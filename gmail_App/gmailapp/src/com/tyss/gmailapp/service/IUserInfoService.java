package com.tyss.gmailapp.service;

import com.tyss.gmailapp.userinfo.UserInfo;

public interface IUserInfoService {
	public UserInfo compose(String email);
	public UserInfo showInbox(String email);
	public UserInfo createAccount();
	public UserInfo validate(String email);
}
