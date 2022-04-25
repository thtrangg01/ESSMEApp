package com.example.essmeapp.ui.homepage;

import com.example.essmeapp.codebase.BaseViewModel;
import com.example.essmeapp.model.HomePage;
import com.example.essmeapp.model.ResearchArea;
import com.example.essmeapp.service.ApiClient;
import com.example.essmeapp.service.EssmeApi;

import java.util.List;

import retrofit2.Call;

public class HomePageViewModel extends BaseViewModel {
    EssmeApi essmeApi = ApiClient.getAPI();

    Call<List<ResearchArea>> getResearchArea = essmeApi.getResearchArea();
    Call<HomePage> getHomePage = ApiClient.getAPI().getHomePage();

}
