package dbmodel.DataPreparation;

import dbmodel.Provider;

public class Scooter {
	Provider provider = new Provider();

	// *********Constructor*********
	public Scooter() {

	}
	
//	// *scooter olustur
//	public Scooter setScooterForAutomation(String scooter_code) {
//		try {
//			provider.ExecuteCommand("delete from rides where scooter_id = (select id from scooters where code = '" + scooter_code + "');"
//					+ "delete from reservations where scooter_id = (select id from scooters where code = '" + scooter_code + "');",
//					"martiDB");
//			
//			provider.ExecuteCommand("delete from scooters where code = "+ scooter_code +";"
//					+ "INSERT INTO public.scooters (code, version, status_id, battery_status, last_known_point, last_update_time, module_battery_status, lock_code, sim_card_no, is_available, timezone, last_ride_id, last_stolen_time, mqtt_password, firmware_version, bt_mac, hdop, attention, geofence_group, need_repair, need_repair_note, gsm_available, gsm_location, mobile_phone_number, total_km, last_fota_time, sub_status, charging_station_id, scooter_body_version_id, starting_price, recurring_price, iot_locked, last_locked_time, life, reservation_price, created_at, last_check_time) VALUES "
//					+ "('" + scooter_code + "', 1, 1, 95, 'sxk9m8gz5', '2020-06-16 12:12:08.174', 22, '1234', '1234', true, 3, 0, NULL, NULL, '1.008.285', NULL, 4.4, false, 10, false, '', true, 'sxk9m8gz5', '5066174696', 20, '2020-01-30 14:05:00.000', NULL, NULL, 4, 1.99, 0.59, true, NULL, 0, 0.39, '2020-02-19 00:00:00.000', '2019-05-18 12:12:27.736');",
//					"martiDB");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return this;
//		}
	
	// *scooterların last know pointlerinin set edilmesi.
	public Scooter setLastKnowPointToScooter(String scooter, String geo_point) {
		try {
		if (scooter.length() < 4) {
			throw new Exception("Scooter kodu yok");
		}
		provider.ExecuteCommand(
				"UPDATE scooters set last_known_point = '" + geo_point + "' where code = '" + scooter + "';",
				"martiDB");
		}catch(Exception ex)
		{}
		return this;
		}
		
	
	//*scooterın şarj durumunun değiştirilmesi.
	public Scooter setBatteryLevel(String scooter, String new_battery_level) throws Throwable {
		if (scooter.length() < 4) {
			throw new Exception("Scooter kodu yok");
		}
		provider.ExecuteCommand(
				"UPDATE scooters set battery_status = " + new_battery_level + " where code = " + scooter + "'",
				"martiDB");
		return this;
		}
		
	//*scooterın body_versionlarının deiştirilmesi
	public Scooter setScooterBodyVersion(String scooter, String body_version) throws Throwable {
		if (scooter.length() < 4) {
			throw new Exception("Scooter kodu yok");
		}
		provider.ExecuteCommand(
				"UPDATE scooters set scooter_body_version_id = " + body_version + " where code = " + scooter + "'",
				"martiDB");
		return this;
		}
	
	
	//*scooterı arızalı statuse gecirme
	public Scooter repairScooterStatus(String scooter, boolean need_repair) throws Throwable {
		if (scooter.length() < 4) {
			throw new Exception("Scooter kodu yok");
		}
		provider.ExecuteCommand(
				"UPDATE scooters set need_repair = " + need_repair + " where code = " + scooter + "'",
				"martiDB");
		return this;
		}

	//*scooter sürüşlerini temizle
	public Scooter deleteScooterRides(String scooter) {
	try {
		if (scooter.length() < 4) {
			throw new Exception("Scooter kodu yok");
		}
		provider.ExecuteCommand(
				"delete from rides where scooter_id = (select id from scooters where code = '" + scooter + "')",
				"martiDB");
	}catch(Exception ex) {}
		return this;
		}
	
	//*scooter sürüşlerini temizle
	public Scooter addScooter(String scooter_code) {
		try {
			provider.ExecuteCommand("delete from rides where scooter_id = (select id from scooters where code ='" + scooter_code + "');"
					+ "delete from scooter_repair_records where scooter_id = (select id from scooters where code ='" + scooter_code + "');"
					+ "delete from reservations where scooter_id = (select id from scooters where code ='" + scooter_code + "');"
					+ "delete from scooters where code ='" + scooter_code + "';"
					+ "INSERT INTO public.scooters (code, version, status_id, battery_status, last_known_point, last_update_time, module_battery_status, lock_code, sim_card_no, is_available, timezone, last_ride_id, last_stolen_time, mqtt_password, firmware_version, bt_mac, hdop, attention, geofence_group, need_repair, need_repair_note, gsm_available, gsm_location, mobile_phone_number, total_km, last_fota_time, sub_status, charging_station_id, scooter_body_version_id, starting_price, recurring_price, iot_locked, last_locked_time, life, reservation_price, created_at, last_check_time) VALUES "
					+ "('"+ scooter_code +"', 1, 1, 95, 'sxk9m8gz5', '2020-06-16 12:12:08.174', 22, '1234', '1234', true, 3, 0, NULL, NULL, '1.008.285', NULL, 4.4, false, 10, false, '', true, 'sxk9m8gz5', '5066174696', 20, '2020-01-30 14:05:00.000', NULL, NULL, 4, 1.99, 0.59, true, NULL, 0, 0.39, '2020-02-19 00:00:00.000', '2019-05-18 12:12:27.736');",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	//*scooter sürüşlerini temizle
	public Scooter addScooterRide(String customer_phone_no, String scooter_code) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"INSERT INTO rides (customer_id, scooter_id, start_time, end_time, distance, charged_price, credit_card_id, payment_service_payment_token, map_data, payment_successful, photo, approved_user_id, approved_date, approved_note, is_approved, actual_price, last_ride_point, payment_service_transaction_id, geofence_group, provision_transaction, additional_payment_transaction, user_id, campaign_id, reservation_id, reservation_price, start_mileage, end_mileage, ride_refunded_by_mileage, gross_price) VALUES" + 
					"((select id from customers where mobile_phone = '" + customer_phone_no + "'), (select id from scooters where code = '"+ scooter_code  +"'), now(), NULL, NULL, 1.99, NULL, NULL, '{sxk9m8gz8}', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12897526', 10, '12198366', NULL, NULL, NULL, 0, 0.00, 0, NULL, NULL, 0);",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
		}
	
	//*scooter rezervayon temizle
	public Scooter deleteScooterReservations(String scooter) {
		try {
		if (scooter.length() < 4) {
			throw new Exception("Scooter kodu yok");
		}
		provider.ExecuteCommand(
				"delete from reservations where scooter_id = (select id from scooters where code = '" + scooter + "')",
				"martiDB");
		}
		catch(Exception ex) {}
		
		return this;
		}
	
	//*scooter kilitle
	public Scooter lockScooter(String scooter) {
		try {
			if (scooter.length() < 4) {
				throw new Exception("Scooter kodu yok");
			}
			provider.ExecuteCommand(
					"update scooters set lock_code = '1234' where code = '"+ scooter +"';",
					"martiDB");
			}
			catch(Exception ex) {}
			
			return this;
		}
	//*scooter kilit ac
	public Scooter unlockScooter(String scooter) {
		try {
			if (scooter.length() < 4) {
				throw new Exception("Scooter kodu yok");
			}
			provider.ExecuteCommand(
					"update scooters set lock_code = NULL where code = '"+ scooter +"';",
					"martiDB");
			}
			catch(Exception ex) {}
			
			return this;
		}
	//*scooter'in surus suresini 7 dk geri alir.
	public Scooter setRideTime(String scooter) {
		try {
			if (scooter.length() < 4) {
				throw new Exception("Scooter kodu yok");
			}
			provider.ExecuteCommand(
					"update rides set start_time = (now() - interval '5 minute') where scooter_id = (select id from scooters where code = '" + scooter + "')",
					"martiDB");
			}
			catch(Exception ex) {}
			
			return this;
		}
	
	// *musterinin surus ekle
	public Scooter addScooterFinishedRide(String customer_phone_no, String scooter_code) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"INSERT INTO rides (customer_id, scooter_id, start_time, end_time, distance, charged_price, credit_card_id, payment_service_payment_token, map_data, payment_successful, photo, approved_user_id, approved_date, approved_note, is_approved, actual_price, last_ride_point, payment_service_transaction_id, geofence_group, provision_transaction, additional_payment_transaction, user_id, campaign_id, reservation_id, reservation_price, start_mileage, end_mileage, ride_refunded_by_mileage, gross_price) VALUES" + 
					"((select id from customers where mobile_phone = '" + customer_phone_no + "'), (select id from scooters where code = '"+ scooter_code +"'), (now() - interval '10 minute'), now(), 10, 1.99, NULL, NULL, '{sxk9m8gz8}', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12897526', 10, '12198366', NULL, NULL, NULL, 0, 0.00, 0, NULL, NULL, 0);",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *musterinin surus ekle
	public String getScooterActiveRepairId(String scooter_code) {
		String id = "";
		try {
		id = provider.ExecuteScalar("SELECT id from scooter_repair_records where scooter_id = (select id from scooters where code = '"+ scooter_code +"') and start_time is null",
		"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	}