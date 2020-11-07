
package coordshw;

import java.util.Scanner;
import java.util.Random;

public class CoordsHw {
    
    public static void createBoard(int[][] board){
        for (int row=0;row<7;row++)
            for(int column=0;column<7;column++)
                board[row][column]=-1;
    }
    
    public static void showBoard(int[][] board){
        System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7"); // \t is tab or large space
        System.out.println();
        
        for (int row=0;row<7;row++){
            System.out.println((row+1)+"");
            for (int column=0;column<7;column++){
                if (board[row][column]==-1){
                    System.out.print("\t"+" ");
                }else if (board[row][column]==0){
                    System.out.print("\t"+"*");
                }else if (board[row][column]==1){
                    System.out.println("\t"+"X");
                }
            }
            System.out.println();
        }
    }

    
    public static void setShips(int[][] ships){
        Random random = new Random();
        
        for (int ship=0; ship<5;ship++){
            ships[ship][0]=random.nextInt(7); //max random number is 7
            ships[ship][1]=random.nextInt(7);
            
            for(int last=0;last<ship; last++){
                if ( (ships[ship][0]==ships[last][0])&&(ships[ship][1]==ships[last][1]))
                    do{
                        ships[ship][0]=random.nextInt(7);
                        ships[ship][1]=random.nextInt(7);
                    }while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]));
            }
        }
    }
    
    public static void shoot(int[] shoot){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the row you would like to try: ");
        shoot[0] = input.nextInt();
        shoot[0]--;
        
        System.out.println("Please enter the column you would like to try: ");
        shoot[1] = input.nextInt();
        shoot[1]--;
    }
    
    public static boolean hitShip(int[] shoot, int[][] ships){
        for (int ship=0; ship<ships.length; ship++){
            if (shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]){
                System.out.println("You hit an enemy ship at " + shoot[0]+1 +"," + shoot[1]+1);
                return true;
        }
        }
        return false;
    }
    
    public static void newBoard(int[] shoot, int[][] ships, int[]][] board){
        if (hitShip(shoot,ships)){
            board[shoot[0]][shoot[1]]=1;
        }else{
            board[shoot[0]][shoot[1]]=0;
        }
            
    }
    
    
    
    public static void main(String[] args) {
        
        
        
        int[][] board = new int[7][7];
        int [][] ships = new int[5][2];
        int [] shoot = new int [2];
        int attempts = 0;
        int hits = 0;
        
        createBoard(board);
        setShips(ships);
        
        System.out.println();
        
        do{
            showBoard(board);
            shoot(shoot);
            attempts++;
            newBoard(shoot,ships,board);

        }while (hits!=5);
        
        System.out.println("Congrats! You have found all 5 ships in "+attempts+" attempts!");
        showBoard(board);
        
        
        
    }
    
}
