/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ortega_exam4;

import java.util.Scanner;
import java.lang.String;
/**
 *
 * @author home
 */
public class Ortega_Exam4 {

      class StackNode{

       int quantity;
       String productName;
        StackNode next;
        String data;

    private StackNode(String productName, int quantity) {
         this.data = productName;
        this.quantity = quantity;
        this.data = data;
        
      }   
    
    }
    private StackNode top;
    private int size;
    
    
    private StackNode createNewNode (String productName ,int quantity)throws Exception{
        StackNode node = createNewNode (productName, quantity);
        if (node == null){
            throw new Exception ("Memory is Full");
        }else {
            int data = quantity;
            node.next = null;
            return node;
        }
    }
    
    public void addProducts (String productName, int quantity) throws Exception{
       StackNode node = new StackNode (productName, quantity);
        if (top == null){
            top = node;
        }else {
            node.next = top;
            top = node;
        }
//        size++;
    }
    
    public String sellProducts(String productName, int quantity) throws Exception{
        StackNode node = new StackNode(productName, quantity);
        if (top == null ){
           throw new Exception ("Stack is empty");
        }
        
          String temporary = peek();
        top = top.next;
        size--;
        return temporary;
    }
    
    public String peek() throws Exception{
            if (top == null){
            throw new Exception ("Stacks is empty");
        }
        
        return top.data;
    }
   
    public void displayInventory()throws Exception {
        if (top == null) {
            System.out.println("Store is empty.");
            return;
        }

             StackNode temporary = top;
             
            while (temporary != top.next) {
            System.out.println("Product: " + temporary.data);
            System.out.println("Quantity: " + temporary.data);
            System.out.println("-----------------------------");
            temporary = temporary.next;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Ortega_Exam4 stack = new Ortega_Exam4();
        boolean start = true;
        
        while(start){
            System.out.println("1. Add Products");
            System.out.println("2. Sell Products");
            System.out.println("3. Display Inventory");   
            int choose = scan.nextInt();
            scan.nextLine();
            int element;
            
       switch (choose) {
                case 1:
                    System.out.println("Add products:");
                   String addProducts = scan.nextLine();
                    System.out.println("Add quantity");
                    element = scan.nextInt();
                    
                    stack.addProducts(addProducts, element);
                    
                    stack.displayInventory();
                    break;        
                case 2:
                    System.out.println("Sell Products");
                    String sellProducts = scan.nextLine();
                    System.out.println("Quantity");
                    element = scan.nextInt();
                    
                    stack.displayInventory();
                    break;
                case 3:
                    System.out.println("All Products");
                    stack.displayInventory();
                    break;
                default:
                    throw new AssertionError();
            }
        }
     
    }
    
}
