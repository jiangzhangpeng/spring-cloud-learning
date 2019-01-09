package cn.com.picc.swxt.mail.bean;

public class DzfpylBean {
	/**
	 * 税号
	 */
	private String kpdwdm;
	/**
	 * 纳税人名称
	 */
	private String kpdwmc;
	/**
	 * 核心板编号
	 */
	private String jqbh;
	/**
	 * 总数（除去整段用完的）
	 */
	private int total;
	/**
	 * 剩余量
	 */
	private int surplus;
	/**
	 * 使用率
	 */
	private double userate;
	/**
	 * 公司名称
	 */
	private String cpname;

	/**
	 * @return the kpdwdm
	 */
	public String getKpdwdm() {
		return kpdwdm;
	}

	/**
	 * @param kpdwdm the kpdwdm to set
	 */
	public void setKpdwdm(String kpdwdm) {
		this.kpdwdm = kpdwdm;
	}

	/**
	 * @return the kpdwmc
	 */
	public String getKpdwmc() {
		return kpdwmc;
	}

	/**
	 * @param kpdwmc the kpdwmc to set
	 */
	public void setKpdwmc(String kpdwmc) {
		this.kpdwmc = kpdwmc;
	}

	/**
	 * @return the jqbh
	 */
	public String getJqbh() {
		return jqbh;
	}

	/**
	 * @param jqbh the jqbh to set
	 */
	public void setJqbh(String jqbh) {
		this.jqbh = jqbh;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the surplus
	 */
	public int getSurplus() {
		return surplus;
	}

	/**
	 * @param surplus the surplus to set
	 */
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}

	/**
	 * @return the userate
	 */
	public double getUserate() {
		return userate;
	}

	/**
	 * @param userate the userate to set
	 */
	public void setUserate(double userate) {
		this.userate = userate;
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

}
