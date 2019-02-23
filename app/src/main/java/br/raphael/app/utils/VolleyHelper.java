package br.raphael.app.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class VolleyHelper {

    private Context context;
    private static RequestQueue mRequestQueue;

    public VolleyHelper(Context context){
        this.context = context;

        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
            mRequestQueue.start();
        }
    }

    public boolean requestString(@NonNull String url, @NonNull int method, @NonNull final RequestListener onRequestListener){

        if(url == null || onRequestListener == null)
            return false;

        StringRequest stringRequest = new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        onRequestListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        onRequestListener.onError(error.getMessage());
                    }
                });

        mRequestQueue.add(stringRequest);

        return true;
    }

    public boolean requestString(@NonNull String url, @NonNull int method, @NonNull JSONObject params, @NonNull final RequestListener onRequestListener){

        if(url == null || params == null ||onRequestListener == null)
            return false;

        StringRequest stringRequest = new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        onRequestListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        onRequestListener.onError(error.getMessage());
                    }
                });

        mRequestQueue.add(stringRequest);

        return true;
    }

    public interface RequestListener{
        void onSuccess(String response);
        void onError(String error);
    }
}
