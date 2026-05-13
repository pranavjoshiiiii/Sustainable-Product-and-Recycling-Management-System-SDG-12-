package src.test.java.test;

import src.main.java.Application.materialService;
import src.main.java.Domain.material;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecyclingGuidanceTest {

    @Test
    void testNoMaterials() {

        materialService service = new materialService();

        List<material> materials = service.listMaterials();

        assertTrue(materials.isEmpty());
    }

    @Test
    void testCreateMaterialIncludesNameAndInstructions() {

        materialService service = new materialService();

        service.createMaterial("Plastic", 5.0, "Recycle in plastic bin");

        List<material> materials = service.listMaterials();

        assertEquals(1, materials.size());

        material material = materials.get(0);

        assertEquals("Plastic", material.getName());
        assertEquals("Recycle in plastic bin", material.getInstructions());
    }

    @Test
    void testSingleMaterialRule() {

        materialService service = new materialService();

        service.createMaterial("Glass", 2.5, "Recycle in glass bin");

        List<material> materials = service.listMaterials();

        assertEquals(1, materials.size());
    }

    @Test
    void testMultipleMaterialsRule() {

        materialService service = new materialService();

        service.createMaterial("Plastic", 5.0, "Plastic instructions");
        service.createMaterial("Metal", 3.0, "Metal instructions");

        List<material> materials = service.listMaterials();

        assertEquals(2, materials.size());
    }
}