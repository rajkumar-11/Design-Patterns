package com.rajkumar.prototype;

public class PrototypeDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		bookShop bs = new bookShop();
		bs.setShopName("Novelty");
		bs.loadData();
		System.out.println(bs);

		bookShop bs1 = (bookShop) bs.clone();
		bs1.setShopName("A1");
		// bs1.remove
		// bs1.loadData();
		System.out.println(bs1);

	}

}
