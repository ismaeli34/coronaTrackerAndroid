package com.example.coronatrackerandroid.ui.geofencing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GeofencingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GeofencingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is geofencing fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}