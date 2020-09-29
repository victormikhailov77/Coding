package coding.reservation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneSeatReservationTest {

    @Test
    public void shouldReserveContinuousDtoG() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(1, s.countGroupReservations(1, "1J 1C"));
    }

    @Test
    public void shouldReserveAcrossIsleBtoE() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(1, s.countGroupReservations(1, "1A 1F"));
    }

    @Test
    public void shouldReserveAcrossIsleFtoG() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(1, s.countGroupReservations(1, "1D 1E"));
    }

    @Test
    public void shouldReserve2GroupsAcrossIsle() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(2, s.countGroupReservations(1, "1A 1K"));
    }

    @Test
    public void shouldReserveWholeRow() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(2, s.countGroupReservations(1, ""));
    }

    @Test
    public void shouldReserveWholeRowMulty() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(10, s.countGroupReservations(5, ""));
    }

    @Test
    public void shouldReserveMultiRows() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(5, s.countGroupReservations(4, "1A 2D 2G 4C 4K"));
    }

    @Test
    public void shouldReserveNothing() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(0, s.countGroupReservations(1, "1A 1B 1C 1D 1E 1F 1G 1H 1J 1K"));
    }

    @Test
    public void shouldReserveNothingMultiRows() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        assertEquals(0, s.countGroupReservations(3, "1C 1E 1J 2B 2F 2G 3D 3G"));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowErrorInvalidFormat() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        s.countGroupReservations(1, "NO SEAT 1");
    }

    @Test
    public void shouldReserveAcrossIsleOrMiddle() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        s.countGroupReservations(1, "1K");
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowErrorInvalidSeatCode() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        s.countGroupReservations(1, "1M 2Q");
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowErrorInvalidRowCount() {
        PlaneSeatReservation s = new PlaneSeatReservation();
        s.countGroupReservations(101, "1M 2Q");
    }

}