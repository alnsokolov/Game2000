package itschool.samsung.ru.game;
public class Vector 
{
	Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector(Vector v)
	{
		x = v.x;
		y = v.y;
	}
	
	Vector()
	{
		this.x = 0;
		this.y = 0;
	}
	
	float x, y;
		
	void Print()
	{
		System.out.println("("+x + "," + y+")");
	}
	
	void Mult(float k)
	{
		x *= k;
		y *= k;
	}
	
	void Set(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public String toString()
	{
		return "("+x + "," + y+")";
	}
	
	public void Sum(Vector v)
	{
		x += v.x;
		y += v.y;
	}
	
	public void Sub(Vector v)
	{
		x -= v.x;
		y -= v.y;
	}
}
