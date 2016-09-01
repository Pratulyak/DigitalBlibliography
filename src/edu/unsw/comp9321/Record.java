package edu.unsw.comp9321;

import java.util.List;

public class Record {
	private String type;
	private List<String> Authors;
	private String Title;
	private String publisher;
	private int year;
	private long pages;
	private long isbn;
	private String ee;
	
	public Record(String title,String publisher,int year,long pages,long isbn,String ee,String type){
		this.Title = title;
		this.publisher = publisher;
		this.year = year;
		this.pages = pages;
		this.isbn = isbn;
		this.ee = ee;
		this.type =type; 
	}

	public List<String> getAuthors() {
		return Authors;
	}

	public void setAuthors(List<String> authors) {
		Authors = authors;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getEe() {
		return ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
