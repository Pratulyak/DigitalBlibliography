package edu.unsw.comp9321;

import java.io.Serializable;
import java.util.*;
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Book> items;
	public ShoppingCart(){
		this.items = new LinkedList<Book>();
	}
	
	public void addItem(Book b){
		this.items.add(b);
	}

	public List<Book> getItems() {
		return items;
	}

	public void setItems(List<Book> items) {
		this.items = items;
	}

	public int getItemsSize(){
		return this.items.size();
	}
	
}
