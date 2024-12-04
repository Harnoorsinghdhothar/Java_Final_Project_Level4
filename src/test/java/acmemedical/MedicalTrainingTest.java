package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MedicalTrainingTest {

    @Test
    public void testMedicalTrainingConstructor() {
        MedicalTraining training = new MedicalTraining();
        assertNotNull(training);
        assertNotNull(training.getDurationAndStatus()); // Ensures the embedded object is initialized
    }

    @Test
    public void testSetAndGetMedicalSchool() {
        MedicalSchool school = new PublicSchool();
        school.setId(1);
        school.setName("Harvard Medical School");

        MedicalTraining training = new MedicalTraining();
        training.setMedicalSchool(school);

        assertEquals(school, training.getMedicalSchool());
        assertEquals("Harvard Medical School", training.getMedicalSchool().getName());
    }

    @Test
    public void testSetAndGetCertificate() {
        MedicalCertificate certificate = new MedicalCertificate();
        certificate.setId(1);

        MedicalTraining training = new MedicalTraining();
        training.setCertificate(certificate);

        assertEquals(certificate, training.getCertificate());
        assertEquals(1, training.getCertificate().getId());
    }

  
    @Test
    public void testEqualsSameObject() {
        MedicalTraining training = new MedicalTraining();
        training.setId(1);

        assertEquals(training, training);
    }

   

    @Test
    public void testEqualsDifferentObjectDifferentValues() {
        MedicalTraining training1 = new MedicalTraining();
        MedicalTraining training2 = new MedicalTraining();

        training1.setId(1);
        training2.setId(2);

        assertNotEquals(training1, training2);
    }

   
    
}
