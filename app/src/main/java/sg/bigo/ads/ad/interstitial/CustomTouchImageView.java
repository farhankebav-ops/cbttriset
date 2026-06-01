package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;

/* JADX INFO: loaded from: classes6.dex */
public class CustomTouchImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdCountDownButton.a f14174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f14175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f14176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14177d;

    public CustomTouchImageView(Context context) {
        super(context);
        this.f14175b = new Rect();
        this.f14176c = 1.0f;
        this.f14177d = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14177d && motionEvent.getAction() == 0) {
            if (this.f14176c == 1.0f) {
                AdCountDownButton.a aVar = this.f14174a;
                if (aVar != null) {
                    aVar.a();
                }
                return true;
            }
            float x2 = (int) motionEvent.getX();
            float y = (int) motionEvent.getY();
            float f4 = this.f14176c;
            float width = getWidth();
            float f8 = width * f4;
            float height = getHeight();
            float f9 = f4 * height;
            float f10 = (width - f8) / 2.0f;
            float f11 = (height - f9) / 2.0f;
            float f12 = f8 + f10;
            float f13 = f9 + f11;
            if (x2 >= f10 && x2 <= f12 && y >= f11 && y <= f13) {
                AdCountDownButton.a aVar2 = this.f14174a;
                if (aVar2 != null) {
                    aVar2.a();
                }
                return true;
            }
            getGlobalVisibleRect(this.f14175b);
            AdCountDownButton.a aVar3 = this.f14174a;
            if (aVar3 != null) {
                aVar3.a(this.f14175b);
            }
        }
        return false;
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        this.f14177d = z2;
    }

    public void setCloseListener(AdCountDownButton.a aVar) {
        this.f14174a = aVar;
    }

    public void setRegionScale(float f4) {
        this.f14176c = f4;
    }

    public CustomTouchImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14175b = new Rect();
        this.f14176c = 1.0f;
        this.f14177d = true;
    }

    public CustomTouchImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14175b = new Rect();
        this.f14176c = 1.0f;
        this.f14177d = true;
    }
}
