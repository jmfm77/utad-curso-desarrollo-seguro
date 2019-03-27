package com.utad.curso.desarrollo.seguro.config.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration // para que se guarde la clase en el contexto y al preguntar por
				// userdetailservide le de esta
public class CustomUserDetailsService implements UserDetailsService {

	private String dbUrl = "jdbc:mysql://127.0.0.1:3306/curso-desarrollo-seguro?allowMultiQueries=true&autoReconnect=true&useSSL=false&characterEncoding=UTF-8";

	// private String dbUsername = " curso-desarrollo-seguro";

	// private String dbPassword =
	// "YMGPHSc93WhKhek5E3Sv6gVECZ4kP3NZa6AYbyjWpXURUHgjcG5pvYqYfSBbAAJ8YZBa6tNKcMscnXArhL2xftjqr53LqaHe7FJGzhpPa22vxSzKjcATTYtaqsm552as";

	@Value("${dbusername}")
	private String dbUsername;

	@Value("${dbPassword}")
	private String dbPassword;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		String query = String.format("select * from users where username = '%s';", username);

		logger.info("usuarioBD:" + dbUsername);
		logger.info("passwordBD:" + dbPassword);

		logger.info("query:" + query);

		try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			if (resultSet.next()) {
				return new org.springframework.security.core.userdetails.User(username, resultSet.getString("password"),
						Arrays.asList(new SimpleGrantedAuthority(resultSet.getString("role"))));
			}

		} catch (SQLException e) {
			throw new UsernameNotFoundException("");
		}

		throw new UsernameNotFoundException("");

	}

}
