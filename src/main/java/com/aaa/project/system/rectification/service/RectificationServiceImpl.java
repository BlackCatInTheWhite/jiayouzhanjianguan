package com.aaa.project.system.rectification.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.rectification.mapper.RectificationMapper;
import com.aaa.project.system.rectification.domain.Rectification;
import com.aaa.project.system.rectification.service.IRectificationService;
import com.aaa.common.support.Convert;

/**
 * 整改 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class RectificationServiceImpl implements IRectificationService 
{
	@Autowired
	private RectificationMapper rectificationMapper;

	/**
     * 查询整改信息
     * 
     * @param rectificationId 整改ID
     * @return 整改信息
     */
    @Override
	public Rectification selectRectificationById(Integer rectificationId)
	{
	    return rectificationMapper.selectRectificationById(rectificationId);
	}
	
	/**
     * 查询整改列表
     * 
     * @param rectification 整改信息
     * @return 整改集合
     */
	@Override
	public List<Rectification> selectRectificationList(Rectification rectification)
	{
	    return rectificationMapper.selectRectificationList(rectification);
	}
	
    /**
     * 新增整改
     * 
     * @param rectification 整改信息
     * @return 结果
     */
	@Override
	public int insertRectification(Rectification rectification)
	{
	    return rectificationMapper.insertRectification(rectification);
	}
	
	/**
     * 修改整改
     * 
     * @param rectification 整改信息
     * @return 结果
     */
	@Override
	public int updateRectification(Rectification rectification)
	{
	    return rectificationMapper.updateRectification(rectification);
	}

	/**
     * 删除整改对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRectificationByIds(String ids)
	{
		return rectificationMapper.deleteRectificationByIds(Convert.toStrArray(ids));
	}
	
}
