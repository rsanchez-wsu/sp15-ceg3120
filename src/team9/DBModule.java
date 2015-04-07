package team9;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public class DBModule {
	
	//Prepared statements
	private static final String queryMostWins = "";
	private static final String queryMostKills = "";
	private static final String queryMostDeaths = "";
	private static final String queryMostAccurate = "";
	private static final String queryMostDamaging = "";
	private static final String queryAvgDuration = "";
	private static final String queryShortestGame = "";
	private static final String queryLongestGame = "";

	public void createTables() throws SQLException, IOException
	{
		try (Connection conn = getConnection())
		{
			Statement stat = conn.createStatement();
			
			stat.executeUpdate("CREATE TABLE Games(uuid CHAR(20), startTime DATE, stopTime DATE, serverListenAddr CHAR(15), serverPort INT)");
			stat.executeUpdate("CREATE TABLE Clients(playerName CHAR(20), uuid CHAR(20), playerID INT, clientIP CHAR(15), clientConnectTime DATE, clientDisconnect DATE)");
			stat.executeUpdate("CREATE TABLE Commands(uuid CHAR(20), seqNum INT, command CHAR(15), activePlayerID INT)");
			stat.executeUpdate("CREATE TABLE Status(uuid CHAR(20), seqNum INT, PlayerID INT, positionX INT, positionY INT, health INT, status INT)");
			
		}
	}
	
	
	
	public static Connection getConnection() throws SQLException, IOException{
		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("database.properties")))
		{
			props.load(in);
		}
		
		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null) System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
}
