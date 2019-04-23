package com.aaa.project.system.fmissionproject.service;

import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import java.util.List;

/**
 * 项目记录 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IFmissionprojectService 
{
	/**
     * 查询项目记录信息
     * 
     * @param projectMissionid 项目记录ID
     * @return 项目记录信息
     */
	public Fmissionproject selectFmissionprojectById(Integer projectMissionid);
	
	/**
     * 查询项目记录列表
     * 
     * @param fmissionproject 项目记录信息
     * @return 项目记录集合
     */
	public List<Fmissionproject> selectFmissionprojectList(Fmissionproject fmissionproject);
	
	/**
     * 新增项目记录
     * 
     * @param fmissionproject 项目记录信息
     * @return 结果
     */
	public int insertFmissionproject(Fmissionproject fmissionproject);
	
	/**
     * 修改项目记录
     * 
     * @param fmissionproject 项目记录信息
     * @return 结果
     */
	public int updateFmissionproject(Fmissionproject fmissionproject);
		
	/**
     * 删除项目记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFmissionprojectByIds(String ids);
	
}
