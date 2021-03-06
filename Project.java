import java.io.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.sql.SQLException;
  
  
public class Project {
    
  public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
    
    if (args.length == 0)
    {
      printUsage();
    }
    //Connect to Database
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println();
    System.out.println("JDBC driver loaded.");
    
    //Connection with information to get to database
    //THIS NEEDS TO BE MODIFIED!!!!!!!!!!!!!!!!!!!!!!!!!

    if (args[0].equals("/?")) {
      printUsage();
    }
    
    else if (args[0].equals("CreateItem") && args.length == 4) {
      CreateItem(args[1], args[2], Double.parseDouble(args[3]));
    }
    
    else if (args[0].equals("CreatePurchase") && args.length == 3) {
      CreatePurchase(args[1], Integer.parseInt(args[2]));
    }
    
    else if (args[0].equals("CreateShipment") && args.length == 4) {
      CreateShipment(args[1], Integer.parseInt(args[2]), Date.valueOf(args[3]));
    }
    
    else if (args[0].equals("GetItems") && args.length == 2) {
      GetItems(args[1]);
    }
    
    else if (args[0].equals("GetShipments") && args.length == 2) {
      GetShipments(args[1]);
    }
    
    else if (args[0].equals("GetPurchases") && args.length == 2) {
      GetPurchases(args[1]);
    }
    
    else if (args[0].equals("ItemsAvailable") && args.length == 2) {
      ItemsAvailable(args[1]);
    }
    
    else if (args[0].equals("UpdateItem") && args.length == 3) {
      UpdateItem(args[1], args[2]);
    }
    
    else if (args[0].equals("DeleteItem") && args.length == 2) {
      DeleteItem(args[1]);
    }
    
    else if (args[0].equals("DeleteShipment") && args.length == 2) {
      DeleteShipment(args[1]);
    }
    
    else if (args[0].equals("DeletePurchase") && args.length == 2) {
      DeletePurchase(args[1]);
    }
    
    else {
      printUsage();
    }
    
  }
  
//connection method for the database
public static Connection getConnection(String port, String database, String password) { 

Connection connect = null;

  try {
    connect = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/test?verifyServerCertificate=false&useSSL=true", "msandbox", password);

    System.out.println("Database " + database + " connection succeeded!! :~)");
    System.out.println();
  } 

  catch (SQLException exception) {
    System.err.println("SQLException: " + exception.getMessage());
    System.err.println("SQLState: " + exception.getSQLState());
    System.err.println("VendorError: " + exception.getErrorCode());
  }
  return connect;
}  

private static Statement stmt = null;
private static Statement stmt2 = null;
private static ResultSet resultset = null;

  //Method that creates the item
  public static void CreateItem (String itemCode, String itemDescription, double price) {
    
    String query = "CALL finalProject.CreateItem('" + itemCode + "', '" + itemDescription + "'," + price + ");";    
    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
    
    try {

     stmt = connect.createStatement();
     resultset = stmt.executeQuery(query);
     
     System.out.println();
     System.out.println("Item " + itemCode + " created.");
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
      
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
      
    }
    
  } //end of createItem method
  
  //Method the creates the purchase
  public static void CreatePurchase (String itemCode, int purchaseQuantity) {
      
      String query = "CALL finalProject.CreatePurchase('" + itemCode + "', " + purchaseQuantity + ")";
      Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");

    try {

      connect.setAutoCommit(false);
      stmt = connect.createStatement();
      resultset = stmt.executeQuery(query);

      System.out.println();
      System.out.println("Purchase " + itemCode + " created.");

    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
      
    }
    try {
      connect.setAutoCommit(true);
      connect.close();
    }
    catch (SQLException sqlEx) {

    }
  }
  
  //Method that creates the shipment
  public static void CreateShipment (String itemCode, int shipmentQuantity, Date shipmentDate) {
    
    String query = "CALL finalProject.CreateShipment('" + itemCode + "', " + shipmentQuantity + ", '" + shipmentDate + "');";
    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
    try {
     stmt = connect.createStatement();
     resultset = stmt.executeQuery(query);
     
     System.out.println();
     System.out.println("Shipment was successfully created.");
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
      
     //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
      
    } //end of finally clause
    
  } //end of createShipment method
  
  //Method that gets the items
  public static void GetItems (String itemCode) {
    String query = "Select * From finalProject.Item Where Item.ItemCode = " + itemCode;
    String queryWildcard = "SELECT * FROM finalProject.Item";

    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");

    try {
     //insert stuff here 
     connect.setAutoCommit(false);
     stmt = connect.createStatement();
      if (itemCode.equals("%")) {
        resultset = stmt.executeQuery(queryWildcard);
      }
      else {
        resultset = stmt.executeQuery(query);
      }
      getResults(resultset);
     connect.commit();
     
}
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
    }
  }
  
  //Method that gets the shipments
  public static void GetShipments (String itemCode) {
    
    String query_1 = "SELECT * FROM finalProject.Shipment;";
    String query_2 = "SELECT * FROM finalProject.Shipment JOIN Item ON Shipment.ItemID = Item.ID WHERE Item.ItemCode = '" + itemCode + "';";
    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");

    try {
     stmt = connect.createStatement();
      
      //if itemCode equals to "%"
      if (itemCode.equals("%")) {
        resultset = stmt.executeQuery(query_1);
      }
      
      else {
        resultset = stmt.executeQuery(query_2);
      }  
      
      //prints the result set
      getResults(resultset);
      
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
	    
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
    }
	  
  }
  
  //Method that gets the purchases
  public static void GetPurchases (String itemCode) {
    String query = "Select * From finalProject.Purchase Where Purchase.ItemID = " + itemCode;
    String queryWildcard = "SELECT * FROM finalProject.Purchase";

    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");

    try {
     connect.setAutoCommit(false);
     stmt = connect.createStatement();
      if (itemCode.equals("%")) {
        resultset = stmt.executeQuery(queryWildcard);
      }
      else {
        resultset = stmt.executeQuery(query);
      }
      getResults(resultset);
      connect.commit();
     
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
    }
   
  }
  
  //Method that shows the items that are available
  public static void ItemsAvailable (String itemCode) {
	  
	 String query = "CALL finalProject.ItemsAvailable('" + itemCode + "');";
    
    try {
	    
     	 Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
         stmt = connect.createStatement();
	    
    	 resultset = stmt.executeQuery(query);
	    
	 System.out.println("ItemCode:\tItemDescription:\tAvilableItems\n");
	 
	 resultset.beforeFirst();
	    
	 while (resultset.next()) {
	      System.out.println(resultset.getString(1) + ":\t\t" + resultset.getString(2) + ":\t\t" + resultset.getInt(3));
	 }
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
	    
    //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
    }
  } //end of method
  
  //Method that updates an item
  public static void UpdateItem (String itemCode, String price) {
    
    Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
    String query = "Call finalProject.UpdateItem('" + itemCode + "', '" + price + "')";
    try {
      connect.setAutoCommit(false);
      stmt = connect.createStatement();
      resultset = stmt.executeQuery(query);
      connect.commit();

      System.out.println();
      System.out.println("Item was successfully updated");
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
      
    }
    try {
    connect.setAutoCommit(true);
    connect.close();
    }
    catch (SQLException sqlEx) {

    }
  }
  
  //Method that deletes an item
  public static void DeleteItem (String itemCode) {
	  
	 String query = "CALL finalProject.DeleteItem('" + itemCode + "');";
   	 Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
    
    try {
       stmt = connect.createStatement();
    	 resultset = stmt.executeQuery(query);
	    
	 System.out.println();
	 System.out.println("Item " + itemCode + " was deleted.");
    }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
	    
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }    
    } //end of finally clause
  } //end of method
  
  //Method that deletes a shipment
  public static void DeleteShipment (String itemCode) {
      String query = "CALL finalProject.DeleteShipment('" + itemCode + "');";
    
      Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
     
     try {
	     stmt = connect.createStatement();
         resultset = stmt.executeQuery(query);

         System.out.println();
         System.out.println("Shipment " + itemCode + " was deleted.");  
     }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
	    
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
    }
  }
  
  //Method that deletes a purchase
  public static void DeletePurchase (String itemCode) {
	  
     String query = "CALL finalProject.DeletePurchase('" + itemCode + "');";
    
     Connection connect = getConnection("55926", "finalProject", "5eu23rk4yl33");
     
     try {
	 stmt = connect.createStatement();
         resultset = stmt.executeQuery(query);

         System.out.println();
         System.out.println("Purchase " + itemCode + " was deleted.");  
     }
    
    catch (SQLException exception) {
      System.err.println("SQLException: " + exception.getMessage());
      System.err.println("SQLState: " + exception.getSQLState());
      System.err.println("VendorError: " + exception.getErrorCode()); 
    }
    
    finally {
	    
      //if the statement DOES NOT equate to NULL
      if (stmt != null) {
        try {
          stmt.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        }
        
        //sets stmt to null
        stmt = null;
      }
      
      //if the result set DOES NOT equate to NULL
      if (resultset != null) {
        try {
          resultset.close();
        }
        catch (SQLException sqlEx) {
          //ignore this
        } 
        
        //sets resultset to null
        resultset = null;
      }
    } //end of finally clause
  } //end of method
  
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
    System.exit(0);
  }
  
  //Use result sets (tables) to navigate through the results
  private static void getResults(ResultSet resultset) throws SQLException {
   
    ResultSetMetaData rsmd = resultset.getMetaData();

    int columnsNumber = rsmd.getColumnCount();
    
    while (resultset.next()) {
          
	for (int i = 1; i <= columnsNumber; i++) {
		if (i > 1) {
		   System.out.print(",  ");
		}
            
		String columnValue = resultset.getString(i);
		System.out.print(columnValue + " " + rsmd.getColumnName(i));
	}
	    
	System.out.println(" ");
    }
}
}
