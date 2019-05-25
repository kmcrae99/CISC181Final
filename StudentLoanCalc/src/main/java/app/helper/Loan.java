package app.helper;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.LinkedList;


public class Loan {	
	
	private double LoanAmount;
	private double IntRate;
	private int Term;
	private double ExtraPayment;
	private Date FirstDueDate;
	private boolean bCompoundType;
	private double FV;
	
	private LinkedList<Payment> LoanPayments = new LinkedList<Payment>();
	
	public Loan(double loanAmount, double intRate, int term, double extraPayment, Date firstDueDate, boolean bCompoundType, double fV) {
		
		super();
		LoanAmount = loanAmount;
		IntRate = intRate;
		Term = term;
		ExtraPayment = extraPayment;
		FirstDueDate = firstDueDate;
		this.bCompoundType = bCompoundType;
		FV = fV;
		
		double rollingBalance = this.LoanAmount;
		int ipaymentID = 0;
		
		do {
			
			Payment p = new Payment(++ipaymentID, firstDueDate, rollingBalance, this);

			LoanPayments.add(p);
			rollingBalance = p.getBalance();
			
			System.out.print("PaymentID: ");
			System.out.print(ipaymentID);
			System.out.print(" ");
			System.out.println(LoanPayments.getLast().getBalance());
				
			if (LoanPayments.getLast().getBalance() <= 0) {
				LoanPayments.getLast().setBalanceToZero();
				break;	
			}
		
		} while (true);

		System.out.println(LoanPayments.size());
		

	}

	public double getLoanAmount() {
		return LoanAmount;
	}

	public double getIntRate() {
		return IntRate;
	}
	public int getTerm() {
		return Term;
	}

	public double getExtraPayment() {
		return ExtraPayment;
	}

	public double getFV() {
		return FV;
	}

	public static Date setDate(String date) {
		
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
		} catch (ParseException e) {
			return null;
		
		}
	}
		
	
}
