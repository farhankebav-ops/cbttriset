package com.bytedance.sdk.openadsdk.core.EV;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends Bc {

    @NonNull
    private final MediaEvents Cc;
    private boolean vCE;

    public DmF(@NonNull AdSession adSession, @NonNull AdEvents adEvents, @NonNull View view, @NonNull MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.Cc = mediaEvents;
    }

    @Override // com.bytedance.sdk.openadsdk.core.EV.Bc
    public void IlO(boolean z2, float f4) {
        if (z2) {
            this.tV = VastProperties.createVastPropertiesForSkippableMedia(f4, true, Position.STANDALONE);
        } else {
            this.tV = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        IlO(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.EV.Bc
    public void MY(int i2) {
        if (IlO()) {
            switch (i2) {
                case 0:
                    this.Cc.pause();
                    break;
                case 1:
                    this.Cc.resume();
                    break;
                case 2:
                case 14:
                    this.Cc.skipped();
                    break;
                case 4:
                    this.Cc.bufferStart();
                    break;
                case 5:
                    this.Cc.bufferFinish();
                    break;
                case 6:
                    this.Cc.firstQuartile();
                    break;
                case 7:
                    this.Cc.midpoint();
                    break;
                case 8:
                    this.Cc.thirdQuartile();
                    break;
                case 9:
                    this.Cc.complete();
                    break;
                case 10:
                    this.Cc.playerStateChange(PlayerState.FULLSCREEN);
                    break;
                case 11:
                    this.Cc.playerStateChange(PlayerState.NORMAL);
                    break;
                case 12:
                    this.Cc.volumeChange(this.vCE ? 0.0f : 1.0f);
                    break;
                case 13:
                    this.Cc.adUserInteraction(InteractionType.CLICK);
                    break;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.EV.Bc
    public void IlO(float f4, boolean z2) {
        if (IlO()) {
            this.Cc.start(f4, z2 ? 0.0f : 1.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.EV.Bc
    public void IlO(boolean z2) {
        this.vCE = z2;
        MY(12);
    }
}
