public class Passenger implements PassengerRequirements{
    
    //Attribute
    private String name;

    /**
     * Constructor for Passenger object
     * @param name name of Passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Getter for name of Passenger
     * @return name of Passenger
     */
    public String getName(){
        return name;
    }

    /**
     * Allows Passenger to board Car.
     * Checks if Car is able to accommodate Passenger.
     * If yes, prints message that Passenger has boarded.
     * If not, prints message that Car is full.
     * @param c Car car to board
     */
    public void boardCar(Car c){
        if (c.addPassenger(this)){
            System.out.println(this.name + "has boarded.");
        }
        else{
            System.out.println("Car is full.");
        }
    }

    /**
     * Allows Passenger to get off Car.
     * Checks if Passenger is on board.
     * If yes, prints message that Passenger has gotten off.
     * If not, prints message that Passenger was not on board.
     * @param c Car car to get off
     */
    public void getOffCar(Car c){
        if (c.removePassenger(this)){
            System.out.println(this.name + "got off.");
        }
        else{
            System.out.println(this.name + "was not on board.");
        }
    }
}
