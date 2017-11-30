package com.spring.dto;

public class userDto {
	private int U_ID;
	private String USER_EMAIL;
	private String USER_PASSWORD;
	private int AUTH_LEV;
	 
	
	
	public userDto() {}
	
	public userDto(int u_ID, String uSER_EMAIL, String uSER_PASSWORD, int aUTH_LEV) {
		super();
		U_ID = u_ID;
		USER_EMAIL = uSER_EMAIL;
		USER_PASSWORD = uSER_PASSWORD;
		AUTH_LEV = aUTH_LEV;
	}
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public int getAUTH_LEV() {
		return AUTH_LEV;
	}
	public void setAUTH_LEV(int aUTH_LEV) {
		AUTH_LEV = aUTH_LEV;
	}

	@Override
	public String toString() {
		return "userDto [U_ID=" + U_ID + ", USER_EMAIL=" + USER_EMAIL + ", USER_PASSWORD=" + USER_PASSWORD
				+ ", AUTH_LEV=" + AUTH_LEV + "]";
	}
	
	
	
	
}
