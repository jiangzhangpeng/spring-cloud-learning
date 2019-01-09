package cn.com.picc.swxt.mail.bean;

public class SkRiskBean {
	/**
	 * ID
	 */
	private String runid;
	/**
	 * 公司代码
	 */
	private String cpname;
	/**
	 * 风险类型
	 */
	private String riskKind;
	/**
	 * 风险提示信息
	 */
	private String riskInfo;

	/**
	 * @return the runid
	 */
	public String getRunid() {
		return runid;
	}

	/**
	 * @param runid the runid to set
	 */
	public void setRunid(String runid) {
		this.runid = runid;
	}

	/**
	 * @return the cpname
	 */
	public String getCpname() {
		return cpname;
	}

	/**
	 * @param cpname the cpname to set
	 */
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	/**
	 * @return the riskKind
	 */
	public String getRiskKind() {
		return riskKind;
	}

	/**
	 * @param riskKind the riskKind to set
	 */
	public void setRiskKind(String riskKind) {
		this.riskKind = riskKind;
	}

	/**
	 * @return the riskInfo
	 */
	public String getRiskInfo() {
		return riskInfo;
	}

	/**
	 * @param riskInfo the riskInfo to set
	 */
	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

}
