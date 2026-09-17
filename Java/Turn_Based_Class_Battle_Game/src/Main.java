
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


public class Main
{
    static void clearScreen()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println();
        }
    }
    public static void main(String[] args)
    {

        //Scanner setup
        Scanner scanner = new Scanner(System.in);
        //Weapons
        Weapon longSword = new Weapon(25, 0.5);
        Weapon dagger = new Weapon(5, 2);
        Weapon sword = new Weapon(9, 1);
        Weapon staff = new Weapon(19, 1);
        Weapon fist = new Weapon(4, 8);
        Weapon hammer = new Weapon(16, 0.7);


        //Classes (AS IN CLASSES THE PLAYER CAN PLAY)
        //Player fighter = new Player("Fighter", 100, longSword, 8);
        //Player assassin = new Player("Assassin", 70, dagger, 20);

        //Attack calls
        //fighter.attack(assassin);
        //assassin.attack(fighter);

        //Debug stats
        //fighter.printStats();
        //assassin.printStats();


        //UNDER THIS IS MAIN PROGRAM PATH
        System.out.println("Choose your class -- type 'fighter', 'assassin', etc... ");
        System.out.println("Class Options: |Fighter| |Assassin| |Tank| |Mage| |Craz|");


        //Player 1
        System.out.print("Player 1: ");
        String choice1 = scanner.nextLine();
        Player player1;

        //Player 2
        System.out.print("Player 2: ");
        String choice2 = scanner.nextLine();
        Player player2;

        //player class selection
        switch (choice1)
        {
            case "fighter":
                player1 = new Player("Fighter", 12, longSword, 8);
                break;

            case "assassin":
                player1 = new Player("Assassin", 70, dagger, 20);
                break;

            case "tank":
                player1 = new Player("Tank", 200, hammer, 5);
                break;

            case "mage":
                player1 = new Player("Mage", 60, staff, 12);
                break;

            case "craz":
                player1 = new Player("Craz", 108, fist, 18);
                break;

            default:
                player1 = new Player("Bum", 100, sword, 10);
                break;
        }

        switch (choice2)
        {
            case "fighter":
                player2 = new Player("Fighter", 12, longSword, 8);
                break;

            case "assassin":
                player2 = new Player("Assassin", 70, dagger, 20);
                break;

            case "tank":
                player2 = new Player("Tank", 200, hammer, 5);
                break;

            case "mage":
                player2 = new Player("Mage", 60, staff, 12);
                break;

            case "craz":
                player2 = new Player("Craz", 108, fist, 18);
                break;

            default:
                player2 = new Player("Bum", 100, sword, 10);
                break;
        }


        //main loop
        while (player1.isAlive() && player2.isAlive())
        {

            //player 1 handler
            clearScreen();
            player1.printStats();
            System.out.println("Player 1's Turn!");
            System.out.println("|Attack| |Block|");
            String move1 = scanner.nextLine();
            if (move1.equals("attack"))
            {
                    player1.attack(player2);
            }
            else if (move1.equals("block"))
            {
                player1.blocking = true;
            } else
            {
                System.out.println("Invalid! Use lowercase!");
            }





            //player 2 handler and game end check
            if (player2.isAlive())
            {

                clearScreen();
                player2.printStats();
                System.out.println("Player 2's Turn!");
                System.out.println("|Attack| |Block|");
                String move2 = scanner.nextLine();
                if (move2.equals("attack"))
                {
                    player2.attack(player1);
                }
                else if (move2.equals("block"))
                {
                    player2.blocking = true;
                } else
                {
                    System.out.println("Invalid! Use lowercase!");
                }
            } else
            {
                break;
            }

        }

        //Win checker
        if (player1.isAlive())
        {
            System.out.println("Player 1 wins!");
        } else
        {
            System.out.println("Player 2 wins!");
        }

    }
}


//Weapon Class
class Weapon
{
    double damage;
    double attackSpeed;

    Weapon(double damage, double attackSpeed)
    {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }
}


//Player Class
class Player
{
    //Player Field
    double speed;
    double health;
    Weapon weapon;
    String name;
    boolean blocking = false;

    //Main Player Method
    Player(String name, double health, Weapon weapon, double speed)
    {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.speed = speed;
    }

    //Stat display method
    void printStats()
    {
        System.out.println("-----------------------------");
        System.out.println("Class:" + name);
        System.out.println("Health: " + health);
        System.out.println("Speed: " + speed);
        System.out.println("Damage: " + weapon.damage);
        System.out.println("Attack Speed: " + weapon.attackSpeed);
        System.out.println("-----------------------------");
    }

    //attack method
    void attack(Player target)
    {
        if (target.isBlocking())
        {
            target.health = target.health - ((weapon.damage * weapon.attackSpeed) / 2);
            target.blocking = false;
            System.out.println(name + " attacked " + target.name + " for " + ((weapon.damage * weapon.attackSpeed) / 2) + " damage!");
        } else
        {
            target.health = target.health - (weapon.damage * weapon.attackSpeed);
            System.out.println(name + " attacked " + target.name + " for " + (weapon.damage * weapon.attackSpeed) + " damage!");
        }
    }

    boolean isBlocking()
    {
        return blocking;
    }

    boolean isAlive()
    {

        return health > 0;
    }

}

