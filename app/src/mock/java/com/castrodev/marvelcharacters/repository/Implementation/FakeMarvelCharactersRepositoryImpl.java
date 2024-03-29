package com.castrodev.marvelcharacters.repository.Implementation;

import android.content.Context;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.handlers.CharacterRequestCallback;
import com.castrodev.marvelcharacters.model.MarvelCharactersData;
import com.castrodev.marvelcharacters.repository.Interface.FakeMarvelCharactersRespository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class FakeMarvelCharactersRepositoryImpl extends FakeMarvelCharactersRespository {


    @Override
    public void getMarvelCharactersData(Context context, final CharacterRequestCallback callback) {

        InputStream inputStream = context.getResources().openRawResource(R.raw.marvel_api_mock);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));

        Gson gson = new Gson();
        callback.onRequestDone(gson.fromJson(reader, MarvelCharactersData.class));
    }
}
