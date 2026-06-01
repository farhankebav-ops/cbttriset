package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class s {
    public static String a(zzfty zzftyVar, File file, String str) {
        return b(file, str, zzfuc.zza);
    }

    public static String b(File file, String str, zzfuc zzfucVar) {
        return new File(file, str).getPath();
    }
}
