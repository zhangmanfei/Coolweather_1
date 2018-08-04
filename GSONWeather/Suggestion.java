package GSONWeather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/6/29.
 */

public class Suggestion {
    @SerializedName("comf")
    public Comf comf;
    public class Comf{
        @SerializedName("txt")
        public String info;
    }
    @SerializedName("cw")
    public Cw cw;
    public class Cw{
        @SerializedName("txt")
        public String info;
    }
    @SerializedName("sport")
    public Sport sport;
    public class Sport{
        @SerializedName("txt")
        public String info;
    }
}
