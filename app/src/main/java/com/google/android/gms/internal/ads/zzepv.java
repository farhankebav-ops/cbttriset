package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzepv implements zzeya {
    private final zzgus zza;
    private final Context zzb;
    private final zzfgn zzc;

    @Nullable
    private final View zzd;

    public zzepv(zzgus zzgusVar, Context context, zzfgn zzfgnVar, @Nullable ViewGroup viewGroup) {
        this.zza = zzgusVar;
        this.zzb = context;
        this.zzc = zzfgnVar;
        this.zzd = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        zzbeu.zza(this.zzb);
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzepu
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 3;
    }

    public final /* synthetic */ zzepw zzc() {
        ArrayList arrayList = new ArrayList();
        View view = this.zzd;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", iIndexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzepw(this.zzb, this.zzc.zzf, arrayList);
    }
}
