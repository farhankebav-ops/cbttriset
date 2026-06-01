package com.apm.insight.i;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.insight.runtime.o;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile UUID f4433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4434b = "";

    private a(Context context) {
        String string;
        if (f4433a == null) {
            synchronized (a.class) {
                if (f4433a == null) {
                    String strC = o.a().c();
                    if (strC != null) {
                        f4433a = UUID.fromString(strC);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused) {
                            string = null;
                        }
                        try {
                            if (string != null) {
                                f4433a = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                            } else {
                                f4433a = UUID.randomUUID();
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            o.a().b(f4433a.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized String a(Context context) {
        try {
            if (TextUtils.isEmpty(f4434b)) {
                new a(context);
                UUID uuid = f4433a;
                if (uuid != null) {
                    f4434b = uuid.toString();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4434b;
    }
}
