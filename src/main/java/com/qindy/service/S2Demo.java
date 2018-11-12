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
        Long time = System.currentTimeMillis();
        for(int i=0 ;i<10000000;i++){
            S2CellId cellId = S2CellId.fromLatLng(S2LatLng.fromDegrees(40.0,116.5));
            cellId.parent(15);
            //System.out.println(cellId);
        }
        System.out.println(System.currentTimeMillis()-time);
    }
}
