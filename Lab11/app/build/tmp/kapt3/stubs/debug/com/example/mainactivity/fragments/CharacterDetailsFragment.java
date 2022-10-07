package com.example.mainactivity.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/mainactivity/fragments/CharacterDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "apperances", "Landroid/widget/TextView;", "args", "Lcom/example/mainactivity/fragments/CharacterDetailsFragmentArgs;", "getArgs", "()Lcom/example/mainactivity/fragments/CharacterDetailsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "database", "Lcom/example/mainactivity/data/datasource/local_source/CaracterDB;", "gender", "imageView", "Landroid/widget/ImageView;", "name", "origin", "result", "Lcom/example/mainactivity/data/datasource/model/onecharacter/AllAssetsForOneCharacterResponse;", "species", "status", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "apiRequest", "", "initListeners", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setAll", "setToolbar", "app_debug"})
public final class CharacterDetailsFragment extends androidx.fragment.app.Fragment {
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private android.widget.ImageView imageView;
    private android.widget.TextView name;
    private android.widget.TextView species;
    private android.widget.TextView status;
    private android.widget.TextView gender;
    private android.widget.TextView origin;
    private android.widget.TextView apperances;
    private com.example.mainactivity.data.datasource.model.onecharacter.AllAssetsForOneCharacterResponse result;
    private com.example.mainactivity.data.datasource.local_source.CaracterDB database;
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
    
    private final void setAll() {
    }
    
    private final void apiRequest() {
    }
    
    private final void setToolbar() {
    }
    
    private final void initListeners() {
    }
}