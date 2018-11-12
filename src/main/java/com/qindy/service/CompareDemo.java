package com.qindy.service;

import ch.hsr.geohash.GeoHash;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;
import com.uber.h3core.H3Core;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/10/18
 */
public class CompareDemo {

    private static double min1 = 106.836525;
    private static double max1 = 117.948492;
    private static double min2 = 23.270296;
    private static double max2 = 39.750707;

    public static void LocationToH3(Double lng, Double lat, int level) throws IOException {
        H3Core core = H3Core.newInstance();
        Long index = core.geoToH3(lat, lng, level);
    }

    public static void LocationToGeoHash(Double lng, Double lat, int level) {
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            GeoHash geoHash = GeoHash.withCharacterPrecision(40.018169, 116.475341, level);
            geoHash.toBase32();
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void LocationToS2(Double lng, Double lat, int level) {
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            S2CellId cellId = S2CellId.fromLatLng(S2LatLng.fromDegrees(40.0, 116.5));
            cellId.parent(level);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
    /**
    H3 test 叶青大厦 116.475341,40.018169

    public static void main(String[] args) {
        H3Core core = null;
        try {
            core = H3Core.newInstance();

            Random random = new Random();
            Long time = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                BigDecimal db = new BigDecimal(Math.random() * (max1 - min1) + min1);
                //小数后6位
                double lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
                db = new BigDecimal(Math.random() * (max2 - min2) + min2);
                double lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
                Long index = core.geoToH3(lat, lon, 7);
            }
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

    /**
     * S2 test 叶青大厦 116.475341,40.018169

    public static void main(String[] args) {
        Random random = new Random();
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            BigDecimal db = new BigDecimal(Math.random() * (max1 - min1) + min1);
            double lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
            db = new BigDecimal(Math.random() * (max2 - min2) + min2);
            double lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
            S2CellId cellId = S2CellId.fromLatLng(S2LatLng.fromDegrees(lat, lon));
//            S2CellId cellId = S2CellId.fromLatLng(S2LatLng.fromDegrees(40.018169, 116.475341));
            cellId.parent(13);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
     */

    /**
     * GeoHash test 叶青大厦 116.475341,40.018169

    public static void main(String[] args) {
        Random random = new Random();
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            BigDecimal db = new BigDecimal(Math.random() * (max1 - min1) + min1);
            double lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
            db = new BigDecimal(Math.random() * (max2 - min2) + min2);
            double lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//            GeoHash geoHash = GeoHash.withCharacterPrecision(40.018169, 116.475341, level);
            GeoHash geoHash = GeoHash.withCharacterPrecision(lat, lon,6);
            geoHash.toBase32();
        }
        System.out.println(System.currentTimeMillis() - time);
    }
     */

    public static void main(String[] args) {
        Random random = new Random();
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            BigDecimal db = new BigDecimal(Math.random() * (max1 - min1) + min1);
            double lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
            db = new BigDecimal(Math.random() * (max2 - min2) + min2);
            double lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}
