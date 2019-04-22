package com.aaa.project.system.gasman.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.gasman.mapper.GasmanMapper;
import com.aaa.project.system.gasman.domain.Gasman;
import com.aaa.project.system.gasman.service.IGasmanService;
import com.aaa.common.support.Convert;

/**
 * 加油站员工 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class GasmanServiceImpl implements IGasmanService 
{
	@Autowired
	private GasmanMapper gasmanMapper;

	/**
     * 查询加油站员工信息
     * 
     * @param gasmanId 加油站员工ID
     * @return 加油站员工信息
     */
    @Override
	public Gasman selectGasmanById(Integer gasmanId)
	{
	    return gasmanMapper.selectGasmanById(gasmanId);
	}
	
	/**
     * 查询加油站员工列表
     * 
     * @param gasman 加油站员工信息
     * @return 加油站员工集合
     */
	@Override
	public List<Gasman> selectGasmanList(Gasman gasman)
	{
	    return gasmanMapper.selectGasmanList(gasman);
	}
	
    /**
     * 新增加油站员工
     * 
     * @param gasman 加油站员工信息
     * @return 结果
     */
	@Override
	public int insertGasman(Gasman gasman)
	{
	    return gasmanMapper.insertGasman(gasman);
	}
	
	/**
     * 修改加油站员工
     * 
     * @param gasman 加油站员工信息
     * @return 结果
     */
	@Override
	public int updateGasman(Gasman gasman)
	{
	    return gasmanMapper.updateGasman(gasman);
	}

	/**
     * 删除加油站员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGasmanByIds(String ids)
	{
		return gasmanMapper.deleteGasmanByIds(Convert.toStrArray(ids));
	}
	
}
