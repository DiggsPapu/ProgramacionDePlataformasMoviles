package com.example.mainactivity.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/mainactivity/adapters/CharacterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/mainactivity/adapters/CharacterAdapter$ViewHolder;", "characters", "", "Lcom/example/mainactivity/data/datasource/model/variouscharacters/Result;", "listener", "Lcom/example/mainactivity/adapters/CharacterAdapter$PlaceListener;", "(Ljava/util/List;Lcom/example/mainactivity/adapters/CharacterAdapter$PlaceListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PlaceListener", "ViewHolder", "app_debug"})
public final class CharacterAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.mainactivity.adapters.CharacterAdapter.ViewHolder> {
    private final java.util.List<com.example.mainactivity.data.datasource.model.variouscharacters.Result> characters = null;
    private final com.example.mainactivity.adapters.CharacterAdapter.PlaceListener listener = null;
    
    public CharacterAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.mainactivity.data.datasource.model.variouscharacters.Result> characters, @org.jetbrains.annotations.NotNull()
    com.example.mainactivity.adapters.CharacterAdapter.PlaceListener listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.mainactivity.adapters.CharacterAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.mainactivity.adapters.CharacterAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/mainactivity/adapters/CharacterAdapter$PlaceListener;", "", "onPlaceClicked", "", "data", "Lcom/example/mainactivity/data/datasource/model/variouscharacters/Result;", "position", "", "app_debug"})
    public static abstract interface PlaceListener {
        
        public abstract void onPlaceClicked(@org.jetbrains.annotations.NotNull()
        com.example.mainactivity.data.datasource.model.variouscharacters.Result data, int position);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/mainactivity/adapters/CharacterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/example/mainactivity/adapters/CharacterAdapter$PlaceListener;", "(Landroid/view/View;Lcom/example/mainactivity/adapters/CharacterAdapter$PlaceListener;)V", "characteristics", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "image", "Landroid/widget/ImageView;", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "name", "bind", "", "character", "Lcom/example/mainactivity/data/datasource/model/variouscharacters/Result;", "setListeners", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.view.View view = null;
        private final com.example.mainactivity.adapters.CharacterAdapter.PlaceListener listener = null;
        private final android.widget.ImageView image = null;
        private final android.widget.TextView name = null;
        private final android.widget.TextView characteristics = null;
        private final androidx.constraintlayout.widget.ConstraintLayout layout = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        com.example.mainactivity.adapters.CharacterAdapter.PlaceListener listener) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.mainactivity.data.datasource.model.variouscharacters.Result character) {
        }
        
        private final void setListeners(com.example.mainactivity.data.datasource.model.variouscharacters.Result character) {
        }
    }
}