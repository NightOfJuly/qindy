package com.qindy.service;

import com.google.common.geometry.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/10/16
 */
public class S2Demo {
    public static void main(String[] args) {
        test();
    }

    public static S2Point toCell(double lng, double lat){
        return S2LatLng.fromDegrees(lat, lng).toPoint();
    }

    public static void test(){

       // 116.473913,40.019896 116.479627,40.017244 116.479734,40.01205 116.469673,40.011939 116.469601,40.01415 116.479698,40.014426
        S2Point cellId1 = toCell(116.474082,40.01726);
        S2Point cellId2 = toCell(116.474046,40.014386);
        S2Point cellId3 = toCell(116.469375,40.014124);
        S2Point cellId4 = toCell(116.469536,40.01172);
        S2Point cellId5 = toCell(116.479849,40.012093);
        S2Point cellId6 = toCell(116.479714,40.017267);
        ArrayList<S2Point> cellList = new ArrayList<>();
        cellList.add(cellId1);
        cellList.add(cellId2);
        cellList.add(cellId3);
        cellList.add(cellId4);
        cellList.add(cellId5);
        cellList.add(cellId6);

        S2Loop s2Loop = new S2Loop(cellList);
        S2Polygon polygon = new S2Polygon(s2Loop); //创建多边形
        S2Point s2Point = S2LatLng.fromDegrees(40.015471, 116.471683).toPoint();
        boolean contains = polygon.contains(s2Point);
        System.out.println(contains);
        //116.478441,40.01263 116.471683,40.015471
//        boolean r = union.contains(S2LatLng.fromDegrees(40.01263, 116.478441).toPoint());
//        System.out.println(r);
    }
}
