package com.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.util.HrmConstants.USERTABLE;

import java.util.Map;

import com.domain.User;
public class UserDynaSqlProvider {
	//动态修改用户
	public String updateUser(User user){
		return new SQL(){
			{	
				UPDATE(USERTABLE);
				if(user.getUsername() != null){
					SET(" username = #{username} ");
				}
				if(user.getLoginname() != null){
					SET(" loginname = #{loginname} ");
				}
				if(user.getPassword()!= null){
					SET(" password = #{password} ");
				}
				if(user.getStatus()!= null){
					SET(" status = #{status} ");
				}
				if(user.getCreateDate()!= null){
					SET(" create_date = #{createDate} ");
				}
				WHERE("id = #{id}");
			}
		}.toString();		
	}
	// 动态 分页查询用户
	public String selectWithParam(Map<String,Object> params){
		String sql= new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user")!= null){
					User user=(User)params.get("user");
					if(user.getUsername()!=null && !user.getUsername().equals("")){
						WHERE("username LIKE CONCAT('%',#{username},'%')");	
					}
					if(user.getStatus()!=null && !user.getStatus().equals("")){
						WHERE("status LIKE CONCAT('%',#{status},'%')");	
					}
				}
			}			
		}.toString();
		//分页
		if(params.get("pageModel")!=null){
			sql+="limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
		}
		return sql;
	}
	//根据参数查询用户总数
	public String count(Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user")!=null){
					User user=(User)params.get("user");
					if(user.getUsername()!=null && !user.getUsername().equals("")){
						WHERE("username LIKE CONCAT('%',#{user.username},'%')");
					}
					if(user.getStatus()!=null && !user.getStatus().equals("")){
						WHERE("status LIKE CONCAT('%',#{user.status},'%')");
					}
				}
			}
		}.toString();
	}
	// 动态插入
	public String insertUser(User user){
		
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES("username", "#{username}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(user.getLoginname() != null && !user.getLoginname().equals("")){
					VALUES("loginname", "#{loginname}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
			}
		}.toString();
	}
}
