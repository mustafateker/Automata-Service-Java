package Automata;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class admin {
	private String adminName;
	private String adminId;
	private String adminPassword;
	
	public admin() {
		
	}
	
	public admin (String adminName , String i, String adminPassword) {
		this.adminName = adminName;
		this.adminId = i;
		this.adminPassword = adminPassword;
	}
	public String getadminName() {
		return adminName;
	}
	public String getadminPassword() {
		return adminPassword;
	}
	public String getadminId() {
		return adminId;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
