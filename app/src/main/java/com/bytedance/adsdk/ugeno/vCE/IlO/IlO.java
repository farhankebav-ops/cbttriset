package com.bytedance.adsdk.ugeno.vCE.IlO;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.vCE.tV;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO extends LinearLayout {
    private int Bc;
    private int Cc;
    private int DmF;
    protected int EO;
    private float EV;
    protected Context IlO;
    protected int MY;
    private float NV;
    private boolean lEW;
    private String rp;
    private List<View> tV;
    private int vCE;

    public IlO(Context context) {
        super(context);
        this.Cc = SupportMenu.CATEGORY_MASK;
        this.vCE = -16776961;
        this.Bc = 5;
        this.MY = 40;
        this.EO = 20;
        this.rp = "row";
        this.IlO = context;
        this.tV = new ArrayList();
        setOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        layoutParams.topMargin = (int) (((int) ((height * r5) / 100.0f)) - ((getHeight() * this.EV) / 100.0f));
        layoutParams.leftMargin = (int) (((int) ((width * r0) / 100.0f)) - ((width2 * this.NV) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public void EO() {
        this.tV.clear();
        removeAllViews();
    }

    public abstract Drawable MY(int i2);

    public void MY() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof MY) {
            this.EO = this.MY;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.MY, this.EO);
        if (getOrientation() == 1) {
            int i2 = this.Bc;
            layoutParams.topMargin = i2;
            layoutParams.bottomMargin = i2;
        } else {
            int i8 = this.Bc;
            layoutParams.leftMargin = i8;
            layoutParams.rightMargin = i8;
        }
        addView(view, layoutParams);
        view.setBackground(MY(this.vCE));
        this.tV.add(view);
    }

    public int getSize() {
        return this.tV.size();
    }

    public void setIndicatorDirection(String str) {
        this.rp = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorHeight(int i2) {
        this.EO = i2;
    }

    public void setIndicatorWidth(int i2) {
        this.MY = i2;
    }

    public void setIndicatorX(float f4) {
        this.NV = f4;
    }

    public void setIndicatorY(float f4) {
        this.EV = f4;
    }

    public void setLoop(boolean z2) {
        this.lEW = z2;
    }

    public void setSelectedColor(int i2) {
        this.Cc = i2;
    }

    public void setUnSelectedColor(int i2) {
        this.vCE = i2;
    }

    public void IlO(int i2, int i8) {
        Iterator<View> it = this.tV.iterator();
        while (it.hasNext()) {
            it.next().setBackground(MY(this.vCE));
        }
        if (i2 < 0 || i2 >= this.tV.size()) {
            i2 = 0;
        }
        if (this.tV.size() > 0) {
            this.tV.get(i2).setBackground(MY(this.Cc));
            this.DmF = i8;
        }
    }

    public void IlO() {
        post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.vCE.IlO.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                IlO.this.tV();
            }
        });
    }

    public void IlO(int i2) {
        if (this instanceof MY) {
            this.EO = this.MY;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.MY, this.EO);
        if (getOrientation() == 1) {
            int i8 = this.Bc;
            layoutParams.topMargin = i8;
            layoutParams.bottomMargin = i8;
        } else {
            int i9 = this.Bc;
            layoutParams.leftMargin = i9;
            layoutParams.rightMargin = i9;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.MY, this.EO);
        if (getOrientation() == 1) {
            int i10 = this.Bc;
            layoutParams2.topMargin = i10;
            layoutParams2.bottomMargin = i10;
        } else {
            int i11 = this.Bc;
            layoutParams2.leftMargin = i11;
            layoutParams2.rightMargin = i11;
        }
        int iIlO = tV.IlO(this.lEW, this.DmF, this.tV.size());
        int iIlO2 = tV.IlO(this.lEW, i2, this.tV.size());
        if (this.tV.size() == 0) {
            iIlO2 = 0;
        }
        if (!this.tV.isEmpty() && tV.IlO(iIlO, this.tV) && tV.IlO(iIlO2, this.tV)) {
            this.tV.get(iIlO).setBackground(MY(this.vCE));
            this.tV.get(iIlO).setLayoutParams(layoutParams2);
            this.tV.get(iIlO2).setBackground(MY(this.Cc));
            this.tV.get(iIlO2).setLayoutParams(layoutParams);
            this.DmF = i2;
        }
    }
}
