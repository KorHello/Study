package com.android.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FragmentManager fragmentManager;
    private MapFragment mapFragment; //앱의 Map 구성 요소.이 파편은 지도를 가장 간단하게 넣을 수 있는 방법이다.신청서지도 주변의 포장지로 필요한 생명을 자동으로 처리한다 (구글 사이트 설명 번역)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        LatLng location = new LatLng(37.2757016, 127.1165512); //위도 경도 (구로디지털단지역 위치)
        MarkerOptions markerOptions = new MarkerOptions(); // 마커 옵션 생성
        markerOptions.title("기흥역"); // 명칭 이름
        markerOptions.snippet("우리회사 근처"); // 세부적인 콘텐트 내용
        markerOptions.position(location); // 위치
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16)); // 구글 카메라 옵션
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 16)); // 구글 카메라 옵션

    }
}