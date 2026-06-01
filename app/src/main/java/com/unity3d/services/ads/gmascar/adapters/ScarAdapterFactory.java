package com.unity3d.services.ads.gmascar.adapters;

import a1.a;
import com.unity3d.scar.adapter.common.b;
import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ScarAdapterFactory {

    /* JADX INFO: renamed from: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion;

        static {
            int[] iArr = new int[ScarAdapterVersion.values().length];
            $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion = iArr;
            try {
                iArr[ScarAdapterVersion.V21.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[ScarAdapterVersion.V23.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[ScarAdapterVersion.NA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void reportAdapterFailure(ScarAdapterVersion scarAdapterVersion, d dVar) {
        String strM = a.m("SCAR version ", scarAdapterVersion.name(), " is not supported.");
        dVar.handleError(new b(c.g, strM, new Object[0]));
        DeviceLog.debug(strM);
    }

    public f createScarAdapter(ScarAdapterVersion scarAdapterVersion, d dVar) {
        int i2 = AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[scarAdapterVersion.ordinal()];
        if (i2 == 1) {
            String versionName = SdkProperties.getVersionName();
            a4.d dVar2 = new a4.d(dVar, 1);
            e2.f fVar = new e2.f(versionName, 4);
            x3.a aVar = new x3.a();
            aVar.f17789a = fVar;
            dVar2.f3227f = aVar;
            z3.a aVar2 = new z3.a(26);
            aVar2.f17979b = aVar;
            dVar2.f3223a = aVar2;
            return dVar2;
        }
        if (i2 != 2) {
            reportAdapterFailure(scarAdapterVersion, dVar);
            return null;
        }
        String versionName2 = SdkProperties.getVersionName();
        a4.d dVar3 = new a4.d(dVar, 0);
        e2.f fVar2 = new e2.f(versionName2, 4);
        b4.a aVar3 = new b4.a();
        aVar3.f4145a = fVar2;
        dVar3.f3227f = aVar3;
        d4.b bVar = new d4.b(26);
        bVar.f11050b = aVar3;
        dVar3.f3223a = bVar;
        return dVar3;
    }
}
