package androidx.constraintlayout.core.motion.utils;

import com.ironsource.C2300e4;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Utils {
    static DebugHandle sOurHandle;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface DebugHandle {
        void message(String str);
    }

    private static int clamp(int i2) {
        int i8 = (i2 & (~(i2 >> 31))) - 255;
        return (i8 & (i8 >> 31)) + 255;
    }

    public static void log(String str, String str2) {
        System.out.println(str + " : " + str2);
    }

    public static void logStack(String str, int i2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i2, stackTrace.length - 1);
        String strC = " ";
        for (int i8 = 1; i8 <= iMin; i8++) {
            StackTraceElement stackTraceElement = stackTrace[i8];
            String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
            strC = a1.a.C(strC, " ");
            System.out.println(str + strC + str2 + strC);
        }
    }

    public static void loge(String str, String str2) {
        System.err.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f4, float f8, float f9, float f10) {
        int iClamp = clamp((int) (f4 * 255.0f));
        int iClamp2 = clamp((int) (f8 * 255.0f));
        return (iClamp << 16) | (clamp((int) (f10 * 255.0f)) << 24) | (iClamp2 << 8) | clamp((int) (f9 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        sOurHandle = debugHandle;
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace(C2300e4.i.f8403d, "   at ").replace(",", "\n   at").replace(C2300e4.i.e, ""));
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String strSubstring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + strSubstring;
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = sOurHandle;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }
}
