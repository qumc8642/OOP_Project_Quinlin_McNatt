package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.Parent;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.shape.Line;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

import javax.swing.*;

/**
 *
 */
public class Controller {

    public void pressExit(ActionEvent event)
    {
        System.exit(0);
        //save data
    }
    @FXML
    public void logData(ActionEvent event) throws Exception
    {
    try {
        FXMLLoader datalog = new FXMLLoader(getClass().getResource("data_log.fxml"));
        Parent dlog = (Parent) datalog.load();
        Stage data = new Stage();
        data.setTitle("Data Log");
        data.setScene(new Scene(dlog, 600, 400));
        data.show();

    } catch (Exception e) {
        System.out.println("Can't load page");
    }



    }

    public void setGoals(ActionEvent event)
    {
        try {
            FXMLLoader datalog = new FXMLLoader(getClass().getResource("set_goals.fxml"));
            Parent dlog = (Parent) datalog.load();
            Stage data = new Stage();
            data.setTitle("Goal Setter");
            data.setScene(new Scene(dlog, 600, 400));
            data.show();

        } catch (Exception e) {
            System.out.println("Can't load page");
        }


    }

    public void nutritionMenu(ActionEvent event)
    {

        try {
            FXMLLoader datalog = new FXMLLoader(getClass().getResource("nutrition_menu.fxml"));
            Parent dlog = (Parent) datalog.load();
            Stage data = new Stage();
            data.setTitle("Nutrition Menu");
            data.setScene(new Scene(dlog, 600, 400));
            data.show();

        } catch (Exception e) {
            System.out.println("Can't load page");
        }


    }



    public void viewData(ActionEvent event)
    {




        Stage data = new Stage();
        data.setTitle("Weight Statistics");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Weight: Lbs");
        xAxis.setTickLabelsVisible(false);
        xAxis.setLabel("2018-01-01                                                                                                                                                          " + LocalDate.now());
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Weight Statistics");
        lineChart.setLegendVisible(false);
        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series goal = new XYChart.Series();
        series.setName("Current Weight");
        goal.setName("Current Goal");
        //populating the series with data
        for(Log item: dataLogController.dataLogs)
        {
            logItemsVisitor weightVisitor = new logItemsVisitorImpl();
            int useVisitor = item.accept(weightVisitor);
            series.getData().add(new XYChart.Data<>(useVisitor, item.getWeight()));
        }

        logItemsVisitor goalVisitor = new logItemsVisitorImpl();

        int goalVisit = setGoalsController.goals.get(setGoalsController.goals.size()-1).accept(goalVisitor);
        System.out.println(goalVisit);
        int currentday = (LocalDate.now().getYear()-2018) * 365 + LocalDate.now().getDayOfYear();
        goal.getData().add(new XYChart.Data<Number, Number>(0, goalVisit));
        goal.getData().add(new XYChart.Data<Number, Number>(currentday, goalVisit));




        /*
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        */

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        data.setScene(scene);
        data.show();


    }


    public void BMIStats (ActionEvent event)
    {
        Stage pie = new Stage();
        Scene scene = new Scene(new Group());
        pie.setTitle("BMI Chart");
        pie.setWidth(500);
        pie.setHeight(500);



        double currWeight = ((dataLogController.dataLogs.get(dataLogController.dataLogs.size()-1).getWeight() * .45) / ((73 * .025) * (73 * .025)));
        System.out.println(currWeight);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("BMI: " + (double)Math.round(currWeight * 1000d) / 1000d,  currWeight),
                        new PieChart.Data("Rest: ", 100-currWeight));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("BMI Chart");

        ((Group) scene.getRoot()).getChildren().add(chart);
        pie.setScene(scene);
        pie.show();
    }

    public void calorieStats (ActionEvent event)
    {

        Stage pie = new Stage();
        Scene scene = new Scene(new Group());
        pie.setTitle("BMI Chart");
        pie.setWidth(500);
        pie.setHeight(500);




        double hold = NutritionController.newcal;
        double calPercentage = (hold / 2700) * 100;
        System.out.println(calPercentage);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Calories consumed: " + (double)Math.round(calPercentage * 1000d) / 1000d,  calPercentage),
                        new PieChart.Data("Calories to eat: " + ((double)Math.round((100 - calPercentage) * 1000d) / 1000d ), 100-calPercentage));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Calorie Chart");

        ((Group) scene.getRoot()).getChildren().add(chart);
        pie.setScene(scene);
        pie.show();


    }




}
