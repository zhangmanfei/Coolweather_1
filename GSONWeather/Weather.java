package GSONWeather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/6/29.
 */

public class Weather {

    public String status;
    public Basic basic;
    //public Now now;
    public Update update;
    public AQI aqi;
}
