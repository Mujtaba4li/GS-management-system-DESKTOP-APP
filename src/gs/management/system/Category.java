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
public class Category {
    public MyDBConnection con;
    private CategoryDAO categorydao;
    private int id;
    private String name;
    private String description;
   
    public Category()
    {
        con=new MyDBConnection();
        con.init();
    }

    public Category(String Name,String Description) {
        categorydao = new CategoryDAO();
        con=new MyDBConnection();
        this.name = Name;
        this.description = Description;
        
    }
    public Category(int Id,String Name,String Description) {
        categorydao = new CategoryDAO();
        this.id=Id;
        this.name = Name;
        this.description = Description;
       
    }
    public Category(int Id) {
        categorydao = new CategoryDAO();
        this.id=Id;
    }

    
   
    
    public CategoryDAO getCategorydao() {
        return categorydao;
    }

    public void setCategorydao(CategoryDAO categorydao) {
        this.categorydao = categorydao;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public void saveRecord(Category cat) {
        categorydao.saveRecord(cat);
    }

    public void updateRecord(Category cat) {
        categorydao.updateRecord(cat);
    }

     public void deleteCategory() {
         
        con.deleteRecord("delete from categorytable where catid="+this.getId());
    }
    public Category getRecord(int id) {
        return categorydao.getRecord(id);
    }

    
}
