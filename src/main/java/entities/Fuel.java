package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carburant")
public class Fuel {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long fuelId;
	
	@Column(name = "nom")
	private String fuelName;
	
	@Column(name = "description")
	private String fuelDescription;
	
	@ManyToMany
	@JoinTable(
			name = "fuel_station",
			joinColumns = @JoinColumn(name = "fuelId"),
			inverseJoinColumns = @JoinColumn(name = "stationId")
			)
	List<Station> histoFuel;

	public Fuel() {
		super();
		//TODO Auto-generated constructor stub
	}


	public Fuel(String fuelName, String fuelDescription, List<Station> histoFuel) {
		super();
		this.fuelName = fuelName;
		this.fuelDescription = fuelDescription;
		this.histoFuel = histoFuel;
	}



	public Long getFuelId() {
		return fuelId;
	}

	public void setFuelId(Long fuelId) {
		this.fuelId = fuelId;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	public String getFuelDescription() {
		return fuelDescription;
	}

	public void setFuelDescription(String fuelDescription) {
		this.fuelDescription = fuelDescription;
	}
	
}
