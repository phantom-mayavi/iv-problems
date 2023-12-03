import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

public class FlightTracker {
    public static void main(String[] args) {
        List<Flight> flights = asList(
                new Flight(367, 4, 45),
                new Flight(357, 4, 45),
                new Flight(377, 4, 48),
                new Flight(255, 4, 73)
        );

//        Collections.sort(flights);

//        flights.forEach(System.out::println);
        flights.sort(new FlightComparator());
        flights.forEach(System.out::println);

        for (int i = 0; i < flights.size(); i++) {
            System.out.println("Flight " + flights.get(i).flightNo + " lands at " + flights.get(i).landingRequestTime);
            if (i+1 < flights.size()) {
                List<Flight> delayedFlights = getDelayedFlights(flights.subList(i + 1, flights.size()),
                        flights.get(i).landingRequestTime + flights.get(i).landingTime + 1);
                delayedFlights
                        .forEach(flight -> System.out.println("Flight " + flight.flightNo
                                + " delayed, updated ETA " + flight.landingRequestTime));
            }

        }
    }

    private static List<Flight> getDelayedFlights(List<Flight> flightsToCheck, int runwayAvailableTime) {
        List<Flight> delayedFlights = new ArrayList<>();
        if (nonNull(flightsToCheck) && flightsToCheck.size() > 0) {
            flightsToCheck.forEach(flight -> {
                if (flight.landingRequestTime < runwayAvailableTime) {
                    flight.landingRequestTime += 10;
                    delayedFlights.add(flight);
                }
            });
        }

        return delayedFlights;
    }


}

class Flight implements Comparable<Flight> {
    int flightNo;
    int landingTime;
    int landingRequestTime;

    public Flight(int flightNo, int landingTime, int landingRequestTime) {
        this.flightNo =flightNo;
        this.landingTime = landingTime;
        this.landingRequestTime = landingRequestTime;
    }

    public String toString() {

        return " flightNo : " + this.flightNo + ", landingTime : " + this.landingTime
                + ", landingRequestTime : " + this.landingRequestTime;
    }

    @Override
    public int compareTo(Flight f1) {
        if (f1.landingRequestTime < this.landingRequestTime) {
            return 1;
        } else if (f1.landingRequestTime > this.landingRequestTime) {
            return -1;
        } else {
            return f1.flightNo < this.flightNo ? 1 : -1;
        }
    }
}

class FlightComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight o1, Flight o2) {
        if (o1.landingRequestTime < o2.landingRequestTime) {
            return -1;
        } else if (o1.landingRequestTime > o2.landingRequestTime) {
            return 1;

        } else {
            return o1.flightNo - o2.flightNo;
        }
    }
}
