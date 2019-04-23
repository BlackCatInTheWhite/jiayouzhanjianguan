package com.aaa.project.system.oilkind.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 油品类型表 jyz_oilkind
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Oilkind extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 油品类型序号 */
	private Integer oilKindid;
	/** 油品类型 */
	private String oilKindname;

	public void setOilKindid(Integer oilKindid) 
	{
		this.oilKindid = oilKindid;
	}

	public Integer getOilKindid() 
	{
		return oilKindid;
	}
	public void setOilKindname(String oilKindname) 
	{
		this.oilKindname = oilKindname;
	}

	public String getOilKindname() 
	{
		return oilKindname;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("oilKindid", getOilKindid())
            .append("oilKindname", getOilKindname())
            .toString();
    }
}
