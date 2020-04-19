package com.example.detikcomclone.ui.headline;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.detikcomclone.R;
import com.example.detikcomclone.adapter.Adapter_Toplines;
import com.example.detikcomclone.api.ApiInterface;
import com.example.detikcomclone.api.Constants;
import com.example.detikcomclone.api.RetrofitApi;
import com.example.detikcomclone.model.headlines.NewsArticalItem;
import com.example.detikcomclone.model.headlines.NewsResponse;

import java.util.ArrayList;
import java.util.List;

public class HeadlineFragment extends Fragment {
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private Adapter_Toplines adapter;
    private ApiInterface apiInterface;
    private List<NewsArticalItem> listArticle = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_headlines, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @SuppressLint("ResourceAsColor")
    private void init(View view) {
         progressBar = view.findViewById(R.id.progress);
        swipeRefreshLayout = view.findViewById(R.id.sw_all_news);

        recyclerView = view.findViewById(R.id.rv_all_data);
        apiInterface = RetrofitApi.getClient().create(ApiInterface.class);
        adapter = new Adapter_Toplines(listArticle, getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimaryDark,R.color.colorPrimary);
        loadingData();
        refreshData();
    }

    private void refreshData() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(true);
                        loadingData();
                    }
                }, 5000);
            }
        });
    }

    private void loadingData() {

        apiInterface.getHeadLines("id", Constants.API_KEY).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    listArticle = response.body().getArticles();
                    recyclerView.setAdapter(new Adapter_Toplines(listArticle, getContext()));
                    adapter.notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                } else {
                    Toast.makeText(getContext(), "Gagal load data..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
