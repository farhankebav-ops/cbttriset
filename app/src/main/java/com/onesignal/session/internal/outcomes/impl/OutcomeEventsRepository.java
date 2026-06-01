package com.onesignal.session.internal.outcomes.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.Influence;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.migrations.RemoveZeroSessionTimeRecords;
import e6.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import okhttp3.internal.url._UrlKt;
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
public final class OutcomeEventsRepository implements IOutcomeEventsRepository {
    private final IDatabaseProvider _databaseProvider;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InfluenceType.values().length];
            iArr[InfluenceType.DIRECT.ordinal()] = 1;
            iArr[InfluenceType.INDIRECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$cleanCachedUniqueOutcomeEventNotifications$2", f = "OutcomeEventsRepository.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ String $notificationIdColumnName;
        final /* synthetic */ String $notificationTableName;
        int label;
        final /* synthetic */ OutcomeEventsRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, OutcomeEventsRepository outcomeEventsRepository, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$notificationTableName = str;
            this.$notificationIdColumnName = str2;
            this.this$0 = outcomeEventsRepository;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$notificationTableName, this.$notificationIdColumnName, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            StringBuilder sb = new StringBuilder("NOT EXISTS(SELECT NULL FROM ");
            sb.append(this.$notificationTableName);
            sb.append(" n WHERE n.");
            sb.append(this.$notificationIdColumnName);
            sb.append(" = channel_influence_id AND channel_type = \"");
            String string = InfluenceChannel.NOTIFICATION.toString();
            Locale ROOT = Locale.ROOT;
            k.d(ROOT, "ROOT");
            String lowerCase = string.toLowerCase(ROOT);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.this$0._databaseProvider.getOs().delete("cached_unique_outcome", a1.a.r(sb, lowerCase, "\")"), null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$deleteOldOutcomeEvent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$deleteOldOutcomeEvent$2", f = "OutcomeEventsRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28262 extends i implements p {
        final /* synthetic */ OutcomeEventParams $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28262(OutcomeEventParams outcomeEventParams, c<? super C28262> cVar) {
            super(2, cVar);
            this.$event = outcomeEventParams;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OutcomeEventsRepository.this.new C28262(this.$event, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            OutcomeEventsRepository.this._databaseProvider.getOs().delete("outcome", "timestamp = ?", new String[]{String.valueOf(this.$event.getTimestamp())});
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28262) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository", f = "OutcomeEventsRepository.kt", l = {104}, m = "getAllEventsToSend")
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
            return OutcomeEventsRepository.this.getAllEventsToSend(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2", f = "OutcomeEventsRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28272 extends i implements p {
        final /* synthetic */ List<OutcomeEventParams> $events;
        int label;

        /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ List<OutcomeEventParams> $events;
            final /* synthetic */ OutcomeEventsRepository this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(OutcomeEventsRepository outcomeEventsRepository, List<OutcomeEventParams> list) {
                super(1);
                this.this$0 = outcomeEventsRepository;
                this.$events = list;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor cursor) {
                k.e(cursor, "cursor");
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(OutcomeEventsTable.COLUMN_NAME_NOTIFICATION_INFLUENCE_TYPE);
                        InfluenceType.Companion companion = InfluenceType.Companion;
                        InfluenceType influenceTypeFromString = companion.fromString(string);
                        InfluenceType influenceTypeFromString2 = companion.fromString(cursor.getString(OutcomeEventsTable.COLUMN_NAME_IAM_INFLUENCE_TYPE));
                        String optString = cursor.getOptString("notification_ids");
                        if (optString == null) {
                            optString = _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
                        }
                        String optString2 = cursor.getOptString(OutcomeEventsTable.COLUMN_NAME_IAM_IDS);
                        String str = optString2 == null ? _UrlKt.PATH_SEGMENT_ENCODE_SET_URI : optString2;
                        String string2 = cursor.getString("name");
                        float f4 = cursor.getFloat("weight");
                        long j = cursor.getLong("timestamp");
                        long j3 = cursor.getLong("session_time");
                        try {
                            int i2 = 3;
                            OutcomeSourceBody outcomeSourceBody = new OutcomeSourceBody(null, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
                            OutcomeSourceBody outcomeSourceBody2 = new OutcomeSourceBody(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
                            OutcomeSource notificationInfluenceSource = this.this$0.getNotificationInfluenceSource(influenceTypeFromString, outcomeSourceBody, outcomeSourceBody2, optString);
                            this.this$0.getIAMInfluenceSource(influenceTypeFromString2, outcomeSourceBody, outcomeSourceBody2, str, notificationInfluenceSource);
                            if (notificationInfluenceSource == null) {
                                notificationInfluenceSource = new OutcomeSource(null, null);
                            }
                            this.$events.add(new OutcomeEventParams(string2, notificationInfluenceSource, f4, j3, j));
                        } catch (JSONException e) {
                            Logging.error("Generating JSONArray from notifications ids outcome:JSON Failed.", e);
                        }
                    } while (cursor.moveToNext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28272(List<OutcomeEventParams> list, c<? super C28272> cVar) {
            super(2, cVar);
            this.$events = list;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OutcomeEventsRepository.this.new C28272(this.$events, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            RemoveZeroSessionTimeRecords.INSTANCE.run(OutcomeEventsRepository.this._databaseProvider);
            IDatabase.DefaultImpls.query$default(OutcomeEventsRepository.this._databaseProvider.getOs(), "outcome", null, null, null, null, null, null, null, new AnonymousClass1(OutcomeEventsRepository.this, this.$events), 254, null);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28272) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository", f = "OutcomeEventsRepository.kt", l = {286}, m = "getNotCachedUniqueInfluencesForOutcome")
    public static final class C28281 extends x5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C28281(c<? super C28281> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OutcomeEventsRepository.this.getNotCachedUniqueInfluencesForOutcome(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2", f = "OutcomeEventsRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28292 extends i implements p {
        final /* synthetic */ List<Influence> $influences;
        final /* synthetic */ String $name;
        final /* synthetic */ List<Influence> $uniqueInfluences;
        int label;
        final /* synthetic */ OutcomeEventsRepository this$0;

        /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class AnonymousClass1 extends l implements e6.l {
            final /* synthetic */ JSONArray $availableInfluenceIds;
            final /* synthetic */ String $channelInfluenceId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(JSONArray jSONArray, String str) {
                super(1);
                this.$availableInfluenceIds = jSONArray;
                this.$channelInfluenceId = str;
            }

            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ICursor) obj);
                return x.f13520a;
            }

            public final void invoke(ICursor it) {
                k.e(it, "it");
                if (it.getCount() == 0) {
                    this.$availableInfluenceIds.put(this.$channelInfluenceId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28292(List<Influence> list, String str, OutcomeEventsRepository outcomeEventsRepository, List<Influence> list2, c<? super C28292> cVar) {
            super(2, cVar);
            this.$influences = list;
            this.$name = str;
            this.this$0 = outcomeEventsRepository;
            this.$uniqueInfluences = list2;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C28292(this.$influences, this.$name, this.this$0, this.$uniqueInfluences, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            try {
                for (Influence influence : this.$influences) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray ids = influence.getIds();
                    if (ids != null) {
                        int length = ids.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            String string = ids.getString(i2);
                            IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), "cached_unique_outcome", new String[0], "channel_influence_id = ? AND channel_type = ? AND name = ?", new String[]{string, influence.getInfluenceChannel().toString(), this.$name}, null, null, null, "1", new AnonymousClass1(jSONArray, string), 112, null);
                        }
                        if (jSONArray.length() > 0) {
                            Influence influenceCopy = influence.copy();
                            influenceCopy.setIds(jSONArray);
                            this.$uniqueInfluences.add(influenceCopy);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28292) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveOutcomeEvent$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveOutcomeEvent$2", f = "OutcomeEventsRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28302 extends i implements p {
        final /* synthetic */ OutcomeEventParams $eventParams;
        int label;
        final /* synthetic */ OutcomeEventsRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28302(OutcomeEventParams outcomeEventParams, OutcomeEventsRepository outcomeEventsRepository, c<? super C28302> cVar) {
            super(2, cVar);
            this.$eventParams = outcomeEventParams;
            this.this$0 = outcomeEventsRepository;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C28302(this.$eventParams, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            InfluenceType influenceType;
            OutcomeSourceBody indirectBody;
            OutcomeSourceBody directBody;
            InfluenceType influenceType2;
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            InfluenceType influenceType3 = InfluenceType.UNATTRIBUTED;
            OutcomeSource outcomeSource = this.$eventParams.getOutcomeSource();
            if (outcomeSource == null || (directBody = outcomeSource.getDirectBody()) == null) {
                influenceType = influenceType3;
            } else {
                JSONArray notificationIds = directBody.getNotificationIds();
                if (notificationIds == null || notificationIds.length() <= 0) {
                    influenceType2 = influenceType3;
                } else {
                    influenceType2 = InfluenceType.DIRECT;
                    jSONArray = notificationIds;
                }
                JSONArray inAppMessagesIds = directBody.getInAppMessagesIds();
                if (inAppMessagesIds != null && inAppMessagesIds.length() > 0) {
                    influenceType3 = InfluenceType.DIRECT;
                    jSONArray2 = inAppMessagesIds;
                }
                influenceType = influenceType3;
                influenceType3 = influenceType2;
            }
            OutcomeSource outcomeSource2 = this.$eventParams.getOutcomeSource();
            if (outcomeSource2 != null && (indirectBody = outcomeSource2.getIndirectBody()) != null) {
                JSONArray notificationIds2 = indirectBody.getNotificationIds();
                if (notificationIds2 != null && notificationIds2.length() > 0) {
                    influenceType3 = InfluenceType.INDIRECT;
                    jSONArray = notificationIds2;
                }
                JSONArray inAppMessagesIds2 = indirectBody.getInAppMessagesIds();
                if (inAppMessagesIds2 != null && inAppMessagesIds2.length() > 0) {
                    influenceType = InfluenceType.INDIRECT;
                    jSONArray2 = inAppMessagesIds2;
                }
            }
            ContentValues contentValues = new ContentValues();
            OutcomeEventParams outcomeEventParams = this.$eventParams;
            contentValues.put("notification_ids", jSONArray.toString());
            contentValues.put(OutcomeEventsTable.COLUMN_NAME_IAM_IDS, jSONArray2.toString());
            String string = influenceType3.toString();
            Locale ROOT = Locale.ROOT;
            k.d(ROOT, "ROOT");
            String lowerCase = string.toLowerCase(ROOT);
            k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            contentValues.put(OutcomeEventsTable.COLUMN_NAME_NOTIFICATION_INFLUENCE_TYPE, lowerCase);
            String string2 = influenceType.toString();
            k.d(ROOT, "ROOT");
            String lowerCase2 = string2.toLowerCase(ROOT);
            k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            contentValues.put(OutcomeEventsTable.COLUMN_NAME_IAM_INFLUENCE_TYPE, lowerCase2);
            contentValues.put("name", outcomeEventParams.getOutcomeId());
            contentValues.put("weight", new Float(outcomeEventParams.getWeight()));
            contentValues.put("timestamp", new Long(outcomeEventParams.getTimestamp()));
            contentValues.put("session_time", new Long(outcomeEventParams.getSessionTime()));
            this.this$0._databaseProvider.getOs().insert("outcome", null, contentValues);
            return contentValues;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super ContentValues> cVar) {
            return ((C28302) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveUniqueOutcomeEventParams$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$saveUniqueOutcomeEventParams$2", f = "OutcomeEventsRepository.kt", l = {}, m = "invokeSuspend")
    public static final class C28312 extends i implements p {
        final /* synthetic */ OutcomeEventParams $eventParams;
        int label;
        final /* synthetic */ OutcomeEventsRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28312(OutcomeEventParams outcomeEventParams, OutcomeEventsRepository outcomeEventsRepository, c<? super C28312> cVar) {
            super(2, cVar);
            this.$eventParams = outcomeEventParams;
            this.this$0 = outcomeEventsRepository;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new C28312(this.$eventParams, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            String outcomeId = this.$eventParams.getOutcomeId();
            ArrayList arrayList = new ArrayList();
            OutcomeSource outcomeSource = this.$eventParams.getOutcomeSource();
            OutcomeSourceBody directBody = outcomeSource != null ? outcomeSource.getDirectBody() : null;
            OutcomeSource outcomeSource2 = this.$eventParams.getOutcomeSource();
            OutcomeSourceBody indirectBody = outcomeSource2 != null ? outcomeSource2.getIndirectBody() : null;
            this.this$0.addIdsToListFromSource(arrayList, directBody);
            this.this$0.addIdsToListFromSource(arrayList, indirectBody);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                CachedUniqueOutcome cachedUniqueOutcome = (CachedUniqueOutcome) obj2;
                ContentValues contentValues = new ContentValues();
                contentValues.put("channel_influence_id", cachedUniqueOutcome.getInfluenceId());
                contentValues.put("channel_type", cachedUniqueOutcome.getChannel().toString());
                contentValues.put("name", outcomeId);
                this.this$0._databaseProvider.getOs().insert("cached_unique_outcome", null, contentValues);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((C28312) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OutcomeEventsRepository(IDatabaseProvider _databaseProvider) {
        k.e(_databaseProvider, "_databaseProvider");
        this._databaseProvider = _databaseProvider;
    }

    private final void addIdToListFromChannel(List<CachedUniqueOutcome> list, JSONArray jSONArray, InfluenceChannel influenceChannel) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    String influenceId = jSONArray.getString(i2);
                    k.d(influenceId, "influenceId");
                    list.add(new CachedUniqueOutcome(influenceId, influenceChannel));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addIdsToListFromSource(List<CachedUniqueOutcome> list, OutcomeSourceBody outcomeSourceBody) {
        if (outcomeSourceBody != null) {
            JSONArray inAppMessagesIds = outcomeSourceBody.getInAppMessagesIds();
            JSONArray notificationIds = outcomeSourceBody.getNotificationIds();
            addIdToListFromChannel(list, inAppMessagesIds, InfluenceChannel.IAM);
            addIdToListFromChannel(list, notificationIds, InfluenceChannel.NOTIFICATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutcomeSource getIAMInfluenceSource(InfluenceType influenceType, OutcomeSourceBody outcomeSourceBody, OutcomeSourceBody outcomeSourceBody2, String str, OutcomeSource outcomeSource) {
        OutcomeSource directBody;
        OutcomeSource indirectBody;
        int i2 = WhenMappings.$EnumSwitchMapping$0[influenceType.ordinal()];
        if (i2 == 1) {
            outcomeSourceBody.setInAppMessagesIds(new JSONArray(str));
            return (outcomeSource == null || (directBody = outcomeSource.setDirectBody(outcomeSourceBody)) == null) ? new OutcomeSource(outcomeSourceBody, null) : directBody;
        }
        if (i2 != 2) {
            return outcomeSource;
        }
        outcomeSourceBody2.setInAppMessagesIds(new JSONArray(str));
        return (outcomeSource == null || (indirectBody = outcomeSource.setIndirectBody(outcomeSourceBody2)) == null) ? new OutcomeSource(null, outcomeSourceBody2) : indirectBody;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutcomeSource getNotificationInfluenceSource(InfluenceType influenceType, OutcomeSourceBody outcomeSourceBody, OutcomeSourceBody outcomeSourceBody2, String str) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[influenceType.ordinal()];
        if (i2 == 1) {
            outcomeSourceBody.setNotificationIds(new JSONArray(str));
            return new OutcomeSource(outcomeSourceBody, null);
        }
        if (i2 != 2) {
            return null;
        }
        outcomeSourceBody2.setNotificationIds(new JSONArray(str));
        return new OutcomeSource(null, outcomeSourceBody2);
    }

    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object cleanCachedUniqueOutcomeEventNotifications(c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(OneSignalDbContract.NotificationTable.TABLE_NAME, "notification_id", this, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object deleteOldOutcomeEvent(OutcomeEventParams outcomeEventParams, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C28262(outcomeEventParams, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getAllEventsToSend(v5.c<? super java.util.List<com.onesignal.session.internal.outcomes.impl.OutcomeEventParams>> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$1
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
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2 r4 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getAllEventsToSend$2
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
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getAllEventsToSend(v5.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getNotCachedUniqueInfluencesForOutcome(java.lang.String r11, java.util.List<com.onesignal.session.internal.influence.Influence> r12, v5.c<? super java.util.List<com.onesignal.session.internal.influence.Influence>> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.C28281
            if (r0 == 0) goto L13
            r0 = r13
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1 r0 = (com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.C28281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1 r0 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r11 = r0.L$0
            java.util.List r11 = (java.util.List) r11
            r2.q.z0(r13)
            return r11
        L2b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L33:
            r2.q.z0(r13)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            x6.e r13 = q6.m0.f13566a
            x6.d r13 = x6.d.f17810a
            com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2 r4 = new com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository$getNotCachedUniqueInfluencesForOutcome$2
            r9 = 0
            r7 = r10
            r6 = r11
            r5 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r11 = q6.c0.H(r4, r13, r0)
            if (r11 != r1) goto L53
            return r1
        L53:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository.getNotCachedUniqueInfluencesForOutcome(java.lang.String, java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object saveOutcomeEvent(OutcomeEventParams outcomeEventParams, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C28302(outcomeEventParams, this, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository
    public Object saveUniqueOutcomeEventParams(OutcomeEventParams outcomeEventParams, c<? super x> cVar) throws Throwable {
        Logging.debug$default("OutcomeEventsCache.saveUniqueOutcomeEventParams(eventParams: " + outcomeEventParams + ')', null, 2, null);
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new C28312(outcomeEventParams, this, null), d.f17810a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }
}
