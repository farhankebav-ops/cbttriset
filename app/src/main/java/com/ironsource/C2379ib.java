package com.ironsource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.ironsource.ib, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2379ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8729b;

    public C2379ib(String str, int i2) {
        this.f8728a = str;
        this.f8729b = i2;
    }

    private final String b() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        kotlin.jvm.internal.k.d(stackTrace, "stackTrace");
        return String.format("%s %s", Arrays.copyOf(new Object[]{a(stackTrace, 4), b(stackTrace, 4)}, 2));
    }

    public final int a() {
        return this.f8729b;
    }

    public final String c() {
        String str = this.f8728a;
        return (str == null || str.length() == 0) ? b() : a1.a.D(b(), " - ", this.f8728a);
    }

    private final String a(StackTraceElement[] stackTraceElementArr, int i2) {
        List listJ0;
        List listK1;
        List listJ02;
        if (stackTraceElementArr.length <= i2) {
            return "";
        }
        String className = stackTraceElementArr[i2].getClassName();
        kotlin.jvm.internal.k.d(className, "stackTrace[depth]\n              .className");
        Pattern patternCompile = Pattern.compile("\\.");
        kotlin.jvm.internal.k.d(patternCompile, "compile(...)");
        n6.m.H0(0);
        Matcher matcher = patternCompile.matcher(className);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList.add(className.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList.add(className.subSequence(iEnd, className.length()).toString());
            listJ0 = arrayList;
        } else {
            listJ0 = r2.q.j0(className.toString());
        }
        boolean zIsEmpty = listJ0.isEmpty();
        List listK12 = r5.r.f13638a;
        if (zIsEmpty) {
            listK1 = listK12;
        } else {
            ListIterator listIterator = listJ0.listIterator(listJ0.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listK1 = r5.l.k1(listIterator.nextIndex() + 1, listJ0);
                    break;
                }
            }
            listK1 = listK12;
        }
        String str = ((String[]) listK1.toArray(new String[0]))[r7.length - 1];
        if (!n6.m.q0(str, "$", false)) {
            return str;
        }
        Pattern patternCompile2 = Pattern.compile("\\$");
        kotlin.jvm.internal.k.d(patternCompile2, "compile(...)");
        n6.m.H0(0);
        Matcher matcher2 = patternCompile2.matcher(str);
        if (matcher2.find()) {
            ArrayList arrayList2 = new ArrayList(10);
            int iEnd2 = 0;
            do {
                arrayList2.add(str.subSequence(iEnd2, matcher2.start()).toString());
                iEnd2 = matcher2.end();
            } while (matcher2.find());
            arrayList2.add(str.subSequence(iEnd2, str.length()).toString());
            listJ02 = arrayList2;
        } else {
            listJ02 = r2.q.j0(str.toString());
        }
        if (!listJ02.isEmpty()) {
            ListIterator listIterator2 = listJ02.listIterator(listJ02.size());
            while (true) {
                if (!listIterator2.hasPrevious()) {
                    break;
                }
                if (((String) listIterator2.previous()).length() != 0) {
                    listK12 = r5.l.k1(listIterator2.nextIndex() + 1, listJ02);
                    break;
                }
            }
        }
        return ((String[]) listK12.toArray(new String[0]))[0];
    }

    private final String b(StackTraceElement[] stackTraceElementArr, int i2) {
        List listJ0;
        List listK1;
        int i8;
        List listJ02;
        List listJ03;
        if (stackTraceElementArr.length > i2) {
            String className = stackTraceElementArr[i2].getClassName();
            kotlin.jvm.internal.k.d(className, "stackTrace[depth]\n              .className");
            Pattern patternCompile = Pattern.compile("\\.");
            kotlin.jvm.internal.k.d(patternCompile, "compile(...)");
            n6.m.H0(0);
            Matcher matcher = patternCompile.matcher(className);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(className.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(className.subSequence(iEnd, className.length()).toString());
                listJ0 = arrayList;
            } else {
                listJ0 = r2.q.j0(className.toString());
            }
            boolean zIsEmpty = listJ0.isEmpty();
            List listK12 = r5.r.f13638a;
            if (zIsEmpty) {
                listK1 = listK12;
            } else {
                ListIterator listIterator = listJ0.listIterator(listJ0.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listK1 = r5.l.k1(listIterator.nextIndex() + 1, listJ0);
                        break;
                    }
                }
                listK1 = listK12;
            }
            String[] strArr = (String[]) listK1.toArray(new String[0]);
            String str = strArr[strArr.length - 1];
            if (n6.m.q0(str, "$", false)) {
                Pattern patternCompile2 = Pattern.compile("\\$");
                kotlin.jvm.internal.k.d(patternCompile2, "compile(...)");
                n6.m.H0(0);
                Matcher matcher2 = patternCompile2.matcher(str);
                if (matcher2.find()) {
                    ArrayList arrayList2 = new ArrayList(10);
                    int iEnd2 = 0;
                    do {
                        arrayList2.add(str.subSequence(iEnd2, matcher2.start()).toString());
                        iEnd2 = matcher2.end();
                    } while (matcher2.find());
                    arrayList2.add(str.subSequence(iEnd2, str.length()).toString());
                    listJ03 = arrayList2;
                } else {
                    listJ03 = r2.q.j0(str.toString());
                }
                if (!listJ03.isEmpty()) {
                    ListIterator listIterator2 = listJ03.listIterator(listJ03.size());
                    while (true) {
                        if (!listIterator2.hasPrevious()) {
                            break;
                        }
                        if (((String) listIterator2.previous()).length() != 0) {
                            listK12 = r5.l.k1(listIterator2.nextIndex() + 1, listJ03);
                            break;
                        }
                    }
                }
                return a1.a.D(((String[]) listK12.toArray(new String[0]))[1], ".", stackTraceElementArr[i2].getMethodName());
            }
            String methodName = stackTraceElementArr[i2].getMethodName();
            kotlin.jvm.internal.k.d(methodName, "stackTrace[depth].methodName");
            if (n6.m.q0(methodName, "$", false) && stackTraceElementArr.length > (i8 = i2 + 1)) {
                String className2 = stackTraceElementArr[i8].getClassName();
                kotlin.jvm.internal.k.d(className2, "stackTrace[depth + 1]\n                .className");
                Pattern patternCompile3 = Pattern.compile("\\$");
                kotlin.jvm.internal.k.d(patternCompile3, "compile(...)");
                n6.m.H0(0);
                Matcher matcher3 = patternCompile3.matcher(className2);
                if (matcher3.find()) {
                    ArrayList arrayList3 = new ArrayList(10);
                    int iEnd3 = 0;
                    do {
                        arrayList3.add(className2.subSequence(iEnd3, matcher3.start()).toString());
                        iEnd3 = matcher3.end();
                    } while (matcher3.find());
                    arrayList3.add(className2.subSequence(iEnd3, className2.length()).toString());
                    listJ02 = arrayList3;
                } else {
                    listJ02 = r2.q.j0(className2.toString());
                }
                if (!listJ02.isEmpty()) {
                    ListIterator listIterator3 = listJ02.listIterator(listJ02.size());
                    while (true) {
                        if (!listIterator3.hasPrevious()) {
                            break;
                        }
                        if (((String) listIterator3.previous()).length() != 0) {
                            listK12 = r5.l.k1(listIterator3.nextIndex() + 1, listJ02);
                            break;
                        }
                    }
                }
                String[] strArr2 = (String[]) listK12.toArray(new String[0]);
                if (strArr2.length > 1) {
                    return a1.a.D(strArr2[1], ".", stackTraceElementArr[i8].getMethodName());
                }
                String methodName2 = stackTraceElementArr[i8].getMethodName();
                kotlin.jvm.internal.k.d(methodName2, "{\n              stackTra….methodName\n            }");
                return methodName2;
            }
            String methodName3 = stackTraceElementArr[i2].getMethodName();
            kotlin.jvm.internal.k.d(methodName3, "stackTrace[depth].methodName");
            return methodName3;
        }
        return "";
    }
}
