package com.aaa.project.system.focus.domain;

import com.aaa.project.system.freason.domain.Freason;
import com.aaa.project.system.gasman.domain.Gasman;
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
	/** 原因名称 */
	private Freason freasonName;
	/** 人员信息 */
	private Gasman gasman;

	public Freason getFreasonName() {
		return freasonName;
	}

	public void setFreasonName(Freason freasonName) {
		this.freasonName = freasonName;
	}

	public Gasman getGasman() {
		return gasman;
	}

	public void setGasman(Gasman gasman) {
		this.gasman = gasman;
	}

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
            .append("freasonId", getFreasonId()).append("freasonName",getFreasonName()).append("gasman",getGasman())
            .toString();
    }
}
