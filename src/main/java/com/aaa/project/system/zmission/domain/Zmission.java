package com.aaa.project.system.zmission.domain;

import com.aaa.framework.web.domain.BaseEntity;
import com.aaa.project.system.gas.domain.Gas;
import com.aaa.project.system.policeman.domain.Policeman;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 巡查总任务分排表 jyz_zmission
 * 
 * @author aaa
 * @date 2019-04-24
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date missionBegin;
	/** 任务结束时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date missionEnd;
	/** 上次提交时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date missionLastcommit;
	/** 任务频次 */
	private Integer missionTimes;
	/** 任务剩余 */
	private Integer missionLeft;
	/** 所属加油站 */
	private Gas gasName;
	/** 巡查人员 */
	private Policeman policemanName;
	/** 地区内所有加油站 */
	private List<Integer> gasidlist;

	public List<Integer> getGasidlist() {
		return gasidlist;
	}

	public void setGasidlist(List<Integer> gasidlist) {
		this.gasidlist = gasidlist;
	}

	public Gas getGasName() {
		return gasName;
	}

	public void setGasName(Gas gasName) {
		this.gasName = gasName;
	}

	public Policeman getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(Policeman policemanName) {
		this.policemanName = policemanName;
	}

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
	public void setMissionLeft(Integer missionLeft) 
	{
		this.missionLeft = missionLeft;
	}

	public Integer getMissionLeft() 
	{
		return missionLeft;
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
            .append("missionLeft", getMissionLeft()).append("Gasidlist",getGasidlist())
            .toString();
    }
}
