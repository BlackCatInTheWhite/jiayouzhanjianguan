package com.aaa.project.system.fpolice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.fpolice.mapper.FpoliceMapper;
import com.aaa.project.system.fpolice.domain.Fpolice;
import com.aaa.project.system.fpolice.service.IFpoliceService;
import com.aaa.common.support.Convert;

/**
 * 公安分局 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class FpoliceServiceImpl implements IFpoliceService 
{
	@Autowired
	private FpoliceMapper fpoliceMapper;

	/**
     * 查询公安分局信息
     * 
     * @param fpoliceId 公安分局ID
     * @return 公安分局信息
     */
    @Override
	public Fpolice selectFpoliceById(Integer fpoliceId)
	{
	    return fpoliceMapper.selectFpoliceById(fpoliceId);
	}
	
	/**
     * 查询公安分局列表
     * 
     * @param fpolice 公安分局信息
     * @return 公安分局集合
     */
	@Override
	public List<Fpolice> selectFpoliceList(Fpolice fpolice)
	{
	    return fpoliceMapper.selectFpoliceList(fpolice);
	}
	
    /**
     * 新增公安分局
     * 
     * @param fpolice 公安分局信息
     * @return 结果
     */
	@Override
	public int insertFpolice(Fpolice fpolice)
	{
	    return fpoliceMapper.insertFpolice(fpolice);
	}
	
	/**
     * 修改公安分局
     * 
     * @param fpolice 公安分局信息
     * @return 结果
     */
	@Override
	public int updateFpolice(Fpolice fpolice)
	{
	    return fpoliceMapper.updateFpolice(fpolice);
	}

	/**
     * 删除公安分局对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFpoliceByIds(String ids)
	{
		return fpoliceMapper.deleteFpoliceByIds(Convert.toStrArray(ids));
	}
	
}
