package com.gx.woring.Entry;

/**
 * Created by Woring on 18-10-26.
 */

public class Location {

    public String time;
    public String point_x;
    public String point_y;
    public String phone;

    public Location(String time, String point_x, String point_y, String phone) {
        this.time = time;
        this.point_x = point_x;
        this.point_y = point_y;
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPoint_x() {
        return point_x;
    }

    public void setPoint_x(String point_x) {
        this.point_x = point_x;
    }

    public String getPoint_y() {
        return point_y;
    }

    public void setPoint_y(String point_y) {
        this.point_y = point_y;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
