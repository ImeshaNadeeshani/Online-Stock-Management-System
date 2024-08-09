package Payment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DeletePaymentServlet")
public class DeletePaymentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("Id");
	    boolean isTrue;
	    
	    if (id != null && !id.isEmpty()) {
	        isTrue = PaymentDBUtil.deletePayment(id);

	        if (isTrue) {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentInsert.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            // Handle the case where the delete operation was not successful
	            response.sendRedirect("unsuccess.jsp");
	        }
	    } else {
	        // Handle the case where the 'Id' parameter is null or empty
	        response.sendRedirect("unsuccess.jsp");
	    }
	}


}

	