package irishrail.sample.com.irishrailrealtime.data.request;

import java.io.UnsupportedEncodingException;

/**
 * Created by evano on 10/01/2016.
 */

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.UnsupportedEncodingException;

public class XmlRequest<T> extends Request<T> {

    private static final Serializer serializer = new Persister();
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/xml; charset=%s", new Object[]{PROTOCOL_CHARSET});
    private Listener<T> mListener;
    private String mRequestBody;
    private Class<T> clazz;

    public XmlRequest(int method, String url,Class<T> clazz, String requestBody, Listener<T> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
        this.mRequestBody = requestBody;
        this.clazz=clazz;
    }

    protected void deliverResponse(T response) {
        this.mListener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response)
    {
        try {

            String data = new String(response.data, PROTOCOL_CHARSET);
            return Response.success(serializer.read(clazz, data),
                    HttpHeaderParser.parseCacheHeaders(response));
        }
        catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
        catch (Exception e) {
            return Response.error(new VolleyError(e.getMessage()));
        }
    }

    /** @deprecated */
    public String getPostBodyContentType() {
        return this.getBodyContentType();
    }

    /** @deprecated */
    public byte[] getPostBody() {
        return this.getBody();
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    public byte[] getBody() {
        try {
            return this.mRequestBody == null?null:this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException var2) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[]{this.mRequestBody, PROTOCOL_CHARSET});
            return null;
        }
    }

}

