package sample;


import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import jssc.SerialPortException;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller  {


    @FXML
    protected TableView<Series> tabela;


    @FXML
    private Label label1;
    @FXML
    protected TableColumn<Series, Integer> temperature;
    @FXML
    protected TableColumn<Series,Integer> temperature2;
    @FXML
    protected TableColumn<Series,Integer> humidity;
    @FXML
    protected TableColumn<Series,Integer> pressure;
    @FXML
    TableColumn<Series,Integer> windSpeed;
    @FXML
    protected  LineChart<Number,Number> chartOfData;
    @FXML
    private NumberAxis xAxis;
    private NumberAxis yAxis;

    public static Data data = new Data();


    private grafic graf;

    @FXML
    public void openPortA() throws SerialPortException {
        //Data data = new Data();
        data.openPort();
        System.out.println("status "+data.serialPortStatus);
    }
    @FXML
    public void getData() throws SerialPortException {

        grafic graf = new grafic(tabela,temperature,temperature2,humidity,pressure,windSpeed,chartOfData,xAxis, label1);

        Thread th = new Thread(graf);

        th.setDaemon(true);
        th.start();



    }

    public void runTable () {







    }
}





