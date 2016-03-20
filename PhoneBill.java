public class PhoneBill{

     public static void main(String []args){
        String S = new String("01:00:01,123-234-598\n00:05:01,987-098-123\n00:00:09,123-234-598");
        System.out.println("Hello World");
        //Scanner input = new Scanner(System.in);
        //String data = input.nextLine();
        System.out.println(S);
        String[] Bill = S.split("[,\\s]+");

        for( String x : Bill ) {
         System.out.print( x );
         System.out.println(",");
      }
        /*
        for (String y : B){
            System.out.println(y);
        }
      */
        int[] PhoneBill = new int[Bill.length];
        for (int i=0; i<=Bill.length-1;i=i+2){
            PhoneBill[i] = CallTime(Bill[i]);
            System.out.println(CallTime(Bill[i]));
        }
        for (int i=1; i<=Bill.length-1;i=i+2){
            PhoneBill[i] = PhoneNum(Bill[i]);
            System.out.println(PhoneNum(Bill[i]));
        }
        
        System.out.println("Result from Integer Array:");
        for (int i=0;i<=PhoneBill.length-1;i++){
            System.out.println(PhoneBill[i]);
        }
        System.out.println("Result from Integer Array after SumSame:");
        int[] PB = SumSame(PhoneBill);
        for (int i=0;i<=PB.length-1;i++){
            System.out.println(PB[i]);
        }
        
        System.out.println(Calculate(PB));
        
        System.out.println("Final Cost:");
        System.out.println(Calculate(RemoveMax(PB)));
        
     }
     
     public static int CallTime(String C){
     
         String[] T=C.split(":");
         int HH = Integer.parseInt(T[0]);
         int MM = Integer.parseInt(T[1]);
         int SS = Integer.parseInt(T[2]);
         return (HH*60+MM)*60+SS;
     }
     public static int PhoneNum(String P){
         String[] PN=P.split("-");
         int N1 = Integer.parseInt(PN[0]);
         int N2 = Integer.parseInt(PN[1]);
         int N3 = Integer.parseInt(PN[2]);
         return (N1*1000+N2)*1000+N3;
     }
     
     public static int[] SumSame(int[] Sum){
         
         for(int i =1; i<= Sum.length-1;i=i+2){
             for(int j=i+2; j<=Sum.length-1;j=j+2){
                 if(Sum[i]==Sum[j]){
                     Sum[i-1] = Sum[i-1]+Sum[j-1];
                     Sum[j-1] = 0;
                 }
             }
         }
         return Sum;
     }
     
     public static int Calculate(int[] P){
         int sum = 0;
         for (int i = 0; i<P.length; i=i+2){
             if(P[i] < 300){
                 sum = sum + P[i] * 3;
             }
             else if(P[i] % 60 == 0){
                 sum = sum + (P[i]/60)*150;  
             }     
             else{
                 sum = sum + (P[i]/60+1)*150;
             }
         }
         return sum;
     }
     
     public static int[] RemoveMax(int[] P){
         int max = 0;
         int position = 0;
         for (int i =0; i<P.length; i=i+2){
             if(P[i] > max){
                 max = P[i];
                 position = i;
             }
             
         }
         P[position] = 0;
         return P;
     }
}
