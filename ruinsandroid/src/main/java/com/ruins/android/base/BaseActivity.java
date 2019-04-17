package com.ruins.android.base;

import android.os.Bundle;

import com.ruins.android.delegate.IActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * BaseActivity
 * @author ruins
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResource() != 0) {
            setContentView(getLayoutResource());
            ButterKnife.bind(this);
        }
        init();
    }

    /**
     * 初始化操作
     */
    protected abstract void init();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
