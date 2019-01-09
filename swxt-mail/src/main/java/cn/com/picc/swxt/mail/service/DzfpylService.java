package cn.com.picc.swxt.mail.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.picc.swxt.mail.bean.DzfpylBean;
import cn.com.picc.swxt.mail.bean.DzfpylMailAddressBean;
import cn.com.picc.swxt.mail.bean.Mail;
import cn.com.picc.swxt.mail.dao.DzfpylDao;
import cn.com.picc.swxt.mail.dao.DzfpylMailAddressDao;
import cn.com.picc.swxt.mail.dao.SysCommonPropertyDao;

@Service
public class DzfpylService {
	private static final Logger logger = LoggerFactory.getLogger(DzfpylService.class);
	private static final String from = "swxt";
	@Autowired
	private DzfpylDao dzfpylDao;
	@Autowired
	private DzfpylMailAddressDao dzfpylMailAddressDao;
	@Autowired
	private MailService mailService;
	@Autowired
	private SysCommonPropertyDao sysCommonPropertyDao;

	/**
	 * 提供电子发票余量定时任务调用接口，发送内容简单邮件
	 */
	public void sendSimpleMail() {
		logger.debug("come into DzfpylService.findAll");
		logger.debug("start to find all dzfpyl ");
		List<DzfpylBean> list = dzfpylDao.findAll();
		logger.debug("start to find all mailaddress ");
		Map<String, String> map = this.loadMailAddress();
		Mail mail;
		logger.debug("send mail iterately ");
		for (DzfpylBean bean : list) {
			if (map.containsKey(bean.getKpdwdm())) {
				logger.debug("send mail:" + bean.getKpdwdm() + bean.getKpdwmc());
				mail = new Mail();
				mail.setFrom(from);
				mail.setTo(map.get(bean.getKpdwdm()));
				mail.setSubject(bean.getKpdwmc() + "电子发票余量说明");
				mail.setContent(getMailContent(bean));
				mailService.sendSimpleMail(mail);
				try {
					Thread.sleep(1000 * 20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				logger.info(bean.getKpdwmc() + "  " + bean.getKpdwdm() + " 未配置邮箱");
			}
		}
		logger.debug("update switch maw-email-fpyl-switch to 1 ");
		sysCommonPropertyDao.updateSwitch("maw-email-fpyl-switch", "1");
		logger.debug("leave DzfpylService.findAll");
	}

	/**
	 * 生成邮件正文
	 * 
	 * @param DzfpylBean bean
	 * @return String
	 */
	private String getMailContent(DzfpylBean bean) {
		logger.debug("come into DzfpylService.getMailContent");
		StringBuilder sb = new StringBuilder();
		sb.append("税号：").append(bean.getKpdwdm()).append("</br>");
		sb.append("纳税人名称：").append(bean.getKpdwmc()).append("</br>");
		sb.append("核心版编号：").append(bean.getJqbh()).append("</br>");
		sb.append("剩余数量：").append(bean.getSurplus()).append("</br>");
		sb.append("发票使用率：").append(bean.getUserate() * 100).append("%").append("</br>");
		logger.debug("content:" + sb.toString());
		logger.debug("leave DzfpylService.getMailContent");
		return sb.toString();
	}

	/**
	 * 每次定时任务发送邮件时，提前加载所有分公司的邮件地址，减少访问数据库
	 * 
	 * @return Map<String, String>
	 */
	private Map<String, String> loadMailAddress() {
		logger.debug("come into DzfpylService.loadMailAddress");
		Map<String, String> map = new HashMap<String, String>();
		List<DzfpylMailAddressBean> list = dzfpylMailAddressDao.findAll();
		for (DzfpylMailAddressBean bean : list) {
			map.put(bean.getNsrsbh(), bean.getMailaddress());
		}
		logger.debug("load " + map.size() + " mail addresses");
		logger.debug("leave DzfpylService.loadMailAddress");
		return map;
	}

}
