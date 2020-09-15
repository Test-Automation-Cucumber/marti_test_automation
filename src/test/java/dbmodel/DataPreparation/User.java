package dbmodel.DataPreparation;

import dbmodel.Provider;

public class User {
	Provider provider = new Provider();

	// *********Constructor*********
	public User() {

	}
	
	// *musteri oluşturur
	public User changeUserRole(String userPhoneNumber, int role_id) {
		try {
			if (userPhoneNumber.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand("UPDATE users set role_id = '"+ Integer.toString(role_id) +"' where mobile_phone = '"+ userPhoneNumber +"';", "martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *musteri oluşturur
	public User deleteRepairRecords(String userPhoneNumber) {
		try {
			if (userPhoneNumber.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand("DELETE from scooter_repair_records where repair_user_id = (select id from users where mobile_phone = '"+ userPhoneNumber +"')", "martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
}