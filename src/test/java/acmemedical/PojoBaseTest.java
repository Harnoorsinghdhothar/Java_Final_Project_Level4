package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class PojoBaseTest {

   
    @Test
    public void testEqualsDifferentObjectSameId() {
        PojoBase pojoBase1 = new PojoBase() {};
        PojoBase pojoBase2 = new PojoBase() {};

        pojoBase1.setId(1);
        pojoBase2.setId(1);

        assertTrue(pojoBase1.equals(pojoBase2));
    }

    @Test
    public void testEqualsDifferentObjectDifferentId() {
        PojoBase pojoBase1 = new PojoBase() {};
        PojoBase pojoBase2 = new PojoBase() {};

        pojoBase1.setId(1);
        pojoBase2.setId(2);

        assertFalse(pojoBase1.equals(pojoBase2));
    }

    @Test
    public void testEqualsNullObject() {
        PojoBase pojoBase = new PojoBase() {};
        assertFalse(pojoBase.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        PojoBase pojoBase = new PojoBase() {};
        assertFalse(pojoBase.equals(new Object()));
    }
}
