package com.castrodev.marvelcharacters.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import com.castrodev.marvelcharacters.model.Character;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public class CharactersViewModel extends BaseObservable{
    @Bindable
    public ObservableArrayList<CharacterViewModel> characters;

    public CharactersViewModel()
    {
        this.characters = new ObservableArrayList<>();
    }

    public void addCharacter(String name)
    {
        this.characters.add(new CharacterViewModel(new Character(name)));
    }

}