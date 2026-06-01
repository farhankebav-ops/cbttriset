package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.unity3d.services.core.fid.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfve {
    @Nullable
    public static Object zza(String str, String str2, zzfvd... zzfvdVarArr) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return Class.forName(str).getDeclaredMethod(Constants.GET_INSTANCE, null).invoke(null, null);
    }
}
