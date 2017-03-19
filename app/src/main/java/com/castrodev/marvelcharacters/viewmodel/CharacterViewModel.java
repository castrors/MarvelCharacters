package com.castrodev.marvelcharacters.viewmodel;

import android.databinding.BaseObservable;

import com.castrodev.marvelcharacters.model.Character;
import com.castrodev.marvelcharacters.model.Thumbnail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by rodrigocastro on 18/03/17.
 */

public class CharacterViewModel extends BaseObservable {

    private final Character model;

    public CharacterViewModel(Character model) {
        this.model = model;
    }

    public Character getModel() {
        return model;
    }

    public Long getId() {
        return model.getId();
    }

    public String getName() {
        return model.getName();
    }

    public String getThumbnail() {
        Thumbnail thumbnail = model.getThumbnail();
        return thumbnail.getPath() + "." + thumbnail.getExtension();
    }

    public String getDescription() {
        return model.getDescription();
    }

    public String getModified() {

        String modified = model.getModified();

        String patternInput = "yyyy-MM-dd'T'HH:mm:ssZ";
        String patternOutput = "yyyy-MM-dd";
        SimpleDateFormat dt = new SimpleDateFormat(patternInput, Locale.getDefault());
        Date date = null;
        try {
            date = dt.parse(modified);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternOutput);
        return simpleDateFormat.format(date);

    }

    public String getComics() {
        return model.getComics().getAvailable().toString();
    }

    public String getSeries() {
        return model.getSeries().getAvailable().toString();
    }

    public String getStories() {
        return model.getStories().getAvailable().toString();
    }

    public String getEvents() {
        return model.getEvents().getAvailable().toString();
    }

}
