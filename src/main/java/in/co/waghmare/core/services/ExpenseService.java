package in.co.waghmare.core.services;

import in.co.waghmare.core.domain.Money;
import in.co.waghmare.core.domain.Trip;

/**
 * Created by ashishw on 7/2/16.
 */
public interface ExpenseService {

    Money calculate(Trip trip);
}
