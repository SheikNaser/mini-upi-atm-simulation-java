// ==============================
// MINI BANKING SYSTEM (v2.0)
//
// Features:
// - PIN authentication for all operations
// - Mobile number verification for secure transactions
// - OTP-based confirmation for deposits and high-value withdrawals
// - Conditional OTP for withdrawals greater than 2000
// - Menu-driven user interaction
// ==============================

import java.util.*;

class MINIUPI
{
	// ===== INPUT & UTILITY OBJECTS =====

	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();

	// ===== USER ACCOUNT DETAILS =====

	long userMobile;
	int userPIN;
	int systemOTP;
	double currentBalance;

	// ===== OTP GENERATION =====

	// Generates a 4-digit OTP for transaction verification

	int generateOTP()
	{
		systemOTP = 1000 + r.nextInt(9000);
		System.out.println("4-digit otp sent to your registered mobile number : "+systemOTP);	 // For simulation/demo purposes
		return systemOTP;
	}

	// ===== OTP VALIDATION =====

	// Validates user-entered OTP with generated OTP

	boolean validateOTP()
	{
		System.out.println("Enter OTP");
		int userOTP = sc.nextInt();

		if(userOTP == systemOTP)
		{
			System.out.println("OTP Verification Successful");
			return true;
		}
		else
		{
			System.out.println("OTP verification failed!");
			System.out.println("Wrong OTP entered");
			return false;
		}
	}

	// ===== MOBILE VERIFICATION =====
	// Verifies if entered mobile matches registered mobile

	boolean validateMobile()
	{
		System.out.println("Enter Mobile Number");
		long enteredMobile = sc.nextLong();

		if(enteredMobile == userMobile)
		{
			System.out.println("Mobile number verification successful!");
			return true;
		}
		else
		{
			System.out.println("Mobile number verification failed!");
			System.out.println("Incorrect Mobile Number");
			return false;
		}
	}

	// ===== PIN AUTHENTICATION =====
	// Authenticates user using 4-digit PIN before operations

	boolean validatePIN()
	{
		System.out.println("Enter 4 digit PIN");
		int enteredPIN = sc.nextInt();

		if(enteredPIN == userPIN)
		{
			System.out.println("Authentication Successful!");
			return true;
		}
		else
		{
			System.out.println("Authentication failed!");
			System.out.println("Incorrect PIN");
			return false;
		}
	}

	// ===== BALANCE ENQUIRY =====
	// Displays current balance after PIN verification

	void checkBalance()
	{
		if(validatePIN())
		{
			System.out.printf("Available balance : ₹%.2f\n", currentBalance);
		}
	}

	// ===== DEPOSIT FUNCTION =====
	// Requires PIN + Mobile + OTP verification before deposit

	void depositAmount()
	{
		if(validatePIN())
		{
			System.out.print("Enter deposit amount : ");
			double depositAmount = sc.nextDouble();

			// Prevent invalid deposits

			if(depositAmount <= 0)
			{
				System.out.println("Invalid deposit amount!");
				return;
			}
			else
			{
				if(validateMobile())
				{
					generateOTP();

					if(validateOTP())
					{
						currentBalance = currentBalance + depositAmount;
						System.out.println("Amount deposited successfully!");
						System.out.printf("Available balance : ₹%.2f\n", currentBalance);
						systemOTP = 0; 	// Reset OTP after success
					}
					else
					{
						System.out.println("Deposit failed!");
					}
				}
				else
				{
					System.out.println("Deposit failed!");
				}
			}
		}
		else
		{
			System.out.println("Deposit failed!");
		}
	}

	// ===== WITHDRAW FUNCTION =====
	// - Requires PIN authentication
	// - No OTP for <= 2000
	// - OTP required for > 2000

	void withdrawAmount()
	{
		if(validatePIN())
		{
			System.out.print("Enter withdraw amount : ");
			double withdrawAmount = sc.nextDouble();

			// Prevent invalid input

			if(withdrawAmount <= 0)
			{
				System.out.println("Invalid withdraw request!");
				return;
			}
			else if(withdrawAmount > currentBalance)
			{
				System.out.println("Insufficient funds!");
				return;
			}
			else
			{
				// Small transactions (no OTP)

				if(withdrawAmount <= 2000.00)
				{
					currentBalance = currentBalance - withdrawAmount;
					System.out.println("Amount withdrawn successfully!");
					System.out.printf("Available balance : ₹%.2f\n", currentBalance);
				}
				else
				{
					// High-value transaction → OTP required

					if(validateMobile())
					{
						generateOTP();

						if(validateOTP())
						{
							currentBalance = currentBalance - withdrawAmount;
							System.out.println("Amount withdrawn successfully!");
							System.out.printf("Available balance : ₹%.2f\n", currentBalance);
							systemOTP = 0;
						}
						else
						{
							System.out.println("Withdraw failed!");
						}
					}
					else
					{
						System.out.println("Withdraw failed!");
					}
				}
			}
		}
	}

	// ===== MENU DISPLAY =====
	// Displays options and routes user to selected operation

	void menuDisplay()
	{
		System.out.println("Enter your choice");
		System.out.println(" 1. Deposit");
		System.out.println(" 2. Withdraw");
		System.out.println(" 3. Balance Enquiry");
		System.out.println(" Any number to Exit");

		int input = sc.nextInt();

		switch(input)
		{
			case 1:
				depositAmount();
				break;

			case 2:
				withdrawAmount();
				break;

			case 3:
				checkBalance();
				break;

			default:
				System.out.println("Thank you for using our MINI BANK SERVICE!!");
		}
	}

	// ===== MAIN METHOD =====
	// Initializes account and controls transaction loop

	public static void main(String[] args)
	{
		MINIUPI obj = new MINIUPI();

		System.out.println("Enter opening balance");
		obj.currentBalance = sc.nextDouble();

		System.out.println("Enter user mobile number");
		obj.userMobile = sc.nextLong();

		System.out.println("Set your 4 digit secure PIN");
		obj.userPIN = sc.nextInt();

		int choice;

		do
		{
			obj.menuDisplay();

			System.out.println();
			System.out.println("Continue");
			System.out.println("1. Yes    2. No");

			choice = sc.nextInt();
		}
		while(choice == 1);

		System.out.println("Thank you for using our MINI BANK SERVICE!!");
	}
}