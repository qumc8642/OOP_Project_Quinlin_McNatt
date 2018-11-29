package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.*;
import java.util.*;
import javafx.scene.Parent;
import java.util.Date;
import java.time.LocalDate;


/**
 *
 *
 */
public class dataLogController {
    public TextField weightSubmit;
    public DatePicker dateSubmit;
    public static ArrayList<Log> dataLogs = new ArrayList();
    public static double finalweight;



    @FXML
    public void LogSubmit(ActionEvent event)
    {


        int castme = Integer.valueOf(weightSubmit.getText());
        Log newlog = new Log(castme, dateSubmit.getValue());
        dataLogs.add(newlog);

        for (Log item: dataLogs) {
            System.out.println(item);
        }

        weightSubmit.clear();
        dateSubmit.setValue(LocalDate.now());
        //System.out.println(newlog.getWeight());
        //System.out.println(newlog.getDateYear());
        finalweight = castme;

    }


    public double accept(logItemsVisitor visitor)
    {
        return visitor.visit(this);
    }



}
