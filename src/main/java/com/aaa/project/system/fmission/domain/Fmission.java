package com.aaa.project.system.fmission.domain;

import com.aaa.framework.web.domain.BaseEntity;
import com.aaa.project.system.missionstate.domain.Missionstate;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 分任务记录表 jyz_fmission
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Fmission extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 任务记录序号 */
	private Integer fmissionId;
	/** 总任务序号 */
	private Integer zmissionId;
	/** 提交时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fmissionCommit;
	/** 任务审核状态序号 */
	private Integer fmissionState;
	/** 分数 */
	private Integer point;
	/** 任务审核状态 */
	private Missionstate missionstateName;

	public Missionstate getMissionstateName() {
		return missionstateName;
	}

	public void setMissionstateName(Missionstate missionstateName) {
		this.missionstateName = missionstateName;
	}

	public void setFmissionId(Integer fmissionId)
	{
		this.fmissionId = fmissionId;
	}

	public Integer getFmissionId() 
	{
		return fmissionId;
	}
	public void setZmissionId(Integer zmissionId) 
	{
		this.zmissionId = zmissionId;
	}

	public Integer getZmissionId() 
	{
		return zmissionId;
	}
	public void setFmissionCommit(Date fmissionCommit) 
	{
		this.fmissionCommit = fmissionCommit;
	}

	public Date getFmissionCommit() 
	{
		return fmissionCommit;
	}
	public void setFmissionState(Integer fmissionState) 
	{
		this.fmissionState = fmissionState;
	}

	public Integer getFmissionState() 
	{
		return fmissionState;
	}
	public void setPoint(Integer point) 
	{
		this.point = point;
	}

	public Integer getPoint() 
	{
		return point;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fmissionId", getFmissionId())
            .append("zmissionId", getZmissionId())
            .append("fmissionCommit", getFmissionCommit())
            .append("fmissionState", getFmissionState())
            .append("point", getPoint()).append("missionstateName",getMissionstateName())
            .toString();
    }
}