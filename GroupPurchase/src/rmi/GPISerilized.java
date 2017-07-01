package rmi;

import assignment3.GroupPurchaseItem;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * GroupPurchaseItem 的可序列化版本，用于解决GroupPurchaseItem不可序列化的问题
 * 所做的事情就是把GroupPurchaseItem里面的所有字段值复刻一遍
 * @author luMinO
 *
 */
public class GPISerilized implements Serializable{
	private String id;
	private String introduction;
	private int limit;
	private double price;
	private String productName;
	private String seller;
	
	public GPISerilized(GroupPurchaseItem item){
		id = item.getId();
		introduction = item.getIntroduction();
		limit = item.getLimit();
		price = item.getPrice();
		productName = item.getProductName();
		seller = item.getSeller();
		
	}

	public GroupPurchaseItem deserilize() {
		GroupPurchaseItem item = new GroupPurchaseItem();

		item.setId(id);
		item.setIntroduction(introduction);
		item.setLimit(limit);
		item.setPrice(price);
		item.setProductName(productName);
		item.setSeller(seller);
		
		return item;
	}

	public static List<GroupPurchaseItem> deserilizeInList(List<GPISerilized> serilizedList){
		List<GroupPurchaseItem> list = new LinkedList<GroupPurchaseItem>();
		
		for( GPISerilized g: serilizedList ){
			list.add(g.deserilize());
		}
		
		return list;
	}
	
	public static List<GPISerilized> serilizeInList(List<GroupPurchaseItem> originList){
		List<GPISerilized> list = new LinkedList<GPISerilized>();
		
		for( GroupPurchaseItem g: originList ){
			list.add(new GPISerilized(g));
		}
		
		return list;
	}
}
