package com.aaa.project.system.zmission.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 巡查总任务分排表 jyz_zmission
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Zmission extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 任务序号 */
	private Integer missionId;
	/** 加油站序号 */
	private Integer gasId;
	/** 巡查人员序号 */
	private Integer policeManid;
	/** 任务开始时间 */
	private Date missionBegin;
	/** 任务结束时间 */
	private Date missionEnd;
	/** 上次提交时间 */
	private Date missionLastcommit;
	/** 任务频次 */
	private Integer missionTimes;

	public void setMissionId(Integer missionId) 
	{
		this.missionId = missionId;
	}

	public Integer getMissionId() 
	{
		return missionId;
	}
	public void setGasId(Integer gasId) 
	{
		this.gasId = gasId;
	}

	public Integer getGasId() 
	{
		return gasId;
	}
	public void setPoliceManid(Integer policeManid) 
	{
		this.policeManid = policeManid;
	}

	public Integer getPoliceManid() 
	{
		return policeManid;
	}
	public void setMissionBegin(Date missionBegin) 
	{
		this.missionBegin = missionBegin;
	}

	public Date getMissionBegin() 
	{
		return missionBegin;
	}
	public void setMissionEnd(Date missionEnd) 
	{
		this.missionEnd = missionEnd;
	}

	public Date getMissionEnd() 
	{
		return missionEnd;
	}
	public void setMissionLastcommit(Date missionLastcommit) 
	{
		this.missionLastcommit = missionLastcommit;
	}

	public Date getMissionLastcommit() 
	{
		return missionLastcommit;
	}
	public void setMissionTimes(Integer missionTimes) 
	{
		this.missionTimes = missionTimes;
	}

	public Integer getMissionTimes() 
	{
		return missionTimes;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("missionId", getMissionId())
            .append("gasId", getGasId())
            .append("policeManid", getPoliceManid())
            .append("missionBegin", getMissionBegin())
            .append("missionEnd", getMissionEnd())
            .append("missionLastcommit", getMissionLastcommit())
            .append("missionTimes", getMissionTimes())
            .toString();
    }
}
