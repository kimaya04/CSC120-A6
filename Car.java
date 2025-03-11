import java.util.ArrayList;

public class Car implements CarRequirements{

    // Attributes
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Constructor for Car object
     * @param capacity maximum passenger capacity of Car
     */
    public Car(int capacity) {
        this.maxCapacity = capacity;
        passengersOnboard = new ArrayList<Passenger>(capacity);
    }

    /**
     * Getter for maximum capacity of Car
     * @return maximum capacity of Car
     */
    public int getCapacity(){
        return maxCapacity;
    }

    /**
     * Calculates remaining seats in Car
     * Checks if there are passengers on board and returns remaining seats accordingly
     * @return number of remaining seats in Car
     */
    public int seatsRemaining(){
        if (passengersOnboard.size()>0){
            return (maxCapacity - passengersOnboard.size());
        }
        return maxCapacity;
    }

    /**
     * Adds Passenger to Car
     * Checks if there are remaining seats in Car
     * If yes, adds Passenger to Car 
     * @param p Passenger to add
     * @return true if Passenger is added, false if not
     */
    public Boolean addPassenger(Passenger p){
        if (seatsRemaining()>0){
            passengersOnboard.add(p);
            return true;
        }
        return false;
    }

    /**
     * Removes Passenger from Car
     * Checks if Passenger is on board
     * If yes, removes Passenger from Car
     * @param p Passenger to remove
     * @return true if Passenger is removed, false if not
     */
    public Boolean removePassenger(Passenger p){
        if (passengersOnboard.contains(p)){
            passengersOnboard.remove(p);
            return true;
        }
        return false;
    }

    /**
     * Prints list of passengers on Car
     * If Car is empty, prints "This car is EMPTY."
     * Otherwise, prints passenger list for Car
     */
    public void printManifest(){
        if (seatsRemaining()==maxCapacity){
            System.out.println("This car is EMPTY.");
        }
        else{
    //        System.out.println("Passengers on board:");
            for (int i=0; i<maxCapacity; i++){
                if (passengersOnboard.get(i)!=null){
                    System.out.println(passengersOnboard.get(i).getName());
                }
            }
            System.out.println();
        }
    }

}