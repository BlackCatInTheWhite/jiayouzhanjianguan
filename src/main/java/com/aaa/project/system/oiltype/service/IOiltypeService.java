package com.aaa.project.system.oiltype.service;

import com.aaa.project.system.oiltype.domain.Oiltype;
import java.util.List;

/**
 * 油品型号 服务层
 * 
 * @author aaa
 * @date 2019-04-23
 */
public interface IOiltypeService 
{
	/**
     * 查询油品型号信息
     * 
     * @param oilId 油品型号ID
     * @return 油品型号信息
     */
	public Oiltype selectOiltypeById(Integer oilId);
	
	/**
     * 查询油品型号列表
     * 
     * @param oiltype 油品型号信息
     * @return 油品型号集合
     */
	public List<Oiltype> selectOiltypeList(Oiltype oiltype);
	
	/**
     * 新增油品型号
     * 
     * @param oiltype 油品型号信息
     * @return 结果
     */
	public int insertOiltype(Oiltype oiltype);
	
	/**
     * 修改油品型号
     * 
     * @param oiltype 油品型号信息
     * @return 结果
     */
	public int updateOiltype(Oiltype oiltype);
		
	/**
     * 删除油品型号信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOiltypeByIds(String ids);
	
}
