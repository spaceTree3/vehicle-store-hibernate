package vehicle.store.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLIENT_NUMBER")
	private int clientNumber;
	@Column(name="CLIENT_NAME")
	private String clientName;
	@Column(name="CLIENT_LASTNAME")
	private String clientLastName;
	//embedded in table
	@Embedded
	@JoinTable(name="CLIENT_ADDRESS", joinColumns=@JoinColumn(name="CLIENT_NUMBER"))
	private Address clientAddress;
	//separate join table
	@ElementCollection
	@JoinTable(name="CLIENT_PHONE", joinColumns=@JoinColumn(name="CLIENT_NUMBER"))
	private List<Phone> clientPhones;
	@Column(name="CLIENT_EMAIL")
	private String clientEmail;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="SALE",
			joinColumns=@JoinColumn(name="CLIENT_ID"),
			inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles;

	public Client() {
		this.clientPhones= new ArrayList<Phone>();
		this.clientAddress= new Address();
		this.vehicles=new ArrayList<Vehicle>();
	}
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientLastName() {
		return clientLastName;
	}
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
	public Address getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(Address clientAddress) {
		this.clientAddress = clientAddress;
	}
	public List<Phone> getClientPhones() {
		return clientPhones;
	}
	public void setClientPhones(List<Phone> clientPhones) {
		this.clientPhones = clientPhones;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
