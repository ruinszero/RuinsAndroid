package com.ruins.android.utils;

import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ruins on 2017/7/29.
 * @author  Ruins
 */

public class RxSchedulers {
    /**
     * 封装Rx线程，io线程=>主线程
     * <p>使用方式：用compose操作符调用该方法</p>
     * <p>ApiFactory
     *      .getApi()
     *      .login(userName, passWord)
     *      .compose(RxSchedulers.o_io_main)</p>
     * @param <T>
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> o_io_main() {
        return upstream ->
            upstream.subscribeOn(Schedulers.io())
	            .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 封装Rx线程，io线程=>主线程
     * <p>使用方式：用compose操作符调用该方法</p>
     * <p>ApiFactory
     *      .getApi()
     *      .login(userName, passWord)
     *      .compose(RxSchedulers.f_io_main)</p>
     * @param <T>
     * @return FlowableTransformer
     */
    public static <T> FlowableTransformer<T, T> f_io_main() {
        return upstream ->
            upstream.subscribeOn(Schedulers.io())
	            .observeOn(AndroidSchedulers.mainThread());
    }


}
