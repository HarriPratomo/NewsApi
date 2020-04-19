package com.example.detikcomclone.model.headlines.allsource;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class All_Source_Respons {

	@SerializedName("sources")
	private List<All_Source_Item> sources;

	@SerializedName("status")
	private String status;

	public void setSources(List<All_Source_Item> sources){
		this.sources = sources;
	}

	public List<All_Source_Item> getSources(){
		return sources;
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
			"sources = '" + sources + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}