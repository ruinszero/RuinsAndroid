package com.ruins.android.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.ruins.android.utils.NetworkUtil;

/**
 * Created by Ruins on 2017/8/31.
 * @author Ruins
 */

public class BaseApplication extends Application {
    NetworkReceiver networkReceiver;
    /**
     * 网络状态
     */
    private boolean isConnection = false;

    @Override
    public void onCreate() {
        super.onCreate();
        if (networkReceiver == null) {
            networkReceiver = new NetworkReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, filter);
    }


    /**
     * 广播接收器，用来监视网络状态
     */
    class NetworkReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            isConnection = NetworkUtil.isNetworkStatus(context);
        }
    }

    public boolean isConnection() {
        return isConnection;
    }
}

