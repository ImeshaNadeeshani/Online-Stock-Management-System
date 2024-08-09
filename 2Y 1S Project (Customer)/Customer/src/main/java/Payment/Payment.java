package Payment;

public class Payment {
	    private int Id;
	    private String name;
	    private String email;
	    private String address;
	    private String username;
	    private String password;
	    private String method;
	    private String amount;
	    
	    public Payment(int Id, String name, String email, String address, String username, String password, String method, String amount) {
	    	
		this.Id = Id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.username = username;
		this.password = password;
		this.method = method;
		this.amount = amount;
		
	    }

	    public int getId() {
	        return Id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }  
	    
	    public String getMethod() {
	        return method;
	    }  
	    
	    public String getAmount() {
	        return amount;
	    }  
	}
	
	

