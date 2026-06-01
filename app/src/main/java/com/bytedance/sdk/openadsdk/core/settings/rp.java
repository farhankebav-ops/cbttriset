package com.bytedance.sdk.openadsdk.core.settings;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.vAh;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.Cc;
import com.bytedance.sdk.openadsdk.utils.mmj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class rp implements Cc {
    private final String Bc;
    private IlO NV;
    private final ConcurrentHashMap<String, Object> EO = new ConcurrentHashMap<>();
    private final Object tV = new Object();
    private final Object Cc = new Object();
    private final CountDownLatch vCE = new CountDownLatch(1);
    private Properties lEW = new Properties();
    private volatile boolean DmF = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface IlO {
        void IlO();

        void MY();
    }

    public rp(String str, IlO ilO) {
        this.Bc = str;
        this.NV = ilO;
        mmj.IlO(new com.bytedance.sdk.component.lEW.lEW("SetL_".concat(String.valueOf(str))) { // from class: com.bytedance.sdk.openadsdk.core.settings.rp.1
            @Override // java.lang.Runnable
            public void run() {
                rp.this.IlO(false);
            }
        });
    }

    private void Cc() {
        if (this.DmF) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.vCE.await(mmj.vCE() ? 4 : 8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            oeT.IlO("SdkSettings.Prop", "awaitLoadedLocked: ", e);
        }
    }

    private File vCE() {
        return new File(cl.IlO().getFilesDir(), this.Bc);
    }

    public void EO() {
        File fileVCE = vCE();
        if (fileVCE.exists()) {
            fileVCE.delete();
        }
    }

    public void tV() {
        IlO ilO = this.NV;
        if (ilO != null) {
            ilO.MY();
        }
    }

    public String IlO(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        Cc();
        return this.lEW.getProperty(str, str2);
    }

    public boolean MY() {
        return this.DmF;
    }

    public int IlO(String str, int i2) {
        if (str != null && !str.isEmpty()) {
            Cc();
            try {
                return Integer.parseInt(this.lEW.getProperty(str, String.valueOf(i2)));
            } catch (NumberFormatException e) {
                oeT.IlO("SdkSettings.Prop", "", e);
            }
        }
        return i2;
    }

    public long IlO(String str, long j) {
        if (str != null && !str.isEmpty()) {
            Cc();
            try {
                return Long.parseLong(this.lEW.getProperty(str, String.valueOf(j)));
            } catch (NumberFormatException e) {
                oeT.IlO("SdkSettings.Prop", "", e);
            }
        }
        return j;
    }

    public float IlO(String str, float f4) {
        if (str != null && !str.isEmpty()) {
            Cc();
            try {
                return Float.parseFloat(this.lEW.getProperty(str, String.valueOf(f4)));
            } catch (NumberFormatException e) {
                oeT.IlO("SdkSettings.Prop", "", e);
            }
        }
        return f4;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class MY implements Cc.IlO {
        private final Map<String, Object> MY = new HashMap();
        private final Object EO = new Object();

        public MY() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public void IlO() {
            Object obj;
            Properties properties = new Properties();
            synchronized (this.EO) {
                try {
                    properties.putAll(rp.this.lEW);
                    boolean z2 = false;
                    for (Map.Entry<String, Object> entry : this.MY.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != this && value != null) {
                            if (properties.containsKey(key) && (obj = properties.get(key)) != null && obj.equals(value)) {
                            }
                            properties.put(key, String.valueOf(value));
                            z2 = true;
                        } else if (properties.containsKey(key)) {
                            properties.remove(key);
                            z2 = true;
                        }
                    }
                    this.MY.clear();
                    if (z2) {
                        rp.this.IlO(properties);
                        rp.this.lEW = properties;
                        rp.this.EO.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public Cc.IlO IlO(String str, String str2) {
            synchronized (this.EO) {
                this.MY.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public Cc.IlO IlO(String str, int i2) {
            synchronized (this.EO) {
                this.MY.put(str, Integer.valueOf(i2));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public Cc.IlO IlO(String str, long j) {
            synchronized (this.EO) {
                this.MY.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public Cc.IlO IlO(String str) {
            synchronized (this.EO) {
                this.MY.put(str, this);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public Cc.IlO IlO(String str, float f4) {
            synchronized (this.EO) {
                this.MY.put(str, Float.valueOf(f4));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.Cc.IlO
        public Cc.IlO IlO(String str, boolean z2) {
            synchronized (this.EO) {
                this.MY.put(str, Boolean.valueOf(z2));
            }
            return this;
        }
    }

    public boolean IlO(String str, boolean z2) {
        if (str != null && !str.isEmpty()) {
            Cc();
            try {
                return Boolean.parseBoolean(this.lEW.getProperty(str, String.valueOf(z2)));
            } catch (Exception e) {
                oeT.IlO("SdkSettings.Prop", "", e);
            }
        }
        return z2;
    }

    public void IlO(boolean z2) {
        IlO ilO;
        synchronized (this.tV) {
            try {
                if (!this.DmF || z2) {
                    File fileVCE = vCE();
                    if (fileVCE.exists()) {
                        Properties properties = new Properties();
                        FileInputStream fileInputStream = null;
                        try {
                            try {
                                FileInputStream fileInputStream2 = new FileInputStream(fileVCE);
                                try {
                                    properties.load(fileInputStream2);
                                    properties.size();
                                    new StringBuilder("items from ").append(fileVCE.getAbsolutePath());
                                    if (!properties.isEmpty()) {
                                        this.lEW = properties;
                                        this.EO.clear();
                                    }
                                    com.bytedance.sdk.openadsdk.utils.hp.IlO(fileInputStream2);
                                } catch (OutOfMemoryError unused) {
                                    fileInputStream = fileInputStream2;
                                    try {
                                        com.bytedance.sdk.component.utils.Bc.EO(fileVCE);
                                    } catch (Throwable th) {
                                        oeT.IlO("SdkSettings.Prop", "delete: ", th);
                                    }
                                    if (fileInputStream != null) {
                                        com.bytedance.sdk.openadsdk.utils.hp.IlO(fileInputStream);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    oeT.IlO("SdkSettings.Prop", "reload: ", th);
                                    if (fileInputStream != null) {
                                        com.bytedance.sdk.openadsdk.utils.hp.IlO(fileInputStream);
                                    }
                                }
                            } catch (OutOfMemoryError unused2) {
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            this.tV.notifyAll();
                        } catch (Throwable th4) {
                            if (fileInputStream != null) {
                                com.bytedance.sdk.openadsdk.utils.hp.IlO(fileInputStream);
                            }
                            this.tV.notifyAll();
                            throw th4;
                        }
                    } else if (vAh.IlO(cl.IlO()) && "tt_sdk_settings.prop".equals(this.Bc)) {
                        try {
                            boolean z7 = false;
                            SharedPreferences sharedPreferences = cl.IlO().getSharedPreferences("tt_sdk_settings", 0);
                            if (!sharedPreferences.getAll().isEmpty()) {
                                Cc.IlO IlO2 = IlO();
                                for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                                    String key = entry.getKey();
                                    Object value = entry.getValue();
                                    if (key != null && !key.isEmpty() && value != null) {
                                        IlO2.IlO(key, value.toString());
                                        z7 = true;
                                    }
                                }
                                if (z7) {
                                    IlO2.IlO();
                                }
                                sharedPreferences.edit().clear().commit();
                            }
                        } catch (Exception unused3) {
                        }
                    }
                    if (!this.DmF && (ilO = this.NV) != null) {
                        ilO.IlO();
                    }
                    this.DmF = true;
                    this.vCE.countDown();
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public Cc.IlO IlO() {
        return new MY();
    }

    public <T> T IlO(String str, T t3, Cc.MY<T> my) {
        T tMY;
        if (str != null && !str.isEmpty()) {
            if (this.EO.containsKey(str)) {
                try {
                    return (T) this.EO.get(str);
                } catch (Exception e) {
                    oeT.IlO("SdkSettings.Prop", "", e);
                    return t3;
                }
            }
            Cc();
            String property = this.lEW.getProperty(str, null);
            if (property != null && my != null && (tMY = my.MY(property)) != null) {
                this.EO.put(str, tMY);
                return tMY;
            }
        }
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(Properties properties) {
        synchronized (this.Cc) {
            File fileVCE = vCE();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileVCE);
                    try {
                        properties.store(fileOutputStream2, (String) null);
                        fileVCE.getAbsolutePath();
                        com.bytedance.sdk.openadsdk.utils.hp.IlO(fileOutputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        oeT.IlO("SdkSettings.Prop", "saveToLocal: ", e);
                        if (fileOutputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.hp.IlO(fileOutputStream);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.hp.IlO(fileOutputStream);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        hp.NST();
    }
}
