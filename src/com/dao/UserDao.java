package com.dao;

import static com.util.HrmConstants.USERTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dao.provider.UserDynaSqlProvider;
import com.domain.User;


public interface UserDao {
	//根据登录用户名和密码查询员工
	@Select("SELECT * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	public User selectByLoginnameAndPassword(@Param("loginname")String loginname,@Param("password")String password);
	//根据id查询用户	
	@Select("SELECT * from "+USERTABLE+"where ID=#{id}")
	public User selectById(Integer id);
	//根据id删除用户
	@Select("DELETE * from "+USERTABLE+"where id=#{id}")
	public void deleteById(Integer id);
	//动态修改用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	public void update(User user);
	// 动态分页 查询用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWithParam")
	public List<User> selectByPage(Map<String,Object> params);
	//根据参数查询用户总数
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	public Integer count(Map<String,Object> params);
	//动态插入用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	public void save(User user);
}
