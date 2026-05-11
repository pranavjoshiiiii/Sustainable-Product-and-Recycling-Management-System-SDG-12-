package Application;

import Domain.impactCalculationStrategy;
import Domain.simpleSumStrategy;
import Domain.weightedByLifespanStrategy;

import java.util.ArrayList;
import java.util.List;

public class strategyFactory {

    public static List<impactCalculationStrategy> getAvailableStrategies() {
        List<impactCalculationStrategy> strategies = new ArrayList<>();
        strategies.add(new simpleSumStrategy());
        strategies.add(new weightedByLifespanStrategy());
        return strategies;
    }

    public static impactCalculationStrategy create(int choice) {
        List<impactCalculationStrategy> strategies = getAvailableStrategies();

        if (choice < 1 || choice > strategies.size()) {
            throw new IllegalArgumentException("Invalid strategy choice: " + choice);
        }

        return strategies.get(choice - 1);
    }
}


