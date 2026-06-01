package sg.bigo.ads.controller;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f16259a;

    public a(c cVar) {
        this.f16259a = cVar;
    }

    @Override // sg.bigo.ads.controller.e
    public final void a(int i2, int i8, int i9, @NonNull String str, @Nullable Pair<sg.bigo.ads.api.b, l> pair) {
        c cVar = this.f16259a;
        if (cVar != null) {
            cVar.a(i2, i8, i9, str, pair);
        }
    }

    @Override // sg.bigo.ads.controller.e
    public final /* bridge */ /* synthetic */ void a(int i2, @NonNull sg.bigo.ads.api.b bVar, @NonNull g[] gVarArr) {
        sg.bigo.ads.api.b bVar2 = bVar;
        g[] gVarArr2 = gVarArr;
        c cVar = this.f16259a;
        if (cVar != null) {
            cVar.a(i2, bVar2, gVarArr2);
        }
    }
}
