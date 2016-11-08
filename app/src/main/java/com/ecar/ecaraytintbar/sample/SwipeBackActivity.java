package com.ecar.ecaraytintbar.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ecar.mylibrary.StatusBarUtil;
import com.r0adkll.slidr.Slidr;
import com.readystatesoftware.systembartint.sample.R;

import java.util.Random;

/**
 * Created by Jaeger on 2016/10/15.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */

public class SwipeBackActivity extends BaseActivity {
    private Button mBtnChangeColor;
    private int mColor = Color.GRAY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置右滑动返回
        Slidr.attach(this);
        setContentView(R.layout.swipe_back_activity);
        mBtnChangeColor = (Button) findViewById(R.id.btn_change_color);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mBtnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                mColor = 0xff000000 | random.nextInt(0xffffff);
                StatusBarUtil.setColorForSwipeBack(SwipeBackActivity.this, mColor, 38);
            }
        });
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColorForSwipeBack(this, mColor, 38);
    }
}
