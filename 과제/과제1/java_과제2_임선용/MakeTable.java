package project2;

import java.util.ArrayList;

public class MakeTable {
	private ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		public ArrayList<BookDTO> bookTable() {
			list.add(new BookDTO(21424,"Java Basic","���ϳ�","Jean.kr",15000,"Java �⺻ ����"));
			list.add(new BookDTO(33455,"JDBC pro","��ö��","Jean.kr",23000,null));
			list.add(new BookDTO(55355,"Servlet/JSP","���ڹ�","Jean.kr",41000,"Model2 ���"));
			list.add(new BookDTO(35332,"Android App","ȫ�浿","Jean.kr",25000,"Lightweight Framework"));
			list.add(new BookDTO(35355,"OOAD �м�,����","�ҳ���","Jean.kr",30000,null));
			return list;
		}
}
