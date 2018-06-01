package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jssc.SerialPortException;

import javax.sound.sampled.Line;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class grafic extends Task implements Runnable {


    public static Data data = new Data();


    public int iteratorOfTableSeries;




    protected TableView<Series> tabela;



    protected TableColumn<Series, Integer> temperature;

    protected TableColumn<Series,Integer> temperature2;

    protected TableColumn<Series,Integer> humidity;

    protected TableColumn<Series,Integer> pressure;

    protected TableColumn<Series,Integer> windSpeed;

    private Label label1;

    private LineChart<Number,Number> chart;

    private NumberAxis xAxis;

    public List listData;

    private ObservableList<Series>  dane;



    public grafic(TableView table, TableColumn temperature, TableColumn temperature2, TableColumn humidity, TableColumn pressure, TableColumn windSpeed, LineChart chart, NumberAxis xAxis, Label label1){

        this.tabela=table;
        this.temperature=temperature;
        this.temperature2=temperature2;
        this.humidity=humidity;
        this.pressure=pressure;
        this.windSpeed=windSpeed;
        this.chart=chart;
        this.xAxis=xAxis;
        this.label1 = label1;

    }

    public void openPort() throws SerialPortException {
        data.openPort();
    }



    @Override
    public void run() {





            int iteratorOfIndeksInList;


            int i=0;
            System.out.println();

            listData = new ArrayList();
            try {
                Thread.sleep(1000);
                String firstValue=data.readString();
                Thread.sleep(1000);
            }  catch (SerialPortException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true){
                try {

                    data.readString();


                    if(i==0){
                        ++i;

                        data.getData();


                        Thread.sleep(1000);

                    }else {

                        ++i;
                        data.getData();
                       listData=data.getData();


                        int finalI = i;


                        int finalI1 = i;
                        Runnable task = () -> {
                            //cos();
                            //System.out.println("cos");
                            label1.textProperty().setValue(Integer.toString(finalI1));
                            //cos();
                           tabela();
                        };
                        Platform.runLater(task);


                        Thread.sleep(1000);




                    }

                    //data.readString();
                } catch (SerialPortException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }









    public void tabela(){


        /*for(Series s:dane){
            System.out.println("seria: "+dane.);
        }*/

        iteratorOfTableSeries=0;

        dane = FXCollections.observableArrayList(

                new Series((int)listData.get(iteratorOfTableSeries),(int) listData.get(iteratorOfTableSeries+1),(int) listData.get(iteratorOfTableSeries+2),(int) listData.get(iteratorOfTableSeries+3),(int) listData.get(iteratorOfTableSeries+4))
        );


        for (int j=0; j<dane.size(); j++) {
            System.out.println("seria: "+dane.get(j).getHumidity());
        }

        iteratorOfTableSeries += 5;


        int j=0;
        j++;
        temperature.setCellValueFactory(
                new PropertyValueFactory<Series, Integer>("temperature")
        );
        humidity.setCellValueFactory(
                new PropertyValueFactory<Series, Integer>("humidity")
        );
        temperature2.setCellValueFactory(
                new PropertyValueFactory<Series, Integer>("temperature2"));
        pressure.setCellValueFactory(
                new PropertyValueFactory<Series, Integer>("pressure")
        );
        windSpeed.setCellValueFactory(
                new PropertyValueFactory<Series, Integer>("windSpeed"));
        tabela.itemsProperty().setValue(dane);

    }

    @Override
    protected Object call() throws Exception {





        return null;
    }
}
