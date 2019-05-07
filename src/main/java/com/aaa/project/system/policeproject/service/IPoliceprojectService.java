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
	 * @param policeproject 含有项目分类id
	 * @return 项目信息
	 */
	public List<Policeproject> selectPoliceprojectByMission(Policeproject policeproject);

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

	/**
	 * 查询所有规范
	 */
	public List<Policeproject> selectProjectGuiFan();
	/**
	 * 查询不及格的项目
	 */
	public List<Integer> getPoint(Integer fmissionid);
	/**
	 * 项目条数
	 */
	public Integer selectProjectCount();
}
