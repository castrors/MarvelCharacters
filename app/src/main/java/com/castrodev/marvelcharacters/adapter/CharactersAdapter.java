package com.castrodev.marvelcharacters.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.castrodev.marvelcharacters.R;
import com.castrodev.marvelcharacters.databinding.ItemCharacterBinding;
import com.castrodev.marvelcharacters.handlers.CharacterClickListener;
import com.castrodev.marvelcharacters.view.CharacterDetailView;
import com.castrodev.marvelcharacters.viewmodel.CharacterViewModel;

import static com.castrodev.marvelcharacters.view.CharacterDetailView.CHARACTER_MODEL;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    private final Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemCharacterBinding binder;

        public ViewHolder(View v) {
            super(v);
            binder = DataBindingUtil.bind(v);
        }
    }

    private ObservableArrayList<CharacterViewModel> list;

    public CharactersAdapter(Context context, ObservableArrayList<CharacterViewModel> l) {
        this.context = context;
        list = l;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final CharacterViewModel character = list.get(position);
        holder.binder.setCharacter(character);
        holder.binder.setClick(new CharacterClickListener() {
            @Override
            public void onCharacterClick(View view) {
                Intent intent = new Intent(context, CharacterDetailView.class);
                intent.putExtra(CHARACTER_MODEL, character.getModel());
                context.startActivity(intent);
            }
        });
        holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
