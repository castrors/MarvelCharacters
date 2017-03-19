package com.castrodev.marvelcharacters.repository;

import com.castrodev.marvelcharacters.repository.Implementation.MarvelCharactersRepositoryImpl;
import com.castrodev.marvelcharacters.repository.Interface.MarvelCharactersRespository;


/**
 * Created by rodrigocastro on 04/03/17.
 */

public class Repository {

    private static MarvelCharactersRespository charactersRespository;

    public static MarvelCharactersRespository providesCharactersRepository() {
        if (charactersRespository == null)
            charactersRespository = new MarvelCharactersRepositoryImpl();
        return charactersRespository;
    }

}
