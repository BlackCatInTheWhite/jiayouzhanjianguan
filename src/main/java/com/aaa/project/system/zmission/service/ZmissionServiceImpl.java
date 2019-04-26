package com.aaa.project.system.zmission.service;

import com.aaa.common.support.Convert;
import com.aaa.project.system.zmission.domain.Zmission;
import com.aaa.project.system.zmission.mapper.ZmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 巡查总任务分排 服务层实现
 * 
 * @author aaa
 * @date 2019-04-24
 */
@Service
public class ZmissionServiceImpl implements IZmissionService 
{
	@Autowired
	private ZmissionMapper zmissionMapper;

	/**
     * 查询巡查总任务分排信息
     * 
     * @param missionId 巡查总任务分排ID
     * @return 巡查总任务分排信息
     */
    @Override
	public Zmission selectZmissionById(Integer missionId)
	{
	    return zmissionMapper.selectZmissionById(missionId);
	}
	
	/**
     * 查询巡查总任务分排列表
     * 
     * @param zmission 巡查总任务分排信息
     * @return 巡查总任务分排集合
     */
	@Override
	public List<Zmission> selectZmissionList(Zmission zmission)
	{
	    return zmissionMapper.selectZmissionList(zmission);
	}
	
    /**
     * 新增巡查总任务分排
     * 
     * @param zmission 巡查总任务分排信息
     * @return 结果
     */
	@Override
	public int insertZmission(Zmission zmission)
	{
	    return zmissionMapper.insertZmission(zmission);
	}
	
	/**
     * 修改巡查总任务分排
     * 
     * @param zmission 巡查总任务分排信息
     * @return 结果
     */
	@Override
	public int updateZmission(Zmission zmission)
	{
	    return zmissionMapper.updateZmission(zmission);
	}

	/**
     * 删除巡查总任务分排对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZmissionByIds(String ids)
	{
		return zmissionMapper.deleteZmissionByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Zmission> selectZmissionByLpolice(Zmission zmission) {
		return zmissionMapper.selectZmissionByLpolice(zmission);
	}

}
