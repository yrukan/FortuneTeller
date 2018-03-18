package by.htp.bean;

public class Client implements Comparable <Client>{
	private String name;
	private String surname;
	
	public Client(){
		
	}
	
	public Client(String name, String surname, String prediction) {
		super();
		this.name = name;
		this.surname = surname;	
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	    	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (obj == this)
            return true;
        
        if (obj.getClass() == this.getClass()) {
            Client client = (Client) obj;
            if (client.name == this.name && client.surname == this.surname)
                return true;            
        }
        return false;
    }
	
	@Override
	public String toString() {
		return "Client [clientName=" + name + ", clientSurname=" + surname + "]";
	}

	@Override
	public int compareTo(Client client) {
        if (client.name == this.name && client.surname == this.surname)
        	return 1;
		return 0;
	}	
	
}
