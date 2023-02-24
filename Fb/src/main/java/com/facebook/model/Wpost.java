package com.facebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wpost")
public class Wpost {

	@Id
	@Column
	int wid;
	String name,p,sender,dop;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getDop() {
		return dop;
	}
	public void setDop(String dop) {
		this.dop = dop;
	}
	public Wpost(int wid, String name, String p, String sender, String dop) {
		super();
		this.wid = wid;
		this.name = name;
		this.p = p;
		this.sender = sender;
		this.dop = dop;
	}
	public Wpost() {
		super();
	}
	@Override
	public String toString() {
		return "Wpost [wid=" + wid + ", name=" + name + ", p=" + p + ", sender=" + sender + ", dop=" + dop + "]";
	}
	    
	
}
