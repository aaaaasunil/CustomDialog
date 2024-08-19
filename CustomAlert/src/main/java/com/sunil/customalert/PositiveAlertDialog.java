package com.sunil.customalert;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.sunil.customalert.databinding.DialogPositiveAlertBinding;

import java.util.Objects;

public class PositiveAlertDialog extends Dialog {
    public static final int NORMAL_TYPE = 0;

    private static DialogPositiveAlertBinding binding;
    Context context;

    public PositiveAlertDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DialogPositiveAlertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initDialog();
        setOnClickListener();
        //setTitleText("nnc",R.color.black);
       // setDescription("nnc",R.color.black,0);

    }

    /**
     * Configuring dialog's properties
     */
    private void initDialog() {
        setCancelable(true);


        Objects.requireNonNull(getWindow()).setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
        );
        getWindow().setBackgroundDrawable(
                new ColorDrawable(ContextCompat.getColor(context, R.color.transparentBlack)));
    }

    private void setOnClickListener() {
        binding.btnOK.setOnClickListener(clickListener);
    }

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnOK) {
                dismiss();
            }
        }
    };

    public void setTitleText(String title, Integer textColor) {
        binding.tvTitle.setText(title);
        binding.tvTitle.setTextColor(textColor);
    }

    public void setDescription(String title, Integer textColor, Integer visibility) {
        binding.tvDescription.setVisibility(visibility);
        binding.tvDescription.setText(title);
        binding.tvDescription.setTextColor(textColor);
    }

    public  void setButton(String title, Integer textColor, String backgroundTint) {
        binding.btnOK.setText(title);
        binding.btnOK.setTextColor(textColor);
        binding.btnOK.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(backgroundTint)));

    }

    public void showDialog() {

        show();
    }
}
