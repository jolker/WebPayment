/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.blisscorp.bliss.payment.services;

import cc.blisscorp.bliss.payment.utils.Constants;
import cc.blisscorp.bliss.payment.utils.RSASign;
import com.google.gson.JsonObject;

/**
 *
 * @author tiennv
 */
public class PaymentService {

    private static final String API_CHECK_QR_CODE = Constants.BLISS_SERVICE_DOMAIN_PAYMENT + "/login_by_QRCode?";
    private static final String API_CHECK_LOGIN = Constants.BLISS_SERVICE_DOMAIN_PAYMENT + "/get_user_info?";
    private static final String API_PAYMENT = Constants.BLISS_SERVICE_DOMAIN_PAYMENT + "/payment_by_id?";
    private static final String API_INFO_PAYMENT = Constants.BLISS_SERVICE_DOMAIN_PAYMENT_INFO + "/get_payment_info?";

    public static JsonObject getDataUserByLoginQrCode(String qrCode) throws Exception {

        JsonObject params = new JsonObject();
        params.addProperty("qrCode", qrCode);

        String url = API_CHECK_QR_CODE + ServiceUtils.createParams(params);
        
        HttpRequestService result = new HttpRequestService();
        return result.get(url);

    }
    
    public static JsonObject getDataUserByType(String type, String typeId, String id) throws Exception {

        JsonObject params = new JsonObject();
        params.addProperty("login_type", type);
        params.addProperty(typeId, id);

        String url = API_CHECK_LOGIN + ServiceUtils.createParams(params);
        
        HttpRequestService result = new HttpRequestService();
        return result.get(url);

    }
    
    public static JsonObject getInfoPayment() throws Exception {

        JsonObject params = new JsonObject();
        params.addProperty("sign", "KiYUv8fGMSu%2BlQLfn7z%2Bbe45fXFYlU5JK2LuPUjSZj%2B3FZ72KWduQkdknpPU%2BTeoEMt%2B4I0p7YjT%0D%0A2P6z4KKCnUhoyd2I1Co8NgfMxMgadOaOEV6fw%2FDugJrvd2ujLISMCneiGi1FMhomtq73ngBeKHpk%0D%0AqiFzkZCuaxqAWsdwWOk%3D");

        String url = API_INFO_PAYMENT + ServiceUtils.createParams(params);
        
        HttpRequestService result = new HttpRequestService();
        return result.get(url);

    }
    
    public static JsonObject payByCard(String telco, String cardCode,
            String cardSerial, String userId) throws Exception {

        JsonObject params = new JsonObject();
        params.addProperty("telco", telco);
        params.addProperty("cardcode", cardCode);
        params.addProperty("cardserial", cardSerial);
        params.addProperty("userid", userId);
        params.addProperty("paymentType", "card");
        
        String signData = ("npl@info@pay@#99" + cardCode + cardSerial + userId);
        params.addProperty("sign", RSASign.base64Sign(signData));

        String url = API_PAYMENT + ServiceUtils.createParams(params);
        
        HttpRequestService result = new HttpRequestService();
        return result.get(url);

    }
}
