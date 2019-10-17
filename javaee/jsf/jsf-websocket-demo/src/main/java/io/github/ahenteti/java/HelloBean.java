package io.github.ahenteti.java;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Data;

@Data
@Named
@RequestScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

    @Inject @Push private PushContext myChannel;

    public void send() {
        myChannel.send("Hello, from the server by push!");
    }

}
