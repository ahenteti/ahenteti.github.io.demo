package io.github.ahenteti.java;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Mojo(name = "sayhi", defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class HelloWorldMojo extends AbstractMojo {

    @Parameter(property = "sayhi.greeting", defaultValue = "Hello World!")
    private String greeting;

    public void execute() throws MojoExecutionException {
        getLog().info(greeting);
    }

}
