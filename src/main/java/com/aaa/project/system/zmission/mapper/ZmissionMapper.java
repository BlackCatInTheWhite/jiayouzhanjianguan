package com.aaa.project.system.zmission.mapper;

import com.aaa.project.system.zmission.domain.Zmission;
import java.util.List;	

/**
 * 巡查总任务分排 数据层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface ZmissionMapper 
{
	/**
     * 查询巡查总任务分排信息
     * 
     * @param missionId 巡查总任务分排ID
     * @return 巡查总任务分排信息
     */
	public Zmission selectZmissionById(Integer missionId);
	
	/**
     * 查询巡查总任务分排列表
     * 
     * @param zmission 巡查总任务分排信息
     * @return 巡查总任务分排集合
     */
	public List<Zmission> selectZmissionList(Zmission zmission);
	
	/**
     * 新增巡查总任务分排
     * 
     * @param zmission 巡查总任务分排信息
     * @return 结果
     */
	public int insertZmission(Zmission zmission);
	
	/**
     * 修改巡查总任务分排
     * 
     * @param zmission 巡查总任务分排信息
     * @return 结果
     */
	public int updateZmission(Zmission zmission);
	
	/**
     * 删除巡查总任务分排
     * 
     * @param missionId 巡查总任务分排ID
     * @return 结果
     */
	public int deleteZmissionById(Integer missionId);
	
	/**
     * 批量删除巡查总任务分排
     * 
     * @param missionIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteZmissionByIds(String[] missionIds);
	
}