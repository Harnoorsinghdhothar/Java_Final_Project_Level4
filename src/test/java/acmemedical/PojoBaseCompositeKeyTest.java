package acmemedical.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Objects;

// Class to represent a test composite key
class TestCompositeKey implements Serializable {
    private String part1;
    private String part2;

    public TestCompositeKey(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(part1, part2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestCompositeKey other = (TestCompositeKey) obj;
        return Objects.equals(part1, other.part1) && Objects.equals(part2, other.part2);
    }
}

// Subclass to test PojoBaseCompositeKey
class PojoBaseCompositeKeyTestEntity extends PojoBaseCompositeKey<TestCompositeKey> {
    private TestCompositeKey id;

    @Override
    public TestCompositeKey getId() {
        return id;
    }

    @Override
    public void setId(TestCompositeKey id) {
        this.id = id;
    }
}

public class PojoBaseCompositeKeyTest {

  
    

    @Test
    public void testEqualsDifferentObjectSameKey() {
        PojoBaseCompositeKeyTestEntity entity1 = new PojoBaseCompositeKeyTestEntity();
        PojoBaseCompositeKeyTestEntity entity2 = new PojoBaseCompositeKeyTestEntity();

        TestCompositeKey compositeKey = new TestCompositeKey("Part1", "Part2");

        entity1.setId(compositeKey);
        entity2.setId(compositeKey);

        assertTrue(entity1.equals(entity2));
    }

    @Test
    public void testEqualsDifferentObjectDifferentKey() {
        PojoBaseCompositeKeyTestEntity entity1 = new PojoBaseCompositeKeyTestEntity();
        PojoBaseCompositeKeyTestEntity entity2 = new PojoBaseCompositeKeyTestEntity();

        entity1.setId(new TestCompositeKey("Part1", "Part2"));
        entity2.setId(new TestCompositeKey("Part3", "Part4"));

        assertFalse(entity1.equals(entity2));
    }

    @Test
    public void testEqualsNullObject() {
        PojoBaseCompositeKeyTestEntity entity = new PojoBaseCompositeKeyTestEntity();
        assertFalse(entity.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        PojoBaseCompositeKeyTestEntity entity = new PojoBaseCompositeKeyTestEntity();
        assertFalse(entity.equals(new Object()));
    }
}
