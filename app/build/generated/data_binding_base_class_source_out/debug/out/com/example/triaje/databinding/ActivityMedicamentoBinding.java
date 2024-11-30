// Generated by view binder compiler. Do not edit!
package com.example.triaje.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.triaje.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMedicamentoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView additionalInfoCard;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final Button btnGuardar;

  @NonNull
  public final Button btnGuardar2;

  @NonNull
  public final EditText etConciencia;

  @NonNull
  public final EditText etDosis;

  @NonNull
  public final EditText etEstado;

  @NonNull
  public final EditText etFechaHora;

  @NonNull
  public final EditText etHeridasGraves;

  @NonNull
  public final EditText etIdAdministracion;

  @NonNull
  public final EditText etIdPaciente;

  @NonNull
  public final EditText etNombre;

  @NonNull
  public final EditText etPulso;

  @NonNull
  public final EditText etRespiracion;

  @NonNull
  public final EditText etViaAdministracion;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageViewTop;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final CardView medicationFormCard;

  @NonNull
  public final TextView tvConciencia;

  @NonNull
  public final TextView tvDosis;

  @NonNull
  public final TextView tvEstado;

  @NonNull
  public final TextView tvFechaHora;

  @NonNull
  public final TextView tvFormTitle;

  @NonNull
  public final TextView tvFormTitle2;

  @NonNull
  public final TextView tvGreeting;

  @NonNull
  public final TextView tvHeridasGraves;

  @NonNull
  public final TextView tvIdAdministracion;

  @NonNull
  public final TextView tvIdPaciente;

  @NonNull
  public final TextView tvNombre;

  @NonNull
  public final TextView tvPulso;

  @NonNull
  public final TextView tvRespiracion;

  @NonNull
  public final TextView tvViaAdministracion;

  private ActivityMedicamentoBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView additionalInfoCard, @NonNull BottomNavigationView bottomNavigation,
      @NonNull Button btnGuardar, @NonNull Button btnGuardar2, @NonNull EditText etConciencia,
      @NonNull EditText etDosis, @NonNull EditText etEstado, @NonNull EditText etFechaHora,
      @NonNull EditText etHeridasGraves, @NonNull EditText etIdAdministracion,
      @NonNull EditText etIdPaciente, @NonNull EditText etNombre, @NonNull EditText etPulso,
      @NonNull EditText etRespiracion, @NonNull EditText etViaAdministracion,
      @NonNull ImageView imageView2, @NonNull ImageView imageViewTop,
      @NonNull ConstraintLayout main, @NonNull CardView medicationFormCard,
      @NonNull TextView tvConciencia, @NonNull TextView tvDosis, @NonNull TextView tvEstado,
      @NonNull TextView tvFechaHora, @NonNull TextView tvFormTitle, @NonNull TextView tvFormTitle2,
      @NonNull TextView tvGreeting, @NonNull TextView tvHeridasGraves,
      @NonNull TextView tvIdAdministracion, @NonNull TextView tvIdPaciente,
      @NonNull TextView tvNombre, @NonNull TextView tvPulso, @NonNull TextView tvRespiracion,
      @NonNull TextView tvViaAdministracion) {
    this.rootView = rootView;
    this.additionalInfoCard = additionalInfoCard;
    this.bottomNavigation = bottomNavigation;
    this.btnGuardar = btnGuardar;
    this.btnGuardar2 = btnGuardar2;
    this.etConciencia = etConciencia;
    this.etDosis = etDosis;
    this.etEstado = etEstado;
    this.etFechaHora = etFechaHora;
    this.etHeridasGraves = etHeridasGraves;
    this.etIdAdministracion = etIdAdministracion;
    this.etIdPaciente = etIdPaciente;
    this.etNombre = etNombre;
    this.etPulso = etPulso;
    this.etRespiracion = etRespiracion;
    this.etViaAdministracion = etViaAdministracion;
    this.imageView2 = imageView2;
    this.imageViewTop = imageViewTop;
    this.main = main;
    this.medicationFormCard = medicationFormCard;
    this.tvConciencia = tvConciencia;
    this.tvDosis = tvDosis;
    this.tvEstado = tvEstado;
    this.tvFechaHora = tvFechaHora;
    this.tvFormTitle = tvFormTitle;
    this.tvFormTitle2 = tvFormTitle2;
    this.tvGreeting = tvGreeting;
    this.tvHeridasGraves = tvHeridasGraves;
    this.tvIdAdministracion = tvIdAdministracion;
    this.tvIdPaciente = tvIdPaciente;
    this.tvNombre = tvNombre;
    this.tvPulso = tvPulso;
    this.tvRespiracion = tvRespiracion;
    this.tvViaAdministracion = tvViaAdministracion;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMedicamentoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMedicamentoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_medicamento, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMedicamentoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.additional_info_card;
      CardView additionalInfoCard = ViewBindings.findChildViewById(rootView, id);
      if (additionalInfoCard == null) {
        break missingId;
      }

      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.btn_guardar;
      Button btnGuardar = ViewBindings.findChildViewById(rootView, id);
      if (btnGuardar == null) {
        break missingId;
      }

      id = R.id.btn_guardar2;
      Button btnGuardar2 = ViewBindings.findChildViewById(rootView, id);
      if (btnGuardar2 == null) {
        break missingId;
      }

      id = R.id.et_conciencia;
      EditText etConciencia = ViewBindings.findChildViewById(rootView, id);
      if (etConciencia == null) {
        break missingId;
      }

      id = R.id.et_dosis;
      EditText etDosis = ViewBindings.findChildViewById(rootView, id);
      if (etDosis == null) {
        break missingId;
      }

      id = R.id.et_estado;
      EditText etEstado = ViewBindings.findChildViewById(rootView, id);
      if (etEstado == null) {
        break missingId;
      }

      id = R.id.et_fecha_hora;
      EditText etFechaHora = ViewBindings.findChildViewById(rootView, id);
      if (etFechaHora == null) {
        break missingId;
      }

      id = R.id.et_heridas_graves;
      EditText etHeridasGraves = ViewBindings.findChildViewById(rootView, id);
      if (etHeridasGraves == null) {
        break missingId;
      }

      id = R.id.et_id_administracion;
      EditText etIdAdministracion = ViewBindings.findChildViewById(rootView, id);
      if (etIdAdministracion == null) {
        break missingId;
      }

      id = R.id.et_id_paciente;
      EditText etIdPaciente = ViewBindings.findChildViewById(rootView, id);
      if (etIdPaciente == null) {
        break missingId;
      }

      id = R.id.et_nombre;
      EditText etNombre = ViewBindings.findChildViewById(rootView, id);
      if (etNombre == null) {
        break missingId;
      }

      id = R.id.et_pulso;
      EditText etPulso = ViewBindings.findChildViewById(rootView, id);
      if (etPulso == null) {
        break missingId;
      }

      id = R.id.et_respiracion;
      EditText etRespiracion = ViewBindings.findChildViewById(rootView, id);
      if (etRespiracion == null) {
        break missingId;
      }

      id = R.id.et_via_administracion;
      EditText etViaAdministracion = ViewBindings.findChildViewById(rootView, id);
      if (etViaAdministracion == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.imageViewTop;
      ImageView imageViewTop = ViewBindings.findChildViewById(rootView, id);
      if (imageViewTop == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.medication_form_card;
      CardView medicationFormCard = ViewBindings.findChildViewById(rootView, id);
      if (medicationFormCard == null) {
        break missingId;
      }

      id = R.id.tv_conciencia;
      TextView tvConciencia = ViewBindings.findChildViewById(rootView, id);
      if (tvConciencia == null) {
        break missingId;
      }

      id = R.id.tv_dosis;
      TextView tvDosis = ViewBindings.findChildViewById(rootView, id);
      if (tvDosis == null) {
        break missingId;
      }

      id = R.id.tv_estado;
      TextView tvEstado = ViewBindings.findChildViewById(rootView, id);
      if (tvEstado == null) {
        break missingId;
      }

      id = R.id.tv_fecha_hora;
      TextView tvFechaHora = ViewBindings.findChildViewById(rootView, id);
      if (tvFechaHora == null) {
        break missingId;
      }

      id = R.id.tv_form_title;
      TextView tvFormTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvFormTitle == null) {
        break missingId;
      }

      id = R.id.tv_form_title2;
      TextView tvFormTitle2 = ViewBindings.findChildViewById(rootView, id);
      if (tvFormTitle2 == null) {
        break missingId;
      }

      id = R.id.tv_greeting;
      TextView tvGreeting = ViewBindings.findChildViewById(rootView, id);
      if (tvGreeting == null) {
        break missingId;
      }

      id = R.id.tv_heridas_graves;
      TextView tvHeridasGraves = ViewBindings.findChildViewById(rootView, id);
      if (tvHeridasGraves == null) {
        break missingId;
      }

      id = R.id.tv_id_administracion;
      TextView tvIdAdministracion = ViewBindings.findChildViewById(rootView, id);
      if (tvIdAdministracion == null) {
        break missingId;
      }

      id = R.id.tv_id_paciente;
      TextView tvIdPaciente = ViewBindings.findChildViewById(rootView, id);
      if (tvIdPaciente == null) {
        break missingId;
      }

      id = R.id.tv_nombre;
      TextView tvNombre = ViewBindings.findChildViewById(rootView, id);
      if (tvNombre == null) {
        break missingId;
      }

      id = R.id.tv_pulso;
      TextView tvPulso = ViewBindings.findChildViewById(rootView, id);
      if (tvPulso == null) {
        break missingId;
      }

      id = R.id.tv_respiracion;
      TextView tvRespiracion = ViewBindings.findChildViewById(rootView, id);
      if (tvRespiracion == null) {
        break missingId;
      }

      id = R.id.tv_via_administracion;
      TextView tvViaAdministracion = ViewBindings.findChildViewById(rootView, id);
      if (tvViaAdministracion == null) {
        break missingId;
      }

      return new ActivityMedicamentoBinding((ConstraintLayout) rootView, additionalInfoCard,
          bottomNavigation, btnGuardar, btnGuardar2, etConciencia, etDosis, etEstado, etFechaHora,
          etHeridasGraves, etIdAdministracion, etIdPaciente, etNombre, etPulso, etRespiracion,
          etViaAdministracion, imageView2, imageViewTop, main, medicationFormCard, tvConciencia,
          tvDosis, tvEstado, tvFechaHora, tvFormTitle, tvFormTitle2, tvGreeting, tvHeridasGraves,
          tvIdAdministracion, tvIdPaciente, tvNombre, tvPulso, tvRespiracion, tvViaAdministracion);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
