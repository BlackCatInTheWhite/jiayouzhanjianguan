package com.aaa.project.system.gasman.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 加油站员工表 jyz_gasman
 * 
 * @author aaa
 * @date 2019-04-22
 */
public class Gasman extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 加油站员工序号 */
	private Integer gasmanId;
	/** 姓名 */
	private String gasmanName;
	/** 性别 */
	private Integer gasmanGender;
	/** 身份证号 */
	private String gasmanCard;
	/** 出生日期 */
	private Date gasmanBirthday;
	/** 民族 */
	private String gasmanEthnic;
	/** 户籍所属县区 */
	private Integer gasmanBirtharea;
	/** 户籍地详址 */
	private String gasmanBirthplace;
	/** 现居住地所属县区 */
	private Integer gasmanHomearea;
	/** 联系方式 */
	private String gasmanPhone;
	/** 加油站序号 */
	private Integer gasId;

	public void setGasmanId(Integer gasmanId) 
	{
		this.gasmanId = gasmanId;
	}

	public Integer getGasmanId() 
	{
		return gasmanId;
	}
	public void setGasmanName(String gasmanName) 
	{
		this.gasmanName = gasmanName;
	}

	public String getGasmanName() 
	{
		return gasmanName;
	}
	public void setGasmanGender(Integer gasmanGender) 
	{
		this.gasmanGender = gasmanGender;
	}

	public Integer getGasmanGender() 
	{
		return gasmanGender;
	}
	public void setGasmanCard(String gasmanCard) 
	{
		this.gasmanCard = gasmanCard;
	}

	public String getGasmanCard() 
	{
		return gasmanCard;
	}
	public void setGasmanBirthday(Date gasmanBirthday) 
	{
		this.gasmanBirthday = gasmanBirthday;
	}

	public Date getGasmanBirthday() 
	{
		return gasmanBirthday;
	}
	public void setGasmanEthnic(String gasmanEthnic) 
	{
		this.gasmanEthnic = gasmanEthnic;
	}

	public String getGasmanEthnic() 
	{
		return gasmanEthnic;
	}
	public void setGasmanBirtharea(Integer gasmanBirtharea) 
	{
		this.gasmanBirtharea = gasmanBirtharea;
	}

	public Integer getGasmanBirtharea() 
	{
		return gasmanBirtharea;
	}
	public void setGasmanBirthplace(String gasmanBirthplace) 
	{
		this.gasmanBirthplace = gasmanBirthplace;
	}

	public String getGasmanBirthplace() 
	{
		return gasmanBirthplace;
	}
	public void setGasmanHomearea(Integer gasmanHomearea) 
	{
		this.gasmanHomearea = gasmanHomearea;
	}

	public Integer getGasmanHomearea() 
	{
		return gasmanHomearea;
	}
	public void setGasmanPhone(String gasmanPhone) 
	{
		this.gasmanPhone = gasmanPhone;
	}

	public String getGasmanPhone() 
	{
		return gasmanPhone;
	}
	public void setGasId(Integer gasId) 
	{
		this.gasId = gasId;
	}

	public Integer getGasId() 
	{
		return gasId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gasmanId", getGasmanId())
            .append("gasmanName", getGasmanName())
            .append("gasmanGender", getGasmanGender())
            .append("gasmanCard", getGasmanCard())
            .append("gasmanBirthday", getGasmanBirthday())
            .append("gasmanEthnic", getGasmanEthnic())
            .append("gasmanBirtharea", getGasmanBirtharea())
            .append("gasmanBirthplace", getGasmanBirthplace())
            .append("gasmanHomearea", getGasmanHomearea())
            .append("gasmanPhone", getGasmanPhone())
            .append("gasId", getGasId())
            .toString();
    }
}
