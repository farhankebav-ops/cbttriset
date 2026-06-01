package com.bytedance.adsdk.MY;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import androidx.camera.core.processing.util.a;
import com.bytedance.adsdk.MY.Cc.kBB;
import com.google.mlkit.common.sdkinternal.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW {
    private static final Map<String, hp<Bc>> IlO = new HashMap();
    private static final Set<Object> MY = new HashSet();
    private static final byte[] EO = {80, 75, 3, 4};

    public static rp<Bc> EO(Context context, String str) {
        return EO(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static hp<Bc> MY(Context context, String str) {
        return MY(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static rp<Bc> EO(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return MY(context.getAssets().open(str), str2);
            }
            return IlO(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new rp<>((Throwable) e);
        }
    }

    public static hp<Bc> IlO(Context context, String str) {
        return IlO(context, str, "url_".concat(String.valueOf(str)));
    }

    public static hp<Bc> MY(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return IlO(str2, new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.lEW.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public rp<Bc> call() throws Exception {
                return lEW.EO(applicationContext, str, str2);
            }
        });
    }

    public static hp<Bc> IlO(final Context context, final String str, final String str2) {
        return IlO(str2, new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.lEW.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public rp<Bc> call() throws Exception {
                rp<Bc> rpVarIlO = Cc.IlO(context).IlO(context, str, str2);
                if (str2 != null && rpVarIlO.IlO() != null) {
                    com.bytedance.adsdk.MY.EO.Cc.IlO().IlO(str2, rpVarIlO.IlO());
                }
                return rpVarIlO;
            }
        });
    }

    public static hp<Bc> IlO(Context context, int i2) {
        return IlO(context, i2, EO(context, i2));
    }

    public static rp<Bc> MY(Context context, int i2) {
        return MY(context, i2, EO(context, i2));
    }

    public static hp<Bc> IlO(Context context, final int i2, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return IlO(str, new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.lEW.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public rp<Bc> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return lEW.MY(context2, i2, str);
            }
        });
    }

    public static rp<Bc> MY(Context context, int i2, String str) {
        try {
            return MY(context.getResources().openRawResource(i2), EO(context, i2));
        } catch (Resources.NotFoundException e) {
            return new rp<>((Throwable) e);
        }
    }

    private static String EO(Context context, int i2) {
        return a.m(new StringBuilder("rawRes"), IlO(context) ? "_night_" : "_day_", i2);
    }

    public static rp<Bc> MY(InputStream inputStream, String str) {
        return IlO(inputStream, str, true);
    }

    private static boolean IlO(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static rp<Bc> MY(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            Bc bcIlO = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase(Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME)) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    bcIlO = IlO(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).IlO();
                } else if (!name.endsWith(".png") && !name.endsWith(".webp") && !name.endsWith(".jpg") && !name.endsWith(".jpeg")) {
                    if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                        zipInputStream.closeEntry();
                    } else if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split("/");
                        String str2 = strArrSplit[strArrSplit.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        new FileOutputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Throwable unused) {
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i2 = zipInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i2);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                file.getAbsolutePath();
                            }
                            map2.put(str3, typefaceCreateFromFile);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    }
                } else if (name.contains("../")) {
                    zipInputStream.closeEntry();
                    nextEntry = zipInputStream.getNextEntry();
                } else {
                    String[] strArrSplit2 = name.split("/");
                    map.put(strArrSplit2[strArrSplit2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (bcIlO == null) {
                return new rp<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                NV nvIlO = IlO(bcIlO, (String) entry.getKey());
                if (nvIlO != null) {
                    nvIlO.IlO(com.bytedance.adsdk.MY.vCE.vCE.IlO((Bitmap) entry.getValue(), nvIlO.IlO(), nvIlO.MY()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z2 = false;
                for (com.bytedance.adsdk.MY.EO.EO eo : bcIlO.ea().values()) {
                    if (eo.IlO().equals(entry2.getKey())) {
                        eo.IlO((Typeface) entry2.getValue());
                        z2 = true;
                    }
                }
                if (!z2) {
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, NV>> it = bcIlO.zPa().entrySet().iterator();
                while (it.hasNext()) {
                    NV value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strDmF = value.DmF();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strDmF.startsWith("data:") && strDmF.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strDmF.substring(strDmF.indexOf(44) + 1), 0);
                            value.IlO(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException unused2) {
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, NV> entry3 : bcIlO.zPa().entrySet()) {
                if (entry3.getValue().EV() == null) {
                    return new rp<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().DmF()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.MY.EO.Cc.IlO().IlO(str, bcIlO);
            }
            return new rp<>(bcIlO);
        } catch (IOException e) {
            return new rp<>((Throwable) e);
        }
    }

    public static hp<Bc> IlO(final InputStream inputStream, final String str) {
        return IlO(str, new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.lEW.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public rp<Bc> call() throws Exception {
                return lEW.MY(inputStream, str);
            }
        });
    }

    private static rp<Bc> IlO(InputStream inputStream, String str, boolean z2) {
        try {
            return IlO(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z2) {
                com.bytedance.adsdk.MY.vCE.vCE.IlO(inputStream);
            }
        }
    }

    public static rp<Bc> IlO(JsonReader jsonReader, String str) {
        return IlO(jsonReader, str, true);
    }

    private static rp<Bc> IlO(JsonReader jsonReader, String str, boolean z2) {
        try {
            try {
                Bc bcIlO = kBB.IlO(jsonReader);
                com.bytedance.adsdk.MY.EO.Cc.IlO().IlO(str, bcIlO);
                rp<Bc> rpVar = new rp<>(bcIlO);
                if (z2) {
                    IlO(jsonReader);
                }
                return rpVar;
            } catch (Exception e) {
                rp<Bc> rpVar2 = new rp<>(e);
                if (z2) {
                    IlO(jsonReader);
                }
                return rpVar2;
            }
        } catch (Throwable th) {
            if (z2) {
                IlO(jsonReader);
            }
            throw th;
        }
    }

    public static void IlO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static rp<Bc> IlO(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return MY(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.MY.vCE.vCE.IlO(zipInputStream);
        }
    }

    private static NV IlO(Bc bc, String str) {
        for (NV nv : bc.zPa().values()) {
            if (nv.DmF().equals(str)) {
                return nv;
            }
        }
        return null;
    }

    private static hp<Bc> IlO(final String str, Callable<rp<Bc>> callable) {
        final Bc bcIlO = str == null ? null : com.bytedance.adsdk.MY.EO.Cc.IlO().IlO(str);
        if (bcIlO != null) {
            return new hp<>(new Callable<rp<Bc>>() { // from class: com.bytedance.adsdk.MY.lEW.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
                public rp<Bc> call() throws Exception {
                    return new rp<>(bcIlO);
                }
            });
        }
        if (str != null) {
            Map<String, hp<Bc>> map = IlO;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        hp<Bc> hpVar = new hp<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            hpVar.IlO(new EV<Bc>() { // from class: com.bytedance.adsdk.MY.lEW.2
                @Override // com.bytedance.adsdk.MY.EV
                public void IlO(Bc bc) {
                    lEW.IlO.remove(str);
                    atomicBoolean.set(true);
                    if (lEW.IlO.size() == 0) {
                        lEW.MY(true);
                    }
                }
            });
            hpVar.EO(new EV<Throwable>() { // from class: com.bytedance.adsdk.MY.lEW.3
                @Override // com.bytedance.adsdk.MY.EV
                public void IlO(Throwable th) {
                    lEW.IlO.remove(str);
                    atomicBoolean.set(true);
                    if (lEW.IlO.size() == 0) {
                        lEW.MY(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, hp<Bc>> map2 = IlO;
                map2.put(str, hpVar);
                if (map2.size() == 1) {
                    MY(false);
                }
            }
        }
        return hpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(boolean z2) {
        ArrayList arrayList = new ArrayList(MY);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2);
        }
    }
}
