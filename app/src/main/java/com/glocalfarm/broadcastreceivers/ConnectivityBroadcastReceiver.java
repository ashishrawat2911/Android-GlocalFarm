package com.glocalfarm.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.glocalfarm.utils.Connectivity;


/**
 * Created by ashish on 20/6/18.
 */

public class ConnectivityBroadcastReceiver extends BroadcastReceiver {

    private ConnectivityReceiverListener mConnectivityReceiverListener;

    public ConnectivityBroadcastReceiver(ConnectivityReceiverListener mConnectivityReceiverListener) {
        this.mConnectivityReceiverListener = mConnectivityReceiverListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (mConnectivityReceiverListener != null && Connectivity.isConnected(context))
            mConnectivityReceiverListener.onNetworkConnectionConnected();
    }


    public interface ConnectivityReceiverListener {
        void onNetworkConnectionConnected();
    }

}
