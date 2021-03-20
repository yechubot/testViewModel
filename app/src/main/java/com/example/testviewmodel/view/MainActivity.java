package com.example.testviewmodel.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.testviewmodel.R;
import com.example.testviewmodel.adapter.UserAdapter;
import com.example.testviewmodel.databinding.ActivityMainBinding;
import com.example.testviewmodel.model.UserData;
import com.example.testviewmodel.viemodel.MainViewModel;

import java.util.ArrayList;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainViewModel mainViewModel;
    UserAdapter userAdapter;
    MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        binding.setLifecycleOwner(this);

        setSupportActionBar(binding.toolbar);
        observeViewModel();
    }

    public void observeViewModel() {
        mainViewModel.counter.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer count) {
                mainViewModel.following.setValue("팔로잉 " + count + " 명");
            }
        });

        mainViewModel.userLiveData.observe(this, new Observer<ArrayList<UserData>>() {
            @Override
            public void onChanged(ArrayList<UserData> userData) {
                userAdapter = new UserAdapter(context, userData);
                binding.recyclerView.setAdapter(userAdapter);
            }
        });
    }


}