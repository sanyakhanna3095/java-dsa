import java.util.Scanner;

class CircularTour {
    public static int findStartingPump(int[] petrol, int[] distance) {
        // Total net petrol in journey
        int totalSurplus = 0;

        // Petrol balance at each step
        int currentSurplus = 0;

        // Possible starting pump
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int netPetrol = petrol[i] - distance[i];
            totalSurplus += netPetrol;
            currentSurplus += netPetrol;

            // If current surplus becomes negative, reset start index
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        // If journey is possible, return start index
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of pumps: ");
        int n=sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter net petrol at pump "+ (i+1)+ " : ");
            petrol[i]=sc.nextInt();
            System.out.println("Enter distance between current pump and the next one : ");
            distance[i]=sc.nextInt();
        }

        int startIndex = findStartingPump(petrol, distance);
        if (startIndex == -1) {
            System.out.println("No valid starting point exists.");
        }
        else {
            System.out.println("Start at petrol pump index: " + startIndex);
        }
    }
}
