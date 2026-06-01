package com.bytedance.sdk.openadsdk.EO;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.sdk.openadsdk.core.Cc.lEW {
    private boolean EO;
    private Paint IlO;
    private float MY;
    private int tV;

    public IlO(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        this.MY = BS.IlO(getContext(), 8.0f);
        this.IlO = new Paint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        IlO(getText().toString(), getWidth());
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.lEW, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        this.tV = getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, this.tV);
        } else {
            layoutParams.height = this.tV;
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Cc.lEW, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        int i2 = this.tV;
        if (i2 == 0 || layoutParams == null) {
            return;
        }
        layoutParams.height = i2;
    }

    public void setMinTextSize(float f4) {
        if (f4 <= 0.0f) {
            return;
        }
        this.MY = f4;
    }

    private void IlO(String str, int i2) {
        if (!this.EO && i2 > 0) {
            float textSize = getTextSize();
            this.IlO.set(getPaint());
            int paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
            float fIlO = IlO(textSize, str);
            while (fIlO > paddingLeft) {
                textSize -= 1.0f;
                this.IlO.setTextSize(textSize);
                if (textSize <= this.MY) {
                    break;
                } else {
                    fIlO = IlO(textSize, str);
                }
            }
            setTextSize(0, textSize);
            this.EO = true;
        }
    }

    private float IlO(float f4, String str) {
        this.IlO.setTextSize(f4);
        return this.IlO.measureText(str);
    }
}
