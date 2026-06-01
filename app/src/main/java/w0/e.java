package w0;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements r0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p5.a f17664b;

    public /* synthetic */ e(p5.a aVar, int i2) {
        this.f17663a = i2;
        this.f17664b = aVar;
    }

    @Override // p5.a
    public final Object get() {
        switch (this.f17663a) {
            case 0:
                String packageName = ((Context) this.f17664b.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            default:
                return new k((Context) this.f17664b.get(), "com.google.android.datatransport.events", Integer.valueOf(k.f17676d).intValue());
        }
    }
}
