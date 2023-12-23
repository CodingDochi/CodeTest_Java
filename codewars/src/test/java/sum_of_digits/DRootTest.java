package sum_of_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DRootTest {

    @Test
    public void test1() {
        assertEquals(7, 7, DRoot.digital_root(16));
        assertEquals(6, 6, DRoot.digital_root(456));
    }

}