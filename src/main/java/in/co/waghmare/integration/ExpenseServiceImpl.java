package in.co.waghmare.integration;

import in.co.waghmare.core.domain.Money;
import in.co.waghmare.core.domain.Rate;
import in.co.waghmare.core.domain.Trip;
import in.co.waghmare.core.services.DistanceService;
import in.co.waghmare.core.services.ExpenseService;
import in.co.waghmare.core.services.RateService;

/**
 * Created by ashishw on 7/2/16.
 */
public class ExpenseServiceImpl implements ExpenseService {

    DistanceService distanceService = new DistanceServiceImpl();

    RateService rateService = new RateServiceImpl();

    @Override
    public Money calculate(Trip trip) {
        double finaldistance = distanceService.distance(trip);
        Rate rate = rateService.calculate(trip);
        int perKm = rate.getValue();
        double rupees = finaldistance * rate.getValue();
        //TODO return new Money(new Money()),);
        return new Money("rupees", (int) rupees);
    }
}
