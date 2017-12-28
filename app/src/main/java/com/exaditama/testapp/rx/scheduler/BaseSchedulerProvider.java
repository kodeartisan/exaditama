package com.exaditama.testapp.rx.scheduler;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

/**
 * Created by kodeartisan on 28/12/17.
 */

public interface BaseSchedulerProvider {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler multi();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
