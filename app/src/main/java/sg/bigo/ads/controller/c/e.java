package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import org.json.JSONObject;
import sg.bigo.ads.api.core.i;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16470a;

    public e(@NonNull JSONObject jSONObject) {
        this.f16470a = jSONObject.optInt("banner_pre_load", 0) == 1;
    }

    @Override // sg.bigo.ads.api.core.i.a
    public final boolean a() {
        return this.f16470a;
    }

    @Override // sg.bigo.ads.api.core.i.a
    @NonNull
    public final String[] b() {
        return new String[0];
    }
}
