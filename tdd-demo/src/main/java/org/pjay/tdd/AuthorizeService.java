/**
 * 
 */
package org.pjay.tdd;

/**
 * @author vkonduru3
 *
 */
public class AuthorizeService {

	private DAO dao;

	public AuthorizeService(DAO dao) {
		this.dao = dao;
	}

	public boolean authorize(UserInfo userInfo) {
		if (userInfo != null && userInfo.getUserid() != null) {
			UserInfo userInfoRep = dao.getUserByID(userInfo);
			System.out.println(userInfoRep);
			if (userInfoRep.getUserid().equals(userInfo.getUserid())) {
				return true;
			}
		}
		return false;
	}

}
