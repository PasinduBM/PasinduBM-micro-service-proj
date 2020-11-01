package com.bawa.projectmanaement.domain;




import javax.persistence.*;


@Entity
public class CustomerOrder {
    
    public CustomerOrder() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public CustomerOrder(Long id, String itemName, Long quantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	@Id
    @GeneratedValue
    private Long id;

    @Column(updatable = false)
    private String itemName;
    @Column(updatable = false)
    private Long quantity;


    
}
