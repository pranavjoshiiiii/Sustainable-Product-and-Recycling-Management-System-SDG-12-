package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Domain.material;
import Domain.product;
import Domain.weightedByLifespanStrategy;
import Domain.recyclingCategory;

import static org.junit.jupiter.api.Assertions.*;

class weightedByLifespanStrategyTest {

    @Test
    @DisplayName("Should multiply impact value by product lifespan")
    void shouldMultiplyImpactValueByLifespan() {
        // Arrange
        weightedByLifespanStrategy strategy = new weightedByLifespanStrategy();
        material plastic = new material("Plastic", 5.0, "Recycle", recyclingCategory.PLASTIC);
        product bottle = new product("Bottle", "Container", 3);
        bottle.addMaterial(plastic);

        // Act
        double result = strategy.calculateImpact(bottle);

        // Assert
        assertEquals(15.0, result);  // 5.0 * 3
    }

    @Test
    @DisplayName("Should return zero when product has no materials")
    void shouldReturnZeroWhenProductHasNoMaterials() {
        // Arrange
        weightedByLifespanStrategy strategy = new weightedByLifespanStrategy();
        product empty = new product("Empty", "Unknown", 5);

        // Act
        double result = strategy.calculateImpact(empty);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Should sum weighted impact for multiple materials")
    void shouldSumWeightedImpactForMultipleMaterials() {
        // Arrange
        weightedByLifespanStrategy strategy = new weightedByLifespanStrategy();
        material plastic = new material("Plastic", 4.0, "Recycle", recyclingCategory.PLASTIC);
        material metal = new material("Metal", 6.0, "Metal bin", recyclingCategory.METAL);
        product phone = new product("Phone", "Electronics", 3);
        phone.addMaterial(plastic);
        phone.addMaterial(metal);

        // Act
        double result = strategy.calculateImpact(phone);

        // Assert
        assertEquals(30.0, result);  // (4.0 + 6.0) * 3
    }
}