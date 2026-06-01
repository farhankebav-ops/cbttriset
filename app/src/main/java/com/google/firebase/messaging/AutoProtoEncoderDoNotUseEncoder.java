package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {
        static final MessagingClientEventEncoder INSTANCE = new MessagingClientEventEncoder();
        private static final FieldDescriptor PROJECTNUMBER_DESCRIPTOR = a0.a(1, FieldDescriptor.builder("projectNumber"));
        private static final FieldDescriptor MESSAGEID_DESCRIPTOR = a0.a(2, FieldDescriptor.builder("messageId"));
        private static final FieldDescriptor INSTANCEID_DESCRIPTOR = a0.a(3, FieldDescriptor.builder("instanceId"));
        private static final FieldDescriptor MESSAGETYPE_DESCRIPTOR = a0.a(4, FieldDescriptor.builder("messageType"));
        private static final FieldDescriptor SDKPLATFORM_DESCRIPTOR = a0.a(5, FieldDescriptor.builder("sdkPlatform"));
        private static final FieldDescriptor PACKAGENAME_DESCRIPTOR = a0.a(6, FieldDescriptor.builder("packageName"));
        private static final FieldDescriptor COLLAPSEKEY_DESCRIPTOR = a0.a(7, FieldDescriptor.builder("collapseKey"));
        private static final FieldDescriptor PRIORITY_DESCRIPTOR = a0.a(8, FieldDescriptor.builder(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY));
        private static final FieldDescriptor TTL_DESCRIPTOR = a0.a(9, FieldDescriptor.builder("ttl"));
        private static final FieldDescriptor TOPIC_DESCRIPTOR = a0.a(10, FieldDescriptor.builder("topic"));
        private static final FieldDescriptor BULKID_DESCRIPTOR = a0.a(11, FieldDescriptor.builder("bulkId"));
        private static final FieldDescriptor EVENT_DESCRIPTOR = a0.a(12, FieldDescriptor.builder(NotificationCompat.CATEGORY_EVENT));
        private static final FieldDescriptor ANALYTICSLABEL_DESCRIPTOR = a0.a(13, FieldDescriptor.builder("analyticsLabel"));
        private static final FieldDescriptor CAMPAIGNID_DESCRIPTOR = a0.a(14, FieldDescriptor.builder("campaignId"));
        private static final FieldDescriptor COMPOSERLABEL_DESCRIPTOR = a0.a(15, FieldDescriptor.builder("composerLabel"));

        private MessagingClientEventEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(MessagingClientEvent messagingClientEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(PROJECTNUMBER_DESCRIPTOR, messagingClientEvent.getProjectNumber());
            objectEncoderContext.add(MESSAGEID_DESCRIPTOR, messagingClientEvent.getMessageId());
            objectEncoderContext.add(INSTANCEID_DESCRIPTOR, messagingClientEvent.getInstanceId());
            objectEncoderContext.add(MESSAGETYPE_DESCRIPTOR, messagingClientEvent.getMessageType());
            objectEncoderContext.add(SDKPLATFORM_DESCRIPTOR, messagingClientEvent.getSdkPlatform());
            objectEncoderContext.add(PACKAGENAME_DESCRIPTOR, messagingClientEvent.getPackageName());
            objectEncoderContext.add(COLLAPSEKEY_DESCRIPTOR, messagingClientEvent.getCollapseKey());
            objectEncoderContext.add(PRIORITY_DESCRIPTOR, messagingClientEvent.getPriority());
            objectEncoderContext.add(TTL_DESCRIPTOR, messagingClientEvent.getTtl());
            objectEncoderContext.add(TOPIC_DESCRIPTOR, messagingClientEvent.getTopic());
            objectEncoderContext.add(BULKID_DESCRIPTOR, messagingClientEvent.getBulkId());
            objectEncoderContext.add(EVENT_DESCRIPTOR, messagingClientEvent.getEvent());
            objectEncoderContext.add(ANALYTICSLABEL_DESCRIPTOR, messagingClientEvent.getAnalyticsLabel());
            objectEncoderContext.add(CAMPAIGNID_DESCRIPTOR, messagingClientEvent.getCampaignId());
            objectEncoderContext.add(COMPOSERLABEL_DESCRIPTOR, messagingClientEvent.getComposerLabel());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {
        static final MessagingClientEventExtensionEncoder INSTANCE = new MessagingClientEventExtensionEncoder();
        private static final FieldDescriptor MESSAGINGCLIENTEVENT_DESCRIPTOR = a0.a(1, FieldDescriptor.builder("messagingClientEvent"));

        private MessagingClientEventExtensionEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(MessagingClientEventExtension messagingClientEventExtension, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(MESSAGINGCLIENTEVENT_DESCRIPTOR, messagingClientEventExtension.getMessagingClientEventInternal());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
        static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();
        private static final FieldDescriptor MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR = FieldDescriptor.of("messagingClientEventExtension");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.Encoder
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR, protoEncoderDoNotUse.getMessagingClientEventExtension());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder(MessagingClientEventExtension.class, MessagingClientEventExtensionEncoder.INSTANCE);
        encoderConfig.registerEncoder(MessagingClientEvent.class, MessagingClientEventEncoder.INSTANCE);
    }
}
