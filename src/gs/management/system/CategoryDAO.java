/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.management.system;

import java.sql.ResultSet;

/**
 *
 * @author MUJTABA R0Y
 */
public class CategoryDAO {
    private final MyDBConnection connection;

    public CategoryDAO() {
        connection = new MyDBConnection();
        connection.init();
    }

    public void saveRecord(Category sel) {
        String status = connection.insertRecord("Insert into categorytable(CatName,CatDescription) values" + "('" + sel.getName() + "', '" + sel.getDescription()+"')");
        System.out.println(status);
    }

    public void updateRecord(Category sel) {
        connection.updateRecord("UPDATE `categorytable` SET `CatName` = '"+sel.getName()+"',`CatDescription` = '"+sel.getDescription()+"' WHERE `categorytable`.`CatID` = '"+sel.getId()+"'");
    }

    public void deleteCategory(Item item) {
        connection.deleteRecord("Delete from product where Id=" + item.getId());
    }

    public Category getRecord(int id) {
        ResultSet rs = connection.getRecord("Select*from product where id=" + id);
        Category category = new Category();
        try {
            while (rs.next()) {
                category.setId(rs.getInt("Id"));
                category.setName(rs.getString("Name"));
                category.setDescription(rs.getString("Description"));
               

            }
            return category;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
