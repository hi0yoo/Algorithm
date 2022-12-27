package programmers;

import programmers.solution.DeliveryBox;
import programmers.solution.DividePower;
import programmers.solution.Fatigue;
import programmers.solution.TableHashFunction;

public class Main {

    public static void main(String[] args) {
        DeliveryBox deliveryBox = new DeliveryBox();
        int[] order = {1, 2, 3, 4, 5};
        System.out.println(deliveryBox.solution(order));
    }
}
