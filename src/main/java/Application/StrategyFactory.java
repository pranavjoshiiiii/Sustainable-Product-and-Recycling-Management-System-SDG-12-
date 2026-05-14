package Application;

import java.util.ArrayList;
import java.util.List;

import Domain.ImpactCalculationStrategy;
import Domain.SimpleSumStrategy;
import Domain.WeightedByLifespanStrategy;

public class StrategyFactory {

    public static List<ImpactCalculationStrategy> getAvailableStrategies() {
        List<ImpactCalculationStrategy> strategies = new ArrayList<>();
        strategies.add(new SimpleSumStrategy());
        strategies.add(new WeightedByLifespanStrategy());
        return strategies;
    }

    public static ImpactCalculationStrategy create(int choice) {
        List<ImpactCalculationStrategy> strategies = getAvailableStrategies();

        if (choice < 1 || choice > strategies.size()) {
            throw new IllegalArgumentException("Invalid strategy choice: " + choice);
        }

        return strategies.get(choice - 1);
    }
}
