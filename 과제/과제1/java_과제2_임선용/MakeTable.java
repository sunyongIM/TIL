package project2;

import java.util.ArrayList;

public class MakeTable {
	private ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		public ArrayList<BookDTO> bookTable() {
			list.add(new BookDTO(21424,"Java Basic","김하나","Jean.kr",15000,"Java 기본 문법"));
			list.add(new BookDTO(33455,"JDBC pro","김철수","Jean.kr",23000,null));
			list.add(new BookDTO(55355,"Servlet/JSP","박자바","Jean.kr",41000,"Model2 기반"));
			list.add(new BookDTO(35332,"Android App","홍길동","Jean.kr",25000,"Lightweight Framework"));
			list.add(new BookDTO(35355,"OOAD 분석,설계","소나무","Jean.kr",30000,null));
			return list;
		}
}
