package cc.blisscorp.bliss.payment.utils;

import com.bliss.framework.common.Config;
import com.bliss.framework.util.ConvertUtils;

/**
 *
 * @author anhlnt
 */
public class Constants {

    public static final String BLISS_SERVICE_DOMAIN = ConvertUtils.toString(Config.getParam("bliss_service", "domain"), "https://api.nivi.vn");
    public static final String BLISS_SERVICE_DOMAIN_PAYMENT = ConvertUtils.toString(Config.getParam("payment_service", "domain"));
    public static final String BLISS_SERVICE_DOMAIN_PAYMENT_INFO = ConvertUtils.toString(Config.getParam("payment_info", "domain"));

    public static final String PAGE_SIZE = ConvertUtils.toString(Config.getParam("bliss_service", "page_size"));
    public static final String ADMIN = ConvertUtils.toString(Config.getParam("bliss_service", "admin"));
    public static final String PASSWORD = ConvertUtils.toString(Config.getParam("bliss_service", "password"));
    public static final String SLACK_URL = Config.getParam("web", "slack_url");
    public static final String ROOT_URL = ConvertUtils.toString(Config.getParam("jetty", "root_url"), "http://console.nivi.vn/");
    public static final String EVENT_URL = ConvertUtils.toString(Config.getParam("jetty", "event_url"));
    public static final String FACEBOOK_ID = ConvertUtils.toString(Config.getParam("jetty", "facebook_id"));
    public static final String GOOGLE_ID = ConvertUtils.toString(Config.getParam("jetty", "google_id"));
    public static final String RESOURCE_PATH = Config.getParam("jetty", "resource_path");

    public static final String CONTEXT_PATH = ConvertUtils.toString(Config.getParam("jetty", "context_path"), "");
    public static final String CURRENT_DIR = new java.io.File(".").getAbsolutePath() + "/";

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String TIME_FORMAT = "hh:mm:ss";
    public static final String DATETIME_FORMAT_DB = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT_FOLDER = "yyyyMMdd";

    public static final String DATETIME_FORMAT_REPORT = "d/M";

    public static final String DATETIME_FORMAT_COPYRIGHT = "yyyy-MM-dd HH:mm";

    public static final String DATETIME_FORMAT_GAME = "yyyy-MM-dd hh:mm:ss";

    public static final String HOST = Config.getParam("web", "host");
    public static final int PORT = ConvertUtils.toInt(Config.getParam("web", "port"));
    public static final int MAX_THREADS = ConvertUtils.toInt(Config.getParam("web", "max_threads"));
    public static final int MIN_THREADS = ConvertUtils.toInt(Config.getParam("web", "min_threads"), 10);

    public static final String PAGE_HOME = "pages/homePage";
    public static final String PAGE_EVENT = "pages/eventPage";
    public static final String PAGE_PAYMENT = "pages/paymentPage";
    public static final String PAGE_PAY_SMS = "pages/paySmsPage";
    public static final String PAGE_LOGIN = "pages/loginPage";
    public static final String PAGE_PAY_CARD = "pages/payCardPage";
    public static final String PAGE_GEN_CODE = "pages/genCodePage";
    public static final String CONTENT_TYPE_JSON = "application/json; charset=UTF-8";
    public static final String CONTENT_TYPE_TEXT = "text/html; charset=UTF-8";

    public static final String PASSING_ROOT_URL = "root_url";
    public static final String PASSING_EVENT_URL = "event_url";
    public static final String PASSING_FACEBOOK_ID= "facebook_id";
    public static final String PASSING_GOOGLE_ID = "google_id";

    public static final String PATH_TEMPLATE = Config.getParam("web_view_freemarker", "template_path");
    public static final String URL_LOGIN = "/login";

    public static final String ACTION = "action";

    public static final String ACTION_ADD = "add";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_DUPLICATE = "duplicate";
    public static final String ACTION_DELETE = "delete";
    public static final String ACTION_VIEW = "view";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_CHECK_QRCODE = "checkQrCode";
    public static final String ACTION_LOGIN_GOOGLE = "glogin";
    public static final String ACTION_LOGIN_FACEBOOK = "fblogin";
    public static final String TAB = "tab";
    public static final String DEFAULT_VALUE = "";
    public static final String CASE_CARD = "card";
    public static final String CASE_SMS = "sms";
    public static final String CASE_PAY_BY_CARD = "pay_by_card";

    public static final String PASSING_MESSAGE_FROM_SERVER = "messageFromServer";

    public static final int SHOW = 1, NOT_SHOW = 0;
    public static final String SESSION_USER = "user";
    public static final String SESSION_AVATAR = "avatar";
    public static final String SESSION_GOLD = "gold";
    public static final String SESSION_USER_GROUP = "userGroup";
    public static final String SESSION_REGISTER_DATE = "registerDate";
    public static final String SESSION_SOURCE = "utmSource";
    public static final String SESSION_CAMPAIGN = "campaign";
    public static final String SESSION_USERID = "user_id";
    public static final String SESSION_SIGN = "sign";
    public static final String SESSION_GAME = "game";
    public static final String LOGIN_REQUIRED = "You must login first so you can use this function";
}
