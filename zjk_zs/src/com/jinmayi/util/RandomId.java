package com.jinmayi.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;  

public class RandomId {  
    private Random random;  
    private String table;  
    public RandomId() {  
        random = new Random();  
        table = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    }  
    public String randomId(int id) {  
        String ret = null,  
            num = String.format("%03d", id);  
        int key = random.nextInt(10),   
            seed = random.nextInt(100);  
        Caesar caesar = new Caesar(table, seed);  
        num = caesar.encode(key, num);  
        ret = num   
            + String.format("%01d", key)   
            + String.format("%02d", seed);  
          
        return ret;  
    }  
    public static void main(String[] args) {  
        RandomId r = new RandomId();  
        Set<String> s = new HashSet<String>();
        for (int i = 0; i < 1000000; i += 1) {  
        	s.add(r.randomId(i));
        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
//        for (int i = 0; i < 100000; i += 1) {  
//        	s.add(r.randomId(i));
//        }
        System.out.println(s.size());
        System.out.println(1000000-s.size());
    }  
}