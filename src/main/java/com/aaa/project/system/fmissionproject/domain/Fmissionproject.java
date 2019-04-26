package com.aaa.project.system.fmissionproject.domain;

import com.aaa.project.system.policeproject.domain.Policeproject;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;

/**
 * 项目记录表 jyz_fmissionproject
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Fmissionproject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 项目记录序号 */
	private Integer projectMissionid;
	/** 分项目记录序号 */
	private Integer fmissionId;
	/** 项目序号 */
	private Integer projectId;
	/** 提交项目状态 */
	private Integer projectState;
	/** 不通过图片 */
	private String projectPicturesrc;
	/** 不通过描述 */
	private String projectDescribe;
	/** 项目名称 */
	private Policeproject policeprojectName;

	public Policeproject getPoliceprojectName() {
		return policeprojectName;
	}

	public void setPoliceprojectName(Policeproject policeprojectName) {
		this.policeprojectName = policeprojectName;
	}

	public void setProjectMissionid(Integer projectMissionid)
	{
		this.projectMissionid = projectMissionid;
	}

	public Integer getProjectMissionid() 
	{
		return projectMissionid;
	}
	public void setFmissionId(Integer fmissionId) 
	{
		this.fmissionId = fmissionId;
	}

	public Integer getFmissionId() 
	{
		return fmissionId;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setProjectState(Integer projectState) 
	{
		this.projectState = projectState;
	}

	public Integer getProjectState() 
	{
		return projectState;
	}
	public void setProjectPicturesrc(String projectPicturesrc) 
	{
		this.projectPicturesrc = projectPicturesrc;
	}

	public String getProjectPicturesrc() 
	{
		return projectPicturesrc;
	}
	public void setProjectDescribe(String projectDescribe) 
	{
		this.projectDescribe = projectDescribe;
	}

	public String getProjectDescribe() 
	{
		return projectDescribe;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectMissionid", getProjectMissionid())
            .append("fmissionId", getFmissionId())
            .append("projectId", getProjectId())
            .append("projectState", getProjectState())
            .append("projectPicturesrc", getProjectPicturesrc())
            .append("projectDescribe", getProjectDescribe()).append("policeprojectName",getPoliceprojectName())
            .toString();
    }
}
