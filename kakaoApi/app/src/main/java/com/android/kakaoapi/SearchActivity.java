package com.android.kakaoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new BridgeInterface(), "Android");
        webView.setWebViewClient(new WebViewClient() { // 콜백 형태
            @Override
            public void onPageFinished(WebView view, String url) { //페이지 로딩 끝났을때
                webView.loadUrl("javascript:sample2_execDaumPostcode();"); // 안드 => 자바 스크립트 전달
            }
        });

        //최초 웹뷰 로드
        webView.loadUrl("https://kakaoapi-4f3f7.web.app");

        //타이밍 적으로 호출시 로드 URL이 호출되며 페이징이 모두 호출완료시 setWebViewClient호출
        // 그리고 자바스크립트에서 전달 완료시 BridgeInterface 전달
    }

    private class BridgeInterface { // 자바 스크립트 => 안드 전달
        @JavascriptInterface //자바 스크립트 인터페이스 명시
        public void processDATA(String data) {
            // kakao 주소 검색 API의 결과 값이 브릿지 통로를 통해 전달 받는다
            Intent intent = new Intent();
            intent.putExtra("data", data); // 메인 액티비티 전달
            setResult(RESULT_OK,intent);
            finish(); //메인 액티비티에 전달후 종료

        }

    }
}