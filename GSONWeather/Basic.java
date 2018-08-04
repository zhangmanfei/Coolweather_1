package GSONWeather;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Administrator on 2018/6/29.
 */

public class Basic {

    @SerializedName("cid")
    public String weatherId;
    @SerializedName("location")
    public String cityName;
    @SerializedName("lat")
    public String Lat;
    @SerializedName("lon")
    public String Lon;
    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }


}
