package com.kronempire.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(GameApplication.class, args);
		DataSource ds = context.getBean(DataSource.class);
		Connection con = null;
		try {
			con = ds.getConnection();
			System.out.println("Connection OK!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
