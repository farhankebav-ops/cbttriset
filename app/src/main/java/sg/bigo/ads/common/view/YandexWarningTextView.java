package sg.bigo.ads.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.e;

/* JADX INFO: loaded from: classes6.dex */
public class YandexWarningTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f16164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16165d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f16166f;
    private boolean g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f16167i;
    private int j;
    private int k;
    private final int l;

    public YandexWarningTextView(Context context) {
        super(context);
        this.f16162a = 25;
        this.f16163b = 10;
        this.f16164c = 35.0f;
        this.e = 1;
        this.f16166f = 50.0f;
        this.g = false;
        this.h = 0;
        this.f16167i = 0.0f;
        this.j = 1000;
        this.k = 1000;
        this.l = 1000;
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.YandexWarningTextView);
            this.f16162a = e.d(getContext(), typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.YandexWarningTextView_bigo_ad_maxTextSize, this.f16162a));
            this.f16163b = e.d(getContext(), typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.YandexWarningTextView_bigo_ad_minTextSize, this.f16163b));
            typedArrayObtainStyledAttributes.recycle();
        }
        this.j = e.c(getContext());
        this.k = e.b(getContext());
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        int i2 = this.e;
        if (i2 > 2) {
            i2 = 2;
        }
        canvas.save();
        float f4 = (this.f16165d * 1.0f) / i2;
        float f8 = f4 / this.f16166f;
        sg.bigo.ads.common.t.a.a("yandexWarn", "onDraw...singleLineHeight:" + f4 + "...scaleY:" + f8 + "...mPy:" + this.f16167i);
        canvas.scale(1.0f, f8, 0.0f, this.f16167i);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        int i11;
        super.onSizeChanged(i2, i8, i9, i10);
        if (i2 <= 0 || i8 <= 0) {
            return;
        }
        try {
            if (TextUtils.isEmpty(getText())) {
                return;
            }
            int paddingLeft = (i2 - getPaddingLeft()) - getPaddingRight();
            int paddingTop = (i8 - getPaddingTop()) - getPaddingBottom();
            this.f16165d = paddingTop;
            float f4 = this.f16162a;
            float f8 = paddingTop * 0.5f;
            this.f16164c = f8;
            setLineSpacing(f8, 0.0f);
            setTextSize(2, f4);
            StaticLayout staticLayout = new StaticLayout(getText(), getPaint(), paddingLeft, Layout.Alignment.ALIGN_NORMAL, 0.0f, this.f16164c, true);
            while (true) {
                if ((staticLayout.getHeight() <= this.f16165d && staticLayout.getWidth() <= paddingLeft) || f4 <= this.f16163b) {
                    break;
                }
                f4 -= 1.0f;
                setTextSize(2, f4);
                staticLayout = new StaticLayout(getText(), getPaint(), paddingLeft, Layout.Alignment.ALIGN_NORMAL, 0.0f, this.f16164c, true);
            }
            this.e = staticLayout.getLineCount();
            this.h = staticLayout.getLineAscent(0);
            this.f16166f = e.b(getContext(), Math.round(f4));
            int iAbs = Math.abs(this.h);
            boolean z2 = this.g;
            if (z2 || 1 == (i11 = this.e)) {
                if (!z2 || f4 <= 20.0f) {
                    this.f16167i = iAbs / 2.0f;
                } else {
                    this.f16167i = iAbs * 1.1f;
                }
            } else if (i11 >= 3) {
                this.f16167i = 0.0f;
            } else if (f4 > 36.0f) {
                this.f16167i = iAbs * 1.1f;
            } else {
                this.f16167i = (iAbs * 1.0f) / i11;
            }
            if (this.k <= 1000 && this.j <= 1000) {
                this.f16167i = 0.0f;
            }
            setLineSpacing(this.f16166f, 0.0f);
            sg.bigo.ads.common.t.a.a("yandexWarn", "adjust...line " + this.e + "...TextSizeSP:" + f4 + "...TextSizePx:" + this.f16166f + "...TotalHeight:" + this.f16165d + "..lineSpace:" + this.f16164c + "...scaleX:" + getPaint().getTextScaleX() + "...mSecondLineAscentHeight:" + this.h + "...secondLineTopH:" + staticLayout.getLineTop(0) + "...mPy:" + this.f16167i);
        } catch (Throwable unused) {
        }
    }

    public void setIsHorizontal(boolean z2) {
        this.g = z2;
    }

    public YandexWarningTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16162a = 25;
        this.f16163b = 10;
        this.f16164c = 35.0f;
        this.e = 1;
        this.f16166f = 50.0f;
        this.g = false;
        this.h = 0;
        this.f16167i = 0.0f;
        this.j = 1000;
        this.k = 1000;
        this.l = 1000;
        a(attributeSet);
    }

    public YandexWarningTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16162a = 25;
        this.f16163b = 10;
        this.f16164c = 35.0f;
        this.e = 1;
        this.f16166f = 50.0f;
        this.g = false;
        this.h = 0;
        this.f16167i = 0.0f;
        this.j = 1000;
        this.k = 1000;
        this.l = 1000;
        a(attributeSet);
    }
}
