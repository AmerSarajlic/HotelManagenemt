package hotelmanagement.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rooms {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String roomNumber;
	private String type;
	private boolean avilable;
	private int price;
	
	public Rooms() {
		// TODO Auto-generated constructor stub
	}
	
	public Rooms(String roomNumber, String type, boolean avilable, int price) {
		super();
		this.roomNumber = roomNumber;
		this.type = type;
		this.avilable = avilable;
		this.price = price;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvilable() {
		return avilable;
	}

	public void setAvilable(boolean isAvilable) {
		this.avilable = isAvilable;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", avilable=" + avilable
				+ ", price=" + price + "]";
	}
}
