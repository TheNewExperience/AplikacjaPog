package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Data {


    public SerialPort serialPort;
    public boolean serialPortStatus;

    private int iteratorOfTableSeries;

    protected  String dataRead;



    TableView tabela;
    TableColumn temperature;
    TableColumn temperature2;
    TableColumn humidity;
    TableColumn pressure;
    TableColumn windSpeed;


    public ObservableList<Series> seriesElements;


    /*public Data(TableView a, TableColumn b, TableColumn c, TableColumn d, TableColumn e,TableColumn f){
        this.tabela=a;
        this.temperature=b;
        this.temperature2=c;
        this.humidity=d;
        this.pressure=e;
        this.windSpeed=f;

    }*/




    public void openPort() throws SerialPortException {
        serialPortStatus=false;
        String[] namses= SerialPortList.getPortNames();
        //for (String name:namses){

            serialPort = new SerialPort("/dev/tty.usbmodem1413");
            serialPort.openPort();
            System.out.println();
        //}
            serialPort.setParams (115200, 8, 1, 0);

        if(serialPort.isOpened()){
            serialPortStatus=true;

            System.out.println("Status: " + serialPortStatus);
        }
    }


    public String readString() throws SerialPortException {

        //dataRead=serialPort.readString();
        //System.out.println(dataRead);

        String s="1;2;3;4;5";
            return s;
        }

    public List getData() throws SerialPortException {

        iteratorOfTableSeries=0;
        int i=0;
        int numberInList=0;
        System.out.println("ten string w data: "+readString());


            StringTokenizer sT = new StringTokenizer(readString(), ";");


            int catchInt;
            List lista=new ArrayList<>();

            while (sT.hasMoreTokens()) {



                catchInt = Integer.parseInt(sT.nextToken().trim());
                lista.add(numberInList, catchInt);


                numberInList++;
                i++;
                if (i == 5) {
                    System.out.println("Ta lista: "+lista);

                    break;
                }

            }









        return lista;
    }







}
