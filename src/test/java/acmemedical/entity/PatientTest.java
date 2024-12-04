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
     * Tests the default constructor of Patient.
     * Verifies that a new instance is created with default values for all fields.
     */
    @Test
    void testDefaultConstructor() {
        assertNotNull(patient);
        assertNull(patient.getFirstName());
        assertNull(patient.getLastName());
        assertEquals(0, patient.getYear());
        assertNull(patient.getAddress());
        assertEquals(0, patient.getHeight());
        assertEquals(0, patient.getWeight());
        assertEquals(0, patient.getSmoker());
    }
    
    /**
     * Tests the parameterized constructor of Patient.
     * Verifies that all parameters are correctly assigned to their respective fields.
     */
    @Test
    void testParameterizedConstructor() {
        Patient p = new Patient("John", "Doe", 1990, "123 Main St", 175, 70, (byte)0);
        assertEquals("John", p.getFirstName());
        assertEquals("Doe", p.getLastName());
        assertEquals(1990, p.getYear());
        assertEquals("123 Main St", p.getAddress());
        assertEquals(175, p.getHeight());
        assertEquals(70, p.getWeight());
        assertEquals(0, p.getSmoker());
    }
    
    /**
     * Tests the setPatient method.
     * Verifies that all patient information can be updated at once.
     */
    @Test
    void testSetPatient() {
        patient.setPatient("Jane", "Smith", 1985, "456 Oak St", 165, 55, (byte)1);
        assertEquals("Jane", patient.getFirstName());
        assertEquals("Smith", patient.getLastName());
        assertEquals(1985, patient.getYear());
        assertEquals("456 Oak St", patient.getAddress());
        assertEquals(165, patient.getHeight());
        assertEquals(55, patient.getWeight());
        assertEquals(1, patient.getSmoker());
    }
    
    /**
     * Tests the first name setter and getter.
     * Verifies that the first name can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetFirstName() {
        patient.setFirstName("Alice");
        assertEquals("Alice", patient.getFirstName());
    }
    
    /**
     * Tests the last name setter and getter.
     * Verifies that the last name can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetLastName() {
        patient.setLastName("Johnson");
        assertEquals("Johnson", patient.getLastName());
    }
    
    /**
     * Tests the birth year setter and getter.
     * Verifies that the year can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetYear() {
        patient.setYear(2000);
        assertEquals(2000, patient.getYear());
    }
    
    /**
     * Tests the address setter and getter.
     * Verifies that the address can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetAddress() {
        String address = "789 Pine Street";
        patient.setAddress(address);
        assertEquals(address, patient.getAddress());
    }
    
    /**
     * Tests the height setter and getter.
     * Verifies that the height can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetHeight() {
        patient.setHeight(180);
        assertEquals(180, patient.getHeight());
    }
    
    /**
     * Tests the weight setter and getter.
     * Verifies that the weight can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetWeight() {
        patient.setWeight(75);
        assertEquals(75, patient.getWeight());
    }
    
    /**
     * Tests the smoker status setter and getter.
     * Verifies that the smoker status can be set and retrieved correctly.
     */
    @Test
    void testSetAndGetSmoker() {
        patient.setSmoker((byte)1);
        assertEquals(1, patient.getSmoker());
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