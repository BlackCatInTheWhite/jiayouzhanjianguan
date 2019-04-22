package com.aaa.project.system.gasman.mapper;

import com.aaa.project.system.gasman.domain.Gasman;
import java.util.List;	

/**
 * 加油站员工 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface GasmanMapper 
{
	/**
     * 查询加油站员工信息
     * 
     * @param gasmanId 加油站员工ID
     * @return 加油站员工信息
     */
	public Gasman selectGasmanById(Integer gasmanId);

	/**
	 * 查询加油站员工身份证
	 *
	 * @param gasmanCard 加油站员工ID
	 * @return 加油站员工信息
	 */
	public Gasman selectGasmanByCard(String gasmanCard);
	
	/**
     * 查询加油站员工列表
     * 
     * @param gasman 加油站员工信息
     * @return 加油站员工集合
     */
	public List<Gasman> selectGasmanList(Gasman gasman);
	
	/**
     * 新增加油站员工
     * 
     * @param gasman 加油站员工信息
     * @return 结果
     */
	public int insertGasman(Gasman gasman);
	
	/**
     * 修改加油站员工
     * 
     * @param gasman 加油站员工信息
     * @return 结果
     */
	public int updateGasman(Gasman gasman);
	
	/**
     * 删除加油站员工
     * 
     * @param gasmanId 加油站员工ID
     * @return 结果
     */
	public int deleteGasmanById(Integer gasmanId);

	/**
     * 批量删除加油站员工
     * 
     * @param gasmanIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteGasmanByIds(String[] gasmanIds);
	
}