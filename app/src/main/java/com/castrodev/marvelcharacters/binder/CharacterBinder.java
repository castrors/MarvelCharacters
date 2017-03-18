package com.castrodev.marvelcharacters.binder;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.castrodev.marvelcharacters.adapter.CharactersAdapter;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public class CharacterBinder {

    @BindingAdapter("items")
    public static void bindList(RecyclerView view, ObservableArrayList<CharacterViewModel> characters) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new CharactersAdapter(characters));
    }

}
