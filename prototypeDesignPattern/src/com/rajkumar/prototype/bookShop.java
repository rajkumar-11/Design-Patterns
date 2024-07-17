package com.rajkumar.prototype;

import java.util.ArrayList;
import java.util.List;

public class bookShop implements Cloneable {
	private String shopName;
	List<Book> books = new ArrayList<>();

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "bookShop [shopName=" + shopName + ", books=" + books + "]";
	}

	public void loadData() {
		for (int i = 0; i < 10; i++) {
			Book b = new Book();
			b.setBid(i);
			b.setBname("Book" + i);
			getBooks().add(b);
		}

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	    
		bookShop shop= new bookShop();
		 
		for(Book b:getBooks())
		{
			shop.getBooks().add(b);
		}
		
		
		return shop;
	}

}
