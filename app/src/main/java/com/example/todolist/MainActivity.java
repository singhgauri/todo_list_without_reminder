package com.example.todolist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.Observer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.todolist.ItemViewModel;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private ItemViewModel itemViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        itemViewModel.getAllItems().observe(this,new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {

            }
        });
    }}









