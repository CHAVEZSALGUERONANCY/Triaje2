// Generated by view binder compiler. Do not edit!
package com.example.triaje.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.triaje.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageViewLogo;

  @NonNull
  public final ConstraintLayout main;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageViewLogo,
      @NonNull ConstraintLayout main) {
    this.rootView = rootView;
    this.imageViewLogo = imageViewLogo;
    this.main = main;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageViewLogo;
      ImageView imageViewLogo = ViewBindings.findChildViewById(rootView, id);
      if (imageViewLogo == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      return new ActivityMainBinding((ConstraintLayout) rootView, imageViewLogo, main);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
