package com.example.essmeapp.ui.homepage;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.navigation.Navigation;

import com.example.essmeapp.R;
import com.example.essmeapp.codebase.BaseFragment;
import com.example.essmeapp.databinding.FragmentHomePageBinding;
import com.example.essmeapp.model.Expert;
import com.example.essmeapp.model.Fields;
import com.example.essmeapp.model.HomePage;
import com.example.essmeapp.ui.hpfields.FieldViewPagerAdapter;
import com.example.essmeapp.ui.hptopexpert.TopExpertAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageFragment extends BaseFragment<FragmentHomePageBinding, HomePageViewModel> {

    public final String Tag = this.getClass().getSimpleName();

    private TopExpertAdapter topExpertAdapter;
    private FieldViewPagerAdapter fieldAdapter;

    public HomePageFragment() {
        super(FragmentHomePageBinding::inflate);
    }

    @Override
    protected Class<HomePageViewModel> getViewModel() {
        return HomePageViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // binding.txtTitle.setText(viewModel.mName);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        topExpertAdapter = new TopExpertAdapter(requireActivity());
        binding.lstExpert.setAdapter(topExpertAdapter);

        fieldAdapter = new FieldViewPagerAdapter(requireActivity());
        binding.lstField.setAdapter(fieldAdapter);
    }

    @Override
    public void initializeEvents() {
        binding.txtFQAs.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(R.id.action_homePageFragment_to_FQAsFragment));

        binding.txtExpert.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_homePageFragment_to_expertFragment);
        });
    }

    @Override
    public void initializeData() {
        viewModel.getHomePage.clone().enqueue(new Callback<HomePage>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<HomePage> call, Response<HomePage> response) {
                HomePage homePage = response.body();

                if (homePage == null) return;

                List<Expert> experts = homePage.getTopExperts();
                topExpertAdapter.submitData(experts);

                List<Fields> fields = homePage.getFields();
                fieldAdapter.submitData(viewModel.adjustField4View(fields));
            }

            @Override
            public void onFailure(Call<HomePage> call, Throwable t) {
                Log.d(Tag, Tag);
            }
        });
    }
}
