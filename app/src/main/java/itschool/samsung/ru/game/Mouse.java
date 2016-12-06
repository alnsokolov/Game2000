package itschool.samsung.ru.game;

import android.content.Context;
import android.graphics.Canvas;

public class Mouse extends Animal implements OnTouch
{
	Mouse(Context context){	super(context, R.drawable.mouse); }
	
	Mouse(float x, float y, float size, Context context){ super(x, y, size, context, R.drawable.mouse);	}
	
	Vector toGo = new Vector();
	
	void Move(Canvas canvas)
	{
		Vector velocity = new Vector(toGo);
		velocity.Sub(pos);
		velocity.Mult((float)Math.random()*20/100);
		pos.Sum(velocity);
	}

	public void moveTo(float x, float y) {
		toGo.x = x - pic.getWidth()/2*size;
		toGo.y = y - pic.getHeight()/2*size;
	}

	@Override
	public void onTouch(float x, float y)
	{
		Vector velocity = new Vector(toGo);
		velocity.Sub(pos);
		velocity.Mult((float)Math.random()*20/100);
		pos.Sum(velocity);
	}
}
