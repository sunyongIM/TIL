package project1;

import java.util.ArrayList;

public class BookTest {
	private ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	public static void main(String[] args) {
		
		BookTest bt = new BookTest();
		
		bt.PrintTable();
	}
	public void PrintTable() {
		MakeTable mt = new MakeTable();
		list = mt.bookTable();
		System.out.println("************************************ 도서 목록 ************************************");
		for(BookDTO element : list) {
			System.out.println(element);
		}
	}
}
