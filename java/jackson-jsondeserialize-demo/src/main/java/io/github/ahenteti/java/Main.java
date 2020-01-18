package io.github.ahenteti.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static final String JSONPLACEHOLDER_USER_API = "https://jsonplaceholder.typicode.com/users/1";

    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        InputStream httpResponse = httpClient
                .execute(new HttpGet(JSONPLACEHOLDER_USER_API))
                .getEntity().getContent();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer());
        mapper.registerModule(module);
        User user = mapper.readValue(httpResponse, User.class);
        System.out.println(user);
    }
}
