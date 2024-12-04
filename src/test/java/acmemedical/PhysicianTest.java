package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PhysicianTest {

    @Test
    public void testSetAndGetLastName() {
        Physician physician = new Physician();
        physician.setLastName("Doe");
        assertEquals("Doe", physician.getLastName());
    }

    @Test
    public void testSetFullName() {
        Physician physician = new Physician();
        physician.setFullName("Alice", "Smith");

        assertEquals("Alice", physician.getFirstName());
        assertEquals("Smith", physician.getLastName());
    }

    @Test
    public void testSetAndGetMedicalCertificates() {
        Physician physician = new Physician();
        MedicalCertificate certificate1 = new MedicalCertificate();
        MedicalCertificate certificate2 = new MedicalCertificate();

        Set<MedicalCertificate> medicalCertificates = new HashSet<>();
        medicalCertificates.add(certificate1);
        medicalCertificates.add(certificate2);

        physician.setMedicalCertificates(medicalCertificates);

        assertEquals(2, physician.getMedicalCertificates().size());
        assertTrue(physician.getMedicalCertificates().contains(certificate1));
        assertTrue(physician.getMedicalCertificates().contains(certificate2));
    }

    @Test
    public void testSetAndGetPrescriptions() {
        Physician physician = new Physician();
        Prescription prescription1 = new Prescription();
        Prescription prescription2 = new Prescription();

        Set<Prescription> prescriptions = new HashSet<>();
        prescriptions.add(prescription1);
        prescriptions.add(prescription2);

        physician.setPrescriptions(prescriptions);

        assertEquals(2, physician.getPrescriptions().size());
        assertTrue(physician.getPrescriptions().contains(prescription1));
        assertTrue(physician.getPrescriptions().contains(prescription2));
    }

}
