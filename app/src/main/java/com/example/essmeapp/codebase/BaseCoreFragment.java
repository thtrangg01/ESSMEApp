package com.example.essmeapp.codebase;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseCoreFragment extends Fragment implements View.OnClickListener, IBaseView {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(this.getClass().getSimpleName(), "onAttach()...");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(this.getClass().getSimpleName(), "onCreate()...");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Log.d(this.getClass().getSimpleName(), "onCreateView()...");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(this.getClass().getSimpleName(), "onViewCreated()...");
        initializeViews();
        initializeComponents();
        initializeEvents();
        initializeData();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(this.getClass().getSimpleName(), "onStart()...");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(this.getClass().getSimpleName(), "onResume()...");
    }

    @Override
    public void onPause() {
        Log.d(this.getClass().getSimpleName(), "onPause()...");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(this.getClass().getSimpleName(), "onStop()...");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(this.getClass().getSimpleName(), "onDestroyView()...");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(this.getClass().getSimpleName(), "onDestroy()...");
        super.onDestroy();
    }
}
