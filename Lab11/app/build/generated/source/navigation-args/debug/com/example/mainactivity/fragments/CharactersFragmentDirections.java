package com.example.mainactivity.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.mainactivity.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CharactersFragmentDirections {
  private CharactersFragmentDirections() {
  }

  @NonNull
  public static ActionCharactersFragment2ToCharacterDetailsFragment actionCharactersFragment2ToCharacterDetailsFragment(
      @NonNull String characterID) {
    return new ActionCharactersFragment2ToCharacterDetailsFragment(characterID);
  }

  @NonNull
  public static NavDirections actionCharactersFragment2ToLogIn() {
    return new ActionOnlyNavDirections(R.id.action_charactersFragment2_to_logIn);
  }

  public static class ActionCharactersFragment2ToCharacterDetailsFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionCharactersFragment2ToCharacterDetailsFragment(@NonNull String characterID) {
      if (characterID == null) {
        throw new IllegalArgumentException("Argument \"characterID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("characterID", characterID);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCharactersFragment2ToCharacterDetailsFragment setCharacterID(
        @NonNull String characterID) {
      if (characterID == null) {
        throw new IllegalArgumentException("Argument \"characterID\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("characterID", characterID);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("characterID")) {
        String characterID = (String) arguments.get("characterID");
        __result.putString("characterID", characterID);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_charactersFragment2_to_characterDetailsFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCharacterID() {
      return (String) arguments.get("characterID");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCharactersFragment2ToCharacterDetailsFragment that = (ActionCharactersFragment2ToCharacterDetailsFragment) object;
      if (arguments.containsKey("characterID") != that.arguments.containsKey("characterID")) {
        return false;
      }
      if (getCharacterID() != null ? !getCharacterID().equals(that.getCharacterID()) : that.getCharacterID() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getCharacterID() != null ? getCharacterID().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCharactersFragment2ToCharacterDetailsFragment(actionId=" + getActionId() + "){"
          + "characterID=" + getCharacterID()
          + "}";
    }
  }
}
