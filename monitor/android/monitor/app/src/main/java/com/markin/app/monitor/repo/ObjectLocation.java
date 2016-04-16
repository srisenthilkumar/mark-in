package com.markin.app.monitor.repo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.markin.app.monitor.model.DeviceLocation;
import com.markin.app.monitor.util.RestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by salagumalai on 16-04-2016.
 */
public class ObjectLocation {

    private static final String TAG = "ObjectLocation";
    private static final String PRODUCT_WEB_SERVICE_URL = "http://192.168.1.11:8080/JSON_RESTful_Service/rest/products";

    public DeviceLocation getLocationByDevice(){
        //setting header to request for a JSON response
        RestClient client = new RestClient();
        String locationJSONStr = client.getHttpResponse();
        Log.d(TAG, "Response: " + locationJSONStr );
        return convertJson(locationJSONStr);
    }

    private DeviceLocation convertJson(String productJSONStr) {
        DeviceLocation location = null;
        if (productJSONStr != null && productJSONStr.length() > 0) {
            try {
                Gson gson = new Gson();
                location =
                        gson.fromJson(productJSONStr, new TypeToken<DeviceLocation>() {
                        }.getType());
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return location;
    }
}
