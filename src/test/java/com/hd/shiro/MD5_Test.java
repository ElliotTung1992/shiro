package com.hd.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5_Test {
    public static void main(String[] args) {
        String password = "wobuaini";
        String salt = "no";
        int count = 3;
        Md5Hash md5Hash = new Md5Hash(password, salt, count);
        System.out.println(md5Hash.toString());

        SimpleHash simpleHash = new SimpleHash("md5", password, salt, count);
        System.out.println(simpleHash.toString());
    }
}
