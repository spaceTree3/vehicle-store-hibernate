package vehicle.store.dto;

public interface Menu {
	
	//void for now

	public void Operations();
	
	
	//vehicle
	
	public void addAVehicle();
	
	public void getVehicleByType();
	
	public void getVehicleByBrand();
	
	public void getAllVehicles();
	
	public void updateVehicleDetails();
	
	public void deleteVehicle();
	
	//client
	public void addAClient();
	
	public void getClientByNameLastName();
	
	public void updateClient();
		
	
	//sale
	public void addSale();
	
	public void updateSale();
	
	public void getAllSales();
	
}
