package com.aaa.project.system.missionproject.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 巡查项目表 jyz_missionproject
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Missionproject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 任务序号 */
	private Integer missionId;
	/** 任务序号 */
	private Integer projectId;

	public void setMissionId(Integer missionId) 
	{
		this.missionId = missionId;
	}

	public Integer getMissionId() 
	{
		return missionId;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("missionId", getMissionId())
            .append("projectId", getProjectId())
            .toString();
    }
}
