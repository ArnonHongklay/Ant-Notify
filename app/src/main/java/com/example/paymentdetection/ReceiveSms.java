package com.example.paymentdetection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class ReceiveSms extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "SMS RECEVIED!", Toast.LENGTH_LONG).show();
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {


            RequestQueue requestQueue = Volley.newRequestQueue(context);
            String URL ="http://192.168.1.40/item/add";
            String requestBody = "";

//            Bundle bundle = intent.getExtras();
//            SmsMessage[] msgs = null;
//            String msgFrom;
//            if(bundle != null) {
//                try {
//                    Object[] pdus = (Object[]) bundle.get("pdus");
//                    msgs = new SmsMessage[pdus.length];
//
//                    for(int i = 0; i < msgs.length; i++) {
//                        msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
//                        msgFrom = msgs[i].getOriginatingAddress();
//                        String msgBody = msgs[i].getMessageBody();
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }


//            OkHttpClient client = new OkHttpClient().newBuilder()
//                    .build();
//            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//            RequestBody body = RequestBody.create(mediaType, "name=123123123");
//            Request request = new Request.Builder()
//                    .url("http://192.168.1.40/item/add")
//                    .method("POST", body)
//                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
//                    .build();
//            Response response = client.newCall(request).execute();


            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/x-www-form-urlencoded";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {


                        return "{\"name\":\"xxxxxxx\"}";

                    } catch (UnsupportedEncodingException | JSONException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);


//            // Request a string response from the provided URL.
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, url + "/item/add",
//                    new Response.Listener<String>() {
//
//                        @Override
//                        public void onResponse(String response) {
//                            // Display the first 500 characters of the response string.
//                            Log.e(TAG, "Response is: "+ response);
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Log.e(TAG, "That didn't work!" + error);
//                }
//            });
//
//            Toast.makeText(context, "FROM: " + msgFrom + ", Body: " + msgBody, Toast.LENGTH_SHORT).show();
//// Add the request to the RequestQueue.
//            queue.add(stringRequest);


        }
    }
}
