package com.ankroid.mynewsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sportsFragment extends Fragment {

    String api ="8b040c8ccf4f412fb3b413284fcafe1b";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";

    private String category = "sports";

    private RecyclerView recyclerViewofsports;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportsfragment,null);
        recyclerViewofsports = v.findViewById(R.id.recycleviewofsports);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new Adapter(getContext(),modelClassArrayList);
        recyclerViewofsports.setAdapter(adapter);

        findNews();
        return  v;
    }

    private void findNews(){
        ApiUtility.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<NewsTele>() {
            @Override
            public void onResponse(Call<NewsTele> call, Response<NewsTele> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsTele> call, Throwable t) {

            }
        });
    }
}
