package com.naver.board.domain;

public class MovieVO {
	
	private String mname;
	private String sdate;
	private String genre;
	private String rate; 
	private String dname;
	private String aname;
	
	
	public MovieVO(String mname, String sdate, String genre, String rate, String dname, String aname) {
		super();
		this.mname = mname;
		this.sdate = sdate;
		this.genre = genre;
		this.rate = rate;
		this.dname = dname;
		this.aname = aname;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
}
