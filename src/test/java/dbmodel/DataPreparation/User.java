package dbmodel.DataPreparation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dbmodel.Provider;

public class User {
	Provider provider = new Provider();

	// *********Constructor*********
	public User() {

	}
	
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
	
	public User deleteUserShift(String userPhoneNumber) {
		try {
		provider.ExecuteCommand("delete from user_shifts where user_id = (select id from users where mobile_phone = '90" + userPhoneNumber + "'); ", "martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public User addUserShift(String userPhoneNumber, String plate) {
		Date dt = new Date();
		Date dtPLus1 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		dt = c.getTime();
		c.add(Calendar.DATE, 1);
		dtPLus1 = c.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today  = dateFormat.format(dt);
		String todayPlus1 = dateFormat.format(dtPLus1);
		
		try {
		provider.ExecuteCommand("delete from user_shifts where user_id = (select id from users where mobile_phone = '90" + userPhoneNumber + "'); "
				+ "INSERT INTO public.user_shifts(user_id, shift_date, shift_no, created_by, created_at, updated_at, car_id, start_time, end_time, warehouse_id, fence_group) VALUES"
				+ "((select id from users where mobile_phone = '90" + userPhoneNumber + "'), current_date, 1, 185, current_date, NULL, (select id from cars where plate ='"+ plate +"'), '" + today + " 07:30:00" + "', '" + today + " 16:30:00" + "', 0, 10), "
				+ "((select id from users where mobile_phone = '90" + userPhoneNumber + "'), current_date, 2, 185, current_date, NULL, (select id from cars where plate ='"+ plate +"'), '" + today + " 15:30:00" + "', '" + todayPlus1 + " 00:30:00" + "', 0, 10), "
				+ "((select id from users where mobile_phone = '90" + userPhoneNumber + "'), current_date, 3, 185, current_date, NULL, (select id from cars where plate ='"+ plate +"'), '" + today + " 23:30:00" + "', '" + todayPlus1 + " 08:30:00" + "', 0, 10); "	
				, "martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public User addVehicleToUser(String userPhoneNumber, String plate) {
		try {
			String plateId = provider.ExecuteScalar("select id from cars where plate = '" + plate + "'", "martiDB");
			
			if (plateId == null) {
				plateId = provider.ExecuteScalar("INSERT INTO public.cars(plate, \"name\", driver_1, driver_2, phone_mac, fence_group, capacity)"
						+ " VALUES('" + plate + "', 'AUTOMATION', NULL, NULL, NULL, 10, 30) returning id;", "martiDB");
			}
			
			provider.ExecuteCommand("delete from car_deliveries where user_id =(select id from users where mobile_phone='90"+ userPhoneNumber +"') and delivered_at is null;"
					+ " delete from car_deliveries where car_id =(select id from cars where plate='" + plate + "') and delivered_at is null; "
					+ " INSERT INTO public.car_deliveries " + 
					"(car_id, user_id, picked_at, delivered_at, pick_km, picking_photos, delivering_photos, has_issue, issue, deliver_km, assistant_user_id) " + 
					"VALUES(" + plateId + ", (select id from users where mobile_phone = '90" + userPhoneNumber + "'), now(), NULL, 10, '{d630fa6d-e3c7-40ee-9e11-61baddae4241.png,149091b4-123c-44b5-bf8c-b8fc95f9ac26.png,7664c797-517c-404f-b7a0-113eb470e028.png,a08d49a4-d06a-4eb4-be92-1696e730746e.png,a62028cf-b026-4520-9af3-7aeb3373d1ff.png}', NULL, false, '', NULL, NULL);",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public User deleteVehicleFromUser(String userPhoneNumber) {
		try {
			provider.ExecuteCommand("delete from car_deliveries where user_id =(select id from users where mobile_phone='90"+ userPhoneNumber +"') and delivered_at is null; ", "martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
}