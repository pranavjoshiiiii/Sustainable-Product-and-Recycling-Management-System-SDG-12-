package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Domain.material;
import Domain.product;
import Domain.simpleSumStrategy;
import Domain.recyclingCategory;

import static org.junit.jupiter.api.Assertions.*;

class simpleSumStrategyTest {

    @Test
    @DisplayName("Should sum impact values of all materials")
    void shouldSumImpactValuesOfAllMaterials() {
        // Arrange
        simpleSumStrategy strategy = new simpleSumStrategy();
        material plastic = new material("Plastic", 5.0, "Recycle", recyclingCategory.PLASTIC);
        material glass = new material("Glass", 2.5, "Recycle", recyclingCategory.GLASS);
        product bottle = new product("Bottle", "Container", 2);
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
        simpleSumStrategy strategy = new simpleSumStrategy();
        product empty = new product("Empty", "Unknown", 0);

        // Act
        double result = strategy.calculateImpact(empty);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Should return impact value for a single material")
    void shouldReturnImpactValueForSingleMaterial() {
        // Arrange
        simpleSumStrategy strategy = new simpleSumStrategy();
        material metal = new material("Metal", 8.0, "Metal bin", recyclingCategory.METAL);
        product can = new product("Can", "Beverage", 1);
        can.addMaterial(metal);

        // Act
        double result = strategy.calculateImpact(can);

        // Assert
        assertEquals(8.0, result);
    }
}