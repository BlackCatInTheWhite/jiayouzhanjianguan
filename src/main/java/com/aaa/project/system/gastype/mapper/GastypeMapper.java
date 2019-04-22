package com.aaa.project.system.gastype.mapper;

import com.aaa.project.system.gastype.domain.Gastype;
import java.util.List;	

/**
 * 加油站性质 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface GastypeMapper 
{
	/**
     * 查询加油站性质信息
     * 
     * @param gastypeId 加油站性质ID
     * @return 加油站性质信息
     */
	public Gastype selectGastypeById(Integer gastypeId);
	
	/**
     * 查询加油站性质列表
     * 
     * @param gastype 加油站性质信息
     * @return 加油站性质集合
     */
	public List<Gastype> selectGastypeList(Gastype gastype);
	
	/**
     * 新增加油站性质
     * 
     * @param gastype 加油站性质信息
     * @return 结果
     */
	public int insertGastype(Gastype gastype);
	
	/**
     * 修改加油站性质
     * 
     * @param gastype 加油站性质信息
     * @return 结果
     */
	public int updateGastype(Gastype gastype);
	
	/**
     * 删除加油站性质
     * 
     * @param gastypeId 加油站性质ID
     * @return 结果
     */
	public int deleteGastypeById(Integer gastypeId);
	
	/**
     * 批量删除加油站性质
     * 
     * @param gastypeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteGastypeByIds(String[] gastypeIds);
	
}