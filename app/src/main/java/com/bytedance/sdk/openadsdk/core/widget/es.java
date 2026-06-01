package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es {
    private c Bc;
    private MY Cc;
    private Context EO;
    private View IlO;
    private TextView MY;
    private ViewGroup lEW;
    private com.bytedance.sdk.openadsdk.core.rp.MY.IlO tV;
    private boolean vCE = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void EV();

        boolean NV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EO() {
        if (this.EO == null) {
            return;
        }
        tV();
    }

    private void tV() {
        View view = this.IlO;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void MY() {
        this.Bc = null;
    }

    public void IlO(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null) {
            return;
        }
        this.lEW = viewGroup;
        this.EO = com.bytedance.sdk.openadsdk.core.cl.IlO().getApplicationContext();
    }

    private void IlO(Context context, View view, boolean z2) {
        ViewGroup.LayoutParams layoutParamsIlO;
        if (context == null || view == null || this.IlO != null || (layoutParamsIlO = IlO(this.lEW)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.bWL.ea eaVar = new com.bytedance.sdk.openadsdk.bWL.ea(context);
        this.IlO = eaVar;
        eaVar.setLayoutParams(layoutParamsIlO);
        this.lEW.addView(this.IlO);
        this.MY = (TextView) this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.Pbh);
        View viewFindViewById = this.IlO.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.qIK);
        if (z2) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.es.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    es.this.EO();
                    if (es.this.tV != null) {
                        es.this.tV.IlO(IlO.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    private ViewGroup.LayoutParams IlO(ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return null;
    }

    public void IlO(com.bytedance.sdk.openadsdk.core.rp.MY.IlO ilO, MY my) {
        this.Cc = my;
        this.tV = ilO;
    }

    public boolean IlO(int i2, c cVar, boolean z2) {
        Context context = this.EO;
        if (context == null || cVar == null) {
            return true;
        }
        IlO(context, this.lEW, z2);
        this.Bc = cVar;
        if (i2 == 1 || i2 == 2) {
            return IlO(i2);
        }
        return true;
    }

    private boolean IlO(int i2) {
        MY my;
        if (IlO() || this.vCE) {
            return true;
        }
        if (this.tV != null && (my = this.Cc) != null) {
            if (my.NV()) {
                this.tV.Cc(null, null);
            }
            this.tV.IlO(IlO.PAUSE_VIDEO, (String) null);
        }
        IlO(this.Bc, true);
        return false;
    }

    public void IlO(boolean z2) {
        if (z2) {
            MY();
        }
        tV();
    }

    public boolean IlO() {
        View view = this.IlO;
        return view != null && view.getVisibility() == 0;
    }

    private void IlO(c cVar, boolean z2) {
        View view;
        String str;
        View view2;
        if (cVar == null || (view = this.IlO) == null || this.EO == null || view.getVisibility() == 0) {
            return;
        }
        MY my = this.Cc;
        if (my != null) {
            my.EV();
        }
        double dCeil = Math.ceil((cVar.f4687c * 1.0d) / 1048576.0d);
        if (z2) {
            str = String.format(pP.IlO(this.EO, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(dCeil).floatValue()));
        } else {
            str = pP.IlO(this.EO, "tt_video_without_wifi_tips") + pP.IlO(this.EO, "tt_video_bytesize");
        }
        BS.IlO(this.IlO, 0);
        BS.IlO(this.MY, str);
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: ");
        if (!BS.tV(this.IlO) || (view2 = this.IlO) == null) {
            return;
        }
        view2.bringToFront();
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: bringToFront");
    }
}
