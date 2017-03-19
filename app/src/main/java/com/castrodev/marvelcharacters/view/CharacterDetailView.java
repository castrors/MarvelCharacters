package com.castrodev.marvelcharacters.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.databinding.CharacterDetailViewBinding;
import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;

public class CharacterDetailView extends AppCompatActivity {

    public static final String CHARACTER_MODEL = "CHARACTER_MODEL";
    private CharacterViewModel characterViewModel;
    private CharacterDetailViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Character character = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey(CHARACTER_MODEL)) {
            character = bundle.getParcelable(CHARACTER_MODEL);
        }

        characterViewModel = new CharacterViewModel(character);
        getSupportActionBar().setTitle(characterViewModel.getName());
        binding = DataBindingUtil.setContentView(CharacterDetailView.this, R.layout.character_detail_view);
        binding.setCharacter(characterViewModel);


    }

}
