package com.unity3d.ads.injection;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class EntryKey {
    private final c instanceClass;
    private final String named;

    public EntryKey(String named, c instanceClass) {
        k.e(named, "named");
        k.e(instanceClass, "instanceClass");
        this.named = named;
        this.instanceClass = instanceClass;
    }

    public static /* synthetic */ EntryKey copy$default(EntryKey entryKey, String str, c cVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = entryKey.named;
        }
        if ((i2 & 2) != 0) {
            cVar = entryKey.instanceClass;
        }
        return entryKey.copy(str, cVar);
    }

    public final String component1() {
        return this.named;
    }

    public final c component2() {
        return this.instanceClass;
    }

    public final EntryKey copy(String named, c instanceClass) {
        k.e(named, "named");
        k.e(instanceClass, "instanceClass");
        return new EntryKey(named, instanceClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntryKey)) {
            return false;
        }
        EntryKey entryKey = (EntryKey) obj;
        return k.a(this.named, entryKey.named) && k.a(this.instanceClass, entryKey.instanceClass);
    }

    public final c getInstanceClass() {
        return this.instanceClass;
    }

    public final String getNamed() {
        return this.named;
    }

    public int hashCode() {
        return this.instanceClass.hashCode() + (this.named.hashCode() * 31);
    }

    public String toString() {
        return "EntryKey(named=" + this.named + ", instanceClass=" + this.instanceClass + ')';
    }

    public /* synthetic */ EntryKey(String str, c cVar, int i2, f fVar) {
        this((i2 & 1) != 0 ? "" : str, cVar);
    }
}
