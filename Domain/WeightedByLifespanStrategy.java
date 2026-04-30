package Domain;

import java.util.List;

public class WeightedByLifespanStrategy implements ImpactCalculationStrategy {

    @Override
    public double calculateImpact(Product product) {
        double total = 0;
        List<Material> materials = product.getMaterials();

        for (Material m : materials) {
            total = total + (m.getImpactValue() * product.getLifespan());
        }

        return total;
    }
}

