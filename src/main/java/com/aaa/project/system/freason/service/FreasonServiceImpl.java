package com.aaa.project.system.freason.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.freason.mapper.FreasonMapper;
import com.aaa.project.system.freason.domain.Freason;
import com.aaa.project.system.freason.service.IFreasonService;
import com.aaa.common.support.Convert;

/**
 * 观察原因 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class FreasonServiceImpl implements IFreasonService 
{
	@Autowired
	private FreasonMapper freasonMapper;

	/**
     * 查询观察原因信息
     * 
     * @param freasonId 观察原因ID
     * @return 观察原因信息
     */
    @Override
	public Freason selectFreasonById(Integer freasonId)
	{
	    return freasonMapper.selectFreasonById(freasonId);
	}
	
	/**
     * 查询观察原因列表
     * 
     * @param freason 观察原因信息
     * @return 观察原因集合
     */
	@Override
	public List<Freason> selectFreasonList(Freason freason)
	{
	    return freasonMapper.selectFreasonList(freason);
	}
	
    /**
     * 新增观察原因
     * 
     * @param freason 观察原因信息
     * @return 结果
     */
	@Override
	public int insertFreason(Freason freason)
	{
	    return freasonMapper.insertFreason(freason);
	}
	
	/**
     * 修改观察原因
     * 
     * @param freason 观察原因信息
     * @return 结果
     */
	@Override
	public int updateFreason(Freason freason)
	{
	    return freasonMapper.updateFreason(freason);
	}

	/**
     * 删除观察原因对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFreasonByIds(String ids)
	{
		return freasonMapper.deleteFreasonByIds(Convert.toStrArray(ids));
	}
	
}
