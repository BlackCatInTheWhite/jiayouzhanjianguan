package com.aaa.project.system.policeproject.service;

import com.aaa.project.system.policeproject.domain.Policeproject;
import java.util.List;

/**
 * 项目 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IPoliceprojectService 
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
     * 删除项目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePoliceprojectByIds(String ids);
	
}
