package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzfrd extends zzfre {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfrd(zzfqw zzfqwVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfqwVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
