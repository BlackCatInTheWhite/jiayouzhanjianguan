package com.aaa.project.system.zpolice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.zpolice.mapper.ZpoliceMapper;
import com.aaa.project.system.zpolice.domain.Zpolice;
import com.aaa.project.system.zpolice.service.IZpoliceService;
import com.aaa.common.support.Convert;

/**
 * 公安总局 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class ZpoliceServiceImpl implements IZpoliceService 
{
	@Autowired
	private ZpoliceMapper zpoliceMapper;

	/**
     * 查询公安总局信息
     * 
     * @param zpoliceId 公安总局ID
     * @return 公安总局信息
     */
    @Override
	public Zpolice selectZpoliceById(Integer zpoliceId)
	{
	    return zpoliceMapper.selectZpoliceById(zpoliceId);
	}
	
	/**
     * 查询公安总局列表
     * 
     * @param zpolice 公安总局信息
     * @return 公安总局集合
     */
	@Override
	public List<Zpolice> selectZpoliceList(Zpolice zpolice)
	{
	    return zpoliceMapper.selectZpoliceList(zpolice);
	}
	
    /**
     * 新增公安总局
     * 
     * @param zpolice 公安总局信息
     * @return 结果
     */
	@Override
	public int insertZpolice(Zpolice zpolice)
	{
	    return zpoliceMapper.insertZpolice(zpolice);
	}
	
	/**
     * 修改公安总局
     * 
     * @param zpolice 公安总局信息
     * @return 结果
     */
	@Override
	public int updateZpolice(Zpolice zpolice)
	{
	    return zpoliceMapper.updateZpolice(zpolice);
	}

	/**
     * 删除公安总局对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteZpoliceByIds(String ids)
	{
		return zpoliceMapper.deleteZpoliceByIds(Convert.toStrArray(ids));
	}
	
}
