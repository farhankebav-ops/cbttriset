package com.bytedance.sdk.component.Cc.tV.EO.IlO.IlO;

import a1.a;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.component.utils.NV;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private int IlO;
    private File MY;

    private IlO(int i2, File file) {
        this.IlO = i2;
        this.MY = file;
    }

    private void EO(File file) {
        if (file == null) {
            return;
        }
        try {
            Bc.MY(file);
        } catch (Throwable unused) {
        }
    }

    public static IlO IlO(int i2, File file) {
        try {
            IlO ilO = new IlO(i2, file);
            if (file != null) {
                file.mkdirs();
            }
            return ilO;
        } catch (Throwable unused) {
            return null;
        }
    }

    private List<File> MY(File file) {
        List<File> listIlO = IlO(file);
        if (listIlO == null || listIlO.isEmpty()) {
            return null;
        }
        final HashMap map = new HashMap();
        for (File file2 : listIlO) {
            map.put(file2, Long.valueOf(file2.lastModified()));
        }
        Collections.sort(listIlO, new Comparator<File>() { // from class: com.bytedance.sdk.component.Cc.tV.EO.IlO.IlO.IlO.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public int compare(File file3, File file4) {
                if (file3 == null && file4 == null) {
                    return 0;
                }
                if (file3 == null) {
                    return 1;
                }
                if (file4 == null) {
                    return -1;
                }
                return Long.compare(((Long) map.get(file4)).longValue(), ((Long) map.get(file3)).longValue());
            }
        });
        return listIlO;
    }

    private static void tV(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private File EO(String str) {
        return new File(this.MY, a.C(str, ".temp"));
    }

    public synchronized InputStream IlO(String str) {
        FileInputStream fileInputStream;
        if (this.IlO <= 0) {
            return null;
        }
        File fileMY = MY(str);
        try {
            try {
                fileInputStream = new FileInputStream(fileMY);
                try {
                    EO(fileMY);
                    return fileInputStream;
                } catch (FileNotFoundException unused) {
                    NV.IlO(fileInputStream);
                    return null;
                }
            } catch (FileNotFoundException unused2) {
                fileInputStream = null;
            }
        } catch (Throwable unused3) {
            return null;
        }
    }

    private File MY(String str) {
        return new File(this.MY, str);
    }

    public synchronized boolean IlO(String str, byte[] bArr) {
        if (this.IlO > 0 && str != null && bArr != null) {
            File fileEO = EO(str);
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileEO);
                try {
                    fileOutputStream2.write(bArr);
                    if (fileEO.exists()) {
                        IlO(fileEO, MY(str), true);
                    }
                    NV.IlO(fileOutputStream2);
                    List<File> listIlO = IlO(this.MY);
                    if (listIlO != null) {
                        int size = listIlO.size();
                        int i2 = this.IlO;
                        if (size > i2) {
                            IlO((int) (((double) i2) * 0.7d));
                        }
                    }
                    return true;
                } catch (FileNotFoundException unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        File file = this.MY;
                        if (file != null) {
                            file.mkdirs();
                        }
                        NV.IlO(fileOutputStream);
                        List<File> listIlO2 = IlO(this.MY);
                        if (listIlO2 != null) {
                            int size2 = listIlO2.size();
                            int i8 = this.IlO;
                            if (size2 > i8) {
                                IlO((int) (((double) i8) * 0.7d));
                            }
                        }
                        return false;
                    } finally {
                        NV.IlO(fileOutputStream);
                        List<File> listIlO3 = IlO(this.MY);
                        if (listIlO3 != null) {
                            int size3 = listIlO3.size();
                            int i9 = this.IlO;
                            if (size3 > i9) {
                                IlO((int) (((double) i9) * 0.7d));
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    fileOutputStream = fileOutputStream2;
                    return false;
                }
            } catch (FileNotFoundException unused3) {
            } catch (Throwable unused4) {
            }
        }
        return false;
    }

    private List<File> IlO(File file) {
        File[] fileArrListFiles;
        if (file != null) {
            try {
                if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                    List<File> listAsList = Arrays.asList(fileArrListFiles);
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listAsList) {
                        if (file2 != null && file2.isFile() && !TextUtils.isEmpty(file2.getName()) && !file2.getName().endsWith(".temp")) {
                            arrayList.add(file2);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public synchronized void IlO(int i2) {
        try {
            if (i2 > this.IlO) {
                return;
            }
            List<File> listMY = MY(this.MY);
            if (listMY != null && listMY.size() > i2) {
                while (i2 < listMY.size()) {
                    File file = listMY.get(i2);
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    i2++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void IlO(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            tV(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }
}
