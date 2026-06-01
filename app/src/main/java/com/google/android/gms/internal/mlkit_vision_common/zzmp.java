package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import m0.c;
import m0.d;
import m0.e;
import m0.f;
import m0.g;
import n0.a;
import p0.t;
import p0.u;
import p0.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmp implements zzmc {

    @Nullable
    private Provider zza;
    private final Provider zzb;
    private final zzme zzc;

    public zzmp(Context context, zzme zzmeVar) {
        this.zzc = zzmeVar;
        a aVar = a.e;
        v.b(context);
        final t tVarC = v.a().c(aVar);
        if (a.f13042d.contains(new c("json"))) {
            this.zza = new Lazy(new Provider() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzmm
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    return ((t) tVarC).a("FIREBASE_ML_SDK", new c("json"), new f() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzmo
                        @Override // m0.f, x4.c
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.zzb = new Lazy(new Provider() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzmn
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return ((t) tVarC).a("FIREBASE_ML_SDK", new c("proto"), new f() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzml
                    @Override // m0.f, x4.c
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    @VisibleForTesting
    public static d zzb(zzme zzmeVar, zzmb zzmbVar) {
        return new m0.a(zzmbVar.zzd(zzmeVar.zza(), false), e.f12922b, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmc
    public final void zza(zzmb zzmbVar) {
        if (this.zzc.zza() != 0) {
            ((u) ((g) this.zzb.get())).b(zzb(this.zzc, zzmbVar));
        } else {
            Provider provider = this.zza;
            if (provider != null) {
                ((u) ((g) provider.get())).b(zzb(this.zzc, zzmbVar));
            }
        }
    }
}
