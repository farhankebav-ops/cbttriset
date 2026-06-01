package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.MY.IlO;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.rp.MY.vCE;
import com.bytedance.sdk.openadsdk.utils.tV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGVideoMediaView extends PAGMediaView implements IlO.InterfaceC0087IlO {
    private final com.bytedance.sdk.openadsdk.IlO.MY.IlO EO;
    private vCE MY;
    private oeT tV;

    public PAGVideoMediaView(Context context, @Nullable View view, @Nullable com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO) {
        super(context);
        IlO(view);
        this.EO = ilO;
    }

    private void IlO(View view) {
        if (view instanceof vCE) {
            vCE vce = (vCE) view;
            this.MY = vce;
            addView(vce, -1, -1);
        }
    }

    private boolean MY() {
        vCE vce = this.MY;
        if (vce != null) {
            return vce.hp();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void close() {
        vCE vce = this.MY;
        if (vce != null) {
            vce.zPa();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.MY.IlO.InterfaceC0087IlO
    public long getVideoProgress() {
        vCE vce = this.MY;
        if (vce == null || vce.getNativeVideoController() == null) {
            return 0L;
        }
        return this.MY.getNativeVideoController().Cc();
    }

    public void handleInterruptVideo() {
        if (MY()) {
            return;
        }
        IlO();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tV.IlO(this, this.tV);
    }

    public void setMaterialMeta(oeT oet) {
        this.tV = oet;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof IlO) {
            ((IlO) onClickListener).IlO((IlO.InterfaceC0087IlO) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.IlO.MY.IlO ilO = this.EO;
        if (ilO == null) {
            return;
        }
        ilO.IlO(new PAGVideoAdListener() { // from class: com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView.1
            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdComplete() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPaused() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPlay() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoError() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }
        });
    }

    private void IlO() {
        vCE vce = this.MY;
        if (vce != null) {
            vce.ea();
        }
    }
}
