package com.ugunay.customprogressdialog;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.ugunay.customprogressdialog.databinding.CustomProgressDialogBinding;

/**
 * ************************** <b>Created by Uğur Günay on 09/09/2022.</b> **************************
 * <p>
 * Bu kütüphane {@link Deprecated} olmuş {@link android.app.ProgressDialog ProgressDialog}
 * sınıfına alternatif olarak yazılmıştır. Bu <code>ProgressDialog</code> tasarımı mesaj
 * olmadan da kullanılabilir.
 * </p>
 * <p>
 * Yazılımcı isterse geliştirdiği uygulamanın <code>launcher activity</code> sayfasında
 * sınıfın <code>static</code> fonksiyonlarını kullanarak sınıfın özelliklerine bir
 * kereliğine atama yapabilir ve yapmış olduğu tasarımı projenin her yerinde kullanabilir.
 * Yazılımcı
 * <ul>
 *     <li>{@link #setBackgroundColor(int) setBackgroundColor} fonksiyonuyla dialog
 *     penceresinin arka plan rengini, </li>
 *     <li>{@link #setIndeterminateTintAndTextColor(int) setIndeterminateTintAndTextColor}
 *     fonksiyonuyla progressBar'ın <code>indeterminateTint</code> ile mesajın
 *     <code>textColor</code> renklerini</li>
 * </ul>
 * özelleştirebilir.
 * Yazılımcı herhangi bir atama yapmazsa sınıfın <b>varsayılan</b> özellikleri geçerli olacaktır.
 * </p>
 * <p>
 * Renk değişkenlerine atama işlemi eğer <code>color</code> dosyasından yapılacaksa
 * <code>context.getResources().getColor(R.color.your_color)</code> yöntemi kullanılmalıdır.
 * </p>
 */
public class CustomProgressDialog extends DialogFragment {

    public static final String TAG = CustomProgressDialog.class.getSimpleName();

    //------------------------------BackgroundColor-------------------------------------------------

    // Varsayılan arka plan rengi. Varsayılan renk mavidir.
    private static int bgColor = Color.parseColor("#3700B3");

    /**
     * Varsayılan arka plan rengini set eder.
     *
     * @param backgroundColor dialog arka plan rengi.
     */
    public static void setBackgroundColor(int backgroundColor) {
        CustomProgressDialog.bgColor = backgroundColor;
    }
//--------------------------------------------------------------------------------------------------

    //-------------------------IndeterminateTint and TextColor--------------------------------------

    // Varsayılan indeterminateTint ve textColor rengi. Varsayılan renk beyaza yakın bir renktir.
    private static int indeterminateTintAndTextColor = Color.parseColor("#E6DEFF");

    /**
     * Varsayılan <code>indeterminateTint</code> ve <code>textColor</code> değerini set eder.
     *
     * @param indeterminateTintAndTextColor <code>indeterminateTint</code> and <code>textColor</code>.
     */
    public static void setIndeterminateTintAndTextColor(int indeterminateTintAndTextColor) {
        CustomProgressDialog.indeterminateTintAndTextColor = indeterminateTintAndTextColor;
    }
//--------------------------------------------------------------------------------------------------

    /**
     * Factory method.
     *
     * @return a new instance of this class.
     */
    @NonNull
    public static CustomProgressDialog getInstance(@NonNull FragmentManager fragmentManager) {
        return new CustomProgressDialog(fragmentManager);
    }

    /**
     * Constructor method.
     *
     * @param fragmentManager parent fragment manager.
     */
    public CustomProgressDialog(@NonNull FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    private final FragmentManager fragmentManager;
    private String message = null;

    /**
     * Dialog mesajını set eder.
     *
     * @param message dialog mesajı. <code>null</code> gelirse mesaj textview'i
     *                <code>GONE</code> olacaktır.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    private CustomProgressDialogBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CustomProgressDialogBinding.inflate(inflater, container, false);
        binding.crdCpd.setCardBackgroundColor(bgColor);
        binding.prgCpd.setIndeterminateTintList(ColorStateList.valueOf(indeterminateTintAndTextColor));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDialogWindow();
        setTxtMessage();
    }

    /**
     * Dialog penceresinin ayarlarını set eder.
     */
    private void setDialogWindow() {
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    /**
     * Mesaj bilgisi varsa <code>gone</code> durumunda olan mesajı görünür yapar ve mesajı
     * set eder. Mesajın <code>null</code> olması durumunda sadece progressbar görünecektir.
     */
    private void setTxtMessage() {
        if (message != null && !message.isEmpty()) {
            binding.txtCpdMessage.setVisibility(View.VISIBLE);
            binding.txtCpdMessage.setText(message);
            binding.txtCpdMessage.setTextColor(indeterminateTintAndTextColor);
        } else {
            binding.txtCpdMessage.setVisibility(View.GONE);
        }
    }

    public void show() {
        show(fragmentManager, TAG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
