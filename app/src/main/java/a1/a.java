package a1;

import android.net.Uri;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static void A(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize, SurfaceCombination surfaceCombination, SurfaceConfig.ConfigType configType2, SurfaceConfig.ConfigSize configSize2) {
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
    }

    public static void B(String str, CallbackToFutureAdapter.Completer completer) {
        completer.setException(new CameraControl.OperationCanceledException(str));
    }

    public static String C(String str, String str2) {
        return str + str2;
    }

    public static String D(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static float a(float f4, float f8, float f9, float f10) {
        return ((f4 - f8) * f9) + f10;
    }

    public static int b(int i2, int i8, int i9, int i10) {
        return i2 + i8 + i9 + i10;
    }

    public static SurfaceCombination c(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize, SurfaceCombination surfaceCombination, ArrayList arrayList, SurfaceCombination surfaceCombination2) {
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(surfaceCombination2);
        return new SurfaceCombination();
    }

    public static SurfaceCombination d(ArrayList arrayList, SurfaceCombination surfaceCombination) {
        arrayList.add(surfaceCombination);
        return new SurfaceCombination();
    }

    public static String e(char c7, String str, StringBuilder sb) {
        sb.append(str);
        sb.append(c7);
        return sb.toString();
    }

    public static String f(int i2, int i8, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i8);
        return sb.toString();
    }

    public static String g(int i2, String str) {
        return str + i2;
    }

    public static String h(int i2, String str, String str2) {
        return str + i2 + str2;
    }

    public static String i(int i2, StringBuilder sb) {
        sb.append(Integer.toHexString(i2));
        return sb.toString();
    }

    public static String j(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static String k(String str, Uri uri) {
        return str + uri;
    }

    public static String l(String str, String str2) {
        return str + str2;
    }

    public static String m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String n(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String o(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String p(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String q(StringBuilder sb, String str, int i2) {
        sb.append(i2);
        sb.append(str);
        return sb.toString();
    }

    public static String r(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String t(StringBuilder sb, boolean z2, char c7) {
        sb.append(z2);
        sb.append(c7);
        return sb.toString();
    }

    public static String u(StringBuilder sb, boolean z2, String str) {
        sb.append(z2);
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder v(int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder w(int i2, String str, String str2, int i8, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i8);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder x(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder z(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }
}
