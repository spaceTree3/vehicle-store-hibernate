package vehicle.store.dto;

import javax.persistence.*;

@Entity
@Table(name="MOTORCYCLE")
public class Motorcycle extends Vehicle {
	@Column(name="MOTO_SEAT_HEIGHT")
	private double seatHeight;

	public double getSeatHeight() {
		return seatHeight;
	}

	public void setSeatHeight(double straddleHeight) {
		this.seatHeight = straddleHeight;
	}
	
	

}
