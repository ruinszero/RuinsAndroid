package com.ruins.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresPermission;

/**
 * 判断网络状态工具类
 * <p>
 *     被 google api 要搞疯了，各种过时的方法，用最新的旧的就不兼容，也是醉了。
 *     但是有一点是肯定的就是不要用 {@link android.net.NetworkInfo#isAvailable} 方法，方法注释中说从 5.0 之后总是返回 true，
 *     但我测试了一下即使在 5.0 以下也是总是返回 true（以注释中提到的开启飞行模式的情况下来测试）。至于国内博客中经常提到的正在
 *     获取 ip 时会返回 false，emmmmm，无话可说，只能无奈的叹一口气。
 * </p>
 * <p>
 *     该工具类不完善，有好多点是不明确，需专门研究进行补全。
 * </p>
 *
 * @author ruinszero
 * @date 16/6/28
 */
public class NetworkUtil {

    private NetworkUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 网络是否可用 => 是否连接上网络(Wi-Fi、以太网、蜂窝网络),并不代表一定能访问互联网。
     * <p>
     *     6.0 及其以上系统，该方法只将 Wi-Fi、以太网、蜂窝网络判断为网络可用，而 VPN、Wi-Fi Aware、Bluetooth、LOWPAN 并没有包含在内.
     * </p>
     *
     * @param context 上下文
     * @return boolean
     */
    @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
    public static boolean isAvailable(Context context) {
        //获取系统网络服务 ConnectivityManager
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Network network = cm.getActiveNetwork();
                if (network == null) {
                    return false;
                }else {
                    NetworkCapabilities networkCapabilities = cm.getNetworkCapabilities(network);
                    // 蜂窝网络、WIFI、以太网
                    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)||
                            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)||
                            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
                }
            }else {
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                return networkInfo.isConnected();
            }
        }
    }
}
