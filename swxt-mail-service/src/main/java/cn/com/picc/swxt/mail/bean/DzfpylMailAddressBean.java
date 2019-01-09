package cn.com.picc.swxt.mail.bean;

public class DzfpylMailAddressBean {
	/**
	 * 纳税人识别号
	 */
	private String nsrsbh;
	/**
	 * 纳税人名称
	 */
	private String nsrsmc;
	/**
	 * 发票类型
	 */
	private String fplxmc;
	/**
	 * 邮箱地址，多个以";"分隔
	 */
	private String mailaddress;

	/**
	 * @return the nsrsbh
	 */
	public String getNsrsbh() {
		return nsrsbh;
	}

	/**
	 * @param nsrsbh the nsrsbh to set
	 */
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	/**
	 * @return the nsrsmc
	 */
	public String getNsrsmc() {
		return nsrsmc;
	}

	/**
	 * @param nsrsmc the nsrsmc to set
	 */
	public void setNsrsmc(String nsrsmc) {
		this.nsrsmc = nsrsmc;
	}

	/**
	 * @return the fplxmc
	 */
	public String getFplxmc() {
		return fplxmc;
	}

	/**
	 * @param fplxmc the fplxmc to set
	 */
	public void setFplxmc(String fplxmc) {
		this.fplxmc = fplxmc;
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
