package com.weicheng.po;

import java.util.List;

public class MOrder extends Order{

	/**��Ʒ�б�*/
	private List<Item> itemList;

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
}
