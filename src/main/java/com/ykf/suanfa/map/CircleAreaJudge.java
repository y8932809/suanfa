package com.ykf.suanfa.map;

/**
 * 描述:
 * 点是否在圆内
 *
 * @author yukaifei
 * @create 2018-12-11 9:57
 */
public class CircleAreaJudge {
    private double cx = 0.0D;
    private double cy = 0.0D;
    private double r = 0.0D;

    public CircleAreaJudge(double x, double y, double r) {
        try {
            this.cx = x;
            this.cy = y;
            this.r = r;
        } catch (NumberFormatException localNumberFormatException) {
        }
    }

    public boolean isInArea(double x, double y) {
        return isInArea(x, y);
    }


    public boolean isInArea(String x, String y) {
//        double dis = RuleUtil.computeLength(Double.parseDouble(x), Double.parseDouble(y), this.cx, this.cy);
        double d2 = Math.hypot((Double.parseDouble(x) - this.cx), (Double.parseDouble(y) - this.cy));
//        double d2 =(double)Math.sqrt((Double.parseDouble(x) - this.cx)+(Double.parseDouble(y) - this.cy));

        System.out.println("d2=="+d2);
        if (d2 < this.r) {
            return true;
        } else {
            return false;
        }
    }


    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }

    /**
     * 判断一个点是否在圆形区域内
     */
    public static boolean isInCircle(double lat1, double lng1, double lat2, double lng2, String radius) {
        double distance = getDistance(lat1, lng1, lat2, lng2);
        double r = Double.parseDouble(radius);
        if (distance > r) {
            return false;
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
        //30.66671, 104.06533,269.5856679472853
//        CircleAreaJudge circleAreaJudge = new CircleAreaJudge( 104.06533,30.66671, 269.5856679472853);
//        System.out.println(circleAreaJudge.isInArea("104.08439","30.66900"));

        System.out.println(isInCircle(30.66671,104.06533,30.66900,104.08439,"269.5856679472853"));
//        System.out.println(getDistance(116.434164,40.047402,116.675629,39.835862));


    }
}
