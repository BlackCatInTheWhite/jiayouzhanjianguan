package com.aaa.project.system.gasstatus.service;

import com.aaa.project.system.gasstatus.domain.Gasstatus;
import java.util.List;

/**
 * 加油站状态 服务层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface IGasstatusService 
{
	/**
     * 查询加油站状态信息
     * 
     * @param gasstatusId 加油站状态ID
     * @return 加油站状态信息
     */
	public Gasstatus selectGasstatusById(Integer gasstatusId);
	
	/**
     * 查询加油站状态列表
     * 
     * @param gasstatus 加油站状态信息
     * @return 加油站状态集合
     */
	public List<Gasstatus> selectGasstatusList(Gasstatus gasstatus);
	
	/**
     * 新增加油站状态
     * 
     * @param gasstatus 加油站状态信息
     * @return 结果
     */
	public int insertGasstatus(Gasstatus gasstatus);
	
	/**
     * 修改加油站状态
     * 
     * @param gasstatus 加油站状态信息
     * @return 结果
     */
	public int updateGasstatus(Gasstatus gasstatus);
		
	/**
     * 删除加油站状态信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGasstatusByIds(String ids);
	
}
