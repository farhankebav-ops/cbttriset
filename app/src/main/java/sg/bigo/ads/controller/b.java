package sg.bigo.ads.controller;

import androidx.annotation.NonNull;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements e<sg.bigo.ads.controller.g.a, String, Object> {
    @Override // sg.bigo.ads.controller.e
    public final /* bridge */ /* synthetic */ void a(int i2, @NonNull sg.bigo.ads.controller.g.a aVar, @NonNull String[] strArr) {
        a(i2, strArr);
    }

    public abstract void a(int i2, @NonNull String str);

    public final void a(int i2, @NonNull String... strArr) {
        a(i2, (String) k.b(strArr));
    }
}
