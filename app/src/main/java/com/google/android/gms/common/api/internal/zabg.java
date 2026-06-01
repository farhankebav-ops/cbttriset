package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zabg {
    private final zabf zaa;

    public zabg(zabf zabfVar) {
        this.zaa = zabfVar;
    }

    public abstract void zaa();

    public final void zab(zabi zabiVar) {
        zabiVar.zai.lock();
        try {
            if (zabiVar.zan == this.zaa) {
                zaa();
            }
        } finally {
            zabiVar.zai.unlock();
        }
    }
}
