package com.google.android.gms.internal.common;

import a1.a;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzx {
    public static String zza(String str, Object... objArr) {
        int length;
        int iIndexOf;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i2 = 0;
        int i8 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length || (iIndexOf = str.indexOf("%s", i8)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i8, iIndexOf);
            sb.append(zzb(objArr[i2]));
            i8 = iIndexOf + 2;
            i2++;
        }
        sb.append((CharSequence) str, i8, str.length());
        if (i2 < length) {
            String str2 = " [";
            while (i2 < objArr.length) {
                sb.append(str2);
                sb.append(zzb(objArr[i2]));
                i2++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String zzb(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            String strS = a.s(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strS), (Throwable) e);
            String name2 = e.getClass().getName();
            StringBuilder sb = new StringBuilder(strS.length() + 8 + name2.length() + 1);
            androidx.camera.core.processing.util.a.A(sb, "<", strS, " threw ", name2);
            sb.append(">");
            return sb.toString();
        }
    }
}
