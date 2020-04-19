package com.example.detikcomclone.ui.category_all_source;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.detikcomclone.R;
import com.example.detikcomclone.adapter.Adapter_All_Source;
import com.example.detikcomclone.api.ApiInterface;
import com.example.detikcomclone.api.Constants;
import com.example.detikcomclone.api.RetrofitApi;
import com.example.detikcomclone.model.headlines.allsource.All_Source_Item;
import com.example.detikcomclone.model.headlines.allsource.All_Source_Respons;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Source_Technology extends Fragment {


    private RecyclerView rv_tech;
    private ApiInterface apiInterface;
    private ProgressBar progressBar;
    private Adapter_All_Source adapter;
    private LinearLayoutManager llm;
    private String category = "technology";
    private List<All_Source_Item> list_tech = new ArrayList<>();


    public Fragment_Source_Technology() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__source__technology, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        progressBar = view.findViewById(R.id.progress_source_tech);
        rv_tech = view.findViewById(R.id.rv_source_tech);
        apiInterface = RetrofitApi.getClient().create(ApiInterface.class);
        llm = new LinearLayoutManager(getContext());
        rv_tech.setLayoutManager(llm);
        loadData();
    }

    private void loadData() {
        apiInterface.getListAllSource(category, Constants.API_KEY).enqueue(new Callback<All_Source_Respons>() {
            @Override
            public void onResponse(Call<All_Source_Respons> call, Response<All_Source_Respons> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    list_tech = response.body().getSources();
                    adapter = new Adapter_All_Source(list_tech,getContext());
                    rv_tech.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getContext(), "Load Data Failed !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<All_Source_Respons> call, Throwable t) {
                Toast.makeText(getContext(), "Error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

