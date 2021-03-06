package com.aaa.project.system.lpolice.mapper;

import com.aaa.project.system.lpolice.domain.Lpolice;
import java.util.List;	

/**
 * 派出所 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface LpoliceMapper 
{
	/**
     * 查询派出所信息
     * 
     * @param lpoliceId 派出所ID
     * @return 派出所信息
     */
	public Lpolice selectLpoliceById(Integer lpoliceId);
	
	/**
     * 查询派出所列表
     * 
     * @param lpolice 派出所信息
     * @return 派出所集合
     */
	public List<Lpolice> selectLpoliceList(Lpolice lpolice);
	
	/**
     * 新增派出所
     * 
     * @param lpolice 派出所信息
     * @return 结果
     */
	public int insertLpolice(Lpolice lpolice);
	
	/**
     * 修改派出所
     * 
     * @param lpolice 派出所信息
     * @return 结果
     */
	public int updateLpolice(Lpolice lpolice);
	
	/**
     * 删除派出所
     * 
     * @param lpoliceId 派出所ID
     * @return 结果
     */
	public int deleteLpoliceById(Integer lpoliceId);
	
	/**
     * 批量删除派出所
     * 
     * @param lpoliceIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteLpoliceByIds(String[] lpoliceIds);
	
}