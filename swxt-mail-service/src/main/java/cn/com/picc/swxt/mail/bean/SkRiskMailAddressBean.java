package cn.com.picc.swxt.mail.bean;

public class SkRiskMailAddressBean {
	/**
	 * 公司代码
	 */
	private String orgname;

	/**
	 * 邮箱地址，多个以";"分隔
	 */
	private String mailaddress;

	/**
	 * @return the orgname
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * @param orgname the orgname to set
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * @return the mailaddress
	 */
	public String getMailaddress() {
		return mailaddress;
	}

	/**
	 * @param mailaddress the mailaddress to set
	 */
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

}
