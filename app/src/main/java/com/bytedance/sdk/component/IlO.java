package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    protected static InterfaceC0046IlO IlO = null;
    private static boolean MY = false;
    private static ArrayMap<File, IlO> hp;

    @GuardedBy("TTPropHelper.class")
    private static ArrayMap<String, File> rp;

    @GuardedBy("mLoadLock")
    private int Bc;

    @GuardedBy("mLoadLock")
    private Properties Cc;

    @GuardedBy("mWriteLock")
    private long DmF;
    private final Object EO;
    private final File EV;
    private final File NV;

    @GuardedBy("this")
    private long lEW;
    private final Object tV;
    private volatile boolean vCE;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface InterfaceC0046IlO {
        ExecutorService getExecutorService();

        HandlerThread getSafeHandlerThread(String str, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        boolean Cc;
        final CountDownLatch EO;
        final long IlO;
        final Properties MY;

        @GuardedBy("mWritingToDiskLock")
        volatile boolean tV;

        public void IlO(boolean z2, boolean z7) {
            this.Cc = z2;
            this.tV = z7;
            this.EO.countDown();
        }

        private MY(long j, Properties properties) {
            this.EO = new CountDownLatch(1);
            this.tV = false;
            this.Cc = false;
            this.IlO = j;
            this.MY = properties;
        }
    }

    private IlO(File file) {
        Object obj = new Object();
        this.EO = obj;
        this.tV = new Object();
        this.Cc = new Properties();
        this.vCE = false;
        this.Bc = 0;
        this.NV = file;
        this.EV = IlO(file);
        synchronized (obj) {
            this.vCE = false;
        }
        InterfaceC0046IlO interfaceC0046IlO = IlO;
        if (interfaceC0046IlO == null || interfaceC0046IlO.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.IlO.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    IlO.this.IlO();
                }
            }.start();
        } else {
            IlO.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.IlO.2
                @Override // java.lang.Runnable
                public void run() {
                    IlO.this.IlO();
                }
            });
        }
    }

    public static /* synthetic */ int Cc(IlO ilO) {
        int i2 = ilO.Bc;
        ilO.Bc = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int DmF(IlO ilO) {
        int i2 = ilO.Bc;
        ilO.Bc = i2 - 1;
        return i2;
    }

    public static /* synthetic */ long vCE(IlO ilO) {
        long j = ilO.lEW;
        ilO.lEW = 1 + j;
        return j;
    }

    private void tV() {
        while (!this.vCE) {
            try {
                this.EO.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public EO MY() {
        return new EO();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class EO implements SharedPreferences.Editor {
        private final Object MY = new Object();

        @GuardedBy("mEditorLock")
        private final Map<String, Object> EO = new HashMap();

        @GuardedBy("mEditorLock")
        private boolean tV = false;

        public EO() {
        }

        private MY MY() {
            Properties properties;
            long j;
            Object obj;
            boolean z2;
            synchronized (IlO.this.EO) {
                try {
                    if (IlO.this.Bc > 0) {
                        Properties properties2 = new Properties();
                        properties2.putAll(IlO.this.Cc);
                        IlO.this.Cc = properties2;
                    }
                    properties = IlO.this.Cc;
                    IlO.Cc(IlO.this);
                    synchronized (this.MY) {
                        try {
                            boolean z7 = false;
                            if (this.tV) {
                                if (properties.isEmpty()) {
                                    z2 = false;
                                } else {
                                    properties.clear();
                                    z2 = true;
                                }
                                this.tV = false;
                                z7 = z2;
                            }
                            for (Map.Entry<String, Object> entry : this.EO.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value == this || value == null) {
                                    if (properties.containsKey(key)) {
                                        properties.remove(key);
                                        z7 = true;
                                    }
                                } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                                    properties.put(key, String.valueOf(value));
                                    z7 = true;
                                }
                            }
                            this.EO.clear();
                            if (z7) {
                                IlO.vCE(IlO.this);
                            }
                            j = IlO.this.lEW;
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new MY(j, properties);
        }

        public EO IlO(String str, Set<String> set) {
            synchronized (this.MY) {
                this.EO.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            IlO.this.IlO(MY(), false);
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long jCurrentTimeMillis = IlO.MY ? System.currentTimeMillis() : 0L;
            MY MY = MY();
            IlO.this.IlO(MY, true);
            try {
                MY.EO.await();
                if (IlO.MY) {
                    Log.d("TTPropHelper", IlO.this.NV.getName() + ":" + MY.IlO + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                }
                return MY.tV;
            } catch (InterruptedException unused) {
                if (!IlO.MY) {
                    return false;
                }
                Log.d("TTPropHelper", IlO.this.NV.getName() + ":" + MY.IlO + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                return false;
            } catch (Throwable th) {
                if (IlO.MY) {
                    Log.d("TTPropHelper", IlO.this.NV.getName() + ":" + MY.IlO + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                }
                throw th;
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return IlO(str, (Set<String>) set);
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO putInt(String str, int i2) {
            synchronized (this.MY) {
                this.EO.put(str, Integer.valueOf(i2));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO putLong(String str, long j) {
            synchronized (this.MY) {
                this.EO.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO putFloat(String str, float f4) {
            synchronized (this.MY) {
                this.EO.put(str, Float.valueOf(f4));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO putString(String str, String str2) {
            synchronized (this.MY) {
                this.EO.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO putBoolean(String str, boolean z2) {
            synchronized (this.MY) {
                this.EO.put(str, Boolean.valueOf(z2));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO remove(String str) {
            synchronized (this.MY) {
                this.EO.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public EO clear() {
            synchronized (this.MY) {
                this.tV = true;
            }
            return this;
        }
    }

    public static void IlO(InterfaceC0046IlO interfaceC0046IlO) {
        IlO = interfaceC0046IlO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0122 A[Catch: all -> 0x0127, TryCatch #6 {all -> 0x0127, blocks: (B:39:0x0090, B:40:0x0092, B:78:0x011e, B:80:0x0122, B:84:0x012b, B:86:0x0134, B:88:0x013c, B:90:0x0148, B:98:0x0193, B:99:0x0194, B:59:0x00f0, B:77:0x011d, B:63:0x00f7, B:97:0x0192, B:96:0x0189), top: B:118:0x0090, inners: #3, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0134 A[Catch: all -> 0x0127, TryCatch #6 {all -> 0x0127, blocks: (B:39:0x0090, B:40:0x0092, B:78:0x011e, B:80:0x0122, B:84:0x012b, B:86:0x0134, B:88:0x013c, B:90:0x0148, B:98:0x0193, B:99:0x0194, B:59:0x00f0, B:77:0x011d, B:63:0x00f7, B:97:0x0192, B:96:0x0189), top: B:118:0x0090, inners: #3, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0148 A[Catch: all -> 0x0127, TRY_LEAVE, TryCatch #6 {all -> 0x0127, blocks: (B:39:0x0090, B:40:0x0092, B:78:0x011e, B:80:0x0122, B:84:0x012b, B:86:0x0134, B:88:0x013c, B:90:0x0148, B:98:0x0193, B:99:0x0194, B:59:0x00f0, B:77:0x011d, B:63:0x00f7, B:97:0x0192, B:96:0x0189), top: B:118:0x0090, inners: #3, #10 }] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.FileOutputStream] */
    @androidx.annotation.GuardedBy("mWriteLock")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void MY(com.bytedance.sdk.component.IlO.MY r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.IlO.MY(com.bytedance.sdk.component.IlO$MY, boolean):void");
    }

    @RequiresApi(api = 19)
    public static IlO IlO(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (IlO.class) {
            try {
                if (rp == null) {
                    rp = new ArrayMap<>();
                }
                File file = rp.get(str);
                if (file == null) {
                    file = new File(context.getFilesDir(), str);
                    rp.put(str, file);
                }
                if (hp == null) {
                    hp = new ArrayMap<>();
                }
                IlO ilO = hp.get(file);
                if (ilO != null) {
                    return ilO;
                }
                IlO ilO2 = new IlO(file);
                hp.put(file, ilO2);
                return ilO2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static File IlO(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO() {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.IlO.IlO():void");
    }

    public String IlO(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.EO) {
            tV();
            property = this.Cc.getProperty(str, str2);
        }
        return property;
    }

    public int IlO(String str, int i2) {
        int i8;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.EO) {
                try {
                    try {
                        tV();
                        i8 = Integer.parseInt(this.Cc.getProperty(str, String.valueOf(i2)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i8;
        }
        return i2;
    }

    public long IlO(String str, long j) {
        long j3;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.EO) {
                try {
                    try {
                        tV();
                        j3 = Long.parseLong(this.Cc.getProperty(str, String.valueOf(j)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return j3;
        }
        return j;
    }

    public float IlO(String str, float f4) {
        float f8;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.EO) {
                try {
                    try {
                        tV();
                        f8 = Float.parseFloat(this.Cc.getProperty(str, String.valueOf(f4)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return f8;
        }
        return f4;
    }

    public boolean IlO(String str, boolean z2) {
        boolean z7;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.EO) {
                try {
                    try {
                        tV();
                        z7 = Boolean.parseBoolean(this.Cc.getProperty(str, String.valueOf(z2)));
                    } catch (NumberFormatException e) {
                        Log.e("TTPropHelper", e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z7;
        }
        return z2;
    }

    public boolean IlO(String str) {
        boolean zContainsKey;
        synchronized (this.EO) {
            try {
                try {
                    tV();
                    zContainsKey = this.Cc.containsKey(str);
                } catch (NumberFormatException e) {
                    Log.e("TTPropHelper", e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zContainsKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(final MY my, final boolean z2) {
        boolean z7;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.IlO.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (IlO.this.tV) {
                    try {
                        IlO.this.MY(my, z2);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (IlO.this.EO) {
                    IlO.DmF(IlO.this);
                }
            }
        };
        if (z2) {
            synchronized (this.EO) {
                z7 = this.Bc == 1;
            }
            if (z7) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.MY.IlO(runnable, true ^ z2);
    }
}
