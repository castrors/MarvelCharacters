package com.castrodev.marvelcharacters.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.databinding.CharacterDetailViewBinding;
import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.repository.Repository;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;

public class CharacterDetailView extends AppCompatActivity {

    public static final String CHARACTER_ID = "CHARACTER_ID";
    private CharacterViewModel characterViewModel;
    private CharacterDetailViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Long characterId = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey(CHARACTER_ID)) {
            characterId = bundle.getLong(CHARACTER_ID);
        }

        Character character = Repository.providesCharactersRepository().getMarvelCharacterById(this, characterId);
        characterViewModel = new CharacterViewModel(character);

        binding = DataBindingUtil.setContentView(this, R.layout.character_detail_view);
        binding.setCharacter(characterViewModel);

        getSupportActionBar().setTitle(characterViewModel.getName());

    }

}
