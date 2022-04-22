package com.example.essmeapp.ui.homepage;

import android.view.View;

import com.example.essmeapp.codebase.BaseFragment;
import com.example.essmeapp.databinding.FragmentHomePageBinding;
import com.example.essmeapp.model.FieldListItem;
import com.example.essmeapp.model.ResearchArea;
import com.example.essmeapp.ui.hpfields.FieldViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageFragment extends BaseFragment<FragmentHomePageBinding, HomePageViewModel> {

    private FieldViewPagerAdapter fieldAdapter;

    public HomePageFragment() {
        super(FragmentHomePageBinding::inflate);
    }

    @Override
    protected Class<HomePageViewModel> getViewModel() {
        return HomePageViewModel.class;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        fieldAdapter = new FieldViewPagerAdapter(requireActivity());
        binding.lstField.setAdapter(fieldAdapter);
    }

    @Override
    public void initializeEvents() {

    }

    @Override
    public void initializeData() {
        viewModel.getResearchArea.enqueue(new Callback<List<ResearchArea>>() {
            @Override
            public void onResponse(Call<List<ResearchArea>> call, Response<List<ResearchArea>> response) {
                List<ResearchArea> fields = response.body();
                ArrayList<FieldListItem> fieldData = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    FieldListItem fieldListItem = new FieldListItem();
                    fieldListItem.setFields(fields.subList(4 * i, 4 * (i + 1)));
                    fieldData.add(0, fieldListItem);
                }
                fieldAdapter.submitData(fieldData);
            }

            @Override
            public void onFailure(Call<List<ResearchArea>> call, Throwable t) {

            }
        });
    }
}
