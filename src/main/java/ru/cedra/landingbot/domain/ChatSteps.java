package ru.cedra.landingbot.domain;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by tignatchenko on 23/04/17.
 */
public class ChatSteps {
    public static Map<Integer, String> states = new HashMap<>();



    public static final int COUNT_STEP = 1;
    public static final int NAME_STEP = 2;
    public static final int GOAL_STEP = 3;
    public static final int INCOME_STEP = 4;
    public static final int RENT_STEP = 5;
    public static final int SALE_CONVERSION_STEP = 6;
    public static final int AVG_CHECK_STEP = 7;
    public static final int SITE_CONVERSION_STEP = 8;
    public static final int CLICK_PRICE_STEP = 9;
    public static final int REPORT_TIME_STEP = 10;
    public static final int CAMPAIGNS_IDS = 11;
    public static final int METRIC_COMPLETE = 12;
    public static final int TOKEN_STEP = 13;
    public static final int DEALS_EDIT = 14;

    public static List<Integer> paramStates = Lists.newArrayList(NAME_STEP,
                                                                 GOAL_STEP,
                                                                 INCOME_STEP,
                                                                 RENT_STEP,
                                                                 SALE_CONVERSION_STEP,
                                                                 AVG_CHECK_STEP,
                                                                 SITE_CONVERSION_STEP,
                                                                 CLICK_PRICE_STEP,
                                                                 CAMPAIGNS_IDS);

    static {
        states.put(COUNT_STEP, "Выберете счетчик");
    }
}
