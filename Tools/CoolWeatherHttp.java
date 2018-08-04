package Tools;


import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2018/6/25.
 */

public class CoolWeatherHttp {

    public static void sendOKHttpRequest(String address, Callback callBack){

        OkHttpClient okhttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(address)
                .build();
        okhttpClient.newCall(request).enqueue(callBack);
    }

}