package io.github.ahenteti.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;


import static javax.faces.application.FacesMessage.SEVERITY_ERROR;

@Data
@Named
@ViewScoped
public class ControllerUsingStandardJsfTags implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    
    @Inject private FacesContext facesContext;
    @Inject private ExternalContext externalContext;

    public void exportAction() {
        try {
            externalContext.responseReset();
            externalContext.setResponseContentType("text/plain");
            externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"export.txt\"");
            String someContent = "some content";
            copy(new ByteArrayInputStream(someContent.getBytes()), externalContext.getResponseOutputStream());
            facesContext.responseComplete();
        } catch (Exception ex) {
            String summary = "error while exporting your file";
            FacesMessage message = new FacesMessage(SEVERITY_ERROR, summary, ex.getLocalizedMessage());
            facesContext.addMessage(null, message);
        }
    }

    private void copy(InputStream in, OutputStream out) throws IOException {
        try (BufferedInputStream input = new BufferedInputStream(in);
                BufferedOutputStream output = new BufferedOutputStream(out)) {
            byte[] buffer = new byte[10240];
            for (int length; (length = input.read(buffer)) > 0; ) {
                output.write(buffer, 0, length);
            }
        }
    }
}
