package hotelmanagement.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private String idCard;
	private Date dateIn = new Date();
	private Date dateOut;

	@OneToOne
	private Rooms rooms;

	@OneToMany
	private List<Services> serviceList;

	public Customers() {
	}

	public Customers(String firstName, String lastName, String idCard, Rooms rooms, List<Services> serviceList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idCard = idCard;
		this.rooms = rooms;
		this.serviceList = serviceList;
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public List<Services> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Services> serviceList) {
		this.serviceList = serviceList;
	}

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", idCard=" + idCard
				+ ", dateIn=" + dateIn + ", dateOut=" + dateOut + ", rooms=" + rooms + ", serviceList=" + serviceList
				+ "]";
	}

}
