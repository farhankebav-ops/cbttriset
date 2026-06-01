package com.bytedance.sdk.openadsdk.core.EV;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    private final AdSession Cc;
    protected String EO;
    protected VastProperties tV;
    private final AdEvents vCE;
    private boolean Bc = false;
    protected boolean IlO = false;
    protected int MY = 0;

    public Bc(AdSession adSession, AdEvents adEvents, View view) {
        this.Cc = adSession;
        this.vCE = adEvents;
        this.EO = adSession.getAdSessionId();
        IlO(view);
    }

    public void EO() {
        IlO(4);
    }

    public void IlO(float f4, boolean z2) {
    }

    public void MY(int i2) {
    }

    public void tV() {
        IlO(3);
    }

    public void IlO(boolean z2) {
    }

    public void MY() {
        IlO(1);
    }

    public void IlO(boolean z2, float f4) {
    }

    public void IlO(View view) {
        AdSession adSession;
        if (view == null || (adSession = this.Cc) == null) {
            return;
        }
        adSession.registerAdView(view);
    }

    public void IlO(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.Cc;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        }
    }

    public boolean IlO() {
        return this.IlO;
    }

    public void IlO(int i2) {
        int i8;
        if (this.Cc == null || this.vCE == null || !Cc.EO()) {
            return;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4 || (i8 = this.MY) == 0 || i8 == 4) {
                        return;
                    }
                    this.Cc.finish();
                    this.IlO = false;
                } else {
                    if (this.Bc) {
                        return;
                    }
                    int i9 = this.MY;
                    if (i9 != 1 && i9 != 2) {
                        return;
                    }
                    this.vCE.impressionOccurred();
                    this.Bc = true;
                }
            } else {
                if (this.MY != 0) {
                    return;
                }
                this.Cc.start();
                if (this.tV == null) {
                    this.tV = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                this.vCE.loaded(this.tV);
                this.IlO = true;
                this.tV = null;
            }
        } else {
            if (this.MY != 0) {
                return;
            }
            this.Cc.start();
            this.vCE.loaded();
            this.IlO = true;
        }
        this.MY = i2;
    }

    public void IlO(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair<View, FriendlyObstructionPurpose> pair : set) {
            IlO((View) pair.first, (FriendlyObstructionPurpose) pair.second);
        }
    }
}
