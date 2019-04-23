package com.aaa.project.system.policenotice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.policenotice.mapper.PolicenoticeMapper;
import com.aaa.project.system.policenotice.domain.Policenotice;
import com.aaa.project.system.policenotice.service.IPolicenoticeService;
import com.aaa.common.support.Convert;

/**
 * 公告 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class PolicenoticeServiceImpl implements IPolicenoticeService 
{
	@Autowired
	private PolicenoticeMapper policenoticeMapper;

	/**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
	public Policenotice selectPolicenoticeById(Integer noticeId)
	{
	    return policenoticeMapper.selectPolicenoticeById(noticeId);
	}
	
	/**
     * 查询公告列表
     * 
     * @param policenotice 公告信息
     * @return 公告集合
     */
	@Override
	public List<Policenotice> selectPolicenoticeList(Policenotice policenotice)
	{
	    return policenoticeMapper.selectPolicenoticeList(policenotice);
	}
	
    /**
     * 新增公告
     * 
     * @param policenotice 公告信息
     * @return 结果
     */
	@Override
	public int insertPolicenotice(Policenotice policenotice)
	{
	    return policenoticeMapper.insertPolicenotice(policenotice);
	}
	
	/**
     * 修改公告
     * 
     * @param policenotice 公告信息
     * @return 结果
     */
	@Override
	public int updatePolicenotice(Policenotice policenotice)
	{
	    return policenoticeMapper.updatePolicenotice(policenotice);
	}

	/**
     * 删除公告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePolicenoticeByIds(String ids)
	{
		return policenoticeMapper.deletePolicenoticeByIds(Convert.toStrArray(ids));
	}
	
}
