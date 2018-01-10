/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.adapter;

import cc.blisscorp.bliss.payment.model.Info;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anhlnt
 */
public class CardInfoAdapter {

    public List<Info> infoCardPayment(JsonObject jo) {
        List<Info> myCardInfo = new ArrayList<>();
        JsonArray arr = jo.getAsJsonArray("data").get(1).getAsJsonObject()
                .getAsJsonArray("Card").get(0).getAsJsonObject().getAsJsonArray("Card Viettel");
        if (arr != null) {
            for (int i = 0; i < arr.size(); i++) {
                Info info = new Info();
                info.setPack(arr.get(i).getAsJsonObject().get("pack").getAsString());
                info.setNcoin(arr.get(i).getAsJsonObject().get("ncoin").getAsString());
                info.setPromotion(arr.get(i).getAsJsonObject().get("promotion").getAsString());

                myCardInfo.add(info);
            }
        }
        return myCardInfo;
    }
}
