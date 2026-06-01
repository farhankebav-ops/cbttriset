package d4;

import android.support.v4.media.g;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.unity3d.scar.adapter.common.i;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f11049c;

    private final void a(String str) {
        i iVar;
        g gVar = this.f11049c;
        ((g) gVar.f3264c).f3264c = str;
        com.unity3d.scar.adapter.common.a aVar = (com.unity3d.scar.adapter.common.a) gVar.f3263b;
        synchronized (aVar) {
            int i2 = aVar.f10958b - 1;
            aVar.f10958b = i2;
            if (i2 <= 0 && (iVar = (i) aVar.f10959c) != null) {
                iVar.run();
            }
        }
    }

    private final void b(QueryInfo queryInfo) {
        i iVar;
        g gVar = this.f11049c;
        ((HashMap) ((g) gVar.f3264c).f3263b).put(this.f11048b, queryInfo.getQuery());
        com.unity3d.scar.adapter.common.a aVar = (com.unity3d.scar.adapter.common.a) gVar.f3263b;
        synchronized (aVar) {
            int i2 = aVar.f10958b - 1;
            aVar.f10958b = i2;
            if (i2 <= 0 && (iVar = (i) aVar.f10959c) != null) {
                iVar.run();
            }
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        i iVar;
        switch (this.f11047a) {
            case 0:
                a(str);
                return;
            default:
                g gVar = this.f11049c;
                ((g) gVar.f3264c).f3264c = str;
                com.unity3d.scar.adapter.common.a aVar = (com.unity3d.scar.adapter.common.a) gVar.f3263b;
                synchronized (aVar) {
                    int i2 = aVar.f10958b - 1;
                    aVar.f10958b = i2;
                    if (i2 <= 0 && (iVar = (i) aVar.f10959c) != null) {
                        iVar.run();
                    }
                    break;
                }
                return;
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        i iVar;
        switch (this.f11047a) {
            case 0:
                b(queryInfo);
                return;
            default:
                g gVar = this.f11049c;
                ((HashMap) ((g) gVar.f3264c).f3263b).put(this.f11048b, queryInfo.getQuery());
                com.unity3d.scar.adapter.common.a aVar = (com.unity3d.scar.adapter.common.a) gVar.f3263b;
                synchronized (aVar) {
                    int i2 = aVar.f10958b - 1;
                    aVar.f10958b = i2;
                    if (i2 <= 0 && (iVar = (i) aVar.f10959c) != null) {
                        iVar.run();
                    }
                    break;
                }
                return;
        }
    }
}
