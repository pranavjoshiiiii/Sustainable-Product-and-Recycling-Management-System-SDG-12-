package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Domain.Material;
import Domain.Product;
import Domain.WeightedByLifespanStrategy;
import Domain.RecyclingCategory;

import static org.junit.jupiter.api.Assertions.*;

class WeightedByLifespanStrategyTest {

    @Test
    @DisplayName("Should multiply impact value by product lifespan")
    void shouldMultiplyImpactValueByLifespan() {
        // Arrange
        WeightedByLifespanStrategy strategy = new WeightedByLifespanStrategy();
        Material plastic = new Material("Plastic", 5.0, "Recycle", RecyclingCategory.PLASTIC);
        Product bottle = new Product("Bottle", "Container", 3);
        bottle.addMaterial(plastic);

        // Act
        double result = strategy.calculateImpact(bottle);

        // Assert
        assertEquals(15.0, result); // 5.0 * 3
    }

    @Test
    @DisplayName("Should return zero when product has no materials")
    void shouldReturnZeroWhenProductHasNoMaterials() {
        // Arrange
        WeightedByLifespanStrategy strategy = new WeightedByLifespanStrategy();
        Product empty = new Product("Empty", "Unknown", 5);

        // Act
        double result = strategy.calculateImpact(empty);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Should sum weighted impact for multiple materials")
    void shouldSumWeightedImpactForMultipleMaterials() {
        // Arrange
        WeightedByLifespanStrategy strategy = new WeightedByLifespanStrategy();
        Material plastic = new Material("Plastic", 4.0, "Recycle", RecyclingCategory.PLASTIC);
        Material metal = new Material("Metal", 6.0, "Metal bin", RecyclingCategory.METAL);
        Product phone = new Product("Phone", "Electronics", 3);
        phone.addMaterial(plastic);
        phone.addMaterial(metal);

        // Act
        double result = strategy.calculateImpact(phone);

        // Assert
        assertEquals(30.0, result); // (4.0 + 6.0) * 3
    }
}