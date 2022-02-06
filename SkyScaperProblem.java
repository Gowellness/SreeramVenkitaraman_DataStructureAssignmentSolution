import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import javax.print.event.PrintJobListener;

public class SkyScaperProblem {

    static class Floor {
        int day;
        int size;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("enter the total no of floors in the building ");
        int totalFloors = Integer.parseInt(reader.readLine());

        List<Integer> floors = new ArrayList<Integer>(totalFloors);
        for (int i = 1; i <= totalFloors; i++) {
            System.out.println("enter the floor size given on day : " + i);
            floors.add(Integer.parseInt(reader.readLine()));
        }

        int currentSize = totalFloors;
        List<Integer> pendingList = new ArrayList<Integer>();
        System.out.println("The order of construction is as follows: ");
        for (int i = 1; i <= totalFloors; i++) {
            System.out.println("Day : " + i);
            if (floors.get(i - 1) == currentSize) {
                System.out.print(floors.get(i - 1));
                currentSize -= 1;
                if (pendingList.size() > 0) {
                    while (pendingList.size() > 0) {
                        if (pendingList.get(0) == currentSize) {
                            System.out.print(" " + pendingList.remove(0));
                            currentSize -= 1;
                        } else {
                            break;
                        }
                    }

                }
            } else {
                pendingList.add(floors.get(i - 1));
            }
            System.out.println("");
            Collections.sort(pendingList, Collections.reverseOrder());
        }
    }
}
