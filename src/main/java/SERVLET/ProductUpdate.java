package SERVLET;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import DAO.productDAO;
import DTO.productDTO;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

@WebServlet("/ProductUpdate")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		System.out.println("productUpdate.doget() ���� ���� �з����� Ȯ�� : "+code);
		
		productDAO DAO = productDAO.getInstance();
		productDTO DTO = DAO.selectProduct(code);
		System.out.println("������ Ȯ�� �׽�Ʈ : "+DTO.getName());
		request.setAttribute("product", DTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("productUpdate.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
