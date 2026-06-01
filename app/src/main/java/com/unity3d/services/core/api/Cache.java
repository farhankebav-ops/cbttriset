package com.unity3d.services.core.api;

import android.media.MediaMetadataRetriever;
import android.util.Base64;
import android.util.SparseArray;
import com.bumptech.glide.load.Key;
import com.unity3d.services.core.cache.CacheDirectory;
import com.unity3d.services.core.cache.CacheDirectoryType;
import com.unity3d.services.core.cache.CacheError;
import com.unity3d.services.core.cache.CacheThread;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.WebRequestError;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Cache {
    @WebViewExposed
    public static void deleteFile(String str, WebViewCallback webViewCallback) {
        if (new File(fileIdToFilename(str)).delete()) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(CacheError.FILE_IO_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void download(String str, String str2, JSONArray jSONArray, Boolean bool, WebViewCallback webViewCallback) {
        if (CacheThread.isActive()) {
            webViewCallback.error(CacheError.FILE_ALREADY_CACHING, new Object[0]);
            return;
        }
        if (!Device.isActiveNetworkConnected()) {
            webViewCallback.error(CacheError.NO_INTERNET, new Object[0]);
            return;
        }
        try {
            CacheThread.download(str, fileIdToFilename(str2), Request.getHeadersMap(jSONArray), bool.booleanValue(), SharedInstances.INSTANCE.getWebViewEventSender());
            webViewCallback.invoke(new Object[0]);
        } catch (Exception e) {
            DeviceLog.exception("Error mapping headers for the request", e);
            webViewCallback.error(WebRequestError.MAPPING_HEADERS_FAILED, str, str2);
        }
    }

    private static String fileIdToFilename(String str) {
        if (SdkProperties.getCacheDirectory() == null) {
            return "";
        }
        return SdkProperties.getCacheDirectory() + "/" + SdkProperties.getCacheFilePrefix() + str;
    }

    @WebViewExposed
    public static void getCacheDirectoryExists(WebViewCallback webViewCallback) {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(Boolean.valueOf(cacheDirectory.exists()));
        }
    }

    @WebViewExposed
    public static void getCacheDirectoryType(WebViewCallback webViewCallback) {
        CacheDirectory cacheDirectoryObject = SdkProperties.getCacheDirectoryObject();
        if (cacheDirectoryObject == null || cacheDirectoryObject.getCacheDirectory(ClientProperties.getApplicationContext()) == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
            return;
        }
        if (!cacheDirectoryObject.getCacheDirectory(ClientProperties.getApplicationContext()).exists()) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_DOESNT_EXIST, new Object[0]);
            return;
        }
        CacheDirectoryType type = cacheDirectoryObject.getType();
        if (type == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_TYPE_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(type.name());
        }
    }

    @WebViewExposed
    public static void getFileContent(String str, String str2, WebViewCallback webViewCallback) throws Throwable {
        Object objEncodeToString;
        String strFileIdToFilename = fileIdToFilename(str);
        File file = new File(strFileIdToFilename);
        if (!file.exists()) {
            webViewCallback.error(CacheError.FILE_NOT_FOUND, str, strFileIdToFilename);
            return;
        }
        try {
            byte[] fileBytes = Utilities.readFileBytes(file);
            if (str2 == null) {
                webViewCallback.error(CacheError.UNSUPPORTED_ENCODING, str, strFileIdToFilename, str2);
                return;
            }
            if (str2.equals(Key.STRING_CHARSET_NAME)) {
                objEncodeToString = Charset.forName(Key.STRING_CHARSET_NAME).decode(ByteBuffer.wrap(fileBytes)).toString();
            } else {
                if (!str2.equals("Base64")) {
                    webViewCallback.error(CacheError.UNSUPPORTED_ENCODING, str, strFileIdToFilename, str2);
                    return;
                }
                objEncodeToString = Base64.encodeToString(fileBytes, 2);
            }
            webViewCallback.invoke(objEncodeToString);
        } catch (IOException e) {
            webViewCallback.error(CacheError.FILE_IO_ERROR, str, strFileIdToFilename, e.getMessage() + ", " + e.getClass().getName());
        }
    }

    @WebViewExposed
    public static void getFileInfo(String str, WebViewCallback webViewCallback) {
        try {
            webViewCallback.invoke(getFileJson(str));
        } catch (JSONException e) {
            DeviceLog.exception("Error creating JSON", e);
            webViewCallback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    private static JSONObject getFileJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", str);
        File file = new File(fileIdToFilename(str));
        if (!file.exists()) {
            jSONObject.put("found", false);
            return jSONObject;
        }
        jSONObject.put("found", true);
        jSONObject.put("size", file.length());
        jSONObject.put("mtime", file.lastModified());
        return jSONObject;
    }

    @WebViewExposed
    public static void getFilePath(String str, WebViewCallback webViewCallback) {
        if (new File(fileIdToFilename(str)).exists()) {
            webViewCallback.invoke(fileIdToFilename(str));
        } else {
            webViewCallback.error(CacheError.FILE_NOT_FOUND, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFiles(WebViewCallback webViewCallback) {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory == null) {
            return;
        }
        DeviceLog.debug("Unity Ads cache: checking app directory for Unity Ads cached files");
        File[] fileArrListFiles = cacheDirectory.listFiles(new FilenameFilter() { // from class: com.unity3d.services.core.api.Cache.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(SdkProperties.getCacheFilePrefix());
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            webViewCallback.invoke(new JSONArray());
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (File file : fileArrListFiles) {
                String strSubstring = file.getName().substring(SdkProperties.getCacheFilePrefix().length());
                DeviceLog.debug("Unity Ads cache: found " + strSubstring + ", " + file.length() + " bytes");
                jSONArray.put(getFileJson(strSubstring));
            }
            webViewCallback.invoke(jSONArray);
        } catch (JSONException e) {
            DeviceLog.exception("Error creating JSON", e);
            webViewCallback.error(CacheError.JSON_ERROR, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFreeSpace(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Long.valueOf(Device.getFreeSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void getHash(String str, WebViewCallback webViewCallback) {
        webViewCallback.invoke(Utilities.Sha256(str));
    }

    @WebViewExposed
    public static void getMetaData(String str, JSONArray jSONArray, WebViewCallback webViewCallback) {
        try {
            SparseArray<String> metaData = getMetaData(fileIdToFilename(str), jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (int i2 = 0; i2 < metaData.size(); i2++) {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(metaData.keyAt(i2));
                jSONArray3.put(metaData.valueAt(i2));
                jSONArray2.put(jSONArray3);
            }
            webViewCallback.invoke(jSONArray2);
        } catch (IOException e) {
            webViewCallback.error(CacheError.FILE_IO_ERROR, e.getMessage());
        } catch (RuntimeException e4) {
            webViewCallback.error(CacheError.INVALID_ARGUMENT, e4.getMessage());
        } catch (JSONException e8) {
            webViewCallback.error(CacheError.JSON_ERROR, e8.getMessage());
        }
    }

    @WebViewExposed
    public static void getProgressInterval(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Integer.valueOf(CacheThread.getProgressInterval()));
    }

    @WebViewExposed
    public static void getTimeouts(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Integer.valueOf(CacheThread.getConnectTimeout()), Integer.valueOf(CacheThread.getReadTimeout()));
    }

    @WebViewExposed
    public static void getTotalSpace(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Long.valueOf(Device.getTotalSpace(SdkProperties.getCacheDirectory())));
    }

    @WebViewExposed
    public static void isCaching(WebViewCallback webViewCallback) {
        webViewCallback.invoke(Boolean.valueOf(CacheThread.isActive()));
    }

    @WebViewExposed
    public static void recreateCacheDirectory(WebViewCallback webViewCallback) {
        if (SdkProperties.getCacheDirectory().exists()) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_EXISTS, new Object[0]);
            return;
        }
        SdkProperties.setCacheDirectory(null);
        if (SdkProperties.getCacheDirectory() == null) {
            webViewCallback.error(CacheError.CACHE_DIRECTORY_NULL, new Object[0]);
        } else {
            webViewCallback.invoke(new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x006c A[EXC_TOP_SPLITTER, PHI: r11
  0x006c: PHI (r11v6 java.io.FileOutputStream) = (r11v5 java.io.FileOutputStream), (r11v7 java.io.FileOutputStream) binds: [B:30:0x006a, B:36:0x0082] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @com.unity3d.services.core.webview.bridge.WebViewExposed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setFileContent(java.lang.String r9, java.lang.String r10, java.lang.String r11, com.unity3d.services.core.webview.bridge.WebViewCallback r12) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "Error closing FileOutputStream"
            java.lang.String r2 = fileIdToFilename(r9)
            r3 = 1
            r4 = 3
            r5 = 0
            r6 = 2
            byte[] r7 = r11.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L91
            if (r10 == 0) goto L3a
            int r8 = r10.length()
            if (r8 <= 0) goto L3a
            java.lang.String r8 = "Base64"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L25
            byte[] r7 = android.util.Base64.decode(r11, r6)
            goto L3a
        L25:
            boolean r11 = r10.equals(r0)
            if (r11 == 0) goto L2c
            goto L3a
        L2c:
            com.unity3d.services.core.cache.CacheError r11 = com.unity3d.services.core.cache.CacheError.UNSUPPORTED_ENCODING
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r5] = r9
            r0[r3] = r2
            r0[r6] = r10
            r12.error(r11, r0)
            return
        L3a:
            r11 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d java.io.FileNotFoundException -> L75
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L5d java.io.FileNotFoundException -> L75
            r0.write(r7)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L59
            r0.flush()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L57 java.io.FileNotFoundException -> L59
            r0.close()     // Catch: java.lang.Exception -> L4a
            goto L4e
        L4a:
            r9 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r9)
        L4e:
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r12.invoke(r9)
            goto L85
        L54:
            r9 = move-exception
            r11 = r0
            goto L86
        L57:
            r11 = r0
            goto L5d
        L59:
            r11 = r0
            goto L75
        L5b:
            r9 = move-exception
            goto L86
        L5d:
            com.unity3d.services.core.cache.CacheError r0 = com.unity3d.services.core.cache.CacheError.FILE_IO_ERROR     // Catch: java.lang.Throwable -> L5b
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5b
            r4[r5] = r9     // Catch: java.lang.Throwable -> L5b
            r4[r3] = r2     // Catch: java.lang.Throwable -> L5b
            r4[r6] = r10     // Catch: java.lang.Throwable -> L5b
            r12.error(r0, r4)     // Catch: java.lang.Throwable -> L5b
            if (r11 == 0) goto L85
        L6c:
            r11.close()     // Catch: java.lang.Exception -> L70
            goto L85
        L70:
            r9 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r9)
            goto L85
        L75:
            com.unity3d.services.core.cache.CacheError r0 = com.unity3d.services.core.cache.CacheError.FILE_NOT_FOUND     // Catch: java.lang.Throwable -> L5b
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5b
            r4[r5] = r9     // Catch: java.lang.Throwable -> L5b
            r4[r3] = r2     // Catch: java.lang.Throwable -> L5b
            r4[r6] = r10     // Catch: java.lang.Throwable -> L5b
            r12.error(r0, r4)     // Catch: java.lang.Throwable -> L5b
            if (r11 == 0) goto L85
            goto L6c
        L85:
            return
        L86:
            if (r11 == 0) goto L90
            r11.close()     // Catch: java.lang.Exception -> L8c
            goto L90
        L8c:
            r10 = move-exception
            com.unity3d.services.core.log.DeviceLog.exception(r1, r10)
        L90:
            throw r9
        L91:
            com.unity3d.services.core.cache.CacheError r11 = com.unity3d.services.core.cache.CacheError.UNSUPPORTED_ENCODING
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r5] = r9
            r0[r3] = r2
            r0[r6] = r10
            r12.error(r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.api.Cache.setFileContent(java.lang.String, java.lang.String, java.lang.String, com.unity3d.services.core.webview.bridge.WebViewCallback):void");
    }

    @WebViewExposed
    public static void setProgressInterval(Integer num, WebViewCallback webViewCallback) {
        CacheThread.setProgressInterval(num.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void setTimeouts(Integer num, Integer num2, WebViewCallback webViewCallback) {
        CacheThread.setConnectTimeout(num.intValue());
        CacheThread.setReadTimeout(num2.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void stop(WebViewCallback webViewCallback) {
        if (!CacheThread.isActive()) {
            webViewCallback.error(CacheError.NOT_CACHING, new Object[0]);
        } else {
            CacheThread.cancel();
            webViewCallback.invoke(new Object[0]);
        }
    }

    private static SparseArray<String> getMetaData(String str, JSONArray jSONArray) throws JSONException, IOException, RuntimeException {
        File file = new File(str);
        SparseArray<String> sparseArray = new SparseArray<>();
        if (file.exists()) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                int i8 = jSONArray.getInt(i2);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(i8);
                if (strExtractMetadata != null) {
                    sparseArray.put(i8, strExtractMetadata);
                }
            }
            return sparseArray;
        }
        throw new IOException("File: " + file.getAbsolutePath() + " doesn't exist");
    }
}
