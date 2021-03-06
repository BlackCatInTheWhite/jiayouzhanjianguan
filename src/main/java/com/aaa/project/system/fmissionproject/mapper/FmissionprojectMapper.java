package com.aaa.project.system.fmissionproject.mapper;

import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.projectkind.domain.Projectkind;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目记录 数据层
 * 
 * @author aaa
 * @date 2019-04-25
 */
public interface FmissionprojectMapper 
{
	/**
	 * 查询重复提交项目的上次提交内容
	 * @param fmissionproject
	 * @return
	 */
	public Fmissionproject selectByFmissionIdAndProjectID(Fmissionproject fmissionproject);

	/**
	 * 查询项目记录信息
	 *
	 * @param fmissionproject 含有任务id的fmissionproject
	 * @return 指定的项目记录集合
	 */
	public List<Projectkind> selectFmissionprojectListByMissionId(Fmissionproject fmissionproject);

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
     * 删除项目记录
     * 
     * @param projectMissionid 项目记录ID
     * @return 结果
     */
	public int deleteFmissionprojectById(Integer projectMissionid);
	
	/**
     * 批量删除项目记录
     * 
     * @param projectMissionids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFmissionprojectByIds(String[] projectMissionids);

	/**
	 * 查询巡查人员添加过得项目
	 */
	public int selectCount(@Param("projectMissionid") int aa);
	/**
	 * 查询项目信息
	 */
	public Fmissionproject selectProject(Fmissionproject fmissionproject);


}