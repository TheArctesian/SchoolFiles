import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        ArrayList<Lunch> lunch = new ArrayList<>();
        ArrayList<Breakfast> brek = new ArrayList<>();
        ArrayList<Snack> snak = new ArrayList<>();
        ArrayList<Drink> drink = new ArrayList<>();

        while (!input.toLowerCase().equals("exit")) {
            input = sc.next();

            if (input.equals("brekkie")) {
                //do stuff for lunches
                Breakfast l = new Breakfast(1000);
                brek.add(l);
                System.out.println("Given you brekkie a name");
                String name = sc.next();
                l.setName(name);
                System.out.println("you have " + brek.size() + " brekkies");
            }

            if (input.equals("show-brek")) {
                System.out.println("you have breakfasts with the name of");
                for (int i = 0; i < brek.size(); i++) {
                    Breakfast Temp = brek.get(i);
                    System.out.println(Temp.getName());
                }
            }

            if (input.equals("lunch")) {
                //do stuff for lunches
                Lunch l = new Lunch(1000);
                lunch.add(l);
                System.out.println("Given you lunch a name");
                String name = sc.next();
                l.setName(name);
                System.out.println("you have " + lunch.size() + " lunch");
            }

            if (input.equals("show-lunch")) {
                System.out.println("you have lunchs with the name of");
                for (int i = 0; i < lunch.size(); i++) {
                    Lunch Temp = lunch.get(i);
                    System.out.println(Temp.getName());
                }
            }
            if (input.equals("snak")) {
                //do stuff for lunches
                Snack l = new Snack(1000);
                snak.add(l);
                System.out.println("Given you snack a name");
                String name = sc.next();
                l.setName(name);
                System.out.println("you have " + snak.size() + " snaks");
            }

            if (input.equals("show-snak")) {
                System.out.println("you have snaks with the name of");
                for (int i = 0; i < snak.size(); i++) {
                    Snack Temp = snak.get(i);
                    System.out.println(Temp.getName());
                }
            }
            if (input.equals("drink")) {
                //do stuff for lunches
                Drink l = new Drink(1000);
                drink.add(l);
                System.out.println("Given you drink a name");
                String name = sc.next();
                l.setName(name);
                System.out.println("you have " + drink.size() + " liquids");
            }
            if (input.equals("show-drink")) {
                System.out.println("you have snaks with the name of");
                for (int i = 0; i < drink.size(); i++) {
                    Drink Temp = drink.get(i);
                    System.out.println(Temp.getName());
                }
            }
        }

        System.out.println("The imposter will be seeing you now...");
        System.out.println("""
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
