package com.aaa.project.system.gasstatus.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 加油站状态表 jyz_gasstatus
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Gasstatus extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 加油站状态序号 */
	private Integer gasstatusId;
	/** 加油站状态 */
	private String gasstatusName;

	public void setGasstatusId(Integer gasstatusId) 
	{
		this.gasstatusId = gasstatusId;
	}

	public Integer getGasstatusId() 
	{
		return gasstatusId;
	}
	public void setGasstatusName(String gasstatusName) 
	{
		this.gasstatusName = gasstatusName;
	}

	public String getGasstatusName() 
	{
		return gasstatusName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gasstatusId", getGasstatusId())
            .append("gasstatusName", getGasstatusName())
            .toString();
    }
}
