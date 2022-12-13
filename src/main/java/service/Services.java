package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Station;

public class Services {
	
	Connection conn;
	
	public Services() throws ClassNotFoundException, SQLException{
		String url = String.format("jdbc:mysql://localhost:3306/webservices");
		String username = "root";
		String password = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,username,password);
	}
	
	public Station insertStation(Station station) {
		String query = "insert into station(nom,ville,adresse) values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, station.getStationName());
			ps.setString(2, station.getStationCity());
			ps.setString(3, station.getStationAddress());
			ps.execute();
		}catch(Exception e) {
			System.out.println(e+" data insert unsuccess");
		}
		return station;
	}

}
