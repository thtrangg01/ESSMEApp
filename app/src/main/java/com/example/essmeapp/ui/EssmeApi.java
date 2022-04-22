package com.example.essmeapp.ui;

import com.example.essmeapp.model.HomePage;
import com.example.essmeapp.model.Question;
import com.example.essmeapp.model.ResearchArea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EssmeApi {

    @GET("homepage")
    Call<HomePage> getHomePage();

    @GET("questions?limit=1000&sort=createdAt&desc=false")
    Call<List<Question>> getQuestions();

    @GET("research_area")
    Call<List<ResearchArea>> getResearchArea();
}
