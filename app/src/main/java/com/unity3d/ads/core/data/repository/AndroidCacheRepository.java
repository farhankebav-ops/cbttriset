package com.unity3d.ads.core.data.repository;

import android.content.Context;
import c6.g;
import com.unity3d.ads.core.data.datasource.CacheDataSource;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.CachedFile;
import com.unity3d.ads.core.domain.CreateFile;
import com.unity3d.ads.core.domain.GetCacheDirectory;
import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import e6.l;
import e6.p;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.io.File;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import n6.m;
import org.json.JSONArray;
import q5.x;
import q6.a0;
import q6.c0;
import q6.q1;
import q6.w;
import q6.z;
import r2.q;
import t6.q0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidCacheRepository implements CacheRepository {
    private final File cacheDir;
    private final CleanupDirectory cleanupDirectory;
    private final Context context;
    private final CreateFile createFile;
    private final DownloadPriorityQueue downloadPriorityQueue;
    private final GetCacheDirectory getCacheDirectory;
    private final CacheDataSource localCacheDataSource;
    private final CacheDataSource remoteCacheDataSource;
    private final a0 scope;
    private final SessionRepository sessionRepository;
    private final File webviewCacheDir;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2", f = "AndroidCacheRepository.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidCacheRepository.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            boolean cleanCache = AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().getDebugSettings().getCleanCache();
            if (cleanCache || !AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
                File[] fileArrListFiles = AndroidCacheRepository.this.cacheDir.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        file.delete();
                    }
                }
            } else {
                NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration = AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().getCachedAssetsConfiguration();
                AndroidCacheRepository.this.cleanupDirectory.invoke(AndroidCacheRepository.this.cacheDir, cachedAssetsConfiguration.getMaxCachedAssetSizeMb(), cachedAssetsConfiguration.getMaxCachedAssetAgeMs());
            }
            x xVar = x.f13520a;
            if (!cleanCache && AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().hasCachedWebviewFilesConfiguration()) {
                NativeConfigurationOuterClass.CachedAssetsConfiguration cachedWebviewFilesConfiguration = AndroidCacheRepository.this.sessionRepository.getNativeConfiguration().getCachedWebviewFilesConfiguration();
                AndroidCacheRepository.this.cleanupDirectory.invoke(AndroidCacheRepository.this.webviewCacheDir, cachedWebviewFilesConfiguration.getMaxCachedAssetSizeMb(), cachedWebviewFilesConfiguration.getMaxCachedAssetAgeMs());
                return xVar;
            }
            File[] fileArrListFiles2 = AndroidCacheRepository.this.webviewCacheDir.listFiles();
            if (fileArrListFiles2 == null) {
                return null;
            }
            for (File file2 : fileArrListFiles2) {
                file2.delete();
            }
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository", f = "AndroidCacheRepository.kt", l = {100}, m = "doesFileExist")
    public static final class AnonymousClass1 extends x5.c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidCacheRepository.this.doesFileExist(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2", f = "AndroidCacheRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28902 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class AnonymousClass1 extends j implements l {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1, File.class, "isFile", "isFile()Z", 0);
            }

            @Override // e6.l
            public final Boolean invoke(File p02) {
                k.e(p02, "p0");
                return Boolean.valueOf(p02.isFile());
            }
        }

        public C28902(c<? super C28902> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidCacheRepository.this.new C28902(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            File file = AndroidCacheRepository.this.cacheDir;
            c6.j jVar = c6.j.f4234a;
            k.e(file, "<this>");
            g gVar = new g(m6.k.H0(new c6.i(file), AnonymousClass1.INSTANCE));
            long length = 0;
            while (gVar.hasNext()) {
                length += ((File) gVar.next()).length();
            }
            return new Long(length);
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super Long> cVar) {
            return ((C28902) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2", f = "AndroidCacheRepository.kt", l = {70, 77, 89}, m = "invokeSuspend")
    public static final class C28912 extends i implements p {
        final /* synthetic */ File $cacheDirectory;
        final /* synthetic */ int $priority;
        final /* synthetic */ String $url;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1", f = "AndroidCacheRepository.kt", l = {79, 85}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements l {
            final /* synthetic */ File $cacheDirectory;
            final /* synthetic */ q0 $fileResult;
            final /* synthetic */ String $filename;
            final /* synthetic */ int $priority;
            final /* synthetic */ String $url;
            int label;
            final /* synthetic */ AndroidCacheRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AndroidCacheRepository androidCacheRepository, File file, String str, String str2, int i2, q0 q0Var, c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = androidCacheRepository;
                this.$cacheDirectory = file;
                this.$filename = str;
                this.$url = str2;
                this.$priority = i2;
                this.$fileResult = q0Var;
            }

            @Override // x5.a
            public final c<x> create(c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$cacheDirectory, this.$filename, this.$url, this.$priority, this.$fileResult, cVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
            
                if (r12 == r0) goto L21;
             */
            @Override // x5.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
                /*
                    r11 = this;
                    w5.a r0 = w5.a.f17774a
                    int r1 = r11.label
                    q5.x r2 = q5.x.f13520a
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L20
                    if (r1 == r4) goto L1b
                    if (r1 != r3) goto L13
                    r2.q.z0(r12)
                    r9 = r11
                    goto L76
                L13:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L1b:
                    r2.q.z0(r12)
                    r9 = r11
                    goto L41
                L20:
                    r2.q.z0(r12)
                    com.unity3d.ads.core.data.repository.AndroidCacheRepository r12 = r11.this$0
                    com.unity3d.ads.core.data.datasource.CacheDataSource r5 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getLocalCacheDataSource$p(r12)
                    java.io.File r6 = r11.$cacheDirectory
                    java.lang.String r7 = r11.$filename
                    java.lang.String r8 = r11.$url
                    int r12 = r11.$priority
                    java.lang.Integer r9 = new java.lang.Integer
                    r9.<init>(r12)
                    r11.label = r4
                    r10 = r11
                    java.lang.Object r12 = r5.getFile(r6, r7, r8, r9, r10)
                    r9 = r10
                    if (r12 != r0) goto L41
                    goto L75
                L41:
                    com.unity3d.ads.core.data.model.CacheResult r12 = (com.unity3d.ads.core.data.model.CacheResult) r12
                    boolean r1 = r12 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
                    if (r1 == 0) goto L5a
                    t6.q0 r1 = r9.$fileResult
                L49:
                    r0 = r1
                    t6.d1 r0 = (t6.d1) r0
                    java.lang.Object r3 = r0.getValue()
                    r4 = r3
                    com.unity3d.ads.core.data.model.CacheResult r4 = (com.unity3d.ads.core.data.model.CacheResult) r4
                    boolean r0 = r0.g(r3, r12)
                    if (r0 == 0) goto L49
                    return r2
                L5a:
                    com.unity3d.ads.core.data.repository.AndroidCacheRepository r12 = r9.this$0
                    com.unity3d.ads.core.data.datasource.CacheDataSource r4 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getRemoteCacheDataSource$p(r12)
                    java.io.File r5 = r9.$cacheDirectory
                    java.lang.String r6 = r9.$filename
                    java.lang.String r7 = r9.$url
                    int r12 = r9.$priority
                    java.lang.Integer r8 = new java.lang.Integer
                    r8.<init>(r12)
                    r9.label = r3
                    java.lang.Object r12 = r4.getFile(r5, r6, r7, r8, r9)
                    if (r12 != r0) goto L76
                L75:
                    return r0
                L76:
                    com.unity3d.ads.core.data.model.CacheResult r12 = (com.unity3d.ads.core.data.model.CacheResult) r12
                    t6.q0 r0 = r9.$fileResult
                L7a:
                    r1 = r0
                    t6.d1 r1 = (t6.d1) r1
                    java.lang.Object r3 = r1.getValue()
                    r4 = r3
                    com.unity3d.ads.core.data.model.CacheResult r4 = (com.unity3d.ads.core.data.model.CacheResult) r4
                    boolean r1 = r1.g(r3, r12)
                    if (r1 == 0) goto L7a
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.C28912.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // e6.l
            public final Object invoke(c<? super x> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28912(String str, File file, int i2, c<? super C28912> cVar) {
            super(2, cVar);
            this.$url = str;
            this.$cacheDirectory = file;
            this.$priority = i2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return AndroidCacheRepository.this.new C28912(this.$url, this.$cacheDirectory, this.$priority, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[RETURN] */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                r18 = this;
                r5 = r18
                w5.a r6 = w5.a.f17774a
                int r0 = r5.label
                r7 = 0
                r8 = 3
                r9 = 2
                r1 = 1
                if (r0 == 0) goto L31
                if (r0 == r1) goto L26
                if (r0 == r9) goto L1e
                if (r0 != r8) goto L16
                r2.q.z0(r19)
                return r19
            L16:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L1e:
                java.lang.Object r0 = r5.L$0
                t6.q0 r0 = (t6.q0) r0
                r2.q.z0(r19)
                goto L8a
            L26:
                java.lang.Object r0 = r5.L$0
                java.lang.String r0 = (java.lang.String) r0
                r2.q.z0(r19)
                r13 = r0
                r0 = r19
                goto L5c
            L31:
                r2.q.z0(r19)
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r0 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                java.lang.String r2 = r5.$url
                java.lang.String r2 = r0.getFilename(r2)
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r0 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                com.unity3d.ads.core.data.datasource.CacheDataSource r0 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getLocalCacheDataSource$p(r0)
                java.io.File r3 = r5.$cacheDirectory
                r4 = r3
                java.lang.String r3 = r5.$url
                int r10 = r5.$priority
                r11 = r4
                java.lang.Integer r4 = new java.lang.Integer
                r4.<init>(r10)
                r5.L$0 = r2
                r5.label = r1
                r1 = r11
                java.lang.Object r0 = r0.getFile(r1, r2, r3, r4, r5)
                if (r0 != r6) goto L5b
                goto L9b
            L5b:
                r13 = r2
            L5c:
                com.unity3d.ads.core.data.model.CacheResult r0 = (com.unity3d.ads.core.data.model.CacheResult) r0
                boolean r1 = r0 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
                if (r1 == 0) goto L63
                return r0
            L63:
                t6.d1 r16 = t6.x0.c(r7)
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r0 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                com.unity3d.ads.core.domain.work.DownloadPriorityQueue r0 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.access$getDownloadPriorityQueue$p(r0)
                int r15 = r5.$priority
                com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1 r10 = new com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFileInternal$2$1
                com.unity3d.ads.core.data.repository.AndroidCacheRepository r11 = com.unity3d.ads.core.data.repository.AndroidCacheRepository.this
                java.io.File r12 = r5.$cacheDirectory
                java.lang.String r14 = r5.$url
                r17 = 0
                r10.<init>(r11, r12, r13, r14, r15, r16, r17)
                r1 = r16
                r5.L$0 = r1
                r5.label = r9
                java.lang.Object r0 = r0.invoke(r15, r10, r5)
                if (r0 != r6) goto L89
                goto L9b
            L89:
                r0 = r1
            L8a:
                a4.a r1 = new a4.a
                r2 = 26
                r1.<init>(r0, r2)
                r5.L$0 = r7
                r5.label = r8
                java.lang.Object r0 = t6.x0.l(r1, r5)
                if (r0 != r6) goto L9c
            L9b:
                return r6
            L9c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.C28912.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super CacheResult> cVar) {
            return ((C28912) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public AndroidCacheRepository(w ioDispatcher, GetCacheDirectory getCacheDirectory, CacheDataSource localCacheDataSource, CacheDataSource remoteCacheDataSource, Context context, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, DownloadPriorityQueue downloadPriorityQueue, CreateFile createFile) {
        k.e(ioDispatcher, "ioDispatcher");
        k.e(getCacheDirectory, "getCacheDirectory");
        k.e(localCacheDataSource, "localCacheDataSource");
        k.e(remoteCacheDataSource, "remoteCacheDataSource");
        k.e(context, "context");
        k.e(sessionRepository, "sessionRepository");
        k.e(cleanupDirectory, "cleanupDirectory");
        k.e(downloadPriorityQueue, "downloadPriorityQueue");
        k.e(createFile, "createFile");
        this.getCacheDirectory = getCacheDirectory;
        this.localCacheDataSource = localCacheDataSource;
        this.remoteCacheDataSource = remoteCacheDataSource;
        this.context = context;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.downloadPriorityQueue = downloadPriorityQueue;
        this.createFile = createFile;
        this.scope = c0.x(c0.x(c0.b(ioDispatcher), new z("CacheRepository")), q1.f13579a);
        this.cacheDir = initCacheDir(UnityAdsConstants.DefaultUrls.CACHE_DIR_NAME);
        this.webviewCacheDir = initCacheDir(UnityAdsConstants.DefaultUrls.CACHE_WEBVIEW_DIR_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getFileInternal(File file, String str, JSONArray jSONArray, int i2, c<? super CacheResult> cVar) {
        return c0.H(new C28912(str, file, i2, null), this.scope.getCoroutineContext(), cVar);
    }

    private final File initCacheDir(String str) {
        GetCacheDirectory getCacheDirectory = this.getCacheDirectory;
        File cacheDir = this.context.getCacheDir();
        k.d(cacheDir, "context.cacheDir");
        File fileInvoke = getCacheDirectory.invoke(cacheDir, str);
        fileInvoke.mkdirs();
        return fileInvoke;
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object clearCache(c<? super x> cVar) {
        return c0.H(new AnonymousClass2(null), this.scope.getCoroutineContext(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doesFileExist(java.lang.String r5, v5.c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.unity3d.ads.core.data.repository.AndroidCacheRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1 r0 = (com.unity3d.ads.core.data.repository.AndroidCacheRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1 r0 = new com.unity3d.ads.core.data.repository.AndroidCacheRepository$doesFileExist$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            r2.q.z0(r6)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            r2.q.z0(r6)
            r0.label = r3
            java.lang.Object r6 = r4.retrieveFile(r5, r0)
            if (r6 != r1) goto L3b
            return r1
        L3b:
            boolean r5 = r6 instanceof com.unity3d.ads.core.data.model.CacheResult.Success
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCacheRepository.doesFileExist(java.lang.String, v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getCacheSize(c<? super Long> cVar) {
        return c0.H(new C28902(null), this.scope.getCoroutineContext(), cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getFile(String str, JSONArray jSONArray, int i2, c<? super CacheResult> cVar) {
        return getFileInternal(this.cacheDir, str, jSONArray, i2, cVar);
    }

    public final String getFilename(String url) {
        k.e(url, "url");
        return StringExtensionsKt.getSHA256Hash(url) + '.' + m.O0('.', url, url);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object getWebviewFile(String str, String str2, c<? super CacheResult> cVar) {
        File fileInvoke = this.createFile.invoke(this.webviewCacheDir, str2);
        fileInvoke.mkdirs();
        return getFileInternal(fileInvoke, str, null, 0, cVar);
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public boolean removeFile(CachedFile cachedFile) {
        k.e(cachedFile, "cachedFile");
        File file = cachedFile.getFile();
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            file = null;
        }
        if (file != null) {
            return file.delete();
        }
        return false;
    }

    @Override // com.unity3d.ads.core.data.repository.CacheRepository
    public Object retrieveFile(String str, c<? super CacheResult> cVar) {
        return CacheDataSource.DefaultImpls.getFile$default(this.localCacheDataSource, this.cacheDir, str, null, null, cVar, 12, null);
    }
}
