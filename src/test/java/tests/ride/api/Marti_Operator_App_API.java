package tests.ride.api;

import utilities.TestBase;
import org.testng.annotations.Test;
import dbmodel.DataPreparation.Customer;
import dbmodel.DataPreparation.Scooter;
import dbmodel.DataPreparation.User;

public class Marti_Operator_App_API extends TestBase {

//	String tcId;
//	String endPoint;
//	String type;
//	String statusCode;
//	String version;
//	String inputParameters;
	Customer customer;
	Scooter scooter;
	User user;
	
	public Marti_Operator_App_API() throws Throwable {
/////////////////////////////////////////////---baseUrl ve test account no burda set ediliyor////////////////////////////////////////
		baseUrl = "https://operation-dev.martiscooter.com";
		queryGetParameters = "select * from operator_app_api_test_parameters order by id;";

		customer = new Customer();
		scooter = new Scooter();
		user = new User();
	}
	
//	@Test//(priority = 1)
//	public void TC_001_app_getConfig() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		// *******************PAGE INSTANTIATIONS*******************
//		
//		// *********************CALL SERVICE***********************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//	}
//	
//	@Test//(priority = 2)
//	public void TC_002_photo_upload() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//	}
//	
//	@Test//(priority = 3)
//	public void TC_003_repairman_addRepairActionLog() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//		//scooter için bi işlem daha yapmak lazım. bulursun
//		
//		
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(",")), activeScooterRepairId);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 4)
//	public void TC_004_repairman_addRepairResultMaterials() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//		//scooter için bi işlem daha yapmak lazım. bulursun
//		
//		
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(",")), activeScooterRepairId);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//
//	@Test//(priority = 5)
//	public void TC_005_repairman_completedRepairRecordDetail() throws Exception {
//		// *******************SET PARAMETERS************************
//				int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//				String accessToken = "";
//				String userPhoneNumber = testParameters[caseNumber][6];
//				String scooterCode = testParameters[caseNumber][7];		
//				String inputParameter = testParameters[caseNumber][5];
//				String repairRecordAddinputParameter = testParameters[16][5];
//				String activeScooterRepairId;
//				
//				// *******************PAGE INSTANTIATIONS*******************
//				user
//				.changeUserRole(userPhoneNumber, 37);
//				
//				scooter
//				.addScooter(scooterCode);
//				
//				accessToken = get_token(caseNumber);
//				repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//				run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//				
//				activeScooterRepairId = scooter
//						.getScooterActiveRepairId(scooterCode);
//				
//				// *********************CALL SERVICE************************
//				inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 1), activeScooterRepairId).trim();
//				run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 6)
//	public void TC_006_repairman_completeRepair() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//		//scooter için bi işlem daha yapmak lazım. bulursun
//		
//		
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(",")), activeScooterRepairId);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}	
//	
//	@Test//(priority = 7)
//	public void TC_007_repairman_continueRepair() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37)
//		.deleteRepairRecords(userPhoneNumber);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 1), activeScooterRepairId).trim();
// 		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 8)
//	public void TC_008_repairman_listRepairHistory() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 9)
//	public void TC_009_repairman_listRepairRecords() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		// *******************PAGE INSTANTIATIONS*******************
//		
//		
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//	}
//	
//	@Test//(priority = 10)
//	public void TC_010_repairman_listRepairResultCategories() throws Exception {
//	// *******************SET PARAMETERS************************
//	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//	String accessToken = "";
//	String userPhoneNumber = testParameters[caseNumber][6];
//	String scooterCode = testParameters[caseNumber][7];		
//	String inputParameter = testParameters[caseNumber][5];
//	String repairRecordAddinputParameter = testParameters[16][5];
//	String activeScooterRepairId;
//	
//	// *******************PAGE INSTANTIATIONS*******************
//	user
//	.changeUserRole(userPhoneNumber, 37)
//	.deleteRepairRecords(userPhoneNumber);
//	
//	scooter
//	.addScooter(scooterCode);
//	
//	accessToken = get_token(caseNumber);
//	repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//	run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//	activeScooterRepairId = scooter
//			.getScooterActiveRepairId(scooterCode);
//	
//	// *********************CALL SERVICE************************
//	inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 1), activeScooterRepairId).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 11)
//	public void TC_011_repairman_listRepairResultMaterials() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//		//scooter için bi işlem daha yapmak lazım. bulursun
//		
//		
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(",")), activeScooterRepairId);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 12)
//	public void TC_012_repairman_outOfOrderRequest() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//		//scooter için bi işlem daha yapmak lazım. bulursun
//		
//		
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
////		 *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(",")), activeScooterRepairId);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 13)
//	public void TC_013_repairman_repairRecordDetail() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37)
//		.deleteRepairRecords(userPhoneNumber);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 1), activeScooterRepairId).trim();
//			run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 14)
//	public void TC_014_repairman_startRepair() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];		
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String inputParameter = testParameters[caseNumber][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//	
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 1), activeScooterRepairId).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 15)
//	public void TC_015_repairman_waitingRepairPart() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String userPhoneNumber = testParameters[caseNumber][6];
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		String repairRecordAddinputParameter = testParameters[16][5];
//		String activeScooterRepairId;
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		user
//		.changeUserRole(userPhoneNumber, 37)
//		.deleteRepairRecords(userPhoneNumber);
//		
//		scooter
//		.addScooter(scooterCode);
//		
//		accessToken = get_token(caseNumber);
//		repairRecordAddinputParameter = repairRecordAddinputParameter.replace(repairRecordAddinputParameter.substring(repairRecordAddinputParameter.indexOf(":") + 2, repairRecordAddinputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(16, accessToken, repairRecordAddinputParameter);  // repairRecord/add
//		
//		activeScooterRepairId = scooter
//				.getScooterActiveRepairId(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.length() - 1), activeScooterRepairId).trim();
// 		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 16)
//	public void TC_016_repairRecord_add() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//	
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 2, inputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 17)
//	public void TC_017_repairRecord_listRepairCategories() throws Exception {
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
//	
//	@Test//(priority = 18)
//	public void TC_018_repairRecord_listRepairTypes() throws Exception {
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
//	
//	@Test//(priority = 19)
//	public void TC_019_scooter_closeBatteryCap() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];		
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);		
//	}
//	
//	@Test//(priority = 20)
//	public void TC_020_scooter_find() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 21)
//	public void TC_021_scooter_headLightOff() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 22)
//	public void TC_022_scooter_headLightOn() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 23)
//	public void TC_023_scooter_openBatteryCap() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 24)
//	public void TC_024_scooter_ringBell() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.indexOf(",") - 1), scooterCode);
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 25)
//	public void TC_025_scooter_sendIotUnlock() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 26)
//	public void TC_026_scooter_showLatestLocations() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
//	@Test//(priority = 27)
//	public void TC_027_scooter_showLatestRidePhoto() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		String scooterCode = testParameters[caseNumber][7];
//		String inputParameter = testParameters[caseNumber][5];
//		// *******************PAGE INSTANTIATIONS*******************
//		scooter
//		.addScooter(scooterCode);
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
//		run_ws(caseNumber, accessToken, inputParameter);
//	}
//	
	@Test//(priority = 28)
	public void TC_028_swapper_batteryDetail() throws Exception {
//		// *******************SET PARAMETERS************************
		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
		String accessToken = "";
		String scooterCode = testParameters[caseNumber][7];
		String inputParameter = testParameters[caseNumber][5];
		// *******************PAGE INSTANTIATIONS*******************
		scooter
		.addScooter(scooterCode);
		// *********************CALL SERVICE************************
		accessToken = get_token(caseNumber);
		inputParameter = inputParameter.replace(inputParameter.substring(inputParameter.indexOf(":") + 3, inputParameter.length() - 2), scooterCode).trim();
		run_ws(caseNumber, accessToken, inputParameter);
	}
//	
//		@Test//(priority = 29)
//	public void TC_029_swapper_checkVerificationComplete() throws Exception {
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
//	
//	@Test//(priority = 30)
//public void TC_030_swapper_completeMountTask() throws Exception {
//	// *******************SET PARAMETERS************************
//	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//	String accessToken = "";
//
//	// *******************PAGE INSTANTIATIONS*******************
//
//	// *********************CALL SERVICE************************
//	accessToken = get_token(caseNumber);
//	run_ws(caseNumber, accessToken, null);
//}
//
//	@Test//(priority = 31)
//public void TC_031_swapper_createBatteryRepairRecord() throws Exception {
//	// *******************SET PARAMETERS************************
//	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//	String accessToken = "";
//
//	// *******************PAGE INSTANTIATIONS*******************
//
//	// *********************CALL SERVICE************************
//	accessToken = get_token(caseNumber);
//	run_ws(caseNumber, accessToken, null);
//}
//	
//	@Test//(priority = 32)
//public void TC_032_swapper_findBrokenBatteries() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		
//		// *******************PAGE INSTANTIATIONS*******************
//
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//}
//
//	@Test//(priority = 33)
//public void TC_033_swapper_findCollectedBatteries() throws Exception {
//	// *******************SET PARAMETERS************************
//	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//	String accessToken = "";
//
//	// *******************PAGE INSTANTIATIONS*******************
//
//	// *********************CALL SERVICE************************
//	accessToken = get_token(caseNumber);
//	run_ws(caseNumber, accessToken, null);
//}
//	
//	@Test//(priority = 34)
//public void TC_034_swapper_findGivenBatteries() throws Exception {
//	// *******************SET PARAMETERS************************
//	int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//	String accessToken = "";
//
//	// *******************PAGE INSTANTIATIONS*******************
//
//	// *********************CALL SERVICE************************
//	accessToken = get_token(caseNumber);
//	run_ws(caseNumber, accessToken, null);
//}
//	
//	@Test//(priority = 35)
//	public void TC_035_swapper_findIncompleteTaskReasons() throws Exception {
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
//	@Test//(priority = 36)
//	public void TC_036_swapper_findMissingBatteryTasks() throws Exception {
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
//	@Test//(priority = 37)
//	public void TC_037_swapper_giveBackBattery() throws Exception {
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
//	
//	@Test//(priority = 38)
//	public void TC_038_swapper_listBatteriesOnOperator() throws Exception {
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
//	
//	@Test//(priority = 39)
//	public void TC_039_swapper_login() throws Exception {
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
//	@Test//(priority = 40)
//	public void TC_040_swapper_mountBattery() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		
//		// *******************PAGE INSTANTIATIONS*******************
//
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//
//	}
//	@Test//(priority = 41)
//	public void TC_041_swapper_pickUpBattery() throws Exception {
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
//	
//	@Test//(priority = 42)
//	public void TC_042_swapper_sendCapLock() throws Exception {
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
//	
//	@Test//(priority = 43)
//	public void TC_043_swapper_sendCapUnlock() throws Exception {
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
//	
//	@Test//(priority = 44)
//	public void TC_044_swapper_taskIncompleted() throws Exception {
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
//
//	@Test//(priority = 45)
//	public void TC_045_swapper_tasks() throws Exception {
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
//
//	@Test//(priority = 46)
//	public void TC_046_vehicle_assignAssistant() throws Exception {
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
//	
//	@Test//(priority = 47)
//	public void TC_047_vehicle_deliver() throws Exception {
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
//	
//	@Test//(priority = 48)
//	public void TC_048_vehicle_findAssignedVehicle() throws Exception {
//		// *******************SET PARAMETERS************************
//		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
//		String accessToken = "";
//		
//		// *******************PAGE INSTANTIATIONS*******************
//
//		// *********************CALL SERVICE************************
//		accessToken = get_token(caseNumber);
//		run_ws(caseNumber, accessToken, null);
//		}
//	
//	@Test//(priority = 49)
//	public void TC_049_vehicle_findPickedVehicle() throws Exception {
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
//	
//	@Test//(priority = 50)
//	public void TC_050_vehicle_pickUp() throws Exception {
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
//	
//	@Test//(priority = 51)
//	public void TC_051_warehouse_acceptBatteries() throws Exception {
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
//	
//	@Test//(priority = 52)
//	public void TC_052_warehouse_changeBatteryStatus() throws Exception {
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
//	
//	@Test//(priority = 53)
//	public void TC_053_warehouse_listBatteries() throws Exception {
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
//	
//	@Test//(priority = 54)
//	public void TC_054_warehouse_listWaitingBatteries() throws Exception {
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
//
//	@Test//(priority = 55)
//	public void TC_055_warehouse_listWarehouses() throws Exception {
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
//	
//	@Test//(priority = 56)
//	public void TC_056_warehouse_login() throws Exception {
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
//	
//	@Test//(priority = 57)
//	public void TC_057_warehouse_transferBatteries() throws Exception {
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
//	
//	@Test//(priority = 58)
//	public void TC_058_warehouse_transferBatteriesForAccept() throws Exception {
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
//	
////	@Test//(priority = 59)
////	public void TC_059_swapper_verify() throws Exception {  bunu ztn hep kullaniyorsun
////		// *******************SET PARAMETERS************************
////		int caseNumber = Integer.parseInt(new Throwable().getStackTrace()[0].getMethodName().substring(3, 6));
////		String accessToken = "";
////		
////		// *******************PAGE INSTANTIATIONS*******************
////
////		// *********************CALL SERVICE************************
////		accessToken = get_token(caseNumber);
////		run_ws(caseNumber, accessToken, null);
////	}
}

