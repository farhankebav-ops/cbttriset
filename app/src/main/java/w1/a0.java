package w1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.cbt.exam.browser.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f17681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[][] f17682c = new int[10][];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d[] f17683d = new d[10];

    public static a0 b(d dVar) {
        a0 a0Var = new a0();
        a0Var.a(StateSet.WILD_CARD, dVar);
        return a0Var;
    }

    public final void a(int[] iArr, d dVar) {
        int i2 = this.f17680a;
        if (i2 == 0 || iArr.length == 0) {
            this.f17681b = dVar;
        }
        int[][] iArr2 = this.f17682c;
        if (i2 >= iArr2.length) {
            int i8 = i2 + 10;
            int[][] iArr3 = new int[i8][];
            System.arraycopy(iArr2, 0, iArr3, 0, i2);
            this.f17682c = iArr3;
            d[] dVarArr = new d[i8];
            System.arraycopy(this.f17683d, 0, dVarArr, 0, i2);
            this.f17683d = dVarArr;
        }
        int[][] iArr4 = this.f17682c;
        int i9 = this.f17680a;
        iArr4[i9] = iArr;
        this.f17683d[i9] = dVar;
        this.f17680a = i9 + 1;
    }

    public final d c(int[] iArr) {
        int i2;
        int[][] iArr2 = this.f17682c;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i2 = -1;
            if (i9 >= this.f17680a) {
                i9 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i9], iArr)) {
                break;
            }
            i9++;
        }
        if (i9 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.f17682c;
            while (true) {
                if (i8 >= this.f17680a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i8], iArr3)) {
                    i2 = i8;
                    break;
                }
                i8++;
            }
            i9 = i2;
        }
        return i9 < 0 ? this.f17681b : this.f17683d[i9];
    }

    public final void d(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                int[] iArr = b1.a.C;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                d dVarC = o.c(typedArrayObtainAttributes, 5, new a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i2 = 0;
                for (int i8 = 0; i8 < attributeCount; i8++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i8);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i9 = i2 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i8, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i2] = attributeNameResource;
                        i2 = i9;
                    }
                }
                a(StateSet.trimStateSet(iArr2, i2), dVarC);
            }
        }
    }
}
