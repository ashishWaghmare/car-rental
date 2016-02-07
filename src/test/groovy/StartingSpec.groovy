import in.co.waghmare.core.domain.Vehicle
import in.co.waghmare.core.domain.Trip
import in.co.waghmare.core.domain.Passengers
import in.co.waghmare.core.domain.*
import in.co.waghmare.core.services.ExpenseService
import in.co.waghmare.integration.ExpenseServiceImpl
import spock.lang.Specification

class StartingSpec extends Specification {


    def "Swift, Diesel, NON AC, Pune-Mumbai-Bangalore-Pune, 3 Passengers"() {
        given:
        ExpenseService expenseService = new ExpenseServiceImpl();
        Passengers passengers = Passengers.size(3);
        Vehicle veh = Vehicle.ofModel("Swift").fuelType(FUEL_TYPE.DIESEL).ac(false);
        Trip trip = new Trip(passengers, veh);
        when:
        trip.startsAt(Location.pune).
                goes(Location.mumbai).
                goes(Location.bangalore).
                endsAt(Location.pune);
        Money tripExpense = expenseService.calculate(trip);
        then: "Pune-Mumbai-Bangalore-Pune > 200+ 1200 +1000 =2400 * 14"
        tripExpense.majorValue == 2400 * 14

    }
}