package com.example.daan.fortnitestats;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Deserializer<LifeTimeStats> implements JsonDeserializer<LifeTimeStats> {
    @Override
    public LifeTimeStats deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        boolean isJson = jsonElement.isJsonArray();
        JsonElement lifeTimeStats = jsonElement.getAsJsonArray().get(0);


        return new Gson().fromJson(lifeTimeStats, typeOfT);
    }
}
