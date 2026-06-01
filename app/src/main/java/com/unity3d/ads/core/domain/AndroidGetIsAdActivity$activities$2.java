package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import l7.m;
import r4.c;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetIsAdActivity$activities$2 extends l implements e6.a {
    final /* synthetic */ AndroidGetIsAdActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidGetIsAdActivity$activities$2(AndroidGetIsAdActivity androidGetIsAdActivity) {
        super(0);
        this.this$0 = androidGetIsAdActivity;
    }

    @Override // e6.a
    public final List<m> invoke() {
        List<ByteString> observableAndroidActivitiesList = this.this$0.sessionRepository.getNativeConfiguration().getObservableAndroidActivitiesList();
        k.d(observableAndroidActivitiesList, "sessionRepository.native…ableAndroidActivitiesList");
        ArrayList arrayList = new ArrayList(n.L0(observableAndroidActivitiesList, 10));
        Iterator<T> it = observableAndroidActivitiesList.iterator();
        while (it.hasNext()) {
            byte[] byteArray = ((ByteString) it.next()).toByteArray();
            byte[] bArrCopyOf = Arrays.copyOf(byteArray, byteArray.length);
            m mVar = m.f12880d;
            arrayList.add(c.f(bArrCopyOf));
        }
        return arrayList;
    }
}
