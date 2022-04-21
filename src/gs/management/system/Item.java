/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.management.system;

/**
 *
 * @author MUJTABA R0Y
 */
public class Item {
    public MyDBConnection con;
    private ItemDAO itemdao;
    private int id;
    private String name;
    private int quantity;
    private double price;
    public Item()
    {
        con=new MyDBConnection();
        con.init();
    }

    public Item(String Name,int Quantity,double Price) {
        itemdao = new ItemDAO();
        con=new MyDBConnection();
        this.name = Name;
        this.quantity = Quantity;
        this.price = Price;
    }
    public Item(int Id,String Name,int Quantity,double Price) {
        itemdao = new ItemDAO();
        this.id=Id;
        this.name = Name;
        this.quantity = Quantity;
        this.price = Price;
    }
    public Item(int Id) {
        itemdao = new ItemDAO();
        this.id=Id;
    }

    
   
    
    public ItemDAO getItemdao() {
        return itemdao;
    }

    public void setItemdao(ItemDAO itemdao) {
        this.itemdao = itemdao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void saveRecord(Item sel) {
        itemdao.saveRecord(sel);
    }

    public void updateRecord(Item sel) {
        itemdao.updateRecord(sel);
    }

     public void deleteItem() {
         
         
         
        con.deleteRecord("delete from itemtable where ItemID="+this.getId());
    }
    public Item getRecord(int id) {
        return itemdao.getRecord(id);
    }

}
