package project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BookTest {
	ArrayList<BookDTO> list = new ArrayList<BookDTO>();
	public static void main(String[] args) {
		BookTest bt = new BookTest();
		try {
			bt.printAllBooks();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertStudent(BookDTO book) throws ClassNotFoundException, SQLException {
		Connection con = this.makeConnection();
		MakeTable mt = new MakeTable();
		list = mt.bookTable();
		
		String sql = "INSERT INTO BOOKDTO VALUES(?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		for(int i=0; i<list.size(); i++) {
			BookDTO bd = list.get(i);
			
			stmt.setInt(1, bd.getIsbn());
			stmt.setString(2, bd.getTitle());
			stmt.setString(3, bd.getAuthor());
			stmt.setString(4, bd.getPublisher());
			stmt.setInt(5, bd.getPrice());
			stmt.setString(6, bd.getDesc());
			stmt.setString(7, "2021.10");
			stmt.executeUpdate();
		}
		stmt.close();
		con.close();
	}
	
	public void printAllBooks() throws ClassNotFoundException, SQLException {
		this.insertStudent(null);
		String rs6=null;
		
		Connection con = this.makeConnection();
		String sql = "SELECT * FROM BOOKDTO";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("***************************************** 도서 목록 *****************************************");
		while(rs.next()) {
			int isbn = rs.getInt(1);
			String title = rs.getString(2);
			String author = rs.getString(3);
			String publisher = rs.getString(4);
			int price = rs.getInt(5);
			if(rs.getString(6) != null) {
				rs6 = rs.getString(6);
			} else {
				rs6 = "\t";
			}
			String desc = rs6;
			String publish_date = rs.getString(7);
			System.out.println(isbn+"\t| "+title+"\t| "+author+"\t| "+publisher+"\t| "+
			price+"\t| "+desc+"\t\t| "+publish_date);
		}
		stmt.close();
		con.close();
		
	}
	public Connection makeConnection() throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "HR";
		String pwd = "1234";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,id,pwd);
		
		return con;
	}
}
