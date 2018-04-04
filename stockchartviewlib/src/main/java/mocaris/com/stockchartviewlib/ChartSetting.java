package mocaris.com.stockchartviewlib;

import android.graphics.Color;

/**
 * Created by mocaris on 2018/3/2.
 * 曲线图设置
 */

public class ChartSetting {
    /**
     * 默认
     *
     * @return
     */
    public static ChartSetting getDefaultSetting() {
        return new ChartSetting();
    }

    //分隔线颜色
    private int limitLineColor = Color.parseColor("#88ffffff");
    //标签文字颜色
    private int axisTextColor = Color.parseColor("#708086");
    //K线颜色
    private int lineColor = Color.parseColor("#3ec0fd");
    //K线蒙层颜色
    private int line_filter_color = Color.parseColor("#880077d2");
    //y左轴颜色
    private int y_left_axis_color = Color.RED;
    //y右轴颜色
    private int y_right_axis_color = Color.RED;
    //x轴颜色
    private int x_axis_color = Color.RED;
    //是否显示y左轴
    private boolean showYLeftAxis = true;
    //是否显示y右轴
    private boolean showYRightAxis = true;
    //是否显示X轴
    private boolean showXAxis = true;
    //标签文字大小 dp
    private float axisTextSize = 12;
    //y轴总共点数
    private int y_count = 1000;
    //X轴总共点数
    private int x_count = 10;
    //K线宽度 dp
    private float line_width = 3;
    //y轴 左下方描述
    private String y_left_bottom_label = "上证指数";
    //是否显示 y轴 左下方描述
    private boolean show_left_bottom_label = false;
    //y轴右下方描述
    private String y_right_bottom_label = "预计收益";
    //    y轴 右下方描述
    private boolean show_right_bottom_label = false;
    //当前点位图标
    private int currentBitmapRes = R.drawable.game_stock_spot;

    public boolean isShow_left_bottom_label() {
        return show_left_bottom_label;
    }

    public void setShow_left_bottom_label(boolean show_left_bottom_label) {
        this.show_left_bottom_label = show_left_bottom_label;
    }

    public boolean isShow_right_bottom_label() {
        return show_right_bottom_label;
    }

    public void setShow_right_bottom_label(boolean show_right_bottom_label) {
        this.show_right_bottom_label = show_right_bottom_label;
    }

    public int getCurrentBitmapRes() {
        return currentBitmapRes;
    }

    public void setCurrentBitmapRes(int currentBitmapRes) {
        this.currentBitmapRes = currentBitmapRes;
    }

    public String getY_left_bottom_label() {
        return y_left_bottom_label;
    }

    public void setY_left_bottom_label(String y_left_bottom_label) {
        this.y_left_bottom_label = y_left_bottom_label;
    }

    public String getY_right_bottom_label() {
        return y_right_bottom_label;
    }

    public void setY_right_bottom_label(String y_right_bottom_label) {
        this.y_right_bottom_label = y_right_bottom_label;
    }

    public int getY_left_axis_color() {
        return y_left_axis_color;
    }

    public void setY_left_axis_color(int y_left_axis_color) {
        this.y_left_axis_color = y_left_axis_color;
    }

    public int getY_right_axis_color() {
        return y_right_axis_color;
    }

    public void setY_right_axis_color(int y_right_axis_color) {
        this.y_right_axis_color = y_right_axis_color;
    }

    public int getX_axis_color() {
        return x_axis_color;
    }

    public void setX_axis_color(int x_axis_color) {
        this.x_axis_color = x_axis_color;
    }

    public boolean isShowYLeftAxis() {
        return showYLeftAxis;
    }

    public void setShowYLeftAxis(boolean showYLeftAxis) {
        this.showYLeftAxis = showYLeftAxis;
    }

    public boolean isShowYRightAxis() {
        return showYRightAxis;
    }

    public void setShowYRightAxis(boolean showYRightAxis) {
        this.showYRightAxis = showYRightAxis;
    }

    public boolean isShowXAxis() {
        return showXAxis;
    }

    public void setShowXAxis(boolean showXAxis) {
        this.showXAxis = showXAxis;
    }

    public int getLimitLineColor() {
        return limitLineColor;
    }

    public void setLimitLineColor(int limitLineColor) {
        this.limitLineColor = limitLineColor;
    }

    public int getAxisTextColor() {
        return axisTextColor;
    }

    public void setAxisTextColor(int axisTextColor) {
        this.axisTextColor = axisTextColor;
    }

    public float getAxisTextSize() {
        return axisTextSize;
    }

    public void setAxisTextSize(float axisTextSize) {
        this.axisTextSize = axisTextSize;
    }

    public int getY_count() {
        return y_count;
    }

    public void setY_count(int y_count) {
        this.y_count = y_count;
    }

    public int getX_count() {
        return x_count;
    }

    public void setX_count(int x_count) {
        this.x_count = x_count;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public int getLine_filter_color() {
        return line_filter_color;
    }

    public void setLine_filter_color(int line_filter_color) {
        this.line_filter_color = line_filter_color;
    }

    public float getLine_width() {
        return line_width;
    }

    public void setLine_width(float line_width) {
        this.line_width = line_width;
    }
}
