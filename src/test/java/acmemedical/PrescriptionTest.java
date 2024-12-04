package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrescriptionTest {

    private Prescription prescription;
    private PrescriptionPK prescriptionPK;
    private Physician physician;
    private Patient patient;
    private Medicine medicine;

    @BeforeEach
    public void setUp() {
        prescription = new Prescription();
        prescriptionPK = new PrescriptionPK();
        physician = new Physician();
        patient = new Patient();
        medicine = new Medicine();

        // Set IDs for related entities
        physician.setId(1);
        patient.setId(2);
        medicine.setId(3);

        // Initialize composite key
        prescriptionPK.setPhysicianId(physician.getId());
        prescriptionPK.setPatientId(patient.getId());
        prescription.setId(prescriptionPK);
    }

    @Test
    public void testSetAndGetId() {
        PrescriptionPK testKey = new PrescriptionPK(4, 5); // New composite key
        prescription.setId(testKey);

        assertEquals(testKey, prescription.getId(), "Composite ID should match the set value");
    }

    @Test
    public void testSetAndGetPhysician() {
        prescription.setPhysician(physician);
        assertEquals(physician, prescription.getPhysician(), "Physician should match the set value");
        assertEquals(physician.getId(), prescription.getId().getPhysicianId(), "Physician ID in composite key should match");
    }

    @Test
    public void testSetAndGetPatient() {
        prescription.setPatient(patient);
        assertEquals(patient, prescription.getPatient(), "Patient should match the set value");
        assertEquals(patient.getId(), prescription.getId().getPatientId(), "Patient ID in composite key should match");
    }

    @Test
    public void testSetAndGetMedicine() {
        prescription.setMedicine(medicine);
        assertEquals(medicine, prescription.getMedicine(), "Medicine should match the set value");
    }

    @Test
    public void testSetAndGetNumberOfRefills() {
        prescription.setNumberOfRefills(5);
        assertEquals(5, prescription.getNumberOfRefills(), "Number of refills should match the set value");
    }

    @Test
    public void testSetAndGetPrescriptionInformation() {
        String prescriptionInfo = "Take one pill daily after meals.";
        prescription.setPrescriptionInformation(prescriptionInfo);
        assertEquals(prescriptionInfo, prescription.getPrescriptionInformation(), "Prescription information should match the set value");
    }

    @Test
    public void testDefaultConstructor() {
        Prescription defaultPrescription = new Prescription();
        assertNotNull(defaultPrescription.getId(), "Default constructor should initialize the composite key");
    }

    @Test
    public void testPrescriptionRelationships() {
        prescription.setPhysician(physician);
        prescription.setPatient(patient);
        prescription.setMedicine(medicine);

        assertEquals(physician, prescription.getPhysician(), "Physician relationship should be set correctly");
        assertEquals(patient, prescription.getPatient(), "Patient relationship should be set correctly");
        assertEquals(medicine, prescription.getMedicine(), "Medicine relationship should be set correctly");
    }
}
