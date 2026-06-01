package androidx.datastore.core;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class State<T> {
    private final int version;

    public /* synthetic */ State(int i2, f fVar) {
        this(i2);
    }

    public final int getVersion() {
        return this.version;
    }

    private State(int i2) {
        this.version = i2;
    }
}
