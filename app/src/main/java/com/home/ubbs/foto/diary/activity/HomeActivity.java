package com.home.ubbs.foto.diary.activity;

import android.os.Bundle;

import com.home.ubbs.foto.diary.R;

/**
 * Created by udyatbhanu-mac on 5/11/16.
 */
public class HomeActivity extends FotoDiaryBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setHome(true);

    }
}
