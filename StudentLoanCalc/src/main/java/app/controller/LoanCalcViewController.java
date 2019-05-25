package app.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import app.StudentCalc;
import app.helper.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField LTerm;

	@FXML
	private TextField AddPayment;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private Button calculate;
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
				
		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);	
		
		lblTotalPayemnts.setText("123");
		
		double dIntRate = Double.parseDouble(InterestRate.getText());
		int dTerm = Integer.parseInt(LTerm.getText());
		double dAddPayment = Double.parseDouble(AddPayment.getText());
		LocalDate localDate = PaymentStartDate.getValue();
		
		Loan dLoan = new Loan(dLoanAmount, dIntRate, dTerm, dAddPayment, localDate, false, 0);

		System.out.println(localDate);
	}
}
