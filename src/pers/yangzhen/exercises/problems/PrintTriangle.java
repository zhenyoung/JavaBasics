package pers.yangzhen.exercises.problems;

public class PrintTriangle {
    public static void main(String[] args){
        //***********************************
        for(int index1_1 = 1;index1_1 <= 10;index1_1++){
            for(int index1_2 = 1;index1_2 <= index1_1;index1_2++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        //**********************************
        for(int index2_1 = 1;index2_1 <= 10;index2_1++){
            for(int index2_2 = 1;index2_2 <= 11 - index2_1;index2_2++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        //***********************************
        for(int index3_1 = 1;index3_1 <= 10;index3_1++){
            for(int index3_2 = 1;index3_2 <= 10;index3_2++){
                if(index3_2 < index3_1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        System.out.println();
        //***********************************
        for(int index4_1 = 1;index4_1 <= 10;index4_1++){
            for(int index4_2 = 1;index4_2 <= 10;index4_2++){
                if(index4_2 < 11- index4_1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        //***********************************
    }
}

