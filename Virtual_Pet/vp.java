import java.util.*;

public class Virtual_Pet {
    static Scanner scan = new Scanner(System.in);
    static Random rng = new Random();

    public static void menu(int virtualPet) {
        System.out.println(" ");

        System.out.println("VIRTUAL PET");
        System.out.println("---------------");
        System.out.println("1. Sleep");
        System.out.println("2. Play");
        System.out.println("3. Eat");
        if (virtualPet == 1) {
            System.out.println("4. Shower");
        } else {
            System.out.println("4. Self-cleaning");
        }
        System.out.println("0. Exit application");

        System.out.println(" ");
    }

    public static void showStats(int virtualPet, String nomGos, String nomGat, int energy, int fatigue, int sleep, int hygiene, int weight) {
        if (virtualPet == 1) {
            System.out.println(nomGos.toUpperCase());
        } else {
            System.out.println(nomGat.toUpperCase());
        }

        System.out.println("Energy: " + energy);
        System.out.println("Fatigue: " + fatigue);
        System.out.println("Sleep: " + sleep);
        System.out.println("Hygiene: " + hygiene);
        System.out.println("Weight: " + weight);
    }

    public static void checkStats(int virtualPet, String nomGos, String nomGat, int energy, int fatigue, int sleep, int hygiene, int weight) {
        if (energy >= 100) {
            energy = 100;
        } else if (energy <= 0) {
            energy = 0;
        }

        if (fatigue >= 100) {
            fatigue = 100;
        } else if (fatigue <= 0) {
            fatigue = 0;
        }

        if (sleep >= 100) {
            sleep = 100;
        } else if (sleep <= 0) {
            sleep = 0;
        }

        if (hygiene >= 100) {
            hygiene = 100;
        } else if (hygiene <= 0) {
            hygiene = 0;
        }

        if (weight >= 100) {
            weight = 100;
        } else if (weight <= 0) {
            weight = 0;
        }

        showStats(virtualPet, nomGos, nomGat, energy, fatigue, sleep, hygiene, weight);

        if (energy == 0 || fatigue == 100 || sleep == 0 || hygiene == 0 || weight == 100) {
            System.out.println("Tu mascota ha muerto.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        int energy = 0;
        int fatigue = 0;
        int sleep = 0;
        int hygiene = 0;
        int weight = 0;
        String nomGos = " ";
        String nomGat = " ";

        int opc;
        int virtualPet;

        System.out.println("Tens un gos o un gat?");
        do {
            System.out.println("1. Gos || 2. Gat");
            virtualPet = scan.nextInt();
        } while (virtualPet != 1 && virtualPet != 2);

        if (virtualPet == 1) {
            System.out.println("Com es diu el teu Gos? ");
            nomGos = scan.next();
        } else {
            System.out.println("Com es diu el teu Gat? ");
            nomGat = scan.next();
        }

        System.out.println("---------------");

        energy = rng.nextInt(40, 61);
        fatigue = rng.nextInt(40, 61);
        sleep = rng.nextInt(40, 61);
        hygiene = rng.nextInt(40, 61);
        weight = rng.nextInt(40, 61);

        showStats(virtualPet, nomGos, nomGat, energy, fatigue, sleep, hygiene, weight);

        do {
            menu(virtualPet);

            System.out.print("Selecciona una opcio: ");
            opc = scan.nextInt();

            switch (opc) {
                case 0:
                    break;
                case 1:
                    if (virtualPet == 1) {
                        sleep -= 25; //gos resta 25
                        fatigue -= 15;
                        energy += 15;
                    } else {
                        sleep -= 20; //gat resta 20
                        fatigue -= 15;
                        energy += 15;
                    }
                    checkStats(virtualPet, nomGos, nomGat, energy, fatigue, sleep, hygiene, weight);
                    break;
                case 2:
                    if (virtualPet == 1) {
                        sleep -= 10;
                        fatigue += 10;
                        energy -= 10;
                        hygiene -= 15;
                        weight -= 10;
                    } else {
                        sleep += 15;
                        fatigue += 10;
                        energy -= 10;
                        hygiene -= 15;
                        weight -= 10;
                    }
                    checkStats(virtualPet, nomGos, nomGat, energy, fatigue, sleep, hygiene, weight);
                    break;
                case 3:
                    if (virtualPet == 1) {
                        sleep += 15;
                        energy += 10;
                        hygiene -= 10;
                        weight += 10;
                    } else {
                        sleep += 10;
                        energy += 10;
                        hygiene -= 10;
                        weight += 10;
                    }
                    checkStats(virtualPet, nomGos, nomGat, energy, fatigue, sleep, hygiene, weight);
                    break;
                case 4:
                    if (virtualPet == 1) {
                        sleep -= 15;
                        hygiene += 20;
                    } else {
                        sleep += 10;
                        hygiene += 20;
                    }
                    checkStats(virtualPet, nomGos, nomGat, energy, fatigue, sleep, hygiene, weight);
                    break;
                default:
                    System.out.println("Opció no valida. ");
            }

        } while (opc != 0);

        scan.close();
    }
}
