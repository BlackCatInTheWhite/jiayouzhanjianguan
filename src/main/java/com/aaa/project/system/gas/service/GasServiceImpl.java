package com.aaa.project.system.gas.service;

import com.aaa.common.support.Convert;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.gas.mapper.GasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 加油站 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class GasServiceImpl implements IGasService 
{
	@Autowired
	private GasMapper gasMapper;

	/**
     * 查询加油站信息
     * 
     * @param gasId 加油站ID
     * @return 加油站信息
     */
    @Override
	public Gas selectGasById(Integer gasId)
	{
	    return gasMapper.selectGasById(gasId);
	}

	/**
     * 查询加油站列表
     * 
     * @param gas 加油站信息
     * @return 加油站集合
     */
	@Override
	public List<Gas> selectGasList(Gas gas)
	{
	    return gasMapper.selectGasList(gas);
	}

	@Override
	public List<Gas> selectGasMission(Gas gas) {
		return gasMapper.selectGasMission(gas);
	}

	/**
     * 新增加油站
     * 
     * @param gas 加油站信息
     * @return 结果
     */
	@Override
	public int insertGas(Gas gas)
	{
	    return gasMapper.insertGas(gas);
	}
	
	/**
     * 修改加油站
     * 
     * @param gas 加油站信息
     * @return 结果
     */
	@Override
	public int updateGas(Gas gas)
	{
	    return gasMapper.updateGas(gas);
	}

	/**
     * 删除加油站对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGasByIds(String ids)
	{
		return gasMapper.deleteGasByIds(Convert.toStrArray(ids));
	}

	/**
	 *
	 * 加油站人员的列表
	 */
	@Override
	public List<Gas> selectArrayGas(int a) {
		return gasMapper.selectArrayGas(a);
	}
}
