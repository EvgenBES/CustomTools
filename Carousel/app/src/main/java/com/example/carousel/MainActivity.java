package com.example.carousel;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mLostLayout;

    private TextView[] mDots;
    private Button mBtnBack, mBtnNext;
    private int currentPage;

    private SlideAdapter slideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mLostLayout = findViewById(R.id.lostLayout);
        mBtnBack = findViewById(R.id.btn_back);
        mBtnNext = findViewById(R.id.btn_next);

        slideAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);



        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(currentPage - 1);
            }
        });

        mBtnBack.animate().alpha(0.0f).setDuration(1);

    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mLostLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTrasparentWhite));

            mLostLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            currentPage = i;

            if (i == 0) {
                mBtnNext.setEnabled(true);
                mBtnBack.setEnabled(false);

                mBtnNext.setText("Next");
                mBtnBack.animate().alpha(0.0f).setDuration(500);

            } else if (i == mDots.length - 1) {
                mBtnNext.setEnabled(false);
                mBtnBack.setEnabled(true);

                mBtnNext.setText("Finish");
                mBtnBack.setText("Back");
            } else {
                mBtnNext.setEnabled(true);
                mBtnBack.setEnabled(true);
                mBtnBack.animate().alpha(1.0f).setDuration(500);

                mBtnNext.setText("Next");
                mBtnBack.setText("Back");
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
