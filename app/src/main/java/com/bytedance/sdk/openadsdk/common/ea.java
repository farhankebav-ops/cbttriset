package com.bytedance.sdk.openadsdk.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.EO.NV;
import com.bytedance.sdk.openadsdk.EO.rp;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea extends com.bytedance.sdk.openadsdk.core.Cc.EO implements NV.MY {
    private final com.bytedance.sdk.openadsdk.EO.NV Bc;
    private String Cc;
    private IlO EO;
    private View IlO;
    private oeT MY;
    private Context tV;
    private boolean vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO(View view);

        void IlO(FilterWord filterWord);

        void MY(View view);
    }

    public ea(@NonNull Context context, @NonNull oeT oet) {
        this(context.getApplicationContext());
        this.MY = oet;
        this.tV = context;
        tV();
        Cc();
    }

    private void Cc() {
        com.bytedance.sdk.openadsdk.EO.NV nv;
        oeT oet = this.MY;
        if (oet == null || (nv = this.Bc) == null) {
            return;
        }
        nv.IlO(oet.cJK());
    }

    private void tV() {
        this.Bc.IlO(this.MY.KT());
        this.Bc.IlO(this);
    }

    private rp.IlO vCE() {
        return new rp.IlO() { // from class: com.bytedance.sdk.openadsdk.common.ea.2
            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void EO() {
                ea.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void IlO() {
                ea.this.setVisibility(8);
            }

            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void MY() {
                ea.this.setVisibility(0);
            }

            @Override // com.bytedance.sdk.openadsdk.EO.rp.IlO
            public void IlO(int i2, FilterWord filterWord, String str) {
                ea.this.Bc.EO(str);
                ea.this.setVisibility(0);
            }
        };
    }

    public void EO() {
        Context context = this.tV;
        if (context instanceof Activity) {
            boolean zIsFinishing = ((Activity) context).isFinishing();
            com.bytedance.sdk.openadsdk.EO.rp rpVar = new com.bytedance.sdk.openadsdk.EO.rp(this.tV, this.Bc);
            rpVar.IlO(vCE());
            rpVar.IlO(this.MY.KT(), this.MY.eDn().toString());
            rpVar.IlO(this.Cc);
            if (zIsFinishing || rpVar.isShowing()) {
                return;
            }
            rpVar.show();
        }
    }

    public void MY() {
        setVisibility(8);
        this.vCE = false;
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.MY(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.sdk.openadsdk.EO.NV nv = this.Bc;
        if (nv != null) {
            nv.IlO();
        }
    }

    public void setCallback(IlO ilO) {
        this.EO = ilO;
    }

    public void setDislikeSource(String str) {
        this.Cc = str;
        this.Bc.MY(str);
    }

    private void IlO(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.ea.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ea.this.Bc != null) {
                    ea.this.Bc.Cc();
                } else {
                    ea.this.MY();
                }
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.IlO = new com.bytedance.sdk.openadsdk.EO.DmF(context, this.Bc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = BS.MY(getContext(), 20.0f);
        layoutParams.rightMargin = BS.MY(getContext(), 20.0f);
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setClickable(true);
        Cc();
    }

    public ea(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public ea(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ea(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.vCE = false;
        this.Bc = new com.bytedance.sdk.openadsdk.EO.NV();
        IlO(context, attributeSet);
    }

    public void IlO() {
        if (this.IlO.getParent() == null) {
            addView(this.IlO);
        }
        setVisibility(0);
        this.vCE = true;
        IlO ilO = this.EO;
        if (ilO != null) {
            ilO.IlO(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.EO.NV.MY
    public void IlO(int i2) {
        if (com.bytedance.sdk.openadsdk.EO.NV.MY == i2) {
            FilterWord filterWordMY = this.Bc.MY();
            if (filterWordMY == null || com.bytedance.sdk.openadsdk.EO.NV.IlO.equals(filterWordMY)) {
                return;
            }
            IlO ilO = this.EO;
            if (ilO != null) {
                try {
                    ilO.IlO(filterWordMY);
                } catch (Throwable unused) {
                }
            }
            MY();
            return;
        }
        if (com.bytedance.sdk.openadsdk.EO.NV.EO == i2) {
            MY();
        } else if (com.bytedance.sdk.openadsdk.EO.NV.Cc == i2) {
            EO();
        }
    }
}
