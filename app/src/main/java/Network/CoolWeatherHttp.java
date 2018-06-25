package Network;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2018/6/25.
 */

public class CoolWeatherHttp extends HttpURLConnection {

    URL url=new URL("");
    HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

}
