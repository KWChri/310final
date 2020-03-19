import java.io.*;
import java.util.*;
import java.sql.*;

public class Project {
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
  
  public static void CreateItem (String itemCode, String itemDescription, String price) {
    
  }
  
  public static void CreatePurchase (String itemCode, int purchaseQuantity) {
    
  }
  
  public static void CreateShipment (String itemCode, int shipmentQuantity, date shipmentDate) {
    
  }
  
  public static void GetItems (String itemCode) {
    
  }
  
  public static void GetShipments (String itemCode) {
    
  }
  
  public static void GetPurchases (String itemCode) {
    
  }
  
  public static void ItemsAvailable (String itemcCode) {
    
  }
  
  public static void UpdateItem (String itemCode, String price) {
    
  }
  
  public static void DeleteItem (String itemCode) {
    
  }
  
  public static void DeleteShipment (String itemCode) {
    
  }
  
  public static void DeletePurchase (String itemCode) {
    
  }
  
  public static void printUsage() {
    System.out.println("java Project /?");
    System.out.println("java Project CreateItem <itemCode> <itemDescription> <price>");
    System.out.println("java Project CreatePurchase <itemCode> <PurchaseQuantity>");
    System.out.println("java Project CreateShipment <itemCode> <ShipmentQuantity> <shipmentDate>");
    System.out.println("java Project GetItems <itemCode>");
    System.out.println("java Project GetShipments <itemCode>");
    System.out.println("java Project GetPurchases <itemCode>");
    System.out.println("java Project ItemsAvailable <itemCode>"); //most complext requirement
    System.out.println("java Project UpdateItem <itemCode> <price>");
    System.out.println("java Project DeleteItem <itemCode>");
    System.out.println("java Project DeleteShipment <itemCode>");
    System.out.println("java Project DeletePurchase <itemCode>");
    
  }
  
 
}
