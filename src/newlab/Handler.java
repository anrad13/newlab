package newlab;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.UUID;

@SessionScoped
@ManagedBean
//@Named
//@Stateful

//@SessionScoped

public class Handler implements Serializable {
    private String result = "result undefine";
    private String value = "undefine";

    private UUID uuid = UUID.randomUUID();

    @PostConstruct
    public void init() {

    }

    public String apply(){
        this.value =  "My name is Name bean";
        this.result =  "Simple result \n Line 2";
        //return "name.xhtml";
        return null;
    }

    public String getValue() {
        return new java.util.Date ().toString () + ": " + uuid + ": " + value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResult() {
        return result ;
    }

    public void setResult(String value) {
        this.result = result;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


}
