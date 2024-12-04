package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicalCertificateTest {

    private MedicalCertificate medicalCertificate;
    private MedicalTraining mockMedicalTraining;
    private Physician mockPhysician;

    @BeforeEach
    void setUp() {
        // Create manual mock implementations
        mockMedicalTraining = new MedicalTraining() {
            // Add specific overrides or leave as-is if no behavior is needed
        };

        mockPhysician = new Physician() {
            // Add specific overrides or leave as-is if no behavior is needed
        };

        // Initialize MedicalCertificate with manually created mocks
        medicalCertificate = new MedicalCertificate(mockMedicalTraining, mockPhysician, (byte) 1);
    }

    @Test
    void testConstructor() {
        assertNotNull(medicalCertificate);
        assertEquals(mockMedicalTraining, medicalCertificate.getMedicalTraining());
        assertEquals(mockPhysician, medicalCertificate.getOwner());
        assertEquals((byte) 1, medicalCertificate.getSigned());
    }

    @Test
    void testGetMedicalTraining() {
        assertEquals(mockMedicalTraining, medicalCertificate.getMedicalTraining());
    }

    @Test
    void testSetMedicalTraining() {
        MedicalTraining newMedicalTraining = new MedicalTraining() {
            // Add specific overrides if needed
        };
        medicalCertificate.setMedicalTraining(newMedicalTraining);
        assertEquals(newMedicalTraining, medicalCertificate.getMedicalTraining());
    }

    @Test
    void testGetOwner() {
        assertEquals(mockPhysician, medicalCertificate.getOwner());
    }

    @Test
    void testSetOwner() {
        Physician newPhysician = new Physician() {
            // Add specific overrides if needed
        };
        medicalCertificate.setOwner(newPhysician);
        assertEquals(newPhysician, medicalCertificate.getOwner());
    }

    @Test
    void testGetSigned() {
        assertEquals((byte) 1, medicalCertificate.getSigned());
    }

   
    @Test
    void testSetSignedWithBooleanTrue() {
        medicalCertificate.setSigned(true);
        assertEquals((byte) 1, medicalCertificate.getSigned());
    }

    @Test
    void testSetSignedWithBooleanFalse() {
        medicalCertificate.setSigned(false);
        assertEquals((byte) 0, medicalCertificate.getSigned());
    }}
;
   
  
