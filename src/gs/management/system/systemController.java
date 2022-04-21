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
public class systemController {
      private Item item;
      private Seller seller;
      private Category category;
    public systemController()
    {
        item=new Item();
        seller=new Seller();
        
    }
    /* Item      */

    public Item getItem(int id)
    {
        item.getRecord(id);
        return item;
    }
    public void addNewItem(String Name,int quantity,double price)
    {
        item=new Item(Name,quantity,price);
        item.saveRecord(item);
    }
    public void removeItem(int id)
    {
        /**item.deleteProduct();*/
    }
    /* Seller */
    public Seller getSeller(int id)
    {
        seller.getRecord(id);
        return seller;
    }
    public void addNewSeller(String Name,String Password,String Gender)
    {
        seller=new Seller(Name,Password,Gender);
        seller.saveRecord(seller);
    }
    public void updateSeller(int Id,String Name,String Password,String Gender)
    {
        seller=new Seller(Id,Name,Password,Gender);
        seller.updateRecord(seller);
    }
    public void removeSeller(int id)
    {
        seller.setId(id);
        seller.deleteSeller();
    }
     /* Category */
    public Category getCategory(int id)
    {
        category.getRecord(id);
        return category;
    }
    public void addNewCategory(String Name,String Description)
    {
        category=new Category(Name,Description);
        category.saveRecord(category);
    }
    public void updateCategory(int Id,String Name,String Description)
    {
        category=new Category(Id,Name,Description);
        category.updateRecord(category);
    }
    public void removeCategory(int id)
    {
        category.setId(id);
        category.deleteCategory();
    }
    
 
    
}
