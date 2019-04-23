package com.aaa.project.system.missionstate.service;

import com.aaa.project.system.missionstate.domain.Missionstate;
import java.util.List;

/**
 * 巡检状态 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IMissionstateService 
{
	/**
     * 查询巡检状态信息
     * 
     * @param missionStateid 巡检状态ID
     * @return 巡检状态信息
     */
	public Missionstate selectMissionstateById(Integer missionStateid);
	
	/**
     * 查询巡检状态列表
     * 
     * @param missionstate 巡检状态信息
     * @return 巡检状态集合
     */
	public List<Missionstate> selectMissionstateList(Missionstate missionstate);
	
	/**
     * 新增巡检状态
     * 
     * @param missionstate 巡检状态信息
     * @return 结果
     */
	public int insertMissionstate(Missionstate missionstate);
	
	/**
     * 修改巡检状态
     * 
     * @param missionstate 巡检状态信息
     * @return 结果
     */
	public int updateMissionstate(Missionstate missionstate);
		
	/**
     * 删除巡检状态信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMissionstateByIds(String ids);
	
}
