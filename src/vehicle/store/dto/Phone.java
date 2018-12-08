package vehicle.store.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone {
//	private int phoneId;
	@Column(name="PHONE_COUNTRY_CODE")
	private int phoneCountryCode;
	@Column(name="PHONE_CITY_CODE")
	private int phoneCityCode;
	@Column(name="PHONE_NUMBER")
	private int phoneNumber;
	
	/*
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	*/
	public int getPhoneCountryCode() {
		return phoneCountryCode;
	}
	public void setPhoneCountryCode(int phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}
	public int getPhoneCityCode() {
		return phoneCityCode;
	}
	public void setPhoneCityCode(int phoneCityCode) {
		this.phoneCityCode = phoneCityCode;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
