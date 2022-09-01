package com.r3xcl.musicplayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    private RecyclerView recView;
    private UserAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);

        recView = (RecyclerView) view.findViewById(R.id.recView);
        userAdapter = new UserAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recView.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        recView.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recView.addItemDecoration(itemDecoration);

        return view;
    }

    private List<String> getListUser(){
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++){
            list.add("User name" + i);
        }

        return list;
    }
}