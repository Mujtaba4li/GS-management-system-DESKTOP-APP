/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gs.management.system;
import java.sql.*;
import static org.apache.derby.iapi.store.raw.ContainerLock.CX;
/**
 *
 * @author MUJTABA R0Y
 */
public class Seller {
    public MyDBConnection con;
    private SellerDAO sellerdao;
    private int id;
    private String name;
    private String password;
    private String gender;
    public Seller()
    {
        con=new MyDBConnection();
        con.init();
    }

    public Seller(String Name,String Password,String Gender) {
        sellerdao = new SellerDAO();
        con=new MyDBConnection();
        this.name = Name;
        this.password = Password;
        this.gender = Gender;
    }
    public Seller(int Id,String Name,String Password,String Gender) {
        sellerdao = new SellerDAO();
        this.id=Id;
        this.name = Name;
        this.password = Password;
        this.gender = Gender;
    }
    public Seller(int Id) {
        sellerdao = new SellerDAO();
        this.id=Id;
    }

    
   
    
    public SellerDAO getSellerdao() {
        return sellerdao;
    }

    public void setSellerdao(SellerDAO sellerdao) {
        this.sellerdao = sellerdao;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void saveRecord(Seller sel) {
        sellerdao.saveRecord(sel);
    }

    public void updateRecord(Seller sel) {
        sellerdao.updateRecord(sel);
    }

     public void deleteSeller() {
    
        con.deleteRecord("delete from sellertable where SellerID="+this.getId());
    }
    public Seller getRecord(int id) {
        return sellerdao.getRecord(id);
    }

    
}
