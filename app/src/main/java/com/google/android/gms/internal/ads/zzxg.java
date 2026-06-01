package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzxg implements Comparator {
    static final /* synthetic */ zzxg zza = new zzxg();

    private /* synthetic */ zzxg() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzxf) Collections.max((List) obj)).compareTo((zzxf) Collections.max((List) obj2));
    }
}
