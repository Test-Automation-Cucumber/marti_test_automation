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
	
	public User addSecurityUserShift(String userPhoneNumber, String plate) {
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
		provider.ExecuteCommand("UPDATE users set role_id = '39' where mobile_phone = '90"+ userPhoneNumber +"';"
				+ "delete from user_shifts where user_id = (select id from users where mobile_phone = '90" + userPhoneNumber + "'); "
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
	
	public User deleteUserTasks(String userPhoneNumber) {
		try {
			provider.ExecuteCommand("delete from tasks where task_owner =(select id from users where mobile_phone='90"+ userPhoneNumber +"') and status in (1,2); ", "martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public User addSecurityAllTasks(String userPhoneNumber, String scooter_code, String location) {
		try {
			scooter_code = scooter_code.substring(0, 3).toUpperCase();
			//CREATE NEW SCOOTER(S)
			provider.ExecuteCommand("delete from rides where scooter_id in (select id from scooters where code in ('" + scooter_code + "1','" + scooter_code + "2','" + scooter_code + "3','" + scooter_code + "4','" + scooter_code + "5')); "
					+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + scooter_code + "1','" + scooter_code + "2','" + scooter_code + "3','" + scooter_code + "4','" + scooter_code + "5')); "
					+ "delete from scooters where code in ('" + scooter_code + "1','" + scooter_code + "2','" + scooter_code + "3','" + scooter_code + "4','" + scooter_code + "5'); "
					+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + scooter_code + "1','" + scooter_code + "2','" + scooter_code + "3','" + scooter_code + "4','" + scooter_code + "5')); "
					+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + scooter_code + "1','" + scooter_code + "2','" + scooter_code + "3','" + scooter_code + "4','" + scooter_code + "5')); "
					+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
					+ " ('"+scooter_code+"1',1,1,95,'"+location.substring(0,8)+"e','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
					+ " ('"+scooter_code+"2',1,1,95,'"+location.substring(0,8)+"f','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
					+ " ('"+scooter_code+"3',1,1,95,'"+location.substring(0,8)+"g','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
					+ " ('"+scooter_code+"4',1,1,95,'"+location.substring(0,8)+"s','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
					+ " ('"+scooter_code+"5',1,1,95,'"+location.substring(0,8)+"6','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
					, "martiDB");

		//TASKLARI AYARLAR
		provider.ExecuteCommand("delete from tasks where task_owner = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
				+ "INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until) VALUES "
				+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,4,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"1'),10,'"+location.substring(0,8)+"e',0,NULL,'"+location.substring(0,8)+"e',NULL,NULL,'2020-08-11 23:00:00.000'),"
				+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,3,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"2'),11,'"+location.substring(0,8)+"f',0,NULL,'"+location.substring(0,8)+"f',NULL,NULL,'2020-08-11 23:00:00.000'),"
				+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,2,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"3'),12,'"+location.substring(0,8)+"g',0,NULL,'"+location.substring(0,8)+"g',NULL,NULL,'2020-08-11 23:00:00.000'),"
				+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"4'),13,'"+location.substring(0,8)+"s',0,NULL,'"+location.substring(0,8)+"s',NULL,NULL,'2020-08-11 23:00:00.000'),"
				+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"5'),14,'"+location.substring(0,8)+"6',0,NULL,'"+location.substring(0,8)+"6',NULL,NULL,'2020-08-11 23:00:00.000');"
				, "martiDB");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

		public User addSecurityStolenTask(String userPhoneNumber, String scooter_code, String location) {
			try {
				scooter_code = scooter_code.toUpperCase();
				//CREATE NEW SCOOTER(S)
				provider.ExecuteCommand("delete from security_action_logs where user_id = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
						+ "delete from rides where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooters where code in ('" + scooter_code + "'); "
						+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						
						+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
						+ " ('"+scooter_code+"',1,1,95,'"+location+"','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
						, "martiDB");

			//TASKLARI AYARLAR
			provider.ExecuteCommand("delete from tasks where task_owner = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
					+ "INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until) VALUES "
					+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,4,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"'),10,'"+location+"',0,NULL,'"+location+"',NULL,NULL,'2020-08-11 23:00:00.000');"
					, "martiDB");
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
	}
		
		public User addSecuritySuspectTask(String userPhoneNumber, String scooter_code, String location) {
			try {
				scooter_code = scooter_code.toUpperCase();
				//CREATE NEW SCOOTER(S)
				provider.ExecuteCommand("delete from rides where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooters where code in ('" + scooter_code + "'); "
						+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						
						+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
						+ " ('"+scooter_code+"',1,1,95,'"+location+"','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
						, "martiDB");

			//TASKLARI AYARLAR
			provider.ExecuteCommand("delete from tasks where task_owner = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
					+ "INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until) VALUES "
					+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,3,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"'),11,'"+location+"',0,NULL,'"+location+"',NULL,NULL,'2020-08-11 23:00:00.000');"
					, "martiDB");
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
	}
		
		public User addSecurityNotFoundTask(String userPhoneNumber, String scooter_code, String location) {
			try {
				scooter_code = scooter_code.toUpperCase();
				//CREATE NEW SCOOTER(S)
				provider.ExecuteCommand("delete from rides where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooters where code in ('" + scooter_code + "'); "
						+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						
						+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
						+ " ('"+scooter_code+"',1,1,95,'"+location+"','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
						, "martiDB");

			//TASKLARI AYARLAR
			provider.ExecuteCommand("delete from tasks where task_owner = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
					+ "INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until) VALUES "
					+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,2,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"'),12,'"+location+"',0,NULL,'"+location+"',NULL,NULL,'2020-08-11 23:00:00.000');"
					, "martiDB");
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
	}
		
		public User addSecurityCustomerTask(String userPhoneNumber, String scooter_code, String location) {
			try {
				scooter_code = scooter_code.toUpperCase();
				//CREATE NEW SCOOTER(S)
				provider.ExecuteCommand("delete from rides where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooters where code in ('" + scooter_code + "'); "
						+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						
						+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
						+ " ('"+scooter_code+"',1,1,95,'"+location+"','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
						, "martiDB");

			//TASKLARI AYARLAR
			provider.ExecuteCommand("delete from tasks where task_owner = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
					+ "INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until) VALUES "
					+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"'),13,'"+location+"',0,NULL,'"+location+"',NULL,NULL,'2020-08-11 23:00:00.000');"
					, "martiDB");
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
	}
		
		public User addSecurityLockControlTask(String userPhoneNumber, String scooter_code, String location) {
			try {
				scooter_code = scooter_code.toUpperCase();
				//CREATE NEW SCOOTER(S)
				provider.ExecuteCommand("delete from rides where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooters where code in ('" + scooter_code + "'); "
						+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + scooter_code + "')); "
						
						+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
						+ " ('"+scooter_code+"',1,1,95,'"+location+"','2020-05-29 15:02:32.596',90,'1234','1234',true,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,4,0.00,0.69,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
						, "martiDB");

			//TASKLARI AYARLAR
			provider.ExecuteCommand("delete from tasks where task_owner = (select id from users where mobile_phone = '90"+ userPhoneNumber +"'); "
					+ "INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until) VALUES "
					+ " ((select id from users where mobile_phone = '90"+ userPhoneNumber +"'),(select id from users where mobile_phone = '90"+ userPhoneNumber +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ scooter_code +"'),14,'"+location+"',0,NULL,'"+location+"',NULL,NULL,'2020-08-11 23:00:00.000');"
					, "martiDB");
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
	}
		
	
}