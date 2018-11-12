package com.qindy.service;

import com.qindy.utils.CoordinateTransformUtil;
import com.uber.h3core.AreaUnit;
import com.uber.h3core.H3Core;
import com.uber.h3core.LengthUnit;
import com.uber.h3core.exceptions.PentagonEncounteredException;
import com.uber.h3core.util.GeoCoord;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/9/19
 */
public class H3Demo {

    //叶青大厦 116.475341,40.018169

    public static void LocationToH3(Double lng, Double lat, int level) {
        try {
            H3Core core = H3Core.newInstance();
            //返回传入坐标点所在的六边形的索引
            Long index = core.geoToH3(lat, lng, level);
            System.out.println("H3 index = " + index + " level =" + level + " length =" + String.valueOf(index).length());
//            H3 index = 577340361605644287 level =0 length =18
//            H3 index = 581839563186503679 level =1 length =18
//            H3 index = 586342063302246399 level =2 length =18
//            H3 index = 590845319332233215 level =3 length =18
//            H3 index = 604356072848752639 level =6 length =18
//            H3 index = 613363272078327807 level =8 length =18
//            H3 index = 640384869840578327 level =14 length =18
//            H3 index = 644888469467948802 level =15 length =18
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LocationToH3Address(Double lng, Double lat, int level) {
        try {
            H3Core core = H3Core.newInstance();
            //返回传入坐标点所在的六边形的索引
            String index = core.geoToH3Address(lat, lng, level);
            System.out.println("H3 index = " + index + " level =" + level + " length =" + index.length());
//            H3 index = 8031fffffffffff level =0 length =15
//            H3 index = 8631aa56fffffff level =6 length =15
//            H3 index = 8931aa56e63ffff level =9 length =15
//            H3 index = 8c31aa56e61e7ff level =12 length =15
//            H3 index = 8f31aa56e61e703 level =15 length =15
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void H3ToLocation(Long index, int level) {
        try {
//            Long index = 613363272078327807L;
            H3Core core = H3Core.newInstance();
            //返回传入索引值的所在的六边形的质心坐标
            GeoCoord h3 = core.h3ToGeo(index);
            System.out.println("H3 index = " + index + " level =" + level + " lat=" + h3.lat + " lng=" + h3.lng);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void H3ToLocationBoundary(Long index, int level) {
        try {
            H3Core core = H3Core.newInstance();
            //返回传入索引值的所在的六边形的边界坐标值集合List
            List<GeoCoord> h3 = core.h3ToGeoBoundary(index);
            System.out.println("H3 index = " + index + " level =" + level + " size=" + h3.size() + " h3=" + StringUtils.join(h3.toArray(), ","));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TestOthers(int level) {
        try {
            H3Core core = H3Core.newInstance();
            //给定精度下正六边形边长
            double edgeLength = core.edgeLength(level, LengthUnit.km);
            System.out.println("H3 level=" + level + "  正六边形边长edgeLength=" + edgeLength);
            //给定精度下正六边形面积
            double hexArea = core.hexArea(level, AreaUnit.km2);
            System.out.println("H3 level=" + level + "  正六边形面积hexArea=" + hexArea);
            //给定精度下正六边形个数
            long numHexagons = core.numHexagons(level);
            System.out.println("H3 level=" + level + "  正六边形个数numHexagons=" + numHexagons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void kRing(Long index, int k) {
        try {
            H3Core core = H3Core.newInstance();

            List<Long> cells = core.kRing(index, k);
            System.out.println("H3 size=" + cells.size() + " cells=" + StringUtils.join(cells.toArray(), ","));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void heRanges(Long index, int k) {
        try {
            H3Core core = H3Core.newInstance();
            List<List<Long>> range = core.hexRange(index, k);
            System.out.println("H3 size=" + range.size() + " cells=" + StringUtils.join(range.toArray(), ","));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (PentagonEncounteredException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //叶青大厦 116.475341,40.018169
//        Double lng = 116.475351D;
//        Double lat = 40.018168D;
//        int level = 3;
        //坐标的cellId（Long）
//        LocationToH3();
        //坐标的cellId（String）
//        LocationToH3Address();
        //cellId对应的坐标
//        H3ToLocation();
        //cell边界顶点的坐标集合
//        H3ToLocationBoundary();
        //给定精度下六边形的大小
//        TestOthers();
        //返回目标cell周围n圈的cell的点集合
//        kRing();
        //返回距离目标cell最近的n个cell的点的集合
//        heRanges();

        try {
            //116.403887,39.914932
            //116.40414714375063,39.914379342231506
            H3Core core = H3Core.newInstance();
            double[] wgs = CoordinateTransformUtil.bd09togcj02(116.493543,39.808831);
            Long index = core.geoToH3(wgs[1],wgs[0],7);
            GeoCoord geoCoord = core.h3ToGeo(index);
            double[] bd = CoordinateTransformUtil.gcj02tobd09(geoCoord.lng, geoCoord.lat);
            System.out.println(bd[0]+","+bd[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
