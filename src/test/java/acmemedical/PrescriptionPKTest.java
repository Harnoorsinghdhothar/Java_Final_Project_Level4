package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrescriptionPKTest {

    private PrescriptionPK prescriptionPK;

    @BeforeEach
    public void setUp() {
        prescriptionPK = new PrescriptionPK();
    }

    @Test
    public void testToString() {
        prescriptionPK.setPhysicianId(7);
        prescriptionPK.setPatientId(9);

        String expectedString = "PrescriptionPK [physicianId = 7, patientId = 9]";
        assertEquals(expectedString, prescriptionPK.toString(), "toString() output should match the expected format");
    }
}
