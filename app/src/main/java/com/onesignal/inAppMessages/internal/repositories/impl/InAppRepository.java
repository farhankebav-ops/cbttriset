package com.onesignal.inAppMessages.internal.repositories.impl;

import android.content.ContentValues;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import e6.p;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
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
public final class InAppRepository implements IInAppRepository {
    public static final Companion Companion = new Companion(null);
    public static final long IAM_CACHE_DATA_LIFETIME = 15552000;
    private final IDatabaseProvider _databaseProvider;
    private final IInAppPreferencesController _prefs;
    private final ITime _time;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$cleanCachedInAppMessages$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$cleanCachedInAppMessages$2", f = "InAppRepository.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$cleanCachedInAppMessages$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ Set<String> $oldClickedClickIds;
            final /* synthetic */ Set<String> $oldMessageIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Set<String> set, Set<String> set2) {
                super(1);
                this.$oldMessageIds = set;
                this.$oldClickedClickIds = set2;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.getCount() == 0) {
                    Logging.debug$default("Attempted to clean 6 month old IAM data, but none exists!", null, 2, null);
                    return;
                }
                if (it.moveToFirst()) {
                    do {
                        String string = it.getString("message_id");
                        String string2 = it.getString(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS);
                        this.$oldMessageIds.add(string);
                        this.$oldClickedClickIds.addAll(JSONUtils.INSTANCE.newStringSetFromJSONArray(new JSONArray(string2)));
                    } while (it.moveToNext());
                }
            }
        }

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return InAppRepository.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            String[] strArr = {"message_id", OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS};
            String[] strArr2 = {String.valueOf((System.currentTimeMillis() / 1000) - InAppRepository.IAM_CACHE_DATA_LIFETIME)};
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            try {
                IDatabase.DefaultImpls.query$default(InAppRepository.this._databaseProvider.getOs(), OneSignalDbContract.InAppMessageTable.TABLE_NAME, strArr, "last_display < ?", strArr2, null, null, null, null, new AnonymousClass1(linkedHashSet, linkedHashSet2), 240, null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            InAppRepository.this._databaseProvider.getOs().delete(OneSignalDbContract.InAppMessageTable.TABLE_NAME, "last_display < ?", strArr2);
            InAppRepository.this._prefs.cleanInAppMessageIds(linkedHashSet);
            InAppRepository.this._prefs.cleanInAppMessageClickedClickIds(linkedHashSet2);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository", f = "InAppRepository.kt", l = {68}, m = "listInAppMessages")
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
            return InAppRepository.this.listInAppMessages(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2", f = "InAppRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27532 extends i implements p {
        final /* synthetic */ List<InAppMessage> $inAppMessages;
        int label;

        /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ List<InAppMessage> $inAppMessages;
            final /* synthetic */ InAppRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InAppRepository inAppRepository, List<InAppMessage> list) {
                super(1);
                this.this$0 = inAppRepository;
                this.$inAppMessages = list;
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
                        this.$inAppMessages.add(new InAppMessage(it.getString("message_id"), JSONUtils.INSTANCE.newStringSetFromJSONArray(new JSONArray(it.getString(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS))), it.getInt(OneSignalDbContract.InAppMessageTable.COLUMN_DISPLAYED_IN_SESSION) == 1, new InAppMessageRedisplayStats(it.getInt(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_DISPLAY_QUANTITY), it.getLong(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_LAST_DISPLAY), this.this$0._time), this.this$0._time));
                    } while (it.moveToNext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27532(List<InAppMessage> list, c<? super C27532> cVar) {
            super(2, cVar);
            this.$inAppMessages = list;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return InAppRepository.this.new C27532(this.$inAppMessages, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            try {
                IDatabase.DefaultImpls.query$default(InAppRepository.this._databaseProvider.getOs(), OneSignalDbContract.InAppMessageTable.TABLE_NAME, null, null, null, null, null, null, null, new AnonymousClass1(InAppRepository.this, this.$inAppMessages), 254, null);
            } catch (JSONException e) {
                Logging.error("Generating JSONArray from iam click ids:JSON Failed.", e);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27532) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$saveInAppMessage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$saveInAppMessage$2", f = "InAppRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C27542 extends i implements p {
        final /* synthetic */ InAppMessage $inAppMessage;
        final /* synthetic */ ContentValues $values;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27542(ContentValues contentValues, InAppMessage inAppMessage, c<? super C27542> cVar) {
            super(2, cVar);
            this.$values = contentValues;
            this.$inAppMessage = inAppMessage;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return InAppRepository.this.new C27542(this.$values, this.$inAppMessage, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            if (InAppRepository.this._databaseProvider.getOs().update(OneSignalDbContract.InAppMessageTable.TABLE_NAME, this.$values, "message_id = ?", new String[]{this.$inAppMessage.getMessageId()}) == 0) {
                InAppRepository.this._databaseProvider.getOs().insert(OneSignalDbContract.InAppMessageTable.TABLE_NAME, null, this.$values);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C27542) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public InAppRepository(IDatabaseProvider _databaseProvider, ITime _time, IInAppPreferencesController _prefs) {
        k.e(_databaseProvider, "_databaseProvider");
        k.e(_time, "_time");
        k.e(_prefs, "_prefs");
        this._databaseProvider = _databaseProvider;
        this._time = _time;
        this._prefs = _prefs;
    }

    @Override // com.onesignal.inAppMessages.internal.repositories.IInAppRepository
    public Object cleanCachedInAppMessages(c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.inAppMessages.internal.repositories.IInAppRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object listInAppMessages(v5.c<? super java.util.List<com.onesignal.inAppMessages.internal.InAppMessage>> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            r2.q.z0(r7)
            return r0
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            r2.q.z0(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            x6.e r2 = q6.m0.f13566a
            x6.d r2 = x6.d.f17810a
            com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2 r4 = new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2
            r5 = 0
            r4.<init>(r7, r5)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = q6.c0.H(r4, r2, r0)
            if (r0 != r1) goto L50
            return r1
        L50:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages(v5.c):java.lang.Object");
    }

    @Override // com.onesignal.inAppMessages.internal.repositories.IInAppRepository
    public Object saveInAppMessage(InAppMessage inAppMessage, c<? super x> cVar) throws Throwable {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", inAppMessage.getMessageId());
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_DISPLAY_QUANTITY, new Integer(inAppMessage.getRedisplayStats().getDisplayQuantity()));
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_LAST_DISPLAY, new Long(inAppMessage.getRedisplayStats().getLastDisplayTime()));
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS, inAppMessage.getClickedClickIds().toString());
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_DISPLAYED_IN_SESSION, Boolean.valueOf(inAppMessage.isDisplayedInSession()));
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C27542(contentValues, inAppMessage, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }
}
