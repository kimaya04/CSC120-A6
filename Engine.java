public class Engine implements EngineRequirements{

    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor for Engine object
     * @param fuelType type of fuel used by Engine
     * @param currentFuel current fuel level of Engine
     * @param maxFuel maximum fuel capacity of Engine
     */
    public Engine(FuelType fuelType, double currentFuel, double maxFuel){
        this.f = fuelType;
        this.maxFuelLevel = maxFuel;
        this.currentFuelLevel = currentFuel;
    }

    /**
     * Getter for FuelType of Engine
     * @return FuelType of Engine
     */
    public FuelType getFuelType(){
        return f;
    }

    /**
     * Getter for maximum fuel capacity of Engine
     * @return maximum fuel capacity of Engine
     */
    public double getMaxFuel(){
        return maxFuelLevel;
    }

    /**
     * Getter for current fuel level of Engine
     * @return current fuel level of Engine
     */
    public double getCurrentFuel(){
        return currentFuelLevel;
    }

    /**
     * Refuels Engine to maximum fuel capacity
     */
    public void refuel(){
        currentFuelLevel = maxFuelLevel;
    }

    /**
     * Starts Engine
     * Checks if there is enough fuel to start Engine
     * If yes, prints message that Engine is starting and decreases fuel level by 5
     * @return true if Engine starts, false if not
     */
    public Boolean go(){
        if(currentFuelLevel > 0){
            System.out.println("Fuel level: " + currentFuelLevel + ", starting engine now.");
            currentFuelLevel -= 1;
            return true;
        }
        return false;
    }

}