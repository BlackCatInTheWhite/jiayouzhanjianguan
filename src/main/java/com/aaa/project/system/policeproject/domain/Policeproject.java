package com.aaa.project.system.policeproject.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 项目表 jyz_policeproject
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Policeproject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 项目序号 */
	private Integer projectId;
	/** 项目分类序号 */
	private Integer projectKindid;
	/** 项目名称 */
	private String projectName;
	/** 分数 */
	private Integer point;

	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setProjectKindid(Integer projectKindid) 
	{
		this.projectKindid = projectKindid;
	}

	public Integer getProjectKindid() 
	{
		return projectKindid;
	}
	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}

	public String getProjectName() 
	{
		return projectName;
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
            .append("projectId", getProjectId())
            .append("projectKindid", getProjectKindid())
            .append("projectName", getProjectName())
            .append("point", getPoint())
            .toString();
    }
}
