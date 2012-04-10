import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IdleGame {
    public static String status = "None yet";
//    public static final File statsFile = new File(IdleGame.class.getResource("").getPath(), "DwarfehGameStatsFile.txt");

    //Player Strings
    public static String playerName = null;
    public static String playerWeapon = null;
    public static String playerShield = null;
    public static String playerHelm = null;
    public static String playerPlatebody = null;
    public static String playerPlatelegs = null;
    public static String playerBoots = null;

    //fighting stuff
    public static boolean isFighting = false;
    public static boolean playersTurn = true;
    public static boolean computersTurn = !playersTurn;

    public static boolean run = true;

    //TODO add player input, shop, etc
    //readFile() breaks it.
    public static void main(String args[]) {
//        if (readFile()) {
            new Player(10000000, 10000000, 100, 100, 121, 1, 0, 0, "Tutorial");

            createNextLevel();
            Player.setLocation("Tutorial");
            Explore.search(Player.getLocation());
            Monster.getNewMonster();
            System.out.println(Monster.currentHP);
        final DwarfehGameGUI a = new DwarfehGameGUI();

        try {
            EventQueue.invokeAndWait(new Runnable() {

                public void run() {
                    a.setVisible(true);
                }
            });
        } catch (Exception ignored) {
        }



        while (run) {
                Player.setLevel(grabCurrentLevel());
                createNextLevel();
                if (Player.getCurrentHealth() < 0) {
//                    System.exit(0);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                }
                if (Player.getCurrentHealth() > 0) {
                    playersTurn = true;
                    Explore.search(Player.getLocation());
                    if (playersTurn) {
                        Monster.currentHP -= 5;
                        playersTurn = false;
                        if (Monster.currentHP <= 0) {
                            playersTurn = true;                           
                            System.out.println("Current gold: " +Player.getGold());
                            Player.setGold(Monster.killMoney);
                            System.out.println("+1 gold: " +Player.getGold());
                            
                            Player.setExperience(Monster.killXP);
                            Monster.getNewMonster();
                        }
                    }
                    if (!playersTurn && Monster.currentHP > 0) {
                        Player.setCurrentHealth(-(Monster.damage * Monster.attackTimes));
                    }
                }
            System.out.println("Looping!!");
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        DwarfehGameGUI.jPanel1.repaint();
                    }
                });
//            }
        }
    }


    private static boolean readFile() {
        System.out.println("File Loc: " + IdleGame.class.getResource("").getPath());
        File statsFile = new File(IdleGame.class.getResource("").getPath(), "DwarfehGameStatsFile.txt");
        if (statsFile.exists()) {
            try {
                status = "Setting file found! Reading your current settings";
                String filename = IdleGame.class.getResource("").getPath() + "\\DwarfehGameStatsFile.txt";
                Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));
                String line;
                String[] opts = {};
                while (in.hasNext()) {
                    line = in.next();
                    if (line.contains(":")) {
                        opts = line.split(":");
                    }
                }
                in.close();
                if (opts.length > 1) {
                    //TODO finish file reader and writer
                }
                return true;
            } catch (final Exception e2) {
                status = "Error reading settings file!";
                e2.printStackTrace();
                return false;
            }
        } else {
            try {
                status = "Creating file for settings";
                return statsFile.createNewFile();
            } catch (IOException ignored) {
                status = "Error creating settings file!";
                return false;
            }
        }
    }

    static double xpMultiplier = 1.05;
    public static int grabCurrentLevel() {
        long x = Player.getExperience();
        int y = 0;
        if (x >= 100) {
            while (x >= 100) {
                x = (int) (x / xpMultiplier);
                y++;
            }
        } else {
            y = 0;
        }
        return y;
    }

    public static void createNextLevel() {
        if (Player.getLevel() == 0) {
            Player.setExperienceToLevel(100);
        } else {
            if (Player.getExperience() >= Player.getExperienceToLevel()) {
                Player.setExperienceToLevel(Player.getExperience() + (long) (Player.getExperienceToLevel() * xpMultiplier));
                System.out.println("xp to lvl:" + Player.getExperienceToLevel());
            }
        }
    }

}
