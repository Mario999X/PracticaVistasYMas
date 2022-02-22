package com.example.practicaexamen;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;

public class AppTablaController {

    @FXML
    private StackPane appTabla;

    @FXML
    private TableView vistaTabla;

    @FXML
    private TableColumn<Animal, String> columnName, columnClas;

    @FXML
    private void volverPrincipalT() {
        appTabla.setVisible(false);
    }

    public void cargarTabla(ObservableList<Animal> datosLista) {
        vistaTabla.setEditable(true);
        columnName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnClas.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
        columnClas.setCellFactory(TextFieldTableCell.forTableColumn());
        columnClas.setOnEditCommit(data -> {
            if (data != null) {
                data.getRowValue().setClasificacion(data.getNewValue());
            }
        });
        vistaTabla.setItems(datosLista);


    }

}
