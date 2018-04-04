package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.dao.EmployeeDao;
import by.htp.library.dao.util.DBConnectionHelper;
import by.htp.library.model.Employee;

public class EmployeeDaoDBImpl implements EmployeeDao {
	
	private static final String SQL_SELECT_EMPLOYEE = "select * from employee";
	private static final String SQL_SELECT_LASTNAME = "select lastname from employee";

	public void create(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	public Employee read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> readAll() {
		List<Employee> listEmployee = new ArrayList<Employee>();

		Connection connection = DBConnectionHelper.connect();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_EMPLOYEE);

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setName(rs.getString("name"));
				emp.setLastname(rs.getString("surname"));

				listEmployee.add(emp);
			}
			for (Employee employee : listEmployee) {
				System.out.println(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnectionHelper.disconnect(connection);
		return listEmployee;
	}

	public void update(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
