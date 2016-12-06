package itschool.samsung.ru.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * Created by Admin on 26.11.2016.
 */
public class Exit
{
    private Vector position;
    private Bitmap picture;
    private float size;

    public void Vector(float x, float y,float size, Context context, int picResId)
    {
        position = new Vector(x,y);
        this.size = size;
        picture = BitmapFactory.decodeResource(context.getResources(),
                picResId);
    }

    private Paint paint = new Paint();

    void appear(Canvas canvas)
    {
        Matrix m = new Matrix();
        m.postScale(size, size);
        m.postTranslate(position.x, position.y);
        canvas.drawBitmap(picture, m, paint);
    }

    public boolean Compare(Mouse mouse)
    {
        if(mouse.pos.x < position.x + picture.getWidth()/2*size && mouse.pos.x + mouse.pic.getWidth()/2*mouse.size > position.x
                && mouse.pos.y < position.y + picture.getHeight()/2*size && mouse.pos.y + mouse.pic.getHeight()/2*mouse.size > position.y)
           return true;
        return false;
    }
}
