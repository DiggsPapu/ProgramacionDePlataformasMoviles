package com.example.mainactivity.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.mainactivity.R;

public class CharacterDetailsFragmentDirections {
  private CharacterDetailsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCharacterDetailsFragmentToLogIn() {
    return new ActionOnlyNavDirections(R.id.action_characterDetailsFragment_to_logIn);
  }
}
