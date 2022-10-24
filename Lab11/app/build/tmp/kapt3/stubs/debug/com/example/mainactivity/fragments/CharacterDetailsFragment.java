package com.example.mainactivity.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u001a\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/example/mainactivity/fragments/CharacterDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "apperances", "Lcom/google/android/material/textfield/TextInputLayout;", "args", "Lcom/example/mainactivity/fragments/CharacterDetailsFragmentArgs;", "getArgs", "()Lcom/example/mainactivity/fragments/CharacterDetailsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "character", "Lcom/example/mainactivity/classes/Caracter;", "database", "Lcom/example/mainactivity/data/datasource/local_source/CaracterDB;", "gender", "imageView", "Landroid/widget/ImageView;", "name", "origin", "result", "Lcom/example/mainactivity/data/datasource/model/onecharacter/AllAssetsForOneCharacterResponse;", "save", "Landroid/widget/Button;", "species", "status", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "apiRequest", "", "deleteCharacter", "getCharacter", "imageRequest", "initListeners", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setAll", "setCharacter", "setToolbar", "updateCharacter", "app_debug"})
public final class CharacterDetailsFragment extends androidx.fragment.app.Fragment {
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private android.widget.ImageView imageView;
    private com.google.android.material.textfield.TextInputLayout name;
    private com.google.android.material.textfield.TextInputLayout species;
    private com.google.android.material.textfield.TextInputLayout status;
    private com.google.android.material.textfield.TextInputLayout gender;
    private com.google.android.material.textfield.TextInputLayout origin;
    private com.google.android.material.textfield.TextInputLayout apperances;
    private com.example.mainactivity.data.datasource.model.onecharacter.AllAssetsForOneCharacterResponse result;
    private com.example.mainactivity.data.datasource.local_source.CaracterDB database;
    private com.example.mainactivity.classes.Caracter character;
    private android.widget.Button save;
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    
    public CharacterDetailsFragment() {
        super();
    }
    
    private final com.example.mainactivity.fragments.CharacterDetailsFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getCharacter() {
    }
    
    private final void setCharacter() {
    }
    
    private final void setAll() {
    }
    
    private final void apiRequest() {
    }
    
    private final void imageRequest() {
    }
    
    private final void initListeners() {
    }
    
    private final void updateCharacter() {
    }
    
    private final void deleteCharacter() {
    }
    
    private final void setToolbar() {
    }
}