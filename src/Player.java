/**
 * Created by IntelliJ IDEA.
 * User: Brandon
 * Date: 4/4/12
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private static long currentHealth = 0;
    private static long totalHealth = 0;
    private static long currentMana = 0;
    private static long totalMana = 0;
    private static long experience = 0;
    private static long level = 0;
    private static long gold = 0;
    private static long experienceToLevel = 0;
    private static String location = "NONE";

    public Player(long currHP, long totHP, long currMana, long totMana, long xp, long lvl, long money, long xpToLvl, String loc) {
        currentHealth = currHP;
        totalHealth = totHP;
        currentMana = currMana;
        totalMana = totMana;
        experience = xp;
        level = lvl;
        gold = money;
        experienceToLevel = xpToLvl;
        location = loc;
    }

    public static void setCurrentHealth(long amount) {
        currentHealth = currentHealth == 0 ? amount : currentHealth+amount;
    }

    public static long getCurrentHealth() {
        return currentHealth;
    }

    public static void setTotalHealth(long amount) {
        totalHealth = amount;
    }

    public static long getTotalHealth() {
        return totalHealth;
    }

    public static void setCurrentMana(long amount) {
        currentMana = currentMana == 0 ? amount : currentMana+amount;
    }

    public static long getCurrentMana() {
        return currentMana;
    }

    public static void setTotalMana(long amount) {
        totalMana = amount;
    }

    public static long getTotalMana() {
        return totalMana;
    }

    //Allows setting and adding experience
    public static void setExperience(long amount) {
        experience += amount;
    }

    public static long getExperience() {
        return experience;
    }

    public static void setLevel(int lvl) {
        level = lvl;
    }

    public static long getLevel() {
        return level;
    }

    public static void setGold(long amount) {
        gold += amount;
    }

    public static long getGold() {
        return gold;
    }

    public static void setExperienceToLevel(long amount) {
        experienceToLevel = amount;
    }

    public static long getExperienceToLevel() {
        return experienceToLevel;
    }

    public static void setLocation(String loc) {
        location = loc;
    }

    public static String getLocation() {
        return location;
    }

    public static class Equipment {

        public static class Weapon {
            private static String name;
            private static long damage = 0;

            Weapon(String name, long damage) {
                Weapon.name = name;
                Weapon.damage = damage;
            }

            private static void decreaseDamage(long amount) {
                damage -= amount;
            }

            private static void increaseDamage(long amount) {
                damage += amount;
            }

            public static long getDamage() {
                return damage;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Shield {
            private static String name;
            private static long armor = 0;

            Shield(String name, long damageReduction) {
                Shield.name = name;
                Shield.armor = damageReduction;
            }

            private static void decreaseArmor(long amount) {
                armor -= amount;
            }

            private static void increaseArmor(long amount) {
                armor += amount;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Helm {
            private static String name;
            private static long armor = 0;

            Helm(String name, long damageReduction) {
                Helm.name = name;
                Helm.armor = damageReduction;
            }

            private static void decreaseArmor(long amount) {
                armor -= amount;
            }

            private static void increaseArmor(long amount) {
                armor += amount;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Body {
            private static String name;
            private static long armor = 0;

            Body(String name, long damageReduction) {
                Body.name = name;
                Body.armor = damageReduction;
            }

            private static void decreaseArmor(long amount) {
                armor -= amount;
            }

            private static void increaseArmor(long amount) {
                armor += amount;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Legs {
            private static String name;
            private static long armor = 0;

            Legs(String name, long damageReduction) {
                Legs.name = name;
                Legs.armor = damageReduction;
            }

            private static void decreaseArmor(long amount) {
                armor -= amount;
            }

            private static void increaseArmor(long amount) {
                armor += amount;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Boots {
            private static String name;
            private static long armor = 0;

            Boots(String name, long damageReduction) {
                Boots.name = name;
                Boots.armor = damageReduction;
            }

            private static void decreaseArmor(long amount) {
                armor -= amount;
            }

            private static void increaseArmor(long amount) {
                armor += amount;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

        public static class Ring {
            private static String name;
            private static long armor = 0;
            private static long damage = 0;

            Ring(String name, long damage, long armor, long hpIncrease, long manaIncrease) {
                Ring.name = name;
                Ring.damage = damage;
                Ring.armor = armor;
                Player.setTotalHealth(Player.getTotalHealth()+hpIncrease);
                Player.setTotalMana(Player.getTotalMana()+manaIncrease);
            }

            public static long getDamage() {
                return damage;
            }

            public static long getArmor() {
                return armor;
            }

            public static String getName() {
                return name;
            }
        }

       public static long getAllArmor() {
           return Shield.getArmor()+Helm.getArmor()+Body.getArmor()+Legs.getArmor()+Boots.getArmor()+Ring.getArmor();
       }

       public static long getAllDamage() {
           return Weapon.getDamage()+Ring.getDamage();
       }


    }

}
