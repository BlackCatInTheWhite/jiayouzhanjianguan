package com.aaa.project.system.lpolice.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 派出所表 jyz_lpolice
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Lpolice extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 派出所序号 */
	private Integer lpoliceId;
	/** 公安分局序号 */
	private Integer fpoliceId;
	/** 派出所名称 */
	private String lpoliceName;

	public void setLpoliceId(Integer lpoliceId) 
	{
		this.lpoliceId = lpoliceId;
	}

	public Integer getLpoliceId() 
	{
		return lpoliceId;
	}
	public void setFpoliceId(Integer fpoliceId) 
	{
		this.fpoliceId = fpoliceId;
	}

	public Integer getFpoliceId() 
	{
		return fpoliceId;
	}
	public void setLpoliceName(String lpoliceName) 
	{
		this.lpoliceName = lpoliceName;
	}

	public String getLpoliceName() 
	{
		return lpoliceName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("lpoliceId", getLpoliceId())
            .append("fpoliceId", getFpoliceId())
            .append("lpoliceName", getLpoliceName())
            .toString();
    }
}
