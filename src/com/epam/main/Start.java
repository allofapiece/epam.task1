package com.epam.main;

import com.epam.entity.Gift;
import com.epam.entity.Sweet;
import com.epam.service.GiftService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class, where application starts.
 * Also, this class contains standard methods for
 * output information.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Start {
    final static Logger log = Logger.getLogger(Start.class);

    public static void main(String[] args) {
        log.debug("Application is running");

        GiftService giftService = new GiftService();
        float sugarMin = 40;
        float sugarMax = 50;
        List<Sweet> filteredSweets = new ArrayList<>();

        Gift gift = giftService.find(0);
        giftService.sort(gift, "sweetType");
        showGift(gift);

        log.info("Weight of gift: " + giftService.calculateGiftWeight(gift));

        log.info("\nSweet sugar filter with minimal "
                + sugarMin + " and maximum "
                + sugarMax + " values");

        filteredSweets.addAll(giftService.sugarFilter(gift, sugarMin, sugarMax));
        showSweets(filteredSweets);
    }

    /**
     * @param sweets
     */
    public static void showSweets(List<Sweet> sweets){
        for (Sweet sweet : sweets) {
            log.debug("Shown sweet with id = " + sweet.getId());
            log.info(sweet.toString());
        }
    }

    /**
     * @param gift
     */
    public static void showGift(Gift gift) {
        log.debug("Shown gift with id = " + gift.getId());
        log.info("Gift id: " + gift.getId());
        log.info("____________content_____________");

        showSweets(gift.getSweets());
    }
}
