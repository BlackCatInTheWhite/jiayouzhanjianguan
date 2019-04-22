package com.aaa.project.system.fpolice.service;

import com.aaa.project.system.fpolice.domain.Fpolice;
import java.util.List;

/**
 * 公安分局 服务层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface IFpoliceService 
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
     * 删除公安分局信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFpoliceByIds(String ids);
	
}
