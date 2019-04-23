package com.aaa.project.system.projectkind.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.projectkind.mapper.ProjectkindMapper;
import com.aaa.project.system.projectkind.domain.Projectkind;
import com.aaa.project.system.projectkind.service.IProjectkindService;
import com.aaa.common.support.Convert;

/**
 * 项目分类 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class ProjectkindServiceImpl implements IProjectkindService 
{
	@Autowired
	private ProjectkindMapper projectkindMapper;

	/**
     * 查询项目分类信息
     * 
     * @param projectKindid 项目分类ID
     * @return 项目分类信息
     */
    @Override
	public Projectkind selectProjectkindById(Integer projectKindid)
	{
	    return projectkindMapper.selectProjectkindById(projectKindid);
	}
	
	/**
     * 查询项目分类列表
     * 
     * @param projectkind 项目分类信息
     * @return 项目分类集合
     */
	@Override
	public List<Projectkind> selectProjectkindList(Projectkind projectkind)
	{
	    return projectkindMapper.selectProjectkindList(projectkind);
	}
	
    /**
     * 新增项目分类
     * 
     * @param projectkind 项目分类信息
     * @return 结果
     */
	@Override
	public int insertProjectkind(Projectkind projectkind)
	{
	    return projectkindMapper.insertProjectkind(projectkind);
	}
	
	/**
     * 修改项目分类
     * 
     * @param projectkind 项目分类信息
     * @return 结果
     */
	@Override
	public int updateProjectkind(Projectkind projectkind)
	{
	    return projectkindMapper.updateProjectkind(projectkind);
	}

	/**
     * 删除项目分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProjectkindByIds(String ids)
	{
		return projectkindMapper.deleteProjectkindByIds(Convert.toStrArray(ids));
	}
	
}
