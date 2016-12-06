package itschool.samsung.ru.game;

import android.content.Context;
import android.graphics.Canvas;

public class Cat extends Animal implements OnTouch
{
	Cat(Context context)
	{
		super(context, R.drawable.cat);
	}
	
	Cat(float x, float y, float size, Context context)
	{
		super(x, y, size, context, R.drawable.cat);
	}
	
	Vector toGo = new Vector();
	public boolean appearence = false;
	
	void Move(Canvas canvas)
	{
		Vector velocity = new Vector(toGo);
		velocity.Sub(pos);
		velocity.Mult((float)0.01);
		pos.Sum(velocity);
	}

	public void moveTo(Mouse mouse) {
		toGo.x = mouse.pos.x + mouse.pic.getWidth()*mouse.size/2 - pic.getWidth()*size/2;
		toGo.y = mouse.pos.y + mouse.pic.getHeight()*mouse.size/2 - pic.getHeight()*size/2;
	}

	@Override
	public void onTouch(float x, float y) {
		if((x-pos.x-pic.getWidth()/2*size)*(x-pos.x-pic.getWidth()/2*size) + (y-pos.y-pic.getHeight()/2*size)*(y-pos.y-pic.getHeight()/2*size) < pic.getWidth()*size*pic.getWidth()*size/4)
			size *= 1.1;
	}

	public boolean Eaten(Mouse m1)
	{
		if (Math.sqrt((pos.x + pic.getWidth()*size/2 - m1.pos.y - m1.pic.getWidth()*m1.size/2)*(pos.x + pic.getWidth()*size/2 - m1.pos.y - m1.pic.getWidth()*m1.size/2)+(pos.y+size/2*pic.getHeight() - m1.pos.y - m1.size/2*m1.pic.getHeight())*(pos.y+size/2*pic.getHeight() - m1.pos.y - m1.size/2*m1.pic.getHeight()))<(pic.getHeight()/2*size + m1.pic.getHeight()/2*m1.size))
			return true;
		else
			return false;
	}
}
