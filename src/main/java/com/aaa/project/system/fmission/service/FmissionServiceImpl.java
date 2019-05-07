package com.aaa.project.system.fmission.service;

import com.aaa.common.support.Convert;
import com.aaa.project.system.fmission.domain.Fmission;
import com.aaa.project.system.fmission.mapper.FmissionMapper;
import com.aaa.project.system.weixin.domain.HistoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 分任务记录 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class FmissionServiceImpl implements IFmissionService 
{
	@Autowired
	private FmissionMapper fmissionMapper;

	/**
	 * 根据总任务id查询上次任务是否完成
	 */
	public Integer selectLast(int aa){return fmissionMapper.selectLast(aa);}

	/**
	 * 查询上一次任务时间
	 * @param missionid
	 * @return
	 */
	@Override
	public Date selectLastTime(int zmissionid) {
		return fmissionMapper.selectLastTime(zmissionid);
	}
	/**
	 * 查询频次
	 */
	@Override
	public int selectPinCi(int missionid) {
		return fmissionMapper.selectPinCi(missionid);
	}
	/**
	 * 查询历史
	 */
	@Override
	public List<HistoryList> selectHistory(int aa) {
		return fmissionMapper.selectHistory(aa);
	}

	@Override
	public List<HistoryList> HistoryList(int aa, String name,String time) {
		return fmissionMapper.HistoryList(aa,name,time);
	}

	@Override
	public Date selectStartTime(int missionid) {
		return fmissionMapper.selectStartTime(missionid);
	}

	@Override
	public Date selectEndTime(int missionid) {
		return fmissionMapper.selectEndTime(missionid);
	}


	/**
     * 查询分任务记录信息
     * 
     * @param fmissionId 分任务记录ID
     * @return 分任务记录信息
     */
    @Override
	public Fmission selectFmissionById(Integer fmissionId)
	{
	    return fmissionMapper.selectFmissionById(fmissionId);
	}
	
	/**
     * 查询分任务记录列表
     * 
     * @param fmission 分任务记录信息
     * @return 分任务记录集合
     */
	@Override
	public List<Fmission> selectFmissionList(Fmission fmission)
	{
	    return fmissionMapper.selectFmissionList(fmission);
	}
	
    /**
     * 新增分任务记录
     * 
     * @param fmission 分任务记录信息
     * @return 结果
     */
	@Override
	public int insertFmission(Fmission fmission)
	{
	    return fmissionMapper.insertFmission(fmission);
	}
	
	/**
     * 修改分任务记录
     * 
     * @param fmission 分任务记录信息
     * @return 结果
     */
	@Override
	public int updateFmission(Fmission fmission)
	{
	    return fmissionMapper.updateFmission(fmission);
	}

	/**
     * 删除分任务记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFmissionByIds(String ids)
	{
		return fmissionMapper.deleteFmissionByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Fmission> selectFmissionByZmissionlist(Fmission fmission) {
		return fmissionMapper.selectFmissionByZmissionlist(fmission);
	}

}
