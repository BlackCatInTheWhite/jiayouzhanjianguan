package com.aaa.project.system.projectkind.mapper;

import com.aaa.project.system.projectkind.domain.Projectkind;
import java.util.List;	

/**
 * 项目分类 数据层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface ProjectkindMapper 
{
	/**
     * 查询项目分类信息
     * 
     * @param projectKindid 项目分类ID
     * @return 项目分类信息
     */
	public Projectkind selectProjectkindById(Integer projectKindid);
	
	/**
     * 查询项目分类列表
     * 
     * @param projectkind 项目分类信息
     * @return 项目分类集合
     */
	public List<Projectkind> selectProjectkindList(Projectkind projectkind);
	
	/**
     * 新增项目分类
     * 
     * @param projectkind 项目分类信息
     * @return 结果
     */
	public int insertProjectkind(Projectkind projectkind);
	
	/**
     * 修改项目分类
     * 
     * @param projectkind 项目分类信息
     * @return 结果
     */
	public int updateProjectkind(Projectkind projectkind);
	
	/**
     * 删除项目分类
     * 
     * @param projectKindid 项目分类ID
     * @return 结果
     */
	public int deleteProjectkindById(Integer projectKindid);
	
	/**
     * 批量删除项目分类
     * 
     * @param projectKindids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProjectkindByIds(String[] projectKindids);
	
}