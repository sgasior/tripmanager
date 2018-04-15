package pl.edu.agh.mwo;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TripManagerTest {

	private TripManager theTripManager;

	@Before
	public void createEmptyTripManagerForTheTest() {
		theTripManager = new TripManager();
	}

	@Test
	public void testEmptyCollectionOfTripsHaveNullValue() {
		Assert.assertThat(theTripManager.getTrips(), IsNull.nullValue());
	}

	@Test
	public void testNonEmptyCollectionOfPhotosHaveNotNullValue() {
		Trip trip = new Trip("Rok akademicki 17/18", "Studia");
		theTripManager.addTrip(trip);

		Assert.assertThat(theTripManager.getTrips(), IsNull.notNullValue());
	}

	@Test
	public void testCollectionHaveAddedItems() {

		Trip trip1 = new Trip("Wakacje 2017", "Morze Bałtyckie");
		Trip trip2 = new Trip("Wakacje 2016", "Morze Kaspijskie");

		theTripManager.addTrip(trip1);
		theTripManager.addTrip(trip2);

		assertThat(theTripManager.getTrips(), hasItems(trip1, trip2));
	}

	@Test
	public void testCollectionHaveExpectedSize() {
		Trip trip1 = new Trip("Wakacje 2017", "Morze Bałtyckie");
		Trip trip2 = new Trip("Wakacje 2016", "Morze Kaspijskie");

		theTripManager.addTrip(trip1);
		assertEquals(1, theTripManager.getTrips().size());

		theTripManager.addTrip(trip2);
		assertEquals(2, theTripManager.getTrips().size());

		theTripManager.removeTrip(trip1);
		assertEquals(1, theTripManager.getTrips().size());

	}

	@Test
	public void testCollectionRemovedItem() {

		Trip trip1 = new Trip("Wakacje 2017", "Morze Bałtyckie");
		Trip trip2 = new Trip("Wakacje 2016", "Morze Kaspijskie");

		theTripManager.addTrip(trip1);
		theTripManager.addTrip(trip2);
		theTripManager.removeTrip(trip2);

		assertThat(theTripManager.getTrips(), not(hasItem(trip2)));
	}

	@Test
	public void testCollectionHaveNullReferenceAfterRemovingAllObjects() {
		Trip trip1 = new Trip("Wakacje 2017", "Morze Bałtyckie");
		theTripManager.addTrip(trip1);
		theTripManager.removeTrip(trip1);
		Assert.assertThat(theTripManager.getTrips(), IsNull.nullValue());
	}

	@Test
	public void testCollectionOfFoundedTripsHaveExpectedSize() {

		Trip trip1 = new Trip("Ferie 2017", "Zakopane");
		Trip trip2 = new Trip("Majówka 2017", "Kraków");
		theTripManager.addTrip(trip1);
		theTripManager.addTrip(trip2);

		Collection<Trip> foundTrips = theTripManager.findTrip("Wakacje");
		assertEquals(0, foundTrips.size());

		foundTrips = theTripManager.findTrip("Ferie");
		assertEquals(1, foundTrips.size());

		Trip trip3 = new Trip("Ferie 2018", "Zakopane");
		theTripManager.addTrip(trip3);

		foundTrips = theTripManager.findTrip("Ferie");
		assertEquals(2, foundTrips.size());
	}

	@Test
	public void testFindTripMethodChecksNameAndDescriptionArguments() {
		Trip trip1 = new Trip("Ferie 2017", "Zakopane");
		Trip trip2 = new Trip("Majówka 2017", "Kraków");
		theTripManager.addTrip(trip1);
		theTripManager.addTrip(trip2);

		Collection<Trip> foundTrips = theTripManager.findTrip("Ferie");
		assertEquals(1, foundTrips.size());

		foundTrips = theTripManager.findTrip("Kraków");
		assertEquals(1, foundTrips.size());
	}

}
