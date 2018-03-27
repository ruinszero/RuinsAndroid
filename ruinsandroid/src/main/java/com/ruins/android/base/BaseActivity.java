package com.ruins.android.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ruins.android.delegate.IActivity;
import butterknife.ButterKnife;

/**
 * BaseActivity
 * @author ruins
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutResource() != 0) {
            setContentView(layoutResource());
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
