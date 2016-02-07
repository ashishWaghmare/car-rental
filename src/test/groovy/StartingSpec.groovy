import in.co.waghmare.core.domain.Vehicle
import in.co.waghmare.core.domain.Trip
import in.co.waghmare.core.domain.Passengers
import in.co.waghmare.core.domain.*
import spock.lang.Specification

class StartingSpec extends Specification {

    @Autowired

    def "Swift, Diesel, NON AC, Pune-Mumbai-Bangalore-Pune, 3 Passengers"() {
        given:
        Passengers passengers = Passengers.size(3);
        Vehicle veh = Vehicle.ofModel("Swift").fuelType(FUEL_TYPE.DIESEL).ac(false);
        Trip trip = new Trip(passengers, veh);
        when:
        trip.startsAt(Location.pune).
                goes(Location.mumbai).
                goes(Location.bangalore).
                endsAt(Location.pune);
        then:
        Rates.calculate(trip);
    }
}