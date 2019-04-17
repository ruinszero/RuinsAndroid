package com.ruins.android.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ruins.android.delegate.IActivity

public abstract class KBaseActivity : AppCompatActivity(), IActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (layoutResource != 0) {
            setContentView(layoutResource)
        }
        init()
    }

    abstract fun init()
}