package com.example;

import java.io.IOException;
import java.io.StringWriter;

import org.json.*;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

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
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonSearch;

    @FXML
    private TextArea textRespons;

    @FXML
    private TableView<TableDataModel> tableView;
    @FXML
    private TableColumn<TableDataModel, Integer> kodeBarang;
    @FXML
    private TableColumn<TableDataModel, String> namaBarang;
    @FXML
    private TableColumn<TableDataModel, Integer> jumlah;
    @FXML
    private TableColumn<TableDataModel, Integer> harga;

    private ObservableList<TableDataModel> tableData;

    public void initialize() {
    kodeBarang.setCellValueFactory(new PropertyValueFactory<>("kodeBarang"));
    namaBarang.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
    jumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
    harga.setCellValueFactory(new PropertyValueFactory<>("harga"));

    tableData = FXCollections.observableArrayList();
    tableView.setItems(tableData);
    
    Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            // Getlist of data from api first
            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            GenericUrl url = new GenericUrl("http://localhost:8081/barang");
            HttpRequest request = requestFactory.buildGetRequest(url);
            HttpResponse response = request.execute();

            // Convert list of object from response into individual object
            String content = response.parseAsString();
            JSONArray jsonArray = new JSONArray(content);
            // Add the data to the tableData
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int tmpkode = jsonObject.getInt("kodeBarang");
                String tmpnama = jsonObject.getString("namaBarang");
                int tmpjumlah = jsonObject.getInt("jumlah");
                int tmpharga = jsonObject.getInt("harga");
                tableData.addAll(new TableDataModel(tmpkode, tmpnama, tmpjumlah, tmpharga));
            }
            response.disconnect();
            return null;
        }
    };
    new Thread(task).start();
}

    @FXML
    public void onInsert(ActionEvent event) {
            // Getting input from user
            int tmpkode = Integer.parseInt(inputKodeProduk.getText());
            String tmpnama = inputNamaProduk.getText();
            int tmpjumlah = Integer.parseInt(inputJumlah.getText());
            int tmpharga = Integer.parseInt(inputHarga.getText());
            // Turning it into JSON object
            StringWriter stringJson = new StringWriter();
            JSONWriter writer = new JSONWriter(stringJson)
                .object()
                    .key("kodeBarang").value(tmpkode)
                    .key("namaBarang").value(tmpnama)
                    .key("jumlah").value(tmpjumlah)
                    .key("harga").value(tmpharga)
                .endObject();
            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            HttpContent content = ByteArrayContent.fromString("application/json", stringJson.toString());
            GenericUrl url = new GenericUrl("http://localhost:8081/barang/add");
            try {
                HttpRequest request = requestFactory.buildPostRequest(url, content);
                HttpResponse response = request.execute();
                String responseString = response.parseAsString();
                textRespons.setText(responseString);
                System.out.println(response.getStatusCode());
                System.out.println(responseString);
                tableData.addAll(new TableDataModel(tmpkode, tmpnama, tmpjumlah, tmpharga));
                response.disconnect();
            } catch (IOException e) {
                System.out.println("An I/O error occurred: " + e);
            } catch (Exception e) {
                System.out.println(e);
            }
    }
}
