package com.orchard.obs.core.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourceNotFoundException;
import com.day.commons.datasource.poolservice.DataSourcePool;
import com.orchard.obs.Exceptions.daoexceptions.CustomerDaoExceptions;
import com.orchard.obs.core.dao.RegistrationDao;
import com.orchard.obs.core.models.Customer;
import com.orchard.obs.core.services.RegistrationServices;
import com.orchard.obs.core.util.DBUtil;


@Component(immediate = true,service=RegistrationDao.class)
public class RegistrationDaoImpl implements RegistrationDao {

	private Logger logger = LoggerFactory.getLogger(RegistrationServices.class);
	
	@Reference
	DBUtil dbConnectionUtil;
	
	@Reference
	DataSourcePool source;
	
	@Override
	public boolean registerUser(String dataSourceName, Customer customer)throws CustomerDaoExceptions {
		Connection connection=null;
		boolean status=false;
		try {
			connection = dbConnectionUtil.getConnection(dataSourceName);
		} catch (DataSourceNotFoundException e) {
			throw new CustomerDaoExceptions("Data Source Not Found",e);
		}
		catch (SQLException e) {
			throw new CustomerDaoExceptions("Connection Failed",e);
		}
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			logger.error("Inside Connection, Source Is  {}", source);
			String id=customer.getId();
			String name=customer.getName();
			String mail=customer.getMail();
			String gender=customer.getGender();
			String dob=customer.getDob();
			String phone=customer.getPhone();
			String address=customer.getAddress();
			String country=customer.getCountry();
			String state=customer.getState();
			String city=customer.getCity();
			String pin=customer.getPin();
			statement=connection.createStatement();
			String query = "insert into customer values('"+id+"','"+name+"','"+mail+"','"+gender+"','"+dob+"','"+phone+"','"+address+"','"+country+"','"+state+"','"+city+"','"+pin+"')";
			statement.executeUpdate(query);
			logger.error("after insert query");
			status=true;
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new CustomerDaoExceptions("Record Already exists",e);
		} catch (SQLException e) {
			throw new CustomerDaoExceptions("Insertion Error",e);
		} finally {
			dbConnectionUtil.closeResource(resultSet);
			dbConnectionUtil.closeResource(preparedStatement);
			dbConnectionUtil.closeResource(connection);
		}
		return status;
	}

}
