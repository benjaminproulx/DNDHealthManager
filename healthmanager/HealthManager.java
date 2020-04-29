package healthmanager;

import java.util.*;

public class HealthManager{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        boolean characterIn = true;
        char selection;
        String characterAttributes;
        boolean doContinue =  false;
        CharacterManager player = new CharacterManager();
        int hpModifier;
        boolean changeAttribute;
        String nameModifier;
        int acModifier;
        
        while(characterIn == true){
            
            
            System.out.println("\n        ~~~ D&D Health Manager ~~~\n");
            System.out.println("A command line interface tool to manage the");
            System.out.println("health of a player or creature while in a");
            System.out.println("combat phase.");
            System.out.println("Please enter character with format 'NAME/HP0/AC', for example: 'Aalia/044/17'\nOr type x to exit");

            characterAttributes = sc.nextLine();

            if (characterAttributes.equals("x")|| characterAttributes.equals("X")) {

                doContinue = false;
                characterIn = false;

            } else {

                player.setStats(characterAttributes.substring(0, characterAttributes.indexOf("/")), Integer.parseInt(characterAttributes.substring(characterAttributes.indexOf("/")+1, characterAttributes.indexOf("/") + 4)), Integer.parseInt(characterAttributes.substring(characterAttributes.indexOf("/") + 5, characterAttributes.indexOf("/") + 7)));
                
                doContinue = true;
                characterIn = false;

            }
            


            while(doContinue == true){

                if(player.isAlive()){

                    System.out.println("\n" + player.displayStats());
                    System.out.println("What would you like to do?\na) Reduce the character's HP\nb) Increase the character's HP\nc) Modify the character's name or AC\nd) Exit");

                     selection = sc.nextLine().charAt(0);
                
                    switch(selection){
                    
                        case 'a':
                        System.out.println("Enter the amount you would like to reduce the character's HP by:");
                        if(sc.hasNextInt()){
                            hpModifier = sc.nextInt();
                            player.reduceHP(hpModifier);
                            sc.nextLine();
                        } else {
                            System.out.println("Error! Please enter an Integer.");
                            sc.nextLine();
                        }

                        break;

                        case 'b':
                        System.out.println("Enter the amount you would like to increase the character's HP by:");
                        if(sc.hasNextInt()){
                            hpModifier = sc.nextInt();
                            player.increaseHP(hpModifier);
                            sc.nextLine();
                        } else {
                            System.out.println("Error! Please enter an Integer.");
                            sc.nextLine();
                        }

                        break;

                        case 'c':

                        changeAttribute = true;
                        while(changeAttribute == true){
                            System.out.println("What attribute would you like to change?\na) HP\nb) AC\nc) Name\nd) Exit");
                            selection = sc.nextLine().charAt(0);
                            switch(selection){
                                case 'a':
                                System.out.println("Enter the desired HP:");
                                if(sc.hasNextInt()){
                                    hpModifier = sc.nextInt();
                                    player.setHP(hpModifier);
                                    sc.nextLine();
                                } else {
                                    System.out.println("Error! Please enter an Integer.");
                                    sc.nextLine();
                                }
                                changeAttribute = false;
                                break;

                                case 'b':
                                System.out.println("Enter the desired AC:");
                                if(sc.hasNextInt()){
                                    acModifier = sc.nextInt();
                                    player.setAC(acModifier);
                                    sc.nextLine();
                                } else {
                                    System.out.println("Error! Please enter an Integer.");
                                    sc.nextLine();
                                }
                                changeAttribute = false;
                                break;

                                case 'c':
                                System.out.println("Enter the desired Name:");
                                nameModifier = sc.nextLine();
                                player.setName(nameModifier);
                                changeAttribute = false;
                                break;

                                case 'd':
                                changeAttribute = false;
                                break;

                                default:
                                System.out.println("Please enter a valid selection.");
                            }
                    
                        }

                        break;

                        case 'd':
                        doContinue = false;
                        break;

                        default:
                        System.out.println("Please enter a valid selection.");
                    }
                } else {
                    System.out.println("Thank you for playing!");
                    doContinue = false;
                }
            }
        }
    }
}