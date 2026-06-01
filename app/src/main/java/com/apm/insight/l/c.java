package com.apm.insight.l;

import android.os.Debug;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f4518a = new b(0);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {
        private a() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends a {
        private b() {
            super((byte) 0);
        }

        @Override // com.apm.insight.l.c.a
        public final int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }

        public /* synthetic */ b(byte b8) {
            this();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return f4518a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return f4518a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return f4518a.c(memoryInfo);
    }

    /* JADX INFO: renamed from: com.apm.insight.l.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        public static Long a(Map<? super String, Long> map, String str, Long l) {
            if (str == null || map == null) {
                return -1L;
            }
            Long l8 = map.get(str);
            if (l8 != null) {
                l = Long.valueOf(l.longValue() + l8.longValue());
            }
            map.put(str, l);
            return l;
        }

        public static Float a(Map<? super String, Float> map) {
            float fFloatValue = 0.0f;
            for (Float f4 : map.values()) {
                if (f4 != null) {
                    fFloatValue = f4.floatValue() + fFloatValue;
                }
            }
            return Float.valueOf(fFloatValue);
        }

        public static int a(Object obj, int i2) {
            if (obj != null) {
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                if (obj instanceof String) {
                    try {
                        return Integer.parseInt(String.valueOf(obj));
                    } catch (Throwable unused) {
                    }
                }
            }
            return i2;
        }
    }
}
