package com.qindy.service;

import com.google.common.geometry.S2Cell;
import com.google.common.geometry.S2CellId;
import com.google.common.geometry.S2LatLng;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/10/16
 */
public class S2Demo {
    public static void main(String[] args) {
        //叶青大厦 116.475341,40.018169

        S2CellId cellId = S2CellId.fromLatLng(S2LatLng.fromDegrees(40.018169,116.475341));
        System.out.println(cellId.id());
        S2Cell cell = new S2Cell(S2LatLng.fromDegrees(40.018169,116.475341));
        System.out.println(cell);
        S2LatLng s2LatLng = S2LatLng.fromDegrees(40.018169,116.475341);
        System.out.println(s2LatLng);

    }
}
