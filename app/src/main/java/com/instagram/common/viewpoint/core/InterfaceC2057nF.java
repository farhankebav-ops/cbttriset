package com.instagram.common.viewpoint.core;

import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC2057nF extends InterfaceC04322s, CX, ET, C9Q {

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Temporary Noop Implementation until we completely migrate")
    public static final InterfaceC2057nF A00 = new InterfaceC2057nF() { // from class: com.facebook.ads.redexgen.X.9S
        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void ACv(C2103o0 c2103o0) {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void ACw(List list) {
        }

        @Override // com.instagram.common.viewpoint.core.CX
        public final /* synthetic */ void AD6(int i2, C2001mL c2001mL, CG cg) {
        }

        @Override // com.instagram.common.viewpoint.core.CX
        public final /* synthetic */ void ADw(int i2, C2001mL c2001mL, CE ce, CG cg) {
        }

        @Override // com.instagram.common.viewpoint.core.CX
        public final /* synthetic */ void ADy(int i2, C2001mL c2001mL, CE ce, CG cg, Object obj, Object obj2) {
        }

        @Override // com.instagram.common.viewpoint.core.CX
        public final /* synthetic */ void AE1(int i2, C2001mL c2001mL, CE ce, CG cg, IOException iOException, boolean z2) {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void AEb(C2138ob c2138ob) {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void AEd(C2140od c2140od) {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void AEf(boolean z2, int i2) {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void AFB() {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void AFQ(Timeline timeline, int i2) {
            AbstractC04312r.A00(this, timeline, i2);
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC04322s
        public final /* synthetic */ void AFU(C2109o6 c2109o6) {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC2057nF
        public final void AC5() {
        }

        @Override // com.instagram.common.viewpoint.core.InterfaceC2057nF
        public final void AIv(InterfaceC04392z interfaceC04392z, Looper looper) {
        }
    };

    void AC5();

    void AIv(InterfaceC04392z interfaceC04392z, Looper looper);
}
