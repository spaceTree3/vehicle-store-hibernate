package vehicle.store;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.jpamodelgen.annotation.*;

import vehicle.store.dto.*;

public class VehicleStoreMain {
	
	public static void main(String [] args) {

		Car car = new Car();
		car.setVehicleBrand("Honda");
		car.setVehicleManufacturer("Honda Motor Company");
		car.setVehicleModel("Civic LX");
		car.setVehiclePrice(11990);
		car.setNoOfDoors(4);
		
		Vehicle car2 = new Car();
		car2.setVehicleBrand("Tesla");
		car2.setVehicleManufacturer("Tesla Inc");
		car2.setVehicleModel("Model S");
		car2.setVehiclePrice(67000);
		
		Motorcycle bike = new Motorcycle();
		bike.setVehicleBrand("Honda");
		bike.setVehicleManufacturer("Honda Motor Company");
		bike.setVehicleModel("CTX700");
		bike.setVehiclePrice(7499);
		bike.setSeatHeight(28.3);

		
		Client client= new Client();
		client.setClientName("John");
		client.setClientLastName("Smith");
		client.setClientEmail("clientMail@example.com");

		client.getClientAddress().setAddressCity("Cordoba");
		client.getClientAddress().setAddressCountry("Argentina");
		client.getClientAddress().setAddressStreet("Lari Boen");
		client.getClientAddress().setAddressNumber(798);
		
		Phone phone1= new Phone();
		phone1.setPhoneCityCode(3761);
		phone1.setPhoneCountryCode(54);
		phone1.setPhoneNumber(998877);
		
		Phone phone2= new Phone();
		phone2.setPhoneCityCode(3761);
		phone2.setPhoneCountryCode(54);
		phone2.setPhoneNumber(665544);
		
		client.getClientPhones().add(phone1);
		client.getClientPhones().add(phone2);
		
		client.getVehicles().add(car);
		client.getVehicles().add(bike);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		session.close();
		
		//criteria
		
		Session session2= sessionFactory.openSession();
		session2.beginTransaction();
		
		CriteriaBuilder builder=session2.getCriteriaBuilder();
		
		CriteriaQuery<Client> criteria= builder.createQuery(Client.class);
		
		Root<Client> clientRoot= criteria.from(Client.class);
		
		criteria.select(clientRoot);
		
		Query<Client> query=session2.createQuery(criteria);
		
		List<Client> clients= (List<Client>) query.getResultList();
		
		session2.getTransaction().commit();
		
		session2.close();
		
		for(Client clientElem:clients) {
			System.out.println("Client Number: "+ clientElem.getClientNumber());
			System.out.println("Bought vehicles: ");
			for(Vehicle vehicleELem:clientElem.getVehicles()) {
				System.out.println("Type: "+vehicleELem.getClass().getSimpleName());
				System.out.println("Brand: "+vehicleELem.getVehicleBrand());
				System.out.println("Model: "+vehicleELem.getVehicleModel());
			}
		}
		
		//HQL
		Session session3= sessionFactory.openSession();
		session3.beginTransaction();
		
		
		Query query2= session3.createQuery("update Client set clientEmail=:email where clientName=:name and clientLastName=:lastName");
		query2.setParameter("name","John");
		query2.setParameter("lastName", "Smith");
		query2.setParameter("email", "myUpdatedEmail@mail.com");
		int result=query2.executeUpdate();

		Query query3=session3.createQuery("from Client where clientName=:name and clientLastName=:lastName");
		query3.setParameter("name", "John");
		query3.setParameter("lastName", "Smith");
		Client client2=(Client) query3.uniqueResult();
		for(Vehicle vehicle:client2.getVehicles()) {
			if (vehicle.getVehicleModel().equals("CTX700"))
				vehicle.setVehiclePrice(7650);
		}
		
		session3.getTransaction().commit();
		
		session3.close();
		
	}

}
