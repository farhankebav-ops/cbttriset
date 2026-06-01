package com.bytedance.adsdk.ugeno.DmF.MY;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends com.bytedance.adsdk.ugeno.MY.IlO<com.bytedance.adsdk.ugeno.DmF.MY.IlO> {
    private com.bytedance.adsdk.ugeno.DmF.MY.IlO eeU;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends IlO.C0032IlO {
        protected int tl;

        public IlO(com.bytedance.adsdk.ugeno.MY.IlO ilO) {
            super(ilO);
            this.tl = -1;
        }

        private int MY(String str) {
            str.getClass();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        public void IlO(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.IlO(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.tl = IlO(str2);
            }
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams IlO() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.IlO, (int) this.MY);
            layoutParams.leftMargin = (int) this.vCE;
            layoutParams.rightMargin = (int) this.Bc;
            layoutParams.topMargin = (int) this.lEW;
            layoutParams.bottomMargin = (int) this.DmF;
            layoutParams.gravity = this.tl;
            return layoutParams;
        }

        private int IlO(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iMY = 0;
            for (String str2 : strArrSplit) {
                iMY |= MY(str2);
            }
            return iMY;
        }
    }

    public MY(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ugeno.DmF.MY.IlO IlO() {
        com.bytedance.adsdk.ugeno.DmF.MY.IlO ilO = new com.bytedance.adsdk.ugeno.DmF.MY.IlO(this.MY);
        this.eeU = ilO;
        ilO.IlO(this);
        return this.eeU;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        this.eeU.setEventMap(this.OW);
        super.MY();
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public IlO.C0032IlO NV() {
        return new IlO(this);
    }
}
