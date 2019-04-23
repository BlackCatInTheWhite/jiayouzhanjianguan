package com.aaa.project.system.policenotice.mapper;

import com.aaa.project.system.policenotice.domain.Policenotice;
import java.util.List;	

/**
 * 公告 数据层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface PolicenoticeMapper 
{
	/**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
	public Policenotice selectPolicenoticeById(Integer noticeId);
	
	/**
     * 查询公告列表
     * 
     * @param policenotice 公告信息
     * @return 公告集合
     */
	public List<Policenotice> selectPolicenoticeList(Policenotice policenotice);
	
	/**
     * 新增公告
     * 
     * @param policenotice 公告信息
     * @return 结果
     */
	public int insertPolicenotice(Policenotice policenotice);
	
	/**
     * 修改公告
     * 
     * @param policenotice 公告信息
     * @return 结果
     */
	public int updatePolicenotice(Policenotice policenotice);
	
	/**
     * 删除公告
     * 
     * @param noticeId 公告ID
     * @return 结果
     */
	public int deletePolicenoticeById(Integer noticeId);
	
	/**
     * 批量删除公告
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePolicenoticeByIds(String[] noticeIds);
	
}