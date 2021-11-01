import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println(CLog.CYAN + "What is you name");
        String Name = sc.next();
        Student s = new Student(Name);
        HashMap<Student, String> orders = new HashMap<Student, String>();
        System.out.println("you may start ordering now" + CLog.YELLOW);
        System.out.println(CLog.BLUE + "if you are cunfuzzled type "+ CLog.RED + "'help'" + CLog.YELLOW);
        while (!input.toLowerCase().equals("exit")) {
            input = sc.next();

            if (input.equals("brekkie")) {
                Breakfast BrkTemp = new Breakfast(1000);
                System.out.println(CLog.CYAN + "Given you brekkie a name" + CLog.YELLOW);
                String name = sc.next();
                BrkTemp.setName(name);
                s.addBreakfast(BrkTemp);
                orders.put(s, BrkTemp.getName());
                s.setStudentOrders("Breakfast", BrkTemp.getName());
                System.out.println(CLog.GREEN + "Your order has been put through!" + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }

            if (input.equals("show-brek")) {
                System.out.println(CLog.GREEN + "you have breakfasts with the name of" + CLog.YELLOW);
                System.out.println(CLog.BLUE + s.getBreakfast() + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }

            if (input.equals("lunch")) {
                Lunch Temp = new Lunch(1000);
                System.out.println(CLog.CYAN + "Given you LUNCH a name" + CLog.YELLOW);
                String name = sc.next();
                Temp.setName(name);
                s.addLunch(Temp);
                orders.put(s, Temp.getName());
                s.setStudentOrders("Lunch", Temp.getName());
                System.out.println(CLog.GREEN + "Your order has been put through!" + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }

            if (input.equals("show-lunch")) {
                System.out.println(CLog.GREEN + "you have breakfasts with the name of" + CLog.YELLOW);
                System.out.println(CLog.BLUE + s.getLunch() + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }
            if (input.equals("snak")) {
                Snack Temp = new Snack(1000);
                System.out.println(CLog.CYAN + "Given you snak name" + CLog.YELLOW);
                String name = sc.next();
                Temp.setName(name);
                s.addSnack(Temp);
                orders.put(s, Temp.getName());
                s.setStudentOrders("Snack", Temp.getName());
                System.out.println(CLog.GREEN + "Your order has been put through!" + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }

            if (input.equals("show-snak")) {
                System.out.println(CLog.GREEN + "you have snacks with the name of" + CLog.YELLOW);
                System.out.println(CLog.BLUE + s.getSnack() + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }
            if (input.equals("Latte")) {
                Latte Temp = new Latte(1000);
                System.out.println(CLog.CYAN + "Given you Latte name" + CLog.YELLOW);
                String name = sc.next();
                Temp.setName(name);
                s.addDrinks(Temp);
                orders.put(s, Temp.getName());
                s.setStudentOrders("Latte", Temp.getName());
                System.out.println(CLog.GREEN + "Your order has been put through!" + CLog.YELLOW);
                System.out.println("What else do you want fatso");
            }
            if (input.equals("show-Latte")) {
                System.out.println(CLog.GREEN + "you have drinks with the name of" + CLog.YELLOW);
                System.out.println(CLog.BLUE + s.getDrinks() + CLog.YELLOW);
            }
            if (input.equals("show-imposter")) {
                System.out.println("you can never see the immposter");
                System.out.println(CLog.RED + "I do hear the if you type exit he might show up" + CLog.YELLOW);
                System.out.println("go back to ordering food fatso");
            }
            if (input.equals("help")) {
                System.out.println(CLog.BLUE + "In this advanced ordering system you may order:" + CLog.CYAN);
                System.out.println("snak");
                System.out.println("brekkie");
                System.out.println("lunch");
                System.out.println("Latte");
                System.out.println(CLog.BLUE + "you can also show all the orders as well for each by typing " + CLog.GREEN + "show-{order}");
                System.out.println(CLog.YELLOW + "I head there is a secret command called 'show-imposter' but idk what that does");
            }
        }


        System.out.println(CLog.RED + "The imposter will be seeing you now...");
        System.out.println(CLog.RESET + """ 
                0000000000000000000000000000000GG000000000000000GGG0000000000000000000000000000000
                000000000000000000000000000GLi:,,:C000000000000L:,,:iLG000000000000000000000000000
                000000000000000000000000GL;........G0000000000C........iLG000000000000000000000000
                0000000000000000000000Ci:.....,:,..1CLfttttfLLi..::,.....:iC0000000000000000000000
                00000000000000000000G1.....:;;;;;,.. ........ ..,;;;;;,.....1000000000000000000000
                0000000000000000000t,...,:;;;;:,..................,:;;;;:,...,t0000000000000000000
                00000000000000000C,...,;;;;:.....,::;;;;;;;;;;::,.....;;;;;,...,C00000000000000000
                0000000000000000C,..,;;;;:,..,:;;;;;;;;;;;;;;;;;;;;:,..,:;;;;,..,C0000000000000000
                0000000000000000;..:;;;;,.,:;;;;;;;;;;;;;;;;;;;;;;;;;;:,.,;;;;:..i0000000000000000
                000000000000000f..:;;;:.:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,.:;;;:..L000000000000000
                00000000000000G,.,;;;::;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;::;;;..:G00000000000000
                00000000000000t..:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:..f00000000000000
                00000000000000;..;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;..;00000000000000
                0000000000000L..:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,..C0000000000000
                0000000000000;..;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;..i0000000000000
                000000000000C..:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,..G000000000000
                0000000000001..;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;..t000000000000
                00000000000G:.,;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;,.:G00000000000
                00000000000L..:;;;;;;;;;;;..............................;;;;;;;;;;;:.,C00000000000
                00000000000t..;;;;;;;;;:..................................:;;;;;;;;;..t00000000000
                00000000000:..;;;;;;;;:....,,:i11111111111111111111111i,...:;;;;;;;;..;00000000000
                0000000000G..:;;;;;;;;...;iii1GGGGGGGGGGGGG008@@@@8000GGL,..;;;;;;;;,..00000000000
                0000000000f..;;;;;;;;...;iiiiLGGGGGGGGGGGG8@@@@@@@@@@@80GL,.,;;;;;;;;..L0000000000
                0000000000:..;;;;;;;;..:iiiiiLGGGGGGGGGGGG@@@@@@@@@@@@@@8GL..:;;;;;;;..i0000000000
                000000000G...;;;;;;;,..;iiiiitGGGGGGGGGGGG0@@@@@@@@@@@@@@0C,.,;;;;;;;,..0000000000
                000000000L..,:;;;;;;,..;iiiii1GGGGGGGGGGGGG008@@@@@@@@@@0GG:.,;;;;;;;:..C000000000
                000000000t..,:;;;;;;,..;iiiiiifGGGGGGGGGGGGGGGG00888800GGGG:.,;;;;;;;:..f000000000
                000000000i..,::;;;;;,..;iiiiiiifGGGGGGGGGGGGGGGGGGGGGGGGGGG:.,;;;;;;;;..1000000000
                000000000;..,:::;;;;,..;iiiiiiiit0GGGGGGGGGGGGGGGGGGGGGGGGG:.,;;;;;;;;..;000000000
                00000000G:..:::::;;;,..;iiiiiiiiitLGGGGGGGGGGGGGGGGGGGGGGGG,.,;;;;;;;;,.:G00000000
                00000000C,.,:::::;;;,..;iiiiiiiiiii1CGGGGGGGGGGGGGGGGGGGGG1,.,;;;;;;;;,.,G00000000
                00000000L..,::::::;;,..;iiiiiiiiiiiiiiLCGGGGGGGGGGGGGGGCLi;..,;;;;;;;;:..C00000000
                00000000f..,::::::::,..;iiiiiiiiiiiiiiiittfLCGGGGGGGLftiii;..,;;;;;;;;:..L00000000
                00000000f..,::::::::: .:iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii:..;;;;;;;;;;..f00000000
                000000001..:::::::::,...;iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii;..,;;;;;;;;;;..t00000000
                00000000i..::::::::::,...:iiiiiiiiiiiiiiiiiiiiiiiiiiiiii:...;;;;;;;;;;;..100000000
                00000000:..::::::::,,:,....................................:;;;;;;;;;;;..;00000000
                00000000,..::::::::,,,,,.................................,:;::;;;;;;;;;..:00000000
                00000000...,:::::::::,.,,,,...........................,:;;:.;;;;;;;;;;;..:00000000
                00000000t...,:::::::::,..,,::::;;;;;;;;;;;;;;;;;;;;;;;;;:.,;;;;;;;;;;:...t00000000
                00000000G;...::::::::::,,...,::::;;;;;;;;;;;;;;;;;;;;:,..:;;;;;;;;;::...i000000000
                000000000G;...,::::::::::,.....,,,::;;;;;;;;;;;;:::,...,;;;;;;;;;::,...;G000000000
                000000000001....::::::::::,,,.........,,,,,,,,.......,;;;;;;;;::::,...100000000000
                000000000000t....,,::::::::::,,....................:;;;;;::::::,,...,f000000000000
                0000000000000Ci....,,::::::::,..,t11i;;:,,::;i111,..:::::::::,,....iC0000000000000
                000000000000000C,.....,,:::::...t00000000000000001..,:::::,,.....:C000000000000000
                00000000000000000f;,.......,,..i000000000000000000;..,,.......,;f00000000000000000
                0000000000000000000Cf;........;0000000000000000000G:........;fC0000000000000000000
                0000000000000000000000GLi::,,;G00000000000000000000C;,,::1LG0000000000000000000000
                000000000000000000000000000GG000000000000000000000000GG000000000000000000000000000
                0000000000000000000000000000000000000000000000000000000000000000000000000000000000
                                
                """);
    }
}