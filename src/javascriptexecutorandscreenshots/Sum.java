package javascriptexecutorandscreenshots;

public class Sum {
	
	
	public void add(int x,int y)
	{
		System.out.println("Sum is "+(x+y));
	}
	
	public void add(int x,int y,int z)
	{
		System.out.println("Sum is "+(x+y+z));
	}
	
	public void add(int... a)
	{
		int res=0;
		
		for(int i=0;i<a.length;i++)
		{
			res=res+a[i];
		}
		
		System.out.println("Sum is "+res);
		
	}

}
