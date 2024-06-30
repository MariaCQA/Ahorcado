package com.example.ahorcado;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    private Paint paintFill;
    private Paint paintStroke;
    private int stage;
    private Matrix rotationMatrix;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintFill = new Paint();
        paintFill.setColor(Color.MAGENTA);
        paintFill.setStyle(Paint.Style.FILL);

        paintStroke = new Paint();
        paintStroke.setColor(Color.BLACK);
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setStrokeWidth(5);

        stage = 0;
        rotationMatrix = new Matrix();
    }

    private void drawHead(Canvas canvas, int centerX, int centerY) { //CABEZA
        float radius = 50;
        canvas.drawCircle(centerX, centerY - 150, radius, paintFill); // relleno de la cabeza
        canvas.drawCircle(centerX, centerY - 150, radius, paintStroke); // borde de la cabeza
    }

    private void drawTrunk(Canvas canvas, int centerX, int centerY) {//TRONCO
        float width = 40;
        float height = 150;
        canvas.drawOval(centerX - width / 2, centerY - 100, centerX + width / 2, centerY + height, paintFill); // relleno del tronco
        canvas.drawOval(centerX - width / 2, centerY - 100, centerX + width / 2, centerY + height, paintStroke); // borde del tronco
    }

    private void drawArm(Canvas canvas, float left, float top, float rotationAngle) { //BRAZO
        float width = 35;
        float height = 120;
        rotationMatrix.setRotate(rotationAngle, left + width / 2, top + height / 2);
        canvas.concat(rotationMatrix);
        canvas.drawOval(left, top, left + width, top + height, paintFill); // relleno del brazo
        canvas.drawOval(left, top, left + width, top + height, paintStroke); // borde del brazo
        rotationMatrix.reset();
        canvas.concat(rotationMatrix);
    }

    private void drawLeg(Canvas canvas, float left, float top, float rotationAngle) { //PIERNA
        float width = 35;
        float height = 160;
        rotationMatrix.setRotate(rotationAngle, left + width / 2, top + height / 2);
        canvas.concat(rotationMatrix);
        canvas.drawOval(left, top, left + width, top + height, paintFill); //relleno de la pierna
        canvas.drawOval(left, top, left + width, top + height, paintStroke); // borde de la pierna
        rotationMatrix.reset();
        canvas.concat(rotationMatrix);
    }

    public void nextStage() {
        if (stage < 6) {
            stage++;
            invalidate();
        }
    }

    public void reset() {
        stage = 0;
        invalidate();
    }
}
