package in.co.waghmare.integration;

import in.co.waghmare.core.domain.Location;
import in.co.waghmare.core.domain.Trip;
import in.co.waghmare.core.services.DistanceService;

import java.util.List;

/**
 * Created by ashishw on 7/2/16.
 */
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double distance(Trip trip) {
        List<Location> hops = trip.getHops();
        double finalDistance = 0;
        for (int i = 0; i < hops.size() - 1; i++) {
            finalDistance = finalDistance + distance(hops.get(i), hops.get(i + 1));
        }
        return finalDistance;
    }

    @Override
    public double distance(Location source, Location destination) {
        //order it
        if (source.compareTo(destination) > 1) {
            Location temp = source;
            source = destination;
            destination = temp;
        }

        if (source == Location.bangalore && destination == Location.pune) {
            return 1000.0;
        }
        if (source == Location.mumbai && destination == Location.pune) {
            return 200.0;
        }
        if (source == Location.bangalore && destination == Location.mumbai) {
            return 1200.0;
        }
        if (source == Location.delhi && destination == Location.mumbai) {
            return 1000.0;
        }
        if (source == Location.mumbai && destination == Location.chennai) {
            return 1234.5;
        }

        //TODO - throw illegal argument if zero
        return 0;
    }
}
