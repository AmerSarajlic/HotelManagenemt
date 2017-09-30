package hotelmanagement.dao;

import java.util.List;

import hotelmanagement.data.Employes;

public interface EmployesDAO {

	public boolean addEmployee(Employes employee);
	
	public boolean removeEmployee(String firstName, String lastName);
	
	public List<Employes> displayAllEmployess();
	
}
