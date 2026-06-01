package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface zzao {
    public static final zzao zzf = new zzat();
    public static final zzao zzg = new zzam();
    public static final zzao zzh = new zzag("continue");
    public static final zzao zzi = new zzag("break");
    public static final zzao zzj = new zzag("return");
    public static final zzao zzk = new zzaf(Boolean.TRUE);
    public static final zzao zzl = new zzaf(Boolean.FALSE);
    public static final zzao zzm = new zzas("");

    String zzc();

    zzao zzcA(String str, zzg zzgVar, List list);

    Double zzd();

    Boolean zze();

    Iterator zzf();

    zzao zzt();
}
