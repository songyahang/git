package com.bw.entity;

public class Student {
	private int sid;
	private String sname;
	private String sex;
	private String age;
	private String birthday;
	private String card;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String sname, String sex, String age,
			String birthday, String card) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.card = card;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex
				+ ", age=" + age + ", birthday=" + birthday + ", card=" + card
				+ "]";
	}
	
	

}
