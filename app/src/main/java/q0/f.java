package q0;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final android.support.v4.media.g f13375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.h f13376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f13377c;

    public f(Context context, e2.h hVar) {
        android.support.v4.media.g gVar = new android.support.v4.media.g(context);
        this.f13377c = new HashMap();
        this.f13375a = gVar;
        this.f13376b = hVar;
    }

    public final synchronized h a(String str) {
        if (this.f13377c.containsKey(str)) {
            return (h) this.f13377c.get(str);
        }
        CctBackendFactory cctBackendFactoryG = this.f13375a.g(str);
        if (cctBackendFactoryG == null) {
            return null;
        }
        e2.h hVar = this.f13376b;
        h hVarCreate = cctBackendFactoryG.create(new b((Context) hVar.f11231a, (y0.a) hVar.f11232b, (y0.a) hVar.f11233c, str));
        this.f13377c.put(str, hVarCreate);
        return hVarCreate;
    }
}
