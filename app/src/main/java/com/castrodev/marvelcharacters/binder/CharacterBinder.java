package com.castrodev.marvelcharacters.binder;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.ImageView;

import com.castrodev.marvelcharacters.adapter.CharactersAdapter;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;
import com.squareup.picasso.Picasso;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public class CharacterBinder {

    @BindingAdapter("items")
    public static void bindList(RecyclerView view, ObservableArrayList<CharacterViewModel> characters) {
        StaggeredGridLayoutManager sglm =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        view.setLayoutManager(sglm);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
//        view.setLayoutManager(layoutManager);
        view.setAdapter(new CharactersAdapter(characters));
    }

    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Log.e("LOG_TAG", url);
        Picasso.with(view.getContext()).load(url).error(error).into(view);
    }


}
