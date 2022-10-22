/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationToProduct {

    Scanner scan = new Scanner(System.in);

    //lưu output vào file
    public void writeOutputToFile(String fileName, String s) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName, true);
            fw.write(s);
        } catch (IOException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //kiểm tra đã thực hiện case 1 hay chưa
    public boolean check(boolean case_1) {
        if (!case_1) {
            System.out.println("Chọn chức năng 1 trước");
            writeOutputToFile("console_output.txt", "\nChọn chức năng 1 trước");

        }
        return case_1;
    }

    //Creating and returning a product with info input from keyboard
    public Product createProduct() {

        System.out.print("Input new ID: ");
        String id = scan.next();
        System.out.print("Input Product's Name: ");
        String title = scan.next();
        System.out.print("Input Product's quantity: ");
        int quantity = scan.nextInt();
        System.out.print("Input Product's price: ");
        double price = scan.nextDouble();

        writeOutputToFile("console_output.txt", "\nInput new ID: " + id
                + "\nInput Product's Name: " + title
                + "\nInput Product's quantity: " + quantity
                + "\nInput Product's price: " + price);

        Product newProduct = new Product(id, title, quantity, price);
        return newProduct;
    }

    // chuyển dổi một chuỗi thành một đối tượng
    public Product parse(String line) {
        Product p = new Product();
        String[] params = line.split(",");
        try {
            p.id = params[0];
            p.title = params[1];
            p.quantity = Integer.parseInt(params[2]);
            p.price = Double.parseDouble(params[3]);
        } catch (ArrayIndexOutOfBoundsException ex) {
        } finally {
        }
        return p;
    }

    //Reading all products from the file and insert them to the list at tail.
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        //đọc file, lưu vào list
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fis = new FileInputStream(fileName);

            reader = new InputStreamReader(fis);

            bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                // chuyển đổi chuỗi đọc được từ file thành một đối tượng sản phẩm
                Product p;
                p = parse(line);
                // lưu vào list
                list.addTail(p);
            }
            System.out.println("Successful!");
            writeOutputToFile("console_output.txt", "\nSuccessful!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

//đọc dữ liệu từ file và lưu vào stack
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        //đọc file, lưu vào list
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fis = new FileInputStream(fileName);

            reader = new InputStreamReader(fis);

            bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                // chuyển đổi chuỗi đọc được từ file thành một đối tượng sản phẩm
                Product p;
                p = parse(line);
                // lưu vào list
                stack.push(p);
            }
            while (!(stack.isEmpty())) {
                try {
                    Product p = stack.pop();
                    System.out.println(p);
                    writeOutputToFile("console_output.txt", "\n" + p.toString());

                } catch (Exception ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Successfully!");
            writeOutputToFile("console_output.txt", "\nSuccessful!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //đọc dữ liệu từ file và lưu vào queue
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        //đọc file, lưu vào list
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fis = new FileInputStream(fileName);

            reader = new InputStreamReader(fis);

            bufferedReader = new BufferedReader(reader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                // chuyển đổi chuỗi đọc được từ file thành một đối tượng sản phẩm
                Product p;
                p = parse(line);
                // lưu vào list
                queue.enqueue(p);

            }
            while (!(queue.isEmpty())) {
                try {
                    Product p = queue.dequeue();
                    System.out.println(p);
                    writeOutputToFile("console_output.txt", "\n" + p.toString());

                } catch (Exception ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Successfully!");
            writeOutputToFile("console_output.txt", "\nSuccessful!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //Adding a product to the list, info of the product input from keyboard.
    public void addLast(MyList<Product> list) {
        Product product = createProduct();
        list.addTail(product);
        // list.tail.next = newNode;
        //list.tail = newNode;
    }

    // Printing all prodcuts of the list to console screen
    public void displayAll(MyList<Product> list) {
        System.out.println("\nID | Title |Quantity|Price \n--------------------------");
        writeOutputToFile("console_output.txt", "\nID | Title |Quantity|Price \n--------------------------");

        Node current = list.head;
        while (current != null) {
            System.out.println(current.info);
            writeOutputToFile("console_output.txt", "\n" + current.info.toString());

            current = current.next;
        }
    }

    //ham chuyển đối đối tượng thanh chuỗi
    public String getFileLine(Product p) {
        return p.id + "," + p.title + "," + p.quantity + "," + p.price;
    }

    //Writing all products from the list to the file
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileName);
            Node<Product> current = list.head;
            while (current != null) {
                String line = getFileLine(current.info) + "\n";
                //string to byte[]
                byte[] b = line.getBytes();
                //save
                fos.write(b);
                current = current.next;
            }
            System.out.println("Successfully!");
            writeOutputToFile("console_output.txt", "\nSuccessfully!");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    /**
     *
     * @param list
     */
    //tìm kiếm sản phẩm trong list bằng id
    public void searchById(MyList<Product> list) {
        System.out.print("Input the IDto search: ");
        String searchId = scan.next();
        writeOutputToFile("console_output.txt", "\nInput the IDto search: " + searchId);

        Node<Product> current = list.head;
        boolean check = false;
        while (current != null) {
            if (current.info.id.equals(searchId)) {
                check = true;
                System.out.println("Result: " + current.info);
                writeOutputToFile("console_output.txt", "\nResult: " + current.info.toString());

                break;
            }
            current = current.next;
        }
        if (!check) {
            System.out.println("-1");
            writeOutputToFile("console_output.txt", "\n-1");

        }
    }

    // Deleting first product that has the ID input from keyboard from the list.
    public void deleteById(MyList<Product> list) {
        System.out.print("Input the id to delete: ");
        String deleteId = scan.next();
        writeOutputToFile("console_output.txt", "\nInput the id to delete: " + deleteId);

        boolean check = false;
        Node<Product> current = list.head;
        while (current != null) {
            if (current.info.id.equals(deleteId)) {
                check = true;
                list.deleteElement(current.info);
            }
            current = current.next;
        }
        if (check) {
            System.out.println("Deleted!");
            writeOutputToFile("console_output.txt", "\nDeleted!");

        }
    }


    public void quickSortById(MyList<Product> list) {

        if (list.head == list.tail) {
            return;
        }
        
        Node<Product> pivot;
        Node<Product> p;
        
        //tạo 2 list để chia mảng
        MyList<Product> l1 = new MyList<>();//l1 chứa product có id be hơn id pivot
        MyList<Product> l2 = new MyList<>();//l2 chứa product có id lớn hơn id pivot

        

        pivot = list.head;
        list.head = list.head.next;//cập nhật lại head của list
        pivot.next = null;// cô lập tag
        while (list.head != null) {
            p = list.head;
            list.head = list.head.next;
            p.next = null;
            if (p.info.id.compareToIgnoreCase(pivot.info.id) < 0) {
                l1.addTail(p.info);
            } else {
                l2.addTail(p.info);
            }
        }
        quickSortById(l1);//gọi đệ quy sắp xếp l1
        quickSortById(l2);//sắp xếp l2

        if (l1.head != null) {
            list.head = l1.head;
            l1.tail.next = pivot;
        } else {
            list.head = pivot;
        }
        pivot.next = l2.head;

        if (l2.head != null) {
            list.tail = l2.tail;
        } else {
            list.tail = pivot;
        }

    }

    //Sorting products in linked list by ID
    public void sortById(MyList<Product> list) {
        quickSortById(list);
        System.out.println("Successful!");
        writeOutputToFile("console_output.txt", "Successful!");
    }

    /**
     * Convert a decimal to an array of binary.
     *
     * @param i
     */
    //chuyển đổi số hệ thập phân sang hệ nhị phân
    public void convertToBinary(int i) {
        if (i > 0) {
            convertToBinary(i / 2);
            System.out.print((i % 2));
            writeOutputToFile("console_output.txt", "" + i % 2);

        }
    }

}
