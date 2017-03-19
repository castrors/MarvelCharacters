package com.castrodev.marvelcharacters.handlers;

import com.castrodev.marvelcharacters.model.MarvelCharactersData;

/**
 * Created by rodrigocastro on 19/03/17.
 */

public interface CharacterRequestCallback {

    void onRequestDone(MarvelCharactersData marvelCharactersData);
    void onRequestError();
}
