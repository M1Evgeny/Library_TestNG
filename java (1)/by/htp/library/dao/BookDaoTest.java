package by.htp.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.dao.util.DBConnectionHelper;
import by.htp.library.model.Book;

public class BookDaoTest {

	private Connection connection;
	private List<Book> expectedBooks;
	BookDaoDBImpl dao;

	@BeforeClass
	public void initDefaultDBConnection() {
		System.out.println("@BeforeClass");

		connection = DBConnectionHelper.connect();
	}

	@BeforeMethod
	public void getExpectedList() throws SQLException {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from book");
		expectedBooks = new ArrayList<Book>();
		while (rs.next()) {
			expectedBooks.add(new Book());
		}
		System.out.println("@BeforeMethod: expectedBooks was recieved");
	}

	@BeforeMethod
	public void initDao() {
		dao = new BookDaoDBImpl();
	}

	@Test
	public void testRecievedCorrectBookCount() {
		List<Book> actualBooks = dao.readAll();

		Assert.assertEquals(actualBooks.size(), expectedBooks.size(),
				"actual is not equal expected");
	}

	@AfterMethod
	public void m4() {
		expectedBooks = null;
		System.out.println("@AfterMethod: actualList is null value");
	}

	@AfterClass
	public void closeDBConnection() {
		System.out.println("@AfterClass");

		DBConnectionHelper.disconnect(connection);
	}

}
