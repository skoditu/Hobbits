/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glory.schema;

/**
 *
 * @author Hashane
 */
public class ConstantElement extends GloryElement{

    private int numericValueInt;
    
    //----Constructor
    public ConstantElement(int numericValueInt) {
        this.numericValueInt = numericValueInt;
    }
    //----Getters
    public int getnumericValueInt() {
        return numericValueInt;
    }
  
    }

