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
public class ItemDAO{
private final MyDBConnection connection;

    public ItemDAO() {
        connection = new MyDBConnection();
        connection.init();
    }

    public void saveRecord(Item item) {
        String status = connection.insertRecord("Insert into itemtable(ItemName,ItemQuantity,ItemPrice) values" + "('" + item.getName() + "', '" + item.getPrice() + "', '" + item.getQuantity() + "')");
        System.out.println(status);
    }

    public void updateRecord(Item item) {
        connection.updateRecord("UPDATE `itemtable` SET `ItemName` = '"+item.getName()+"',`ItemPassword` = '"+item+"', `ItemGender` = '"+item+"' WHERE `itemtable`.`ItemID` = '"+item.getId()+"'");
    }

    public void deleteItem(Item item) {
        connection.deleteRecord("Delete from product where Id=" + item.getId());
    }

    public Item getRecord(int id) {
        ResultSet rs = connection.getRecord("Select*from product where id=" + id);
        Item item = new Item();
        try {
            while (rs.next()) {
                item.setId(rs.getInt("Id"));
                item.setName(rs.getString("Name"));
              

            }
            return item;
        } catch (Exception ex) {
            return null;
        }
    }
}