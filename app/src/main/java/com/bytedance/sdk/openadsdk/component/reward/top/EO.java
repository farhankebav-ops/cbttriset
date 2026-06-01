package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends View implements IlO<EO> {
    private IlO<EO> IlO;

    public EO(Context context) {
        this(context, null);
    }

    public EO IlO(@NonNull oeT oet) {
        if (this.IlO == null) {
            TopLayoutDislike2 topLayoutDislike2M214load = new TopLayoutDislike2(getContext()).load(oet);
            this.IlO = topLayoutDislike2M214load;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                IlO(topLayoutDislike2M214load, (ViewGroup) parent);
            }
        }
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void clickSkip() {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.clickSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void clickSound(String str) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.clickSound(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public View getCloseButton() {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            return ilO.getCloseButton();
        }
        return null;
    }

    public View getITopLayout() {
        Object obj = this.IlO;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setListener(MY my) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setListener(my);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setShowDislike(boolean z2) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setShowDislike(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setShowSkip(boolean z2) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setShowSkip(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setShowSound(boolean z2) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setShowSound(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSkipEnable(boolean z2) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setSkipEnable(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSkipInvisiable() {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setSkipInvisiable();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSkipText(CharSequence charSequence) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setSkipText(charSequence);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSoundMute(boolean z2) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setSoundMute(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.setTime(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void showCloseButton() {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.showCloseButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void showCountDownText() {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.showCountDownText();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void showSkipButton() {
        IlO<EO> ilO = this.IlO;
        if (ilO != null) {
            ilO.showSkipButton();
        }
    }

    public EO(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EO(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setVisibility(8);
        setWillNotDraw(true);
    }

    private void IlO(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
        if (view != null) {
            view.setId(zPa.pS);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }
}
