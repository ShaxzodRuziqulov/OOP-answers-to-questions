package train.gpt;
import java.util.ArrayList;
import java.util.List;

// Train sinfi
class Train {
    private String name;
    private List<Station> route;

    public Train(String name) {
        this.name = name;
        this.route = new ArrayList<>();
    }

    public void addStation(Station station) {
        route.add(station);
    }

    public List<Station> getRoute() {
        return route;
    }

    public String getName() {
        return name;
    }
}

// Station sinfi
class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Schedule sinfi
class Schedule {
    private List<Train> trains;

    public Schedule() {
        this.trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }
}

public class Main {
    public static void main(String[] args) {
        // Jadval yaratish
        Schedule schedule = new Schedule();

        // Poezdlar yaratish
        Train train1 = new Train("Train 1");
        Train train2 = new Train("Train 2");

        // Stantsiyalar yaratish
        Station station1 = new Station("Station A");
        Station station2 = new Station("Station B");
        Station station3 = new Station("Station C");

        // Stantsiyalarni poezdlarga qo'shish
        train1.addStation(station1);
        train1.addStation(station2);
        train1.addStation(station3);

        train2.addStation(station3);
        train2.addStation(station2);
        train2.addStation(station1);

        // Poezdlarni jadvalga qo'shish
        schedule.addTrain(train1);
        schedule.addTrain(train2);

        // Jadvalni chiqarish
        List<Train> trains = schedule.getTrains();
        for (Train train : trains) {
            System.out.println("Train name: " + train.getName());
            List<Station> route = train.getRoute();
            System.out.println("Route:");
            for (Station station : route) {
                System.out.println("- " + station.getName());
            }
            System.out.println();
        }
    }
}
