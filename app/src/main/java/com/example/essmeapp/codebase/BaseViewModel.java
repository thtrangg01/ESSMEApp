package com.example.essmeapp.codebase;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    @Override
    protected void onCleared() {
        Log.d(this.getClass().getSimpleName(), "onCleared()...");
        super.onCleared();
    }
}
