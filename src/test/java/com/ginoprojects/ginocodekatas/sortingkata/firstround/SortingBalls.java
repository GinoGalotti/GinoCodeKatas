package com.ginoprojects.ginocodekatas.sortingkata.firstround;

import java.util.ArrayList;

/**
 * Created by GinoGalotti on 01/06/2015.
 * ginogalotti.com
 * ginogalotti@gmail.com
 */
public class SortingBalls {


    ArrayList<Integer> balls = new ArrayList<Integer>();

    public void clear() {
        balls = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getBalls() {
        return balls;
    }

    public void sortedAdd(int value) {
        boolean lookingForPosition = true;
        int i = 0;
        while (lookingForPosition && i < balls.size()) {
            if (balls.get(i) >= value) {
                for (int j = balls.size() - 1; j >= i; j--) {
                    moveMember(j);
                }
                balls.set(i, value);
                lookingForPosition = false;
            }
            i++;
        }

        if (lookingForPosition)
            balls.add(value);

    }

    private void moveMember(int j) {
        if (j == (balls.size() - 1))
            balls.add(balls.get(j));
        else
            balls.set(j + 1, balls.get(j));
    }

}
