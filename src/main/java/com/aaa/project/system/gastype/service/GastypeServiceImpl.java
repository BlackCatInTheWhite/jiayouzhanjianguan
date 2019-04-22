package com.aaa.project.system.gastype.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.gastype.mapper.GastypeMapper;
import com.aaa.project.system.gastype.domain.Gastype;
import com.aaa.project.system.gastype.service.IGastypeService;
import com.aaa.common.support.Convert;

/**
 * 加油站性质 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class GastypeServiceImpl implements IGastypeService 
{
	@Autowired
	private GastypeMapper gastypeMapper;

	/**
     * 查询加油站性质信息
     * 
     * @param gastypeId 加油站性质ID
     * @return 加油站性质信息
     */
    @Override
	public Gastype selectGastypeById(Integer gastypeId)
	{
	    return gastypeMapper.selectGastypeById(gastypeId);
	}
	
	/**
     * 查询加油站性质列表
     * 
     * @param gastype 加油站性质信息
     * @return 加油站性质集合
     */
	@Override
	public List<Gastype> selectGastypeList(Gastype gastype)
	{
	    return gastypeMapper.selectGastypeList(gastype);
	}
	
    /**
     * 新增加油站性质
     * 
     * @param gastype 加油站性质信息
     * @return 结果
     */
	@Override
	public int insertGastype(Gastype gastype)
	{
	    return gastypeMapper.insertGastype(gastype);
	}
	
	/**
     * 修改加油站性质
     * 
     * @param gastype 加油站性质信息
     * @return 结果
     */
	@Override
	public int updateGastype(Gastype gastype)
	{
	    return gastypeMapper.updateGastype(gastype);
	}

	/**
     * 删除加油站性质对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGastypeByIds(String ids)
	{
		return gastypeMapper.deleteGastypeByIds(Convert.toStrArray(ids));
	}
	
}
