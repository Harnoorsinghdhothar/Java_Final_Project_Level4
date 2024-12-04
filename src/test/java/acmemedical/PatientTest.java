package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import acmemedical.entity.Patient;
import acmemedical.entity.Prescription;

import java.util.HashSet;
import java.util.Set;

class PatientTest {
    private Patient patient;
    
    /**
     * Sets up the test environment before each test.
     * Creates a new instance of Patient.
     */
    @BeforeEach
    void setUp() {
        patient = new Patient();
    }
   
    /**
     * Tests the initial state of prescriptions collection.
     * Verifies that the collection is empty but not null.
     */
    @Test
    void testInitialPrescriptionsIsEmpty() {
        assertNotNull(patient.getPrescriptions());
        assertTrue(patient.getPrescriptions().isEmpty());
    }
    
    /**
     * Tests the prescriptions setter and getter.
     * Verifies that a collection of prescriptions can be set and retrieved.
     */
    @Test
    void testSetAndGetPrescriptions() {
        Set<Prescription> prescriptions = new HashSet<>();
        Prescription prescription = new Prescription();
        prescriptions.add(prescription);
        patient.setPrescription(prescriptions);
        assertEquals(prescriptions, patient.getPrescriptions());
    }
    
    /**
     * Tests adding multiple prescriptions.
     * Verifies that multiple prescriptions can be added and the collection size is correct.
     */
    @Test
    void testMultiplePrescriptions() {
        Set<Prescription> prescriptions = new HashSet<>();
        prescriptions.add(new Prescription());
        prescriptions.add(new Prescription());
        patient.setPrescription(prescriptions);
        assertEquals(2, patient.getPrescriptions().size());
    }
    
    /**
     * Tests setting maximum length address.
     * Verifies that a 100-character address can be set and retrieved.
     */
    @Test
    void testLongAddress() {
        String longAddress = "A".repeat(100);
        patient.setAddress(longAddress);
        assertEquals(longAddress, patient.getAddress());
    }
    
    /**
     * Tests setting negative values for numeric fields.
     * Verifies that negative values can be set and retrieved for height, weight, and year.
     */
    @Test
    void testNegativeValues() {
        patient.setHeight(-180);
        patient.setWeight(-75);
        patient.setYear(-2000);
        assertEquals(-180, patient.getHeight());
        assertEquals(-75, patient.getWeight());
        assertEquals(-2000, patient.getYear());
    }
}