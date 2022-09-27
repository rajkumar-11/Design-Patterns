package com.phone;

public class Shop {
	public static void main(String[] args) {
		Phone phone = new PhoneBuilder().setOs("Android").setRam(2).getPhone();

		System.out.println(phone);
		
		
	}

}
