package y4;

import a5.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b[] f17850b;

    static {
        b bVar = new b("INSTANCE", 0);
        f17849a = bVar;
        f17850b = new b[]{bVar, new b("NEVER", 1)};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f17850b.clone();
    }

    @Override // a5.d
    public final int d(int i2) {
        return 2;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return true;
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // a5.h
    public final Object poll() {
        return null;
    }

    @Override // a5.h
    public final void clear() {
    }

    @Override // u4.b
    public final void dispose() {
    }
}
