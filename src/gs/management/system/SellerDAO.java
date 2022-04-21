/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.management.system;

import java.sql.ResultSet;
import static sun.misc.MessageUtils.where;

/**
 *
 * @author MUJTABA R0Y
 */
public class SellerDAO {
    private final MyDBConnection connection;

    public SellerDAO() {
        connection = new MyDBConnection();
        connection.init();
    }

    public void saveRecord(Seller sel) {
        String status = connection.insertRecord("Insert into sellertable(SellerName,SellerPassword,SellerGender) values" + "('" + sel.getName() + "', '" + sel.getPassword() + "', '" + sel.getGender() + "')");
        System.out.println(status);
    }

    public void updateRecord(Seller sel) {
        connection.updateRecord("UPDATE `sellertable` SET `SellerName` = '"+sel.getName()+"',`SellerPassword` = '"+sel.getPassword()+"', `SellerGender` = '"+sel.getGender()+"' WHERE `sellertable`.`SellerID` = '"+sel.getId()+"'");
    }

    public void deleteSeller(Item item) {
        connection.deleteRecord("Delete from product where Id=" + item.getId());
    }

    public Seller getRecord(int id) {
        ResultSet rs = connection.getRecord("Select*from product where id=" + id);
        Seller seller = new Seller();
        try {
            while (rs.next()) {
                seller.setId(rs.getInt("Id"));
                seller.setName(rs.getString("Name"));
                seller.setPassword(rs.getString("Password"));
                seller.setGender(rs.getString("Gender"));

            }
            return seller;
        } catch (Exception ex) {
            return null;
        }
    }
    
}
