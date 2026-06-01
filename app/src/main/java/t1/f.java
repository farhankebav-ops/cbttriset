package t1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f17392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17395d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17396f;
    public final float g;
    public final float h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17397i;
    public final float j;
    public final ColorStateList k;
    public float l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f17398n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f17399o = false;
    public Typeface p;

    public f(Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.k = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f17395d = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.e = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i8 = R.styleable.TextAppearance_fontFamily;
        i8 = typedArrayObtainStyledAttributes.hasValue(i8) ? i8 : R.styleable.TextAppearance_android_fontFamily;
        this.m = typedArrayObtainStyledAttributes.getResourceId(i8, 0);
        this.f17393b = typedArrayObtainStyledAttributes.getString(i8);
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f17392a = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f17396f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i2, b1.a.f4141x);
        this.f17397i = typedArrayObtainStyledAttributes2.hasValue(0);
        this.j = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f17394c = typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(3) ? 3 : 1);
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.p;
        int i2 = this.f17395d;
        if (typeface == null && (str = this.f17393b) != null) {
            this.p = Typeface.create(str, i2);
        }
        if (this.p == null) {
            int i8 = this.e;
            if (i8 == 1) {
                this.p = Typeface.SANS_SERIF;
            } else if (i8 == 2) {
                this.p = Typeface.SERIF;
            } else if (i8 != 3) {
                this.p = Typeface.DEFAULT;
            } else {
                this.p = Typeface.MONOSPACE;
            }
            this.p = Typeface.create(this.p, i2);
        }
    }

    public final void b(Context context, g gVar) {
        if (!c(context)) {
            a();
        }
        int i2 = this.m;
        if (i2 == 0) {
            this.f17398n = true;
        }
        if (this.f17398n) {
            gVar.b(this.p, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i2, new d(this, gVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f17398n = true;
            gVar.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.f17393b, e);
            this.f17398n = true;
            gVar.a(-3);
        }
    }

    public final boolean c(Context context) {
        String string;
        Typeface typefaceCreate;
        XmlResourceParser xml;
        if (this.f17398n) {
            return true;
        }
        int i2 = this.m;
        if (i2 != 0) {
            Typeface cachedFont = ResourcesCompat.getCachedFont(context, i2);
            if (cachedFont != null) {
                this.p = cachedFont;
                this.f17398n = true;
                return true;
            }
            Typeface typefaceCreate2 = null;
            if (!this.f17399o) {
                this.f17399o = true;
                Resources resources = context.getResources();
                if (i2 == 0 || !resources.getResourceTypeName(i2).equals("font")) {
                    string = null;
                    if (string != null && (typefaceCreate = Typeface.create(string, 0)) != Typeface.DEFAULT) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.f17395d);
                    }
                } else {
                    try {
                        xml = resources.getXml(i2);
                    } catch (Throwable unused) {
                    }
                    while (xml.getEventType() != 1) {
                        if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R.styleable.FontFamily);
                            string = typedArrayObtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                            typedArrayObtainAttributes.recycle();
                            break;
                        }
                        xml.next();
                        string = null;
                    }
                    string = null;
                    if (string != null) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.f17395d);
                    }
                }
            }
            if (typefaceCreate2 != null) {
                this.p = typefaceCreate2;
                this.f17398n = true;
                return true;
            }
        }
        return false;
    }

    public final void d(Context context, TextPaint textPaint, g gVar) {
        e(context, textPaint, gVar);
        ColorStateList colorStateList = this.k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        ColorStateList colorStateList2 = this.f17392a;
        textPaint.setShadowLayer(this.h, this.f17396f, this.g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, g gVar) {
        Typeface typeface;
        if (c(context) && this.f17398n && (typeface = this.p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.p);
        b(context, new e(this, context, textPaint, gVar));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = h.a(context.getResources().getConfiguration(), typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f17395d;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.l);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.f17394c);
        }
        if (this.f17397i) {
            textPaint.setLetterSpacing(this.j);
        }
    }
}
