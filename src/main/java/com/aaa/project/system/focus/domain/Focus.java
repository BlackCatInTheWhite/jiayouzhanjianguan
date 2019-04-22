package com.aaa.project.system.focus.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 重点观察表 jyz_focus
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Focus extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 重点观察序号 */
	private Integer focusId;
	/** 身份证号 */
	private String focusCard;
	/** 原因序号 */
	private Integer freasonId;

	public void setFocusId(Integer focusId) 
	{
		this.focusId = focusId;
	}

	public Integer getFocusId() 
	{
		return focusId;
	}
	public void setFocusCard(String focusCard) 
	{
		this.focusCard = focusCard;
	}

	public String getFocusCard() 
	{
		return focusCard;
	}
	public void setFreasonId(Integer freasonId) 
	{
		this.freasonId = freasonId;
	}

	public Integer getFreasonId() 
	{
		return freasonId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("focusId", getFocusId())
            .append("focusCard", getFocusCard())
            .append("freasonId", getFreasonId())
            .toString();
    }
}
