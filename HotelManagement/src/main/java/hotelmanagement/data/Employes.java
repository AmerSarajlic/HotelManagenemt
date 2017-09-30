package hotelmanagement.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String position;
	private int salary;
	
	public Employes() {
		// TODO Auto-generated constructor stub
	}

	public Employes(String firstName, String lastName, String position, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employes [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", position=" + position
				+ ", salary=" + salary + "]";
	}
	
}
