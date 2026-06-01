package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1665gQ implements PZ {
    public final /* synthetic */ C05286k A00;
    public final /* synthetic */ PU A01;

    public C1665gQ(C05286k c05286k, PU pu) {
        this.A00 = c05286k;
        this.A01 = pu;
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final Object A58(int i2) {
        PS compatInfo = this.A01.A00(i2);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final List<Object> A6Q(String str, int i2) {
        List<PS> listA03 = this.A01.A03(str, i2);
        if (listA03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int infoCount = listA03.size();
        for (int i8 = 0; i8 < infoCount; i8++) {
            arrayList.add(listA03.get(i8).A0M());
        }
        return arrayList;
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final Object A6R(int i2) {
        PS compatInfo = this.A01.A01(i2);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.instagram.common.viewpoint.core.PZ
    public final boolean AGB(int i2, int i8, Bundle bundle) {
        return this.A01.A04(i2, i8, bundle);
    }
}
