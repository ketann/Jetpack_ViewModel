package com.example.jetpack_viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFetchNumber = findViewById(R.id.btnFetchNumber);
        TextView mTVRandomNumber =  findViewById(R.id.tvDisplayNumber);

        //MainActivityViewModel viewModel = new MainActivityViewModel();
        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        LiveData<String> randomNumber =  viewModel.getNumber();

        btnFetchNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.generateNumber();
                Log.i(TAG, "Data Updated on UI");
            }
        });

        /*this method observe number change and update on ui */
        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTVRandomNumber.setText(s);
            }
        });
        Log.i(TAG, "Random number set");

    }
}