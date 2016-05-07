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

    public DeviceLocation getLocationByDevice(){
        //setting header to request for a JSON response
        RestClient client = new RestClient();
        String locationJSONStr = client.getHttpResponse();
        Log.d(TAG, "Response: " + locationJSONStr );
        return convertJson(locationJSONStr);
    }

    private DeviceLocation convertJson(String productJSONStr) {
        List<DeviceLocation> location = new ArrayList<DeviceLocation>();
        if (productJSONStr != null && productJSONStr.length() > 0) {
            try {
                Gson gson = new Gson();
                location =
                        gson.fromJson(productJSONStr, new TypeToken<List<DeviceLocation>>() {
                        }.getType());
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if(location.size() > 0)
        {
            return location.get(0);
        }
        else {
            return null;
        }
    }
}
