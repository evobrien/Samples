package irishrail.sample.com.irishrailrealtime.data.request;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;


public abstract class BaseRequest<T> {
	
	protected Context mCtx;
	protected Listener<T> mResponseListener;
	protected ErrorListener mErrorListener;
	protected RequestQueue mQueue;

	public final static int DEFAULT_TIMEOUT = 15000;
	public final static int EXTENDED_TIMEOUT = 25000;
	
	public BaseRequest(Context ctx,
					   Listener<T> responseListener,
					   ErrorListener errorListener
	){
		mCtx=ctx;
		mResponseListener=responseListener;
		mErrorListener=errorListener;

	}
	
	public abstract void execute();
	
	protected Context getContext(){
		return mCtx;
	}
}