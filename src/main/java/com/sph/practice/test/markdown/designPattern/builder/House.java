package com.sph.practice.test.markdown.designPattern.builder;

/**
 * Created by Shen Peihong on 2020/11/25 22:09
 * Description:产品类
 *
 * @since 1.0.0
 */
public class House {
    //地基
    private String basic;
    //屋顶
    private String roofed;
    //墙壁
    private String wall;

    public House(String basic, String roofed, String wall) {
        this.basic = basic;
        this.roofed = roofed;
        this.wall = wall;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
