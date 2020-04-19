package com.example.detikcomclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.detikcomclone.R;
import com.example.detikcomclone.model.headlines.allsource.All_Source_Item;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_All_Source extends RecyclerView.Adapter<Adapter_All_Source.ViewHolder> {
    private List<All_Source_Item> listAllSource;
    private Context context;

    public Adapter_All_Source(List<All_Source_Item> listAllSource, Context context) {
        this.listAllSource = listAllSource;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_All_Source.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_all_source,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_All_Source.ViewHolder holder, int position) {
        All_Source_Item item  = listAllSource.get(position);
        holder.companyTitle.setText(item.getName());
        holder.descCompany.setText(item.getDescription());
        holder.urlCompany.setText(item.getUrl());
        holder.countrycompany.setText(item.getCountry());
    }

    @Override
    public int getItemCount() {
        return listAllSource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView companyTitle,descCompany,urlCompany,countrycompany;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyTitle = itemView.findViewById(R.id.name_company);
            descCompany = itemView.findViewById(R.id.headlines_company);
            urlCompany = itemView.findViewById(R.id.url_company);
            countrycompany = itemView.findViewById(R.id.country_from);
        }
    }
}
