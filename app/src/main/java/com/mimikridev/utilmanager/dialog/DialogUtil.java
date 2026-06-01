package com.mimikridev.utilmanager.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.ImageView;
import androidx.camera.camera2.interop.d;
import androidx.core.content.ContextCompat;
import com.mimikridev.utilmanager.R;
import q.f;
import q.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class DialogUtil {
    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$showErrorDialogExit$2(Activity activity, g gVar) {
        gVar.d(false);
        activity.finishAffinity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showErrorDialogExit$3(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showLoadingAds$0(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$showSuccessDialogWithRedirect$1(Context context, Class cls, g gVar) {
        gVar.d(false);
        context.startActivity(new Intent(context, (Class<?>) cls));
    }

    public static void safeDismiss(g gVar, Context context) {
        if (gVar != null && gVar.isShowing() && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            gVar.d(false);
        }
    }

    public static void showBasicDialog(Context context) {
        g gVar = new g(context, 0);
        gVar.setCancelable(true);
        gVar.setCanceledOnTouchOutside(true);
        gVar.show();
    }

    public static void showCustomImageDialog(Context context, String str, String str2, int i2) {
        g gVar = new g(context, 4);
        gVar.j(str);
        gVar.i(str2);
        Drawable drawable = gVar.getContext().getResources().getDrawable(i2);
        gVar.f13365x = drawable;
        ImageView imageView = gVar.y;
        if (imageView != null && drawable != null) {
            imageView.setVisibility(0);
            gVar.y.setImageDrawable(gVar.f13365x);
        }
        gVar.show();
    }

    public static void showDeleteConfirmationDialog(Context context, String str, String str2, f fVar, f fVar2) {
        g gVar = new g(context, 3);
        gVar.j(str);
        gVar.i(str2);
        gVar.g("No, cancel!");
        gVar.h("Yes, delete it!");
        gVar.k();
        gVar.F = fVar2;
        gVar.G = fVar;
        gVar.show();
    }

    public static void showErrorDialog(Context context, String str, String str2) {
        g gVar = new g(context, 1);
        gVar.j(str);
        gVar.i(str2);
        gVar.show();
    }

    public static void showErrorDialogExit(Context context, String str, String str2, String str3) {
        if (context instanceof Activity) {
            g gVar = new g(context, 1);
            gVar.j(str);
            gVar.i(str2);
            gVar.h(str3);
            gVar.G = new a((Activity) context);
            gVar.setCancelable(false);
            gVar.setCanceledOnTouchOutside(false);
            gVar.setOnKeyListener(new b(0));
            gVar.show();
        }
    }

    public static g showLoadingAds(Context context) {
        g gVar = new g(context, 5);
        gVar.j(gVar.getContext().getResources().getString(R.string.ads_loading_title));
        gVar.setCancelable(false);
        gVar.setCanceledOnTouchOutside(false);
        gVar.setCancelable(false);
        gVar.setCanceledOnTouchOutside(false);
        gVar.setOnKeyListener(new b(1));
        gVar.show();
        return gVar;
    }

    public static g showLoadingDialog(Context context, String str) {
        g gVar = new g(context, 5);
        gVar.j(str);
        gVar.setCancelable(false);
        gVar.show();
        return gVar;
    }

    public static void showProgressDialog(final Context context, String str) {
        final g gVar = new g(context, 5);
        gVar.j(str);
        gVar.show();
        gVar.setCancelable(false);
        new CountDownTimer(5600L, 800L) { // from class: com.mimikridev.utilmanager.dialog.DialogUtil.1

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f10696i = -1;

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.f10696i = -1;
                g gVar2 = gVar;
                gVar2.j("Success!");
                gVar2.h("OK");
                gVar2.c(2, false);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                int i2 = this.f10696i + 1;
                this.f10696i = i2;
                switch (i2) {
                    case 0:
                        gVar.D.a(ContextCompat.getColor(context, R.color.blue_btn_bg_color));
                        break;
                    case 1:
                        gVar.D.a(ContextCompat.getColor(context, R.color.material_deep_teal_50));
                        break;
                    case 2:
                    case 6:
                        gVar.D.a(ContextCompat.getColor(context, R.color.success_stroke_color));
                        break;
                    case 3:
                        gVar.D.a(ContextCompat.getColor(context, R.color.material_deep_teal_20));
                        break;
                    case 4:
                        gVar.D.a(ContextCompat.getColor(context, R.color.material_blue_grey_80));
                        break;
                    case 5:
                        gVar.D.a(ContextCompat.getColor(context, R.color.warning_stroke_color));
                        break;
                }
            }
        }.start();
    }

    public static void showSuccessDialog(Context context, String str, String str2) {
        g gVar = new g(context, 2);
        gVar.j(str);
        gVar.i(str2);
        gVar.show();
    }

    public static void showSuccessDialogWithRedirect(Context context, String str, String str2, String str3, Class<?> cls) {
        g gVar = new g(context, 2);
        gVar.j(str);
        gVar.i(str2);
        gVar.h(str3);
        gVar.G = new d(9, context, cls);
        gVar.show();
    }

    public static void showUnderTextDialog(Context context, String str) {
        g gVar = new g(context, 0);
        gVar.i(str);
        gVar.show();
    }

    public static void showWarningCancelDialog(Context context, String str, String str2, String str3, String str4, f fVar, f fVar2) {
        g gVar = new g(context, 3);
        gVar.j(str);
        gVar.i(str2);
        gVar.g(str4);
        gVar.h(str3);
        gVar.k();
        gVar.F = fVar2;
        gVar.G = fVar;
        gVar.show();
    }

    public static void showWarningConfirmDialog(Context context, String str, String str2, f fVar) {
        g gVar = new g(context, 3);
        gVar.j(str);
        gVar.i(str2);
        gVar.h("Yes, delete it!");
        gVar.G = fVar;
        gVar.show();
    }

    public static void showWarningDialog(Context context, String str, String str2, String str3, String str4, f fVar, f fVar2) {
        g gVar = new g(context, 3);
        gVar.j(str);
        gVar.i(str2);
        gVar.g(str4);
        gVar.h(str3);
        gVar.k();
        gVar.G = fVar;
        gVar.show();
    }
}
