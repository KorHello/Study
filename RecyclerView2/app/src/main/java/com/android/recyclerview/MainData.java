package com.android.recyclerview;

public class MainData { // 리스트 데이터를 넣을곳

    private int iv_profile; // 이미지 뷰
    private String tv_name; // 이름
    private String tv_content; // 내용

    //atr + insert => Constructor 자동생성
    public MainData(int iv_profile, String tv_name, String tv_content) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }

    //atr + insert => Gatter and Setter 자동생성
    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
