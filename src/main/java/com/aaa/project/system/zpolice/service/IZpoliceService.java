package com.aaa.project.system.zpolice.service;

import com.aaa.project.system.zpolice.domain.Zpolice;
import java.util.List;

/**
 * 公安总局 服务层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface IZpoliceService 
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
     * 删除公安总局信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteZpoliceByIds(String ids);
	
}
