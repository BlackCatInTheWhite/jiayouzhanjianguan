package com.aaa.project.system.policeman.service;

import com.aaa.common.support.Convert;
import com.aaa.project.system.policeman.domain.Policeman;
import com.aaa.project.system.policeman.mapper.PolicemanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 派出所人员 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class PolicemanServiceImpl implements IPolicemanService 
{
	@Autowired
	private PolicemanMapper policemanMapper;

	/**
     * 查询派出所人员信息
     * 
     * @param policemanId 派出所人员ID
     * @return 派出所人员信息
     */
    @Override
	public Policeman selectPolicemanById(Integer policemanId)
	{
	    return policemanMapper.selectPolicemanById(policemanId);
	}
	
	/**
     * 查询派出所人员列表
     * 
     * @param policeman 派出所人员信息
     * @return 派出所人员集合
     */
	@Override
	public List<Policeman> selectPolicemanList(Policeman policeman)
	{
	    return policemanMapper.selectPolicemanList(policeman);
	}

	/***
	 * 查询巡查人员负责的加油站
	 * @param policeman
	 * @return
	 */
	public Policeman selectJYZByPolicemanId(Integer policeman){
		return policemanMapper.selectJYZByPolicemanId(policeman);
	}

	/***
	 * 查询巡查人员的历史记录
	 */
	public Policeman selectPolicemanJYZById(Integer policeman,String address,Date committime){
		return  policemanMapper.selectPolicemanJYZById(policeman,address,committime);
	}

	/**
	 *  根据登录信息查询公安人员
	 *
	 * @return
	 */
	public Policeman selectByLogin(Policeman policeman){
		return policemanMapper.selectByLogin(policeman);
	}
    /**
     * 新增派出所人员
     * 
     * @param policeman 派出所人员信息
     * @return 结果
     */
	@Override
	public int insertPoliceman(Policeman policeman)
	{
	    return policemanMapper.insertPoliceman(policeman);
	}
	
	/**
     * 修改派出所人员
     * 
     * @param policeman 派出所人员信息
     * @return 结果
     */
	@Override
	public int updatePoliceman(Policeman policeman)
	{
	    return policemanMapper.updatePoliceman(policeman);
	}

	/**
     * 删除派出所人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePolicemanByIds(String ids)
	{
		return policemanMapper.deletePolicemanByIds(Convert.toStrArray(ids));
	}
	
}
