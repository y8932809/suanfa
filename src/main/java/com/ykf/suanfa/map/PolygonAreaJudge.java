package com.ykf.suanfa.map;

import org.springframework.util.StringUtils;

import java.awt.*;
import java.io.PrintStream;
import java.text.DecimalFormat;

/**
 * 描述:
 * 多边形
 *
 * @author yukaifei
 * @create 2018-12-10 16:20
 */
public class PolygonAreaJudge {
    private Polygon polygon;
    private int rate = 1000000;
    private double maxX = 0.0D;
    private double minX = 0.0D;
    private double maxY = 0.0D;
    private double minY = 0.0D;

    //创建多边形  多边形坐标点
    public PolygonAreaJudge(String axisStr) {
        this.rate = RuleUtil.rate;
        createPolygon(axisStr);
    }

    private boolean createPolygon(String axisStr) {
        if (StringUtils.isEmpty(axisStr)) {
            return false;
        }
        this.polygon = new Polygon();
        String[] axisInfo = axisStr.split("\\;");

        String currAxis = "";

        for (int cnt = 0; cnt < axisInfo.length; cnt++) {
            currAxis = axisInfo[cnt];
            if (!StringUtils.isEmpty(currAxis)) {
                int pos = currAxis.indexOf(",");
                if (pos != -1) {
                    int y;
                    int x;
                    try {
                        //十进制转换
                        DecimalFormat decimalFormat = new DecimalFormat("#########");
                        double dX = Double.parseDouble(axisInfo[cnt].substring(0, pos).trim()) * this.rate;
                        String sX = decimalFormat.format(dX);
                        if (sX.indexOf(".") != -1) {
                            sX = sX.substring(0, sX.indexOf("."));
                        }
                        x = Integer.parseInt(sX);
                        double dY = Double.parseDouble(axisInfo[cnt].substring(pos + 1, currAxis.length()).trim())
                                * this.rate;
                        String sY = decimalFormat.format(dY);
                        if (sY.indexOf(".") != -1) {
                            sY = sY.substring(0, sY.indexOf("."));
                        }
                        y = Integer.parseInt(sY);
                    } catch (NumberFormatException e) {

                        continue;
                    }

                    this.polygon.addPoint(x, y);
                }
            }
        }
        return true;
    }

    //创建边界
    private boolean creatBounds() {
        Rectangle rectangle = this.polygon.getBounds();
        this.maxX = rectangle.getMaxX();
        this.maxY = rectangle.getMaxY();
        this.minX = rectangle.getMinX();
        this.minY = rectangle.getMinY();
        return true;
    }

    public boolean checkIsInArea(int x, int y) {
        if (this.polygon == null) {
            return false;
        }
        return this.polygon.contains(x, y);
    }

    public boolean isInArea(float x, float y) {
        int iX = (int) (x * this.rate);
        int iY = (int) (y * this.rate);

        return checkIsInArea(iX, iY);
    }

    public boolean isInArea(String x, String y) {
        if (this.polygon == null) {
            return false;
        }
        if (!isInAreaBounds(x, y)) {
            return false;
        }
        int iX = RuleUtil.toInt(x);
        int iY = RuleUtil.toInt(y);

        return checkIsInArea(iX, iY);
    }

    public boolean isInAreaBounds(String x, String y) {
        double ix = Double.parseDouble(x);
        double iy = Double.parseDouble(y);

        if ((ix >= this.minX) && (ix <= this.maxX) && (iy >= this.minY) && (iy <= this.maxY)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PolygonAreaJudge poly = new PolygonAreaJudge(
                "116.379907,39.843951;116.385476,39.844865;116.388135,39.840932;116.379655,39.841015");
        System.out.println("IsInArea is " + poly.isInArea(118.11251F, 30.115244F));
        System.out.println("IsInArea is " + poly.isInArea("118.112511", "30.115244"));
        System.out.println("IsInArea is " + poly.isInArea(116.383078F, 39.843006F));

        System.out.println("----------------------");
        poly = new PolygonAreaJudge("0,0;0,5;1,7;2,9;6,0");
        System.out.println("IsInArea is " + poly.isInArea(2.0F, 9.0F));

    }

}