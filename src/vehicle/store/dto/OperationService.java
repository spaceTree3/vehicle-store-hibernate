package vehicle.store.dto;

import java.util.Scanner;

public class OperationService implements Menu {
	private Scanner reader;
	
	public OperationService() {	
		this.reader= new Scanner(System.in);
	}
	
	//General
	@Override
	public void Operations() {
		System.out.println("Welcome!");
		String answer="";
		while(answer!="Z")
		System.out.println("Pick one operation: ");
		System.out.println(
				"A: Add a vehicle %n"+
				"B: Get vehicle by type %n"+
				"C: Get vehicle by brand %n"+
				"D: Get all vehicles %n"+
				"E: Update Vehicle Details %n"+
				"F: Delete a vehicle %n"+
				"G: Add a client %n"+
				"H: Get client by name and lastname %n"+
				"I: Update client %n"+
				"J: Add a sale %n"+
				"K: Update a sale %n"+
				"L: Get all sales %n"+
				"Z: Exit");
		System.out.print("Answer: ");
		answer= reader.next();
		switch(answer) {
		case "A":
			this.addAVehicle();
			break;
		case "B":
			this.getVehicleByType();
			break;
		
		case "C":
			this.getVehicleByBrand();
			break;
		
		case "D":
			this.getAllVehicles();
			break;
		
		case "E":
			this.updateVehicleDetails();
			break;
		
		case "F":
			this.deleteVehicle();
			break;
		
		case "G":
			this.addAClient();
			break;
		
		case "H":
			this.getClientByNameLastName();
			break;
		
		case "I":
			this.updateClient();
			break;
		
		case "J":
			this.addSale();
			break;
		
		case "K":
			this.updateSale();
			break;
		
		case "L":
			this.getAllSales();
			break;
		
		case "Z":
			System.out.println("Thanks :)");
			break;
		}
	}
	
	//Vehicle
	
	@Override
	public void addAVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Wanna add a car or bike? <c> or <b>");
		String answer=reader.next();
		if (answer.equals("c")) {
			Car car = new Car();
			car.setVehicleBrand("Honda");
			car.setVehicleManufacturer("Honda Motor Company");
			car.setVehicleModel("Civic LX");
			car.setVehiclePrice(11990);
			car.setNoOfDoors(4);
		}
		
		

	}

	@Override
	public void getVehicleByType() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getVehicleByBrand() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllVehicles() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVehicleDetails() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void deleteVehicle() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAClient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getClientByNameLastName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSale() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSale() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllSales() {
		// TODO Auto-generated method stub

	}

}
