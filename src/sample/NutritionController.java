package sample;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.collections.*;

import java.lang.reflect.Array;
import java.util.*;
import javafx.scene.Parent;
import java.util.Date;
import java.time.LocalDate;

/**
 *
 *
 */
public class NutritionController {

    @FXML
    public TextField quantityField;
    public TextField nameSubmit;
    public TextField descriptionSubmit;
    public TextField caloriesSubmit;
    public TextField nameField;
    public TableView nutritionTable;

    public static int newcal;
    private int columnTrack = 0;

    //public static ArrayList<Nutrition> nutritionList = new ArrayList();
    ObservableList<Nutrition> nutritionList = FXCollections.observableArrayList();

    public void setNutritionTable (ObservableList<Nutrition> nutritionList)
    {

        TableColumn nameCol = new TableColumn("Name");
        TableColumn descriptionCol = new TableColumn("Description");
        TableColumn caloriesCol = new TableColumn("Calories");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<Nutrition, String>("name")
        );

        descriptionCol.setCellValueFactory(
                new PropertyValueFactory<Nutrition, String>("description")
        );

        caloriesCol.setCellValueFactory(
                new PropertyValueFactory<Nutrition, Integer>("calories")
        );

        nutritionTable.setItems(nutritionList);
        if(columnTrack == 0) {
            nutritionTable.getColumns().addAll(nameCol, descriptionCol, caloriesCol);
            columnTrack++;
        }


    }

    public void nutritionSubmit(ActionEvent event)
    {
        int calories = Integer.valueOf(caloriesSubmit.getText());
        String name = nameSubmit.getText();
        String description = descriptionSubmit.getText();



        Nutrition newNutrition = new Nutrition(name, description, calories);

        nutritionList.add(newNutrition);


        setNutritionTable(nutritionList);


        caloriesSubmit.clear();
        nameSubmit.clear();
        descriptionSubmit.clear();


    }


    public void nutritionField(ActionEvent event)
    {

        int quantity = Integer.valueOf(quantityField.getText());
        String searchName = nameField.getText();

        for (Nutrition item : nutritionList)
        {
            System.out.println(item.getName());
            System.out.println(item.getDescription());


            if(searchName.equals(item.getName()))
            {
                newcal = newcal + quantity * item.getCalories();
                System.out.println("Working");
            }

        }

    System.out.println(newcal);

    }



}
