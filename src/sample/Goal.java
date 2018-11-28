package sample;
import java.time.LocalDate;

public class Goal implements logItems{

    public LocalDate goalDate;
    public int goalWeight;

    @Override
    public int accept(logItemsVisitor visitor)
    {
        return visitor.visit(this);
    }



    public Goal(int _goalWeight, LocalDate _goalDate)
    {
        this.goalDate = _goalDate;
        this.goalWeight = _goalWeight;
    }

    public int getGoalWeight() {
        return goalWeight;
    }
}
