package com.aaa.project.system.rectification.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 整改表 jyz_rectification
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Rectification extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 整改序号 */
	private Integer rectificationId;
	/** 加油站序号 */
	private Integer gasId;
	/** 任务记录序号 */
	private Integer fmissionId;
	/** 更改描述 */
	private String rectificationDes;
	/** 整改负责人序号 */
	private Integer rectificationPolicemanid;
	/** 状态 */
	private Integer rectificationState;
	/** 整改时间 */
	private Integer rectificationTime;
	/** 整改开始时间 */
	private Date rectificationBegin;

	public void setRectificationId(Integer rectificationId) 
	{
		this.rectificationId = rectificationId;
	}

	public Integer getRectificationId() 
	{
		return rectificationId;
	}
	public void setGasId(Integer gasId) 
	{
		this.gasId = gasId;
	}

	public Integer getGasId() 
	{
		return gasId;
	}
	public void setFmissionId(Integer fmissionId) 
	{
		this.fmissionId = fmissionId;
	}

	public Integer getFmissionId() 
	{
		return fmissionId;
	}
	public void setRectificationDes(String rectificationDes) 
	{
		this.rectificationDes = rectificationDes;
	}

	public String getRectificationDes() 
	{
		return rectificationDes;
	}
	public void setRectificationPolicemanid(Integer rectificationPolicemanid) 
	{
		this.rectificationPolicemanid = rectificationPolicemanid;
	}

	public Integer getRectificationPolicemanid() 
	{
		return rectificationPolicemanid;
	}
	public void setRectificationState(Integer rectificationState) 
	{
		this.rectificationState = rectificationState;
	}

	public Integer getRectificationState() 
	{
		return rectificationState;
	}
	public void setRectificationTime(Integer rectificationTime) 
	{
		this.rectificationTime = rectificationTime;
	}

	public Integer getRectificationTime() 
	{
		return rectificationTime;
	}
	public void setRectificationBegin(Date rectificationBegin) 
	{
		this.rectificationBegin = rectificationBegin;
	}

	public Date getRectificationBegin() 
	{
		return rectificationBegin;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rectificationId", getRectificationId())
            .append("gasId", getGasId())
            .append("fmissionId", getFmissionId())
            .append("rectificationDes", getRectificationDes())
            .append("rectificationPolicemanid", getRectificationPolicemanid())
            .append("rectificationState", getRectificationState())
            .append("rectificationTime", getRectificationTime())
            .append("rectificationBegin", getRectificationBegin())
            .toString();
    }
}
