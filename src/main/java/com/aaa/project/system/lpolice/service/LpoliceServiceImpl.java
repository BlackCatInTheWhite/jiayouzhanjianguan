package com.aaa.project.system.lpolice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.lpolice.mapper.LpoliceMapper;
import com.aaa.project.system.lpolice.domain.Lpolice;
import com.aaa.project.system.lpolice.service.ILpoliceService;
import com.aaa.common.support.Convert;

/**
 * 派出所 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class LpoliceServiceImpl implements ILpoliceService 
{
	@Autowired
	private LpoliceMapper lpoliceMapper;

	/**
     * 查询派出所信息
     * 
     * @param lpoliceId 派出所ID
     * @return 派出所信息
     */
    @Override
	public Lpolice selectLpoliceById(Integer lpoliceId)
	{
	    return lpoliceMapper.selectLpoliceById(lpoliceId);
	}
	
	/**
     * 查询派出所列表
     * 
     * @param lpolice 派出所信息
     * @return 派出所集合
     */
	@Override
	public List<Lpolice> selectLpoliceList(Lpolice lpolice)
	{
	    return lpoliceMapper.selectLpoliceList(lpolice);
	}
	
    /**
     * 新增派出所
     * 
     * @param lpolice 派出所信息
     * @return 结果
     */
	@Override
	public int insertLpolice(Lpolice lpolice)
	{
	    return lpoliceMapper.insertLpolice(lpolice);
	}
	
	/**
     * 修改派出所
     * 
     * @param lpolice 派出所信息
     * @return 结果
     */
	@Override
	public int updateLpolice(Lpolice lpolice)
	{
	    return lpoliceMapper.updateLpolice(lpolice);
	}

	/**
     * 删除派出所对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLpoliceByIds(String ids)
	{
		return lpoliceMapper.deleteLpoliceByIds(Convert.toStrArray(ids));
	}
	
}
