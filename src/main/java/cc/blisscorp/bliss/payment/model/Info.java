/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.model;

/**
 *
 * @author anhlnt
 */
public class Info {
    private String pack;
    private String ncoin;
    private String promotion;
    private String smsMessage;

    public Info() {
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getNcoin() {
        return ncoin;
    }

    public void setNcoin(String ncoin) {
        this.ncoin = ncoin;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }
    
    
}
