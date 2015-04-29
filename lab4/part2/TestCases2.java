import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCases2
{
    private static final double DELTA = 0.00001;
    private Point pt = new CartesianPoint(3.0, 4.0);
    private Point pt2 = new PolarPoint(1.0, Math.PI/4);
    private Point pt3 = new CartesianPoint(0.0, 0.0);
    private Point pt4 = new PolarPoint(0.0, Math.PI);

    @Test
    public void testCartesianX()
    {
        assertEquals(3.0, pt.xCoordinate(), DELTA);
    }

    @Test
    public void testCartesianY()
    {
        assertEquals(4.0, pt.yCoordinate(), DELTA);
    }

    @Test
    public void testCartesianRadius()
    {
        assertEquals(5.0, pt.radius(), DELTA);
    }

    @Test
    public void testCartesianAngle()
    {
        assertEquals(0.927293432, pt.angle(), DELTA);
    }

    @Test
    public void testCartesianRotate90()
    {
        CartesianPoint test = new CartesianPoint(-4.0, 3.0);
        assertEquals(test.xCoordinate(), pt.rotate90().xCoordinate(), DELTA);
        assertEquals(test.yCoordinate(), pt.rotate90().yCoordinate(), DELTA);
    }

    @Test
    public void testPolarX()
    {
        assertEquals(Math.sqrt(2)/2, pt2.xCoordinate(), DELTA);
    }

    @Test
    public void testPolarY()
    {
        assertEquals(Math.sqrt(2)/2, pt2.yCoordinate(), DELTA);
    }

    @Test
    public void testPolarRadius()
    {
        assertEquals(1.0, pt2.radius(), DELTA);
    }

    @Test
    public void testPolarAngle()
    {
        assertEquals(Math.PI/4, pt2.angle(), DELTA);
    }

    @Test
    public void testPolarRotate90()
    {
        PolarPoint test = new PolarPoint(1.0, Math.PI * 3 / 4);
        assertEquals(test.xCoordinate(), pt2.rotate90().xCoordinate(), DELTA);
        assertEquals(test.yCoordinate(), pt2.rotate90().yCoordinate(), DELTA);
    }

    @Test
    public void testCartesianZero() {
        assertEquals(0.0, pt3.radius(), DELTA);
        assertEquals(0.0, pt3.angle(), DELTA);
    }

    @Test
    public void testPolarZero() {
        assertEquals(0.0, pt4.xCoordinate(), DELTA);
        assertEquals(0.0, pt4.yCoordinate(), DELTA);
    }
}
