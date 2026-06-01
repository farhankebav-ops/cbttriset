package sg.bigo.ads.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13790b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f13792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f13793c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f13794d;

        @Nullable
        public final String e;

        public a(boolean z2, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f13791a = z2;
            this.e = str;
            this.f13794d = str2;
            this.f13793c = str3;
            this.f13792b = str4;
        }
    }

    @NonNull
    public static a a(Context context) {
        String string;
        String str;
        String str2;
        PackageInfo packageInfo;
        String strSubstring;
        String str3;
        String strValueOf;
        int iIndexOf;
        a aVar = f13790b;
        if (aVar != null) {
            return aVar;
        }
        boolean z2 = false;
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com")), 0);
        String strConcat = null;
        String str4 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.android.chrome", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
        } catch (Exception e4) {
            e = e4;
        }
        if (packageInfo == null || !"com.android.chrome".equals(packageInfo.packageName)) {
            string = "No chrome pkg";
            str = string;
            str2 = strConcat;
            a aVar2 = new a(z2, f13789a, str2, str4, str);
            f13790b = aVar2;
            return aVar2;
        }
        f13789a = "com.android.chrome";
        String str5 = packageInfo.versionName;
        try {
            strSubstring = (TextUtils.isEmpty(str5) || (iIndexOf = str5.indexOf(".")) < 0) ? null : str5.substring(0, iIndexOf);
        } catch (PackageManager.NameNotFoundException e8) {
            e = e8;
            strConcat = str5;
            string = e.toString();
            str = string;
            str2 = strConcat;
        } catch (Exception e9) {
            e = e9;
            strConcat = str5;
            string = e.toString();
            str = string;
            str2 = strConcat;
        }
        if (TextUtils.isEmpty(strSubstring)) {
            str3 = "Invalid chrome version: ";
            strValueOf = String.valueOf(str5);
        } else {
            if (Integer.parseInt(strSubstring) >= 45) {
                z2 = true;
                str2 = str5;
                str = strConcat;
                a aVar22 = new a(z2, f13789a, str2, str4, str);
                f13790b = aVar22;
                return aVar22;
            }
            str3 = "Chrome version is low: ";
            strValueOf = String.valueOf(str5);
        }
        strConcat = str3.concat(strValueOf);
        str2 = str5;
        str = strConcat;
        a aVar222 = new a(z2, f13789a, str2, str4, str);
        f13790b = aVar222;
        return aVar222;
        string = e.toString();
        str = string;
        str2 = strConcat;
        a aVar2222 = new a(z2, f13789a, str2, str4, str);
        f13790b = aVar2222;
        return aVar2222;
    }
}
