package okhttp3.internal.cache;

import com.unity3d.scar.adapter.common.i;
import e6.l;
import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache;
import q5.x;
import r6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13231c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f13229a = i2;
        this.f13230b = obj;
        this.f13231c = obj2;
    }

    @Override // e6.l
    public final Object invoke(Object obj) {
        switch (this.f13229a) {
            case 0:
                return DiskLruCache.Editor.newSink$lambda$3$lambda$2((DiskLruCache) this.f13230b, (DiskLruCache.Editor) this.f13231c, (IOException) obj);
            default:
                c cVar = (c) this.f13230b;
                cVar.f13646a.removeCallbacks((i) this.f13231c);
                return x.f13520a;
        }
    }
}
