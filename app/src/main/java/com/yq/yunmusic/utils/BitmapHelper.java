package com.yq.yunmusic.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by yinqi on 2017/9/9.
 */

public class BitmapHelper {

    public static Bitmap getCircleBmp(Resources resources, int resId, int radius) {
        Bitmap src = BitmapFactory.decodeResource(resources, resId);
        return getRoundedCornerBitmap(src, radius);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static Bitmap getRoundCornerBitmapWithBorder(Resources resources, int resId, int borderCornerRadius) {
        Bitmap src = BitmapFactory.decodeResource(resources, resId);
        Bitmap temp_out = getRoundedCornerBitmap(src, 0);//图片默认为矩形的
        Bitmap out = Bitmap.createBitmap(temp_out.getWidth(), temp_out.getHeight(), Bitmap.Config.ARGB_8888);
        //新建画布
        Canvas canvas = new Canvas(out);
        //原始大小的矩形
        Rect rect = new Rect(0, 0, temp_out.getWidth(), temp_out.getHeight());
        //矩形宽高的两边都缩小 10
        Rect insetRect = new Rect(rect);
        //外面白色变宽宽度 默认为 10
        final int borderWidth = 8;
        //缩小矩形
        insetRect.inset(borderWidth, borderWidth);

        Paint paint = new Paint();
        //把图像信息画在缩小后的矩形区域内
        canvas.drawBitmap(temp_out, rect, insetRect, paint);

        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(borderWidth);
        //画边框线
        canvas.drawRoundRect(new RectF(insetRect), borderCornerRadius, borderCornerRadius, paint);
        return out;
    }

}
