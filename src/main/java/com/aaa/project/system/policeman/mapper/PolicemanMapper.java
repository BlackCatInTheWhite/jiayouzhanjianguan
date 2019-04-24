package com.aaa.project.system.policeman.mapper;

import com.aaa.project.system.policeman.domain.Policeman;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 派出所人员 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface PolicemanMapper 
{
	/**
     * 查询派出所人员信息
     * 
     * @param policemanId 派出所人员ID
     * @return 派出所人员信息
     */
	public Policeman selectPolicemanById(Integer policemanId);

	/**
	 *  根据登录信息查询公安人员
	 *
	 * @return
	 */
	public Policeman selectByLogin(Policeman policeman);
	/**
     * 查询派出所人员列表
     * 
     * @param policeman 派出所人员信息
     * @return 派出所人员集合
     */
	public List<Policeman> selectPolicemanList(Policeman policeman);

	/***
	 * 查询巡查人员负责的加油站
	 * @param policeman
	 * @return
	 */
	public Policeman selectJYZByPolicemanId(Integer policeman);
	/***
	 * 查询巡查人员的历史记录
	 */
	public Policeman selectPolicemanJYZById(@Param("policemanId") Integer policeman,@Param("address") String address,@Param("committime") Date committime);
	/**
     * 新增派出所人员
     * 
     * @param policeman 派出所人员信息
     * @return 结果
     */
	public int insertPoliceman(Policeman policeman);
	
	/**
     * 修改派出所人员
     * 
     * @param policeman 派出所人员信息
     * @return 结果
     */
	public int updatePoliceman(Policeman policeman);
	
	/**
     * 删除派出所人员
     * 
     * @param policemanId 派出所人员ID
     * @return 结果
     */
	public int deletePolicemanById(Integer policemanId);
	
	/**
     * 批量删除派出所人员
     * 
     * @param policemanIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePolicemanByIds(String[] policemanIds);
	
}