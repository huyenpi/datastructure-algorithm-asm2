/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class Main {

    public static String showMenu() {

        String menu = "\n\tChoose one of this options:"
                + "\nProduct list:"
                + "\n1. Load data from file and display"
                + "\n2. Input & add to the end."
                + "\n3. Display data"
                + "\n4. Save product list to file."
                + "\n5. Search by ID"
                + "\n6. Delete by ID"
                + "\n7. Sort by ID."
                + "\n8. Convert to Binary"
                + "\n9. Load to stack and display"
                + "\n10. Load to queue and display."
                + "\n0. Exit";
        System.out.println(menu);
        return menu;
    }

    public static void main(String[] args) {

        MyList<Product> list = new MyList<>();
        OperationToProduct oTP = new OperationToProduct();
        MyStack<Product> stack = new MyStack();
        MyQueue<Product> queue = new MyQueue();
        Scanner scan = new Scanner(System.in);

        //kiểm tra xem đã thực hiện bước 1 hay chưa
        boolean case_1 = false;

        while (true) {

            oTP.writeOutputToFile("console_output.txt", showMenu());

            String input;
            int choice = -1;
            boolean check;
            String typeOfInput = "\\d{1,2}";

            do {
                System.out.print("Input your choice: ");
                input = scan.next();
                check = input.matches(typeOfInput);
                oTP.writeOutputToFile("console_output.txt", "\nInput your choice: " + input);

                if (check) {
                    choice = Integer.parseInt(input);
                }

                if (choice < 0 || choice > 10 || !check) {
                    System.out.println("Nhập sai!");
                    oTP.writeOutputToFile("console_output.txt", "\nNhập sai!");

                }
            } while (choice < 0 || choice > 10);
            //điều kiện dừng vòng lặp
            if (choice == 0) {
                System.out.println("Goodbye!");
                oTP.writeOutputToFile("console_output.txt", "\nGoodbye!");

                break;
            }

            switch (choice) {
                //đọc dữ liệu có sẵn từ file và lưu vào list
                case 1 -> {
                    case_1 = true;

                    oTP.getAllItemsFromFile("data.txt", list);
                    oTP.displayAll(list);
                }
                //nhập thêm 1 sản phẩm vào cuối list
                case 2 -> {

                    oTP.addLast(list);
                }
                //hiển thị các sản phẩm trong list
                case 3 -> {

                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.displayAll(list);
                }
                //lưu list vào file data1
                case 4 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.writeAllItemsToFile("data1.txt", list);
                }
                //tìm kiếm thông tin sản phẩm theo id
                case 5 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.searchById(list);
                }
                //xóa sản phẩm trong danh sách theo id
                case 6 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.deleteById(list);
                }
                //sắp xếp các sản phẩm trong danh sách theo id
                case 7 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.sortById(list);
                }
                //biểu diễn quantity sang hệ nhị phân
                case 8 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    int i = list.head.info.quantity;
                    System.out.print("Quantity=" + i + "(=>");
                    oTP.writeOutputToFile("console_output.txt", "\nQuantity=" + i + "(=>");

                    oTP.convertToBinary(i);
                    System.out.println(")");
                    oTP.writeOutputToFile("console_output.txt", ")");

                }
                //đọc dữ liệu từ data1  lưu vào stack
                case 9 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.getAllItemsFromFile("data1.txt", stack);
                }
                //đọc dữ liệu từ data1 lưu vào queue
                case 10 -> {
                    if (!oTP.check(case_1)) {
                        break;
                    }

                    oTP.getAllItemsFromFile("data1.txt", queue);
                }
            }
        }

    }

}
