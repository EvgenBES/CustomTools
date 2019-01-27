package com.example.detalinfo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private ImageView mImageView;
    private TextView mTextName, mTextDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = findViewById(R.id.relativeLayout);
        mImageView = findViewById(R.id.imageView);
        mTextName = findViewById(R.id.textView1);
        mTextDesc = findViewById(R.id.textView2);

        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(mImageView, "imageTransition");
                pairs[1] = new Pair<View, String>(mTextName, "nameTransition");
                pairs[2] = new Pair<View, String>(mTextDesc, "detailTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(intent, options.toBundle());

            }
        });
    }
}
