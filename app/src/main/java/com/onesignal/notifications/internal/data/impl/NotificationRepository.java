package com.onesignal.notifications.internal.data.impl;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import e6.p;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.w;
import org.json.JSONException;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;
import x6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationRepository implements INotificationRepository {
    private static final long NOTIFICATION_CACHE_DATA_LIFETIME = 604800;
    private final IApplicationService _applicationService;
    private final IBadgeCountUpdater _badgeCountUpdater;
    private final IDatabaseProvider _databaseProvider;
    private final INotificationQueryHelper _queryHelper;
    private final ITime _time;
    public static final Companion Companion = new Companion(null);
    private static final String[] COLUMNS_FOR_LIST_NOTIFICATIONS = {"title", "message", "notification_id", OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME};

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String[] getCOLUMNS_FOR_LIST_NOTIFICATIONS() {
            return NotificationRepository.COLUMNS_FOR_LIST_NOTIFICATIONS;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$clearOldestOverLimitFallback$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$clearOldestOverLimitFallback$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ int $maxNumberOfNotificationsInt;
        final /* synthetic */ int $notificationsToMakeRoomFor;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$clearOldestOverLimitFallback$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ int $maxNumberOfNotificationsInt;
            final /* synthetic */ int $notificationsToMakeRoomFor;
            final /* synthetic */ NotificationRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i2, int i8, NotificationRepository notificationRepository) {
                super(1);
                this.$maxNumberOfNotificationsInt = i2;
                this.$notificationsToMakeRoomFor = i8;
                this.this$0 = notificationRepository;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                int count = (it.getCount() - this.$maxNumberOfNotificationsInt) + this.$notificationsToMakeRoomFor;
                if (count < 1) {
                    return;
                }
                while (it.moveToNext()) {
                    this.this$0.internalMarkAsDismissed(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                    count--;
                    if (count <= 0) {
                        return;
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i2, NotificationRepository notificationRepository, int i8, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$maxNumberOfNotificationsInt = i2;
            this.this$0 = notificationRepository;
            this.$notificationsToMakeRoomFor = i8;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$maxNumberOfNotificationsInt, this.this$0, this.$notificationsToMakeRoomFor, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            String strValueOf = String.valueOf(this.$maxNumberOfNotificationsInt);
            try {
                IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, this.this$0._queryHelper.recentUninteractedWithNotificationsWhere().toString(), null, null, null, "_id", strValueOf + this.$notificationsToMakeRoomFor, new AnonymousClass1(this.$maxNumberOfNotificationsInt, this.$notificationsToMakeRoomFor, this.this$0), 56, null);
            } catch (Throwable th) {
                Logging.error("Error clearing oldest notifications over limit! ", th);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$createNotification$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$createNotification$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27702 extends i implements p {
        final /* synthetic */ int $androidId;
        final /* synthetic */ String $body;
        final /* synthetic */ String $collapseKey;
        final /* synthetic */ long $expireTime;
        final /* synthetic */ String $groupId;
        final /* synthetic */ String $id;
        final /* synthetic */ boolean $isOpened;
        final /* synthetic */ String $jsonPayload;
        final /* synthetic */ boolean $shouldDismissIdenticals;
        final /* synthetic */ String $title;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27702(String str, boolean z2, int i2, NotificationRepository notificationRepository, String str2, String str3, boolean z7, String str4, String str5, long j, String str6, c<? super C27702> cVar) {
            super(2, cVar);
            this.$id = str;
            this.$shouldDismissIdenticals = z2;
            this.$androidId = i2;
            this.this$0 = notificationRepository;
            this.$groupId = str2;
            this.$collapseKey = str3;
            this.$isOpened = z7;
            this.$title = str4;
            this.$body = str5;
            this.$expireTime = j;
            this.$jsonPayload = str6;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C27702(this.$id, this.$shouldDismissIdenticals, this.$androidId, this.this$0, this.$groupId, this.$collapseKey, this.$isOpened, this.$title, this.$body, this.$expireTime, this.$jsonPayload, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            Logging.debug$default("Saving Notification id=" + this.$id, null, 2, null);
            try {
                if (this.$shouldDismissIdenticals) {
                    String str = "android_notification_id = " + this.$androidId;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, new Integer(1));
                    this.this$0._databaseProvider.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, str, null);
                    this.this$0._badgeCountUpdater.update();
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("notification_id", this.$id);
                String str2 = this.$groupId;
                if (str2 != null) {
                    contentValues2.put("group_id", str2);
                }
                String str3 = this.$collapseKey;
                if (str3 != null) {
                    contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_COLLAPSE_ID, str3);
                }
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, new Integer(this.$isOpened ? 1 : 0));
                if (!this.$isOpened) {
                    contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, new Integer(this.$androidId));
                }
                String str4 = this.$title;
                if (str4 != null) {
                    contentValues2.put("title", str4);
                }
                String str5 = this.$body;
                if (str5 != null) {
                    contentValues2.put("message", str5);
                }
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_EXPIRE_TIME, new Long(this.$expireTime));
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, this.$jsonPayload);
                this.this$0._databaseProvider.getOs().insertOrThrow(OneSignalDbContract.NotificationTable.TABLE_NAME, null, contentValues2);
                Logging.debug$default("Notification saved values: " + contentValues2, null, 2, null);
                if (!this.$isOpened) {
                    this.this$0._badgeCountUpdater.update();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27702) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$createSummaryNotification$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$createSummaryNotification$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27712 extends i implements p {
        final /* synthetic */ int $androidId;
        final /* synthetic */ String $groupId;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27712(int i2, String str, NotificationRepository notificationRepository, c<? super C27712> cVar) {
            super(2, cVar);
            this.$androidId = i2;
            this.$groupId = str;
            this.this$0 = notificationRepository;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C27712(this.$androidId, this.$groupId, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            ContentValues contentValues = new ContentValues();
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, new Integer(this.$androidId));
            contentValues.put("group_id", this.$groupId);
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_IS_SUMMARY, new Integer(1));
            this.this$0._databaseProvider.getOs().insertOrThrow(OneSignalDbContract.NotificationTable.TABLE_NAME, null, contentValues);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27712) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$deleteExpiredNotifications$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$deleteExpiredNotifications$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27722 extends i implements p {
        int label;

        public C27722(c<? super C27722> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27722(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            String strValueOf = String.valueOf((NotificationRepository.this._time.getCurrentTimeMillis() / 1000) - NotificationRepository.NOTIFICATION_CACHE_DATA_LIFETIME);
            k.d(strValueOf, "valueOf(\n               …FETIME,\n                )");
            NotificationRepository.this._databaseProvider.getOs().delete(OneSignalDbContract.NotificationTable.TABLE_NAME, "created_time < ?", new String[]{strValueOf});
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27722) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {162}, m = "doesNotificationExist")
    public static final class AnonymousClass1 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.doesNotificationExist(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27732 extends i implements p {
        final /* synthetic */ String $id;
        final /* synthetic */ w $result;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ String $id;
            final /* synthetic */ w $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str, w wVar) {
                super(1);
                this.$id = str;
                this.$result = wVar;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.moveToFirst()) {
                    Logging.debug$default("Notification notValidOrDuplicated with id duplicated, duplicate FCM message received, skip processing of " + this.$id, null, 2, null);
                    this.$result.f12728a = true;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27732(String str, NotificationRepository notificationRepository, w wVar, c<? super C27732> cVar) {
            super(2, cVar);
            this.$id = str;
            this.this$0 = notificationRepository;
            this.$result = wVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C27732(this.$id, this.this$0, this.$result, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            String str = this.$id;
            k.b(str);
            IDatabase os = this.this$0._databaseProvider.getOs();
            IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{"notification_id"}, "notification_id = ?", new String[]{str}, null, null, null, null, new AnonymousClass1(this.$id, this.$result), 240, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27732) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {515}, m = "getAndroidIdForGroup")
    public static final class C27741 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27741(c<? super C27741> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.getAndroidIdForGroup(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27752 extends i implements p {
        final /* synthetic */ kotlin.jvm.internal.a0 $recentId;
        final /* synthetic */ String[] $whereArgs;
        final /* synthetic */ kotlin.jvm.internal.a0 $whereStr;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ kotlin.jvm.internal.a0 $recentId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(kotlin.jvm.internal.a0 a0Var) {
                super(1);
                this.$recentId = a0Var;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                boolean zMoveToFirst = it.moveToFirst();
                this.$recentId.f12717a = !zMoveToFirst ? null : Integer.valueOf(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27752(kotlin.jvm.internal.a0 a0Var, String[] strArr, kotlin.jvm.internal.a0 a0Var2, c<? super C27752> cVar) {
            super(2, cVar);
            this.$whereStr = a0Var;
            this.$whereArgs = strArr;
            this.$recentId = a0Var2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27752(this.$whereStr, this.$whereArgs, this.$recentId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            IDatabase.DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, (String) this.$whereStr.f12717a, this.$whereArgs, null, null, "created_time DESC", "1", new AnonymousClass1(this.$recentId), 48, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27752) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {381}, m = "getAndroidIdFromCollapseKey")
    public static final class C27761 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27761(c<? super C27761> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.getAndroidIdFromCollapseKey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27772 extends i implements p {
        final /* synthetic */ kotlin.jvm.internal.a0 $androidId;
        final /* synthetic */ String $collapseKey;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ kotlin.jvm.internal.a0 $androidId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(kotlin.jvm.internal.a0 a0Var) {
                super(1);
                this.$androidId = a0Var;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.moveToFirst()) {
                    this.$androidId.f12717a = Integer.valueOf(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27772(String str, kotlin.jvm.internal.a0 a0Var, c<? super C27772> cVar) {
            super(2, cVar);
            this.$collapseKey = str;
            this.$androidId = a0Var;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27772(this.$collapseKey, this.$androidId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            IDatabase.DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{this.$collapseKey}, null, null, null, null, new AnonymousClass1(this.$androidId), 240, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27772) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {361}, m = "getGroupId")
    public static final class C27781 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27781(c<? super C27781> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.getGroupId(0, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27792 extends i implements p {
        final /* synthetic */ int $androidId;
        final /* synthetic */ kotlin.jvm.internal.a0 $groupId;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ kotlin.jvm.internal.a0 $groupId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(kotlin.jvm.internal.a0 a0Var) {
                super(1);
                this.$groupId = a0Var;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.moveToFirst()) {
                    this.$groupId.f12717a = it.getOptString("group_id");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27792(int i2, kotlin.jvm.internal.a0 a0Var, c<? super C27792> cVar) {
            super(2, cVar);
            this.$androidId = i2;
            this.$groupId = a0Var;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27792(this.$androidId, this.$groupId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            IDatabase.DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{"group_id"}, "android_notification_id = " + this.$androidId, null, null, null, null, null, new AnonymousClass1(this.$groupId), 248, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27792) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {440}, m = "listNotificationsForGroup")
    public static final class C27801 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27801(c<? super C27801> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.listNotificationsForGroup(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27812 extends i implements p {
        final /* synthetic */ List<INotificationRepository.NotificationData> $listOfNotifications;
        final /* synthetic */ String $summaryGroup;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ List<INotificationRepository.NotificationData> $listOfNotifications;
            final /* synthetic */ String $summaryGroup;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List<INotificationRepository.NotificationData> list, String str) {
                super(1);
                this.$listOfNotifications = list;
                this.$summaryGroup = str;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.moveToFirst()) {
                    do {
                        try {
                            String optString = it.getOptString("title");
                            String optString2 = it.getOptString("message");
                            this.$listOfNotifications.add(new INotificationRepository.NotificationData(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID), it.getString("notification_id"), it.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA), it.getLong(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME), optString, optString2));
                        } catch (JSONException unused) {
                            Logging.error$default("Could not parse JSON of sub notification in group: " + this.$summaryGroup, null, 2, null);
                        }
                    } while (it.moveToNext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27812(String str, NotificationRepository notificationRepository, List<INotificationRepository.NotificationData> list, c<? super C27812> cVar) {
            super(2, cVar);
            this.$summaryGroup = str;
            this.this$0 = notificationRepository;
            this.$listOfNotifications = list;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C27812(this.$summaryGroup, this.this$0, this.$listOfNotifications, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, NotificationRepository.Companion.getCOLUMNS_FOR_LIST_NOTIFICATIONS(), "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{this.$summaryGroup}, null, null, "_id DESC", null, new AnonymousClass1(this.$listOfNotifications, this.$summaryGroup), 176, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27812) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {541}, m = "listNotificationsForOutstanding")
    public static final class C27821 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27821(c<? super C27821> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.listNotificationsForOutstanding(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27832 extends i implements p {
        final /* synthetic */ List<Integer> $excludeAndroidIds;
        final /* synthetic */ List<INotificationRepository.NotificationData> $listOfNotifications;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ List<INotificationRepository.NotificationData> $listOfNotifications;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List<INotificationRepository.NotificationData> list) {
                super(1);
                this.$listOfNotifications = list;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                while (it.moveToNext()) {
                    String optString = it.getOptString("title");
                    String optString2 = it.getOptString("message");
                    String string = it.getString("notification_id");
                    this.$listOfNotifications.add(new INotificationRepository.NotificationData(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID), string, it.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA), it.getLong(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME), optString, optString2));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27832(List<Integer> list, List<INotificationRepository.NotificationData> list2, c<? super C27832> cVar) {
            super(2, cVar);
            this.$excludeAndroidIds = list;
            this.$listOfNotifications = list2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27832(this.$excludeAndroidIds, this.$listOfNotifications, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            StringBuilder sbRecentUninteractedWithNotificationsWhere = NotificationRepository.this._queryHelper.recentUninteractedWithNotificationsWhere();
            if (this.$excludeAndroidIds != null) {
                sbRecentUninteractedWithNotificationsWhere.append(" AND android_notification_id NOT IN (");
                sbRecentUninteractedWithNotificationsWhere.append(TextUtils.join(",", this.$excludeAndroidIds));
                sbRecentUninteractedWithNotificationsWhere.append(")");
            }
            IDatabase.DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, NotificationRepository.Companion.getCOLUMNS_FOR_LIST_NOTIFICATIONS(), sbRecentUninteractedWithNotificationsWhere.toString(), null, null, null, "_id DESC", String.valueOf(INotificationLimitManager.Constants.INSTANCE.getMaxNumberOfNotifications()), new AnonymousClass1(this.$listOfNotifications), 56, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27832) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsConsumed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsConsumed$2", f = "NotificationRepository.kt", l = {322}, m = "invokeSuspend")
    public static final class C27842 extends i implements p {
        final /* synthetic */ int $androidId;
        final /* synthetic */ boolean $clearGroupOnSummaryClick;
        final /* synthetic */ boolean $dismissed;
        final /* synthetic */ String $summaryGroup;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27842(String str, boolean z2, boolean z7, NotificationRepository notificationRepository, int i2, c<? super C27842> cVar) {
            super(2, cVar);
            this.$summaryGroup = str;
            this.$dismissed = z2;
            this.$clearGroupOnSummaryClick = z7;
            this.this$0 = notificationRepository;
            this.$androidId = i2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C27842(this.$summaryGroup, this.$dismissed, this.$clearGroupOnSummaryClick, this.this$0, this.$androidId, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r7.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 != r3) goto L14
                boolean r0 = r7.Z$0
                java.lang.Object r1 = r7.L$0
                java.lang.String r1 = (java.lang.String) r1
                r2.q.z0(r8)
                goto L56
            L14:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1c:
                r2.q.z0(r8)
                java.lang.String r8 = r7.$summaryGroup
                r1 = 0
                if (r8 == 0) goto L73
                java.lang.String r4 = "os_group_undefined"
                boolean r8 = kotlin.jvm.internal.k.a(r8, r4)
                if (r8 == 0) goto L32
                java.lang.String r4 = "group_id IS NULL"
            L2e:
                r6 = r4
                r4 = r1
                r1 = r6
                goto L3b
            L32:
                java.lang.String[] r1 = new java.lang.String[r3]
                java.lang.String r4 = r7.$summaryGroup
                r1[r2] = r4
                java.lang.String r4 = "group_id = ?"
                goto L2e
            L3b:
                boolean r5 = r7.$dismissed
                if (r5 != 0) goto L71
                boolean r5 = r7.$clearGroupOnSummaryClick
                if (r5 != 0) goto L71
                com.onesignal.notifications.internal.data.impl.NotificationRepository r4 = r7.this$0
                java.lang.String r5 = r7.$summaryGroup
                r7.L$0 = r1
                r7.Z$0 = r8
                r7.label = r3
                java.lang.Object r4 = r4.getAndroidIdForGroup(r5, r2, r7)
                if (r4 != r0) goto L54
                return r0
            L54:
                r0 = r8
                r8 = r4
            L56:
                java.lang.String r8 = java.lang.String.valueOf(r8)
                java.lang.String r4 = " AND android_notification_id = ?"
                java.lang.String r1 = a1.a.C(r1, r4)
                if (r0 == 0) goto L67
                java.lang.String[] r0 = new java.lang.String[r3]
                r0[r2] = r8
                goto L85
            L67:
                r0 = 2
                java.lang.String[] r0 = new java.lang.String[r0]
                java.lang.String r4 = r7.$summaryGroup
                r0[r2] = r4
                r0[r3] = r8
                goto L85
            L71:
                r0 = r4
                goto L85
            L73:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r0 = "android_notification_id = "
                r8.<init>(r0)
                int r0 = r7.$androidId
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                r0 = r1
                r1 = r8
            L85:
                android.content.ContentValues r8 = new android.content.ContentValues
                r8.<init>()
                boolean r2 = r7.$dismissed
                if (r2 == 0) goto L99
                java.lang.Integer r2 = new java.lang.Integer
                r2.<init>(r3)
                java.lang.String r3 = "dismissed"
                r8.put(r3, r2)
                goto La3
            L99:
                java.lang.Integer r2 = new java.lang.Integer
                r2.<init>(r3)
                java.lang.String r3 = "opened"
                r8.put(r3, r2)
            La3:
                com.onesignal.notifications.internal.data.impl.NotificationRepository r2 = r7.this$0
                com.onesignal.core.internal.database.IDatabaseProvider r2 = com.onesignal.notifications.internal.data.impl.NotificationRepository.access$get_databaseProvider$p(r2)
                com.onesignal.core.internal.database.IDatabase r2 = r2.getOs()
                java.lang.String r3 = "notification"
                r2.update(r3, r8, r1, r0)
                com.onesignal.notifications.internal.data.impl.NotificationRepository r8 = r7.this$0
                com.onesignal.notifications.internal.badges.IBadgeCountUpdater r8 = com.onesignal.notifications.internal.data.impl.NotificationRepository.access$get_badgeCountUpdater$p(r8)
                r8.update()
                q5.x r8 = q5.x.f13520a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.C27842.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27842) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", l = {127}, m = "markAsDismissed")
    public static final class C27851 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C27851(c<? super C27851> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NotificationRepository.this.markAsDismissed(0, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27862 extends i implements p {
        final /* synthetic */ int $androidId;
        final /* synthetic */ w $didDismiss;
        int label;
        final /* synthetic */ NotificationRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27862(w wVar, NotificationRepository notificationRepository, int i2, c<? super C27862> cVar) {
            super(2, cVar);
            this.$didDismiss = wVar;
            this.this$0 = notificationRepository;
            this.$androidId = i2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C27862(this.$didDismiss, this.this$0, this.$androidId, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            this.$didDismiss.f12728a = this.this$0.internalMarkAsDismissed(this.$androidId);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27862) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForGroup$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForGroup$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27872 extends i implements p {
        final /* synthetic */ String $group;
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ NotificationManager $notificationManager;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(NotificationManager notificationManager) {
                super(1);
                this.$notificationManager = notificationManager;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                while (it.moveToNext()) {
                    int i2 = it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID);
                    if (i2 != -1) {
                        this.$notificationManager.cancel(i2);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27872(String str, c<? super C27872> cVar) {
            super(2, cVar);
            this.$group = str;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27872(this.$group, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(NotificationRepository.this._applicationService.getAppContext());
            String[] strArr = {OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID};
            String[] strArr2 = {this.$group};
            IDatabase.DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, strArr, "group_id = ? AND dismissed = 0 AND opened = 0", strArr2, null, null, null, null, new AnonymousClass1(notificationManager), 240, null);
            ContentValues contentValues = new ContentValues();
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, new Integer(1));
            NotificationRepository.this._databaseProvider.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "group_id = ? AND opened = 0 AND dismissed = 0", strArr2);
            NotificationRepository.this._badgeCountUpdater.update();
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27872) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForOutstanding$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForOutstanding$2", f = "NotificationRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27882 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissedForOutstanding$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ NotificationManager $notificationManager;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(NotificationManager notificationManager) {
                super(1);
                this.$notificationManager = notificationManager;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.moveToFirst()) {
                    do {
                        this.$notificationManager.cancel(it.getInt(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
                    } while (it.moveToNext());
                }
            }
        }

        public C27882(c<? super C27882> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return NotificationRepository.this.new C27882(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(NotificationRepository.this._applicationService.getAppContext());
            IDatabase.DefaultImpls.query$default(NotificationRepository.this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, "dismissed = 0 AND opened = 0", null, null, null, null, null, new AnonymousClass1(notificationManager), 248, null);
            ContentValues contentValues = new ContentValues();
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, new Integer(1));
            NotificationRepository.this._databaseProvider.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "opened = 0", null);
            NotificationRepository.this._badgeCountUpdater.updateCount(0);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27882) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public NotificationRepository(IApplicationService _applicationService, INotificationQueryHelper _queryHelper, IDatabaseProvider _databaseProvider, ITime _time, IBadgeCountUpdater _badgeCountUpdater) {
        k.e(_applicationService, "_applicationService");
        k.e(_queryHelper, "_queryHelper");
        k.e(_databaseProvider, "_databaseProvider");
        k.e(_time, "_time");
        k.e(_badgeCountUpdater, "_badgeCountUpdater");
        this._applicationService = _applicationService;
        this._queryHelper = _queryHelper;
        this._databaseProvider = _databaseProvider;
        this._time = _time;
        this._badgeCountUpdater = _badgeCountUpdater;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean internalMarkAsDismissed(int i2) {
        Context appContext = this._applicationService.getAppContext();
        String strH = a1.a.h(i2, "android_notification_id = ", " AND opened = 0 AND dismissed = 0");
        ContentValues contentValues = new ContentValues();
        contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_DISMISSED, (Integer) 1);
        boolean z2 = this._databaseProvider.getOs().update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, strH, null) > 0;
        this._badgeCountUpdater.update();
        NotificationHelper.INSTANCE.getNotificationManager(appContext).cancel(i2);
        return z2;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object clearOldestOverLimitFallback(int i2, int i8, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(i8, this, i2, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object createNotification(String str, String str2, String str3, boolean z2, boolean z7, int i2, String str4, String str5, long j, String str6, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27702(str, z2, i2, this, str2, str3, z7, str4, str5, j, str6, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object createSummaryNotification(int i2, String str, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27712(i2, str, this, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object deleteExpiredNotifications(c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27722(null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doesNotificationExist(java.lang.String r7, v5.c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.w r7 = (kotlin.jvm.internal.w) r7
            r2.q.z0(r8)
            goto L5c
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            if (r7 == 0) goto L63
            java.lang.String r8 = ""
            boolean r8 = r8.equals(r7)
            if (r8 == 0) goto L41
            goto L63
        L41:
            kotlin.jvm.internal.w r8 = new kotlin.jvm.internal.w
            r8.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$doesNotificationExist$2
            r5 = 0
            r4.<init>(r7, r6, r8, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r4, r2, r0)
            if (r7 != r1) goto L5b
            return r1
        L5b:
            r7 = r8
        L5c:
            boolean r7 = r7.f12728a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        L63:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.doesNotificationExist(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getAndroidIdForGroup(java.lang.String r11, boolean r12, v5.c<? super java.lang.Integer> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.C27741
            if (r0 == 0) goto L13
            r0 = r13
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.C27741) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r11 = r0.L$0
            kotlin.jvm.internal.a0 r11 = (kotlin.jvm.internal.a0) r11
            r2.q.z0(r13)
            goto L9f
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            r2.q.z0(r13)
            kotlin.jvm.internal.a0 r8 = new kotlin.jvm.internal.a0
            r8.<init>()
            java.lang.String r13 = "os_group_undefined"
            boolean r13 = kotlin.jvm.internal.k.a(r11, r13)
            kotlin.jvm.internal.a0 r6 = new kotlin.jvm.internal.a0
            r6.<init>()
            if (r13 == 0) goto L4c
            java.lang.String r2 = "group_id IS NULL"
            goto L4e
        L4c:
            java.lang.String r2 = "group_id = ?"
        L4e:
            r6.f12717a = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Object r4 = r6.f12717a
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = " AND dismissed = 0 AND opened = 0 AND "
            java.lang.String r2 = a1.a.r(r2, r4, r5)
            r6.f12717a = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Object r4 = r6.f12717a
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            if (r12 == 0) goto L72
            java.lang.String r12 = "is_summary = 1"
            goto L74
        L72:
            java.lang.String r12 = "is_summary = 0"
        L74:
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r6.f12717a = r12
            if (r13 == 0) goto L82
            r11 = 0
            r7 = r11
            goto L88
        L82:
            java.lang.String[] r12 = new java.lang.String[r3]
            r13 = 0
            r12[r13] = r11
            r7 = r12
        L88:
            x6.e r11 = q6.m0.f13566a
            x6.d r11 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdForGroup$2
            r9 = 0
            r5 = r10
            r4.<init>(r6, r7, r8, r9)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r11 = q6.c0.H(r4, r11, r0)
            if (r11 != r1) goto L9e
            return r1
        L9e:
            r11 = r8
        L9f:
            java.lang.Object r11 = r11.f12717a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdForGroup(java.lang.String, boolean, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getAndroidIdFromCollapseKey(java.lang.String r7, v5.c<? super java.lang.Integer> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.C27761
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.C27761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.a0 r7 = (kotlin.jvm.internal.a0) r7
            r2.q.z0(r8)
            goto L51
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            kotlin.jvm.internal.a0 r8 = new kotlin.jvm.internal.a0
            r8.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getAndroidIdFromCollapseKey$2
            r5 = 0
            r4.<init>(r7, r8, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r4, r2, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = r8
        L51:
            java.lang.Object r7 = r7.f12717a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.getAndroidIdFromCollapseKey(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getGroupId(int r7, v5.c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.C27781
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.C27781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.a0 r7 = (kotlin.jvm.internal.a0) r7
            r2.q.z0(r8)
            goto L51
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            kotlin.jvm.internal.a0 r8 = new kotlin.jvm.internal.a0
            r8.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$getGroupId$2
            r5 = 0
            r4.<init>(r7, r8, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r4, r2, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = r8
        L51:
            java.lang.Object r7 = r7.f12717a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.getGroupId(int, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object listNotificationsForGroup(java.lang.String r7, v5.c<? super java.util.List<com.onesignal.notifications.internal.data.INotificationRepository.NotificationData>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.C27801
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.C27801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            r2.q.z0(r8)
            return r7
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForGroup$2
            r5 = 0
            r4.<init>(r7, r6, r8, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r4, r2, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForGroup(java.lang.String, v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object listNotificationsForOutstanding(java.util.List<java.lang.Integer> r7, v5.c<? super java.util.List<com.onesignal.notifications.internal.data.INotificationRepository.NotificationData>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.C27821
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.C27821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            java.util.List r7 = (java.util.List) r7
            r2.q.z0(r8)
            return r7
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$listNotificationsForOutstanding$2
            r5 = 0
            r4.<init>(r7, r8, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r4, r2, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.listNotificationsForOutstanding(java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsConsumed(int i2, boolean z2, String str, boolean z7, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27842(str, z2, z7, this, i2, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object markAsDismissed(int r7, v5.c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.data.impl.NotificationRepository.C27851
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1 r0 = (com.onesignal.notifications.internal.data.impl.NotificationRepository.C27851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1 r0 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.w r7 = (kotlin.jvm.internal.w) r7
            r2.q.z0(r8)
            goto L51
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            r2.q.z0(r8)
            kotlin.jvm.internal.w r8 = new kotlin.jvm.internal.w
            r8.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$2 r4 = new com.onesignal.notifications.internal.data.impl.NotificationRepository$markAsDismissed$2
            r5 = 0
            r4.<init>(r8, r6, r7, r5)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = q6.c0.H(r4, r2, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r7 = r8
        L51:
            boolean r7 = r7.f12728a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.data.impl.NotificationRepository.markAsDismissed(int, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsDismissedForGroup(String str, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27872(str, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.notifications.internal.data.INotificationRepository
    public Object markAsDismissedForOutstanding(c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27882(null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }
}
