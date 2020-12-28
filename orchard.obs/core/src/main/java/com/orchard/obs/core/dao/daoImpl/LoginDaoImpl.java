/**
 * 
 */
package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.osgi.service.component.annotations.Reference;

import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
import com.orchard.obs.Exceptions.daoexceptions.LoginDaoException;
import com.orchard.obs.core.dao.LoginDao;
import com.orchard.obs.core.models.Customer;
import com.orchard.obs.core.util.DBUtil;

/**
 * @author Rushabh
 *
 */
public class LoginDaoImpl implements LoginDao {


	@Reference
	DBUtil dbUtil;

	@Override
	public Customer getCustomerDetails(String dataSourceName, String name, String password) throws LoginDaoException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dbUtil.getConnection(dataSourceName);
			preparedStatement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE EMAIL = ? AND CUST_PASSWORD = ?;");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			Customer customer = null;
			if(resultSet.isBeforeFirst()) {
				resultSet.next();
				//Populate Employee object with data from MySQL
				customer = new Customer();
				customer.setId(resultSet.getString(1));
				customer.setName(resultSet.getString(2)); 
				customer.setPassword(resultSet.getString(3));
			}		
		} catch (DataSourceNotFoundException | SQLException e) {
			throw new LoginDaoException(e);
		}
		finally {
			dbUtil.closeResource(resultSet);
			dbUtil.closeResource(preparedStatement);
			dbUtil.closeResource(connection);
		}
		return new Customer();
	}

}
