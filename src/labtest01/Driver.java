package labtest01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class with a driver program and some 
 * sample items and inventories.
 */
public final class Driver
{
	private static final Item ITEM_CEREAL = new Item("Cereal", 1, 200);
	private static final Item ITEM_JAM = new Item("Jam", 2, 400);
	private static final Item ITEM_BUTTER = new Item("Butter", 3, 250);
	
	private static final Item[] ITEMS = { ITEM_CEREAL, ITEM_JAM, ITEM_BUTTER };
	
	private Driver() {}
	
	/**
	 * @param pArgs Not used
	 */
	public static void main(String[] pArgs)
	{
		Inventory lInventory = new Inventory("Test");
		
		List<Item> lItems = new ArrayList<Item>();
		for (int i = 0; i < ITEMS.length; i++)
		{
			lItems.add(ITEMS[i]);
		}
		Collections.sort(lItems, Item.getItemByPriceComparator());
		for( Item item : lItems )
		{
			System.out.println(item.getName());
			lInventory.stock(item, 4);
		}
		System.out.println("Total number of goods in inventory " + lInventory.totalValue());
		Item notIn = new Item("Milk", 4, 300);
//		lInventory.dispose(notIn, 1);
		lInventory.dispose(ITEM_CEREAL, 5);
	}
}
