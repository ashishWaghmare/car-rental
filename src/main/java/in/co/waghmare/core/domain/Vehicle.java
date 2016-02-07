package in.co.waghmare.core.domain;

/**
 * Created by ashishw on 7/2/16.
 */
public class Vehicle {

    private Model model;
    private FUEL_TYPE fuelType;
    private boolean isAC;
    private Passengers maxCapacity;

    Vehicle fuelType(FUEL_TYPE type) {
        this.fuelType = type;
        return this;
    }

    Vehicle ac(boolean value) {
        this.isAC = value;
        return this;
    }

    public static Vehicle ofModel(String modelName) {
        switch (modelName.toUpperCase()) {
            case "SWIFT":
                Vehicle vehicle = new Vehicle();
                vehicle.maxCapacity = Passengers.size(4);
                return vehicle;
        }
    }

    public FUEL_TYPE getFuelType() {
        return fuelType;
    }

    public boolean isAC() {
        return isAC;
    }

    public Passengers getMaxCapacity() {
        return maxCapacity;
    }

    public Model getModel() {
        return model;
    }

    public enum Model {
        //A vehicle can be rented for a trip. Vehicle can be a SUV, car, van, bus, etc.
        SUV,
        Car,
        Van,
        Bus;
    }
}
