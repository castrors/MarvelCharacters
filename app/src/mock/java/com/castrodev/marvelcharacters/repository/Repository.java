package com.castrodev.marvelcharacters.repository;

import com.castrodev.marvelcharacters.repository.Implementation.FakeMarvelCharactersRepositoryImpl;
import com.castrodev.marvelcharacters.repository.Interface.FakeMarvelCharactersRespository;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class Repository {

    private static FakeMarvelCharactersRespository charactersRespository;

    public static FakeMarvelCharactersRespository providesCharactersRepository() {
        if (charactersRespository == null)
            charactersRespository = new FakeMarvelCharactersRepositoryImpl();
        return charactersRespository;
    }

}
