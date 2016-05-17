package fr.tbr.bankaccount.datamodel;

public class SavingsAccount extends Account{

	private Double interestRate;

	
	
	
	
	public SavingsAccount(Double interestRate, Double balance) {
		super();
		this.interestRate = interestRate;
		this.setBalance(balance);
	}



	public void withdraw(Double amount) {
	
		double balance = this.getBalance() - amount;
		this.setBalance(balance);
		
	}

	
	
	public void computeSavings() {
		
		Double current_balance = this.getBalance(); 
		
		//We can use Double and double transparently,
		//thanks to the java "autoboxing" feature.
		//Double double = 20.0;
		//int i = 20;
		//Integer intWrapper = i;
		double new_balance = current_balance + current_balance * this.interestRate;
		this.setBalance(new_balance);
		

		
	}

	/**
	 * 
	 * @return the interrest rate at this format : 3% => 0.03
	 */
	public Double getInterrestRate() {
		return interestRate;
	}

	/**
	 * Format for the interest rate : 3% => 0.03
	 * @param interrestRate
	 */
	public void setInterrestRate(Double interrestRate) {
		this.interestRate = interrestRate;
	}


	
}
