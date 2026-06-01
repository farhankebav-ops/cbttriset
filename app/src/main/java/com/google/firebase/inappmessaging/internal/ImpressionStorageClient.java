package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.injection.qualifiers.ImpressionStore;
import e5.v;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ImpressionStorageClient {
    private static final r2.f EMPTY_IMPRESSIONS = r2.f.d();
    private s4.h cachedImpressionsMaybe = e5.e.f11264a;
    private final ProtoStorageClient storageClient;

    public ImpressionStorageClient(@ImpressionStore ProtoStorageClient protoStorageClient) {
        this.storageClient = protoStorageClient;
    }

    private static r2.f appendImpression(r2.f fVar, r2.c cVar) {
        r2.e eVarF = r2.f.f(fVar);
        eVarF.a(cVar);
        return (r2.f) eVarF.build();
    }

    private void clearInMemCache() {
        this.cachedImpressionsMaybe = e5.e.f11264a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initInMemCache, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$storeImpression$0(r2.f fVar) {
        this.cachedImpressionsMaybe = s4.h.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s4.c lambda$clearImpressions$4(HashSet hashSet, r2.f fVar) throws Exception {
        Logging.logd("Existing impressions: " + fVar.toString());
        r2.e eVarE = r2.f.e();
        for (r2.c cVar : fVar.c()) {
            if (!hashSet.contains(cVar.getCampaignId())) {
                eVarE.a(cVar);
            }
        }
        r2.f fVar2 = (r2.f) eVarE.build();
        Logging.logd("New cleared impression list: " + fVar2.toString());
        return this.storageClient.write(fVar2).c(new h(this, fVar2, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllImpressions$2(Throwable th) throws Exception {
        clearInMemCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s4.c lambda$storeImpression$1(r2.c cVar, r2.f fVar) throws Exception {
        r2.f fVarAppendImpression = appendImpression(fVar, cVar);
        return this.storageClient.write(fVarAppendImpression).c(new h(this, fVarAppendImpression, 1));
    }

    public s4.a clearImpressions(r2.o oVar) {
        HashSet hashSet = new HashSet();
        for (q2.f fVar : oVar.e()) {
            hashSet.add(q0.c.a(fVar.e(), 1) ? fVar.h().getCampaignId() : fVar.c().getCampaignId());
        }
        Logging.logd("Potential impressions to clear: " + hashSet.toString());
        s4.h allImpressions = getAllImpressions();
        r2.f fVar2 = EMPTY_IMPRESSIONS;
        allImpressions.getClass();
        z4.b.a(fVar2, "item is null");
        return new e5.j(new e5.g(allImpressions, s4.h.a(fVar2), 2), new a(5, this, hashSet));
    }

    public s4.h getAllImpressions() {
        s4.h hVar = this.cachedImpressionsMaybe;
        s4.h hVar2 = this.storageClient.read(r2.f.parser());
        final int i2 = 0;
        x4.b bVar = new x4.b(this) { // from class: com.google.firebase.inappmessaging.internal.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ImpressionStorageClient f5638b;

            {
                this.f5638b = this;
            }

            @Override // x4.b
            public final void accept(Object obj) throws Exception {
                switch (i2) {
                    case 0:
                        this.f5638b.lambda$storeImpression$0((r2.f) obj);
                        break;
                    default:
                        this.f5638b.lambda$getAllImpressions$2((Throwable) obj);
                        break;
                }
            }
        };
        hVar2.getClass();
        w1.f fVar = z4.b.f17984d;
        e5.s sVar = new e5.s(hVar2, bVar, fVar);
        hVar.getClass();
        final int i8 = 1;
        return new e5.s(new e5.g(hVar, sVar, 2), fVar, new x4.b(this) { // from class: com.google.firebase.inappmessaging.internal.i

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ImpressionStorageClient f5638b;

            {
                this.f5638b = this;
            }

            @Override // x4.b
            public final void accept(Object obj) throws Exception {
                switch (i8) {
                    case 0:
                        this.f5638b.lambda$storeImpression$0((r2.f) obj);
                        break;
                    default:
                        this.f5638b.lambda$getAllImpressions$2((Throwable) obj);
                        break;
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s4.q isImpressed(q2.f fVar) {
        s4.l iVar;
        String campaignId = q0.c.a(fVar.e(), 1) ? fVar.h().getCampaignId() : fVar.c().getCampaignId();
        s4.h allImpressions = getAllImpressions();
        androidx.camera.camera2.internal.compat.workaround.c cVar = new androidx.camera.camera2.internal.compat.workaround.c(24);
        allImpressions.getClass();
        Object kVar = new e5.k(allImpressions, cVar, 1);
        androidx.camera.camera2.internal.compat.workaround.c cVar2 = new androidx.camera.camera2.internal.compat.workaround.c(25);
        s4.l lVarA = kVar instanceof a5.b ? ((a5.b) kVar).a() : new v(kVar, 0);
        int i2 = s4.d.f13683a;
        z4.b.b(Integer.MAX_VALUE, "maxConcurrency");
        z4.b.b(i2, "bufferSize");
        if (lVarA instanceof a5.f) {
            Object objCall = ((a5.f) lVarA).call();
            iVar = objCall == null ? f5.e.f11373a : new f5.p(objCall, cVar2);
        } else {
            iVar = new f5.i(lVarA, cVar2, i2);
        }
        f5.c cVar3 = new f5.c(iVar, new androidx.camera.camera2.internal.compat.workaround.c(26), 3);
        z4.b.a(campaignId, "element is null");
        return new f5.d(cVar3, new e2.f(campaignId, 6, false));
    }

    public s4.a storeImpression(r2.c cVar) {
        s4.h allImpressions = getAllImpressions();
        r2.f fVar = EMPTY_IMPRESSIONS;
        allImpressions.getClass();
        z4.b.a(fVar, "item is null");
        return new e5.j(new e5.g(allImpressions, s4.h.a(fVar), 2), new a(4, this, cVar));
    }
}
