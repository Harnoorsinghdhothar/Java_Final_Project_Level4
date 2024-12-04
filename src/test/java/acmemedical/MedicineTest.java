package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MedicineTest {

  
    @Test
    public void testSetAndGetDosageInformation() {
        Medicine medicine = new Medicine();
        medicine.setDosageInformation("Take one tablet after meals");
        assertEquals("Take one tablet after meals", medicine.getDosageInformation());
    }

    @Test
    public void testSetAndGetChemicalName() {
        Medicine medicine = new Medicine();
        medicine.setChemicalName("Acetaminophen");
        assertEquals("Acetaminophen", medicine.getChemicalName());
    }

    @Test
    public void testSetAndGetPrescriptions() {
        Medicine medicine = new Medicine();
        Prescription prescription1 = new Prescription();
        Prescription prescription2 = new Prescription();

        Set<Prescription> prescriptions = new HashSet<>();
        prescriptions.add(prescription1);
        prescriptions.add(prescription2);

        medicine.setPrescriptions(prescriptions);

        assertEquals(2, medicine.getPrescriptions().size());
        assertTrue(medicine.getPrescriptions().contains(prescription1));
        assertTrue(medicine.getPrescriptions().contains(prescription2));
    }

    @Test
    public void testSetMedicine() {
        Medicine medicine = new Medicine();
        medicine.setMedicine("Advil", "Pfizer", "Take one capsule every 6 hours");

        assertEquals("Advil", medicine.getDrugName());
        assertEquals("Pfizer", medicine.getManufacturerName());
        assertEquals("Take one capsule every 6 hours", medicine.getDosageInformation());
    }

    @Test
    public void testEmptyPrescriptionSet() {
        Medicine medicine = new Medicine();
        assertNotNull(medicine.getPrescriptions());
        assertTrue(medicine.getPrescriptions().isEmpty());
    }
}
