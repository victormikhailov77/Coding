package coding.maxsibling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSiblingNumberTest {

    @Test
    public void shouldReturnMaxSibling() {
        MaxSiblingNumber s = new MaxSiblingNumber();
        assertEquals(63211, s.findMaxSibling(12361));
    }

    @Test
    public void shouldReturnMaxSiblingBig() {
        MaxSiblingNumber s = new MaxSiblingNumber();
        assertEquals(9744322, s.findMaxSibling(4273429));
    }

    @Test
    public void shouldReturnItselfForZero() {
        MaxSiblingNumber s = new MaxSiblingNumber();
        assertEquals(0, s.findMaxSibling(0));
    }

    @Test
    public void shouldReturnErrorForNegative() {
        MaxSiblingNumber s = new MaxSiblingNumber();
        assertEquals(-1, s.findMaxSibling(-1));
    }

    @Test
    public void shouldReturnErrorForExceededMax() {
        MaxSiblingNumber s = new MaxSiblingNumber();
        assertEquals(-1, s.findMaxSibling(100000000));
    }
}