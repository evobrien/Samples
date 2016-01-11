package irishrail.sample.com.irishrailrealtime.data.request;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import irishrail.sample.com.irishrailrealtime.data.model.StationDataItems;

/**
 * Created by evano on 10/01/2016.
 */
public class GetStationDataRequest extends BaseRequest<StationDataItems> {

    protected String url="http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByNameXML?StationDesc=";
    protected String mStationName;
    public GetStationDataRequest(Context ctx,
                        Response.Listener<StationDataItems> responseListener,
                        Response.ErrorListener errorListener,String stationName) {
        super(ctx, responseListener, errorListener);
        mStationName=stationName;
    }

    @Override
    public void execute() {

        XmlRequest request=new XmlRequest(
                Request.Method.GET,
                getUrl(),
                StationDataItems.class,
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
        try {
            return this.url + URLEncoder.encode(this.mStationName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
