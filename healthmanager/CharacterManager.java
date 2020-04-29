package healthmanager;

public class CharacterManager {


    String name;
    int hp;
    int ac;
    boolean isAlive = true;

    public CharacterManager(){

    }

    public void setStats(String charName, int hpAmount, int acAmount) {

        name = charName;
        hp = hpAmount;
        ac = acAmount;

    }

    public boolean isAlive(){
        return isAlive;
    }

    public String displayStats() {
        
        if(isAlive == true){
            return "~~~ " + name + " ~~~\nCurrent HP: " + hp + "\nAC: " + ac + "\n";
        } else {
            return "~~~ " + name + " ~~~\n-CHARACTER DEAD-\n";
        }
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getAC() {
        return ac;
    }

    public void reduceHP(int reduceAmount) {
        hp = hp - reduceAmount;

        if(hp <= 0){
            isAlive = false;
            System.out.println(name + " has died after taking " + reduceAmount + " damage.");
        } else {
            System.out.println(name + " has taken " + reduceAmount + " damage.");
        }
    }

    public void increaseHP(int increaseAmount) {
        hp = hp + increaseAmount;
    }

    public void setHP(int setHPAmount){
        hp = setHPAmount;
    }
    
    public void setAC(int setACAmount){
        ac = setACAmount;
    }

    public void setName(String setName){
        name = setName;
    }


}