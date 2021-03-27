/**
 * 
 */
package org.pjay.tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author vkonduru3
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorizeServiceTest {
	
	AuthorizeService authorizeService;
	UserInfo userInfo;
	DAO dao;
	
	@Before
	public void initialize() {
		dao = mock(DAO.class);
		authorizeService = new AuthorizeService(dao);
		userInfo = new UserInfo();
		userInfo.setUserid(null);
		userInfo.setPassword(null);
	}
	
	public UserInfo getstubbedUserInfo_Failure() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserid("kumar");
		userInfo.setPassword("kumar");
		return userInfo;
	}
	
	public UserInfo getstubbedUserInfo_Success() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserid("vijay");
		userInfo.setPassword("vijay");
		return userInfo;
	}
	
	@Test
	public void testAuthorize() {
		boolean authorize = authorizeService.authorize(userInfo);
		assertFalse(authorize);
	}
	
	
	// Old
	@Test
	public void testAuthorizeFailure() {
		UserInfo getstubbedUserInfo_Success = getstubbedUserInfo_Success();
		when(dao.getUserByID(getstubbedUserInfo_Success)).thenReturn(getstubbedUserInfo_Failure());
		boolean authorize = authorizeService.authorize(getstubbedUserInfo_Success);
		Mockito.verify(dao).getUserByID(getstubbedUserInfo_Success);
		assertFalse(authorize);
	}
	
	@Test
	public void testAuthorizeSuccess() {
		UserInfo getstubbedUserInfo_Success = getstubbedUserInfo_Success();
		when(dao.getUserByID(getstubbedUserInfo_Success)).thenReturn(getstubbedUserInfo_Success());
		boolean authorize = authorizeService.authorize(getstubbedUserInfo_Success);
		Mockito.verify(dao).getUserByID(getstubbedUserInfo_Success);
		assertTrue(authorize);
	}
	
	@After
	public void tearDown() {
		authorizeService = null;
		userInfo = null;
		dao = null;
	}

}
