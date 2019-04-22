package com.aaa.project.system.zpolice.mapper;

import com.aaa.project.system.zpolice.domain.Zpolice;
import java.util.List;	

/**
 * 公安总局 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface ZpoliceMapper 
{
	/**
     * 查询公安总局信息
     * 
     * @param zpoliceId 公安总局ID
     * @return 公安总局信息
     */
	public Zpolice selectZpoliceById(Integer zpoliceId);
	
	/**
     * 查询公安总局列表
     * 
     * @param zpolice 公安总局信息
     * @return 公安总局集合
     */
	public List<Zpolice> selectZpoliceList(Zpolice zpolice);
	
	/**
     * 新增公安总局
     * 
     * @param zpolice 公安总局信息
     * @return 结果
     */
	public int insertZpolice(Zpolice zpolice);
	
	/**
     * 修改公安总局
     * 
     * @param zpolice 公安总局信息
     * @return 结果
     */
	public int updateZpolice(Zpolice zpolice);
	
	/**
     * 删除公安总局
     * 
     * @param zpoliceId 公安总局ID
     * @return 结果
     */
	public int deleteZpoliceById(Integer zpoliceId);
	
	/**
     * 批量删除公安总局
     * 
     * @param zpoliceIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteZpoliceByIds(String[] zpoliceIds);
	
}