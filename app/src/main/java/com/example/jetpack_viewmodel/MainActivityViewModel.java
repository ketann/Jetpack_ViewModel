package com.example.jetpack_viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "Get Number");
        if (randomNumber == null) {
            randomNumber =  new MutableLiveData<>();
            generateNumber();
        }
        return randomNumber;
    }

    public void generateNumber() {
        Log.i(TAG, "Generate a Number");
        Random random = new Random();
        randomNumber.setValue("Number : " + (random.nextInt(100 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "View Model Cleared");
    }
}
