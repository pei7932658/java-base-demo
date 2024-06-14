package com.sy.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author:peiliang
 * @Description:
 * @Date: 2021/12/24 16:34
 * @Modified By:peiliang
 * @Version: 1.0
 */
public class HttpUtil {

    public static boolean fileExist(String url) {
        boolean isExist = false;
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setRequestMethod("HEAD");

            Map<String, List<String>> headerMap = conn.getHeaderFields();
            Iterator iterator = headerMap.keySet().iterator();

            String code = "0";
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
//                List<String> values = headerMap.get(key);
//                System.out.println(key + ":" + values.toString());
                if (key == null) {
                    code = headerMap.get(key).get(0).substring(9, 12);
                }
                if ("200".equals(code)) {
                    isExist = true;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isExist;
    }

    public static void main(String[] args) {
        System.out.println(fileExist("http://10.231.50.189:8080/v5/resources/data?uri=weed%3A%2F%2F2833%2C016c683a408eaa7a&contentType=image/jpeg"));
    }
}
