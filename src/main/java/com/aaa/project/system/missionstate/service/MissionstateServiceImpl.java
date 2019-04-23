package com.aaa.project.system.missionstate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.missionstate.mapper.MissionstateMapper;
import com.aaa.project.system.missionstate.domain.Missionstate;
import com.aaa.project.system.missionstate.service.IMissionstateService;
import com.aaa.common.support.Convert;

/**
 * 巡检状态 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class MissionstateServiceImpl implements IMissionstateService 
{
	@Autowired
	private MissionstateMapper missionstateMapper;

	/**
     * 查询巡检状态信息
     * 
     * @param missionStateid 巡检状态ID
     * @return 巡检状态信息
     */
    @Override
	public Missionstate selectMissionstateById(Integer missionStateid)
	{
	    return missionstateMapper.selectMissionstateById(missionStateid);
	}
	
	/**
     * 查询巡检状态列表
     * 
     * @param missionstate 巡检状态信息
     * @return 巡检状态集合
     */
	@Override
	public List<Missionstate> selectMissionstateList(Missionstate missionstate)
	{
	    return missionstateMapper.selectMissionstateList(missionstate);
	}
	
    /**
     * 新增巡检状态
     * 
     * @param missionstate 巡检状态信息
     * @return 结果
     */
	@Override
	public int insertMissionstate(Missionstate missionstate)
	{
	    return missionstateMapper.insertMissionstate(missionstate);
	}
	
	/**
     * 修改巡检状态
     * 
     * @param missionstate 巡检状态信息
     * @return 结果
     */
	@Override
	public int updateMissionstate(Missionstate missionstate)
	{
	    return missionstateMapper.updateMissionstate(missionstate);
	}

	/**
     * 删除巡检状态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMissionstateByIds(String ids)
	{
		return missionstateMapper.deleteMissionstateByIds(Convert.toStrArray(ids));
	}
	
}
