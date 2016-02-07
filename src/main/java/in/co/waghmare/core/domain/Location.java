package in.co.waghmare.core.domain;

/**
 * Created by ashishw on 7/2/16.
 */
public class Location implements Comparable<Location> {

    private final String name;
    private Location(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Location o) {
        return this.name.compareTo(o.name);
    }

    public static Location pune = new Location("PUNE");
    public static Location bangalore = new Location("BANGALORE");
    public static Location mumbai = new Location("MUMBAI");
    public static Location delhi = new Location("DELHI");
    public static Location chennai = new Location("CHENNAI");
}
