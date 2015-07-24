package com.example.android.myapplication.util;

import com.squareup.otto.Bus;

/**
 * Created by angebagui on 22/05/15.
 */
public final class BusProvider {
    private static final Bus bus = new Bus();

    public static Bus getInstance(){

        return bus;
    }
    private BusProvider(){

    }
}
