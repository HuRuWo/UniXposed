package com.huruwo.hposed.sekiro;


import android.app.Activity;
import android.graphics.Color;
import android.widget.TextView;

import com.blankj.utilcode.util.DeviceUtils;
import com.huruwo.hposed.utils.XSharePrefeUtil;
import com.virjar.sekiro.business.api.SekiroClient;
import com.virjar.sekiro.business.api.interfaze.ActionHandler;
import com.virjar.sekiro.business.api.interfaze.SekiroRequest;
import com.virjar.sekiro.business.api.interfaze.SekiroResponse;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SekiroHelper {

    private static SekiroResponse nowSekiroResponse = null;

    public static void sekiroRegister(Activity activity,ClassLoader classLoader) {
        SekiroClient sekiroClient = new SekiroClient("test", DeviceUtils.getAndroidID(), XSharePrefeUtil.getDataHost(), Integer.valueOf(XSharePrefeUtil.getDataPort()));
        sekiroClient.setupSekiroRequestInitializer((sekiroRequest, handlerRegistry) -> {

            handlerRegistry.registerSekiroHandler(new ActionHandler() {
                @Override
                public String action() {
                    return "test";
                }
                @Override
                public void handleRequest(SekiroRequest sekiroRequest, SekiroResponse sekiroResponse) {
                    sekiroResponse.success("链接成功");
                }
            });

        }).start();
    }


    public static void isOnline(Activity activity, TextView button){
         new Thread(new Runnable() {
             @Override
             public void run() {
                 threadPause(5*1000);
                 while (true){

                     String url = "http://42.192.78.74:5620/business-demo/clientQueue?group=lolm";
                     OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                     Request request = new Request.Builder().get().url(url).build();
                     Response response = null;
                     try {
                         response = okHttpClient.newCall(request).execute();
                         String str = response.body().string();
                         if(str.contains(DeviceUtils.getAndroidID())){
                             activity.runOnUiThread(new Runnable() {
                                 @Override
                                 public void run() {
                                     button.setBackgroundColor(Color.GREEN);
                                     button.setText(DeviceUtils.getAndroidID()+"长链接在线");
                                 }
                             });
                         }else {
                             activity.runOnUiThread(new Runnable() {
                                 @Override
                                 public void run() {
                                     button.setBackgroundColor(Color.RED);
                                     button.setText(DeviceUtils.getAndroidID()+"长链接不在线");
                                 }
                             });
                         }
                     } catch (IOException e) {
                         e.printStackTrace();
                         activity.runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 button.setBackgroundColor(Color.RED);
                                 button.setText("长链接异常"+e.getMessage());
                             }
                         });
                     }
                     threadPause(10*1000);
                 }
             }
         }).start();
    }


    public static void threadPause(long millis) {
        if (millis > 0) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
