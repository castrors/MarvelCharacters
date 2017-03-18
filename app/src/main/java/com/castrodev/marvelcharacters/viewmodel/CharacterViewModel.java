package com.castrodev.marvelcharacters.viewmodel;

import android.databinding.BaseObservable;

import com.castrodev.marvelcharacters.model.Character;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public class CharacterViewModel extends BaseObservable {

    private final Character model;

    public CharacterViewModel(Character model) {
        this.model = model;
    }

    public Character getModel() {
        return model;
    }

    public String getName() {
        return model.getName();
    }

}
