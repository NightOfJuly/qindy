package com.qindy.service;

import com.uber.h3core.AreaUnit;
import com.uber.h3core.H3Core;
import com.uber.h3core.LengthUnit;
import com.uber.h3core.exceptions.PentagonEncounteredException;
import com.uber.h3core.util.GeoCoord;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * @author qindongyun
 * @Description:
 * @date 2018/9/19
 */
public class H3Demo {

    public static void LocationToH3(){
        try {
            //叶青大厦 116.475341,40.018169
            Double lng = 116.475351D;
            Double lat = 40.018168D;
            int level = 8;
            H3Core core = H3Core.newInstance();
            //返回传入坐标点所在的六边形的索引
            Long index = core.geoToH3(lat, lng, level);
            System.out.println("H3 index = " + index + " level =" + level + " length =" + String.valueOf(index).length());
//            H3 index = 577340361605644287 level =0 length =18
//            H3 index = 604356072848752639 level =6 length =18
//            H3 index = 613363272078327807 level =8 length =18
//            H3 index = 640384869840578327 level =14 length =18
//            H3 index = 644888469467948802 level =15 length =18
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LocationToH3Address(){
        try {
            //叶青大厦 116.475341,40.018169
            Double lng = 116.475351D;
            Double lat = 40.018168D;
            int level = 12;
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

    public static void H3ToLocation(){
        try {
            //叶青大厦 116.475341,40.018169
            Long index = 613363272078327807L;
            int level = 8;
            H3Core core = H3Core.newInstance();
            //返回传入索引值的所在的六边形的质心坐标
            GeoCoord h3 = core.h3ToGeo(index);
            System.out.println("H3 index = " + index + " level =" + level + " lat=" + h3.lat + " lng=" + h3.lng);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void H3ToLocationBoundary() {
        try {
            //叶青大厦 116.475341,40.018169
            Long index = 613363272078327807L;
            int level = 8;
            H3Core core = H3Core.newInstance();
            //返回传入索引值的所在的六边形的边界坐标值集合List
            List<GeoCoord> h3 = core.h3ToGeoBoundary(index);
            System.out.println("H3 index = " + index + " level =" + level + " size=" + h3.size() + " h3=" + StringUtils.join(h3.toArray(),","));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void TestOthers(){
        try {
            H3Core core = H3Core.newInstance();
            int level = 0;
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

    public static void kRing(){
        try {
            H3Core core = H3Core.newInstance();
            int level = 12;
            List<String> cells = core.kRing("8c31aa56e61e7ff",2);
            System.out.println("H3 level=" + level + " size=" + cells.size() + " cells=" + StringUtils.join(cells.toArray(),","));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void heRanges(){
        try {
            H3Core core = H3Core.newInstance();
            List<List<String>> range = core.hexRange("8c31aa56e61e7ff",5);
            System.out.println("H3 size=" + range.size() + " cells=" + StringUtils.join(range.toArray(),","));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (PentagonEncounteredException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
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
        heRanges();
    }

}
