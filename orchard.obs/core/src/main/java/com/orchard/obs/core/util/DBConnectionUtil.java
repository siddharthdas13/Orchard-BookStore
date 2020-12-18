package com.orchard.obs.core.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;

@Component(immediate = true, service = DBConnectionUtil.class)

public class DBConnectionUtil {
	private Logger logger = LoggerFactory.getLogger(DBConnectionUtil.class);
	@Reference
	DataSourcePool source;
	/**
	 * 
	 * @param dataSourceName	name of dataSource to connect to DataBase
	 * @return					connection object 
	 */
	public Connection getConnection(String dataSourceName) {
		DataSource dataSource = null;
		Connection connection = null;
		try {
			logger.error("Inside Connection , Source Is {}", source);
			dataSource = (DataSource) source.getDataSource(dataSourceName);
			connection = dataSource.getConnection();
		} catch (Exception e) {
			logger.error("Error Occured While Establishing The Connection : " + e);
		}
		return connection;
	}

	public void closeResource(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeResource(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeResource(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeResource(ResultSet res) {
		try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
