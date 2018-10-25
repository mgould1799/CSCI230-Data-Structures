import java.util.Scanner;
public class dice {
    public void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like 1) numbers 1-6 or 2) 6 statements of your choice?");
        int x=scan.nextInt();

        if(x==1)
            nums();
        else
            statements();
    }
    public void nums(){
        boolean run = true;
        while(run==true){
            double num=Math.random()*60;
            if(num<11)
                System.out.println("1");
            if(num>10&&num<=20)
                System.out.println("2");
            if(num>20&&num<=30)
                System.out.println("3");
            if(num>30&&num<=40)
                System.out.println("4");
            if(num>50&&num<=60)
                System.out.println("5");
            if(num > 60)
                System.out.println("6");
            Scanner scan= new Scanner(System.in);
            System.out.println("would you like to roll again?");
            System.out.println("1) yes 2) no");
            int ans = scan.nextInt();
            if (ans ==2 )
                run=false;
        }
    }
    public void statements(){
        System.out.println("Please enter your 6 statements below");
        Scanner scan = new Scanner(System.in);
        String one = scan.nextLine();
        String two= scan.nextLine();
        String three= scan.nextLine();
        String four = scan.nextLine();
        String five = scan.nextLine();
        String six = scan.nextLine();
        boolean run = true;
        while(run==true){
            double num=Math.random()*60;
            if(num<=10)
            System.out.println(one);
            if(num>10&&num<=20)
                System.out.println(two);
            if(num>20&&num<=30)
                System.out.println(three);
            if(num>30&&num<=40)
                System.out.println(four);
            if(num>50&&num<=60)
                System.out.println(five);
            if(num>60)
                System.out.println(six);
            //Scanner scan= new Scanner(System.in);
            System.out.println("would you like to roll again?");
            System.out.println("1) yes 2) no");
            int ans = scan.nextInt();
            if (ans ==1 )
                run=true;
            else
                run=false;
        }
    }
    public static void main( String[] args ){
        dice run = new dice();
        run.run();
    }
}
