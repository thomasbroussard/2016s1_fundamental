package fr.tbr.bankaccount.datamodel;

public class Customer {
	
	private String name;
	private String address;
	private InvestmentAccount[] investAccounts;
	private SavingsAccount[] savingsAccounts;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address.equals("")){
			System.out.println("not a valid address");
			return;
		}
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InvestmentAccount[] getInvestAccounts() {
		return investAccounts;
	}
	public void setInvestAccounts(InvestmentAccount[] investAccounts) {
		this.investAccounts = investAccounts;
	}
	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
	}
	public void setSavingsAccounts(SavingsAccount[] savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
	
	
	

}
