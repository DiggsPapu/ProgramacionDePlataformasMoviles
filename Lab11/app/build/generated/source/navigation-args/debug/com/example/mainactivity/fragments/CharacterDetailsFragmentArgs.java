package com.example.mainactivity.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CharacterDetailsFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CharacterDetailsFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CharacterDetailsFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CharacterDetailsFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CharacterDetailsFragmentArgs __result = new CharacterDetailsFragmentArgs();
    bundle.setClassLoader(CharacterDetailsFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("characterID")) {
      String characterID;
      characterID = bundle.getString("characterID");
      if (characterID == null) {
        throw new IllegalArgumentException("Argument \"characterID\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("characterID", characterID);
    } else {
      throw new IllegalArgumentException("Required argument \"characterID\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CharacterDetailsFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    CharacterDetailsFragmentArgs __result = new CharacterDetailsFragmentArgs();
    if (savedStateHandle.contains("characterID")) {
      String characterID;
      characterID = savedStateHandle.get("characterID");
      if (characterID == null) {
        throw new IllegalArgumentException("Argument \"characterID\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("characterID", characterID);
    } else {
      throw new IllegalArgumentException("Required argument \"characterID\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getCharacterID() {
    return (String) arguments.get("characterID");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("characterID")) {
      String characterID = (String) arguments.get("characterID");
      __result.putString("characterID", characterID);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("characterID")) {
      String characterID = (String) arguments.get("characterID");
      __result.set("characterID", characterID);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CharacterDetailsFragmentArgs that = (CharacterDetailsFragmentArgs) object;
    if (arguments.containsKey("characterID") != that.arguments.containsKey("characterID")) {
      return false;
    }
    if (getCharacterID() != null ? !getCharacterID().equals(that.getCharacterID()) : that.getCharacterID() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCharacterID() != null ? getCharacterID().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CharacterDetailsFragmentArgs{"
        + "characterID=" + getCharacterID()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CharacterDetailsFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String characterID) {
      if (characterID == null) {
        throw new IllegalArgumentException("Argument \"characterID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("characterID", characterID);
    }

    @NonNull
    public CharacterDetailsFragmentArgs build() {
      CharacterDetailsFragmentArgs result = new CharacterDetailsFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCharacterID(@NonNull String characterID) {
      if (characterID == null) {
        throw new IllegalArgumentException("Argument \"characterID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("characterID", characterID);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getCharacterID() {
      return (String) arguments.get("characterID");
    }
  }
}
