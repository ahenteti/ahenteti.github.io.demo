package io.github.ahenteti.java;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@SessionScoped
public class EditorBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    private String value;

}
