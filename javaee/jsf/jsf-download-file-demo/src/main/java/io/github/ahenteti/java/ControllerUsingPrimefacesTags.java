package io.github.ahenteti.java;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Data
@Named
@ViewScoped
public class ControllerUsingPrimefacesTags implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    private transient StreamedContent file;

    public void exportAction() {
        InputStream stream = new ByteArrayInputStream("some content".getBytes());
        file = new DefaultStreamedContent(stream, "text/plain", "file.txt");
    }

}
