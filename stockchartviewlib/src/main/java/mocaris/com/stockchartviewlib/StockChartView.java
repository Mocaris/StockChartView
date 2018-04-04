package mocaris.com.stockchartviewlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.List;

/**
 * Created by mocaris on 2018/3/2.
 * 股指娱乐宝曲线图
 */

public class StockChartView extends View {
    //y轴上部距离顶部间距
    private int y_top_offset;
    //x y轴距离View底部间距
    private int xy_bottom_offset;
    // x y轴距离view左边间距
    private int axis_left_offset;
    //x y轴距离view右边间距
    private int axis_right_offset;
    //    //设置
    private ChartSetting mChartSetting = ChartSetting.getDefaultSetting();
    //参数
    private ChartParam mChartParm = ChartParam.getDefaultParam();
//
//    //标签文字大小
//    private float axisTextSize = mChartSetting.getAxisTextSize();
//    //标签文字颜色
//    private int axisTextColor = mChartSetting.getAxisTextColor();
//    //分隔线颜色
//    private int limitLineColor = mChartSetting.getLimitLineColor();
//    //K线颜色
//    private int lineColor = mChartSetting.getLineColor();
//    //K线蒙层颜色
//    private int line_filter_color = mChartSetting.getLine_filter_color();
//    //K线宽度
//    private float line_width = mChartSetting.getLine_width();
//
//    //y左轴颜色
//    private int y_left_axis_color = mChartSetting.getY_left_axis_color();
//    //y右轴颜色
//    private int y_right_axis_color = mChartSetting.getY_right_axis_color();
//    //x轴颜色
//    private int x_axis_color = mChartSetting.getX_axis_color();
//    //是否显示y左轴
//    private boolean showYLeftAxis = mChartSetting.isShowYLeftAxis();
//    //是否显示y右轴
//    private boolean showYRightAxis = mChartSetting.isShowYRightAxis();
//    //是否显示X轴
//    private boolean showXAxis = mChartSetting.isShowXAxis();
//    //y轴总共点数
//    private final int y_count = mChartSetting.getY_count();
//    //X轴总共点数
//    private final int x_count = mChartSetting.getX_count();
//    //当前点位图标
//    private int currentBitmapRes = mChartSetting.getCurrentBitmapRes();
//    //    ===========================================
//    //y轴 左下方描述
//    private String y_left_bottom_label = mChartSetting.getY_left_bottom_label();
//    //y轴右下方描述
//    private String y_right_bottom_label = mChartSetting.getY_right_bottom_label();
//    private boolean show_left_bottom_label = mChartSetting.isShow_left_bottom_label();
//    //    y轴 右下方描述
//    private boolean show_right_bottom_label = mChartSetting.isShow_right_bottom_label();
//    //y 轴左侧 标签
//    private float[] yAxisLeft_label_datas = mChartParm.getyAxisLeft_label_datas();
//    //Y 轴右侧标签
//    private String[] yAxisRight_label_datas = mChartParm.getyAxisRight_label_datas();
//    //X 轴标签
//    private String[] xAxis_label_datas = mChartParm.getxAxis_label_datas();
//    // 点位数据
//    private List<Integer> points = mChartParm.getPoints();
//    //区间块
//    private List<ChartBlockData> blockDatas = mChartParm.getBlockDatas();

    public StockChartView(Context context) {
        this(context, null);
    }

    public StockChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        y_top_offset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20F, this.getContext().getResources().getDisplayMetrics()) + getPaddingTop();
        xy_bottom_offset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25F, this.getContext().getResources().getDisplayMetrics()) + getPaddingBottom();
        axis_left_offset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45F, this.getContext().getResources().getDisplayMetrics()) + getPaddingLeft();
        axis_right_offset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45F, this.getContext().getResources().getDisplayMetrics()) + getPaddingRight();
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StockChartView);
//        axisTextSize = typedArray.getDimension(R.styleable.StockChartView_axis_lable_size, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 8, this.getContext().getResources().getDisplayMetrics()));
//        line_width = typedArray.getDimension(R.styleable.StockChartView_line_width, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 3, this.getContext().getResources().getDisplayMetrics()));
//        dashColor = typedArray.getColor(R.styleable.StockChartView_limit_line_color, Color.parseColor("#88ffffff"));
//        axisTextColor = typedArray.getColor(R.styleable.StockChartView_axis_lable_color, Color.parseColor("#708086"));
//        lineColor = typedArray.getColor(R.styleable.StockChartView_chart_line_color, Color.parseColor("#3ec0fd"));
//        line_filter_color = typedArray.getColor(R.styleable.StockChartView_line_filter_color, Color.parseColor("#0077d2"));
        List<Integer> points = mChartParm.getPoints();
        points.add(234);
        points.add(434);
        points.add(864);
        points.add(634);
        points.add(434);
        points.add(334);
        points.add(134);
        points.add(500);

    }

    public void update(ChartSetting chartSetting) {
        this.mChartSetting = chartSetting;
    }

    public void update(ChartParam chartParam) {
        this.mChartParm = chartParam;
    }

    public ChartSetting getChartSetting() {
        return mChartSetting;
    }

    public ChartParam getChartParm() {
        return mChartParm;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //y左轴
        drawYLeftAxis(canvas);
        //y右轴
        drawYRightAxis(canvas);
        //x轴
        drawXAxis(canvas);
        //y轴左侧文字
        drawYleftLabels(canvas);
        //y轴右侧文字
        drawYRightLabels(canvas);
        //x轴文字
        drawXLabels(canvas);
        //y轴 下方描述
        drawYAxisBottomLabel(canvas);
        //画折线
        drawPoints(canvas);
        //画超出区间 小于区间
        drawStockBlock(canvas);
    }


    /*
    y轴 下方描述
     */
    private void drawYAxisBottomLabel(Canvas canvas) {
        TextPaint paint = new TextPaint();
        paint.setStrokeWidth(1);
        paint.setColor(mChartSetting.getAxisTextColor());
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mChartSetting.getAxisTextSize(), getContext().getResources().getDisplayMetrics()));
        paint.setAntiAlias(true);
        Rect rect = new Rect();
        String y_left_bottom_label = mChartSetting.getY_left_bottom_label();
        if (mChartSetting.isShow_left_bottom_label() && null != y_left_bottom_label) {
            //Y轴左下方描述
            paint.getTextBounds(y_left_bottom_label, 0, y_left_bottom_label.length(), rect);
            canvas.drawText(y_left_bottom_label
                    , Math.abs(axis_left_offset - rect.width()) / 2 + 5
                    , getMeasuredHeight() - xy_bottom_offset + rect.height()
                    , paint);
        }
        String y_right_bottom_label = mChartSetting.getY_right_bottom_label();
        if (mChartSetting.isShow_right_bottom_label() && null != y_right_bottom_label) {
            //Y轴右下方描述
            paint.getTextBounds(y_right_bottom_label, 0, y_right_bottom_label.length(), rect);
            canvas.drawText(y_right_bottom_label
//                , getMeasuredWidth() - (axis_left_offset + rect.width()) / 2
                    , getMeasuredWidth() - rect.width() - 5
                    , getMeasuredHeight() - xy_bottom_offset + rect.height()
                    , paint);
        }
    }

    /*
    画x轴
     */
    private void drawXAxis(Canvas canvas) {
        if (!mChartSetting.isShowXAxis()) {
            return;
        }
        float xWidth = (getMeasuredWidth() - axis_left_offset - axis_right_offset);
        float x_cell_widhth = xWidth / (mChartSetting.getX_count() - 1);
        int x_axis_color = mChartSetting.getX_axis_color();
        Paint paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setColor(x_axis_color);
        paint.setAntiAlias(true);

        canvas.drawLine(axis_left_offset
                , getMeasuredHeight() - xy_bottom_offset
                , axis_left_offset + xWidth
                , getMeasuredHeight() - xy_bottom_offset,
                paint);

        paint.setColor(x_axis_color);
        paint.setStrokeWidth(2);
        for (int i = 0; i < mChartSetting.getX_count(); i++) {
            canvas.drawLine(i * x_cell_widhth + axis_left_offset
                    , getMeasuredHeight() - xy_bottom_offset - 5
                    , i * x_cell_widhth + axis_left_offset
                    , getMeasuredHeight() - xy_bottom_offset
                    , paint);
        }

    }

    /*
    画X轴文字
     */
    private void drawXLabels(Canvas canvas) {
        String[] xAxis_label_datas = mChartParm.getxAxis_label_datas();
        if (null == xAxis_label_datas) {
            return;
        }
        float xWidth = getMeasuredWidth() - axis_left_offset - axis_right_offset;
        float x_cell_widhth = xWidth / (xAxis_label_datas.length - 1);
//        float x_cell_widhth = xWidth / y_count * (y_count / (xAxis_label_datas.length-1));
        TextPaint paint = new TextPaint();
        paint.setStrokeWidth(1);
        paint.setColor(mChartSetting.getAxisTextColor());
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mChartSetting.getAxisTextSize(), getContext().getResources().getDisplayMetrics()));
        paint.setAntiAlias(true);
        Rect rect = new Rect();
        for (int i = 0; i < xAxis_label_datas.length; i++) {
            String xAxis_label_data = xAxis_label_datas[i];
            paint.getTextBounds(xAxis_label_data
                    , 0
                    , xAxis_label_data.length()
                    , rect);
            canvas.drawText(xAxis_label_data
                    , i * x_cell_widhth + axis_left_offset - (i == 0 ? 0 : i == xAxis_label_datas.length - 1 ? rect.width() : rect.width() / 2)
                    , getMeasuredHeight() - xy_bottom_offset + rect.height() + rect.height() / 3
                    , paint
            );
        }

    }

    /*
    轴线
     * 画y轴左侧
     *
     */
    private void drawYLeftAxis(Canvas canvas) {
        boolean showYLeftAxis = mChartSetting.isShowYLeftAxis();
        if (!showYLeftAxis) {
            return;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setColor(mChartSetting.getY_left_axis_color());
        paint.setAntiAlias(true);
        canvas.drawLine(axis_left_offset
                , y_top_offset
                , axis_left_offset
                , getMeasuredHeight() - xy_bottom_offset
                , paint);

    }

    /*
    轴线
        * 画Y轴右侧
        */
    private void drawYRightAxis(Canvas canvas) {
        boolean showYRightAxis = mChartSetting.isShowYRightAxis();
        if (!showYRightAxis) {
            return;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setColor(mChartSetting.getY_right_axis_color());
        paint.setAntiAlias(true);
        canvas.drawLine(getMeasuredWidth() - axis_right_offset
                , y_top_offset
                , getMeasuredWidth() - axis_right_offset
                , getMeasuredHeight() - xy_bottom_offset
                , paint);


    }

    /*
    画y轴左侧文字
    Y轴横线
     */
    private void drawYleftLabels(Canvas canvas) {
        float[] yAxisLeft_label_datas = mChartParm.getyAxisLeft_label_datas();
        if (null == yAxisLeft_label_datas) {
            return;
        }
        float yAxisHeight = getMeasuredHeight() - y_top_offset - xy_bottom_offset;
        float y_cell_height = yAxisHeight / (yAxisLeft_label_datas.length - 1);
        TextPaint paint = new TextPaint();
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mChartSetting.getAxisTextSize(), getContext().getResources().getDisplayMetrics()));
        paint.setColor(mChartSetting.getAxisTextColor());
        Rect rect = new Rect();
        for (int i = 0; i < yAxisLeft_label_datas.length; i++) {
            String label = String.valueOf(yAxisLeft_label_datas[yAxisLeft_label_datas.length - 1 - i]);
            paint.getTextBounds(label, 0, label.length(), rect);
            canvas.drawText(label
                    , Math.abs(axis_left_offset - rect.width()) / 2
                    , y_top_offset + i * y_cell_height
                    , paint);
        }
        paint.setColor(mChartSetting.getLimitLineColor());
        paint.setStrokeWidth(1);
        //limit线
        for (int i = 0; i < yAxisLeft_label_datas.length; i++) {
            canvas.drawLine(axis_left_offset
                    , y_top_offset + i * y_cell_height
                    , getMeasuredWidth() - axis_right_offset
                    , y_top_offset + i * y_cell_height, paint);
        }

    }

    /*
    画Y轴右侧文字
     */
    private void drawYRightLabels(Canvas canvas) {
        String[] yAxisRight_label_datas = mChartParm.getyAxisRight_label_datas();
        if (null == yAxisRight_label_datas) {
            return;
        }
        float yAxisHeight = getMeasuredHeight() - y_top_offset - xy_bottom_offset;
        float ylabelSpace = ((float) yAxisHeight) / (yAxisRight_label_datas.length - 1);
        TextPaint paint = new TextPaint();
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mChartSetting.getAxisTextSize(), getContext().getResources().getDisplayMetrics()));
        paint.setColor(mChartSetting.getAxisTextColor());
        Rect rect = new Rect();
        for (int i = 0; i < yAxisRight_label_datas.length; i++) {
            String label = String.valueOf(yAxisRight_label_datas[yAxisRight_label_datas.length - 1 - i]);
            paint.getTextBounds(label, 0, label.length(), rect);
            canvas.drawText(label
                    , getMeasuredWidth() - (axis_right_offset + rect.width()) / 2
                    , y_top_offset + i * ylabelSpace
                    , paint);
        }
    }

    /*
    根据数据画点
     */
    private void drawPoints(Canvas canvas) {
        List<Integer> points = mChartParm.getPoints();
        int x_count = mChartSetting.getX_count();
        int y_count = mChartSetting.getY_count();
        if (null == points) {
            return;
        }
        float x_cell_width = ((float) (getMeasuredWidth() - axis_left_offset - axis_right_offset)) / (x_count - 1);
        float y_cell_height = ((float) (getMeasuredHeight() - y_top_offset - xy_bottom_offset)) / (y_count - 1);

        Paint paint = new Paint();
        Paint paintfill = new Paint();
        paintfill.setStyle(Paint.Style.FILL);
        paintfill.setColor(mChartSetting.getLine_filter_color());
//        ColorMatrixColorFilter filter=new ColorMatrixColorFilter();
//        paintfill.setColorFilter(filter);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(mChartSetting.getLineColor());
        paint.setStrokeWidth(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mChartSetting.getLine_width(), getContext().getResources().getDisplayMetrics()));
        Path path = new Path();
        Path pathfill = new Path();
        pathfill.moveTo(axis_left_offset, getMeasuredHeight() - xy_bottom_offset);
        for (int i = 0; i < points.size(); i++) {
            int tempData = points.get(i);
            float x = i * x_cell_width + axis_left_offset;
            float y = (y_count - tempData) * y_cell_height + y_top_offset;
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
            pathfill.lineTo(x, y);
            //画当前点
            if (i == points.size() - 1) {
                int bitmapwidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, getContext().getResources().getDisplayMetrics());
                Drawable drawable = getContext().getResources().getDrawable(mChartSetting.getCurrentBitmapRes());
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    Rect rect = new Rect(((int) x - bitmapwidth / 2)
                            , ((int) y - bitmapwidth / 2)
                            , bitmapwidth + ((int) x - bitmapwidth / 2)
                            , bitmapwidth + ((int) y - bitmapwidth / 2));
//                    Rect rect = new Rect((int) x, (int) y, 10, 10);
                    canvas.drawBitmap(bitmap, null, rect, null);
                }
            }

//            ===============贝塞尔==============
//            if (i > 0) {
//                float x1 = (i - 1) * x_cell_width + axis_left_offset;
//                float y1 = (y_count - tempDatas[i - 1]) * y_cell_height + y_top_offset;
//                path.quadTo(x1, y1, x, y);
//            }
//            =================================end
            Log.i("StockLineChartView", "drawPoints:::" + x + ":::" + y);
        }
        pathfill.lineTo((points.size() - 1) * x_cell_width + axis_left_offset, getMeasuredHeight() - xy_bottom_offset);
        canvas.drawPath(path, paint);
        canvas.drawPath(pathfill, paintfill);
    }

    //画区间
    private void drawStockBlock(Canvas canvas) {
        List<ChartBlockData> blockDatas = mChartParm.getBlockDatas();
        ChartBlockData block = new ChartBlockData();
        block.setDesc("哈哈哈嘿嘿嘿");
        block.setMinY(500);
        block.setMaxY(800);
        blockDatas.add(block);
        //非null 才能继续画
        if (null != blockDatas && 0 != blockDatas.size()) {
            int y_count = mChartSetting.getY_count();
            Paint paint = new Paint();
            paint.setStrokeWidth(1);
            paint.setAntiAlias(true);
            paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 13f, getContext().getResources().getDisplayMetrics()));
            float y_axis_height = getMeasuredHeight() - y_top_offset - xy_bottom_offset;
            float x_axis_right = getMeasuredWidth() - axis_right_offset;
            float y_space_height = (y_axis_height) / (y_count - 1);
            for (int i = 0; i < blockDatas.size(); i++) {
                ChartBlockData blockData = blockDatas.get(i);
                float minY = blockData.getMinY();
                float maxY = blockData.getMaxY();
                String desc = blockData.getDesc();
                paint.setColor(blockData.getBlockColor());
                //区间块
                Rect rect = new Rect(axis_left_offset
                        , ((int) (y_top_offset + (y_count - Math.min(maxY, y_count)) * y_space_height))
                        , (int) x_axis_right
                        , ((int) (y_top_offset + (y_count - Math.max(minY, 0)) * y_space_height)));
                canvas.drawRect(rect, paint);
                //描述
                Rect txtBounds = new Rect();
                paint.getTextBounds(desc, 0, desc.length(), txtBounds);
                paint.setColor(Color.WHITE);
                canvas.drawText(desc
                        , (getMeasuredWidth() - txtBounds.width()) / 2
                        , y_top_offset + y_space_height * (y_count - (maxY - minY) / 2 - minY) + txtBounds.height() / 4
                        , paint);
            }
        }
    }

}
