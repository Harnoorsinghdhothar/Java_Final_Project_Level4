package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedicalSchoolTest {

    @Test
    public void testMedicalSchoolConstructor() {
        MedicalSchool publicSchool = new PublicSchool();
        assertNotNull(publicSchool);
        assertTrue(publicSchool instanceof MedicalSchool);
    }

    @Test
    public void testEqualsSameObject() {
        MedicalSchool medicalSchool = new PublicSchool();
        medicalSchool.setId(1);
        medicalSchool.setName("Harvard Medical School");

        assertEquals(medicalSchool, medicalSchool);
    }

    @Test
    public void testEqualsDifferentObjectSameValues() {
        MedicalSchool medicalSchool1 = new PublicSchool();
        MedicalSchool medicalSchool2 = new PublicSchool();

        medicalSchool1.setId(1);
        medicalSchool1.setName("Harvard Medical School");

        medicalSchool2.setId(1);
        medicalSchool2.setName("Harvard Medical School");

        assertEquals(medicalSchool1, medicalSchool2);
    }

    @Test
    public void testEqualsDifferentObjectDifferentValues() {
        MedicalSchool medicalSchool1 = new PublicSchool();
        MedicalSchool medicalSchool2 = new PublicSchool();

        medicalSchool1.setId(1);
        medicalSchool1.setName("Harvard Medical School");

        medicalSchool2.setId(2);
        medicalSchool2.setName("Stanford Medical School");

        assertNotEquals(medicalSchool1, medicalSchool2);
    }

    
}
