package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgps {
    public static boolean zza(Iterable iterable, zzgme zzgmeVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzgmeVar.getClass();
            return zzc((List) iterable, zzgmeVar);
        }
        Iterator it = iterable.iterator();
        zzgmeVar.getClass();
        boolean z2 = false;
        while (it.hasNext()) {
            if (zzgmeVar.zza(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static Object zzb(Iterable iterable, Object obj) {
        zzgrs it = ((zzgrj) iterable).iterator();
        return it.hasNext() ? it.next() : obj;
    }

    private static boolean zzc(List list, zzgme zzgmeVar) {
        int i2 = 0;
        int i8 = 0;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            if (!zzgmeVar.zza(obj)) {
                if (i2 > i8) {
                    try {
                        list.set(i8, obj);
                    } catch (IllegalArgumentException unused) {
                        zzd(list, zzgmeVar, i8, i2);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzd(list, zzgmeVar, i8, i2);
                        return true;
                    }
                }
                i8++;
            }
            i2++;
        }
        list.subList(i8, list.size()).clear();
        return i2 != i8;
    }

    private static void zzd(List list, zzgme zzgmeVar, int i2, int i8) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i8) {
                break;
            } else if (zzgmeVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i8--;
            if (i8 < i2) {
                return;
            } else {
                list.remove(i8);
            }
        }
    }
}
