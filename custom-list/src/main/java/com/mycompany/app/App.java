package com.mycompany.app;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
public class App 
{
	private static final Logger LOGGER=LogManager.getLogger(App.class);
	static Scanner s=new Scanner(System.in);
    public static void main(String[] args) throws Exception
    {
        CustomList<Integer> list=new CustomList<Integer>(5);
        int choice,element,position;
        while(true)
        {
        	LOGGER.info("Choose an option from below:\n1.Add element\n2.Fetch element\n3.Remove element\n4.Display elements\n5.Exit");
        	choice=s.nextInt();
        	switch(choice)
        	{
        	case 1:
        		LOGGER.info("Enter an element to insert");
        		element=s.nextInt();
        		list.insertElement(element);
        		break;
        	case 2:
        		LOGGER.info("Enter an index of element to fetch");
        		position=s.nextInt();
        		element=list.fetchElement(position);
        		LOGGER.info("\nThe element at position"+position+"is"+element+"\n");
        		break;
        	case 3:
        		LOGGER.info("Enter an element to be removed:");
        		element=s.nextInt();
        		if(list.remove(element))
        		{
        			LOGGER.info("Element has been deleted successfully");
        		}
        		else
        		{
        			LOGGER.info("Element is not found in the list");
        		}
        		break;
        	case 4:
        		list.display();
        	case 5:
        		System.exit(0);
        	default:
        		LOGGER.info("INVALID CHOICE!");
        	}
        }
    }
}
