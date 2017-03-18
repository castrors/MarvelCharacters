package com.castrodev.marvelcharacters.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.databinding.CharactersListViewBinding;
import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.model.MarvelCharactersData;
import com.castrodev.marvelcharacters.repository.Repository;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;
import com.castrodev.marvelcharacters.viewmodel.CharactersViewModel;

import java.util.List;

public class CharactersListView extends AppCompatActivity {

    private CharactersViewModel charactersViewModel;
    private CharactersListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        charactersViewModel = new CharactersViewModel();

        MarvelCharactersData marvelCharactersData = Repository.providesCharactersRepository().getMarvelCharactersData(this);
        List<Character> characterList = marvelCharactersData.getData().getCharacters();
        for (Character character : characterList) {
            character.setName(character.getName());
            charactersViewModel.characters.add(new CharacterViewModel(character));
        }

        binding = DataBindingUtil.setContentView(this, R.layout.characters_list_view);
        binding.setCharactersViewModel(charactersViewModel);

    }

}
