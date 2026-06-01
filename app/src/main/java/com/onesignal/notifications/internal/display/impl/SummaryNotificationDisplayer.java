package com.onesignal.notifications.internal.display.impl;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.INotificationDisplayBuilder;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.vungle.ads.internal.protos.Sdk;
import java.security.SecureRandom;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import q5.x;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SummaryNotificationDisplayer implements ISummaryNotificationDisplayer {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationDisplayBuilder _notificationDisplayBuilder;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createGrouplessSummaryNotification$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer", f = "SummaryNotificationDisplayer.kt", l = {267}, m = "createGrouplessSummaryNotification")
    public static final class AnonymousClass1 extends c {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SummaryNotificationDisplayer.this.createGrouplessSummaryNotification(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer$createSummaryNotification$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer", f = "SummaryNotificationDisplayer.kt", l = {111, 116, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE}, m = "createSummaryNotification")
    public static final class C27891 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C27891(v5.c<? super C27891> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SummaryNotificationDisplayer.this.createSummaryNotification(null, null, 0, this);
        }
    }

    public SummaryNotificationDisplayer(IApplicationService _applicationService, INotificationRepository _dataController, INotificationDisplayBuilder _notificationDisplayBuilder) {
        k.e(_applicationService, "_applicationService");
        k.e(_dataController, "_dataController");
        k.e(_notificationDisplayBuilder, "_notificationDisplayBuilder");
        this._applicationService = _applicationService;
        this._dataController = _dataController;
        this._notificationDisplayBuilder = _notificationDisplayBuilder;
    }

    private final Intent createBaseSummaryIntent(int i2, IntentGeneratorForAttachingToNotifications intentGeneratorForAttachingToNotifications, JSONObject jSONObject, String str) {
        Intent intentPutExtra = intentGeneratorForAttachingToNotifications.getNewBaseIntent(i2).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString()).putExtra("summary", str);
        k.d(intentPutExtra, "intentGenerator.getNewBa…utExtra(\"summary\", group)");
        return intentPutExtra;
    }

    private final Context getCurrentContext() {
        return this._applicationService.getAppContext();
    }

    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public void createGenericPendingIntentsForGroup(NotificationCompat.Builder builder, IntentGeneratorForAttachingToNotifications intentGenerator, JSONObject gcmBundle, String group, int i2) {
        k.e(intentGenerator, "intentGenerator");
        k.e(gcmBundle, "gcmBundle");
        k.e(group, "group");
        SecureRandom secureRandom = new SecureRandom();
        int iNextInt = secureRandom.nextInt();
        Intent intentPutExtra = intentGenerator.getNewBaseIntent(i2).putExtra(NotificationConstants.BUNDLE_KEY_ONESIGNAL_DATA, gcmBundle.toString()).putExtra("grp", group);
        k.d(intentPutExtra, "intentGenerator.getNewBa…)).putExtra(\"grp\", group)");
        PendingIntent newActionPendingIntent = intentGenerator.getNewActionPendingIntent(iNextInt, intentPutExtra);
        k.b(builder);
        builder.setContentIntent(newActionPendingIntent);
        INotificationDisplayBuilder iNotificationDisplayBuilder = this._notificationDisplayBuilder;
        int iNextInt2 = secureRandom.nextInt();
        Intent intentPutExtra2 = this._notificationDisplayBuilder.getNewBaseDismissIntent(i2).putExtra("grp", group);
        k.d(intentPutExtra2, "_notificationDisplayBuil…d).putExtra(\"grp\", group)");
        builder.setDeleteIntent(iNotificationDisplayBuilder.getNewDismissActionPendingIntent(iNextInt2, intentPutExtra2));
        builder.setGroup(group);
        try {
            builder.setGroupAlertBehavior(this._notificationDisplayBuilder.getGroupAlertBehavior());
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    @androidx.annotation.RequiresApi(api = 23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createGrouplessSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r10, com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications r11, int r12, int r13, v5.c<? super q5.x> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createGrouplessSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, com.onesignal.notifications.internal.display.impl.IntentGeneratorForAttachingToNotifications, int, int, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationJob, NotificationCompat.Builder builder) {
        k.e(notificationJob, "notificationJob");
        boolean z2 = Build.VERSION.SDK_INT < 24 && !notificationJob.isRestoring();
        if (z2 && notificationJob.getOverriddenSound() != null) {
            Uri overriddenSound = notificationJob.getOverriddenSound();
            k.b(overriddenSound);
            if (!overriddenSound.equals(notificationJob.getOrgSound())) {
                k.b(builder);
                builder.setSound(null);
            }
        }
        k.b(builder);
        Notification notificationBuild = builder.build();
        k.d(notificationBuild, "notifBuilder!!.build()");
        if (z2) {
            builder.setSound(notificationJob.getOverriddenSound());
        }
        return notificationBuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023b A[EDGE_INSN: B:112:0x023b->B:54:0x023b BREAK  A[LOOP:0: B:35:0x01cc->B:116:0x01cc], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
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
    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob r25, com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder.OneSignalNotificationBuilder r26, int r27, v5.c<? super q5.x> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer.createSummaryNotification(com.onesignal.notifications.internal.common.NotificationGenerationJob, com.onesignal.notifications.internal.display.impl.NotificationDisplayBuilder$OneSignalNotificationBuilder, int, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer
    public Object updateSummaryNotification(NotificationGenerationJob notificationGenerationJob, v5.c<? super x> cVar) throws Throwable {
        Object objCreateSummaryNotification = createSummaryNotification(notificationGenerationJob, null, this._notificationDisplayBuilder.getGroupAlertBehavior(), cVar);
        return objCreateSummaryNotification == a.f17774a ? objCreateSummaryNotification : x.f13520a;
    }
}
