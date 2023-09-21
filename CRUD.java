import java.util.Scanner; 

public class CRUD {

  public static String[] arrayList = new String[10];
  public static int size = 0;

  public static void displayMenuList() { 
    System.out.println("------SELECT MENU--------");
    System.out.println("1. Add data");
    System.out.println("2. Update data");
    System.out.println("3. Delete Data");
    System.out.println("4. List data");
    System.out.println("5. Exit");
    System.out.println("------SELECT MENU--------");
  }

  public static int userChoice(Scanner scan) {
     int menu;

     System.out.print("Select menu: ");
     menu = scan.nextInt();

     return menu;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
  
  public static void addData(String data) {
    arrayList[size + 1] = data;
    size++;
  }

  public static void updateData(int index, String updatedData) {
    if(size == 0) {
      System.out.println("Array list is empty");
      return;
    }


    if(index < 0 || index > arrayList.length) {
      System.out.print("Invalid index to update");
      return;
    }

    arrayList[index] = updatedData;

    System.out.println("Successfully updated");
  }

  public static void deleteData(int index) {
    if (index >= 0 && index < arrayList.length) {
            // make a array copy
            String[] newArray = new String[arrayList.length - 1];
            for (int i = 0, newIndex = 0; i < arrayList.length; i++) {
                if (i != index) {
                    newArray[newIndex] = arrayList[i];
                    newIndex++;
                }
            }

            arrayList = newArray;
            size--;
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Invalid index.");
        }
  }

  public static void displayAllData () {
    System.out.println("--------------LIST ARRAY DATA-------------");

    for(int i = 0; i < size; i++) {
        int sizeCount = i + 1;
        System.out.println(sizeCount + ". " + arrayList[i + 1]);
    }
  }

  public static void isRedirectMenu(Scanner scan) {
    String exit = "";

    System.out.print("type any key to exit: ");
    scan.nextLine();
    exit = scan.nextLine();

    if(exit.trim().isEmpty()) {
      clearScreen();
    }
  }

  public static void menuList(int menu, Scanner scan) {
    switch(menu) {
      case 1:
          String newData = "";
          System.out.print("Add data: ");
          scan.nextLine();
          newData = scan.nextLine();

          if(!newData.trim().isEmpty()) {
            addData(newData); 
          }

          isRedirectMenu(scan);
      break;
      case 2:
        int indexToUpdated;
        String updatedData = "";

        System.out.print("Search index to delete: ");
        indexToUpdated = scan.nextInt();

        System.out.print("New data: ");
        scan.nextLine();
        updatedData = scan.nextLine();

        if(indexToUpdated > 0 && !updatedData.trim().isEmpty()) {
          updateData(indexToUpdated, updatedData);
          isRedirectMenu(scan);
        } else {
          System.out.println("index can't be 0 or less than 0.");
        }
      break;
      case 3:
        int indexToDelete;

        System.out.print("Search index to delete: ");
        indexToDelete = scan.nextInt();

        if(indexToDelete >= 0) {
          deleteData(indexToDelete);
          isRedirectMenu(scan);
        } else {
          System.out.println("index can't be 0 or less than 0.");
        }
      break;
      case 4:
        displayAllData();
        isRedirectMenu(scan);
      break;
      case 5:
        System.exit(0);
      break;
      default:
        System.out.println("wrong key please try again!"); 
      break;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while(true) {
      displayMenuList();
      int choices = userChoice(scan);  

      menuList(choices, scan);
    }
  }
}
