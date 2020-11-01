package com.bawa.projectmanaement.dto;


public class OrderDTO {

    private String itemName;
    public OrderDTO() {
		super();
	}
	public OrderDTO(String itemName, Long quantity) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	private Long quantity;
    
}