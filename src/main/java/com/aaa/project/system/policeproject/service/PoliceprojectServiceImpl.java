package com.aaa.project.system.policeproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaa.project.system.policeproject.mapper.PoliceprojectMapper;
import com.aaa.project.system.policeproject.domain.Policeproject;
import com.aaa.project.system.policeproject.service.IPoliceprojectService;
import com.aaa.common.support.Convert;

/**
 * 项目 服务层实现
 * 
 * @author aaa
 * @date 2019-04-23
 */
@Service
public class PoliceprojectServiceImpl implements IPoliceprojectService 
{
	@Autowired
	private PoliceprojectMapper policeprojectMapper;

	/**
	 * 查询项目信息
	 *
	 * @param policeproject 含有项目分类id
	 * @return 项目信息
	 */
	public List<Policeproject> selectPoliceprojectByMission(Policeproject policeproject){
		return policeprojectMapper.selectPoliceprojectByMission(policeproject);
	}

	/**
     * 查询项目信息
     * 
     * @param projectId 项目ID
     * @return 项目信息
     */
    @Override
	public Policeproject selectPoliceprojectById(Integer projectId)
	{
	    return policeprojectMapper.selectPoliceprojectById(projectId);
	}
	
	/**
     * 查询项目列表
     * 
     * @param policeproject 项目信息
     * @return 项目集合
     */
	@Override
	public List<Policeproject> selectPoliceprojectList(Policeproject policeproject)
	{
	    return policeprojectMapper.selectPoliceprojectList(policeproject);
	}
	
    /**
     * 新增项目
     * 
     * @param policeproject 项目信息
     * @return 结果
     */
	@Override
	public int insertPoliceproject(Policeproject policeproject)
	{
	    return policeprojectMapper.insertPoliceproject(policeproject);
	}
	
	/**
     * 修改项目
     * 
     * @param policeproject 项目信息
     * @return 结果
     */
	@Override
	public int updatePoliceproject(Policeproject policeproject)
	{
	    return policeprojectMapper.updatePoliceproject(policeproject);
	}

	/**
     * 删除项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePoliceprojectByIds(String ids)
	{
		return policeprojectMapper.deletePoliceprojectByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Policeproject> selectProjectGuiFan() {
		return policeprojectMapper.selectProjectGuiFan();
	}
	@Override
	public List<Integer> getPoint(Integer fmissionid){
		return policeprojectMapper.getPoint(fmissionid);
	}

	@Override
	public Integer selectProjectCount() {
		return policeprojectMapper.selectProjectCount();
	}


}
