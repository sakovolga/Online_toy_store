package com.example.online_toy_store.util;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordHashing {
    private static final int MEMORY = 65536;
    private static final int ITERATIONS = 10;
    private static final int PARALLELISM = 1;
    private static final int HASH_LENGTH = 32; // Длина хэша в байтах

    private static final Argon2 ARGON2 = Argon2Factory.create();

    public static String hashPassword(String password) {
        return ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, password.toCharArray());
    }

    public static boolean verifyPassword(String hashedPassword, String password) {
        return ARGON2.verify(hashedPassword, password.toCharArray());
    }


}
