package com.demo.jedis;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println(0.1 * 3 == 0.3); //false

        System.out.println(0.1 * 3);    //0.30000000000000004，默认是double
        System.out.println(0.1f * 3);   //0.3
    }
}
