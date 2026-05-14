package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Domain.Material;
import Domain.Product;
import Domain.SimpleSumStrategy;
import Domain.RecyclingCategory;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSumStrategyTest {

    @Test
    @DisplayName("Should sum impact values of all materials")
    void shouldSumImpactValuesOfAllMaterials() {
        // Arrange
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Material plastic = new Material("Plastic", 5.0, "Recycle", RecyclingCategory.PLASTIC);
        Material glass = new Material("Glass", 2.5, "Recycle", RecyclingCategory.GLASS);
        Product bottle = new Product("Bottle", "Container", 2);
        bottle.addMaterial(plastic);
        bottle.addMaterial(glass);

        // Act
        double result = strategy.calculateImpact(bottle);

        // Assert
        assertEquals(7.5, result);
    }

    @Test
    @DisplayName("Should return zero when product has no materials")
    void shouldReturnZeroWhenProductHasNoMaterials() {
        // Arrange
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product empty = new Product("Empty", "Unknown", 0);

        // Act
        double result = strategy.calculateImpact(empty);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Should return impact value for a single material")
    void shouldReturnImpactValueForSingleMaterial() {
        // Arrange
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Material metal = new Material("Metal", 8.0, "Metal bin", RecyclingCategory.METAL);
        Product can = new Product("Can", "Beverage", 1);
        can.addMaterial(metal);

        // Act
        double result = strategy.calculateImpact(can);

        // Assert
        assertEquals(8.0, result);
    }
}