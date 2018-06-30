/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.innerclassex;

/**
 *
 * @author Yurii
 */
public class OuterClass {
    private static int mRatioInt;
    
    public static int calculate(int _x){
        return _x * mRatioInt;
    }
    
    static{
        mRatioInt = 5;
        System.out.println("OuterClass was loaded");
    }
    
    public static class InnerClass{
        public static int getRatio(){
            return mRatioInt;
        }
        
        static{
            System.out.println("InnerClass was loaded");
        }
    }
}
