package com.aaa.project.system.missionproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.missionproject.mapper.MissionprojectMapper;
import com.aaa.project.system.missionproject.domain.Missionproject;
import com.aaa.project.system.missionproject.service.IMissionprojectService;
import com.aaa.common.support.Convert;

/**
 * 巡查项目 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class MissionprojectServiceImpl implements IMissionprojectService 
{
	@Autowired
	private MissionprojectMapper missionprojectMapper;

	/**
     * 查询巡查项目信息
     * 
     * @param missionId 巡查项目ID
     * @return 巡查项目信息
     */
    @Override
	public Missionproject selectMissionprojectById(Integer missionId)
	{
	    return missionprojectMapper.selectMissionprojectById(missionId);
	}
	
	/**
     * 查询巡查项目列表
     * 
     * @param missionproject 巡查项目信息
     * @return 巡查项目集合
     */
	@Override
	public List<Missionproject> selectMissionprojectList(Missionproject missionproject)
	{
	    return missionprojectMapper.selectMissionprojectList(missionproject);
	}
	
    /**
     * 新增巡查项目
     * 
     * @param missionproject 巡查项目信息
     * @return 结果
     */
	@Override
	public int insertMissionproject(Missionproject missionproject)
	{
	    return missionprojectMapper.insertMissionproject(missionproject);
	}
	
	/**
     * 修改巡查项目
     * 
     * @param missionproject 巡查项目信息
     * @return 结果
     */
	@Override
	public int updateMissionproject(Missionproject missionproject)
	{
	    return missionprojectMapper.updateMissionproject(missionproject);
	}

	/**
     * 删除巡查项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMissionprojectByIds(String ids)
	{
		return missionprojectMapper.deleteMissionprojectByIds(Convert.toStrArray(ids));
	}
	
}
