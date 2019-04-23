package com.aaa.project.system.policeman.service;

import com.aaa.project.system.policeman.domain.Policeman;
import java.util.List;

/**
 * 派出所人员 服务层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface IPolicemanService 
{
	/**
     * 查询派出所人员信息
     * 
     * @param policemanId 派出所人员ID
     * @return 派出所人员信息
     */
	public Policeman selectPolicemanById(Integer policemanId);
	
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

	/**
	 *  根据登录信息查询公安人员
	 *
	 * @return
	 */
	public Policeman selectByLogin(Policeman policeman);

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
     * 删除派出所人员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePolicemanByIds(String ids);
	
}
