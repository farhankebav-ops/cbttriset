package com.instagram.common.viewpoint.core;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1374bf {
    public static C5Q A00(final C1315ai c1315ai, int i2, final String str, final FH fh) {
        if (i2 == 1) {
            return new C5Q(c1315ai, str, fh) { // from class: com.facebook.ads.redexgen.X.0e
                public static final int A00 = (int) (AbstractC1180Wl.A02 * 20.0f);
                public static final int A01 = (int) (AbstractC1180Wl.A02 * 16.0f);

                @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
                public final boolean A02() {
                    return false;
                }

                @Override // com.instagram.common.viewpoint.core.C5Q
                public final void A1V(C1477dL c1477dL) {
                    C1297aQ titleDescContainer = getTitleDescContainer();
                    titleDescContainer.setAlignment(3);
                    titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    titleDescContainer.setPadding(0, 0, 0, A00);
                    getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayout = new LinearLayout(c1477dL);
                    XP.A0Q(linearLayout, new ColorDrawable(-1));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(3, getMediaContainer().getId());
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(1);
                    linearLayout.setPadding(A01, A01, A01, A01);
                    linearLayout.addView(titleDescContainer);
                    linearLayout.addView(getCtaButton());
                    addView(getMediaContainer());
                    addView(linearLayout);
                }
            };
        }
        return new C5Q(c1315ai, str, fh) { // from class: com.facebook.ads.redexgen.X.0f
            public static final int A00 = (int) (AbstractC1180Wl.A02 * 12.0f);

            @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
            public final boolean A01() {
                return false;
            }

            @Override // com.instagram.common.viewpoint.core.C5Q, com.instagram.common.viewpoint.core.AbstractC1311ae
            public final boolean A0C() {
                return false;
            }

            @Override // com.instagram.common.viewpoint.core.C5Q
            public final void A1V(C1477dL c1477dL) {
                C1297aQ titleDescContainer = getTitleDescContainer();
                titleDescContainer.setAlignment(3);
                RelativeLayout.LayoutParams adTitleAndDescriptionLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
                adTitleAndDescriptionLayoutParams.addRule(8, getMediaContainer().getId());
                titleDescContainer.setLayoutParams(adTitleAndDescriptionLayoutParams);
                titleDescContainer.setPadding(A00, A00, A00, A00);
                XP.A0P(titleDescContainer, getAdContextWrapper());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, getMediaContainer().getId());
                getCtaButton().setLayoutParams(layoutParams);
                addView(getMediaContainer());
                addView(titleDescContainer);
                addView(getCtaButton());
            }
        };
    }
}
