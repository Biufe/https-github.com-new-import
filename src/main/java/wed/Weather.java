package wed;

public class Weather {
    private String local;
    private String date;
    private String temp;

    public Weather(String local, String date, String temp) {
        this.local = local;
        this.date = date;
        this.temp = temp;
    }

    public Weather() {
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
