package com.example.mainactivity.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.mainactivity.R;

public class LogInDirections {
  private LogInDirections() {
  }

  @NonNull
  public static NavDirections actionLogInToCharactersFragment2() {
    return new ActionOnlyNavDirections(R.id.action_logIn_to_charactersFragment2);
  }
}
