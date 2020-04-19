package com.example.detikcomclone.model.headlines;

import java.util.List;

import com.example.detikcomclone.model.headlines.NewsArticalItem;
import com.google.gson.annotations.SerializedName;

public class NewsResponse {

	@SerializedName("totalResults")
	private int totalResults;

	@SerializedName("articles")
	private List<NewsArticalItem> articles;

	@SerializedName("status")
	private String status;

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setArticles(List<NewsArticalItem> articles){
		this.articles = articles;
	}

	public List<NewsArticalItem> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"totalResults = '" + totalResults + '\'' + 
			",articles = '" + articles + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}