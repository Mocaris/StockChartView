package mocaris.com.stockchartviewlib;

import android.graphics.Color;

/**
 * Created by mocaris on 2018/3/3.
 * 区间块
 */

public class ChartBlockData {
    //最小Y值
    private float minY;
    //最大Y值
    private float maxY;
    //描述信息
    private String desc;
    //区间块颜色
    private int blockColor = Color.parseColor("#72f92b46");

    public int getBlockColor() {
        return blockColor;
    }

    public void setBlockColor(int blockColor) {
        this.blockColor = blockColor;
    }

    public float getMinY() {
        return minY;
    }

    public void setMinY(float minY) {
        this.minY = minY;
    }

    public float getMaxY() {
        return maxY;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
