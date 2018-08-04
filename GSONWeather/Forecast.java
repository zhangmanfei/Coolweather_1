package GSONWeather;


import com.google.gson.annotations.SerializedName;


/**
 * Created by Administrator on 2018/6/29.
 */

public class Forecast {
   @SerializedName("date")
    public String date;
   @SerializedName("cond")
    public Cond cond;
    public class Cond{
      @SerializedName("txt_d")
        public String info;
    }
    @SerializedName("tmp")
    public Tmp tmp;
    public class Tmp{
        public String max;
        public String min;
    }


}
