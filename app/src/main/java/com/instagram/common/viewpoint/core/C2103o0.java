package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.facebook.ads.androidx.media3.common.text.Cue;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2103o0 implements C1S {
    public final long A00;

    @MetaExoPlayerCustomization("Oculus does not work well with Google Guava")
    public final List<C2105o2> A01;
    public static final C2103o0 A03 = new C2103o0(MetaExoPlayerCustomizedCollections.A01(), 0);
    public static final String A04 = AbstractC04664a.A0h(0);
    public static final String A05 = AbstractC04664a.A0h(1);
    public static final C1R<C2103o0> A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.o1
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C2103o0.A00(bundle);
        }
    };

    @MetaExoPlayerCustomization("Oculus does not work well with Google Guava")
    public C2103o0(List<C2105o2> list, long j) {
        this.A01 = MetaExoPlayerCustomizedCollections.A03((C2105o2[]) list.toArray(new C2105o2[0]));
        this.A00 = j;
    }

    public static final C2103o0 A00(Bundle bundle) {
        List listA01;
        List<Cue> cues = bundle.getParcelableArrayList(A04);
        if (cues == null) {
            listA01 = MetaExoPlayerCustomizedCollections.A01();
        } else {
            listA01 = C3S.A01(C2105o2.A0I, cues);
        }
        return new C2103o0(listA01, bundle.getLong(A05));
    }
}
