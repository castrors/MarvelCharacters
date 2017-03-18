package com.castrodev.marvelcharacters.repository.Interface;

import android.content.Context;

import com.castrodev.marvelcharacters.model.MarvelCharactersData;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public abstract class MarvelCharactersRespository {
    public abstract MarvelCharactersData getMarvelCharactersData(Context context);
}
