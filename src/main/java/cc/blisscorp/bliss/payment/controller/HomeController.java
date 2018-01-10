/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.controller;

import cc.blisscorp.bliss.payment.utils.Constants;
import cc.blisscorp.bliss.payment.utils.PassingDataUtil;
import cc.blisscorp.bliss.payment.utils.SlackUtils;
import com.nct.game.framework.web.view.freemarker.FreeMarker;
import ga.log4j.GA;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anhlnt
 */
public class HomeController extends BaseController {

    private static final long serialVersionUID = 1L;

    @Override
    void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> data = new HashMap<>();
        data.putAll(PassingDataUtil.generalPassing());
        String user = (String) req.getSession().getAttribute(Constants.SESSION_USER);
        String avatar = (String) req.getSession().getAttribute(Constants.SESSION_AVATAR);
        String userId = (String) req.getSession().getAttribute(Constants.SESSION_USERID);
        String sign = (String) req.getSession().getAttribute(Constants.SESSION_SIGN);

        if (user != null) {
            data.put(Constants.SESSION_USER, user);
            data.put(Constants.SESSION_AVATAR, avatar);
            data.put(Constants.SESSION_USERID, userId);
            data.put(Constants.SESSION_SIGN, sign);
        }
        try {
            new FreeMarker(Constants.PAGE_HOME, data).render(req, resp);
        } catch (Exception ex) {
            GA.app.error(HomeController.class.getName() + " - " + ex.getMessage(), ex);
            SlackUtils.sendMessage("HomeController failed. " + ex.toString());
        }

    }

}
