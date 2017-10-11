package com.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dao.provider.DeptDynaSqlProvider;
import com.domain.Dept;

import static com.util.HrmConstants.DEPTTABLE;

import java.util.List;
import java.util.Map;
public interface DeptDao {
	//根据id删除部门
	@Delete("DELETE FROM "+DEPTTABLE+"WHERE id=#{id}")
	public Dept deleteByid(Integer id);
	// 动态查询
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
	public List<Dept> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	public Integer count(Map<String, Object> params);
	
	@Select("select * from "+DEPTTABLE+" ")
	public List<Dept> selectAllDept();
	
	@Select("select * from "+DEPTTABLE+" where ID = #{id}")
	public Dept selectById(int id);
	
	// 动态插入部门
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	public void save(Dept dept);	
	// 动态修改用户
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	public void update(Dept dept);
}
