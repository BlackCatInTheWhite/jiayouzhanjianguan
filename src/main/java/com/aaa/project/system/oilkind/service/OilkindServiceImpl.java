package com.aaa.project.system.oilkind.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.oilkind.mapper.OilkindMapper;
import com.aaa.project.system.oilkind.domain.Oilkind;
import com.aaa.project.system.oilkind.service.IOilkindService;
import com.aaa.common.support.Convert;

/**
 * 油品类型 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class OilkindServiceImpl implements IOilkindService 
{
	@Autowired
	private OilkindMapper oilkindMapper;

	/**
     * 查询油品类型信息
     * 
     * @param oilKindid 油品类型ID
     * @return 油品类型信息
     */
    @Override
	public Oilkind selectOilkindById(Integer oilKindid)
	{
	    return oilkindMapper.selectOilkindById(oilKindid);
	}
	
	/**
     * 查询油品类型列表
     * 
     * @param oilkind 油品类型信息
     * @return 油品类型集合
     */
	@Override
	public List<Oilkind> selectOilkindList(Oilkind oilkind)
	{
	    return oilkindMapper.selectOilkindList(oilkind);
	}
	
    /**
     * 新增油品类型
     * 
     * @param oilkind 油品类型信息
     * @return 结果
     */
	@Override
	public int insertOilkind(Oilkind oilkind)
	{
	    return oilkindMapper.insertOilkind(oilkind);
	}
	
	/**
     * 修改油品类型
     * 
     * @param oilkind 油品类型信息
     * @return 结果
     */
	@Override
	public int updateOilkind(Oilkind oilkind)
	{
	    return oilkindMapper.updateOilkind(oilkind);
	}

	/**
     * 删除油品类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOilkindByIds(String ids)
	{
		return oilkindMapper.deleteOilkindByIds(Convert.toStrArray(ids));
	}
	
}
