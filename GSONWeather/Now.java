package GSONWeather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/6/29.
 */

public class Now {
        @SerializedName("cloud")
        public int cloud;
        @SerializedName("cond_code")
        public int cond;
        @SerializedName("wind_dir")
        public String fengxiang;

}
