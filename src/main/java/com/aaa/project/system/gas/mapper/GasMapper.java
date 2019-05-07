package com.aaa.project.system.gas.mapper;

import com.aaa.project.system.gas.domain.Gas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 加油站 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface GasMapper 
{
	/**
     * 查询加油站信息
     * 
     * @param gasId 加油站ID
     * @return 加油站信息
     */
	public Gas selectGasById(Integer gasId);

	
//	/**
//     * 查询加油站列表对用户
//     *
//     * @param gas 加油站信息
//     * @return 加油站集合
//     */
//	public List<Gas> selectGasListForUser(Gas gas);

	/**
	 * 查询加油站列表
	 *
	 * @param gas 加油站信息
	 * @return 加油站集合
	 */
	public List<Gas> selectGasList(Gas gas);
	
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
     * 删除加油站
     * 
     * @param gasId 加油站ID
     * @return 结果
     */
	public int deleteGasById(Integer gasId);
	
	/**
     * 批量删除加油站
     * 
     * @param gasIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteGasByIds(String[] gasIds);

	/**
	 * 巡查人员的历史加油站
	 */
	public List<Gas> selectArrayGas(@Param("policemanid") int aa);
}