package com.aaa.project.system.oiltype.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.oiltype.mapper.OiltypeMapper;
import com.aaa.project.system.oiltype.domain.Oiltype;
import com.aaa.project.system.oiltype.service.IOiltypeService;
import com.aaa.common.support.Convert;

/**
 * 油品型号 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class OiltypeServiceImpl implements IOiltypeService 
{
	@Autowired
	private OiltypeMapper oiltypeMapper;

	/**
     * 查询油品型号信息
     * 
     * @param oilId 油品型号ID
     * @return 油品型号信息
     */
    @Override
	public Oiltype selectOiltypeById(Integer oilId)
	{
	    return oiltypeMapper.selectOiltypeById(oilId);
	}
	
	/**
     * 查询油品型号列表
     * 
     * @param oiltype 油品型号信息
     * @return 油品型号集合
     */
	@Override
	public List<Oiltype> selectOiltypeList(Oiltype oiltype)
	{
	    return oiltypeMapper.selectOiltypeList(oiltype);
	}
	
    /**
     * 新增油品型号
     * 
     * @param oiltype 油品型号信息
     * @return 结果
     */
	@Override
	public int insertOiltype(Oiltype oiltype)
	{
	    return oiltypeMapper.insertOiltype(oiltype);
	}
	
	/**
     * 修改油品型号
     * 
     * @param oiltype 油品型号信息
     * @return 结果
     */
	@Override
	public int updateOiltype(Oiltype oiltype)
	{
	    return oiltypeMapper.updateOiltype(oiltype);
	}

	/**
     * 删除油品型号对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOiltypeByIds(String ids)
	{
		return oiltypeMapper.deleteOiltypeByIds(Convert.toStrArray(ids));
	}
	
}
