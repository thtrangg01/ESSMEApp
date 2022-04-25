package com.example.essmeapp.ui.hpfields;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.essmeapp.model.FieldListItem;
import com.google.gson.Gson;

import java.util.List;

public class FieldViewPagerAdapter extends FragmentStateAdapter {
    private List<FieldListItem> fieldListItems;

    public FieldViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        FieldListItem item = fieldListItems.get(position);
        Bundle bundle = new Bundle();
        Gson gson = new Gson();
        String fieldJson = gson.toJson(item.getFields());
        bundle.putString("list_fields", fieldJson);
        FieldsFragment fieldsFragment = new FieldsFragment();
        fieldsFragment.setArguments(bundle);
        return fieldsFragment;
    }

    @Override
    public int getItemCount() {
        if (fieldListItems != null) {
            return fieldListItems.size();
        }
        return 0;
    }

    public void submitData(List<FieldListItem> items) {
        this.fieldListItems = items;
        notifyDataSetChanged();
    }
}
