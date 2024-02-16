package com.example;

import javafx.scene.control.Button;

import java.io.StringWriter;

import org.json.*;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
    
    @FXML
    private TextField inputKodeProduk;
    @FXML
    private TextField inputNamaProduk;
    @FXML
    private TextField inputJumlah;
    @FXML
    private TextField inputHarga;
    @FXML
    private TextField inputSearch;
    
    @FXML
    private Button buttonInsert;
    @FXML
    private Button buttonUpdate;
    // @FXML
    // private Button buttonDelete;
    // @FXML
    // private Button buttonSearch;
    
    
     Integer sample = 0;

    @FXML
    public void onInsert(ActionEvent event) {
            String tmpkode = inputKodeProduk.getText();
            String tmpnama = inputNamaProduk.getText();
            int tmpjumlah = Integer.parseInt(inputJumlah.getText());
            int tmpharga = Integer.parseInt(inputHarga.getText());
            StringWriter stringJson = new StringWriter();
            JSONWriter writer = new JSONWriter(stringJson)
                .object()
                    .key("kodeBarang").value(tmpkode)
                    .key("namaBarang").value(tmpnama)
                    .key("jumlah").value(tmpjumlah)
                    .key("harga").value(tmpharga)
                .endObject();
                    inputSearch.setText(stringJson.toString());
        HttpTransport httpTransport = new NetHttpTransport();
        HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
        HttpContent content = ByteArrayContent.fromString("application/json", stringJson.toString());
        GenericUrl url = new GenericUrl("http://localhost:8081/barang/add");
        try {
                    HttpRequest request = requestFactory.buildPostRequest(url, content);
                    HttpResponse response = request.execute();
            
                    System.out.println(response.getStatusCode());
                    System.out.println(response.parseAsString());
            
                    response.disconnect();
                } catch (Exception e) {
                    System.out.println(e);
                }
    }
}
