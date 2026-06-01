package w1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.cbt.exam.browser.R;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f17693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[][] f17694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o[] f17695d;
    public final a0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a0 f17696f;
    public final a0 g;
    public final a0 h;

    public c0(b0 b0Var) {
        this.f17692a = b0Var.f17686a;
        this.f17693b = b0Var.f17687b;
        this.f17694c = b0Var.f17688c;
        this.f17695d = b0Var.f17689d;
        this.e = b0Var.e;
        this.f17696f = b0Var.f17690f;
        this.g = b0Var.g;
        this.h = b0Var.h;
    }

    public static void a(b0 b0Var, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = b1.a.f4139v;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                o oVarA = o.a(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0), new a(0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i2 = 0;
                for (int i8 = 0; i8 < attributeCount; i8++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i8);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i9 = i2 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i8, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i2] = attributeNameResource;
                        i2 = i9;
                    }
                }
                b0Var.a(StateSet.trimStateSet(iArr2, i2), oVarA);
            }
        }
    }

    public static c0 b(Context context, TypedArray typedArray, int i2) {
        XmlResourceParser xml;
        AttributeSet attributeSetAsAttributeSet;
        int next;
        int resourceId = typedArray.getResourceId(i2, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        b0 b0Var = new b0();
        b0Var.b();
        try {
            xml = context.getResources().getXml(resourceId);
            try {
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
            } catch (Throwable th) {
                if (xml != null) {
                    try {
                        xml.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            b0Var.b();
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xml.getName().equals("selector")) {
            a(b0Var, context, xml, attributeSetAsAttributeSet, context.getTheme());
        }
        xml.close();
        if (b0Var.f17686a == 0) {
            return null;
        }
        return new c0(b0Var);
    }

    public final o c() {
        o oVar = this.f17693b;
        a0 a0Var = this.h;
        a0 a0Var2 = this.g;
        a0 a0Var3 = this.f17696f;
        a0 a0Var4 = this.e;
        if (a0Var4 == null && a0Var3 == null && a0Var2 == null && a0Var == null) {
            return oVar;
        }
        n nVarF = oVar.f();
        if (a0Var4 != null) {
            nVarF.e = a0Var4.f17681b;
        }
        if (a0Var3 != null) {
            nVarF.f17737f = a0Var3.f17681b;
        }
        if (a0Var2 != null) {
            nVarF.h = a0Var2.f17681b;
        }
        if (a0Var != null) {
            nVarF.g = a0Var.f17681b;
        }
        return nVarF.a();
    }

    public final boolean d() {
        a0 a0Var;
        a0 a0Var2;
        a0 a0Var3;
        a0 a0Var4;
        return this.f17692a > 1 || ((a0Var = this.e) != null && a0Var.f17680a > 1) || (((a0Var2 = this.f17696f) != null && a0Var2.f17680a > 1) || (((a0Var3 = this.g) != null && a0Var3.f17680a > 1) || ((a0Var4 = this.h) != null && a0Var4.f17680a > 1)));
    }
}
