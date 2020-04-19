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

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSports extends Fragment {
    private ProgressBar progressBar;
    private Adapter_Toplines adapter;
    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;
    private List<NewsArticalItem> list_sports = new ArrayList<>();
    private String category = "sports";

    public FragmentSports() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        progressBar = view.findViewById(R.id.progress_sports);
        recyclerView = view.findViewById(R.id.rv_sports);
        apiInterface = RetrofitApi.getClient().create(ApiInterface.class);
        adapter = new Adapter_Toplines(list_sports, getContext());
        llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        loadData();

    }

    private void loadData() {
        apiInterface.getListAllNewsCategory("id", category, Constants.API_KEY).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(GONE);
                    list_sports = response.body().getArticles();
                    adapter = new Adapter_Toplines(list_sports, getContext());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Gagal Memuat Data !", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Kesalahan " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
