package hotelmanagement.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String serviceName;
	private int servicePrice;

	public Services() {
		// TODO Auto-generated constructor stub
	}
	
	public Services(String serviceName, int servicePrice) {
		super();
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(int servicePrice) {
		this.servicePrice = servicePrice;
	}

	@Override
	public String toString() {
		return "Services [id=" + id + ", serviceName=" + serviceName + ", servicePrice=" + servicePrice + "]";
	}
	
}
