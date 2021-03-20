package com.example.testviewmodel.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testviewmodel.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> following;
    public MutableLiveData<ArrayList<UserData>> userLiveData;
    ArrayList<UserData> userDataList;
    public MutableLiveData<Integer> counter;

    public MainViewModel() {
        super();
        counter = new MutableLiveData<>();
        following = new MutableLiveData<>();
        userLiveData = new MutableLiveData<>();
        userDataList = new ArrayList<>();
        counter.setValue(0);
        makeLists();
    }

    public MutableLiveData<ArrayList<UserData>> getUserLiveData(){
        return userLiveData;
    }


    private void makeLists() {
        for (int i = 0; i < 30; i++) {
            userDataList.add(new UserData("randomID " + i, "ABCname " + i));
        }
        userLiveData.setValue(userDataList);
    }

    public void increase() {
        counter.setValue(counter.getValue()+1);
    }

    public void decrease() {
        counter.setValue(counter.getValue()-1);
    }
}
