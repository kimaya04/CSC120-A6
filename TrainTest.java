import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class TrainTest {

    // Engine Tests

    Engine e = new Engine(FuelType.STEAM, 5, 10);
    
    @Test
    public void testEngineConstructor() {;
        assertEquals("Testing fuel type", FuelType.STEAM, e.getFuelType());
    }

    @Test
    public void testEngineGo() {
        assertTrue("Testing engine.go()", e.go());
    }

    // Car Tests

    Car c = new Car(2);
    Passenger p = new Passenger("Alice");

    @Test
    public void testCarAddPassenger() {
        assertTrue("Testing car.addPassenger()", c.addPassenger(p));
    }

    @Test(timeout = 2000)
    public void testCarRemovePassenger() {
        c.addPassenger(p);
        assertTrue("Testing car.removePassenger()", c.removePassenger(p));
    }

    // Passenger Tests

    Passenger p2 = new Passenger("RyAnne");
    Passenger p3 = new Passenger("Casey");

    @Test
    public void testPassengerBoardCarWithSpace() {
        assertTrue("Testing passenger.boardCar() with space", c.addPassenger(p));
    }

    @Test
    public void testPassengerBoardCarFull() {
        c.addPassenger(p);
        c.addPassenger(p2);
        assertFalse("Testing passenger.boardCar() when full", c.addPassenger(p3));
    }

    // Train Tests

    Train t = new Train(FuelType.STEAM, 5, 10, 2, 1);

    @Test
    public void testTrainConstructor() {
        int count = 0;
        while (count < 2){
            assertNotNull("Testing train car initialization", t.getCar(count));
            count++;
        }
    }

    @Test
    public void testTrainPassengerCount() {
        t.getCar(0).addPassenger(p);
        assertNotSame("Testing train passenger count", t.getMaxCapacity(), t.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Car testCar = new Car(1);
        t.addCar(testCar);
        assertEquals("Testing train.getCar()", testCar, t.getCar(2));
    }

    @Test
    public void testTrainPrintManifest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        t.getCar(0).addPassenger(p);
        t.getCar(1).addPassenger(p2);
        t.printManifest();
        System.setOut(originalOut);
        String expected = "Passengers on board this train:\n" + p.getName() + "\n\n" + p2.getName() + "\n\n";
        assertEquals("Testing train.printManifest()", expected, outContent.toString());
    }
    
}
