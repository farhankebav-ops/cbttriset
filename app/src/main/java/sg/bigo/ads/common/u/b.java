package sg.bigo.ads.common.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.u.b.c;
import sg.bigo.ads.common.u.c.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b<Req extends sg.bigo.ads.common.u.b.c, Res extends sg.bigo.ads.common.u.c.c> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b<sg.bigo.ads.common.u.b.c, sg.bigo.ads.common.u.c.a> f15958d = new a();

    public static class a<Req extends sg.bigo.ads.common.u.b.c> extends b<Req, sg.bigo.ads.common.u.c.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Req f15959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        sg.bigo.ads.common.u.c.a f15960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h f15961c;

        @Override // sg.bigo.ads.common.u.b
        public final /* bridge */ /* synthetic */ sg.bigo.ads.common.u.c.c a(@NonNull sg.bigo.ads.common.u.c.a aVar) {
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.u.b
        public final /* bridge */ /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull sg.bigo.ads.common.u.c.c cVar2) {
            this.f15959a = cVar;
            this.f15960b = (sg.bigo.ads.common.u.c.a) cVar2;
        }

        @Override // sg.bigo.ads.common.u.b
        public final void a(@NonNull Req req, @NonNull h hVar) {
            this.f15959a = req;
            this.f15961c = hVar;
        }
    }

    public abstract Res a(@NonNull sg.bigo.ads.common.u.c.a aVar);

    public void a(@NonNull Req req) {
    }

    public abstract void a(@NonNull Req req, @NonNull Res res);

    public abstract void a(@NonNull Req req, @NonNull h hVar);

    public void a(@NonNull Req req, @Nullable String str, int i2) {
    }

    public boolean a(@NonNull Req req, int i2) {
        return i2 >= 200 && i2 < 300;
    }
}
