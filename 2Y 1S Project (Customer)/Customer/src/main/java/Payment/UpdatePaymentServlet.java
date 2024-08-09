package Payment;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("payId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");
		
		boolean isTrue;
		
		isTrue = PaymentDBUtil.updatePayment(Id, name, email,address, username, password,method,amount);
		
		if(isTrue == true) {
			
			List<Payment> payDetails = PaymentDBUtil.getPayment(username);
			request.setAttribute("payDetails", payDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("PaymentRead.jsp");
			dis.forward(request, response);
		}
		else {
			List<Payment> payDetails = PaymentDBUtil.getPaymentDetails(Id);
			request.setAttribute("payDetails", payDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
	}

}
	
	

