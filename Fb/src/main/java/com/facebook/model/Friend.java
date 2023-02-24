package com.facebook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
	int fid;
    
	String sender,rec,dor;
	int status;

	@Override
	public String toString() {
		return "Friends [fid=" + fid + ", sender=" + sender + ", rec=" + rec + ", dor=" + dor + ", status=" + status
				+ "]";
	}
	public Friend() {
		
	}
	public Friend(int fid, String sender, String rec, String dor, int status) {
	
		this.fid = fid;
		this.sender = sender;
		this.rec = rec;
		this.dor = dor;
		this.status = status;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRec() {
		return rec;
	}
	public void setRec(String rec) {
		this.rec = rec;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
