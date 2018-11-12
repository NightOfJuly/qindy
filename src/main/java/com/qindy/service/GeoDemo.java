package com.qindy.service;

import ch.hsr.geohash.GeoHash;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/10/16
 */
public class GeoDemo {

    public static void main(String[] args) {
        //叶青大厦 116.475341,40.018169
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            GeoHash geoHash = GeoHash.withCharacterPrecision(40.018169, 116.475341, 9);
            geoHash.toBase32();
        }
        System.out.println(System.currentTimeMillis()-time);
    }
}
