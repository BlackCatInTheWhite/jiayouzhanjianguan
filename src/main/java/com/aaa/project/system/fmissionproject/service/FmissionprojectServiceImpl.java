package com.aaa.project.system.fmissionproject.service;

import java.util.List;

import com.aaa.project.system.projectkind.domain.Projectkind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.fmissionproject.mapper.FmissionprojectMapper;
import com.aaa.project.system.fmissionproject.domain.Fmissionproject;
import com.aaa.project.system.fmissionproject.service.IFmissionprojectService;
import com.aaa.common.support.Convert;

/**
 * 项目记录 服务层实现
 * 
 * @author aaa
 * @date 2019-04-25
 */
@Service
public class FmissionprojectServiceImpl implements IFmissionprojectService 
{
	@Autowired
	private FmissionprojectMapper fmissionprojectMapper;

	public List<Projectkind> selectFmissionprojectListByMissionId(Fmissionproject fmissionproject){
		return fmissionprojectMapper.selectFmissionprojectListByMissionId(fmissionproject);
	}
	/**
     * 查询项目记录信息
     * 
     * @param projectMissionid 项目记录ID
     * @return 项目记录信息
     */
    @Override
	public Fmissionproject selectFmissionprojectById(Integer projectMissionid)
	{
	    return fmissionprojectMapper.selectFmissionprojectById(projectMissionid);
	}
	
	/**
     * 查询项目记录列表
     * 
     * @param fmissionproject 项目记录信息
     * @return 项目记录集合
     */
	@Override
	public List<Fmissionproject> selectFmissionprojectList(Fmissionproject fmissionproject)
	{
	    return fmissionprojectMapper.selectFmissionprojectList(fmissionproject);
	}
	
    /**
     * 新增项目记录
     * 
     * @param fmissionproject 项目记录信息
     * @return 结果
     */
	@Override
	public int insertFmissionproject(Fmissionproject fmissionproject)
	{
	    return fmissionprojectMapper.insertFmissionproject(fmissionproject);
	}
	
	/**
     * 修改项目记录
     * 
     * @param fmissionproject 项目记录信息
     * @return 结果
     */
	@Override
	public int updateFmissionproject(Fmissionproject fmissionproject)
	{
	    return fmissionprojectMapper.updateFmissionproject(fmissionproject);
	}

	/**
     * 删除项目记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFmissionprojectByIds(String ids)
	{
		return fmissionprojectMapper.deleteFmissionprojectByIds(Convert.toStrArray(ids));
	}
	
}
