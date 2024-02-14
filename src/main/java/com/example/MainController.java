package com.example;

import org.assertj.core.internal.Integers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.*;
import org.json.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.*;

public class MainController {
    
    // @FXML
    // public Label manipulasi;
    // @FXML
    // private TextField kodeBarang;
    @FXML
    private TextField namaBarang;

    // @FXML
    // private TextField jumlah;
    // @FXML
    // private TextField harga;
    
    @FXML
    private Button buttonInsert;
    @FXML
    private Button buttonUpdate;
    // @FXML
    // private Button buttonDelete;
    // @FXML
    // private Button buttonSearch;
    
    
    // String sample = "test";

    // public void addToTextField(ActionEvent event) {
        // namabarang.setText(sample);
    // }
    
    // public void findToDatabase(ActionEvent event) {
    //     OkHttpClient client = new OkHttpClient();
    //     Request req = new   Request.Builder()
    //     .url("http://localhost:8081/barang").build();

    //     try {
    //         Response resp = client.newCall(req).execute();
    //         // JSONObject respobj = new JSONObject(resp.body());
            // String jsoString = respobj.toString();
        //     JSONArray arrJson = new JSONArray(resp.body());
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        // public void insertToDatabase(ActionEvent event) {
        //     OkHttpClient client = new OkHttpClient();

        //     String jsonString =  "\n + \"namaBarang\": \"" + namaBarang.getText() + "\"," +  \n" +
        //     "\n + \"jumlah\": \"" + jumlah.getText() + "\"," +  \n" +
        //     "\n + \"harga\": \"" + harga.getText() + "\"," +  \n" +
        //     "\n + \"kodeBarang\": \"" + kodeBarang.getText() + "\"";
        //     RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jsonString);
        //     Request req = new   Request.Builder()
        //         .url("http://localhost:8081/barang/add")
        //         .post(body).build();

        //     try {
        //         Response resp = client.newCall(req).execute();
        //         ////Dump Json
        //         JSONArray arrJson = new JSONArray(resp.body());
        //         for
        //     } catch (Exception e) {
        //         // TODO: handle exception
        //     }
        // }
    // }
}
