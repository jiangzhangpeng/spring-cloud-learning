package cn.com.picc.swxt.mail.util;

public class Constants {
	// 邮件提醒定时任务开关
	public class SwitchStatus {
		public static final String OPEN = "0";// 未处理 开关打开
		public static final String CLOSED = "1";// 未处理 开关关闭
	}

	// 任务类型，区分电子发票数量定时任务和税控风险定时任务
	public class SwitchType {
		public static final String DZFPYL = "maw-email-fpyl-switch";
		public static final String SKRISK = "maw-email-switch";
	}

}
