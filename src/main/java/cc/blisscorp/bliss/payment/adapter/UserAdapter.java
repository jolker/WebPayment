/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.adapter;

import cc.blisscorp.bliss.payment.model.User;
import com.google.gson.JsonObject;

/**
 *
 * @author tiennv
 */
public class UserAdapter {

    public User getUser(JsonObject joUser) {

        User user = new User();

        user.setUserId(joUser.getAsJsonObject("data").get("userId").getAsString());
        if (!joUser.getAsJsonObject("data").get("displayName").isJsonNull()) {
            user.setUserName(joUser.getAsJsonObject("data").get("displayName").getAsString());
        }
        if (!joUser.getAsJsonObject("data").get("avatar").isJsonNull()) {
            user.setAvatar(joUser.getAsJsonObject("data").get("avatar").getAsString());
        }
//        user.setDisplayName(joUser.getAsJsonObject("data").get("displayName").getAsString());

        user.setGold(joUser.getAsJsonObject("data").get("gold").getAsString());
        user.setUserGroup(joUser.getAsJsonObject("data").get("userGroup").getAsString());
        user.setRegisterDate(joUser.getAsJsonObject("data").get("registerDate").getAsString());
        if (!joUser.getAsJsonObject("data").get("utm_source").isJsonNull()) {
            user.setUtmSource(joUser.getAsJsonObject("data").get("utm_source").getAsString());
        }
        if (!joUser.getAsJsonObject("data").get("campaign").isJsonNull()) {
            user.setCampaign(joUser.getAsJsonObject("data").get("campaign").getAsString());
        }
        return user;

    }
}
