package com.ykf.suanfa.map;

/**
 * 描述:
 *矩形
 * @author yukaifei
 * @create 2018-12-10 18:18
 */
public class RectangleAreaJudge {
    private float maxX = 0.0F;
    private float minX = 0.0F;
    private float maxY = 0.0F;
    private float minY = 0.0F;

    public RectangleAreaJudge(String points) {
        create(points);
    }

    public void create(String points) {
        String[] pointsArray = points.split(";");

        float x1 = Float.parseFloat(pointsArray[0].split(",")[0]);
        float y1 = Float.parseFloat(pointsArray[0].split(",")[1]);
        float x2 = Float.parseFloat(pointsArray[1].split(",")[0]);
        float y2 = Float.parseFloat(pointsArray[1].split(",")[1]);
        System.out.println(x1 + "--" + y1 + "--" + x2 + "---" + y2);
        if (x1 > x2) {
            this.maxX = x1;
            this.minX = x2;
        } else {
            this.maxX = x2;
            this.minX = x1;
        }
        if (y1 > y2) {
            this.maxY = y1;
            this.minY = y2;
        } else {
            this.maxY = y2;
            this.minY = y1;
        }
    }

    public String cutDot(String s) {
        int dot = s.indexOf(".");
        if (dot < 0) {
            return s;
        }
        return s.substring(0, dot) + s.substring(dot + 1, s.length());
    }

    public boolean isInArea(String x, String y) {
        float ix = Float.parseFloat(x);
        float iy = Float.parseFloat(y);

        if ((ix >= this.minX) && (ix <= this.maxX) && (iy >= this.minY) && (iy <= this.maxY)) {
            return true;
        }

        return false;
    }

    public boolean isInArea(double x, double y) {
        if ((x >= this.minX) && (x <= this.maxX) && (y >= this.minY) && (y <= this.maxY)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        RectangleAreaJudge area = new RectangleAreaJudge("0,0;5,5");
        System.out.println(area.isInArea("1", "1"));
    }

}