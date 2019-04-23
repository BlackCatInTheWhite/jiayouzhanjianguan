package com.aaa.project.system.missionproject.service;

import com.aaa.project.system.missionproject.domain.Missionproject;
import java.util.List;

/**
 * 巡查项目 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IMissionprojectService 
{
	/**
     * 查询巡查项目信息
     * 
     * @param missionId 巡查项目ID
     * @return 巡查项目信息
     */
	public Missionproject selectMissionprojectById(Integer missionId);
	
	/**
     * 查询巡查项目列表
     * 
     * @param missionproject 巡查项目信息
     * @return 巡查项目集合
     */
	public List<Missionproject> selectMissionprojectList(Missionproject missionproject);
	
	/**
     * 新增巡查项目
     * 
     * @param missionproject 巡查项目信息
     * @return 结果
     */
	public int insertMissionproject(Missionproject missionproject);
	
	/**
     * 修改巡查项目
     * 
     * @param missionproject 巡查项目信息
     * @return 结果
     */
	public int updateMissionproject(Missionproject missionproject);
		
	/**
     * 删除巡查项目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMissionprojectByIds(String ids);
	
}
