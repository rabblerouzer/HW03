package pricewatcher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemManagerTest {
	private ItemManager itemManager = new ItemManager();
	@BeforeEach
	void setUp() {
		itemManager = new ItemManager();
	}
	@Test
	void testItemManager() {
		
		assertEquals(0, itemManager.size());
	}
	@Test
	void testAddItem() {
		Item item = itemManager.addItem("TV","someurl", 200);
		
		assertEquals(1, itemManager.size());
		assertEquals("TV", item.name);
		assertEquals("someurl", item.url);
		assertEquals(200, item.currentPrice);
	}
	@Test
	void testDeleteItem() {
		Item item = itemManager.addItem("TV","someurl", 200);
		int size = itemManager.size();
		itemManager.deleteItem(item);
		assertEquals(size - 1, itemManager.size());
		assertEquals("TV", item.name);
		assertEquals("someurl", item.url);
		assertEquals(200, item.currentPrice);
	}

}
