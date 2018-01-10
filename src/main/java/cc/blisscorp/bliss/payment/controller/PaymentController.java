/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.controller;

import cc.blisscorp.bliss.payment.adapter.SMSInfoAdapter;
import cc.blisscorp.bliss.payment.services.PaymentService;
import cc.blisscorp.bliss.payment.utils.Constants;
import cc.blisscorp.bliss.payment.utils.PassingDataUtil;
import cc.blisscorp.bliss.payment.utils.SlackUtils;
import com.bliss.framework.util.ConvertUtils;
import com.bliss.framework.util.DateTimeUtils;
import com.bliss.framework.util.JSONUtil;
import com.bliss.service.paymentv2.ent.card.CardInfoEnt;
import com.bliss.service.paymentv2.ent.card.CardPurchaseResultInfo;
import com.bliss.service.paymentv2.thrift.EProductType;
import com.bliss.service.paymentv2.thrift.TInvoiceValue;
import com.bliss.service.paymentv2.thrift.TProductValue;
import com.bliss.service.paymentv2.thrift.client.TPaymentV2ThriftClient;
import com.bliss.service.thrift.EUserGroup;
import com.bliss.service.thrift.OpAuth;
import com.bliss.service.thrift.TUserMiniProfile;
import com.google.gson.JsonObject;
import com.nct.game.framework.web.view.freemarker.FreeMarker;
import ga.log4j.GA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author anhlnt
 */
public class PaymentController extends BaseController {

    private static final long serialVersionUID = 1L;

    private static final String PASSING_RESULT = "result";

    private TPaymentV2ThriftClient paymentv2Service = TPaymentV2ThriftClient.getInstance("thrift_paymentv2_client");

    @Override
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String, Object> data = new HashMap<>();
            data.putAll(PassingDataUtil.generalPassing());

            String user = (String) request.getSession().getAttribute(Constants.SESSION_USER);
            if (user == null) {
                super.showLoginPage(request, response, data, Constants.LOGIN_REQUIRED);
                return;
            }
            data.put(Constants.SESSION_USER, user);
            data.put(Constants.SESSION_AVATAR, (String) request.getSession().getAttribute(Constants.SESSION_AVATAR));
            data.put(Constants.SESSION_USERID, (String) request.getSession().getAttribute(Constants.SESSION_USERID));
            data.put(Constants.SESSION_SIGN, (String) request.getSession().getAttribute(Constants.SESSION_SIGN));

            String action = request.getParameter(Constants.ACTION);
            switch (StringUtils.isBlank(action) ? Constants.DEFAULT_VALUE : action) {
                case Constants.DEFAULT_VALUE:
                    initPage(data, request, response);
                    break;
                case Constants.CASE_CARD:
                    cardPage(data, request, response);
                    break;
                case Constants.CASE_SMS:
                    smsPage(data, request, response);
                    break;
                case Constants.CASE_PAY_BY_CARD:
                    payByCard(request, response);
                    break;
            }

        } catch (Exception ex) {
            GA.app.error(PaymentController.class.getName() + " - " + ex.getMessage(), ex);
            SlackUtils.sendMessage("PaymentController failed. " + ex.toString());
        }

    }

    private void initPage(Map<String, Object> data, HttpServletRequest request, HttpServletResponse response) {
        try {
//            JsonObject joInfo = PaymentService.getInfoPayment();
//
//            if (joInfo.get("status").getAsString().equals("ok")) {
//                CardInfoAdapter infoCard = new CardInfoAdapter();
//                data.put("info_card", infoCard.infoCardPayment(joInfo));
//            } else {
//                data.put("error", "information error");
//            }

            TUserMiniProfile user = new TUserMiniProfile();
            user.setUserId(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_USERID)));
            user.setUserName(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_USER)));
            user.setAppPlatform("WEB");
            user.setNCoin(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_GOLD)));
            user.setUserGroup(EUserGroup.valueOf(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_USER_GROUP))));
            user.setRegisterDate(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_REGISTER_DATE)));
            user.setUtm_source(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_SOURCE)));
            user.setCampaign(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_CAMPAIGN)));

            List<TProductValue> tProductValues = paymentv2Service.listProductByUserWebPayment(user);

            if (tProductValues != null && !tProductValues.isEmpty()) {
                data.put("info_card", tProductValues);
            } else {
                data.put("error", "information error");
            }

            new FreeMarker(Constants.PAGE_PAYMENT, data).render(request, response);
        } catch (Exception ex) {
            GA.app.error(PaymentController.class.getName() + " - " + ex.getMessage(), ex);
            SlackUtils.sendMessage("PaymentController failed. Ex: " + ex.getMessage());
        }

    }

    private void cardPage(Map<String, Object> data, HttpServletRequest request, HttpServletResponse response) {

        try {
//            JsonObject joInfo = PaymentService.getInfoPayment();
//
//            if (joInfo.get("status").getAsString().equals("ok")) {
//                CardInfoAdapter infoCard = new CardInfoAdapter();
//
//                data.put("info_card", infoCard.infoCardPayment(joInfo));
//            } else {
//                data.put("error", "information error");
//            }
            TUserMiniProfile user = new TUserMiniProfile();
            user.setUserId(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_USERID)));
            user.setUserName(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_USER)));
            user.setAppPlatform("WEB");
            user.setNCoin(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_GOLD)));
            user.setUserGroup(EUserGroup.valueOf(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_USER_GROUP))));
            user.setRegisterDate(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_REGISTER_DATE)));
            user.setUtm_source(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_SOURCE)));
            user.setCampaign(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_CAMPAIGN)));

            List<TProductValue> tProductValues = paymentv2Service.listProductByUserWebPayment(user);

            if (tProductValues != null && !tProductValues.isEmpty()) {
                data.put("info_card", tProductValues);
            } else {
                data.put("error", "information error");
            }

            new FreeMarker(Constants.PAGE_PAY_CARD, data).render(request, response);
        } catch (Exception ex) {
            GA.app.error(PaymentController.class.getName() + " - " + ex.getMessage(), ex);
            SlackUtils.sendMessage("PaymentController failed. " + ex.toString());
        }

    }

    private void smsPage(Map<String, Object> data, HttpServletRequest request, HttpServletResponse response) {

        try {
            JsonObject joInfo = PaymentService.getInfoPayment();

            if (joInfo.get("status").getAsString().equals("ok")) {
                SMSInfoAdapter infoSMS = new SMSInfoAdapter();

                data.put("sms_vt", infoSMS.infoSMSPayment(joInfo, "SMSVT", 0));
                data.put("sms_mb", infoSMS.infoSMSPayment(joInfo, "SMSMOBI", 1));
                data.put("sms_vn", infoSMS.infoSMSPayment(joInfo, "SMSVNA", 2));

            } else {
                data.put("error", "information error");
            }

            new FreeMarker(Constants.PAGE_PAY_SMS, data).render(request, response);
        } catch (Exception ex) {
            GA.app.error(PaymentController.class.getName() + " - " + ex.getMessage(), ex);
            SlackUtils.sendMessage("PaymentController failed. " + ex.toString());
        }

    }

    private void payByCard(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        resp.setContentType(Constants.CONTENT_TYPE_JSON);
        try (PrintWriter out = resp.getWriter()) {
            JsonObject obj = new JsonObject();
            try {
                String telco = request.getParameter("telco");
                String cardCode = request.getParameter("card_code");
                String cardSerial = request.getParameter("card_serial");
                String userIp = request.getParameter("user_ip");

                CardInfoEnt data = new CardInfoEnt();
                data.code = cardCode;
                data.serial = cardSerial;
                data.telco = telco;
                String dataJson = JSONUtil.Serialize(data);

//                JsonObject result = PaymentService.payByCard(telco, cardCode, cardSerial, userId);
                OpAuth auth = new OpAuth();
                TInvoiceValue invoice = new TInvoiceValue();

                invoice.setUserId(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_USERID)));
                invoice.setUserName(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_USER)));
                invoice.setAppPlatform("WEB");
                invoice.setProductType(EProductType.CARD);
                invoice.setSourceName(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_SOURCE)));
                invoice.setMarketingCampaign(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_CAMPAIGN)));
                invoice.setNCoinBefore(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_GOLD)));
                invoice.setUserGroup(EUserGroup.valueOf(ConvertUtils.toString(request.getSession().getAttribute(Constants.SESSION_USER_GROUP))));
                invoice.setUserRetention(
                        DateTimeUtils.subtractDate(
                                DateTimeUtils.getDateTime(
                                        DateTimeUtils.getMilisecondsNow()), 
                                DateTimeUtils.getDateTime(ConvertUtils.toLong(request.getSession().getAttribute(Constants.SESSION_REGISTER_DATE)))));
                invoice.setUserIp(userIp);
                invoice.setData(dataJson);

                String obResult = paymentv2Service.processPaymentCard(auth, invoice);
                CardPurchaseResultInfo result = JSONUtil.DeSerialize(obResult, CardPurchaseResultInfo.class);

                obj.addProperty(PASSING_RESULT, false);
                if (result.status) {
                    obj.addProperty(PASSING_RESULT, true);
                    obj.addProperty("newNcoin", result.nCoinNew);
                }

                obj.addProperty("msg", result.msg);

            } catch (Exception ex) {
                obj.addProperty(PASSING_RESULT, ex.getMessage());
                GA.app.error(PaymentController.class.getName() + " - " + ex.getMessage(), ex);
                SlackUtils.sendMessage("PaymentController failed. " + ex.toString());
            } finally {
                if (out != null) {
                    out.print(obj);
                    out.flush();
                }
            }
        }
    }
}
