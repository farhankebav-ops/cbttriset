package com.onesignal.core.internal.config.impl;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import e6.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigModelStoreListener implements IStartableService, ISingletonModelStoreChangeHandler<ConfigModel> {
    public static final Companion Companion = new Companion(null);
    private static final int INCREASE_BETWEEN_RETRIES = 10000;
    private static final int MAX_WAIT_BETWEEN_RETRIES = 90000;
    private static final int MIN_WAIT_BETWEEN_RETRIES = 30000;
    private final ConfigModelStore _configModelStore;
    private final IParamsBackendService _paramsBackendService;
    private final ISubscriptionManager _subscriptionManager;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.config.impl.ConfigModelStoreListener$fetchParams$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.config.impl.ConfigModelStoreListener$fetchParams$1", f = "ConfigModelStoreListener.kt", l = {70, 120}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ String $appId;
        int I$0;
        int I$1;
        int label;
        final /* synthetic */ ConfigModelStoreListener this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, ConfigModelStoreListener configModelStoreListener, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$appId = str;
            this.this$0 = configModelStoreListener;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.$appId, this.this$0, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d0 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00dd A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ea A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f7 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0104 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0111 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x012b A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0138 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0145 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0156 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0167 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x017c A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0191 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01a6 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01bb A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01d0 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x01e5 A[Catch: BackendException -> 0x0028, TryCatch #0 {BackendException -> 0x0028, blocks: (B:15:0x0044, B:18:0x0065, B:21:0x0073, B:23:0x00d0, B:24:0x00d7, B:26:0x00dd, B:27:0x00e4, B:29:0x00ea, B:30:0x00f1, B:32:0x00f7, B:33:0x00fe, B:35:0x0104, B:36:0x010b, B:38:0x0111, B:39:0x0118, B:41:0x011e, B:42:0x0125, B:44:0x012b, B:45:0x0132, B:47:0x0138, B:48:0x013f, B:50:0x0145, B:51:0x0150, B:53:0x0156, B:54:0x015d, B:56:0x0167, B:57:0x0172, B:59:0x017c, B:60:0x0187, B:62:0x0191, B:63:0x019c, B:65:0x01a6, B:66:0x01b1, B:68:0x01bb, B:69:0x01c6, B:71:0x01d0, B:72:0x01db, B:74:0x01e5, B:75:0x01f0, B:10:0x0024), top: B:90:0x0024 }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x023e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x01fb -> B:88:0x023c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0238 -> B:87:0x023b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 575
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.config.impl.ConfigModelStoreListener.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public ConfigModelStoreListener(ConfigModelStore _configModelStore, IParamsBackendService _paramsBackendService, ISubscriptionManager _subscriptionManager) {
        k.e(_configModelStore, "_configModelStore");
        k.e(_paramsBackendService, "_paramsBackendService");
        k.e(_subscriptionManager, "_subscriptionManager");
        this._configModelStore = _configModelStore;
        this._paramsBackendService = _paramsBackendService;
        this._subscriptionManager = _subscriptionManager;
    }

    private final void fetchParams() {
        String appId = this._configModelStore.getModel().getAppId();
        if (appId.length() == 0) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(appId, this, null), 1, null);
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
        if (k.a(args.getProperty(), RemoteConfigConstants.RequestFieldKey.APP_ID)) {
            fetchParams();
        }
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._configModelStore.subscribe((ISingletonModelStoreChangeHandler) this);
        fetchParams();
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(ConfigModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        if (tag.equals(ModelChangeTags.NORMAL)) {
            fetchParams();
        }
    }
}
