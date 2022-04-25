package com.example.essmeapp.service;

import com.example.essmeapp.model.ExpertResponse;
import com.example.essmeapp.model.Fields;
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

    @GET("experts/field")
    Call<List<Fields>> getFields();

    @GET("experts/search?what=khoa&radius=5&page=0&size=100&asc=true")
    Call<ExpertResponse> getExperts();

    @GET("research_area")
    Call<List<ResearchArea>> getResearchArea();
}
