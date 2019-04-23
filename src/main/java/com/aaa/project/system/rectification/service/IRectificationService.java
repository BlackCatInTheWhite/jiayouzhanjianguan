package com.aaa.project.system.rectification.service;

import com.aaa.project.system.rectification.domain.Rectification;
import java.util.List;

/**
 * 整改 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IRectificationService 
{
	/**
     * 查询整改信息
     * 
     * @param rectificationId 整改ID
     * @return 整改信息
     */
	public Rectification selectRectificationById(Integer rectificationId);
	
	/**
     * 查询整改列表
     * 
     * @param rectification 整改信息
     * @return 整改集合
     */
	public List<Rectification> selectRectificationList(Rectification rectification);
	
	/**
     * 新增整改
     * 
     * @param rectification 整改信息
     * @return 结果
     */
	public int insertRectification(Rectification rectification);
	
	/**
     * 修改整改
     * 
     * @param rectification 整改信息
     * @return 结果
     */
	public int updateRectification(Rectification rectification);
		
	/**
     * 删除整改信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRectificationByIds(String ids);
	
}
