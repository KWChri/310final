import java.io.*;
import java.util.*;
import java.sql.*;

public class Project {
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
