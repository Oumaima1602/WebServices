package persistence;

import java.util.List;

import entities.Fuel;
import entities.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DatabaseOperations {
	
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	private static EntityTransaction tr = em.getTransaction();
	
	/*----------- Insert a station -----------*/
	public static Station addStation(String stationName, String stationCity, String stationAddress, List<Fuel> fuels) {
		
		if(!tr.isActive()) {
			tr.begin();
		}
		
		Station station = new Station(stationName, stationCity, stationAddress, fuels);
		System.out.println(station.toString());
		em.persist(station);
		tr.commit();
		return station;
	}
	
	/*----------- Get all stations -----------*/
	@SuppressWarnings("unchecked")
	public static List<Station> getAllStations(){
		Query qry = em.createQuery("SELECT s FROM Station s");
		List<Station> stations = qry.getResultList();
		if(stations != null & stations.size() > 0) {
			return stations;
		}else {
			System.out.println("--->null");
			return null;
		}
	}
	
	/*----------- Update a station -----------*/
	public static Station updateStation(Station station) {
		if (!tr.isActive()) {
			tr.begin();
		}
		Query qry = em.createQuery("UPDATE Station s SET s.stationName = :nom, s.stationCity = :ville, s.stationAddress = :adresse s WHERE s.stationId = " +station.getStationId());
		qry.setParameter("nom", station.getStationName());
		qry.setParameter("ville", station.getStationCity());
		qry.setParameter("adresse", station.getStationAddress());
		qry.executeUpdate();
		tr.commit();
		return station;
	}
	
	/*----------- Delete a station -----------*/
	public static void deleteStation(int id) {
		if(!tr.isActive()) {
			tr.begin();
		}
		Station station = em.find(Station.class, id);
		em.remove(station);
		tr.commit();
	}
	
	/*----------- Insert a fuel -----------*/
	public static Fuel addFuel(String fuelName, String fuelDescription, List<Station> histoFuel) {
		
		if(!tr.isActive()) {
			tr.begin();
		}
		
		Fuel fuel = new Fuel(fuelName, fuelDescription, histoFuel);
		System.out.println(fuel.toString());
		em.persist(fuel);
		tr.commit();
		return fuel;
	}
	
	/*----------- Get all fuels -----------*/
	@SuppressWarnings("unchecked")
	public static List<Fuel> getAllFuels(){
		Query qry = em.createQuery("SELECT f FROM Fuel f");
		List<Fuel> fuels = qry.getResultList();
		if(fuels != null & fuels.size() > 0) {
			return fuels;
		}else {
			System.out.println("--->null");
			return null;
		}
	}
	
	/*----------- Update a fuel -----------*/
	public static Fuel updateFuel(Fuel fuel) {
		if (!tr.isActive()) {
			tr.begin();
		}
		Query qry = em.createQuery("UPDATE Fuel f SET f.fuelName = :nom, f.fuelDescription = :description f WHERE f.fuelId = " +fuel.getFuelId());
		qry.setParameter("nom", fuel.getFuelName());
		qry.setParameter("description", fuel.getFuelDescription());
		qry.executeUpdate();
		tr.commit();
		return fuel;
	}
	
	/*----------- Delete a station -----------*/
	public static void deleteFuel(int id) {
		if(!tr.isActive()) {
			tr.begin();
		}
		Fuel fuel = em.find(Fuel.class, id);
		em.remove(fuel);
		tr.commit();
	}

}
