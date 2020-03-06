package com.mycompany.app;
import java.util.Arrays;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class CustomList<L>
{
	public static final Logger LOGGER=LogManager.getLogger(CustomList.class);
	private Object[] data;
	private int size;
	public int index=0;
	public CustomList() throws Exception{
		this(10);
	}
	public CustomList(int capacity) throws Exception
	{
		if(capacity>0)
			this.data=new Object[capacity];
		else if(capacity==0)
			this.data=new Object[10];
		else
			throw new Exception("Illegal Capacity:"+capacity);
	}
	public void insertElement(L element)
	{
		checkCapacity();
		data[size++]=element;
	}
	private void checkCapacity()
	{
		if(data.length<=size)
		{
			int previousCapacity=data.length;
			int presentCapacity=(previousCapacity*3)/2+1;
			data=Arrays.copyOf(data,presentCapacity);	
		}
	}
	public L fetchElement(int index) throws Exception
	{
		if(index>=size)
		{
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (L)data[index];
	}
	public boolean remove(L obj) throws Exception
	{
		int i=indexOf(obj);
		if(i>=0)
		{
			removeElement(i);
			return true;
		}
		return false;
	}
	public L removeElement(int index) throws Exception
	{
		if(index>=size)
			throw new ArrayIndexOutOfBoundsException(index);
		L previousValue=(L)data[index];
		int numMoved=size-index-1;
		if(numMoved>0)
		    System.arraycopy(data, index+1,data,index,numMoved);
		data[--size]=null;
		return previousValue;
	}
	public int indexOf(Object o) 
	{			
		return indexOf(o,0);		
	}
	public int indexOf(Object o,int index)
	{
		if(o==null)
		{
			for(int i=index;i<size;i++)
			{
				if(data[i]==null)
					return i;
			}
		}
		else
		{
			for(int i=index;i<size;i++)
			{
				if(o.equals(data[i]))
					return i;
			}
		}
		return -1;
	}
	public void display()
	{
		LOGGER.info("The elements in Array list are:");
		for(int i=0;i<size;i++)
			LOGGER.info(data[i]+" ");
		LOGGER.info("\n");
	}
}