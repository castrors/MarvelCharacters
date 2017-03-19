package com.castrodev.marvelcharacters.repository.Interface;

import android.content.Context;

import com.castrodev.marvelcharacters.handlers.CharacterRequestCallback;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public abstract class FakeMarvelCharactersRespository {

    public abstract void getMarvelCharactersData(Context context, CharacterRequestCallback callback);
}
