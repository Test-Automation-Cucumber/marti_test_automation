package DataPreparation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;
import utilities.TestBase;
import dbmodel.*;
//import dbmodel.DataPreparation.MobilServiceData;
import java.text.DateFormat;

public class Data_MobilService {
	Provider provider;
	
	// ******************************************GLOBAL_PARAMETERS**************************************
	String resetUserPhone; 			
	String resetMartiName; 			
	String resetLocation;			
	String resetScooterType;		
	String resetTookVehicle; 	 	
	String resetVehiclePlate;	 	
	String resetUserEmail;

	public Data_MobilService() throws Throwable {
		provider = new Provider();
	}

	@Test(priority = 0)
	public void SetCustomer() throws Throwable {
		
//    	//DATA OLUSTURMA
//		System.setProperty("resetUserPhone", "5309945452");
//		System.setProperty("resetMartiName", "MTN3");
//		System.setProperty("resetScooterType", "Panzer");
//		System.setProperty("resetLocation", "sxk9m8gze");		
//		System.setProperty("resetTookVehicle", "Evet");
//		System.setProperty("resetSelectVehicle", "34 MOB 01");
//		System.setProperty("resetUserEmail", "metin@marti.tech");
		
		resetUserPhone = System.getProperty("resetUserPhone");
		resetMartiName = System.getProperty("resetMartiName").substring(0, 3).toUpperCase();
		resetLocation = System.getProperty("resetLocation");
		resetScooterType = System.getProperty("resetScooterType");
		resetTookVehicle = System.getProperty("resetTookVehicle");
		resetVehiclePlate = System.getProperty("resetSelectVehicle");
		resetUserEmail = System.getProperty("resetUserEmail");
		
		System.out.println(resetUserPhone);
		System.out.println(resetMartiName);
		System.out.println(resetLocation);
		System.out.println(resetScooterType);
		System.out.println(resetTookVehicle);
		System.out.println(resetVehiclePlate);
		
		if (resetUserPhone.length()<9) {
			throw new Exception("Scooter kodu yok !'");
		}	
		
		if (resetMartiName.length()<3) {
			throw new Exception("Scooter kodu yok !'");
		}	
		
		if (resetLocation.length()<8) {
			throw new Exception("Konum bilgisi yok !'");
		}
		

		if (resetScooterType.equals("ES2"))
			resetScooterType = "1";
		else if (resetScooterType.equals("MAX"))
			resetScooterType = "2";
		else if (resetScooterType.equals("Fıstık"))
			resetScooterType = "3";
		else if (resetScooterType.equals("Panzer"))
			resetScooterType = "4";
		else if (resetScooterType.equals("E-bike"))
			resetScooterType = "5";
		else if (resetScooterType.equals("ES5"))
			resetScooterType = "6";
		else if (resetScooterType.equals("CEKİÇ"))
			resetScooterType = "7";
		else if (resetScooterType.equals("Anadolu 1"))
			resetScooterType = "8";
		

		String queryResetTookVehicle ="";
		if(resetTookVehicle.equals("Evet"))
			queryResetTookVehicle = "INSERT INTO public.car_deliveries " + 
					"(car_id, user_id, picked_at, delivered_at, pick_km, picking_photos, delivering_photos, has_issue, issue, deliver_km, assistant_user_id) " + 
					"VALUES((select id from cars where plate = '"+ resetVehiclePlate +"'), (select id from users where mobile_phone = '90" + resetUserPhone + "'), now(), NULL, 10, '{d630fa6d-e3c7-40ee-9e11-61baddae4241.png,149091b4-123c-44b5-bf8c-b8fc95f9ac26.png,7664c797-517c-404f-b7a0-113eb470e028.png,a08d49a4-d06a-4eb4-be92-1696e730746e.png,a62028cf-b026-4520-9af3-7aeb3373d1ff.png}', NULL, false, '', NULL, NULL);";
		

		//VARDIYALARI OLUSTURUR
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
				
		provider.ExecuteCommand("update users set role_id = 18 where mobile_phone = '90"+ resetUserPhone +"';"
				+ "delete from user_shifts where user_id = (select id from users where mobile_phone = '90" + resetUserPhone + "'); "
				+ "INSERT INTO public.user_shifts(user_id, shift_date, shift_no, created_by, created_at, updated_at, car_id, start_time, end_time, warehouse_id, fence_group) VALUES"
				+ "((select id from users where mobile_phone = '90" + resetUserPhone + "'), current_date, 1, 185, current_date, NULL, (select id from cars where plate ='"+ resetVehiclePlate +"'), '" + today + " 07:30:00" + "', '" + today + " 16:30:00" + "', 0, 10), "
				+ "((select id from users where mobile_phone = '90" + resetUserPhone + "'), current_date, 2, 185, current_date, NULL, (select id from cars where plate ='"+ resetVehiclePlate +"'), '" + today + " 15:30:00" + "', '" + todayPlus1 + " 00:30:00" + "', 0, 10), "
				+ "((select id from users where mobile_phone = '90" + resetUserPhone + "'), current_date, 3, 185, current_date, NULL, (select id from cars where plate ='"+ resetVehiclePlate +"'), '" + today + " 23:30:00" + "', '" + todayPlus1 + " 08:30:00" + "', 0, 10); "	
				+ " delete from car_deliveries where user_id =(select id from users where mobile_phone='90"+ resetUserPhone +"') and delivered_at is null; "
				+ " delete from car_deliveries where car_id =(select id from cars where plate ='"+ resetVehiclePlate +"') and delivered_at is null; "
				+ queryResetTookVehicle, "martiDB");

		provider.ExecuteCommand("delete from rides where scooter_id in (select id from scooters where code in ('" + resetMartiName + "1','" + resetMartiName + "2','" + resetMartiName + "3','" + resetMartiName + "4','" + resetMartiName + "5','" + resetMartiName + "6')); "
				+ "delete from reservations where scooter_id in (select id from scooters where code in ('" + resetMartiName + "1','" + resetMartiName + "2','" + resetMartiName + "3','" + resetMartiName + "4','" + resetMartiName + "5','" + resetMartiName + "6')); "
				+ "delete from scooters where code in ('" + resetMartiName + "1','" + resetMartiName + "2','" + resetMartiName + "3','" + resetMartiName + "4','" + resetMartiName + "5','" + resetMartiName + "6'); "
				+ "delete from operator_action_log where scooter_id in (select id from scooters where code in ('" + resetMartiName + "1','" + resetMartiName + "2','" + resetMartiName + "3','" + resetMartiName + "4','" + resetMartiName + "5','" + resetMartiName + "6')); "
				+ "delete from scooter_repair_records where scooter_id in (select id from scooters where code in ('" + resetMartiName + "1','" + resetMartiName + "2','" + resetMartiName + "3','" + resetMartiName + "4','" + resetMartiName + "5','" + resetMartiName + "6')); "
				
				+ "INSERT INTO scooters (code,\"version\",status_id,battery_status,last_known_point,last_update_time,module_battery_status,lock_code,sim_card_no,is_available,timezone,last_ride_id,last_stolen_time,mqtt_password,firmware_version,bt_mac,hdop,attention,geofence_group,need_repair,need_repair_note,gsm_available,gsm_location,mobile_phone_number,total_km,last_fota_time,sub_status,charging_station_id,scooter_body_version_id,starting_price,recurring_price,iot_locked,last_locked_time,life,reservation_price,created_at,last_check_time) VALUES "
				+ " ('"+resetMartiName+"1',1,13,95,'"+resetLocation.substring(0,8)+"e','2020-05-29 15:02:32.596',90,'1234','1234',false,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,true,'test otomasyon',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,"+resetScooterType+",0.01,0,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
				+ " ('"+resetMartiName+"2',1,13,95,'"+resetLocation.substring(0,8)+"f','2020-05-29 15:02:32.596',90,'1234','1234',false,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,true,'test otomasyon',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,"+resetScooterType+",0.01,0,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
				+ " ('"+resetMartiName+"3',1,13,95,'"+resetLocation.substring(0,8)+"g','2020-05-29 15:02:32.596',90,'1234','1234',false,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,true,'test otomasyon',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,"+resetScooterType+",0.01,0,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
				+ " ('"+resetMartiName+"4',1,8, 95,'"+resetLocation.substring(0,8)+"s','2020-05-29 15:02:32.596',90,'1234','1234',false,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,"+resetScooterType+",0.01,0,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
				+ " ('"+resetMartiName+"5',1,8, 95,'"+resetLocation.substring(0,8)+"6','2020-05-29 15:02:32.596',90,'1234','1234',false,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,"+resetScooterType+",0.01,0,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736'),"
				+ " ('"+resetMartiName+"6',1,8, 95,'"+resetLocation.substring(0,8)+"7','2020-05-29 15:02:32.596',90,'1234','1234',false,3,0,NULL,NULL,'1.000.000',NULL,0,false,10,false,'',true,NULL,'5066174696',0,'2020-01-30 14:05:00.000',NULL,NULL,"+resetScooterType+",0.01,0,true,NULL,0,0.19,'2020-02-19 00:00:00.000','2019-05-18 12:12:27.736');"
				, "martiDB");
				
		provider.ExecuteCommand("delete from tasks where created_by = (select id from users where mobile_phone = '90" + resetUserPhone +"'); "
				+ " INSERT INTO tasks (created_by,task_owner,status,priority,created_date,start_date,end_date,cancelled_by,scooter_id,task_type,to_location,task_count,blocked_by,task_location,blocked_reason,battery_id,valid_until,geofence_group) VALUES "
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ resetMartiName +"1'),4,'"+resetLocation.substring(0,8)+"e',NULL,NULL,'"+resetLocation.substring(0,8)+"e',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ resetMartiName +"2'),4,'"+resetLocation.substring(0,8)+"f',NULL,NULL,'"+resetLocation.substring(0,8)+"f',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ resetMartiName +"3'),4,'"+resetLocation.substring(0,8)+"g',NULL,NULL,'"+resetLocation.substring(0,8)+"g',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ resetMartiName +"4'),8,'"+resetLocation.substring(0,8)+"s',NULL,NULL,'"+resetLocation.substring(0,8)+"s',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ resetMartiName +"5'),8,'"+resetLocation.substring(0,8)+"6',NULL,NULL,'"+resetLocation.substring(0,8)+"6',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,(select id from scooters where code = '"+ resetMartiName +"6'),8,'"+resetLocation.substring(0,8)+"1',NULL,NULL,'"+resetLocation.substring(0,8)+"1',NULL,NULL,'2020-03-10 23:00:00.000',10),"
					
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,NULL,16,'"+resetLocation.substring(0,8)+"9',NULL,NULL,'"+resetLocation.substring(0,8)+"9',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,NULL,16,'"+resetLocation.substring(0,8)+"8',NULL,NULL,'"+resetLocation.substring(0,8)+"8',NULL,NULL,'2020-03-10 23:00:00.000',10),"
				+ " ((select id from users where mobile_phone = '90"+ resetUserPhone +"'),(select id from users where mobile_phone = '90"+ resetUserPhone +"'),1,1,now(),NULL,NULL,NULL,NULL,16,'"+resetLocation.substring(0,8)+"5',NULL,NULL,'"+resetLocation.substring(0,8)+"5',NULL,NULL,'2020-03-10 23:00:00.000',10);"
							
				, "martiDB");

		mailAt(resetUserEmail);
	}
		
		   public void mailAt(String user_mail){
	           final String username = "martitestotomasyon@gmail.com";  //otomasyon maili aç
	           final String password = "2242ZXc+";
	           Properties properties = new Properties();
	           properties.put("mail.smtp.auth", "true");
	           properties.put("mail.smtp.starttls.enable", "true");
	           properties.put("mail.smtp.host", "smtp.gmail.com");
	           properties.put("mail.smtp.port", "587");

	           Session session = Session.getInstance(properties,
	                         new javax.mail.Authenticator() {
	                  protected PasswordAuthentication getPasswordAuthentication() {
	                         return new PasswordAuthentication(username, password);
	                  }
	           }); 
	           try {
	                  Message message = new MimeMessage(session);
	                  message.setFrom(new InternetAddress("martitestotomasyon@gmail.com"));
	                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(user_mail));
	                  message.setSubject("'Taşıyıcı' test kullanıcısı bilgileri");
	                  message.setText("'Taşıyıcı' test kullanıcısı bilgileri: \n" +
	                			"------------------------------------------- \n" +
	                			"Kullanıcı telefon no : " + resetUserPhone + "\n" +
	                			"------------------------------------------- \n" +
	                			"Kullanıcıya tanımlanmış toplama görevi: " + resetMartiName + "1,   Lokasyon: " + resetLocation.substring(0,8) + "e,   Scooter tipi: " + System.getProperty("resetScooterType") +" \n" +
	                			"Kullanıcıya tanımlanmış toplama görevi: " + resetMartiName + "2,   Lokasyon: " + resetLocation.substring(0,8) + "f,   Scooter tipi: " + System.getProperty("resetScooterType") +" \n" +
	                			"Kullanıcıya tanımlanmış toplama görevi: " + resetMartiName + "3,   Lokasyon: " + resetLocation.substring(0,8) + "g,   Scooter tipi: " + System.getProperty("resetScooterType") +" \n" +
	                			"------------------------------------------- \n" +                                                                     
	                			"Kullanıcıya tanımlanmış bırakma görevi: " + resetMartiName + "4,   Lokasyon: " + resetLocation.substring(0,8) + "s,   Scooter tipi: " + System.getProperty("resetScooterType") +" \n" +
	                			"Kullanıcıya tanımlanmış bırakma görevi: " + resetMartiName + "5,   Lokasyon: " + resetLocation.substring(0,8) + "6,   Scooter tipi: " + System.getProperty("resetScooterType") +" \n" +
	                			"Kullanıcıya tanımlanmış bırakma görevi: " + resetMartiName + "6,   Lokasyon: " + resetLocation.substring(0,8) + "7,   Scooter tipi: " + System.getProperty("resetScooterType") +" \n" +
	                			"------------------------------------------- \n" +
	                			" \n" +
	                			"------------------------------------------------------- \n" +
	                			"DATA RESET.. \n" +
	                			"-------------------------------------------------------"); 
	                  Transport.send(message);

	           } catch (MessagingException ex) {
	                  throw new RuntimeException(ex);
	           }
	     }
		

}

