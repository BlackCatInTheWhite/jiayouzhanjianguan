package com.aaa.project.system.freason.mapper;

import com.aaa.project.system.freason.domain.Freason;
import java.util.List;	

/**
 * 观察原因 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface FreasonMapper 
{
	/**
     * 查询观察原因信息
     * 
     * @param freasonId 观察原因ID
     * @return 观察原因信息
     */
	public Freason selectFreasonById(Integer freasonId);
	
	/**
     * 查询观察原因列表
     * 
     * @param freason 观察原因信息
     * @return 观察原因集合
     */
	public List<Freason> selectFreasonList(Freason freason);
	
	/**
     * 新增观察原因
     * 
     * @param freason 观察原因信息
     * @return 结果
     */
	public int insertFreason(Freason freason);
	
	/**
     * 修改观察原因
     * 
     * @param freason 观察原因信息
     * @return 结果
     */
	public int updateFreason(Freason freason);
	
	/**
     * 删除观察原因
     * 
     * @param freasonId 观察原因ID
     * @return 结果
     */
	public int deleteFreasonById(Integer freasonId);
	
	/**
     * 批量删除观察原因
     * 
     * @param freasonIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFreasonByIds(String[] freasonIds);
	
}