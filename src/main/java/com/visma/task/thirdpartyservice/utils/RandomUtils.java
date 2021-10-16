package com.visma.task.thirdpartyservice.utils;

import java.util.Random;

public class RandomUtils {

    private RandomUtils() {    }

    private static final Random random = new Random();

    public static int getRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
