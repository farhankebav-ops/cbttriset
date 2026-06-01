package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzais implements zzaeh {
    public static final zzais zza = new zzais(true);
    public static final zzais zzb = new zzais(false);
    public final boolean zzc;

    private zzais(boolean z2) {
        this.zzc = z2;
    }

    public final String toString() {
        boolean z2 = !this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(z2).length() + 33);
        sb.append("IncorrectFragmentation{expected=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
