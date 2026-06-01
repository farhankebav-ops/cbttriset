package com.mimikridev.utilmanager.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.mimikridev.utilmanager.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ToastUtil {
    public static final int TYPE_ERROR = 0;
    public static final int TYPE_INFO = 2;
    public static final int TYPE_SUCCESS = 1;

    public static void showError(Context context, String str) {
        showToast(context, str, R.drawable.ic_close, R.color.red_600);
    }

    public static void showInfo(Context context, String str) {
        showToast(context, str, R.drawable.ic_error_outline, R.color.blue_500);
    }

    public static void showSuccess(Context context, String str) {
        showToast(context, str, R.drawable.ic_done, R.color.green_500);
    }

    private static void showToast(Context context, String str, int i2, int i8) {
        Toast toast = new Toast(context);
        toast.setDuration(1);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.toast_icon_text, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.message)).setText(str);
        ((ImageView) viewInflate.findViewById(R.id.icon)).setImageResource(i2);
        ((CardView) viewInflate.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(i8));
        toast.setView(viewInflate);
        toast.show();
    }
}
