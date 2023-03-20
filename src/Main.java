import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        List<String> products = new ArrayList<>();
        while (true) {
            try {
                System.out.println();
                System.out.println("Chose operation: \n1. add, 2. show, 3. delete, 4. find\n(else \"end\" for exit)");
                String line = scanner.nextLine();
                if ("end".equals(line)) {
                    break;
                }
                int choice = Integer.parseInt(line);
                System.out.println();
                switch (choice) {
                    case 1:
                        addList(scanner, products);
//                        System.out.println(products);
                        break;
                    case 2:
                        printList(products);
                        break;
                    case 3:
                        if (printList(products) == null) continue;
                        removeList(scanner, products);
                        printList(products);
                        break;
                    case 4:
                        if (products.isEmpty()) {
                            System.out.println("List empty.");
                            continue;
                        }
                        findList(scanner, products);
                        break;
                    default:
                        System.out.println("Such operation \"" + choice + "\" no. Chose from 1 to 4");
                        System.out.println();
                }
            } catch (NumberFormatException exception) {
                System.out.println("Need to enter from 1 to 4");
            }
        }
        System.out.println();
        System.out.println("Finally in list: " + products.size());
        printList(products);
    }

    private static void addList(Scanner scanner, List<String> products) {
        System.out.println("what ?");
        System.out.println("What kind of purchase to add?");
        products.add(scanner.nextLine());
        System.out.println("Finaly in lis: " + products.size());
    }

    public static <T> T printList(List<T> products) {
        if (products.isEmpty()) {
            System.out.println("List empty.");
            return null;
        }
        System.out.println("List of purchase: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        return (T) products;
    }

    private static void removeList(Scanner scanner, List<String> products) {
        String line;
        System.out.println("wan to delete? enter number or name");
        line = scanner.nextLine();
        try { // проверка номера
            int indexProduct = Integer.parseInt(line) - 1;
            if ((indexProduct >= 0) & (indexProduct < products.size())) {
                System.out.print("Purchase \"" + products.get(indexProduct) + "\" deleted. ");
                products.remove(indexProduct);
            } else System.out.printf("No purchase with number \"%d\". ", (indexProduct + 1));
        } catch (NumberFormatException e) {
            if (products.contains(line)) {
                products.remove(line);
                System.out.printf("Purchase \"%s\" deleted. ", line);
            } else System.out.printf("in list no purchase \"%s\". ", line);
        }
    }

    private static void findList(Scanner scanner, List<String> products) {
        System.out.println("enter umber for search:");
        String queryLower = (scanner.nextLine()).toLowerCase();
        System.out.println("Found:");
        for (int i = 0; i < products.size(); i++) {
            String itemLower = (products.get(i)).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }
}