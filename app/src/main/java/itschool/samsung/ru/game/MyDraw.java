package itschool.samsung.ru.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;

public class MyDraw extends View implements SeekBar.OnSeekBarChangeListener
{
		Vector v;
		public MyDraw(Context context,AttributeSet attrs)
		{
	        super(context, attrs);
			start(context);
		}
		public void start(Context context)
		{
			v = new Vector(30,100);
			animals = new Animal[4];
			animals[0] = new Cat(100,0,.1f,context);
			cats = new Cat[3];
			for(i = 1; i < animals.length; i++)
				animals[i] = new Mouse((float)Math.random()*200,(float)Math.random()*500,.2f,context);

			for(i = 1; i < cats.length; i++)
				cats[i] = new Cat((float)Math.random()*200,(float)Math.random()*500,.2f,context);
		}

		Paint paint = new Paint();
		Cat cat1;
		Animal[] animals;
		int i = 0;
		TextView text;
		Cat[] cats;
		Timer timer = new Timer();
		int appear = 0;
		
		@Override
		protected void onDraw(Canvas canvas)
		{
			for(i = 0; i < animals.length; i++)
			{
				animals[i].appear(canvas);
				if (animals[i] instanceof Mouse)
					((Mouse)animals[i]).Move(canvas);
			}
			((Cat)animals[0]).appear(canvas);
			((Cat)animals[0]).Move(canvas);
			((Cat)animals[0]).Eaten((Mouse)animals[1]);
			invalidate();

		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			
			for(i = 0; i < animals.length; i++)
				if (animals[i] instanceof Mouse)
					((Mouse)animals[i]).moveTo(event.getX(), event.getY());
			((Cat)animals[0]).moveTo((Mouse)animals[1]);
			return true;
		}

	@Override
	public void onProgressChanged(SeekBar seekBar, int i, boolean b)
	{

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar)
	{

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar)
	{

	}
}

