package irishrail.sample.com.irishrailrealtime;

import android.app.Application;

import irishrail.sample.com.irishrailrealtime.data.request.RequestManager;

/**
 * Created by evano on 10/01/2016.
 */
public class RailApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RequestManager.init(this);
    }
}
