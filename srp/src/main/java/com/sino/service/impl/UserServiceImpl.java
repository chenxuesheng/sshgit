package com.sino.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.sino.model.User;
import com.sino.service.UserServcie;

@Service
public class UserServiceImpl extends JdbcDaoSupport implements UserServcie {
	
	
	@Resource
	public void setJdbc(JdbcTemplate jdbcTemplate){
		super.setJdbcTemplate(jdbcTemplate);
	}


	public void add(User user) {
		getJdbcTemplate().update("insert into sys_user(id, name)  values(?,?)",
				new Object[] { user.getId(), user.getName() });
	}

	public void delete(String id) {
		getJdbcTemplate().update("delete from sys_user where id=?", new Object[] { id });
	}

	public void update(User user) {
		getJdbcTemplate().update("update sys_user set name=? where id=?",
				new Object[] { user.getName(), user.getId() });
	}

	public User getById(String id) {
		return (User) getJdbcTemplate().queryForObject("select id,name from sys_user where id=?", new Object[] { id },
				new UserRowMapper());
	}

	public List<User> findAll() {
		return getJdbcTemplate().queryForList("select id, name from sys_user");
	}

	class UserRowMapper implements RowMapper {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId( rs.getString("id"));
			user.setName(rs.getString("name"));
			return user;
		}
	}

}
