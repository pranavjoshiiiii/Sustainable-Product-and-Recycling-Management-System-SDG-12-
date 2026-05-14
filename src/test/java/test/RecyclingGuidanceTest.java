package test;

import Application.MaterialService;
import Domain.Material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RecyclingGuidanceTest {

    @Test
    void testNoMaterials() {

        MaterialService service = new MaterialService();

        List<Material> materials = service.listMaterials();

        assertTrue(materials.isEmpty());
    }

    @Test
    void testCreateMaterialIncludesNameAndInstructions() {

        MaterialService service = new MaterialService();

        service.createMaterial("Plastic", 5.0, "Recycle in plastic bin");

        List<Material> materials = service.listMaterials();

        assertEquals(1, materials.size());

        Material material = materials.get(0);

        assertEquals("Plastic", material.getName());
        assertEquals("Recycle in plastic bin", material.getInstructions());
    }

    @Test
    void testSingleMaterialRule() {

        MaterialService service = new MaterialService();

        service.createMaterial("Glass", 2.5, "Recycle in glass bin");

        List<Material> materials = service.listMaterials();

        assertEquals(1, materials.size());
    }

    @Test
    void testMultipleMaterialsRule() {

        MaterialService service = new MaterialService();

        service.createMaterial("Plastic", 5.0, "Plastic instructions");
        service.createMaterial("Metal", 3.0, "Metal instructions");

        List<Material> materials = service.listMaterials();

        assertEquals(2, materials.size());
    }
}