package com.example.zotcard.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zotcard.Adaptors.FragmentStatePager;
import com.example.zotcard.Adaptors.ZoomOutPageTransformer;
import com.example.zotcard.CustomViews.MultiViewPager;
import com.example.zotcard.Helper.SpinnerInteractionListener;
import com.example.zotcard.Model.CurrentMode;
import com.example.zotcard.Model.SetModel;
import com.example.zotcard.R;
import com.jpardogo.android.googleprogressbar.library.GoogleProgressBar;

import java.io.File;
import java.util.ArrayList;

public class CardActivity extends AppCompatActivity {
    /**
     * Main cardAdapter for the {@code mViewPager}
     */
    FragmentStatePager cardAdapter;
    /**
     * Holds all the cards in a page layout.
     */
    private MultiViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        mViewPager = findViewById(R.id.pager);
        loadData();

    }

    private void loadData() {
        cardAdapter = new FragmentStatePager(getSupportFragmentManager(), (FragmentStatePager.EmptyInterface) CardActivity.this);
        mViewPager.setAdapter(cardAdapter);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer()); // Custom animation for page swipes
    }

}

