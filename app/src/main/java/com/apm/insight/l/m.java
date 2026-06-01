package com.apm.insight.l;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.l.e;
import com.apm.insight.nativecrash.NativeImpl;
import com.ironsource.C2300e4;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f4545a = new StackTraceElement("", "", "", 0);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4547b;

        public a(int i2, int i8) {
            this.f4546a = i2;
            this.f4547b = i8;
        }

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f4546a);
                jSONObject.put("end", this.f4547b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StackTraceElement[] b(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            a(th, arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    private static boolean c(String str) {
        Set<String> setA = g.a();
        if (setA.contains(str)) {
            return true;
        }
        for (String str2 : setA) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i2 = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i2 > 20) {
                    return false;
                }
                i2++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    @Nullable
    public static JSONObject b(String str) {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!c(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() > 0) {
                        }
                    }
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i2 = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i2 > 20) {
                return false;
            }
            i2++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @NonNull
    public static String a(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            a(th, printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    @NonNull
    public static String a(@NonNull Throwable th, PrintStream printStream, e.a aVar) throws IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Throwable unused) {
            messageDigest = null;
        }
        e eVar = new e(printStream, messageDigest, aVar);
        try {
            a(th, eVar);
        } catch (Throwable unused2) {
        }
        eVar.close();
        if (messageDigest == null) {
            return null;
        }
        byte[] bArrDigest = messageDigest.digest();
        if (bArrDigest != null && bArrDigest.length > 0) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArrDigest.length << 1];
            int i2 = 0;
            for (byte b8 : bArrDigest) {
                int i8 = i2 + 1;
                cArr2[i2] = cArr[(b8 >>> 4) & 15];
                i2 += 2;
                cArr2[i8] = cArr[b8 & 15];
            }
            return new String(cArr2);
        }
        return "";
    }

    public static String a(String str) {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i8 = 0;
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    if (i8 <= 256) {
                        linkedList.add(line);
                        sb.append(line);
                        sb.append('\n');
                    } else {
                        linkedList2.add(line);
                        if (linkedList2.size() > 256) {
                            linkedList2.poll();
                            i2++;
                        }
                    }
                    i8++;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    com.apm.insight.a.a((Closeable) bufferedReader);
                }
            }
            com.apm.insight.a.a((Closeable) bufferedReader2);
        } catch (Throwable unused2) {
        }
        if (!linkedList2.isEmpty()) {
            if (i2 != 0) {
                sb.append("\t... skip ");
                sb.append(i2);
                sb.append(" lines\n");
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    private static void b(Throwable th, int i2) {
        th.getClass();
        String localizedMessage = th.getLocalizedMessage();
        try {
            NativeImpl.a(i2, th.getClass().getName());
            if (localizedMessage != null) {
                NativeImpl.a(i2, ": ");
                NativeImpl.a(i2, localizedMessage);
            }
            NativeImpl.a(i2, "\n");
        } catch (Throwable unused) {
        }
    }

    private static void a(StackTraceElement stackTraceElement, int i2) {
        try {
            NativeImpl.a(i2, "\tat ");
            NativeImpl.a(i2, stackTraceElement.getClassName());
            NativeImpl.a(i2, ".");
            NativeImpl.a(i2, stackTraceElement.getMethodName());
            if (stackTraceElement.isNativeMethod()) {
                NativeImpl.a(i2, "(Native Method)");
            } else if (stackTraceElement.getFileName() != null) {
                if (stackTraceElement.getLineNumber() >= 0) {
                    NativeImpl.a(i2, "(");
                    NativeImpl.a(i2, stackTraceElement.getFileName());
                    NativeImpl.a(i2, ":");
                    NativeImpl.a(i2, String.valueOf(stackTraceElement.getLineNumber()));
                    NativeImpl.a(i2, ")");
                } else {
                    NativeImpl.a(i2, "(");
                    NativeImpl.a(i2, stackTraceElement.getFileName());
                    NativeImpl.a(i2, ")");
                }
            } else if (stackTraceElement.getLineNumber() >= 0) {
                NativeImpl.a(i2, "(Unknown Source:");
                NativeImpl.a(i2, String.valueOf(stackTraceElement.getLineNumber()));
                NativeImpl.a(i2, ")");
            } else {
                NativeImpl.a(i2, "(Unknown Source)");
            }
            NativeImpl.a(i2, "\n");
        } catch (Throwable unused) {
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list) {
        if (th == null) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        list.add(f4545a);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z2 = stackTrace.length > 384;
        int length = stackTrace.length;
        int i2 = 0;
        int i8 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z2 && i8 > 256) {
                list.add(f4545a);
                break;
            } else {
                list.add(stackTraceElement);
                i8++;
                i2++;
            }
        }
        if (z2) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            a(th2, list, "\t", setNewSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, list, "", setNewSetFromMap, 128);
        }
    }

    private static void a(Throwable th, List<StackTraceElement> list, String str, Set<Throwable> set, int i2) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i8 = 0;
            boolean z2 = stackTrace.length > i2;
            list.add(f4545a);
            int length = stackTrace.length;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i9 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i9];
                if (z2 && i10 > i2) {
                    list.add(f4545a);
                    break;
                } else {
                    list.add(stackTraceElement);
                    i10++;
                    i9++;
                }
            }
            if (z2) {
                for (int length2 = stackTrace.length - (i2 / 2); length2 < stackTrace.length; length2++) {
                    list.add(stackTrace[length2]);
                }
            }
            Throwable[] suppressed = th.getSuppressed();
            int length3 = suppressed.length;
            while (true) {
                int i11 = 10;
                if (i8 >= length3) {
                    break;
                }
                Throwable th2 = suppressed[i8];
                String strC = a1.a.C(str, "\t");
                int i12 = i2 / 2;
                if (i12 > 10) {
                    i11 = i12;
                }
                a(th2, list, strC, set, i11);
                i8++;
            }
            th = th.getCause();
            if (th == null) {
                return;
            }
            i2 /= 2;
            if (i2 <= 10) {
                i2 = 10;
            }
        }
        list.add(f4545a);
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        printWriter.println(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z2 = stackTrace.length > 384;
        int length = stackTrace.length;
        int i2 = 0;
        int i8 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z2 && i8 > 256) {
                StringBuilder sb = new StringBuilder("\t... skip ");
                sb.append((stackTrace.length - i8) - 128);
                sb.append(" lines");
                printWriter.println(sb.toString());
                break;
            }
            printWriter.println("\tat ".concat(String.valueOf(stackTraceElement)));
            i8++;
            i2++;
        }
        if (z2) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            a(th2, printWriter, "Suppressed: ", "\t", setNewSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, printWriter, "Caused by: ", "", setNewSetFromMap, 128);
        }
    }

    private static void a(Throwable th, int i2, String str, String str2) {
        while (true) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            try {
                NativeImpl.a(i2, str2);
                NativeImpl.a(i2, str);
            } catch (Throwable unused) {
            }
            b(th, i2);
            for (StackTraceElement stackTraceElement : stackTrace) {
                a(stackTraceElement, i2);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i2, "Suppressed: ", a1.a.C(str2, "\t"));
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
    }

    private static void a(Throwable th, PrintWriter printWriter, String str, String str2, Set<Throwable> set, int i2) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            boolean z2 = stackTrace.length > i2;
            printWriter.println(str2 + str + th);
            int length = stackTrace.length;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i8];
                if (z2 && i9 > i2) {
                    printWriter.println("\t... skip " + ((stackTrace.length - i9) - (i2 / 2)) + " lines");
                    break;
                }
                printWriter.println("\tat ".concat(String.valueOf(stackTraceElement)));
                i9++;
                i8++;
            }
            if (z2) {
                for (int length2 = stackTrace.length - (i2 / 2); length2 < stackTrace.length; length2++) {
                    printWriter.println("\tat " + stackTrace[length2]);
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                int i10 = i2 / 2;
                a(th2, printWriter, "Suppressed: ", a1.a.C(str2, "\t"), set, i10 > 10 ? i10 : 10);
            }
            PrintWriter printWriter2 = printWriter;
            Set<Throwable> set2 = set;
            th = th.getCause();
            if (th == null) {
                return;
            }
            i2 /= 2;
            if (i2 <= 10) {
                i2 = 10;
            }
            str = "Caused by: ";
            printWriter = printWriter2;
            set = set2;
        }
        printWriter.println("\t[CIRCULAR REFERENCE:" + th + C2300e4.i.e);
    }

    private static boolean a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static JSONArray a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
            if (aVar.f4546a == -1) {
                if (a(stackTraceElementArr[i2].getClassName(), strArr)) {
                    aVar.f4546a = i2;
                    aVar.f4547b = i2;
                }
            } else if (!a(stackTraceElementArr[i2].getClassName(), strArr)) {
                aVar.f4547b = i2;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f4546a != -1) {
            aVar.f4547b = stackTraceElementArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static JSONArray a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (aVar.f4546a == -1) {
                if (a(strArr[i2], strArr2)) {
                    aVar.f4546a = i2;
                    aVar.f4547b = i2;
                }
            } else if (!a(strArr[i2], strArr2)) {
                aVar.f4547b = i2;
                jSONArray.put(aVar.a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f4546a != -1) {
            aVar.f4547b = strArr.length;
            jSONArray.put(aVar.a());
        }
        return jSONArray;
    }

    public static void a(@NonNull Throwable th, int i2) {
        if (th == null || i2 <= 0) {
            return;
        }
        try {
            b(th, i2);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                a(stackTraceElement, i2);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, i2, "Suppressed: ", "\t");
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, i2, "Caused by: ", "");
            }
        } catch (Throwable unused) {
        }
    }
}
