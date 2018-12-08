package vehicle.store.dto;


import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="SALE")
public class Sale {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SALE_ID")
	private int saleId;
//	@JoinTable(name="SOLD_VEHICLES",
//			joinColumns=@JoinColumn(name="SALE_ID"),
//			inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	@OneToMany(cascade=CascadeType.ALL,mappedBy="sale")	
	private Collection<Vehicle> vehicles;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	public Sale() {
		this.vehicles= new ArrayList<Vehicle>();
	}
	
	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	


}
