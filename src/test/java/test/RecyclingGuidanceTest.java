package test;

import Application.materialService;
import Domain.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;



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