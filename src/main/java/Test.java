import wed.Weather;
import wed.weatherUtil;

public class Test {
    public static void main(String[] args) {

//        Almanac almanac=AlmanacUtil.getAlmanac();
//        System.out.println("����ʱ�䣺"+almanac.getSolar());
//        System.out.println("ũ��ʱ�䣺"+almanac.getLunar());
//        System.out.println("��ɵ�֧��"+almanac.getChineseAra());
//        System.out.println("�ˣ�"+almanac.getShould());
//        System.out.println("�ɣ�"+almanac.getAvoid());

        Weather weather = weatherUtil.getWeather();
        System.out.println(weather.getTemp());
        System.out.println(weather.getLocal());
        System.out.println(weather.getDate());

    }


}
