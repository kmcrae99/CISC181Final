package pkgUT;

import static org.junit.Assert.*;

import java.util.Date;
//import java.text.SimpleDateFormat;  

import org.junit.Test;

import app.helper.Loan;

public class LoanTest {

	@Test
	public void LoanTest() {
		double loanAmount = 100000;
		double intRate = 0.07;
		int term = 20;
		double extraPayment = 0;
		Date firstDueDate = Loan.setDate("2019-06-01");
		boolean bCompoundType = false;
		double fV = 0;
		
		Loan l = new Loan(loanAmount, intRate, term, extraPayment, firstDueDate, bCompoundType, fV);
	}

}
