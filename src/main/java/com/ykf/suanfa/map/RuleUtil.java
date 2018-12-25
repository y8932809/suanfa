package com.ykf.suanfa.map;

/**
 * 描述:
 *
 * @author yukaifei
 * @create 2018-12-10 16:22
 */
public class RuleUtil {
    public static int rate = 10000;


    public static int toInt(String coordinate) {
        double dx = Double.parseDouble(coordinate);
        Double rdx = new Double(dx * rate);
        long lx = rdx.longValue();
        int ix = (int) lx;
        return ix;
    }

    public static double computeLength(double dwStartX, double dwStartY, double dwEndX, double dwEndY) {
        double PI = 3.1415926535898D;

        double latRadians1 = dwStartY * (PI / 180.0D);
        double latRadians2 = dwEndY * (PI / 180.0D);
        double latRadians = latRadians1 - latRadians2;
        double lngRadians = dwStartX * (PI / 180.0D) - dwEndX * (PI / 180.0D);
        double f = 2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin(latRadians / 2.0D), 2.0D)
                + Math.cos(latRadians1) * Math.cos(latRadians2) * Math.pow(Math.sin(lngRadians / 2.0D), 2.0D)));
        return f * 6378137.0D;
    }

}