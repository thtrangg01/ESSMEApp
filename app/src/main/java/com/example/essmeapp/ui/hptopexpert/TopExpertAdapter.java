package com.example.essmeapp.ui.hptopexpert;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.essmeapp.model.Expert;
import com.example.essmeapp.ui.hptopexpert.ExpertFragment;

import java.util.List;

public class TopExpertAdapter extends FragmentStateAdapter {

    private List<Expert> experts;

    public TopExpertAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Expert expert = experts.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("expert", expert);
        ExpertFragment expertFragment = new ExpertFragment();
        expertFragment.setArguments(bundle);
        return expertFragment;
    }

    @Override
    public int getItemCount() {
        if (experts != null) {
            return experts.size();
        }
        return 0;
    }

    public void submitData(List<Expert> experts) {
        this.experts = experts;
        notifyDataSetChanged();
    }
}
