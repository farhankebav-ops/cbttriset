package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BindingWrapper {
    final InAppMessageLayoutConfig config;
    final LayoutInflater inflater;
    protected final InAppMessage message;

    public BindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        this.config = inAppMessageLayoutConfig;
        this.inflater = layoutInflater;
        this.message = inAppMessage;
    }

    public static void setButtonBgColorFromHex(Button button, String str) {
        try {
            Drawable drawableWrap = DrawableCompat.wrap(button.getBackground());
            DrawableCompat.setTint(drawableWrap, Color.parseColor(str));
            button.setBackground(drawableWrap);
        } catch (IllegalArgumentException e) {
            Logging.loge("Error parsing background color: " + e.toString());
        }
    }

    public static void setupViewButtonFromModel(Button button, com.google.firebase.inappmessaging.model.Button button2) {
        String hexColor = button2.getText().getHexColor();
        setButtonBgColorFromHex(button, button2.getButtonHexColor());
        button.setText(button2.getText().getText());
        button.setTextColor(Color.parseColor(hexColor));
    }

    public boolean canSwipeToDismiss() {
        return false;
    }

    @NonNull
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @NonNull
    public abstract View getDialogView();

    @Nullable
    public View.OnClickListener getDismissListener() {
        return null;
    }

    @NonNull
    public abstract ImageView getImageView();

    @NonNull
    public abstract ViewGroup getRootView();

    @Nullable
    public abstract ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener onClickListener);

    public void setButtonActionListener(@Nullable Button button, View.OnClickListener onClickListener) {
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public void setViewBgColorFromHex(@Nullable View view, @Nullable String str) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            view.setBackgroundColor(Color.parseColor(str));
        } catch (IllegalArgumentException e) {
            Logging.loge("Error parsing background color: " + e.toString() + " color: " + str);
        }
    }
}
