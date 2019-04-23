package com.aaa.project.system.oilkind.service;

import com.aaa.project.system.oilkind.domain.Oilkind;
import java.util.List;

/**
 * 油品类型 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IOilkindService 
{
	/**
     * 查询油品类型信息
     * 
     * @param oilKindid 油品类型ID
     * @return 油品类型信息
     */
	public Oilkind selectOilkindById(Integer oilKindid);
	
	/**
     * 查询油品类型列表
     * 
     * @param oilkind 油品类型信息
     * @return 油品类型集合
     */
	public List<Oilkind> selectOilkindList(Oilkind oilkind);
	
	/**
     * 新增油品类型
     * 
     * @param oilkind 油品类型信息
     * @return 结果
     */
	public int insertOilkind(Oilkind oilkind);
	
	/**
     * 修改油品类型
     * 
     * @param oilkind 油品类型信息
     * @return 结果
     */
	public int updateOilkind(Oilkind oilkind);
		
	/**
     * 删除油品类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOilkindByIds(String ids);
	
}
