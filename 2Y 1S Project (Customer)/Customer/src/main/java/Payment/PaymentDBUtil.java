package Payment;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PaymentDBUtil {
	
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    
	public static boolean validate(String username, String password) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from payment where username='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true; 
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Payment> getPayment(String userName) {
		
		ArrayList<Payment> payment = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from payment where username='"+userName+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String address = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);
				String method = rs.getString(7);
				String amount = rs.getString(8);
				
				Payment pay = new Payment(Id,name,email,address,username,password,method,amount);
				payment.add(pay);
			}
			
		} catch (Exception e) {
			
		}
		
		return payment;	
	}
    
    public static boolean insertPayment(String name, String email, String address, String username, String password, String method, String amount) {
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into payment values (0,'"+name+"','"+email+"','"+address+"','"+username+"','"+password+"','"+method+"','"+amount+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
    
  public static boolean updatePayment(String Id, String name, String email, String address, String username, String password, String method, String amount) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		
    		String sql = "update payment set name='"+name+"', email='"+email+"', address='"+address+"', username='"+username+"', password='"+password+"', method='"+method+"', amount='"+amount+"' where Id='"+Id+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		System.out.println("error");
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
  public static List<Payment> getPaymentDetails(String id) {
	    ArrayList<Payment> pay = new ArrayList<>();
	    
	    if (id == null) {
	        // Handle the case where id is null (e.g., throw a custom exception with an error message)
	        throw new IllegalArgumentException("ID is null. Please provide a valid ID.");
	    }
	    
	    try {
	        int convertedId = Integer.parseInt(id);
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        String sql = "select * from payment where id='" + convertedId + "'";
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int Id = rs.getInt(1);
	            String name = rs.getString(2);
	            String email = rs.getString(3);
	            String address = rs.getString(4);
	            String username = rs.getString(5);
	            String password = rs.getString(6);
	            String method = rs.getString(7);
	            String amount = rs.getString(8);
	            
	            Payment p = new Payment(Id, name, email, address, username, password, method, amount);
	            pay.add(p);
	        }
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        // Handle the case where id is not a valid integer (e.g., throw a custom exception with an error message)
	        throw new IllegalArgumentException("Invalid ID format. Please provide a valid integer ID.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Handle other exceptions if necessary
	    }
	    
	    return pay;
	}

    
    
    public static boolean deletePayment(String Id) {
    	
    	int convId = Integer.parseInt(Id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from payment where Id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("error");
    	}
    	
    	return isSuccess;
    }    
}


