/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.blisscorp.bliss.payment.utils.Constants;
import cc.blisscorp.bliss.payment.utils.PassingDataUtil;

import com.nct.game.framework.web.view.freemarker.FreeMarker;

/**
 *
 * @author tiennv
 */
public class LogoutController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute(Constants.SESSION_USER, null);
        request.getSession().setAttribute(Constants.SESSION_AVATAR, null);
        request.getSession().setAttribute(Constants.SESSION_USERID, null);
        request.getSession().setAttribute(Constants.SESSION_SIGN, null);
        request.getSession().invalidate();
        
        Map<String, Object> data = new HashMap<>();
        data.putAll(PassingDataUtil.generalPassing());
        
        new FreeMarker(Constants.PAGE_GEN_CODE, data).render(request, response);
    }
}
