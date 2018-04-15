package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.Collection;

public class TripManager {

	private Collection<Trip> trips;

	public Collection<Trip> getTrips() {
		return trips;
	}

	public void addTrip(Trip trip) {

		if (trips == null) {
			trips = new ArrayList<>();
		}
		trips.add(trip);
	}

	public void removeTrip(Trip trip) {

		trips.remove(trip);
		if (trips.size() == 0) {
			trips = null;
		}
	}

	public Collection<Trip> findTrip(String keyword) {

		Collection<Trip> foundedTrips = new ArrayList<>();

		for (Trip trip : trips) {
			String name_and_description = (trip.name() + " " + trip.description()).toLowerCase();
			if (name_and_description.contains(keyword.toLowerCase())) {
				foundedTrips.add(trip);
			}
		}
		return foundedTrips;
	}

}
