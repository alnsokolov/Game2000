package itschool.samsung.ru.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Animal 
{
	Animal(Context context, int picResId)
	{
		pos = new Vector();
		size = 1;
		pic = BitmapFactory.decodeResource(context.getResources(),
				picResId);
	}
	
	Animal(float x, float y, float size, Context context, int picResId)
	{
		pos = new Vector(x,y);
		this.size = size;
		pic = BitmapFactory.decodeResource(context.getResources(),
				picResId);
	}
	
	Vector pos;
	float size;
	protected Bitmap pic;
	Paint paint = new Paint();

	void appear(Canvas canvas)
	{
		Matrix m = new Matrix();
		m.postScale(size, size);
		m.postTranslate(pos.x, pos.y);
		canvas.drawBitmap(pic, m, paint);
	}
}
