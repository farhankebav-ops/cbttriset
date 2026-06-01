package sg.bigo.ads.api.core;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final c f15496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.api.a.l f15497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.api.b f15498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public sg.bigo.ads.common.g f15499d;
    public final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f15500f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public sg.bigo.ads.common.g f15501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        private final c f15502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        private final sg.bigo.ads.api.a.l f15503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private final sg.bigo.ads.api.b f15504d;

        @NonNull
        private final Context e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Context f15505f;

        public a(@NonNull c cVar, @NonNull sg.bigo.ads.api.a.l lVar, @NonNull sg.bigo.ads.api.b bVar, @NonNull Context context, @NonNull Context context2) {
            this.f15502b = cVar;
            this.f15503c = lVar;
            this.f15504d = bVar;
            this.e = context;
            this.f15505f = context2;
        }

        public final g a() {
            g gVar = new g(this.f15502b, this.f15503c, this.f15504d, this.e, this.f15505f, (byte) 0);
            gVar.f15499d = this.f15501a;
            return gVar;
        }
    }

    private g(@NonNull c cVar, @NonNull sg.bigo.ads.api.a.l lVar, @NonNull sg.bigo.ads.api.b bVar, @NonNull Context context, @NonNull Context context2) {
        this.f15496a = cVar;
        this.f15497b = lVar;
        this.f15498c = bVar;
        this.e = context;
        this.f15500f = context2;
    }

    public final g a(c cVar) {
        g gVar = new g(cVar, this.f15497b, this.f15498c, this.e, this.f15500f);
        gVar.f15499d = this.f15499d;
        return gVar;
    }

    public /* synthetic */ g(c cVar, sg.bigo.ads.api.a.l lVar, sg.bigo.ads.api.b bVar, Context context, Context context2, byte b8) {
        this(cVar, lVar, bVar, context, context2);
    }
}
