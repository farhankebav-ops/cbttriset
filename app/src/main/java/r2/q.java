package r2;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.location.LocationRequestCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import f7.g0;
import f7.i1;
import f7.j1;
import f7.k1;
import f7.q1;
import f7.r1;
import f7.t0;
import f7.z0;
import i4.c1;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.b0;
import l6.r;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c1 f13622a;

    public static void A(int i2, int i8) {
        String strK;
        if (i2 < 0 || i2 >= i8) {
            if (i2 < 0) {
                strK = a.a.K("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2));
            } else {
                if (i8 < 0) {
                    throw new IllegalArgumentException(a1.a.g(i8, "negative size: "));
                }
                strK = a.a.K("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i2), Integer.valueOf(i8));
            }
            throw new IndexOutOfBoundsException(strK);
        }
    }

    public static final long A0(int i2, o6.c unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        return unit.compareTo(o6.c.f13212d) <= 0 ? R(a.a.r(i2, unit, o6.c.f13210b)) : B0(i2, unit);
    }

    public static void B(int i2, Object[] objArr) {
        for (int i8 = 0; i8 < i2; i8++) {
            if (objArr[i8] == null) {
                throw new NullPointerException(a1.a.g(i8, "at index "));
            }
        }
    }

    public static final long B0(long j, o6.c unit) {
        kotlin.jvm.internal.k.e(unit, "unit");
        o6.c cVar = o6.c.f13210b;
        long jR = a.a.r(4611686018426999999L, cVar, unit);
        return ((-jR) > j || j > jR) ? P(J(a.a.q(j, unit, o6.c.f13211c), -4611686018427387903L, 4611686018427387903L)) : R(a.a.r(j, unit, cVar));
    }

    public static final void C(int i2, String str) {
        if (str.charAt(i2) == '-') {
            return;
        }
        StringBuilder sbV = a1.a.v(i2, "Expected '-' (hyphen) at index ", ", but was '");
        sbV.append(str.charAt(i2));
        sbV.append('\'');
        throw new IllegalArgumentException(sbV.toString().toString());
    }

    public static boolean C0(o7.a aVar, s4.g gVar, x4.c cVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) aVar).call();
            if (objCall == null) {
                k5.d.a(gVar);
                return true;
            }
            try {
                Object objApply = cVar.apply(objCall);
                z4.b.a(objApply, "The mapper returned a null Publisher");
                o7.a aVar2 = (o7.a) objApply;
                if (!(aVar2 instanceof Callable)) {
                    aVar2.a(gVar);
                    return true;
                }
                try {
                    Object objCall2 = ((Callable) aVar2).call();
                    if (objCall2 == null) {
                        k5.d.a(gVar);
                        return true;
                    }
                    gVar.f(new k5.e(objCall2, gVar));
                    return true;
                } catch (Throwable th) {
                    y0(th);
                    k5.d.b(th, gVar);
                    return true;
                }
            } catch (Throwable th2) {
                y0(th2);
                k5.d.b(th2, gVar);
                return true;
            }
        } catch (Throwable th3) {
            y0(th3);
            k5.d.b(th3, gVar);
            return true;
        }
    }

    public static void D(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static k6.d D0(int i2, int i8) {
        if (i8 > Integer.MIN_VALUE) {
            return new k6.d(i2, i8 - 1, 1);
        }
        k6.d dVar = k6.d.f12716d;
        return k6.d.f12716d;
    }

    public static void E(int i2, int i8) {
        if (i2 < 0 || i2 > i8) {
            throw new IndexOutOfBoundsException(n(i2, i8, FirebaseAnalytics.Param.INDEX));
        }
    }

    public static void F(int i2, int i8, int i9) {
        if (i2 < 0 || i8 < i2 || i8 > i9) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i9) ? n(i2, i9, "start index") : (i8 < 0 || i8 > i9) ? n(i8, i9, "end index") : a.a.K("end index (%s) must not be less than start index (%s)", Integer.valueOf(i8), Integer.valueOf(i2)));
        }
    }

    public static void F0(Parcel parcel, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i2);
        }
    }

    public static void G(Object obj, String str, boolean z2) {
        if (!z2) {
            throw new IllegalStateException(a.a.K(str, obj));
        }
    }

    public static void H(boolean z2, String str) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(str));
        }
    }

    public static final void I(Closeable closeable, Throwable th) throws IOException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                a.a.h(th, th2);
            }
        }
    }

    public static long J(long j, long j3, long j8) {
        if (j3 <= j8) {
            return j < j3 ? j3 : j > j8 ? j8 : j;
        }
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("Cannot coerce value to an empty range: maximum ", j8, " is less than minimum ");
        sbT.append(j3);
        sbT.append('.');
        throw new IllegalArgumentException(sbT.toString());
    }

    public static ImageView.ScaleType K(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static n7.b L(int i2) {
        return i2 != 0 ? i2 != 1 ? new w1.m() : new w1.e() : new w1.m();
    }

    public static final q5.j M(Throwable exception) {
        kotlin.jvm.internal.k.e(exception, "exception");
        return new q5.j(exception);
    }

    public static s5.c N() {
        return new s5.c(10);
    }

    public static final byte[] O(String str) {
        int i2;
        byte b8;
        int i8;
        byte b9;
        int i9;
        byte b10;
        int i10;
        byte b11;
        byte[] bArr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i11 = 0;
        while (i11 < length) {
            while (true) {
                i2 = i11 + 1;
                b8 = bArr[bytes[i11]];
                if (i2 >= length || b8 != -1) {
                    break;
                }
                i11 = i2;
            }
            if (b8 == -1) {
                break;
            }
            while (true) {
                i8 = i2 + 1;
                b9 = bArr[bytes[i2]];
                if (i8 >= length || b9 != -1) {
                    break;
                }
                i2 = i8;
            }
            if (b9 == -1) {
                break;
            }
            byteArrayOutputStream.write((b8 << 2) | ((b9 & 48) >>> 4));
            while (true) {
                i9 = i8 + 1;
                byte b12 = bytes[i8];
                if (b12 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b10 = bArr[b12];
                if (i9 >= length || b10 != -1) {
                    break;
                }
                i8 = i9;
            }
            if (b10 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b9 & 15) << 4) | ((b10 & 60) >>> 2));
            while (true) {
                i10 = i9 + 1;
                byte b13 = bytes[i9];
                if (b13 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b11 = bArr[b13];
                if (i10 >= length || b11 != -1) {
                    break;
                }
                i9 = i10;
            }
            if (b11 == -1) {
                break;
            }
            byteArrayOutputStream.write(b11 | ((b10 & 3) << 6));
            i11 = i10;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final long P(long j) {
        long j3 = (j << 1) + 1;
        int i2 = o6.a.f13207d;
        int i8 = o6.b.f13209a;
        return j3;
    }

    public static final long Q(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? P(J(j, -4611686018427387903L, 4611686018427387903L)) : R(j * ((long) 1000000));
    }

    public static final long R(long j) {
        long j3 = j << 1;
        int i2 = o6.a.f13207d;
        int i8 = o6.b.f13209a;
        return j3;
    }

    public static void S(e7.f fVar, b7.j serializer, Object obj) {
        kotlin.jvm.internal.k.e(serializer, "serializer");
        if (serializer.getDescriptor().b()) {
            fVar.encodeSerializableValue(serializer, obj);
        } else if (obj == null) {
            fVar.encodeNull();
        } else {
            fVar.encodeNotNullMark();
            fVar.encodeSerializableValue(serializer, obj);
        }
    }

    public static final void T(long j, byte[] bArr, int i2, int i8, int i9) {
        int i10 = 7 - i8;
        int i11 = 8 - i9;
        if (i11 > i10) {
            return;
        }
        while (true) {
            int i12 = n6.d.f13086a[(int) ((j >> (i10 << 3)) & 255)];
            int i13 = i2 + 1;
            bArr[i2] = (byte) (i12 >> 8);
            i2 += 2;
            bArr[i13] = (byte) i12;
            if (i10 == i11) {
                return;
            } else {
                i10--;
            }
        }
    }

    public static final b7.c Y(b7.c cVar) {
        kotlin.jvm.internal.k.e(cVar, "<this>");
        return cVar.getDescriptor().b() ? cVar : new z0(cVar);
    }

    public static final k1 a(l6.c cVar, b7.c elementSerializer) {
        kotlin.jvm.internal.k.e(elementSerializer, "elementSerializer");
        return new k1(cVar, elementSerializer);
    }

    public static String b(File file) {
        int i2;
        if (!file.isFile()) {
            return "";
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                int i8 = bufferedInputStream.read(bArr, 0, 1024);
                if (i8 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i8);
            }
            if (!TextUtils.isEmpty(null)) {
                throw null;
            }
            bufferedInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest == null || bArrDigest.length <= 0) {
                return "";
            }
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i9 = 0;
            for (byte b8 : bArrDigest) {
                int i10 = i9 + 1;
                cArr2[i9] = cArr[(b8 >>> 4) & 15];
                i9 += 2;
                cArr2[i10] = cArr[b8 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static final f7.d c(b7.c elementSerializer) {
        kotlin.jvm.internal.k.e(elementSerializer, "elementSerializer");
        return new f7.d(elementSerializer, 0);
    }

    public static final g0 d(b7.c cVar) {
        return new g0(q1.f11501a, cVar, 1);
    }

    public static final i1 e(String str, d7.f fVar) {
        if (n6.m.A0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        Iterator it = ((s5.h) j1.f11473a.values()).iterator();
        while (((s5.d) it).hasNext()) {
            b7.c cVar = (b7.c) ((s5.d) it).next();
            if (str.equals(cVar.getDescriptor().h())) {
                StringBuilder sbY = a1.a.y("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exists ");
                sbY.append(b0.a(cVar.getClass()).f());
                sbY.append(".\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(n6.n.b0(sbY.toString()));
            }
        }
        return new i1(str, fVar);
    }

    public static Object f(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static final boolean g(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (kotlin.jvm.internal.k.g(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static final long h(String str) {
        o6.c cVar;
        long jQ;
        char cCharAt;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int i2 = o6.a.f13207d;
        char cCharAt2 = str.charAt(0);
        int i8 = (cCharAt2 == '+' || cCharAt2 == '-') ? 1 : 0;
        boolean z2 = i8 > 0 && n6.m.L0(str, '-');
        if (length <= i8) {
            throw new IllegalArgumentException("No components");
        }
        if (str.charAt(i8) != 'P') {
            throw new IllegalArgumentException();
        }
        int i9 = i8 + 1;
        if (i9 == length) {
            throw new IllegalArgumentException();
        }
        o6.c cVar2 = null;
        long jG = 0;
        boolean z7 = false;
        while (i9 < length) {
            if (str.charAt(i9) != 'T') {
                int i10 = i9;
                while (i10 < str.length() && (('0' <= (cCharAt = str.charAt(i10)) && cCharAt < ':') || n6.m.r0("+-.", cCharAt))) {
                    i10++;
                }
                String strSubstring = str.substring(i9, i10);
                kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
                if (strSubstring.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length2 = strSubstring.length() + i9;
                if (length2 < 0 || length2 >= str.length()) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                }
                char cCharAt3 = str.charAt(length2);
                int i11 = length2 + 1;
                if (z7) {
                    if (cCharAt3 == 'H') {
                        cVar = o6.c.f13213f;
                    } else if (cCharAt3 == 'M') {
                        cVar = o6.c.e;
                    } else {
                        if (cCharAt3 != 'S') {
                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                        }
                        cVar = o6.c.f13212d;
                    }
                } else {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    cVar = o6.c.g;
                }
                if (cVar2 != null && cVar2.compareTo(cVar) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iX0 = n6.m.x0(strSubstring, '.', 0, 6);
                if (cVar != o6.c.f13212d || iX0 <= 0) {
                    jG = o6.a.g(jG, B0(l0(strSubstring), cVar));
                } else {
                    String strSubstring2 = strSubstring.substring(0, iX0);
                    kotlin.jvm.internal.k.d(strSubstring2, "substring(...)");
                    long jG2 = o6.a.g(jG, B0(l0(strSubstring2), cVar));
                    String strSubstring3 = strSubstring.substring(iX0);
                    kotlin.jvm.internal.k.d(strSubstring3, "substring(...)");
                    double d8 = Double.parseDouble(strSubstring3);
                    double dP = a.a.p(d8, cVar, o6.c.f13210b);
                    if (Double.isNaN(dP)) {
                        throw new IllegalArgumentException("Duration value cannot be NaN.");
                    }
                    if (Double.isNaN(dP)) {
                        throw new IllegalArgumentException("Cannot round NaN value.");
                    }
                    long jRound = Math.round(dP);
                    if (-4611686018426999999L > jRound || jRound >= 4611686018427000000L) {
                        double dP2 = a.a.p(d8, cVar, o6.c.f13211c);
                        if (Double.isNaN(dP2)) {
                            throw new IllegalArgumentException("Cannot round NaN value.");
                        }
                        jQ = Q(Math.round(dP2));
                    } else {
                        jQ = R(jRound);
                    }
                    jG = o6.a.g(jG2, jQ);
                }
                cVar2 = cVar;
                i9 = i11;
            } else {
                if (z7 || (i9 = i9 + 1) == length) {
                    throw new IllegalArgumentException();
                }
                z7 = true;
            }
        }
        return z2 ? o6.a.j(jG) : jG;
    }

    public static final String i(Object[] objArr, int i2, int i8, r5.f fVar) {
        StringBuilder sb = new StringBuilder((i8 * 3) + 2);
        sb.append(C2300e4.i.f8403d);
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2 + i9];
            if (obj == fVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append(C2300e4.i.e);
        String string = sb.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }

    public static m6.i i0(e6.p pVar) {
        m6.i iVar = new m6.i();
        iVar.f12988d = a.a.s(pVar, iVar, iVar);
        return iVar;
    }

    public static void j(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static List j0(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        kotlin.jvm.internal.k.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static final g7.k k(e7.e eVar) {
        kotlin.jvm.internal.k.e(eVar, "<this>");
        g7.k kVar = eVar instanceof g7.k ? (g7.k) eVar : null;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + b0.a(eVar.getClass()));
    }

    public static final b7.c k0(l6.c cVar, ArrayList arrayList, e6.a aVar) {
        b7.c dVar;
        t0 t0Var;
        kotlin.jvm.internal.k.e(cVar, "<this>");
        if (cVar.equals(b0.a(Collection.class)) || cVar.equals(b0.a(List.class)) || cVar.equals(b0.a(List.class)) || cVar.equals(b0.a(ArrayList.class))) {
            dVar = new f7.d((b7.c) arrayList.get(0), 0);
        } else if (cVar.equals(b0.a(HashSet.class))) {
            dVar = new f7.d((b7.c) arrayList.get(0), 1);
        } else if (cVar.equals(b0.a(Set.class)) || cVar.equals(b0.a(Set.class)) || cVar.equals(b0.a(LinkedHashSet.class))) {
            dVar = new f7.d((b7.c) arrayList.get(0), 2);
        } else if (cVar.equals(b0.a(HashMap.class))) {
            dVar = new g0((b7.c) arrayList.get(0), (b7.c) arrayList.get(1), 0);
        } else if (cVar.equals(b0.a(Map.class)) || cVar.equals(b0.a(Map.class)) || cVar.equals(b0.a(LinkedHashMap.class))) {
            dVar = new g0((b7.c) arrayList.get(0), (b7.c) arrayList.get(1), 1);
        } else {
            if (cVar.equals(b0.a(Map.Entry.class))) {
                b7.c keySerializer = (b7.c) arrayList.get(0);
                b7.c valueSerializer = (b7.c) arrayList.get(1);
                kotlin.jvm.internal.k.e(keySerializer, "keySerializer");
                kotlin.jvm.internal.k.e(valueSerializer, "valueSerializer");
                t0Var = new t0(keySerializer, valueSerializer, 0);
            } else if (cVar.equals(b0.a(q5.i.class))) {
                b7.c keySerializer2 = (b7.c) arrayList.get(0);
                b7.c valueSerializer2 = (b7.c) arrayList.get(1);
                kotlin.jvm.internal.k.e(keySerializer2, "keySerializer");
                kotlin.jvm.internal.k.e(valueSerializer2, "valueSerializer");
                t0Var = new t0(keySerializer2, valueSerializer2, 1);
            } else if (cVar.equals(b0.a(q5.n.class))) {
                b7.c aSerializer = (b7.c) arrayList.get(0);
                b7.c bSerializer = (b7.c) arrayList.get(1);
                b7.c cSerializer = (b7.c) arrayList.get(2);
                kotlin.jvm.internal.k.e(aSerializer, "aSerializer");
                kotlin.jvm.internal.k.e(bSerializer, "bSerializer");
                kotlin.jvm.internal.k.e(cSerializer, "cSerializer");
                dVar = new r1(aSerializer, bSerializer, cSerializer);
            } else if (a.a.B(cVar).isArray()) {
                Object objInvoke = aVar.invoke();
                kotlin.jvm.internal.k.c(objInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                dVar = a((l6.c) objInvoke, (b7.c) arrayList.get(0));
            } else {
                dVar = null;
            }
            dVar = t0Var;
        }
        if (dVar != null) {
            return dVar;
        }
        b7.c[] cVarArr = (b7.c[]) arrayList.toArray(new b7.c[0]);
        return f7.c1.d(cVar, (b7.c[]) Arrays.copyOf(cVarArr, cVarArr.length));
    }

    public static final g7.p l(e7.f fVar) {
        kotlin.jvm.internal.k.e(fVar, "<this>");
        g7.p pVar = fVar instanceof g7.p ? (g7.p) fVar : null;
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + b0.a(fVar.getClass()));
    }

    public static final long l0(String str) {
        char cCharAt;
        int length = str.length();
        int i2 = (length <= 0 || !n6.m.r0("+-", str.charAt(0))) ? 0 : 1;
        if (length - i2 > 16) {
            int i8 = i2;
            while (true) {
                if (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == '0') {
                        if (i8 == i2) {
                            i8++;
                        }
                    } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                        break;
                    }
                    i2++;
                } else if (length - i8 > 16) {
                    if (str.charAt(0) == '-') {
                        return Long.MIN_VALUE;
                    }
                    return LocationRequestCompat.PASSIVE_INTERVAL;
                }
            }
        }
        return (!t.n0(str, "+", false) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(n6.m.s0(1, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m(s6.x r4, e6.a r5, x5.c r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof s6.u
            if (r0 == 0) goto L13
            r0 = r6
            s6.u r0 = (s6.u) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            s6.u r0 = new s6.u
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.g
            w5.a r1 = w5.a.f17774a
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            e6.a r5 = r0.f13757f
            z0(r6)     // Catch: java.lang.Throwable -> L29
            goto L63
        L29:
            r4 = move-exception
            goto L69
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            z0(r6)
            v5.h r6 = r0.getContext()
            q6.e1 r2 = q6.e1.f13546a
            v5.f r6 = r6.get(r2)
            if (r6 != r4) goto L6d
            r0.f13757f = r5     // Catch: java.lang.Throwable -> L29
            r0.h = r3     // Catch: java.lang.Throwable -> L29
            q6.l r6 = new q6.l     // Catch: java.lang.Throwable -> L29
            v5.c r0 = a.a.I(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.r()     // Catch: java.lang.Throwable -> L29
            s6.v r0 = new s6.v     // Catch: java.lang.Throwable -> L29
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L29
            s6.w r4 = (s6.w) r4     // Catch: java.lang.Throwable -> L29
            r4.d0(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.p()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L63
            return r1
        L63:
            r5.invoke()
            q5.x r4 = q5.x.f13520a
            return r4
        L69:
            r5.invoke()
            throw r4
        L6d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.q.m(s6.x, e6.a, x5.c):java.lang.Object");
    }

    public static String m0(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        long length = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb.toString();
            }
            length += (long) line.length();
            if (length > 10485760) {
                throw new IOException("File exceeds size limit");
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    public static String n(int i2, int i8, String str) {
        if (i2 < 0) {
            return a.a.K("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i8 >= 0) {
            return a.a.K("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i8));
        }
        throw new IllegalArgumentException(a1.a.g(i8, "negative size: "));
    }

    public static void n0(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static s5.c o(s5.c cVar) {
        cVar.f();
        cVar.f13698c = true;
        return cVar.f13697b > 0 ? cVar : s5.c.f13695d;
    }

    public static final void o0(int i2, int i8, Object[] objArr) {
        kotlin.jvm.internal.k.e(objArr, "<this>");
        while (i2 < i8) {
            objArr[i2] = null;
            i2++;
        }
    }

    public static final d7.h p(String str, d7.g[] gVarArr, e6.l lVar) {
        if (n6.m.A0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        d7.a aVar = new d7.a(str);
        lVar.invoke(aVar);
        return new d7.h(str, d7.m.f11201b, aVar.f11175c.size(), r5.j.s0(gVarArr), aVar);
    }

    public static int p0(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static d7.h q(String str, d7.g[] gVarArr) {
        if (n6.m.A0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        d7.a aVar = new d7.a(str);
        return new d7.h(str, d7.m.f11201b, aVar.f11175c.size(), r5.j.s0(gVarArr), aVar);
    }

    public static final b7.c q0(i7.f fVar, r type) {
        kotlin.jvm.internal.k.e(fVar, "<this>");
        kotlin.jvm.internal.k.e(type, "type");
        b7.c cVarW = a.a.W(fVar, type, true);
        if (cVarW != null) {
            return cVarW;
        }
        f7.c1.i(f7.c1.h(type));
        throw null;
    }

    public static final d7.h r(String serialName, a.a aVar, d7.g[] gVarArr, e6.l lVar) {
        kotlin.jvm.internal.k.e(serialName, "serialName");
        if (n6.m.A0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (aVar.equals(d7.m.f11201b)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        d7.a aVar2 = new d7.a(serialName);
        lVar.invoke(aVar2);
        return new d7.h(serialName, aVar, aVar2.f11175c.size(), r5.j.s0(gVarArr), aVar2);
    }

    public static final b7.c r0(l6.c cVar) {
        kotlin.jvm.internal.k.e(cVar, "<this>");
        b7.c cVarD = f7.c1.d(cVar, new b7.c[0]);
        return cVarD == null ? (b7.c) j1.f11473a.get(cVar) : cVarD;
    }

    public static d7.h s(String serialName, a.a aVar, d7.g[] gVarArr) {
        kotlin.jvm.internal.k.e(serialName, "serialName");
        if (n6.m.A0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (aVar.equals(d7.m.f11201b)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        d7.a aVar2 = new d7.a(serialName);
        return new d7.h(serialName, aVar, aVar2.f11175c.size(), r5.j.s0(gVarArr), aVar2);
    }

    public static final ArrayList s0(i7.f fVar, List typeArguments, boolean z2) {
        kotlin.jvm.internal.k.e(fVar, "<this>");
        kotlin.jvm.internal.k.e(typeArguments, "typeArguments");
        if (z2) {
            ArrayList arrayList = new ArrayList(r5.n.L0(typeArguments, 10));
            Iterator it = typeArguments.iterator();
            while (it.hasNext()) {
                arrayList.add(q0(fVar, (r) it.next()));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(r5.n.L0(typeArguments, 10));
        Iterator it2 = typeArguments.iterator();
        while (it2.hasNext()) {
            r type = (r) it2.next();
            kotlin.jvm.internal.k.e(type, "type");
            b7.c cVarW = a.a.W(fVar, type, false);
            if (cVarW == null) {
                return null;
            }
            arrayList2.add(cVarW);
        }
        return arrayList2;
    }

    public static void t0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z2 = onLongClickListener != null;
        boolean z7 = zHasOnClickListeners || z2;
        checkableImageButton.setFocusable(z7);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        checkableImageButton.setImportantForAccessibility(z7 ? 1 : 2);
    }

    public static void u0(View view, w1.k kVar) {
        p1.a aVar = kVar.f17716b.f17707c;
        if (aVar == null || !aVar.f13321a) {
            return;
        }
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += ((View) parent).getElevation();
        }
        w1.h hVar = kVar.f17716b;
        if (hVar.m != elevation) {
            hVar.m = elevation;
            kVar.w();
        }
    }

    public static void v(int i2, String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(a.a.K(str, Integer.valueOf(i2)));
        }
    }

    public static void w(Object obj, String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(a.a.K(str, obj));
        }
    }

    public static k6.b w0(k6.d dVar, int i2) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        boolean z2 = i2 > 0;
        Integer numValueOf = Integer.valueOf(i2);
        if (!z2) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i8 = dVar.f12709a;
        int i9 = dVar.f12710b;
        if (dVar.f12711c <= 0) {
            i2 = -i2;
        }
        return new k6.b(i8, i9, i2);
    }

    public static void x(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void x0(String str, int i2, e6.a aVar, int i8) {
        if ((i8 & 8) != 0) {
            str = null;
        }
        if ((i8 & 16) != 0) {
            i2 = -1;
        }
        u5.a aVar2 = new u5.a(aVar);
        if (i2 > 0) {
            aVar2.setPriority(i2);
        }
        if (str != null) {
            aVar2.setName(str);
        }
        aVar2.start();
    }

    public static void y(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void y0(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static void z(boolean z2, String str, long j) {
        if (!z2) {
            throw new IllegalArgumentException(a.a.K(str, Long.valueOf(j)));
        }
    }

    public static final void z0(Object obj) throws Throwable {
        if (obj instanceof q5.j) {
            throw ((q5.j) obj).f13500a;
        }
    }

    public abstract void E0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i8);

    public abstract int U();

    public abstract int V();

    public abstract int W();

    public abstract int X();

    public abstract int Z(View view);

    public abstract int a0(CoordinatorLayout coordinatorLayout);

    public abstract int b0();

    public abstract int c0(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int d0();

    public abstract ViewPropertyAnimator e0(View view, int i2);

    public abstract boolean f0(float f4);

    public abstract boolean g0(View view);

    public abstract boolean h0(float f4, float f8);

    public abstract int t(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float u(int i2);

    public abstract boolean v0(View view, float f4);
}
