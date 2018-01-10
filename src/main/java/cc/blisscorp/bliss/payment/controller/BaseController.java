/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.controller;

import cc.blisscorp.bliss.payment.utils.Constants;
import com.nct.game.framework.web.view.freemarker.FreeMarker;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anhlnt
 */
public abstract class BaseController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    abstract void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    void showLoginPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data, String msg) throws ServletException, IOException {
        data.put(Constants.PASSING_MESSAGE_FROM_SERVER, msg);
        new FreeMarker(Constants.PAGE_GEN_CODE, data).render(request, response);

    }

}
