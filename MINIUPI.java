import java.util.*;
class MINIUPI
{
	static Scanner sc = new Scanner(System.in);
	float balance;
	int PIN;

	int GENPIN()
	{
		Random r = new Random();
		PIN=1000+r.nextInt(9000);
		System.out.println("YOUR PIN IS : "+PIN);
		return PIN;
	}

	boolean AUTHENTICATE()
	{
		System.out.println("Enter 4 digit PIN");
		int a_pin = sc.nextInt();

		if(PIN==a_pin)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	float Deposit(float a)
	{

		if(AUTHENTICATE())
		{
			balance+=a;
			System.out.println("Transaction successful");
			System.out.println("Current Balance : "+balance);
			return balance;
		}

		else
		{
			System.out.println("Wrong Pin Entered");
			return balance;
		}


	}

	float Withdraw(float a)
	{
		if(AUTHENTICATE())
		{
			if(a>balance)
			{
				System.out.println("Insufficient funds");
				return balance;
			}

			else
			{
				balance = balance-a;
				System.out.println("Transaction successful");
				System.out.println("Current Balance : "+balance);
				return balance;
			}
		}
		else
		{
			System.out.println("Wrong Pin Entered");
			return balance;
		}
	}

	float BalanceEnquiry()
	{
		if(AUTHENTICATE())
		{
			System.out.println("Current Balance : "+balance);
			return balance;
		}

		else
		{
			System.out.println("Wrong Pin Entered");
			return balance;
		}
	}

	void Display()
	{
		System.out.println("Enter your choice");
		System.out.println("1.Balance Enquiry	2.Deposit     3.Withdraw");

		int n = sc.nextInt();

		switch (n){
			case 1 :
				{
					BalanceEnquiry();
					break;
				}
			
			case 2 :
				{
					System.out.println("Enter deposit amount");
					Deposit(sc.nextFloat());
					break;
				}

			case 3 :
				{
					System.out.println("Enter withdraw amount");
					Withdraw(sc.nextFloat());
					break;
				}

			default :
				{
					System.out.println("invalid Input");
				}
			}
	}

		public static void main(String [] args)
		{
			MINIUPI x = new MINIUPI();
			x.GENPIN();

			int a;
			do
			{
				x.Display();

				System.out.println("1.New Transaction	2.Exit");
				a = sc.nextInt();
			}
			while(a==1);
			System.out.println("Thankyou for using our MINI ATM");
		}
}