package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 */
public class setGoalsController {

    public static ArrayList<Goal> goals = new ArrayList();

    public TextField weightSubmit;
    public DatePicker dateSubmit;


    public void GoalSubmit(ActionEvent event)
    {

        int castme = Integer.valueOf(weightSubmit.getText());
        Goal newlog = new Goal(castme, dateSubmit.getValue());
        goals.add(newlog);

        //System.out.println(castme);
        //System.out.println(dateSubmit.getValue());
        weightSubmit.clear();
        dateSubmit.setValue(LocalDate.now());
    }





}
