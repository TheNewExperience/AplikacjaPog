package sample;

import jssc.SerialPortException;

import java.util.ArrayList;
import java.util.List;

public class Threed implements Runnable {






    @Override
    public void run() {

    }

/*
        int iteratorOfIndeksInList;


        int i=0;
        System.out.println();
        Controller cs = new Controller();
        List lista = new ArrayList();
        try {
            Thread.sleep(1000);
            String firstValue=Controller.data.readString();
            Thread.sleep(1000);
        }  catch (SerialPortException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true){
            try {

                Controller.data.readString();


                if(i==0){
                    ++i;
                    Controller.data.getData();
                    Thread.sleep(1000);

                }else {

                    ++i;

                    Controller.data.getData();
                    Thread.sleep(1000);




                }

                //data.readString();
            } catch (SerialPortException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }*/
}
