package in.co.waghmare.core.services;

import in.co.waghmare.core.domain.Location;
import in.co.waghmare.core.domain.Trip;

/**
 * Created by ashishw on 7/2/16.
 */
public interface DistanceService {

    double distance(Trip trip);
    double distance(Location source,Location destination);
}
