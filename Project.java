import java.io.*;
import java.util.*;
import java.sql.*;

public class Project {
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    
    //Connect to Database
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    System.out.println();
    System.out.println("JDBC driver loaded.");
    
    //Connection with information to get to database
    //THIS NEEDS TO BE MODIFIED!!!!!!!!!!!!!!!!!!!!!!!!!
    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");

    if (args[0].equals("/?")) {
      printUsage();
    }
    
    else if (args[0].equals("CreateItem") && args.length == 4) {
      //method goes in here
    }
    
    else if (args[0].equals("CreatePurchase") && args.length == 3) {
      //method goes in here
    }
    
    else if (args[0].equals("CreateShipment") && args.length == 4) {
      //method goes in here
    }
    
    else if (args[0].equals("GetItems") && args.length == 2) {
      //method goes in here
    }
    
    else if (args[0].equals("GetShipments") && args.length == 2) {
      //method goes in here
    }
    
    else if (args[0].equals("GetPurchases") && args.length == 2) {
      //method goes in here
    }
    
    else if (args[0].equals("ItemsAvailable") && args.length == 2) {
      //method goes in here
    }
    
    else if (args[0].equals("UpdateItem") && args.length == 3) {
      //method goes in here
    }
    
    else if (args[0].equals("DeleteItem") && args.length == 2) {
      //method goes in here
    }
    
    else if (args[0].equals("DeleteShipment") && args.length == 2) {
      //method goes in here
    }
    
    else if (args[0].equals("DeletePurchase") && args.length == 2) {
      //method goes in here
    }
    
    else {
      printUsage();
    }
    
  }
  
//connection method for the database
public static void getConnection(String port, String database, String password) { 

Connection connect = null;

try {

connect = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/test?verifyServerCertificate=false&useSSL=true", "msandbox", password);

System.out.println("Database" + database + " connection succeeded!! :~)");
System.out.println();

} 

catch (SQLException exception) {
System.err.println("SQLException: " + exception.getMessage());
System.err.println("SQLState: " + exception.getSQLState());
System.err.println("VendorError: " + exception.getErrorCode());
}
  
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
