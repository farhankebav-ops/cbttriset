package com.google.mlkit.common.internal.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzu;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
@WorkerThread
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdk
    public static abstract class AutoMLManifest {
        @NonNull
        @KeepForSdk
        public abstract String getLabelsFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelType();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @KeepForSdk
    public static abstract class ModelLoggingInfo {
        public static ModelLoggingInfo zza(long j, @Nullable String str, boolean z2) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzu.zzb(str), z2);
        }

        @NonNull
        @KeepForSdk
        public abstract String getHash();

        @KeepForSdk
        public abstract long getSize();

        @KeepForSdk
        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0109 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull com.google.mlkit.common.model.LocalModel r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    @Nullable
    @KeepForSdk
    public static String getSHA256(@NonNull File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZzc = zzc(fileInputStream);
                fileInputStream.close();
                return strZzc;
            } finally {
            }
        } catch (IOException e) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (new java.io.File(r6).exists() == false) goto L10;
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(@androidx.annotation.NonNull java.lang.String r6, boolean r7, @androidx.annotation.NonNull android.content.Context r8) {
        /*
            java.lang.String r0 = "Json string from the manifest file: "
            java.lang.String r1 = java.lang.String.valueOf(r6)
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r3 = "Manifest file path: "
            java.lang.String r1 = r3.concat(r1)
            java.lang.String r3 = "ModelUtils"
            r2.d(r3, r1)
            r1 = 0
            if (r7 == 0) goto L24
            android.content.res.AssetManager r4 = r8.getAssets()     // Catch: java.io.IOException -> L2f
            java.io.InputStream r4 = r4.open(r6)     // Catch: java.io.IOException -> L2f
            if (r4 == 0) goto L37
            r4.close()     // Catch: java.io.IOException -> L2f
            goto L37
        L24:
            java.io.File r4 = new java.io.File
            r4.<init>(r6)
            boolean r4 = r4.exists()
            if (r4 != 0) goto L37
        L2f:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Manifest file does not exist."
            r6.e(r3, r7)
            return r1
        L37:
            boolean r4 = r6.isEmpty()     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r5 = 0
            if (r4 == 0) goto L45
            byte[] r6 = new byte[r5]     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            goto L68
        L41:
            r6 = move-exception
            goto L9f
        L43:
            r6 = move-exception
            goto L9f
        L45:
            if (r7 == 0) goto L50
            android.content.res.AssetManager r7 = r8.getAssets()     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.io.InputStream r6 = r7.open(r6)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            goto L5b
        L50:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.io.File r8 = new java.io.File     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r8.<init>(r6)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r7.<init>(r8)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r6 = r7
        L5b:
            int r7 = r6.available()     // Catch: java.lang.Throwable -> L93
            byte[] r8 = new byte[r7]     // Catch: java.lang.Throwable -> L93
            r6.read(r8, r5, r7)     // Catch: java.lang.Throwable -> L93
            r6.close()     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r6 = r8
        L68:
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.lang.String r8 = "UTF-8"
            r7.<init>(r6, r8)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.lang.String r6 = r0.concat(r7)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r2.d(r3, r6)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r6.<init>(r7)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.lang.String r7 = "modelType"
            java.lang.String r7 = r6.getString(r7)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.lang.String r8 = "modelFile"
            java.lang.String r8 = r6.getString(r8)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            java.lang.String r0 = "labelsFile"
            java.lang.String r6 = r6.getString(r0)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            r0.<init>(r7, r8, r6)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
            return r0
        L93:
            r7 = move-exception
            if (r6 == 0) goto L9e
            r6.close()     // Catch: java.lang.Throwable -> L9a
            goto L9e
        L9a:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
        L9e:
            throw r7     // Catch: java.io.IOException -> L41 org.json.JSONException -> L43
        L9f:
            com.google.android.gms.common.internal.GmsLogger r7 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r8 = "Error parsing the manifest file."
            r7.e(r3, r8, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(@NonNull File file, @NonNull String str) {
        String sha256 = getSHA256(file);
        zza.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }

    @Nullable
    private static String zzb(Context context, String str, boolean z2) {
        AutoMLManifest manifestFile = parseManifestFile(str, z2, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    @Nullable
    private static String zzc(InputStream inputStream) {
        int i2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i8 = inputStream.read(bArr);
                if (i8 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i8);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b8 : bArrDigest) {
                String hexString = Integer.toHexString(b8 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}
