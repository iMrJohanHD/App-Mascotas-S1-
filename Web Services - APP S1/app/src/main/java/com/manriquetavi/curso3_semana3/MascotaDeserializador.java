package com.manriquetavi.curso3_semana3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse petResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        petResponse.setProfileItems(deserializarMascotaJson(mascotaResponseData));
        return petResponse;
    }

    private ArrayList<ProfileItem> deserializarMascotaJson(JsonArray mascotaResponseData) {
        ArrayList<ProfileItem> profileItems = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {

            JsonObject petResponseDataObject    = mascotaResponseData.get(i).getAsJsonObject();
            String id                           = petResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String media_url                    = petResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            int media_likes                     = petResponseDataObject.get(JsonKeys.MEDIA_LIKES).getAsInt();

            ProfileItem currentPetProfile = new ProfileItem();
            currentPetProfile.setId(id);
            currentPetProfile.setUrlPetPic(media_url);
            currentPetProfile.setLikes(media_likes);
            profileItems.add(currentPetProfile);

        }
        return profileItems;
    }
}
