import in.co.waghmare.core.domain.Vehicle
import in.co.waghmare.core.domain.Trip
import in.co.waghmare.core.domain.Passengers
import spock.lang.Specification

class StartingSpec extends Specification {

    def "Swift, Diesel, NON AC, Pune-Mumbai-Bangalore-Pune, 3 Passengers"() {
        given:
                Passengers = Passengers.size(3);
                Vehicle veh=Vehicle.ofModel("Swift").fuelType("Diesel").ac(false);

               Trip.
                       startsAt(Location.pune).
                       goes(Location.mumbai).
                       goes(Location.bangalore).
                       endsAt(Location.pune).
                       with(passenger3).
                       using(veh);

        when:
        then:
    }
}