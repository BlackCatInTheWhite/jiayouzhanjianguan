package com.aaa.project.system.missionstate.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 巡检状态表 jyz_missionstate
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Missionstate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 巡检任务序号 */
	private Integer missionStateid;
	/** 巡检任务名称 */
	private String missionStatename;

	public void setMissionStateid(Integer missionStateid) 
	{
		this.missionStateid = missionStateid;
	}

	public Integer getMissionStateid() 
	{
		return missionStateid;
	}
	public void setMissionStatename(String missionStatename) 
	{
		this.missionStatename = missionStatename;
	}

	public String getMissionStatename() 
	{
		return missionStatename;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("missionStateid", getMissionStateid())
            .append("missionStatename", getMissionStatename())
            .toString();
    }
}
