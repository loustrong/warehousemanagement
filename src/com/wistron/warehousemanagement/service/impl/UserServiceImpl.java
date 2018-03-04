package com.wistron.warehousemanagement.service.impl;

import com.wistron.warehousemanagement.dao.IUserDao;
import com.wistron.warehousemanagement.dao.impl.UserDaoImpl;
import com.wistron.warehousemanagement.domain.User;
import com.wistron.warehousemanagement.exception.UserExistException;
import com.wistron.warehousemanagement.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void registerUser(User user) throws UserExistException {
		if (userDao.find(user.getUserName())!=null) {
			//checked exception 
			//unchecked exception
			//�?酉���仃�����內靽⊥�酉�������歇蝬�
			throw new UserExistException("瘜典�����歇摮嚗���");
			
			
		}
		userDao.add(user);
	}

	@Override
	public User loginUser(String userName, String userPwd) {
		return userDao.find(userName, userPwd);
	}

}
