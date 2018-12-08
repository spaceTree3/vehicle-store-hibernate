package vehicle.store.dto;

import javax.persistence.*;

@Entity
@Table(name="CAR")
public class Car extends Vehicle {
	@Column(name="CAR_NUMBER_DOORS")
	private int noOfDoors;

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}
	
}
