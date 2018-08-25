package com.home.wifiordatausage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkBroadcastReciver extends BroadcastReceiver {

    private TextView textView;

    public NetworkBroadcastReciver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        Bundle extras = intent.getExtras();

        NetworkInfo info = (NetworkInfo) extras.get("networkInfo");

//        for (String key : extras.keySet()){
////            result += key +":\n" + "( "+ extras.get(key).getClass() +"  )"+ extras.get(key).toString();
////        }

        String result = info.getSubtypeName();

        if (result == null || result.isEmpty())
            result = "Wifi is Connected";
        else {
            result = "Mobile data is Connected";
        }

        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        textView.setText(result);

    }
}
