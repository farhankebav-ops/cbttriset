package com.mimikridev.utilmanager;

import a1.a;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import androidx.webkit.internal.AssetHelper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Tools {
    public static void rateApp(Activity activity, String str) {
        String strL = a.l("https://play.google.com/store/apps/details?id=", str);
        if (activity == null || strL == null) {
            return;
        }
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(strL)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shareApp(Activity activity, String str) {
        if (activity == null || str == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(str).toString());
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            activity.startActivity(Intent.createChooser(intent, "Share via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shareContent(Activity activity, String str, String str2, String str3) {
        String strL = a.l("https://play.google.com/store/apps/details?id=", str3);
        if (activity == null) {
            return;
        }
        try {
            String str4 = Html.fromHtml(str).toString() + "\n\n" + Html.fromHtml(str2).toString() + "\n\n" + strL;
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str4);
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            activity.startActivity(Intent.createChooser(intent, "Bagikan via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
