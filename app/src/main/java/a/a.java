package a;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.PathParser;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.tasks.Task;
import com.mimikridev.utilmanager.security.Dataku;
import e6.p;
import g7.j;
import g7.q;
import j2.m;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.k;
import l6.c;
import n7.b;
import org.json.JSONException;
import org.json.JSONObject;
import s6.l;
import s6.t;
import v5.f;
import v5.g;
import v5.h;
import v5.i;
import w5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3198a;

    public /* synthetic */ a(int i2) {
        this.f3198a = i2;
    }

    public static f A(f fVar, g key) {
        k.e(key, "key");
        if (k.a(fVar.getKey(), key)) {
            return fVar;
        }
        return null;
    }

    public static final Class B(c cVar) {
        k.e(cVar, "<this>");
        Class clsA = ((d) cVar).a();
        k.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class C(c cVar) {
        k.e(cVar, "<this>");
        Class clsA = ((d) cVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals(TypedValues.Custom.S_FLOAT)) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static float D(String[] strArr, int i2) {
        float f4 = Float.parseFloat(strArr[i2]);
        if (f4 >= 0.0f && f4 <= 1.0f) {
            return f4;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f4);
    }

    public static SecretKeySpec G() {
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(Dataku.SECRETPASSPHRASE().toCharArray(), Dataku.SALT().getBytes(), 65536, 256)).getEncoded(), "AES");
    }

    public static String H(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }

    public static v5.c I(v5.c cVar) {
        v5.c<Object> cVarIntercepted;
        k.e(cVar, "<this>");
        x5.c cVar2 = cVar instanceof x5.c ? (x5.c) cVar : null;
        return (cVar2 == null || (cVarIntercepted = cVar2.intercepted()) == null) ? cVar : cVarIntercepted;
    }

    public static boolean J(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static String K(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i2 = 0;
        int i8 = 0;
        while (i2 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i8)) != -1) {
            sb.append((CharSequence) strValueOf, i8, iIndexOf);
            sb.append(L(objArr[i2]));
            i8 = iIndexOf + 2;
            i2++;
        }
        sb.append((CharSequence) strValueOf, i8, strValueOf.length());
        if (i2 < objArr.length) {
            String str2 = " [";
            while (i2 < objArr.length) {
                sb.append(str2);
                sb.append(L(objArr[i2]));
                i2++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String L(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e);
            StringBuilder sbY = a1.a.y("<", str, " threw ");
            sbY.append(e.getClass().getName());
            sbY.append(">");
            return sbY.toString();
        }
    }

    public static String M(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }

    public static h N(f fVar, g key) {
        k.e(key, "key");
        return k.a(fVar.getKey(), key) ? i.f17610a : fVar;
    }

    public static h O(f fVar, h context) {
        k.e(context, "context");
        return context == i.f17610a ? fVar : (h) context.fold(fVar, new androidx.camera.camera2.internal.compat.workaround.a(8));
    }

    public static void P(AtomicLong atomicLong, long j) {
        long j3;
        long j8;
        do {
            j3 = atomicLong.get();
            if (j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return;
            }
            j8 = j3 - j;
            if (j8 < 0) {
                b.F(new IllegalStateException(androidx.camera.core.processing.util.a.j("More produced than requested: ", j8)));
                j8 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j8));
    }

    public static int S(Context context, int i2, int i8) {
        TypedValue typedValueA = t1.b.a(context, i2);
        return (typedValueA == null || typedValueA.type != 16) ? i8 : typedValueA.data;
    }

    public static TimeInterpolator T(Context context, int i2, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!J(strValueOf, "cubic-bezier") && !J(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!J(strValueOf, "cubic-bezier")) {
            if (J(strValueOf, "path")) {
                return new PathInterpolator(PathParser.createPathFromPathData(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(D(strArrSplit, 0), D(strArrSplit, 1), D(strArrSplit, 2), D(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static int U(float f4) {
        if (Float.isNaN(f4)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f4);
    }

    public static void V(Runnable runnable) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final b7.c W(i7.f r6, l6.r r7, boolean r8) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.W(i7.f, l6.r, boolean):b7.c");
    }

    public static int[] X(byte[] bArr) {
        int[] iArr = new int[(bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i8 = i2 >>> 2;
            iArr[i8] = iArr[i8] | ((bArr[i2] & 255) << ((i2 & 3) << 3));
        }
        return iArr;
    }

    public static e2.i Y(Object obj) {
        return new e2.i(obj.getClass().getSimpleName());
    }

    public static Object Z(p pVar, Object obj, v5.c cVar) {
        k.e(pVar, "<this>");
        h context = cVar.getContext();
        Object dVar = context == i.f17610a ? new w5.d(cVar) : new e(cVar, context);
        d0.d(2, pVar);
        return pVar.invoke(obj, dVar);
    }

    public static s6.h a(int i2, int i8, s6.a aVar) {
        if ((i8 & 2) != 0) {
            aVar = s6.a.f13718a;
        }
        if (i2 == -2) {
            if (aVar != s6.a.f13718a) {
                return new t(1, aVar);
            }
            l.f13750z6.getClass();
            return new s6.h(s6.k.f13749b);
        }
        if (i2 != -1) {
            return i2 != 0 ? i2 != Integer.MAX_VALUE ? aVar == s6.a.f13718a ? new s6.h(i2) : new t(i2, aVar) : new s6.h(Integer.MAX_VALUE) : aVar == s6.a.f13718a ? new s6.h(0) : new t(1, aVar);
        }
        if (aVar == s6.a.f13718a) {
            return new t(1, s6.a.f13719b);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static int a0(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            case 15:
            default:
                return 0;
            case 16:
                return 17;
        }
    }

    public static q b(e6.l builderAction) {
        g7.b from = g7.c.f11597d;
        k.e(from, "from");
        k.e(builderAction, "builderAction");
        g7.h hVar = new g7.h();
        j jVar = from.f11598a;
        hVar.f11609a = jVar.f11613a;
        hVar.f11610b = jVar.f11616d;
        hVar.f11611c = jVar.f11614b;
        String str = jVar.e;
        String str2 = jVar.f11617f;
        g7.a aVar = jVar.h;
        boolean z2 = jVar.g;
        hVar.f11612d = jVar.f11615c;
        i7.f module = from.f11599b;
        builderAction.invoke(hVar);
        if (!k.a(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        j jVar2 = new j(hVar.f11609a, hVar.f11611c, hVar.f11612d, hVar.f11610b, str, str2, z2, aVar);
        k.e(module, "module");
        q qVar = new q(jVar2, module);
        if (module.equals(i7.h.f12046a)) {
            return qVar;
        }
        module.a(new e2.f(str2, 1));
        return qVar;
    }

    public static int c(int i2, int i8, int i9, int i10, int[] iArr, int i11) {
        return ((i2 ^ i8) + (iArr[(i10 & 3) ^ i11] ^ i9)) ^ (((i9 >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i9 << 4)));
    }

    public static Object d(Parcel parcel) {
        Parcelable.Creator creator = Bundle.CREATOR;
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void e(Parcel parcel, Bundle bundle, int i2) {
        if (bundle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, i2);
        }
    }

    public static long f(AtomicLong atomicLong, long j) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!atomicLong.compareAndSet(j3, g(j3, j)));
        return j3;
    }

    public static long g(long j, long j3) {
        long j8 = j + j3;
        return j8 < 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j8;
    }

    public static void h(Throwable th, Throwable exception) {
        k.e(th, "<this>");
        k.e(exception, "exception");
        if (th != exception) {
            Integer num = a6.a.f3228a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(exception);
                return;
            }
            Method method = z5.a.f17985a;
            if (method != null) {
                method.invoke(th, exception);
            }
        }
    }

    public static void i(StringBuilder sb, Object obj, e6.l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static final Object j(Task task, v5.c cVar) throws Exception {
        if (!task.isComplete()) {
            q6.l lVar = new q6.l(1, I(cVar));
            lVar.r();
            task.addOnCompleteListener(a7.a.f3229a, new a4.a(lVar, 2));
            Object objP = lVar.p();
            w5.a aVar = w5.a.f17774a;
            return objP;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }

    public static void n(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void o(int i2, String str) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i2);
    }

    public static final double p(double d8, o6.c sourceUnit, o6.c targetUnit) {
        k.e(sourceUnit, "sourceUnit");
        k.e(targetUnit, "targetUnit");
        long jConvert = targetUnit.f13214a.convert(1L, sourceUnit.f13214a);
        return jConvert > 0 ? d8 * jConvert : d8 / r8.convert(1L, r9);
    }

    public static final long q(long j, o6.c sourceUnit, o6.c targetUnit) {
        k.e(sourceUnit, "sourceUnit");
        k.e(targetUnit, "targetUnit");
        return targetUnit.f13214a.convert(j, sourceUnit.f13214a);
    }

    public static final long r(long j, o6.c sourceUnit, o6.c targetUnit) {
        k.e(sourceUnit, "sourceUnit");
        k.e(targetUnit, "targetUnit");
        return targetUnit.f13214a.convert(j, sourceUnit.f13214a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static v5.c s(p pVar, v5.c cVar, v5.c cVar2) {
        k.e(pVar, "<this>");
        if (pVar instanceof x5.a) {
            return ((x5.a) pVar).create(cVar, cVar2);
        }
        h context = cVar2.getContext();
        return context == i.f17610a ? new w5.b(pVar, cVar2, cVar) : new w5.c(cVar2, context, pVar, cVar);
    }

    public static void t(String str, String str2, Object obj) {
        String strH = H(str);
        if (Log.isLoggable(strH, 3)) {
            Log.d(strH, String.format(str2, obj));
        }
    }

    public static final byte[] u(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] iArrX = X(bArr);
        if (bArr2.length != 16) {
            byte[] bArr3 = new byte[16];
            if (bArr2.length < 16) {
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArr3, 0, 16);
            }
            bArr2 = bArr3;
        }
        int[] iArrX2 = X(bArr2);
        int length = iArrX.length;
        int i2 = length - 1;
        if (i2 >= 1) {
            int i8 = (52 / length) + 6;
            int iC = iArrX[0];
            for (int i9 = i8 * (-772015605); i9 != 0; i9 -= -772015605) {
                int i10 = (i9 >>> 2) & 3;
                int iC2 = iC;
                int i11 = i2;
                while (i11 > 0) {
                    iC2 = iArrX[i11] - c(i9, iC2, iArrX[i11 - 1], i11, iArrX2, i10);
                    iArrX[i11] = iC2;
                    i11--;
                }
                iC = iArrX[0] - c(i9, iC2, iArrX[i2], i11, iArrX2, i10);
                iArrX[0] = iC;
            }
        }
        int length2 = iArrX.length << 2;
        int i12 = iArrX[iArrX.length - 1];
        int i13 = length2 - 4;
        if (i12 < length2 - 7 || i12 > i13) {
            return null;
        }
        byte[] bArr4 = new byte[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            bArr4[i14] = (byte) (iArrX[i14 >>> 2] >>> ((i14 & 3) << 3));
        }
        return bArr4;
    }

    public static JSONObject v(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
        if (jSONObjectOptJSONObject == null) {
            throw new Exception("Invalid CBT file: no meta section");
        }
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("encrypted", false);
        String string = jSONObject.getString("payload");
        if (!zOptBoolean) {
            return new JSONObject(string);
        }
        byte[] bArrDecode = Base64.decode(string, 2);
        byte[] bArr = new byte[16];
        int length = bArrDecode.length - 16;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArrDecode, 0, bArr, 0, 16);
        System.arraycopy(bArrDecode, 16, bArr2, 0, length);
        SecretKeySpec secretKeySpecG = G();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpecG, ivParameterSpec);
        return new JSONObject(new String(cipher.doFinal(bArr2), StandardCharsets.UTF_8));
    }

    public static void w(String str, String str2, Exception exc) {
        String strH = H(str);
        if (Log.isLoggable(strH, 6)) {
            Log.e(strH, str2, exc);
        }
    }

    public static String x(JSONObject jSONObject) throws BadPaddingException, JSONException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpecG = G();
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpecG, ivParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
        byte[] bArr2 = new byte[bArrDoFinal.length + 16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArrDoFinal, 0, bArr2, 16, bArrDoFinal.length);
        String strEncodeToString = Base64.encodeToString(bArr2, 2);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("version", 1);
        jSONObject3.put("encrypted", true);
        jSONObject3.put("algorithm", "AES-256-CBC");
        jSONObject2.put("meta", jSONObject3);
        jSONObject2.put("payload", strEncodeToString);
        return jSONObject2.toString(2);
    }

    public abstract void E(Context context, String str, u3.d dVar, com.unity3d.scar.adapter.common.a aVar, android.support.v4.media.g gVar);

    public abstract void F(Context context, u3.d dVar, com.unity3d.scar.adapter.common.a aVar, android.support.v4.media.g gVar);

    public abstract void Q(j2.l lVar, j2.l lVar2);

    public abstract void R(j2.l lVar, Thread thread);

    public int hashCode() {
        switch (this.f3198a) {
            case 7:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public abstract boolean k(p4.a aVar, j2.d dVar, j2.d dVar2);

    public abstract boolean l(m mVar, Object obj, Object obj2);

    public abstract boolean m(m mVar, j2.l lVar, j2.l lVar2);

    public String toString() {
        switch (this.f3198a) {
            case 7:
                String strF = b0.a(getClass()).f();
                k.b(strF);
                return strF;
            default:
                return super.toString();
        }
    }

    public abstract j2.d y(p4.a aVar);

    public abstract j2.l z(p4.a aVar);
}
