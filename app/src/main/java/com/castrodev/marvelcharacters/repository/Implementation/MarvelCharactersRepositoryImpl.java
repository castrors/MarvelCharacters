package com.castrodev.marvelcharacters.repository.Implementation;

import android.content.Context;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.model.MarvelCharactersData;
import com.castrodev.marvelcharacters.repository.Interface.MarvelCharactersRespository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class MarvelCharactersRepositoryImpl extends MarvelCharactersRespository {


    @Override
    public MarvelCharactersData getMarvelCharactersData(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.marvel_api_mock);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));

        Gson gson = new Gson();
        return gson.fromJson(reader, MarvelCharactersData.class);
    }

    @Override
    public Character getMarvelCharacterById(Context context, Long id) {

        MarvelCharactersData marvelCharactersData = getMarvelCharactersData(context);
        List<Character> characters = marvelCharactersData.getData().getCharacters();
        for (Character character : characters) {
            if (character.getId().equals(id)) {
                return character;
            }
        }
        return new Character("");
    }
}
