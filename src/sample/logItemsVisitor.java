package sample;

import java.util.ArrayList;

public interface logItemsVisitor {

    int visit(Log log);
    int visit(Goal goal);
    int visit(Nutrition nutrition);
    double visit(dataLogController dataLogController);
}


class logItemsVisitorImpl implements logItemsVisitor
{


    @Override
    public int visit(Log log)
    {
        return ((log.getDate().getYear()-2018)*365) + log.getDate().getDayOfYear();
    }

    @Override
    public int visit(Goal goal)
    {
        return goal.getGoalWeight();
    }

    @Override
    public int visit(Nutrition nutrition)
    {
        return nutrition.getCalories();
    }

    @Override
    public double visit(dataLogController dataLogController)
    {
        System.out.println("Hello");
        return ((dataLogController.dataLogs.get(dataLogController.dataLogs.size()-1).getWeight() * .45) / ((73 * .025) * (73 * .025)));
    }


}

