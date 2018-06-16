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
public class VariableElement extends GloryElement{

    
    
    private String VariableName;
    
    public VariableElement(String VariableName) {
        this.VariableName = VariableName;
    }
    
    public String getVariableName() {
        return VariableName;
    }
    
    public void setVariableName(String VariableName) {
        this.VariableName = VariableName;
    }
    
}
