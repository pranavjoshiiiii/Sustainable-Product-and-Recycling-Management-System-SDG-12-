package src.main.java.Domain;

import java.util.List;

public class weightedByLifespanStrategy implements impactCalculationStrategy {

    @Override
    public double calculateImpact(product product) {
        double total = 0;
        List<material> materials = product.getMaterials();

        for (material m : materials) {
            total = total + (m.getImpactValue() * product.getLifespan());
        }

        return total;
    }
}

