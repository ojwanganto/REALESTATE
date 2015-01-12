package org.restate.project.model;

/**
 * Defines the different types of payments
 */
public class PaymentType{
    private Integer id;
    private String name;

   /* private Integer isEnabled;*/

    public PaymentType(){}

    public PaymentType(Integer id, String name){
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
