package com.bytedance.sdk.component.adexpress.vCE;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.sdk.component.utils.vSq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends TextSwitcher implements ViewSwitcher.ViewFactory, vSq.IlO {
    private int Bc;
    private Context Cc;
    private float DmF;
    private int EO;
    private int EV;
    Animation.AnimationListener IlO;
    private List<String> MY;
    private int NV;
    private Handler bWL;
    private int hp;
    private int lEW;
    private int rp;
    private final int tV;
    private TextView vCE;

    public IlO(Context context, int i2, float f4, int i8, int i9) {
        super(context);
        this.MY = new ArrayList();
        this.EO = 0;
        this.tV = 1;
        this.bWL = new vSq(Looper.getMainLooper(), this);
        this.IlO = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.vCE.IlO.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (IlO.this.vCE != null) {
                    IlO.this.vCE.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.Cc = context;
        this.lEW = i2;
        this.DmF = f4;
        this.NV = i8;
        this.hp = i9;
        EO();
    }

    private void EO() {
        setFactory(this);
    }

    public void MY() {
        List<String> list = this.MY;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i2 = this.EO;
        this.EO = i2 + 1;
        this.EV = i2;
        setText(this.MY.get(i2));
        if (this.EO > this.MY.size() - 1) {
            this.EO = 0;
        }
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.vCE = textView;
        textView.setTextColor(this.lEW);
        this.vCE.setTextSize(this.DmF);
        this.vCE.setMaxLines(this.NV);
        this.vCE.setTextAlignment(this.hp);
        return this.vCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.bWL.sendEmptyMessageDelayed(1, this.Bc);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bWL.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY(this.MY.get(this.EV), this.DmF, false)[0], BasicMeasure.EXACTLY), i2);
        } catch (Exception unused) {
            super.onMeasure(i2, i8);
        }
    }

    public void setAnimationDuration(int i2) {
        this.Bc = i2;
    }

    public void setAnimationText(List<String> list) {
        this.MY = list;
    }

    public void setAnimationType(int i2) {
        this.rp = i2;
    }

    public void setMaxLines(int i2) {
        this.NV = i2;
    }

    public void setTextColor(int i2) {
        this.lEW = i2;
    }

    public void setTextSize(float f4) {
        this.DmF = f4;
    }

    public void IlO() {
        int i2 = this.rp;
        if (i2 == 1) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.pP.DmF(this.Cc, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.pP.DmF(this.Cc, "tt_text_animation_y_out"));
        } else if (i2 == 0) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.pP.DmF(this.Cc, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.pP.DmF(this.Cc, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.IlO);
            getOutAnimation().setAnimationListener(this.IlO);
        }
        this.bWL.sendEmptyMessage(1);
    }

    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    public void IlO(Message message) {
        if (message.what != 1) {
            return;
        }
        MY();
        this.bWL.sendEmptyMessageDelayed(1, this.Bc);
    }
}
