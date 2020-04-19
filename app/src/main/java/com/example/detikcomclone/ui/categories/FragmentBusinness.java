package com.example.detikcomclone.ui.categories;

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
import com.example.detikcomclone.adapter.Adapter_Toplines;
import com.example.detikcomclone.api.ApiInterface;
import com.example.detikcomclone.api.Constants;
import com.example.detikcomclone.api.RetrofitApi;
import com.example.detikcomclone.model.headlines.NewsArticalItem;
import com.example.detikcomclone.model.headlines.NewsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBusinness extends Fragment {

    private ProgressBar progressBar;
    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private Adapter_Toplines adapter;
    private List<NewsArticalItem> listCategory = new ArrayList<>();
    private String category = "business";



    public FragmentBusinness() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_businnes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress_businnes);
        apiInterface = RetrofitApi.getClient().create(ApiInterface.class);
        adapter = new Adapter_Toplines(listCategory,getContext());
        recyclerView = view.findViewById(R.id.rv_businnes);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        loadData();
    }

    private void loadData() {
        apiInterface.getListAllNewsCategory("id",category, Constants.API_KEY).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    listCategory  = response.body().getArticles();
                    recyclerView.setAdapter(new Adapter_Toplines(listCategory,getContext()));
                    adapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getContext(), "Gagal Muat Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Tidak ada jaringan Internet !", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
