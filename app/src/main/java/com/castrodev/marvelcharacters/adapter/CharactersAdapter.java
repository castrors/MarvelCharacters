package com.castrodev.marvelcharacters.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castrodev.marvelcharacters.handlers.CharacterClickListener;
import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.databinding.ItemCharacterBinding;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemCharacterBinding binder;

        public ViewHolder(View v) {
            super(v);
            binder = DataBindingUtil.bind(v);
        }
    }

    private ObservableArrayList<CharacterViewModel> list;

    public CharactersAdapter(ObservableArrayList<CharacterViewModel> l) {
        list = l;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CharacterViewModel character = list.get(position);
        holder.binder.setCharacter(character);
        holder.binder.setClick(new CharacterClickListener() {
            @Override
            public void onCharacterClick(View view) {
                Log.e("TAG_LOG", character.getName());
            }
        });
        holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
