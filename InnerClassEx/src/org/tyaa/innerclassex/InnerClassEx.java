/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.innerclassex;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yurii
 */
public class InnerClassEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(int.class);
        
        //System.out.println(OuterClass.calculate(10));
        //
        try {
            Class.forName("org.tyaa.innerclassex.OuterClass");
            //System.out.println(OuterClass.calculate(10));
            System.out.println(OuterClass.InnerClass.getRatio());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InnerClassEx.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
