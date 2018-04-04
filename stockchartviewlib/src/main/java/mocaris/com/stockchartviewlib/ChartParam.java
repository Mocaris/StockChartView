package mocaris.com.stockchartviewlib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mocaris on 2018/3/2.
 */

public class ChartParam {

    /**
     * 默认
     * @return
     */
    public static ChartParam getDefaultParam() {
        return new ChartParam();
    }

    //y 轴左侧 标签
    private float[] yAxisLeft_label_datas = {1000, 2000, 3000, 4000, 5000};
    //Y 轴右侧标签
    private String[] yAxisRight_label_datas = {"≈3.0倍", "≈2.0倍", "≈开盘价", "≈2.0倍", "≈3.0倍"};
    //X 轴标签  默认值  无需修改
    private String[] xAxis_label_datas = {"9:30", "10:30", "11:30/13:00", "14:00", "15:00"};
    // 点位数据
    private List<Integer> points = new ArrayList<>();
    //区间块
    private List<ChartBlockData> blockDatas = new ArrayList<>();
    //当前点位
    private int currentPoint;

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public List<ChartBlockData> getBlockDatas() {
        return blockDatas;
    }

    public void setBlockDatas(List<ChartBlockData> blockDatas) {
        this.blockDatas = blockDatas;
    }

    public float[] getyAxisLeft_label_datas() {
        return yAxisLeft_label_datas;
    }

    public void setyAxisLeft_label_datas(float[] yAxisLeft_label_datas) {
        this.yAxisLeft_label_datas = yAxisLeft_label_datas;
    }

    public String[] getyAxisRight_label_datas() {
        return yAxisRight_label_datas;
    }

    public void setyAxisRight_label_datas(String[] yAxisRight_label_datas) {
        this.yAxisRight_label_datas = yAxisRight_label_datas;
    }

    public String[] getxAxis_label_datas() {
        return xAxis_label_datas;
    }

    public void setxAxis_label_datas(String[] xAxis_label_datas) {
        this.xAxis_label_datas = xAxis_label_datas;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }
}
