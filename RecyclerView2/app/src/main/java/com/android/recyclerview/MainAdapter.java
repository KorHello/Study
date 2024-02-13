package com.android.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    private ArrayList<MainData> arrayList; // MainData 가져오기

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile()); // 이미지 생성된애들 가져옴
        holder.tv_name.setText(arrayList.get(position).getTv_name()); // name에 대하여 생성된애를 가져옴
        holder.tv_content.setText(arrayList.get(position).getTv_content()); // content에 대하여 생성된애를 가져옴

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { //클릭 하였을때
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString(); // 현제 이름값 = 이름(오브젝트) String으로 변환된값
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();// 토스트 메세지 (테스트 목적)
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition()); // 포지션값 지우는 메소드
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position); // 포지션값 지우기
            notifyItemRemoved(position); // 리스트 뷰가 삭제된후 새로 갱신할수 있도록 하는 메소드
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile); // 뷰 캐스팅
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name); // 뷰 캐스팅
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content); // 뷰 캐스팅
        }
    }

}
