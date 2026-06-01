package sg.bigo.ads.core.g.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.g.a.b;
import sg.bigo.ads.core.g.f;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements sg.bigo.ads.core.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ViewGroup f17067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public b f17068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0317a f17069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b.a f17070d = new b.a() { // from class: sg.bigo.ads.core.g.a.a.1
        @Override // sg.bigo.ads.core.g.a.b.a
        public final void a() {
            InterfaceC0317a interfaceC0317a = a.this.f17069c;
            if (interfaceC0317a != null) {
                interfaceC0317a.a();
            }
            b bVarB = a.this.b();
            u.a(bVarB, a.this.f17067a, null, -1);
            bVarB.setVPAIDEvenListener(a.this.f17068b.getVPAIDEvenListener());
            bVarB.setLayoutParams(a.this.f17068b.getLayoutParams());
            u.b(a.this.f17068b);
            a.this.f17068b = bVarB;
        }
    };
    private final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f17071f;
    private final int g;
    private final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f f17072i;
    private final String j;
    private final int k;
    private sg.bigo.ads.api.core.u l;

    /* JADX INFO: renamed from: sg.bigo.ads.core.g.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0317a {
        void a();
    }

    public a(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull String str, int i2, int i8, @NonNull f fVar, @Nullable String str2, int i9, sg.bigo.ads.api.core.u uVar) {
        this.e = context;
        this.f17067a = viewGroup;
        this.f17071f = str;
        this.g = i2;
        this.h = i8;
        this.f17072i = fVar;
        this.j = str2;
        this.k = i9;
        this.l = uVar;
        b bVarB = b();
        this.f17068b = bVarB;
        u.a(bVarB, viewGroup, null, 0);
    }

    @Override // sg.bigo.ads.api.c.a
    public final void a() {
        this.f17068b.a("window.vpaidwrapper.pauseAd()");
    }

    public final b b() {
        b bVar = new b(this.e, this.f17071f, this.g, this.h, this.f17072i, this.j, this.k, this.l);
        bVar.setOnRenderProcessGoneListener(this.f17070d);
        return bVar;
    }
}
