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
public class FunctionElement extends GloryElement{
    private String functionName;

    public FunctionElement(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionName() {
        return functionName;
    }
    
}
