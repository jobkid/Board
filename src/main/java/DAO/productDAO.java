package DAO;

import java.sql.*;
import java.util.*;
import DTO.productDTO;

public class productDAO {
	private productDAO() {}
	private static productDAO instance = new productDAO();
	public static productDAO getInstance() {
		return instance;
	}
	
	//Ŀ�ؼ� ��� ó�� �޼���
	public Connection getConnection() throws Exception{
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/study";
		String id = "root";
		String pw = "iotiot";
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, id, pw);
		return conn;
	}
	
	//Ŀ�ؼ� �������� ó�� �޼���
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {//select ����
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("�������� �� ���� �߻�");
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {//update����
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("���� ���� �� �����߻� : "+e);
		}
	}
	
	//�����ͺ��̽� ��ȸ ���
	public List<productDTO> selectAllProducts(){
		List<productDTO> list=new ArrayList<productDTO>();
		String sql = "select * from product order by code desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);//rs�� �����Ƿ� ���⼭ sql�ؾ� ��.
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productDTO p = new productDTO();
				p.setCode(rs.getInt("code"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setPictureurl(rs.getString("pictureurl"));
				p.setDescription(rs.getString("description"));
				list.add(p);
			}
		}catch(Exception e) {
			System.out.println("��ü��ȸ �� ���� �߻� : "+e);
		}finally {
			productDAO.close(conn, pstmt, rs);
		}
		return list;
	}
}
