package com.aaa.project.system.buyoilform.service;

import com.aaa.project.system.buyoilform.domain.Buyoilform;
import java.util.List;

/**
 * 散装油登记 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IBuyoilformService 
{
	/**
     * 查询散装油登记信息
     * 
     * @param id 散装油登记ID
     * @return 散装油登记信息
     */
	public Buyoilform selectBuyoilformById(Integer id);
	
	/**
     * 查询散装油登记列表
     * 
     * @param buyoilform 散装油登记信息
     * @return 散装油登记集合
     */
	public List<Buyoilform> selectBuyoilformList(Buyoilform buyoilform);
	
	/**
     * 新增散装油登记
     * 
     * @param buyoilform 散装油登记信息
     * @return 结果
     */
	public int insertBuyoilform(Buyoilform buyoilform);
	
	/**
     * 修改散装油登记
     * 
     * @param buyoilform 散装油登记信息
     * @return 结果
     */
	public int updateBuyoilform(Buyoilform buyoilform);
		
	/**
     * 删除散装油登记信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBuyoilformByIds(String ids);
	
}
