package com.aaa.project.system.gasstatus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.gasstatus.mapper.GasstatusMapper;
import com.aaa.project.system.gasstatus.domain.Gasstatus;
import com.aaa.project.system.gasstatus.service.IGasstatusService;
import com.aaa.common.support.Convert;

/**
 * 加油站状态 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class GasstatusServiceImpl implements IGasstatusService 
{
	@Autowired
	private GasstatusMapper gasstatusMapper;

	/**
     * 查询加油站状态信息
     * 
     * @param gasstatusId 加油站状态ID
     * @return 加油站状态信息
     */
    @Override
	public Gasstatus selectGasstatusById(Integer gasstatusId)
	{
	    return gasstatusMapper.selectGasstatusById(gasstatusId);
	}
	
	/**
     * 查询加油站状态列表
     * 
     * @param gasstatus 加油站状态信息
     * @return 加油站状态集合
     */
	@Override
	public List<Gasstatus> selectGasstatusList(Gasstatus gasstatus)
	{
	    return gasstatusMapper.selectGasstatusList(gasstatus);
	}
	
    /**
     * 新增加油站状态
     * 
     * @param gasstatus 加油站状态信息
     * @return 结果
     */
	@Override
	public int insertGasstatus(Gasstatus gasstatus)
	{
	    return gasstatusMapper.insertGasstatus(gasstatus);
	}
	
	/**
     * 修改加油站状态
     * 
     * @param gasstatus 加油站状态信息
     * @return 结果
     */
	@Override
	public int updateGasstatus(Gasstatus gasstatus)
	{
	    return gasstatusMapper.updateGasstatus(gasstatus);
	}

	/**
     * 删除加油站状态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGasstatusByIds(String ids)
	{
		return gasstatusMapper.deleteGasstatusByIds(Convert.toStrArray(ids));
	}
	
}
