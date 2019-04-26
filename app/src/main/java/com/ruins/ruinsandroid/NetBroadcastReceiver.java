package com.ruins.ruinsandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ruins.android.utils.NetworkUtil;

/**
 * @author jihao
 */
public class NetBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("网络是否连接", NetworkUtil.isAvailable(context) + "");
    }
}
