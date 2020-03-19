import java.io.*;
import java.util.*;
import java.sql.*;

public class Project {
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
  
  //Method that creates the item
  public static void CreateItem (String itemCode, String itemDescription, String price) {
    
  }
  
  //Method the creates the purchase
  public static void CreatePurchase (String itemCode, int purchaseQuantity) {
    
  }
  
  //Method that creates the shipment
  public static void CreateShipment (String itemCode, int shipmentQuantity, date shipmentDate) {
    
  }
  
  //Method that gets the items
  public static void GetItems (String itemCode) {
    
  }
  
  //Method that gets the shipments
  public static void GetShipments (String itemCode) {
    
  }
  
  //Method that gets the purchases
  public static void GetPurchases (String itemCode) {
    
  }
  
  //Method that shows the items that are available
  public static void ItemsAvailable (String itemcCode) {
    
  }
  
  //Method that updates an item
  public static void UpdateItem (String itemCode, String price) {
    
  }
  
  //Method that deletes an item
  public static void DeleteItem (String itemCode) {
    
  }
  
  //Method that deletes a shipment
  public static void DeleteShipment (String itemCode) {
    
  }
  
  //Method that deletes a purchase
  public static void DeletePurchase (String itemCode) {
    
  }
  
  //Prints the usage of the program
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
