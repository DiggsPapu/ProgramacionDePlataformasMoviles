package com.example.mainactivity.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0015H\u0003J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/mainactivity/fragments/CharactersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/mainactivity/adapters/CaracterAdapter$PlaceListener;", "()V", "apiResult", "", "Lcom/example/mainactivity/data/datasource/model/variouscharacters/Result;", "buttonAZ", "Landroid/widget/Button;", "buttonZA", "caracterList", "Lcom/example/mainactivity/classes/Caracter;", "database", "Lcom/example/mainactivity/data/datasource/local_source/CaracterDB;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "syncButton", "Landroid/widget/ImageButton;", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "apiRequest", "", "getCharacters", "initListeners", "onPlaceClicked", "data", "position", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setListeners", "setToolbar", "setUpRecycler", "app_debug"})
public final class CharactersFragment extends androidx.fragment.app.Fragment implements com.example.mainactivity.adapters.CaracterAdapter.PlaceListener {
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.Button buttonAZ;
    private android.widget.Button buttonZA;
    private java.util.List<com.example.mainactivity.data.datasource.model.variouscharacters.Result> apiResult;
    private android.widget.ImageButton syncButton;
    private com.example.mainactivity.data.datasource.local_source.CaracterDB database;
    private java.util.List<com.example.mainactivity.classes.Caracter> caracterList;
    
    public CharactersFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getCharacters() {
    }
    
    private final void apiRequest() {
    }
    
    @java.lang.Override()
    public void onPlaceClicked(@org.jetbrains.annotations.NotNull()
    com.example.mainactivity.classes.Caracter data, int position) {
    }
    
    private final void setUpRecycler() {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void setListeners() {
    }
    
    private final void setToolbar() {
    }
    
    private final void initListeners() {
    }
}