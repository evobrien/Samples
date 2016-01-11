package irishrail.sample.com.irishrailrealtime.data.request;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;

import irishrail.sample.com.irishrailrealtime.data.model.Stations;

/**
 * Created by evano on 10/01/2016.
 */
public class GetStationsRequest extends BaseRequest<Stations> {

    protected String url="http://api.irishrail.ie/realtime/realtime.asmx/getAllStationsXML";

    public GetStationsRequest(Context ctx,
                                 Response.Listener<Stations> responseListener,
                                 Response.ErrorListener errorListener) {
        super(ctx, responseListener, errorListener);
    }

    @Override
    public void execute() {

        XmlRequest request=new XmlRequest(
                Request.Method.GET,
                getUrl(),
                Stations.class,
                null,
                this.mResponseListener,
                this.mErrorListener);


        request.setTag(this.getClass().getName());
        request.setShouldCache(false);
        request.setRetryPolicy(new DefaultRetryPolicy(DEFAULT_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestManager.getInstance().add(request);

    }

    private String getUrl(){
        return this.url;
    }
}
