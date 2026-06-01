package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CachedFile;
import org.json.JSONArray;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface CacheRepository {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getFile$default(CacheRepository cacheRepository, String str, JSONArray jSONArray, int i2, c cVar, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFile");
            }
            if ((i8 & 2) != 0) {
                jSONArray = null;
            }
            if ((i8 & 4) != 0) {
                i2 = 0;
            }
            return cacheRepository.getFile(str, jSONArray, i2, cVar);
        }
    }

    Object clearCache(c<? super x> cVar);

    Object doesFileExist(String str, c<? super Boolean> cVar);

    Object getCacheSize(c<? super Long> cVar);

    Object getFile(String str, JSONArray jSONArray, int i2, c<? super CacheResult> cVar);

    Object getWebviewFile(String str, String str2, c<? super CacheResult> cVar);

    boolean removeFile(CachedFile cachedFile);

    Object retrieveFile(String str, c<? super CacheResult> cVar);
}
