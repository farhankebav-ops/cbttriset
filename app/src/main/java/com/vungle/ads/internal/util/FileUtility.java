package com.vungle.ads.internal.util;

import android.os.Build;
import android.webkit.URLUtil;
import androidx.annotation.VisibleForTesting;
import com.mimikridev.utilmanager.config.b;
import com.vungle.ads.AssetFailedToDeleteError;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;
import okhttp3.HttpUrl;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FileUtility {
    private static final String TAG = "FileUtility";
    public static final FileUtility INSTANCE = new FileUtility();
    private static ObjectInputStreamProvider objectInputStreamProvider = new b(4);
    private static final List<Class<?>> allowedClasses = m.H0(LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ObjectInputStreamProvider {
        ObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    private FileUtility() {
    }

    public static final void delete(File file, Set<String> set) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        if (set != null && set.contains(file.getName())) {
                            Logger.Companion.d(TAG, "Skipping deletion of directory: " + file.getName());
                            return;
                        }
                        deleteContents(file, set);
                    }
                    if (set != null && set.contains(file.getName())) {
                        Logger.Companion.d(TAG, "Skipping deletion of file: " + file.getName());
                        return;
                    }
                    if (file.delete()) {
                        return;
                    }
                    Logger.Companion.d(TAG, "Failed to delete file: " + file);
                }
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Failed to delete file: " + e.getLocalizedMessage());
            }
        }
    }

    public static /* synthetic */ void delete$default(File file, Set set, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            set = null;
        }
        delete(file, set);
    }

    public static final void deleteAndLogIfFailed(File file) {
        k.e(file, "file");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Files.delete(file.toPath());
            } else {
                if (file.delete()) {
                    return;
                }
                new AssetFailedToDeleteError("Cannot delete " + file.getName()).logErrorNoReturnValue$vungle_ads_release();
            }
        } catch (Exception e) {
            new AssetFailedToDeleteError("Failed to delete " + file.getName() + " with error :" + e.getMessage()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public static final void deleteContents(File folder, Set<String> set) {
        k.e(folder, "folder");
        File[] fileArrListFiles = folder.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            delete(file, set);
        }
    }

    public static /* synthetic */ void deleteContents$default(File file, Set set, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            set = null;
        }
        deleteContents(file, set);
    }

    private final String getIndentString(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < i2; i8++) {
            sb.append("|  ");
        }
        String string = sb.toString();
        k.d(string, "sb.toString()");
        return string;
    }

    public static /* synthetic */ String guessFileName$default(FileUtility fileUtility, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return fileUtility.guessFileName(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: objectInputStreamProvider$lambda-0, reason: not valid java name */
    public static final ObjectInputStream m3377objectInputStreamProvider$lambda0(InputStream inputStream) {
        return new SafeObjectInputStream(inputStream, allowedClasses);
    }

    public static final void printDirectoryTree(File file) {
    }

    private final void printFile(File file, int i2, StringBuilder sb) {
        sb.append(getIndentString(i2));
        sb.append("+--");
        sb.append(file.getName());
        sb.append('\n');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x002f: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:48), block:B:11:0x002f */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.vungle.ads.internal.util.FileUtility] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.FileUtility] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.vungle.ads.internal.util.FileUtility] */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v11, types: [com.vungle.ads.internal.util.FileUtility$ObjectInputStreamProvider] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final <T> T readSerializable(File file) throws Throwable {
        Closeable closeable;
        ObjectInputStream objectInputStreamProvideObjectInputStream;
        ?? r42;
        k.e(file, "file");
        ?? Exists = file.exists();
        Closeable closeable2 = null;
        try {
            if (Exists != 0) {
                try {
                    Exists = new FileInputStream(file);
                    try {
                        objectInputStreamProvideObjectInputStream = objectInputStreamProvider.provideObjectInputStream(Exists);
                    } catch (IOException e) {
                        e = e;
                        objectInputStreamProvideObjectInputStream = null;
                    } catch (ClassNotFoundException e4) {
                        e = e4;
                        objectInputStreamProvideObjectInputStream = null;
                    } catch (Exception e8) {
                        e = e8;
                        objectInputStreamProvideObjectInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        ?? r02 = INSTANCE;
                        r02.closeQuietly(closeable2);
                        r02.closeQuietly(Exists);
                        throw th;
                    }
                } catch (IOException e9) {
                    e = e9;
                    Exists = 0;
                    objectInputStreamProvideObjectInputStream = null;
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    Exists = 0;
                    objectInputStreamProvideObjectInputStream = null;
                } catch (Exception e11) {
                    e = e11;
                    Exists = 0;
                    objectInputStreamProvideObjectInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    Exists = 0;
                }
                try {
                    T t3 = (T) objectInputStreamProvideObjectInputStream.readObject();
                    ?? r03 = INSTANCE;
                    r03.closeQuietly(objectInputStreamProvideObjectInputStream);
                    r03.closeQuietly(Exists);
                    return t3;
                } catch (IOException e12) {
                    e = e12;
                    Logger.Companion.e(TAG, "IOException: " + e.getMessage());
                    r42 = Exists;
                    ?? r04 = INSTANCE;
                    r04.closeQuietly(objectInputStreamProvideObjectInputStream);
                    r04.closeQuietly(r42);
                    try {
                        delete$default(file, null, 2, null);
                    } catch (IOException unused) {
                    }
                    return null;
                } catch (ClassNotFoundException e13) {
                    e = e13;
                    Logger.Companion.e(TAG, "ClassNotFoundException: " + e.getMessage());
                    r42 = Exists;
                    ?? r042 = INSTANCE;
                    r042.closeQuietly(objectInputStreamProvideObjectInputStream);
                    r042.closeQuietly(r42);
                    delete$default(file, null, 2, null);
                    return null;
                } catch (Exception e14) {
                    e = e14;
                    Logger.Companion.e(TAG, "cannot read serializable " + e.getMessage());
                    r42 = Exists;
                    ?? r0422 = INSTANCE;
                    r0422.closeQuietly(objectInputStreamProvideObjectInputStream);
                    r0422.closeQuietly(r42);
                    delete$default(file, null, 2, null);
                    return null;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeable2 = closeable;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void writeSerializable(File file, Serializable serializable) throws Throwable {
        OutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        k.e(file, "file");
        if (file.exists()) {
            deleteAndLogIfFailed(file);
        }
        if (serializable == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.reset();
                    FileUtility fileUtility = INSTANCE;
                    fileUtility.closeQuietly(objectOutputStream);
                    fileUtility.closeQuietly(fileOutputStream);
                } catch (IOException e) {
                    e = e;
                    outputStream = fileOutputStream;
                    try {
                        Logger.Companion.e(TAG, String.valueOf(e.getMessage()));
                        FileUtility fileUtility2 = INSTANCE;
                        fileUtility2.closeQuietly(objectOutputStream);
                        fileUtility2.closeQuietly(outputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = outputStream;
                        outputStream = objectOutputStream;
                        FileUtility fileUtility3 = INSTANCE;
                        fileUtility3.closeQuietly(outputStream);
                        fileUtility3.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = objectOutputStream;
                    FileUtility fileUtility32 = INSTANCE;
                    fileUtility32.closeQuietly(outputStream);
                    fileUtility32.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                FileUtility fileUtility322 = INSTANCE;
                fileUtility322.closeQuietly(outputStream);
                fileUtility322.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            objectOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final List<Class<?>> getAllowedClasses$vungle_ads_release() {
        return allowedClasses;
    }

    @VisibleForTesting
    public final ObjectInputStreamProvider getObjectInputStreamProvider() {
        return objectInputStreamProvider;
    }

    public final String guessFileName(String url, String str) {
        k.e(url, "url");
        String strGuessFileName = URLUtil.guessFileName(url, null, str);
        k.d(strGuessFileName, "guessFileName(url, null, ext)");
        return strGuessFileName;
    }

    public final boolean isValidUrl(String str) {
        return (str == null || str.length() == 0 || HttpUrl.Companion.parse(str) == null) ? false : true;
    }

    public final String readString(File file) {
        k.e(file, "file");
        if (!file.exists()) {
            return null;
        }
        try {
            return c6.k.c0(file);
        } catch (IOException e) {
            Logger.Companion.e(TAG, "IOException: " + e.getMessage());
            return null;
        } catch (Exception e4) {
            Logger.Companion.e(TAG, "cannot read string " + e4.getMessage());
            return null;
        }
    }

    @VisibleForTesting
    public final void setObjectInputStreamProvider(ObjectInputStreamProvider objectInputStreamProvider2) {
        k.e(objectInputStreamProvider2, "<set-?>");
        objectInputStreamProvider = objectInputStreamProvider2;
    }

    public final long size(File file) {
        long size = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            if (!(fileArrListFiles.length == 0)) {
                for (File file2 : fileArrListFiles) {
                    size += size(file2);
                }
            }
        }
        return size;
    }

    public final void writeString(File file, String str) {
        k.e(file, "file");
        if (str == null) {
            return;
        }
        try {
            c6.k.e0(file, str, n6.a.f13073a);
        } catch (IOException e) {
            Logger.Companion.e(TAG, String.valueOf(e.getMessage()));
        }
    }

    private final void printDirectoryTree(File file, int i2, StringBuilder sb) {
        if (file == null) {
            return;
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("folder is not a Directory");
        }
        sb.append(getIndentString(i2));
        sb.append("+--");
        sb.append(file.getName());
        sb.append("/\n");
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                printDirectoryTree(file2, i2 + 1, sb);
            } else {
                printFile(file2, i2 + 1, sb);
            }
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getAllowedClasses$vungle_ads_release$annotations() {
    }
}
