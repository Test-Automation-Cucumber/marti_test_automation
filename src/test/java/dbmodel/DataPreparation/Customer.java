package dbmodel.DataPreparation;

import dbmodel.Provider;

public class Customer {
	Provider provider = new Provider();

	// *musteri oluşturur
	public Customer addCustomer(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from customers where mobile_phone = '" + customer_phone_no + "'; "
					+ "INSERT INTO public.customers (\"name\", email, mobile_phone_country_code, mobile_phone, sms_code, is_enabled, \"language\", skip_verification, created_at, free_tier, tckn, birthdate, notes, is_kvkk_read, kvkk_date, tckn_validated, id_photo) "
					+ "VALUES('Metin emre Şen', 'noreply@martiautomation.com', '90', '"+ customer_phone_no +"', '0000', true, 'tr-TR', false, (now() - interval '1 minute'), false, '42682855444', '1987-10-03', NULL, true, (now() - interval '30 second'), true, NULL);",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *musterinin suruslerini temizle
	public Customer deleteCustomerRides(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from rides where customer_id = (select id from customers where mobile_phone = '"
							+ customer_phone_no + "')",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *ozet ekrani degerlerini getirir
	public String getChargedRidePrice(String customer_phone_no) {
		String actualPrice = "";
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			actualPrice = provider.ExecuteScalar(
					"select charged_price from rides where  customer_id = (select id from customers where mobile_phone = '"
							+ customer_phone_no + "') order by id desc",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actualPrice;
	}
	
	// *musterinin surus ekle    -----------------buraya birde scooter kodu ekleyebilirsin. o scooterida hazir hale getirir. jenkinse zaten en az 1 scooter baglayacaksin.
	public Customer addCustomerFinishedRide(String customer_phone_no, String scooter_code) {
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
			public int addCustomerContinuesRide(String customer_phone_no, String scooter_code) {
				String rideId = "";
				try {
					if (customer_phone_no.length() < 9) {
						throw new Exception("hatali musteri numarasi");
					}
					provider.ExecuteCommand("delete from rides where end_time is null and customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');"
							+ "delete from rides where end_time is null and scooter_id = (select id from scooters where code = '"+ scooter_code  +"');"
							+ "UPDATE scooters set status_id = 2, is_available = false where code = '"+ scooter_code +"';",
							"martiDB");
					
					rideId = provider.ExecuteScalar("INSERT INTO rides (customer_id, scooter_id, start_time, end_time, distance, charged_price, credit_card_id, payment_service_payment_token, map_data, payment_successful, photo, approved_user_id, approved_date, approved_note, is_approved, actual_price, last_ride_point, payment_service_transaction_id, geofence_group, provision_transaction, additional_payment_transaction, user_id, campaign_id, reservation_id, reservation_price, start_mileage, end_mileage, ride_refunded_by_mileage, gross_price) VALUES" + 
							"((select id from customers where mobile_phone = '" + customer_phone_no + "'), (select id from scooters where code = '"+ scooter_code  +"'), now(), NULL, NULL, 1.99, NULL, NULL, '{sxk9m8gz8}', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '12897526', 10, '12198366', NULL, NULL, NULL, 0, 0.00, 0, NULL, NULL, 0) returning id;",
							"martiDB");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Integer.parseInt(rideId);
			}
	
	// *kupon temizleme
	public Customer deleteCustomerCoupons(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from coupons where creator_customer_id in ((select id from customers where mobile_phone = '" + customer_phone_no + "'), 1); ",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *kupon kontrol
	public int countCustomerCoupon(String customer_phone_no) {
		int count = 0;
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			count = Integer.parseInt(provider.ExecuteScalar(
					"select count(*) from coupons where creator_customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');",
					"martiDB"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	// *kullanilmamis kupon getir
	public String getCustomerCoupon(String customer_phone_no) {
	String couponCode = "";
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			couponCode = provider.ExecuteScalar(
					"select code from coupons where creator_customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "') order by id desc;",
					"martiDB");
			provider.ExecuteCommand("update coupons set creator_customer_id = 1 where creator_customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "')",
					"martiDB");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return couponCode;
	}
	
//	// *kupon kontrol
//	public int addCustomerCoupon(String customer_phone_no) {
//		int count = 0;
//		try {
//			if (customer_phone_no.length() < 9) {
//				throw new Exception("hatali musteri numarasi");
//			}
//			count = Integer.parseInt(provider.ExecuteScalar(
//					"select count(*) from coupons where creator_customer_id = (select id from coupons where mobile_phone = '" + customer_phone_no + "');",
//					"martiDB"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return count;
//	}
	
	// *müşteri kartlarını temizleme
	public Customer deleteCreditCards(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from credit_cards where customer_id = (select id from customers where mobile_phone = '"
							+ customer_phone_no + "')",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	//*müşteri kart ekleme
	public String addCreditCard(String customer_phone_no) {
		String ccNumber = "";
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			ccNumber = provider.ExecuteScalar(
					"INSERT INTO credit_cards (customer_id,last_4_digits,created_date,payment_service_token,is_default,name_on_card,is_active,user_token,cc_type,cc_association) VALUES "
							+ "((select id from customers where mobile_phone = '" + customer_phone_no
							+ "'),'0001', now(),'bMvAMjACbfvmd7PrAf9/dp9Y9/E=',true,'AUTO AUTOMATION',true,'j+ut1NFSt/mymsCjC8QCJsACtKY=','DEBIT_CARD','VISA') returning id;",
					"martiDB");
		} catch (Exception ex) {

		}
		return ccNumber;
	}
	
	//*müşteri hatalı kart ekleme
	public Customer addErrorCreditCard(String customer_phone_no) {
	try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"INSERT INTO credit_cards (customer_id,last_4_digits,created_date,payment_service_token,is_default,name_on_card,is_active,user_token,cc_type,cc_association) VALUES "
							+ "((select id from customers where mobile_phone = '" + customer_phone_no
							+ "'),'1234', now(),'LpM8o3CV+7g+VZRntnUODq5bm98=',true,'HATALI KART',true,'BPu9Hq50Qbsboh5rWv6BXNAvwf4=',NULL,NULL)",
					"martiDB");
		} catch (Exception ex) {

		}
		return this;
	}
	
	// *customer rezervasyon temizle
	public Customer deleteCustomerReservations(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from reservations where customer_id = (select id from customers where mobile_phone = '"+ customer_phone_no + "')",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}	
	
	// *customer rezervasyon ekle
	public Customer addCustomerReservations(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand("INSERT INTO public.reservations (customer_id, scooter_id, start_time, end_time, amount, payment_status, card_id, payment_time, user_id, payment_service_payment_token, payment_service_transaction_id) VALUES "
					+ "((select id from customers where mobile_phone = '"+ customer_phone_no + "'), (select id from scooters where code='AUT1'), now(), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);","martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}	
	
	// *customer tckn validasyon
	public Customer addTcknAndKvkkValidation(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"update customers set tckn = '42682855444', is_kvkk_read = true, kvkk_date = now(), tckn_validated = true, birthdate ='1987-10-03' where mobile_phone = '" + customer_phone_no +"';",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *customer tckn validasyon
	public Customer deleteTcknValidation(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"update customers set tckn = NULL, tckn_validated = false, birthdate = NULL where mobile_phone = '" + customer_phone_no +"';",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *customer kvkk validasyon
	public Customer deleteKvkkValidation(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"update customers set is_kvkk_read = false, kvkk_date = NULL where mobile_phone = '" + customer_phone_no +"';",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	
	// *musteriye borç oluştur
	public Customer addCustomerDebt(String customer_phone_no, int amount) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"INSERT INTO public.customer_ride_debts (customer_id, ride_id, card_id, amount, created_date, update_date, is_success, user_id, payment_token, transaction_token) VALUES "
					+ "((select id from customers where mobile_phone = '" + customer_phone_no + "'), 1, NULL, " + amount + ", now(), NULL, false, NULL, NULL, NULL);",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *musterinin borclarını sil
	public Customer deleteCustomerDebt(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from customer_ride_debts where customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "')",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *musterinin arıza kaydi bildirimlerini sil
	public Customer deleteCustomerIssues(String customer_phone_no) {
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			provider.ExecuteCommand(
					"delete from issues where customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');",
					"martiDB");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	// *musterinin ariza kaydi bildirim sayisini getirir
	public int countCustomerIssue(String customer_phone_no) {
		int count = 0;
		try {
			if (customer_phone_no.length() < 9) {
				throw new Exception("hatali musteri numarasi");
			}
			count = Integer.parseInt(provider.ExecuteScalar(
					"select count(*) from issues where customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');",
					"martiDB"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	// *musteriyi ofis etrafındaki bi alanda kampanyaya dahil eder.
	public Customer addLocalCampaign(String customer_phone_no) {
		try {
		provider.ExecuteCommand("delete from customer_popups where customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');"
				+ "INSERT INTO customer_popups (customer_id, \"date\", user_id, is_read, popup_id, read_date) VALUES"
				+ " ((select id from customers where mobile_phone = '" + customer_phone_no + "'), (now() - interval '10 minute'), NULL, false, 2, NULL);"
//				+ "update campaign_locations set is_active = " + status + " where id = 1;"
				,	"martiDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	// *musteriyi ofis etrafındaki bi alanda kampanyaya dahil eder.
	public Customer deleteLocalCampaign(String customer_phone_no) {
		try {
		provider.ExecuteCommand("delete from customer_popups where customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');"
				,	"martiDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	// *açık rıza metnini set eder
	public Customer setExplicitConsentForm(String customer_phone_no, boolean status) {
		try {
		provider.ExecuteCommand("update customer_detail set is_explicit_consent_text_confirmed = " + status + " where  customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');", "martiDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	// *açık rıza metnini set eder
	public Customer setMinus16DaysForExplicitConsentFormDate(String customer_phone_no) {
		try {
		provider.ExecuteCommand("update customer_detail set explicit_consent_text_update_date = (now() - interval '16 day') where  customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');", "martiDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	// *açık rıza metnini set eder
	public Customer minus14DaysForExplicitConsentFormDate(String customer_phone_no) {
		try {
		provider.ExecuteCommand("update customer_detail set explicit_consent_text_update_date = (now() - interval '14 day') where  customer_id = (select id from customers where mobile_phone = '" + customer_phone_no + "');", "martiDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

}