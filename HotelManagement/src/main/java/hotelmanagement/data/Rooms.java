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
	private String type;
	private boolean isAvilable;
	
	public Rooms() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvilable() {
		return isAvilable;
	}

	public void setAvilable(boolean isAvilable) {
		this.isAvilable = isAvilable;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", type=" + type + ", isAvilable=" + isAvilable + "]";
	}

}
