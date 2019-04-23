package com.aaa.project.system.policeproject.mapper;

import com.aaa.project.system.policeproject.domain.Policeproject;
import java.util.List;	

/**
 * 项目 数据层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface PoliceprojectMapper 
{
	/**
     * 查询项目信息
     * 
     * @param projectId 项目ID
     * @return 项目信息
     */
	public Policeproject selectPoliceprojectById(Integer projectId);
	
	/**
     * 查询项目列表
     * 
     * @param policeproject 项目信息
     * @return 项目集合
     */
	public List<Policeproject> selectPoliceprojectList(Policeproject policeproject);
	
	/**
     * 新增项目
     * 
     * @param policeproject 项目信息
     * @return 结果
     */
	public int insertPoliceproject(Policeproject policeproject);
	
	/**
     * 修改项目
     * 
     * @param policeproject 项目信息
     * @return 结果
     */
	public int updatePoliceproject(Policeproject policeproject);
	
	/**
     * 删除项目
     * 
     * @param projectId 项目ID
     * @return 结果
     */
	public int deletePoliceprojectById(Integer projectId);
	
	/**
     * 批量删除项目
     * 
     * @param projectIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePoliceprojectByIds(String[] projectIds);
	
}