package com.visa.prj.client;

import com.visa.prj.entity.Account;

public class AccountClient {

	
	public static void main(String[] args) {

		Account first = new Account();
		Account second = new Account();
		
		first.deposit(5000);
		second.deposit(3500);
		
		System.out.println("First Account:");
		System.out.println(first.getBalance());
		
		System.out.println("Second Account:");
		System.out.println(second.getBalance());
		
		System.out.println("Accounts: " + Account.getCount());
		
	}

}
