package com.aaa.project.system.fmission.mapper;

import com.aaa.project.system.fmission.domain.Fmission;
import com.aaa.project.system.weixin.domain.HistoryList;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 分任务记录 数据层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface FmissionMapper 
{
	/**
	 * 根据总任务id查询上次任务是否完成
	 */
	public Integer selectLast(@Param("zmissionid") int aa);

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
     * 删除分任务记录
     * 
     * @param fmissionId 分任务记录ID
     * @return 结果
     */
	public int deleteFmissionById(Integer fmissionId);
	
	/**
     * 批量删除分任务记录
     * 
     * @param fmissionIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFmissionByIds(String[] fmissionIds);

	/**
	 * 查询上一次任务提交时间
	 */
	public Date selectLastTime(@Param("zmissionid") int missionid);
	/**
	 * 查询开始时间
	 */
	public Date selectStartTime(@Param("zmissionid") int missionid);
	/**
	 * 查询结束时间
	 */
	public Date selectEndTime(@Param("zmissionid") int missionid);
	/**
	 * 查询频次
	 */
	public Integer selectPinCi(@Param("zmissionid") int missionid);
	/**
	 * 查询历史
	 */
	public List<HistoryList> selectHistory(@Param("policemanid") int aa);
	/**
	 * 根据条件查询
	 */
	public List<HistoryList> HistoryList(@Param("policemanid") int aa,@Param("gasname") String name,@Param("committime") String time);


	public List<Fmission> selectFmissionByZmissionlist(Fmission fmission);
	
}