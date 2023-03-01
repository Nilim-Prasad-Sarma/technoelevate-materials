package com.tyss.gmailapp.dao;

import com.tyss.gmailapp.userinfo.UserInfo;

public interface IUserInfoDao {
	public UserInfo compose(String email);
	public UserInfo showInbox(String email);
	public UserInfo createAccount(String user_name,String password,String email);
	public UserInfo validate(String email,String password);
}
