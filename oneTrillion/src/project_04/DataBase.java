package project_04;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {
	Connection c;
	Statement stmt;

	public DataBase() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:insideOut.db");
			stmt = c.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS SONGPROGRESS (" + "MUSICTITLE CHAR(50)," + " NORMAL DOUBLE, "
					+ " CHALLENGE DOUBLE)";
			stmt.executeUpdate(sql);

			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM SONGPROGRESS WHERE MUSICTITLE=" + "'Tobu & Itro - Sunburst_Highlight.mp3';");
			if (rs.next() == false) {
				sql = "INSERT INTO SONGPROGRESS VALUES (" + "'Tobu & Itro - Sunburst_Highlight.mp3',0,0)";
				stmt.executeUpdate(sql);
			}

			rs = stmt.executeQuery("SELECT * FROM SONGPROGRESS WHERE MUSICTITLE=" + "'BadNewsHighLight.mp3';");
			if (rs.next() == false) {
				sql = "INSERT INTO SONGPROGRESS VALUES (" + "'BadNewsHighLight.mp3',0,0)";
				stmt.executeUpdate(sql);
			}

			rs = stmt.executeQuery("SELECT * FROM SONGPROGRESS WHERE MUSICTITLE=" + "'HeartBeatHighLight.mp3';");
			if (rs.next() == false) {
				sql = "INSERT INTO SONGPROGRESS VALUES (" + "'HeartBeatHighLight.mp3',0,0)";
				stmt.executeUpdate(sql);
			}

			rs = stmt.executeQuery("SELECT * FROM SONGPROGRESS;");
			while (rs.next()) {
				String musicTitle = rs.getString("MUSICTITLE");
				double normal = rs.getDouble("NORMAL");
				double challenge = rs.getDouble("CHALLENGE");
				System.out.println(musicTitle + " " + normal + " " + challenge);
			}

			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public double searchNormalProgress(String musicTitle) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:insideOut.db");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SONGPROGRESS WHERE MUSICTITLE=" + "'" + musicTitle + "';");
			while (rs.next()) {
				return rs.getDouble("NORMAL");
			}
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public double searchChallengeProgress(String musicTitle) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:insideOut.db");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SONGPROGRESS WHERE MUSICTITLE=" + "'" + musicTitle + "';");
			while (rs.next()) {
				return rs.getDouble("CHALLENGE");
			}
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void updateProgress(String musicTitle, String difficulty, double progress) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:insideOut.db");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SONGPROGRESS WHERE MUSICTITLE=" + "'" + musicTitle + "';");
			while(rs.next()) {
				double temp = rs.getDouble(difficulty);
				if(temp <progress) {
					String sql = "UPDATE SONGPROGRESS SET " + difficulty + "=" + progress + " WHERE "
							+ "MUSICTITLE =" + "'"+ musicTitle +"';";
					stmt.executeUpdate(sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
