package com.aaa.project.system.focus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.focus.mapper.FocusMapper;
import com.aaa.project.system.focus.domain.Focus;
import com.aaa.project.system.focus.service.IFocusService;
import com.aaa.common.support.Convert;

/**
 * 重点观察 服务层实现
 * 
 * @author aaa
 * @date 2019-04-22
 */
@Service
public class FocusServiceImpl implements IFocusService 
{
	@Autowired
	private FocusMapper focusMapper;

	/**
     * 查询重点观察信息
     * 
     * @param focusId 重点观察ID
     * @return 重点观察信息
     */
    @Override
	public Focus selectFocusById(Integer focusId)
	{
	    return focusMapper.selectFocusById(focusId);
	}
	
	/**
     * 查询重点观察列表
     * 
     * @param focus 重点观察信息
     * @return 重点观察集合
     */
	@Override
	public List<Focus> selectFocusList(Focus focus)
	{
	    return focusMapper.selectFocusList(focus);
	}
	
    /**
     * 新增重点观察
     * 
     * @param focus 重点观察信息
     * @return 结果
     */
	@Override
	public int insertFocus(Focus focus)
	{
	    return focusMapper.insertFocus(focus);
	}
	
	/**
     * 修改重点观察
     * 
     * @param focus 重点观察信息
     * @return 结果
     */
	@Override
	public int updateFocus(Focus focus)
	{
	    return focusMapper.updateFocus(focus);
	}

	/**
     * 删除重点观察对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFocusByIds(String ids)
	{
		return focusMapper.deleteFocusByIds(Convert.toStrArray(ids));
	}
	
}
