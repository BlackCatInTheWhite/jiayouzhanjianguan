package com.aaa.project.system.gas.service;

import com.aaa.project.system.gas.domain.Gas;
import java.util.List;

/**
 * 加油站 服务层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface IGasService 
{
	/**
     * 查询加油站信息
     * 
     * @param gasId 加油站ID
     * @return 加油站信息
     */
	public Gas selectGasById(Integer gasId);

	/**
     * 查询加油站列表
     * 
     * @param gas 加油站信息
     * @return 加油站集合
     */
	public List<Gas> selectGasList(Gas gas);

	/**
	 * 查询加油站列表对巡检
	 *
	 * @param gas 加油站信息
	 * @return 加油站集合
	 */
	public List<Gas> selectGasMission(Gas gas);
	
	/**
     * 新增加油站
     * 
     * @param gas 加油站信息
     * @return 结果
     */
	public int insertGas(Gas gas);
	
	/**
     * 修改加油站
     * 
     * @param gas 加油站信息
     * @return 结果
     */
	public int updateGas(Gas gas);
		
	/**
     * 删除加油站信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGasByIds(String ids);

	/**
	 * 查询巡查人员的加油站列表
	 */
	public List<Gas> selectArrayGas(int a);
	
}
