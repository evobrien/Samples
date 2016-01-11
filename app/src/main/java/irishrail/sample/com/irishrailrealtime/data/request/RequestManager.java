package irishrail.sample.com.irishrailrealtime.data.request;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestManager {


private static RequestQueue mRequestQueue;


private RequestManager() {

}

/**
     * @param context application context
*/
public static void init(Context context) {
	//sorts out the SSL validation issue
	mRequestQueue = Volley.newRequestQueue(context);
}

/**
     * @return instance of the queue
     * @throws IllegalStateException if init has not yet been called
*/
public static synchronized RequestQueue getInstance() {
	if (mRequestQueue != null) {
		return mRequestQueue;
	} else {
		throw new IllegalStateException("Not initialized");
	}
}
}