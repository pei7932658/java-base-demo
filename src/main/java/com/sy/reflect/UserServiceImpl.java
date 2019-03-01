package com.sy.reflect;

public class UserServiceImpl implements UserService{
	public void insertUser(int userid){
		System.out.println("模拟插入用户记录;用户ID:"+userid);
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteUser(int userid){
		System.out.println("模拟删除用户记录;用户ID:"+userid);
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectUser(int userid){
		System.out.println("模拟查询用户记录;用户ID:"+userid);
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
