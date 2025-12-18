package com.example.a10tomilovpr_23101;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.graphics.Typeface;

public class Draw2D extends View {
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Draw2D(Context context) {
        super(context);


        Resources res = this.getResources();

        mBitmap = BitmapFactory.decodeResource(res, R.drawable.car);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // 1. ФОН
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.rgb(40, 0, 60));
        canvas.drawPaint(mPaint);

        // 2. ЛУНА
        mPaint.setColor(Color.YELLOW);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(width - 100, 100, 60, mPaint);

        // 3. ДОРОГА
        mPaint.setColor(Color.DKGRAY);
        canvas.drawRect(0, height - 300, width, height, mPaint);

        // Линия разметки
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(15);
        canvas.drawLine(0, height - 150, width, height - 150, mPaint);
        mPaint.setStrokeWidth(0);

        // 4. ТЕКСТ "Ночной город"
        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(60);
        mPaint.setTypeface(Typeface.DEFAULT);
        mPaint.setShadowLayer(0, 0, 0, 0);
        canvas.drawText("Ночной город", 50, 100, mPaint);


        String roadText = "СКОРОСТЬ";


        mPaint.setColor(Color.CYAN);
        mPaint.setTextSize(100);


        mPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC));


        mPaint.setShadowLayer(30, 0, 0, Color.WHITE);

        canvas.save();
        canvas.rotate(-15, width / 2, height / 2);

        float textWidth = mPaint.measureText(roadText);
        canvas.drawText(roadText, (width - textWidth) / 2, height / 2, mPaint);
        canvas.restore();


        mPaint.setShadowLayer(0, 0, 0, 0);
        mPaint.setTypeface(Typeface.DEFAULT);


        if (mBitmap != null) {

            float carX = width - mBitmap.getWidth() +90;


            float carY = height - mBitmap.getHeight() - 20;


            canvas.drawBitmap(mBitmap, carX, carY, mPaint);
        }
    }
}