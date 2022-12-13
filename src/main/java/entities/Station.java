package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Table
@Entity
public class Station {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long stationId;
	
	@Column(name = "nom")
	private String stationName;
	
	@Column(name = "ville")
	private String stationCity;
	
	@Column(name = "adresse")
	private String stationAddress;
	
	@ManyToMany(mappedBy = "histoFuel")
	List<Fuel> fuels;

	public Station() {
		super();
		//TODO Auto-generated constructor stub
	}


	public Station(String stationName, String stationCity, String stationAddress, List<Fuel> fuels) {
		super();
		this.stationName = stationName;
		this.stationCity = stationCity;
		this.stationAddress = stationAddress;
		this.fuels = fuels;
	}



	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", stationName=" + stationName + ", stationCity=" + stationCity
				+ ", stationAddress=" + stationAddress + ", fuels=" + fuels + "]";
	}


	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationCity() {
		return stationCity;
	}

	public void setStationCity(String stationCity) {
		this.stationCity = stationCity;
	}

	public String getStationAddress() {
		return stationAddress;
	}

	public void setStationAddress(String stationAddress) {
		this.stationAddress = stationAddress;
	}

}
