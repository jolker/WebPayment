/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.controller;

import cc.blisscorp.bliss.payment.adapter.UserAdapter;
import cc.blisscorp.bliss.payment.model.User;
import cc.blisscorp.bliss.payment.services.PaymentService;
import cc.blisscorp.bliss.payment.utils.Constants;
import cc.blisscorp.bliss.payment.utils.PassingDataUtil;
import cc.blisscorp.bliss.payment.utils.SlackUtils;
import com.google.gson.JsonObject;
import com.nct.game.framework.web.view.freemarker.FreeMarker;
import ga.log4j.GA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author tiennv
 */
public class GenCodeController extends BaseController {

    private static final long serialVersionUID = 1L;

    private static final String ID = "id";
    private static final String GEN_CODE = "gencode";
    private static final String MESSAGE = "message";
    private static final String SECECT_KEY = "900150983cd24fb0d6963f7d28e17f72";
    private static final String PASSING_RESULT = "result";

    @Override
    void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Map<String, Object> data = new HashMap<>();
            data.putAll(PassingDataUtil.generalPassing());

            String action = req.getParameter(Constants.ACTION);
            switch (StringUtils.isBlank(action) ? Constants.DEFAULT_VALUE : action) {
                case Constants.DEFAULT_VALUE:
                    initPage(data, req, resp);
                    break;
                case Constants.ACTION_CHECK_QRCODE:
                    checkGenCode(data, req, resp);
                    break;
                case Constants.ACTION_LOGIN_GOOGLE:
                    loginGoogle(req, resp);
                    break;
                case Constants.ACTION_LOGIN_FACEBOOK:
                    loginFB(req, resp);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initPage(Map<String, Object> data, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new FreeMarker(Constants.PAGE_GEN_CODE, data).render(req, resp);
    }

    private void checkGenCode(Map<String, Object> data, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, Exception {

        String gencode = req.getParameter(GEN_CODE);
        try {
            JsonObject jsonGenCode = PaymentService.getDataUserByLoginQrCode(gencode);
            if (jsonGenCode.get("status").getAsBoolean()) {
                UserAdapter adapter = new UserAdapter();
                User gencodeUser = adapter.getUser(jsonGenCode);
                String sign = gencodeUser.getUserId() + "_" + SECECT_KEY;

                req.getSession().setAttribute(Constants.SESSION_USER, gencodeUser.getUserName());
                req.getSession().setAttribute(Constants.SESSION_AVATAR, gencodeUser.getAvatar());
                req.getSession().setAttribute(Constants.SESSION_USERID, gencodeUser.getUserId());
                req.getSession().setAttribute(Constants.SESSION_SIGN, DigestUtils.md5Hex(sign));
                req.getSession().setAttribute(Constants.SESSION_GOLD, gencodeUser.getGold());
                req.getSession().setAttribute(Constants.SESSION_USER_GROUP, gencodeUser.getUserGroup());
                req.getSession().setAttribute(Constants.SESSION_REGISTER_DATE, gencodeUser.getRegisterDate());
                req.getSession().setAttribute(Constants.SESSION_SOURCE, gencodeUser.getUtmSource());
                req.getSession().setAttribute(Constants.SESSION_CAMPAIGN, gencodeUser.getCampaign());
                req.getSession().setMaxInactiveInterval(3000 * 60);

                data.put(Constants.SESSION_USER, gencodeUser.getUserName());
                data.put(Constants.SESSION_AVATAR, gencodeUser.getAvatar());
                data.put(Constants.SESSION_USERID, gencodeUser.getUserId());
                data.put(Constants.SESSION_SIGN, DigestUtils.md5Hex(sign));

                resp.sendRedirect(Constants.ROOT_URL + "payment");
            } else {
                data.put(MESSAGE, "Bạn vui lòng thử mã khác");
                new FreeMarker(Constants.PAGE_GEN_CODE, data).render(req, resp);
            }

        } catch (Exception e) {
            GA.app.error(GenCodeController.class.getName() + " - " + e.getMessage(), e);
            SlackUtils.sendMessage("GenCodeController failed. " + e.toString());
        }

    }

    private void loginGoogle(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception {

        resp.setContentType(Constants.CONTENT_TYPE_JSON);
        try (PrintWriter out = resp.getWriter()) {
            JsonObject obj = new JsonObject();
            String id = req.getParameter(ID);
            JsonObject jsonLogin = PaymentService.getDataUserByType("google", "openid", id);

            try {
                if (jsonLogin.get("status").getAsBoolean()) {
                    UserAdapter adapter = new UserAdapter();
                    User gencodeUser = adapter.getUser(jsonLogin);
                    String sign = gencodeUser.getUserId() + "_" + SECECT_KEY;

                    if (gencodeUser.getUserName() == null) {
                        req.getSession().setAttribute(Constants.SESSION_USER, gencodeUser.getUserId());
                    } else {
                        req.getSession().setAttribute(Constants.SESSION_USER, gencodeUser.getUserName());
                    }

                    req.getSession().setAttribute(Constants.SESSION_AVATAR, gencodeUser.getAvatar());
                    req.getSession().setAttribute(Constants.SESSION_USERID, gencodeUser.getUserId());
                    req.getSession().setAttribute(Constants.SESSION_SIGN, DigestUtils.md5Hex(sign));

                    req.getSession().setAttribute(Constants.SESSION_GOLD, gencodeUser.getGold());
                    req.getSession().setAttribute(Constants.SESSION_USER_GROUP, gencodeUser.getUserGroup());
                    req.getSession().setAttribute(Constants.SESSION_REGISTER_DATE, gencodeUser.getRegisterDate());
                    req.getSession().setAttribute(Constants.SESSION_SOURCE, gencodeUser.getUtmSource());
                    req.getSession().setAttribute(Constants.SESSION_CAMPAIGN, gencodeUser.getCampaign());
                    req.getSession().setMaxInactiveInterval(3000 * 60);

                    obj.addProperty(PASSING_RESULT, true);
                } else {
                    obj.addProperty(MESSAGE, jsonLogin.get("message").getAsString());
                }

            } catch (Exception ex) {
                GA.app.error(GenCodeController.class.getName() + " - " + ex.getMessage(), ex);
                SlackUtils.sendMessage("GenCodeController failed. Ex: " + ex.getMessage());
            } finally {
                if (out != null) {
                    out.print(obj);
                    out.flush();
                }
            }
        }

    }

    private void loginFB(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception {

        resp.setContentType(Constants.CONTENT_TYPE_JSON);
        try (PrintWriter out = resp.getWriter()) {
            JsonObject obj = new JsonObject();
            String id = req.getParameter(ID);
            JsonObject jsonLogin = PaymentService.getDataUserByType("facebook", "openid", id);

            try {
                if (jsonLogin.get("status").getAsBoolean()) {
                    UserAdapter adapter = new UserAdapter();
                    User gencodeUser = adapter.getUser(jsonLogin);
                    String sign = gencodeUser.getUserId() + "_" + SECECT_KEY;

                    if (gencodeUser.getUserName() == null) {
                        req.getSession().setAttribute(Constants.SESSION_USER, gencodeUser.getUserId());
                    } else {
                        req.getSession().setAttribute(Constants.SESSION_USER, gencodeUser.getUserName());
                    }

                    req.getSession().setAttribute(Constants.SESSION_AVATAR, gencodeUser.getAvatar());
                    req.getSession().setAttribute(Constants.SESSION_USERID, gencodeUser.getUserId());
                    req.getSession().setAttribute(Constants.SESSION_SIGN, DigestUtils.md5Hex(sign));
                    req.getSession().setAttribute(Constants.SESSION_GOLD, gencodeUser.getGold());
                    req.getSession().setAttribute(Constants.SESSION_USER_GROUP, gencodeUser.getUserGroup());
                    req.getSession().setAttribute(Constants.SESSION_REGISTER_DATE, gencodeUser.getRegisterDate());
                    req.getSession().setAttribute(Constants.SESSION_SOURCE, gencodeUser.getUtmSource());
                    req.getSession().setAttribute(Constants.SESSION_CAMPAIGN, gencodeUser.getCampaign());
                    req.getSession().setMaxInactiveInterval(3000 * 60);

                    obj.addProperty(PASSING_RESULT, true);
                } else {
                    obj.addProperty(MESSAGE, jsonLogin.get("message").getAsString());
                }

            } catch (Exception ex) {
                GA.app.error(GenCodeController.class.getName() + " - " + ex.getMessage(), ex);
                SlackUtils.sendMessage("GenCodeController failed. Ex: " + ex.getMessage());
            } finally {
                if (out != null) {
                    out.print(obj);
                    out.flush();
                }
            }
        }

    }
}
