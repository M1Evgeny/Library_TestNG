package by.htp.library.console;

import java.util.List;

import by.htp.library.dao.impl.BookDaoDBImpl;
import by.htp.library.model.Book;

public class Main {

	public static void main(String[] args) {
		BookDaoDBImpl bk = new BookDaoDBImpl();
		List<Book> list = bk.readAll();
		for(Book b: list){
			System.out.println(b);
		}

	}

}
