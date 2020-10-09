package tests.api;

import utilities.TestBase;
import org.testng.annotations.Test;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;

public class Marti_App_API extends TestBase {
	Customer customer;
	Scooter scooter;
	
	public Marti_App_API() throws Throwable {
/////////////////////////////////////////////---baseUrl ve test account no burda set ediliyor////////////////////////////////////////
		baseUrl = "https://customer-dev.martiscooter.com";
		queryGetParameters = "select * from ride_app_api_test_parameters order by id;";
		
		System.setProperty("platformName", "api");
		System.setProperty("appName", "ride");
		
		customer = new Customer();
		scooter = new Scooter();
	}
	
	@Test//(priority = 1)
	public void TC_001_app_getConfig() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		// *******************PAGE INSTANTIATIONS*******************
		
		// *********************CALL SERVICE***********************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 2)
	public void TC_002_campaign_list() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		// *******************PAGE INSTANTIATIONS*******************
		
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 3)
	public void TC_003_countries_list() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		// *******************PAGE INSTANTIATIONS*******************
		
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 4)
	public void TC_004_customer_addCouponToCustomer() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String couponCode = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		// *******************PAGE INSTANTIATIONS*******************
		customer.deleteCustomerCoupons(customerPhoneNumber);
		
		accessToken = get_token(caseNumber);
		run_ws(52, accessToken, null); // KUPON OLUSTURUR.
		
		couponCode = customer.getCustomerCoupon(customerPhoneNumber);
		
		// *********************CALL SERVICE************************
		couponCode = "{\"code\":\"" + couponCode.substring(couponCode.lastIndexOf(":") + 1).replace("}", "").replace("\"", "") + "\"}";
		run_ws(caseNumber, accessToken, couponCode);
	}

	@Test//(priority = 5)
	public void TC_005_customer_couponList() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 6)
	public void TC_006_customer_hasPopup() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}	
	
	@Test//(priority = 7)
	public void TC_007_customer_notificationCount() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 8)
	public void TC_008_customer_notificationList() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 9)
	public void TC_009_customer_payDebt() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String creditCardNumber = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		
		// *******************PAGE INSTANTIATIONS*******************
		creditCardNumber = customer.addCustomerDebt(customerPhoneNumber, 10)
				.deleteCreditCards(customerPhoneNumber)
				.addCreditCard(customerPhoneNumber);
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		creditCardNumber = "{\"cardId\":\"" + creditCardNumber.substring(creditCardNumber.lastIndexOf(":") + 1).replace("}", "").replace("\"", "") + "\"}";	
		run_ws(caseNumber, accessToken, creditCardNumber);
	}
	
	@Test//(priority = 10)
	public void TC_010_customer_readKvkk() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 11)
	public void TC_011_customer_readNotification() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 12)
	public void TC_01_customer_ridingDebts() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 13)
	public void TC_013_customer_signin() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 14)
	public void TC_014_customer_updateName() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
//	@Test//(priority = 15)
//	public void TC_015_customer_updateName() throws Exception {  bunu zaten her case icin cagiriyorsun mecburen...
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		
//		// *******************PAGE INSTANTIATIONS*******************
//
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//	}
	
	@Test//(priority = 16)
	public void TC_016_geofence_borders() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 17)
	public void TC_017_geofence_handshake() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 18)
	public void TC_018_geofence_iotUnlock() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String scooterCode = testParameters[caseNumber][7];		
		String customerPhoneNumber = testParameters[caseNumber][6];
		String ride_start_inputParameter = testParameters[45][5];  // ride/start 'in parametreleri cekiyor. id = 45
		String rideStartParametersRideCode = "";
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		
		rideStartParametersRideCode = ride_start_inputParameter.substring(ride_start_inputParameter.indexOf(":") + 3, ride_start_inputParameter.indexOf(",") - 1);
		ride_start_inputParameter = ride_start_inputParameter.replace(rideStartParametersRideCode, scooterCode);
		run_ws(45, accessToken, ride_start_inputParameter);  // surus baslatir
		run_ws(caseNumber, accessToken, null);

		// *********************LAST STAND************************
		customer.deleteCustomerRides(customerPhoneNumber);
	}
	
	@Test//(priority = 19)
	public void TC_019_geofence_ring() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 20)
	public void TC_020_geofence_solveChallenge() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 21)
	public void TC_021_history_list() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		
		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 22)
	public void TC_022_issue_contact() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");
		
		customer
		.deleteCustomerRides(customerPhoneNumber)
		.addCustomerContinuesRide(customerPhoneNumber, scooterCode);

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
		customer.deleteCustomerRides(customerPhoneNumber);
	}
	
	@Test//(priority = 23)
	public void TC_023_issue_requestScooter() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 24)
	public void TC_024_issue_send() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 25)
	public void TC_025_issue_types() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 26)
	public void TC_026_issue_uploadPhoto() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 27)
	public void TC_027_map_listAvailables() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
		@Test//(priority = 28)
	public void TC_028_paymentaddCard() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 29)
public void TC_029_payment_cardList() throws Exception {
	// *******************SET PARAMETERS************************
	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
	String accessToken = "";

	// *******************PAGE INSTANTIATIONS*******************

	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	run_ws(caseNumber, accessToken, null);
}
	@Test//(priority = 30)
public void TC_030_payment_default() throws Exception {
	// *******************SET PARAMETERS************************
	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
	String accessToken = "";

	// *******************PAGE INSTANTIATIONS*******************

	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	run_ws(caseNumber, accessToken, null);
}
	@Test//(priority = 31)
public void TC_031_payment_deleteCard() throws Exception {
	// *******************SET PARAMETERS************************
	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
	String accessToken = "";

	// *******************PAGE INSTANTIATIONS*******************

	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	run_ws(caseNumber, accessToken, null);
}
	
	@Test//(priority = 32)
public void TC_032_payment_setDefault() throws Exception {
	// *******************SET PARAMETERS************************
	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
	String accessToken = "";
	String customerPhoneNumber = testParameters[caseNumber][6];
	String scooterCode = testParameters[caseNumber][7];
	String inputParameter = testParameters[caseNumber][5];
	String creditCardId;
	String oldCreditCardId;	
//	// *******************PAGE INSTANTIATIONS*******************
	creditCardId = customer
			.deleteCreditCards(customerPhoneNumber)
			.addCreditCard(customerPhoneNumber);
	
	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	oldCreditCardId = inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() -2);
	inputParameter = inputParameter.replace(oldCreditCardId, creditCardId);
	
	
	
	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	run_ws(caseNumber, accessToken, inputParameter);
}

	@Test//(priority = 33)
public void TC_033_ride_checkBeforeReservation() throws Exception {
	// *******************SET PARAMETERS************************
	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
	String accessToken = "";

	// *******************PAGE INSTANTIATIONS*******************

	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	run_ws(caseNumber, accessToken, null);
}
	
	@Test//(priority = 34)
public void TC_034_ride_checkBeforeRide() throws Exception {
	// *******************SET PARAMETERS************************
	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
	String accessToken = "";

	// *******************PAGE INSTANTIATIONS*******************

	// *********************CALL SERVICE************************
	accessToken = get_token(caseNumber);
	run_ws(caseNumber, accessToken, null);
}
	
	@Test//(priority = 35)
	public void TC_035_ride_customerHasReservation() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}	
	@Test//(priority = 36)
	public void TC_036_ride_customerHasRide() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	@Test//(priority = 37)
	public void TC_037_ride_end() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		String inputParameter = testParameters[caseNumber][5];
		int rideId;
		String oldRideId;
		String creditCardId;
		String oldCreditCardId;
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");
		
		rideId = customer
		.addCustomerContinuesRide(customerPhoneNumber, scooterCode);
		
		creditCardId = customer
				.deleteCreditCards(customerPhoneNumber)
				.addCreditCard(customerPhoneNumber);
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);

		oldRideId = inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(","));
		oldCreditCardId = inputParameter.substring(inputParameter.indexOf("cardId\":") + 9, inputParameter.indexOf(",", 20));
		inputParameter = inputParameter.replace(oldRideId, Integer.toString(rideId));
		inputParameter = inputParameter.replace(oldCreditCardId, creditCardId);
		
		run_ws(caseNumber, accessToken, inputParameter);
	}	
	
	@Test//(priority = 38)
	public void TC_038_ride_getReviewCategories() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
	
	@Test//(priority = 39)
	public void TC_039_ride_paymentPreview() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");

		customer
		.addCustomerContinuesRide(customerPhoneNumber, scooterCode);

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
		customer.deleteCustomerRides(customerPhoneNumber);
	}
	@Test//(priority = 40)
	public void TC_040_ride_reservationEnd() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");

		customer
		.addCustomerReservations(customerPhoneNumber);

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);

	}
	@Test//(priority = 41)
	public void TC_041_ride_reservationPaymentPreview() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");

		customer
		.addCustomerReservations(customerPhoneNumber);

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);

		// *********************LAST STAND************************
		customer.
		deleteCustomerReservations(customerPhoneNumber);
	}
	
	@Test//(priority = 42)
	public void TC_042_ride_reservationStart() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);

		// *********************LAST STAND************************
		customer.
		deleteCustomerReservations(customerPhoneNumber);
	}
	
	@Test//(priority = 43)
	public void TC_043_ride_review() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String customerPhoneNumber = testParameters[caseNumber][6];
		String scooterCode = testParameters[caseNumber][7];
		String inputParameter = testParameters[caseNumber][5];
		int rideId;
		String oldRideId;
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");
		
		rideId = customer
		.addCustomerContinuesRide(customerPhoneNumber, scooterCode);
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);

		oldRideId = inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(","));
		inputParameter = inputParameter.replace(oldRideId, Integer.toString(rideId));
		
		run_ws(caseNumber, accessToken, inputParameter);
		
		// *********************LAST STAND************************
		customer.
		deleteCustomerRides(customerPhoneNumber);
	}
	
	@Test//(priority = 44)
	public void TC_044_ride_review() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
		
	}

	@Test//(priority = 45)
	public void TC_045_ride_start() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String scooterCode = testParameters[caseNumber][7];
		String customerPhoneNumber = testParameters[caseNumber][6];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
		customer.
		deleteCustomerRides(customerPhoneNumber);
	}

	@Test//(priority = 46)
	public void TC_046_ride_status() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String scooterCode = testParameters[caseNumber][7];
		String customerPhoneNumber = testParameters[caseNumber][6];
		String oldRideId = "";
		int rideId;
		String inputParameter = testParameters[caseNumber][5];
		
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode, "sxk9m8gyf");
		
		rideId = customer
		.addCustomerContinuesRide(customerPhoneNumber, scooterCode);
		
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		oldRideId = inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(","));
		inputParameter = inputParameter.replace(oldRideId, Integer.toString(rideId));
		run_ws(caseNumber, accessToken, inputParameter);
		
		// *********************LAST STAND************************
		customer.
		deleteCustomerRides(customerPhoneNumber);
	}
	
	@Test//(priority = 47)
	public void TC_047_ride_uploadPhoto() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************

	}
	
	@Test//(priority = 48)
	public void TC_048_settings_getMyProfile() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
	}
	
	@Test//(priority = 49)
	public void TC_049_settings_updateMyProfile() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
	}
	
	@Test//(priority = 50)
	public void TC_050_settings_uploadPhoto() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
		
		// *********************LAST STAND************************
	}
	
//	@Test//(priority = 51)
//	public void TC_051_settings_validateMyPhone() throws Exception {  bu artik kullanilmiyor.
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//
//		// *******************PAGE INSTANTIATIONS*******************
//
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//	}
	
	@Test//(priority = 52)
	public void TC_052_customer_generateInvitationCoupon() throws Exception {
		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";

		// *******************PAGE INSTANTIATIONS*******************

		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		run_ws(caseNumber, accessToken, null);
	}
}
