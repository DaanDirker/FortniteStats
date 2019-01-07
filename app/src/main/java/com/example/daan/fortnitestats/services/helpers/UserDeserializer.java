package com.example.daan.fortnitestats.services.helpers;

import com.example.daan.fortnitestats.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);

        JsonArray lifeTimeStatsArray = json.getAsJsonObject().get("lifeTimeStats").getAsJsonArray();
        Map<String, String> lifeTimeStatsMap = new HashMap<>();

        //Map JsonArray to a HashMap
        for (JsonElement element : lifeTimeStatsArray) {
            String key = element.getAsJsonObject().get("key").getAsString();
            String value = element.getAsJsonObject().get("value").getAsString();
            lifeTimeStatsMap.put(key, value);
        }
        user.setLifeTimeStats(lifeTimeStatsMap);

        return user;
    }
}
