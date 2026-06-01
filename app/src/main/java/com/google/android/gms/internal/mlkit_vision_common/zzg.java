package com.google.android.gms.internal.mlkit_vision_common;

import a1.a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg {
    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i2 = 0;
        int i8 = 0;
        while (true) {
            length = objArr.length;
            if (i8 >= length) {
                break;
            }
            Object obj = objArr[i8];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e);
                    StringBuilder sbY = a.y("<", str2, " threw ");
                    sbY.append(e.getClass().getName());
                    sbY.append(">");
                    string = sbY.toString();
                }
            }
            objArr[i8] = string;
            i8++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i9 = 0;
        while (true) {
            length2 = objArr.length;
            if (i2 >= length2 || (iIndexOf = str.indexOf("%s", i9)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i9, iIndexOf);
            sb.append(objArr[i2]);
            i2++;
            i9 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i9, str.length());
        if (i2 < length2) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i10 = i2 + 1; i10 < objArr.length; i10++) {
                sb.append(", ");
                sb.append(objArr[i10]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static boolean zzb(String str) {
        return zze.zza(str);
    }
}
