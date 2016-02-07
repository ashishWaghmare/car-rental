package in.co.waghmare.integration;

import in.co.waghmare.core.domain.*;
import in.co.waghmare.core.services.RateService;

/**
 * Created by ashishw on 7/2/16.
 */
public class RateServiceImpl implements RateService {
    @Override
    public Rate calculate(Trip trip) {

        Rate rate = null;

        Vehicle vehicle = trip.getVehicle();
        //The standard rate for a petrol vehicle for a standard trip is 15 Rs/Km
        if (vehicle.getFuelType() == FUEL_TYPE.PETROL) {
            rate = Rate.rupeesPerKilometer(15);
        }

        //Diesel vehicles cost a rupee less than standard rate.
        if (vehicle.getFuelType() == FUEL_TYPE.DIESEL) {
            rate = Rate.rupeesPerKilometer(14);
        }

        // 2% discount is applicable for bus on standard rate.
        if (vehicle.getModel() == Vehicle.Model.Bus) {
            rate = Rate.rupeesPerKilometer(98 / 100 * rate.getValue());
        }
        //. Additional 2 Rs/Km charge is applicable for AC vehicles.
        if (vehicle.isAC()) {
            rate = rate.add(2);
        }

        //Additional charges of 1 Rs/Km/Person are charged if number of passengers exceeds the max limit of a
        //vehicle.
        Passengers additional = trip.getPassengers().minus(vehicle.getMaxCapacity());
        if (additional.getSize() > 0) {
            rate = rate.add(additional.getSize() * 1);
        }
        return rate;
    }
}
