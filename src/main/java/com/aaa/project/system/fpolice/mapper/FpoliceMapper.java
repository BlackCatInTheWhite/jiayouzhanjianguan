package com.aaa.project.system.fpolice.mapper;

import com.aaa.project.system.fpolice.domain.Fpolice;
import java.util.List;	

/**
 * 公安分局 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface FpoliceMapper 
{
	/**
     * 查询公安分局信息
     * 
     * @param fpoliceId 公安分局ID
     * @return 公安分局信息
     */
	public Fpolice selectFpoliceById(Integer fpoliceId);
	
	/**
     * 查询公安分局列表
     * 
     * @param fpolice 公安分局信息
     * @return 公安分局集合
     */
	public List<Fpolice> selectFpoliceList(Fpolice fpolice);
	
	/**
     * 新增公安分局
     * 
     * @param fpolice 公安分局信息
     * @return 结果
     */
	public int insertFpolice(Fpolice fpolice);
	
	/**
     * 修改公安分局
     * 
     * @param fpolice 公安分局信息
     * @return 结果
     */
	public int updateFpolice(Fpolice fpolice);
	
	/**
     * 删除公安分局
     * 
     * @param fpoliceId 公安分局ID
     * @return 结果
     */
	public int deleteFpoliceById(Integer fpoliceId);
	
	/**
     * 批量删除公安分局
     * 
     * @param fpoliceIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFpoliceByIds(String[] fpoliceIds);
	
}