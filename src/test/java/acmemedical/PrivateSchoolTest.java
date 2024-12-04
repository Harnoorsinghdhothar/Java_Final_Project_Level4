package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrivateSchoolTest {

    @Test
    public void testSetAndGetName() {
        PrivateSchool privateSchool = new PrivateSchool();
        privateSchool.setName("Ivy League Private Academy");

        assertEquals("Ivy League Private Academy", privateSchool.getName(), "Name should match the value set");
    }
}
  
