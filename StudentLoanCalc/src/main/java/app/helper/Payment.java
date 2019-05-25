package app.helper;

import java.util.Date;
import org.apache.poi.ss.formula.functions.*;
import java.math.*;
import java.text.DecimalFormat;


public class Payment {
	
	private int PaymentID;
	private Date DueDate;
	private double IPMT;
	private double PPMT;
	private double TotalPrinciple;
	private double Balance;
	private Loan l;
	
	public Payment(int paymentID, Date dueDate, double balance, Loan l) {
//		super();
		
		PaymentID = paymentID;
		DueDate = dueDate;
		Balance = balance;
		this.l = l;
		this.PPMT = Math.abs(getPPMT());
		this.TotalPrinciple = this.PPMT + l.getExtraPayment();
//		this.IPMT = (balance - this.TotalPrinciple) * (l.getIntRate()/12);
		this.IPMT = (balance) * (l.getIntRate()/12);
		this.Balance = balance - this.TotalPrinciple;
		
	}	
	
	
	
	private double getPPMT() {
		return Finance.ppmt(l.getIntRate()/12,this.PaymentID,l.getTerm()*12, l.getLoanAmount());
	}
	
	public double getBalance() {
		Balance = Math.round(Balance*100.0)/100.0;
		return Balance;
	}
	
	public void setBalanceToZero() {
		Balance = 0;
	}
	
}
