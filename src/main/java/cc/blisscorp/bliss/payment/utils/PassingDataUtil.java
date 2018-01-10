package cc.blisscorp.bliss.payment.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dientt
 */
public class PassingDataUtil {

    private static Map<String, Object> mapData = new HashMap<>();

    public static Map<String, Object> generalPassing() {
        if (mapData.isEmpty()) {
            Map<String, Object> passingData = new HashMap<>();
            passingData.put(Constants.PASSING_ROOT_URL, Constants.ROOT_URL);
            passingData.put(Constants.PASSING_EVENT_URL, Constants.EVENT_URL);
            passingData.put(Constants.PASSING_FACEBOOK_ID, Constants.FACEBOOK_ID);
            passingData.put(Constants.PASSING_GOOGLE_ID, Constants.GOOGLE_ID);
            return passingData;
        } else {
            return mapData;
        }
    }
}
