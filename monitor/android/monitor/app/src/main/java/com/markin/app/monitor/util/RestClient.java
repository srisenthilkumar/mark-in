package com.markin.app.monitor.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by salagumalai on 17-04-2016.
 */
public class RestClient {

    private static final String TAG = "AndroidNetworkUtility";

    public boolean isConnected(Context ctx) {
        boolean flag = false;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            flag = true;
        }
        return flag;
    }

    public String getHttpResponse() {
        StringBuilder sb = new StringBuilder();
        InputStream in = null;

        try {

            URL  url = new URL("http://10.0.2.2:8080/locations/device");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setAllowUserInteraction(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("GET");
            connection.connect();

            int resCode = connection.getResponseCode();
            Log.d(TAG, "Status code: " + resCode);
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = connection.getInputStream();
            }

            BufferedReader reader =new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String data="";

            while ((data = reader.readLine()) != null){
                sb.append(data);
            }

            Log.d(TAG, "response: " + sb.toString());

        }  catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            Log.d(TAG, "Status code: " + e.getMessage());
            e.printStackTrace();
        }

        return sb.toString();
    }
}
