/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.utils;

import ga.log4j.GA;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

import com.bliss.framework.common.Config;
import com.bliss.framework.util.ConvertUtils;
import com.bliss.framework.util.DateTimeUtils;

/**
 *
 * @author huynxt
 * @author tuyenpv
 */
public class SlackUtils {
	private static SlackApi slackAPI = null;
	private static boolean isLogging = true;
	private static String userName = "anhlnt";
	private static BlockingQueue<SlackMessage> msgQueue = null;

	static {
		slackAPI = new SlackApi(Config.getParam("slack_service", "webhook_url"));
		isLogging = ConvertUtils.toBoolean(Config.getParam("slack_service", "is_logging"));
		userName = Config.getParam("slack_service", "user_name");
		if (isLogging) {
			msgQueue = new LinkedBlockingQueue<>();
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (isLogging) {
						try {
							SlackMessage msg = msgQueue.take();
							if (msg != null)
								slackAPI.call(msg);

						} catch (Exception ex) {
							GA.app.error("send mess2slack failed. " + ex.getMessage(), ex);
						}
					}
				}
			}).start();			
		}
	}

	/**
	 * 
	 * @param message
	 * @throws Exception
	 */
	public static void sendMessage(String message) {
		try {
			if (!isLogging) 
				return;

			SlackMessage slackMsg = new SlackMessage(userName, String.format("%s : %s", DateTimeUtils.getDateTime(new Date()), message));
			msgQueue.add(slackMsg);			
		} catch (Exception e) {
			GA.app.error("send mess2slack failed. Msg: " + message +  " - " + e.getMessage(), e);
		}
	}

}
