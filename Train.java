import java.util.ArrayList;

public class Train implements TrainRequirements{

    // Attributes
    private Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructor for Train object
     * @param FuelType fuel type used by Engine
     * @param currentFuelLevel current fuel level of Engine
     * @param fuelCapacity maximum fuel capacity of Engine
     * @param nCars number of cars in Train
     * @param passengerCapacity maximum passenger capacity of each Car
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity, currentFuelLevel);
        cars = new ArrayList<Car>();
        for (int i=0; i<nCars; i++){
            Car c = new Car(passengerCapacity);
            cars.add(c);
        }
    }
    
    /**
     * Getter for Engine object
     * @return Engine object of Train
     */
    public Engine getEngine(){
        return engine;
    }

    /**
     * Getter for Car object
     * @param i index of Car object in cars ArrayList
     * @return Car object at index i
     */
    public Car getCar(int i){
        return cars.get(i);
    }

    public void addCar(Car c){
        cars.add(c);
    }

    /**
     * Calculates maximum capacity of Train.
     * Checks capacity of each Car and sums them up.
     * @return total capacity of all cars in Train
     */
    public int getMaxCapacity(){
        int total=0;
        for (int i=0; i<cars.size(); i++){
            total += cars.get(i).getCapacity();
        }
        return total;
    }

    /**
     * Calculates remaining seats in Train.
     * Checks remaining seats in each Car and sums them up.
     * @return total remaining seats in all cars in Train
     */
    public int seatsRemaining(){
        int seats = 0;
        for (int i=0; i<cars.size(); i++){
            seats += cars.get(i).seatsRemaining();
        }
        return seats;
    }

    /**
     * Prints list of passengers on Train.
     * If Train is empty, prints "This train is EMPTY."
     * Otherwise, prints passenger list for each Car.
     */
    public void printManifest(){
        if (seatsRemaining()==getMaxCapacity()){
            System.out.println("This train is EMPTY.");
        }
        else{
            System.out.println("Passengers on board this train:");
            for (int i=0; i<cars.size(); i++){
             //   System.out.println("CAR " + (i+1));
               // System.out.println("----------");
                cars.get(i).printManifest();
            }
        }
    }
        
}
