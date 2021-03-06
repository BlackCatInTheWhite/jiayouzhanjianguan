package com.aaa.project.system.policeproject.domain;

import com.aaa.project.system.projectkind.domain.Projectkind;
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

	private String projectKind;



	/** 项目名称 */
	private String projectName;
	/** 分数 */
	private Integer point;
	/** 项目分类 */
	private Projectkind projectkindName;

	public Projectkind getProjectkindName() {
		return projectkindName;
	}

	public void setProjectkindName(Projectkind projectkindName) {
		this.projectkindName = projectkindName;
	}

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
	public String getProjectKind() {
		return projectKind;
	}

	public void setProjectKind(String projectKind) {
		this.projectKind = projectKind;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectKindid", getProjectKindid())
            .append("projectName", getProjectName())
            .append("point", getPoint()).append("projectkindName",getProjectkindName())
            .toString();
    }
}
