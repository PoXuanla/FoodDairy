package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentList_One extends Fragment {
    private MyAdapter mAdapter;
    private RecyclerView mRecyclerView;
    ArrayList<String> myDataset = new ArrayList<>();
    ArrayList<String> myDataset2 = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentlist_one, container, false);
        FloatingActionButton fab = view.findViewById(R.id.FAB);
        //fab監聽
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Fab clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), AddFood.class);
                startActivity(intent);

            }
        });
        mAdapter = new MyAdapter(myDataset,myDataset2);
       //測資
            myDataset.add("靜園");
            myDataset.add("靜園");
            myDataset.add("至善");
             myDataset2.add("豬排鐵板燒麵");
             myDataset2.add("水餃八顆");
             myDataset2.add("鍋燒意麵");
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
