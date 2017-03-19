package com.castrodev.marvelcharacters.repository.Implementation;

import android.content.Context;

import com.castrodev.marvelcharacters.api.ApiClient;
import com.castrodev.marvelcharacters.api.ApiInterface;
import com.castrodev.marvelcharacters.handlers.CharacterRequestCallback;
import com.castrodev.marvelcharacters.model.MarvelCharactersData;
import com.castrodev.marvelcharacters.repository.Interface.MarvelCharactersRespository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rodrigocastro on 04/03/17.
 */

public class MarvelCharactersRepositoryImpl extends MarvelCharactersRespository {


    @Override
    public void getMarvelCharactersData(Context context, final CharacterRequestCallback callback) {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MarvelCharactersData> call = apiService.fetchCharacters(ApiClient.getData());
        call.enqueue(new Callback<MarvelCharactersData>() {
            @Override
            public void onResponse(Call<MarvelCharactersData> call, Response<MarvelCharactersData> response) {
                callback.onRequestDone(response.body());
            }

            @Override
            public void onFailure(Call<MarvelCharactersData> call, Throwable t) {
                callback.onRequestError();
            }
        });
    }
}
