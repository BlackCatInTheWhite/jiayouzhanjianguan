package com.aaa.project.system.fmission.service;

import com.aaa.project.system.fmission.domain.Fmission;
import java.util.List;

/**
 * 分任务记录 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IFmissionService 
{
	/**
     * 查询分任务记录信息
     * 
     * @param fmissionId 分任务记录ID
     * @return 分任务记录信息
     */
	public Fmission selectFmissionById(Integer fmissionId);
	
	/**
     * 查询分任务记录列表
     * 
     * @param fmission 分任务记录信息
     * @return 分任务记录集合
     */
	public List<Fmission> selectFmissionList(Fmission fmission);
	
	/**
     * 新增分任务记录
     * 
     * @param fmission 分任务记录信息
     * @return 结果
     */
	public int insertFmission(Fmission fmission);
	
	/**
     * 修改分任务记录
     * 
     * @param fmission 分任务记录信息
     * @return 结果
     */
	public int updateFmission(Fmission fmission);
		
	/**
     * 删除分任务记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFmissionByIds(String ids);

	public List<Fmission> selectFmissionByZmissionlist(Fmission fmission);
	
}
