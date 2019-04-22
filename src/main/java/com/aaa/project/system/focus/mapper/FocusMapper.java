package com.aaa.project.system.focus.mapper;

import com.aaa.project.system.focus.domain.Focus;
import java.util.List;	

/**
 * 重点观察 数据层
 * 
 * @author aaa
 * @date 2019-04-22
 */
public interface FocusMapper 
{
	/**
     * 查询重点观察信息
     * 
     * @param focusId 重点观察ID
     * @return 重点观察信息
     */
	public Focus selectFocusById(Integer focusId);
	
	/**
     * 查询重点观察列表
     * 
     * @param focus 重点观察信息
     * @return 重点观察集合
     */
	public List<Focus> selectFocusList(Focus focus);
	
	/**
     * 新增重点观察
     * 
     * @param focus 重点观察信息
     * @return 结果
     */
	public int insertFocus(Focus focus);
	
	/**
     * 修改重点观察
     * 
     * @param focus 重点观察信息
     * @return 结果
     */
	public int updateFocus(Focus focus);
	
	/**
     * 删除重点观察
     * 
     * @param focusId 重点观察ID
     * @return 结果
     */
	public int deleteFocusById(Integer focusId);
	
	/**
     * 批量删除重点观察
     * 
     * @param focusIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteFocusByIds(String[] focusIds);
	
}