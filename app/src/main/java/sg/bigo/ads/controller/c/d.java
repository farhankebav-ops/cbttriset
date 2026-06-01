package sg.bigo.ads.controller.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
import sg.bigo.ads.api.core.i;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends b implements sg.bigo.ads.api.core.i {

    @Nullable
    protected i.b D;

    @NonNull
    protected final i.a E;
    private boolean F;
    private boolean G;

    public d(long j, @NonNull sg.bigo.ads.api.core.h hVar, @NonNull sg.bigo.ads.api.a.l lVar, @NonNull JSONObject jSONObject) {
        super(j, hVar, lVar, jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("display");
        if (jSONObjectOptJSONObject != null) {
            this.D = new h(jSONObjectOptJSONObject);
        }
        this.E = new e(jSONObject);
    }

    @Override // sg.bigo.ads.api.core.i
    public final void aA() {
        this.G = true;
    }

    @Override // sg.bigo.ads.api.core.i
    public final boolean aB() {
        return this.G;
    }

    @Override // sg.bigo.ads.api.core.i
    public final boolean av() {
        return a(32);
    }

    @Override // sg.bigo.ads.api.core.i
    @Nullable
    public final i.b aw() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.core.i
    @NonNull
    public final i.a ax() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.core.i
    public final void ay() {
        this.F = true;
    }

    @Override // sg.bigo.ads.api.core.i
    public final boolean az() {
        return this.F;
    }
}
