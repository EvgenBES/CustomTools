package com.example.detalinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.Window;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getWindow().setSharedElementEnterTransition(enterTransition());
    }

    //Speed transition
    private Transition enterTransition() {
        ChangeBounds bounds = new ChangeBounds();
        bounds.setDuration(600);

        return bounds;
    }
}
