package sg.bigo.ads.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import sg.bigo.ads.api.a.l;

/* JADX INFO: loaded from: classes6.dex */
public class IconAdsRequest extends sg.bigo.ads.api.b implements sg.bigo.ads.api.b.c {
    private final l h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final sg.bigo.ads.api.core.c f15434i;
    private final int j;
    private final int k;
    private final int l;
    private final b m;

    public static class a extends c<a, IconAdsRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f15435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public sg.bigo.ads.api.core.c f15436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15437c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15438d = 1;
        public int e = 20;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f15439f;

        @Override // sg.bigo.ads.api.c
        public final /* synthetic */ sg.bigo.ads.api.b createAdRequest() {
            if (this.f15435a == null) {
                return null;
            }
            return new IconAdsRequest(this, (byte) 0);
        }
    }

    public interface b {
        int a();
    }

    private IconAdsRequest(@NonNull a aVar) {
        super(aVar.mSlotId, null);
        this.h = aVar.f15435a;
        this.f15434i = aVar.f15436b;
        this.j = aVar.f15437c;
        this.k = aVar.f15438d;
        this.l = aVar.e;
        this.m = aVar.f15439f;
    }

    @Override // sg.bigo.ads.api.b
    public final int c() {
        return this.h.b();
    }

    @Override // sg.bigo.ads.api.b
    @Nullable
    public final Map<String, Object> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        sg.bigo.ads.api.core.c cVar = this.f15434i;
        if (cVar != null) {
            linkedHashMap.put("host_slot", cVar.b());
            linkedHashMap.put("host_placement", this.f15434i.c());
            linkedHashMap.put("host_ad_type", Integer.valueOf(this.f15434i.x()));
            linkedHashMap.put("host_adx_type", Integer.valueOf(this.f15434i.w()));
            linkedHashMap.put("dsp_source", this.f15434i.v());
            linkedHashMap.put("main_domain", this.f15434i.i());
            linkedHashMap.put("main_bundle", this.f15434i.n());
            linkedHashMap.put("main_adx_sid", Long.valueOf(this.f15434i.y()));
            linkedHashMap.put("main_ad_id", this.f15434i.r());
            linkedHashMap.put("dsp_extra", this.f15434i.an());
        }
        linkedHashMap.put("adx_type", 5);
        linkedHashMap.put("ad_type", Integer.valueOf(c()));
        linkedHashMap.put("icon_ads_type", Integer.valueOf(this.k));
        linkedHashMap.put("scene_page", Integer.valueOf(this.j));
        linkedHashMap.put("icon_num", Integer.valueOf(this.l));
        return linkedHashMap;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean e() {
        return true;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean f() {
        return true;
    }

    @Override // sg.bigo.ads.api.b
    public final boolean g() {
        return true;
    }

    @Override // sg.bigo.ads.api.b
    public final l h() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.b.b
    public final sg.bigo.ads.api.core.c i() {
        return this.f15434i;
    }

    @Override // sg.bigo.ads.api.b.c
    public final int j() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.b.c
    public final int k() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.b.c
    public final int l() {
        b bVar = this.m;
        if (bVar != null) {
            return bVar.a();
        }
        return 1;
    }

    public /* synthetic */ IconAdsRequest(a aVar, byte b8) {
        this(aVar);
    }
}
