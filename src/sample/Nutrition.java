package sample;

import java.time.LocalDate;

/**
 *
 */
public class Nutrition implements logItems{

    public String name;
    public String description;
    public int calories;




    Nutrition()
    {
        this.name = "";
        this.description = "";
        this.calories = 0;
    }



    @Override
    public int accept(logItemsVisitor visitor)
    {
        return visitor.visit(this);
    }


    public Nutrition(String _name, String _description, int _calories)
    {
        this.name = _name;
        this.description = _description;
        this.calories = _calories;
    }

    public String getName(){return name;}
    public String getDescription(){return description;}
    public int getCalories(){return calories;}


}
