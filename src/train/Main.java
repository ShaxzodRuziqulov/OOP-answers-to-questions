package train;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

record Station(String name){
}
class Train{
    private String name;
    private List<Station> route;

    public Train(String name) {
        this.name = name;
        this.route = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station){
        route.add(station);
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Station> getRoute() {
        return route;
    }

    public void setRoute(List<Station> route) {
        this.route = route;
    }
}
class Schedule {
    private List<Train>trains;

    public Schedule() {
        this.trains = new ArrayList<>();
    }
    public void addTrain(Train train){
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Jadval yaratish
        Schedule schedule = new Schedule();

        // Poezdlar yaratish
        Train train1 = new Train("Train 1");
        Train train2 = new Train("Train 2");

        // Stantsiyalar yaratish
        System.out.println("Stansiya nomini kiriting");
        String stationScan1 = scanner.next();
        Station station1 = new Station(stationScan1);

        String stationScan = scanner.next();
        Station station2 = new Station(stationScan);

        String stationScan2 = scanner.next();
        Station station3 = new Station(stationScan2);


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

        List<Train> trains = schedule.getTrains();
        for (Train train4 : trains) {
            System.out.println("Train name: " + train4.getName());
            List<Station> route = train4.getRoute();
            System.out.println("Route:");
            for (Station station4 : route) {
                System.out.println("- " + station4.name());
            }
            System.out.println();
        }
    }
}
