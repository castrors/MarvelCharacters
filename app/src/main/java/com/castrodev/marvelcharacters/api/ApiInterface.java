package com.castrodev.marvelcharacters.api;

import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.model.MarvelCharactersData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public interface ApiInterface {

    @GET("characters")
    Call<MarvelCharactersData> fetchCharacters( @QueryMap Map<String, String> options);

    @GET("characters/{id}")
    Call<Character> fetchCharacter(@Path("id") Long characterId, @QueryMap Map<String, String> options);
}
