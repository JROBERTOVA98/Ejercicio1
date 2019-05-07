package sample;

import com.sun.org.apache.xpath.internal.operations.Mult;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.Parent;
import java.lang.Integer;
import java.lang.String;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Scanner;



public class Main extends Application {


    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);

        //Boton para el inicio del programa y que muestre los dos numeros aleatorios
        Button btnInicio = new Button("Inicio");
        //Colocar arriba del lblNum1
        root.add(btnInicio,0,0);

        //Label para los minutos en pantalla
        TextField txtMin = new TextField();
        root.add(txtMin,1,0);

        //Label para los segundos en pantalla
        TextField txtSeg = new TextField();
        root.add(txtSeg,2,0);


        //Etiqueta para el numero 1
        Label lblNum1 = new Label ("Numero 1: ");
        //Determinar fuente y tamaño de la etiqueta
        lblNum1.setFont(Font.font("Arial",16));
        //Determinar el color de la etiqueta
        lblNum1.setTextFill(Color.BLACK);
        //poner en la celda(0,1)
        root.add(lblNum1,0,2);

        //TextField para numero1
        TextField fldNum1 = new TextField();
        //Colocar en la celda (1,1)
        root.add(fldNum1,1,2);
        fldNum1.setEditable(false);

        //Etiqueta para el numero 2
        Label lblNum2 = new Label ("Numero 2: ");
        //Determinar fuente y tamaño de la etiqueta
        lblNum2.setFont(Font.font("Arial",16));
        //Determinar el color de la etiqueta
        lblNum2.setTextFill(Color.DARKRED);
        //poner en la celda(0,2)
        root.add(lblNum2,0,3);

        //TextField para numero2
        TextField fldNum2 = new TextField();
        //Colocar en la celda (1,2)
        root.add(fldNum2,1,3);
        fldNum2.setEditable(false);

        //Creacion de un boton
        Button btnResult = new Button("Comprobar");
        //Colocar debajo del lblNum3
        root.add(btnResult,1,4);

        //TextField para escribir resultado en pantalla
        TextField txfResul = new TextField();
        //Colocar
        root.add(txfResul,0,4);

        //Acciones de para el botonInicio
        btnInicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Mostrar el primer numero aleatorio en pantalla
               int Num1 = (int) (Math.random() * (10) + 1);
               String datoNum1 = String.valueOf(Num1);
               fldNum1.setText(datoNum1);
               //Mostrar el segundo numero aleatorio en pantalla
               int Num2 = (int) (Math.random() * (10) + 1);
               String datoNum2 = String.valueOf(Num2);
               fldNum2.setText(datoNum2);



                 class Cronometro extends Thread {


                     public Cronometro(){
                        super();
                    }
                    public void run() {
                        int nuMin=0;
                        int nuSeg=0;

                        String Min = String.valueOf(nuMin);
                        txtMin.setText(Min);

                        String Seg = String.valueOf(nuSeg);
                        txtSeg.setText(Seg);


                        try {
                            for (; ;){
                                if(nuSeg!=59) {
                                    nuSeg++;
                                    //aqui
                                }else{
                                    if(nuMin!=59){
                                        nuSeg=0;
                                        nuMin++;
                                    }
                                }
                                txtMin.setText(nuMin+"");
                                txtSeg.setText(nuSeg+"");
                                //System.out.println(nuMin+":"+nuSeg);
                                sleep(999);
                            }
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                        //Cronometro c = new Cronometro();
                       // c.Start();

                }
                Cronometro c = new Cronometro();
                c.start();

            }

        });

        //Acciones de para el botonResultado
        btnResult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String Numero1;
                Numero1 = fldNum1.getText();
                String Numero2;
                Numero2 = fldNum2.getText();

                String Respuesta;
                Respuesta = txfResul.getText();

                int num1 = Integer.parseInt(Numero1);
                int num2 = Integer.parseInt(Numero2);
                int resp = Integer.parseInt(Respuesta);

                int mult = num1 * num2;

                if (resp == mult){
                    txfResul.setText("Respuesta correcta");
                } else {
                    txfResul.setText("Respuesta incorrecta");
                }

            }
        });


        primaryStage.setTitle("Ejercicio 1 Jose Roberto Vargas Arano");
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();

    }



    public static void main(String[] args) {

        launch(args);
    }



}

