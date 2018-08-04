package com.test.administrator.coolweather.coolweather;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.CoolWeather.android.R;
import java.io.IOException;
import GSONWeather.Weather;
import Tools.CoolWeatherHttp;
import Tools.Utility;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/7/3.
 */

public class WeatherActivity extends AppCompatActivity {

    private ScrollView weatherLayout;
    private TextView titleCity;
    private TextView cloud;
    private TextView cond;
    private TextView fengxiang;
    private LinearLayout forecastLayout;
    private TextView updateTime;
    private TextView updateTime1;

    private TextView Lat;
    private TextView Lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather1);
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        cloud = (TextView) findViewById(R.id.cloud);
        cond=(TextView) findViewById(R.id.cond);
        fengxiang=(TextView) findViewById(R.id.fengxiang);
        updateTime=(TextView) findViewById(R.id.updateTime);
        updateTime1=(TextView) findViewById(R.id.updateTime1);

        Lat=(TextView) findViewById(R.id.Lat);
        Lon=(TextView) findViewById(R.id.Lon);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather", null);//第一次获取天气为null
        if (weatherString != null) {
            Weather weather = Utility.handleWeatherResponse(weatherString);
            showWeatherInfo(weather);
        } else {//如果获取天气为null
            String weatherId = getIntent().getStringExtra("weather_id");
            Log.i( TAG,weatherId+"weatherId");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }
    }

    static String TAG="WeatherActivity.class";
    public void requestWeather(final String weatherId){
        String weatherUrl = "http://guolin.tech/api/weather?cityid="+weatherId+"&key=5ce71f25312544c6aeb01517dc550ab9";
        CoolWeatherHttp.sendOKHttpRequest(weatherUrl, new Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"获取天气信息失败llllll",Toast.LENGTH_SHORT).show();
                       // swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG,response+"zhuangtaisssssssss");
                final String responseText = response.body().string();

                final Weather weather = Utility.handleWeatherResponse(responseText);
                Log.i(TAG,weather.status+"zhuangtai");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.status)){
                            SharedPreferences.Editor editor=PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather",responseText);
                            editor.apply();
                            //mWeatherId = weatherId;
                            showWeatherInfo(weather);

                        }else if(!("ok".equals(weather.status))){
                            Toast.makeText(WeatherActivity.this,"获取天气信息失败kkkkkk",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(WeatherActivity.this,"获取天气信息失败",Toast.LENGTH_SHORT).show();
                        }
                       // swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });
        //loadBingPic();
    }

    private void showWeatherInfo(Weather weather) {
        String cityName = weather.basic.cityName;
        String updateTimeSet = weather.update.updateTime.split(" ")[1];
      //  String cloudSet = weather.now.cloud+"ji";
      //  String fengxiangSet = weather.now.fengxiang;
        String latSet=weather.basic.Lat;
        String lonSet=weather.basic.Lon;
        titleCity.setText(cityName);
        updateTime.setText(updateTimeSet);
      //  cloud.setText(cloudSet);
       // fengxiang.setText(fengxiangSet);
        Lat.setText(latSet);
        Lon.setText(lonSet);
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString=sharedPreferences.getString("weather",null);
        if(weatherString!=null){
            weather=Utility.handleWeatherResponse(weatherString);
            showWeatherInfo(weather);
        }else{
            String weatherId=getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.VISIBLE);
            requestWeather(weatherId);
        }

    }

}