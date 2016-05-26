package com.mao.infocrawler.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mao.infocrawler.model.dao.UserDao;
import com.mao.infocrawler.model.dao.common.IOperations;
import com.mao.infocrawler.model.entity.User;
import com.mao.infocrawler.service.LoginService;
import com.mao.infocrawler.service.common.AbstractService;


@Service("loginService")
public class LoginServiceImpl extends AbstractService<User> implements LoginService {

    @Resource(name = "userDao")
    private UserDao dao;

    public LoginServiceImpl() {
        super();
    }

    @Override
    protected IOperations<User> getDao() {
        return this.dao;
    }

    @Override
    public boolean checkLogin(String id, String password) {
    	String sql = "select * from _user where id='"+id+"' and password='"+password+"'";
    	if(dao.query(sql).size()==1)
    	{
            return true;
        }else{
            return false;
        }
    }

	@Override
	public String registUser(String userid, String username, String password,
			String usertype) {
		String msg = "";
		String querysql = "select count(*) from _user where id='" +userid.trim()+"'";
		// 首先进行查询，查看数据库是否已经存在对应的主键
		if(dao.queryCount(querysql)>0){
			msg = "注册用户的工号已存在，请重新注册！";
		}else{
			User user = new User();
			user.setId(userid.trim());
			user.setPassword(password.trim());
			user.setUsername(username.trim());
			user.setUsertype(usertype);
//			String sql = "insert into _user(id,username,password,usertype) values('"+userid+"','"+username+"','"+password+"','"+usertype+"')";
			dao.create(user);
			msg = "注册成功！";
		}
		return msg;
	}

	@Override
	public User findOneUser(String id) {
		String sql = "select * from _user where id='" +id+ "'";
		return dao.findOneUser(sql);
	}
	
	

}
