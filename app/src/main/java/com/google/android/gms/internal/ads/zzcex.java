package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcex implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final boolean zza(zzcdr zzcdrVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcew zzcewVar = (zzcew) it.next();
            if (zzcewVar.zza == zzcdrVar) {
                arrayList.add(zzcewVar);
            }
        }
        int i2 = 0;
        if (arrayList.isEmpty()) {
            return false;
        }
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((zzcew) obj).zzb.zzl();
        }
        return true;
    }

    @Nullable
    public final zzcew zzb(zzcdr zzcdrVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcew zzcewVar = (zzcew) it.next();
            if (zzcewVar.zza == zzcdrVar) {
                return zzcewVar;
            }
        }
        return null;
    }

    public final void zzc(zzcew zzcewVar) {
        this.zza.add(zzcewVar);
    }

    public final void zzd(zzcew zzcewVar) {
        this.zza.remove(zzcewVar);
    }
}
