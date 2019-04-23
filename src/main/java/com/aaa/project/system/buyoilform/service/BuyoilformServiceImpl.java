package com.aaa.project.system.buyoilform.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.buyoilform.mapper.BuyoilformMapper;
import com.aaa.project.system.buyoilform.domain.Buyoilform;
import com.aaa.project.system.buyoilform.service.IBuyoilformService;
import com.aaa.common.support.Convert;

/**
 * 散装油登记 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class BuyoilformServiceImpl implements IBuyoilformService 
{
	@Autowired
	private BuyoilformMapper buyoilformMapper;

	/**
     * 查询散装油登记信息
     * 
     * @param id 散装油登记ID
     * @return 散装油登记信息
     */
    @Override
	public Buyoilform selectBuyoilformById(Integer id)
	{
	    return buyoilformMapper.selectBuyoilformById(id);
	}
	
	/**
     * 查询散装油登记列表
     * 
     * @param buyoilform 散装油登记信息
     * @return 散装油登记集合
     */
	@Override
	public List<Buyoilform> selectBuyoilformList(Buyoilform buyoilform)
	{
	    return buyoilformMapper.selectBuyoilformList(buyoilform);
	}
	
    /**
     * 新增散装油登记
     * 
     * @param buyoilform 散装油登记信息
     * @return 结果
     */
	@Override
	public int insertBuyoilform(Buyoilform buyoilform)
	{
	    return buyoilformMapper.insertBuyoilform(buyoilform);
	}
	
	/**
     * 修改散装油登记
     * 
     * @param buyoilform 散装油登记信息
     * @return 结果
     */
	@Override
	public int updateBuyoilform(Buyoilform buyoilform)
	{
	    return buyoilformMapper.updateBuyoilform(buyoilform);
	}

	/**
     * 删除散装油登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBuyoilformByIds(String ids)
	{
		return buyoilformMapper.deleteBuyoilformByIds(Convert.toStrArray(ids));
	}
	
}
