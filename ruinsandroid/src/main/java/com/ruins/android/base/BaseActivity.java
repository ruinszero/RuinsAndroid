package com.ruins.android.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ruins.android.delegate.IActivity;
import com.ruins.android.ui.widget.SweetAlert.SweetAlertDialog;

import butterknife.ButterKnife;

/**
 * BaseActivity
 * @author ruins
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivity{

    protected SweetAlertDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutResource() != 0) {
            setContentView(layoutResource());
            ButterKnife.bind(this);
        }
        progressDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
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
