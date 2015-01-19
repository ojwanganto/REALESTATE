package org.restate.project.model;

/**
 * Defines the different modes of payments e.g cash, bank and mobile money
 */
public class PaymentMode {
    private Integer id;
    private String name;

   /* private Integer isEnabled;*/

    public PaymentMode(){}

    public PaymentMode(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public Integer getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Integer enabled) {
        isEnabled = enabled;
    }*/
}
