package wed;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class weatherUtil {

    private weatherUtil(){

    }

    public static Weather getWeather(){
        String url = "http://www.weather.com.cn/weather/101190101.shtml";
        String html = pickdata(url);
        Weather weather = analyzeHTMLByString(html);

        return weather;
    }


    /*
     * 使用jsoup解析网页信息
     */
    private static Weather analyzeHTMLByString(String html) {
        String local=" ",date= " ",temp = " ";
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("t clearfix");
//        local = cityName.select("h1").text();
        Elements city = document.getElementsByClass("sky skyid lv3 on");
        local = city.select("h1").text();

//        Element temp1 = document.getElementById("temp");
//        temp = temp1.text();
        date  = city.select("p.wea").text();//0
        temp  = city.select("p.tem").text();

//        Elements temp2 = document.select("[class=yq-weather]");
//        temp = temp2.get(0).text();

//        Element updateTime = document.getElementById("updataTime");
//        date = updateTime.text();

        Weather weather = new Weather(local,date,temp);
        return weather;
    }


    /*
     * 爬取网页信息
     */
    private static String pickdata(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if(entity != null){
                    return EntityUtils.toString(entity,"utf8");
                }
            }finally{
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Weather weather = weatherUtil.getWeather();
        System.out.println(weather.getTemp());
        System.out.println(weather.getLocal());
        System.out.println(weather.getDate());
    }
}
