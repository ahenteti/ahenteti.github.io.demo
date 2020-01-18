package io.github.ahenteti.java;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class UserDeserializer extends StdDeserializer<User> {

    public UserDeserializer() {
        this(null);
    }
    
    public UserDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode userNode = jsonParser.getCodec().readTree(jsonParser);
        String username = userNode.get("username").asText();
        String email = userNode.get("email").asText();
        String website = userNode.get("website").asText();
        JsonNode companyNode = userNode.get("company");
        String company = companyNode.get("name").asText();
        return new User(username, email, website, company);
    }
}
