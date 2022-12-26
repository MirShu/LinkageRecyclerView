package com.example.linkagerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;


import com.example.linkagerecyclerview.recycler.RecyclerAdapter;
import com.example.linkagerecyclerview.recycler.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView RecyclerView1;
    RecyclerView RecyclerView2;
    private RecyclerAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView1 = findViewById(R.id.RecyclerView1);
        RecyclerView2 = findViewById(R.id.RecyclerView2);
        this.bindRecycleView();
    }


    private void bindRecycleView() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView1.setLayoutManager(linearLayoutManager);
        this.adapter = new RecyclerAdapter<String>(this, list,
                R.layout.item_address) {
            @Override
            public void convert(RecyclerViewHolder helper, String item, int position) {
                TextView tv_item = helper.getView(R.id.tv_item);
                tv_item.setText("" + position);
            }
        };
        RecyclerView1.setAdapter(adapter);





        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView2.setLayoutManager(linearLayoutManager2);
        this.adapter = new RecyclerAdapter<String>(this, list,
                R.layout.item_address) {
            @Override
            public void convert(RecyclerViewHolder helper, String item, int position) {
                TextView tv_item = helper.getView(R.id.tv_item);
                tv_item.setText("" + position);
            }
        };
        RecyclerView2.setAdapter(adapter);


        RecyclerView1.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (recyclerView.getScrollState() !=RecyclerView.SCROLL_STATE_IDLE) {

                    RecyclerView2.scrollBy(dy, dx);

                }

            }

        });

    }

}