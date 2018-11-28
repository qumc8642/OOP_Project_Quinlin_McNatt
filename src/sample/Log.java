package sample;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 *
 */
public class Log implements logItems{



    public LocalDate date;

    public int weight;


    public Log()
    {
        date = LocalDate.now();
        weight = 0;
    }


    @Override
    public int accept(logItemsVisitor visitor)
    {
        return visitor.visit(this);
    }


    public Log(int _weight, LocalDate _dateYear)
    {
        this.weight = _weight;
        this.date = _dateYear;
    }


    public int getWeight()
    {
        return this.weight;
    }

    public LocalDate getDate() {
        return this.date;
    }


    @Override
    public String toString()
    {
        return "Weight: " + weight + " Date: " + date;


    }




}
