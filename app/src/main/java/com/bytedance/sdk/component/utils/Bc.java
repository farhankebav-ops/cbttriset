package com.bytedance.sdk.component.utils;

import a1.a;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.Bc$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File file, File file2) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class IlO implements Comparator<File> {
        private IlO() {
        }

        private int IlO(long j, long j3) {
            if (j < j3) {
                return -1;
            }
            return j == j3 ? 0 : 1;
        }

        public /* synthetic */ IlO(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return IlO(file.lastModified(), file2.lastModified());
        }
    }

    private static void Cc(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long length = file.length();
        if (length == 0) {
            vCE(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            try {
                randomAccessFile.seek(j);
                byte b8 = randomAccessFile.readByte();
                randomAccessFile.seek(j);
                randomAccessFile.write(b8);
                randomAccessFile.close();
            } catch (Throwable unused) {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
    }

    public static void EO(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        EO(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    public static File IlO(Context context, boolean z2, String str, String str2) {
        String strMY = MY(context);
        if (z2) {
            str = IlO(context) + "-" + str;
        }
        if (strMY != null) {
            String str3 = File.separator;
            if (!strMY.endsWith(str3)) {
                strMY = a.C(strMY, str3);
            }
        }
        String strC = a.C(strMY, str);
        File file = new File(strC);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(strC, str2);
    }

    private static String MY(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static byte[] tV(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                long length = file.length();
                Long lValueOf = Long.valueOf(length);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[lValueOf.intValue()];
                    if (fileInputStream.read(bArr) == length) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                    }
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    private static void vCE(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    public static void MY(File file) throws IOException {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            Cc(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                new Date(file.lastModified()).toString();
                file.getAbsolutePath();
            }
        }
    }

    public static File IlO(Context context, boolean z2, String str) {
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (z2) {
            str = IlO(context) + "-" + str;
        }
        if (absolutePath != null) {
            String str2 = File.separator;
            if (!absolutePath.endsWith(str2)) {
                absolutePath = a.C(absolutePath, str2);
            }
        }
        File file = new File(a.C(absolutePath, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static List<File> IlO(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new IlO(null));
        return listAsList;
    }

    public static String IlO(Context context) {
        String strIlO = kBB.IlO(context);
        return (TextUtils.isEmpty(strIlO) || !strIlO.contains(":")) ? strIlO : strIlO.replace(":", "-");
    }
}
