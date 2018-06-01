package sample;

public class Series {

    private int temperature;
    private int temperature2;
    private int humidity;
    private int pressure;
    private int windspeed;

    public Series(int temperature,int temperature2,int humidity,int pressure,int windspeed ){

        this.temperature=temperature;
        this.temperature2=temperature2;
        this.humidity=humidity;
        this.pressure=pressure;
        this.windspeed=windspeed;
    }

    public int getTemperature(){
        return temperature;
    }
    public int getTemperature2(){
        return temperature2;
    }
    public int getHumidity(){
        return humidity;
    }
    public int getPressure(){
        return pressure;
    }

    public int getWindspeed() {
        return windspeed;
    }
}
