package cn.com.picc.swxt.mail.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.picc.swxt.mail.bean.Mail;
import cn.com.picc.swxt.mail.bean.SkRiskBean;
import cn.com.picc.swxt.mail.bean.SkRiskMailAddressBean;
import cn.com.picc.swxt.mail.bean.SysCommonPropertyBean;
import cn.com.picc.swxt.mail.dao.SkRiskDao;
import cn.com.picc.swxt.mail.dao.SkRiskMailAddressDao;
import cn.com.picc.swxt.mail.dao.SysCommonPropertyDao;
import cn.com.picc.swxt.mail.util.Constants;

@Service
public class SkriskService {
	private static final Logger logger = LoggerFactory.getLogger(SkriskService.class);
	private static final String from = "swxt";

	@Autowired
	private SysCommonPropertyDao sysCommonPropertyDao;
	@Autowired
	private SkRiskDao skRiskDao;
	@Autowired
	private SkRiskMailAddressDao skRiskMailAddressDao;
	@Autowired
	private MailService mailService;

	/**
	 * 提供税控风险定时任务调用接口，发送内容简单邮件
	 */
	public void sendSimpleMail() {
		logger.debug("come into SkriskService.sendSimpleMail");
		logger.debug("start to check the switch ");
		List<SysCommonPropertyBean> proList = sysCommonPropertyDao.getPropertyByProName(Constants.SwitchType.SKRISK);
		if (proList != null && proList.size() >= 1) {
			if (Constants.SwitchStatus.CLOSED.equals(proList.get(0).getPropertyValue())) {
				logger.debug("switch closed,return to caller ");
				return;
			}
		}
		logger.debug("start to find all skrisk info ");
		List<SkRiskBean> list = skRiskDao.findAll();
		logger.debug("start to find all mailaddress ");
		Map<String, String> map = this.loadMailAddress();
		Mail mail;
		logger.debug("send mail iterately ");
		for (SkRiskBean bean : list) {
			if (map.containsKey(bean.getCpname())) {
				logger.debug("send mail:" + bean.getCpname() + bean.getRiskKind());
				mail = new Mail();
				mail.setFrom(from);
				mail.setTo(map.get(bean.getCpname()));
				mail.setSubject("税控风险通知, 风险代码: " + bean.getRiskKind());
				mail.setContent(bean.getRiskInfo());
				mailService.sendSimpleMail(mail);
				try {
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				logger.info(bean.getCpname() + " 未配置邮箱");
			}
		}
		logger.debug("update switch maw-email-switch to 1 ");
		sysCommonPropertyDao.updateSwitch(Constants.SwitchType.SKRISK, Constants.SwitchStatus.CLOSED);
		logger.debug("leave SkriskService.sendSimpleMail");

	}

	/**
	 * 每次定时任务发送邮件时，提前加载所有分公司的邮件地址，减少访问数据库
	 * 
	 * @return Map<String, String>
	 */
	private Map<String, String> loadMailAddress() {
		logger.debug("come into SkriskService.loadMailAddress");
		Map<String, String> map = new HashMap<String, String>();
		List<SkRiskMailAddressBean> list = skRiskMailAddressDao.findAll();
		for (SkRiskMailAddressBean bean : list) {
			map.put(bean.getOrgname(), bean.getMailaddress());
		}
		logger.debug("load " + map.size() + " mail addresses");
		logger.debug("leave SkriskService.loadMailAddress");
		return map;
	}

}
