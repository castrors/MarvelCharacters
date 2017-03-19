package com.castrodev.marvelcharacters.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.databinding.CharactersListViewBinding;
import com.castrodev.marvelcharacters.handlers.CharacterRequestCallback;
import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.model.MarvelCharactersData;
import com.castrodev.marvelcharacters.repository.Repository;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;
import com.castrodev.marvelcharacters.viewmodel.CharactersViewModel;

public class CharactersListView extends AppCompatActivity {

    private CharactersViewModel charactersViewModel;
    private CharactersListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        charactersViewModel = new CharactersViewModel();

        CharacterRequestCallback callback = new CharacterRequestCallback() {
            @Override
            public void onRequestDone(MarvelCharactersData marvelCharactersData) {
                for (Character character : marvelCharactersData.getData().getCharacters()) {
                    character.setName(character.getName());
                    charactersViewModel.characters.add(new CharacterViewModel(character));
                }
            }

            @Override
            public void onRequestError() {
                Log.e("TAG_LOG", "onRequestError");
            }
        };

        Repository.providesCharactersRepository().getMarvelCharactersData(this, callback);

        binding = DataBindingUtil.setContentView(this, R.layout.characters_list_view);
        binding.setCharactersViewModel(charactersViewModel);

    }

}
