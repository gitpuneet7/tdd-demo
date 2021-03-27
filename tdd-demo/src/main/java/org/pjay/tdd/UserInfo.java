package org.pjay.tdd;

public class UserInfo {

	private String userid;

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setPassword(String string) {
	}

	public String getUserid() {
		return userid;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + "]";
	}
}
