package com.aaa.project.system.policenotice.domain;

import com.aaa.project.system.policeman.domain.Policeman;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 公告表 jyz_policenotice
 * 
 * @author aaa
 * @date 2019-04-23
 */
public class Policenotice extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 公告序号 */
	private Integer noticeId;
	/** 公告标题 */
	private String noticeTitle;
	/** 公告时间 */
	private Date noticeTime;
	/** 公告发布人 */
	private Integer noticePlicemanid;
	/** 公告内容 */
	private String noticeContent;
	/** 公告发布人姓名 */
	private Policeman policemanName;

	public Policeman getPolicemanName() {
		return policemanName;
	}

	public void setPolicemanName(Policeman policemanName) {
		this.policemanName = policemanName;
	}

	public void setNoticeId(Integer noticeId)
	{
		this.noticeId = noticeId;
	}

	public Integer getNoticeId() 
	{
		return noticeId;
	}
	public void setNoticeTitle(String noticeTitle) 
	{
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeTitle() 
	{
		return noticeTitle;
	}
	public void setNoticeTime(Date noticeTime) 
	{
		this.noticeTime = noticeTime;
	}

	public Date getNoticeTime() 
	{
		return noticeTime;
	}
	public void setNoticePlicemanid(Integer noticePlicemanid) 
	{
		this.noticePlicemanid = noticePlicemanid;
	}

	public Integer getNoticePlicemanid() 
	{
		return noticePlicemanid;
	}
	public void setNoticeContent(String noticeContent) 
	{
		this.noticeContent = noticeContent;
	}

	public String getNoticeContent() 
	{
		return noticeContent;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeTime", getNoticeTime())
            .append("noticePlicemanid", getNoticePlicemanid())
            .append("noticeContent", getNoticeContent()).append("policemanName",getPolicemanName())
            .toString();
    }
}
