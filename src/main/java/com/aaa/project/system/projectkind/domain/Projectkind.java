package com.aaa.project.system.projectkind.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 项目分类表 jyz_projectkind
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Projectkind extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 项目分类序号 */
	private Integer projectKindid;
	/** 项目分类名称 */
	private String projectKind;

	public void setProjectKindid(Integer projectKindid) 
	{
		this.projectKindid = projectKindid;
	}

	public Integer getProjectKindid() 
	{
		return projectKindid;
	}
	public void setProjectKind(String projectKind) 
	{
		this.projectKind = projectKind;
	}

	public String getProjectKind() 
	{
		return projectKind;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectKindid", getProjectKindid())
            .append("projectKind", getProjectKind())
            .toString();
    }
}
