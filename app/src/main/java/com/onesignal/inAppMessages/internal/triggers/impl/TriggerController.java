package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import e2.s;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TriggerController implements ITriggerController, IModelStoreChangeHandler<TriggerModel> {
    private DynamicTriggerController _dynamicTriggerController;
    private final ConcurrentHashMap<String, Object> triggers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Trigger.OSTriggerOperator.values().length];
            iArr[Trigger.OSTriggerOperator.EQUAL_TO.ordinal()] = 1;
            iArr[Trigger.OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 2;
            iArr[Trigger.OSTriggerOperator.EXISTS.ordinal()] = 3;
            iArr[Trigger.OSTriggerOperator.CONTAINS.ordinal()] = 4;
            iArr[Trigger.OSTriggerOperator.NOT_EXISTS.ordinal()] = 5;
            iArr[Trigger.OSTriggerOperator.LESS_THAN.ordinal()] = 6;
            iArr[Trigger.OSTriggerOperator.GREATER_THAN.ordinal()] = 7;
            iArr[Trigger.OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 8;
            iArr[Trigger.OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.triggers.impl.TriggerController$onModelAdded$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ TriggerModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TriggerModel triggerModel) {
            super(1);
            this.$model = triggerModel;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ITriggerHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ITriggerHandler it) {
            k.e(it, "it");
            it.onTriggerChanged(this.$model.getKey());
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.triggers.impl.TriggerController$onModelUpdated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27551 extends l implements e6.l {
        final /* synthetic */ TriggerModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27551(TriggerModel triggerModel) {
            super(1);
            this.$model = triggerModel;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ITriggerHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ITriggerHandler it) {
            k.e(it, "it");
            it.onTriggerChanged(this.$model.getKey());
        }
    }

    public TriggerController(TriggerModelStore triggerModelStore, DynamicTriggerController _dynamicTriggerController) {
        k.e(triggerModelStore, "triggerModelStore");
        k.e(_dynamicTriggerController, "_dynamicTriggerController");
        this._dynamicTriggerController = _dynamicTriggerController;
        this.triggers = new ConcurrentHashMap<>();
        triggerModelStore.subscribe((IModelStoreChangeHandler) this);
    }

    private final void addTriggers(String str, Object obj) {
        synchronized (this.triggers) {
            this.triggers.put(str, obj);
        }
    }

    private final boolean evaluateAndTriggers(List<Trigger> list) {
        Iterator<Trigger> it = list.iterator();
        while (it.hasNext()) {
            if (!evaluateTrigger(it.next())) {
                return false;
            }
        }
        return true;
    }

    private final boolean evaluateTrigger(Trigger trigger) {
        if (trigger.getKind() == Trigger.OSTriggerKind.UNKNOWN) {
            return false;
        }
        if (trigger.getKind() != Trigger.OSTriggerKind.CUSTOM) {
            return this._dynamicTriggerController.dynamicTriggerShouldFire(trigger);
        }
        Trigger.OSTriggerOperator operatorType = trigger.getOperatorType();
        Object obj = this.triggers.get(trigger.getProperty());
        if (obj == null) {
            if (operatorType == Trigger.OSTriggerOperator.NOT_EXISTS) {
                return true;
            }
            return operatorType == Trigger.OSTriggerOperator.NOT_EQUAL_TO && trigger.getValue() != null;
        }
        if (operatorType == Trigger.OSTriggerOperator.EXISTS) {
            return true;
        }
        if (operatorType == Trigger.OSTriggerOperator.NOT_EXISTS) {
            return false;
        }
        if (operatorType == Trigger.OSTriggerOperator.CONTAINS) {
            return (obj instanceof Collection) && ((Collection) obj).contains(trigger.getValue());
        }
        if ((obj instanceof String) && (trigger.getValue() instanceof String)) {
            String str = (String) trigger.getValue();
            k.b(str);
            if (triggerMatchesStringValue(str, (String) obj, operatorType)) {
                return true;
            }
        }
        if ((trigger.getValue() instanceof Number) && (obj instanceof Number)) {
            Number number = (Number) trigger.getValue();
            k.b(number);
            if (triggerMatchesNumericValue(number, (Number) obj, operatorType)) {
                return true;
            }
        }
        return triggerMatchesFlex(trigger.getValue(), obj, operatorType);
    }

    private final void removeTriggersForKeys(String str) {
        synchronized (this.triggers) {
            this.triggers.remove(str);
        }
    }

    private final boolean triggerMatchesFlex(Object obj, Object obj2, Trigger.OSTriggerOperator oSTriggerOperator) {
        if (obj == null) {
            return false;
        }
        if (!oSTriggerOperator.checksEquality()) {
            if ((obj2 instanceof String) && (obj instanceof Number)) {
                return triggerMatchesNumericValueFlex((Number) obj, (String) obj2, oSTriggerOperator);
            }
            return false;
        }
        String string = obj.toString();
        String string2 = obj2.toString();
        if (obj2 instanceof Number) {
            string2 = new DecimalFormat("0.#").format(obj2);
            k.d(string2, "format.format(deviceValue)");
        }
        return triggerMatchesStringValue(string, string2, oSTriggerOperator);
    }

    private final boolean triggerMatchesNumericValue(Number number, Number number2, Trigger.OSTriggerOperator oSTriggerOperator) {
        double dDoubleValue = number.doubleValue();
        double dDoubleValue2 = number2.doubleValue();
        switch (WhenMappings.$EnumSwitchMapping$0[oSTriggerOperator.ordinal()]) {
            case 1:
                return dDoubleValue2 == dDoubleValue;
            case 2:
                return dDoubleValue2 != dDoubleValue;
            case 3:
            case 4:
            case 5:
                Logging.error$default("Attempted to use an invalid operator with a numeric value: " + oSTriggerOperator, null, 2, null);
                return false;
            case 6:
                return dDoubleValue2 < dDoubleValue;
            case 7:
                return dDoubleValue2 > dDoubleValue;
            case 8:
                return dDoubleValue2 < dDoubleValue || dDoubleValue2 == dDoubleValue;
            case 9:
                return dDoubleValue2 > dDoubleValue || dDoubleValue2 == dDoubleValue;
            default:
                throw new s(3);
        }
    }

    private final boolean triggerMatchesNumericValueFlex(Number number, String str, Trigger.OSTriggerOperator oSTriggerOperator) {
        try {
            return triggerMatchesNumericValue(Double.valueOf(number.doubleValue()), Double.valueOf(Double.parseDouble(str)), oSTriggerOperator);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private final boolean triggerMatchesStringValue(String str, String str2, Trigger.OSTriggerOperator oSTriggerOperator) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[oSTriggerOperator.ordinal()];
        if (i2 == 1) {
            return k.a(str, str2);
        }
        if (i2 == 2) {
            return !k.a(str, str2);
        }
        Logging.error$default("Attempted to use an invalid operator for a string trigger comparison: " + oSTriggerOperator, null, 2, null);
        return false;
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerController
    public boolean evaluateMessageTriggers(InAppMessage message) {
        k.e(message, "message");
        if (message.getTriggers().isEmpty()) {
            return true;
        }
        Iterator<List<Trigger>> it = message.getTriggers().iterator();
        while (it.hasNext()) {
            if (evaluateAndTriggers(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this._dynamicTriggerController.getHasSubscribers();
    }

    public final ConcurrentHashMap<String, Object> getTriggers() {
        return this.triggers;
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerController
    public boolean isTriggerOnMessage(InAppMessage message, Collection<String> triggersKeys) {
        k.e(message, "message");
        k.e(triggersKeys, "triggersKeys");
        if (message.getTriggers() == null) {
            return false;
        }
        for (String str : triggersKeys) {
            Iterator<List<Trigger>> it = message.getTriggers().iterator();
            while (it.hasNext()) {
                for (Trigger trigger : it.next()) {
                    if (k.a(str, trigger.getProperty()) || k.a(str, trigger.getTriggerId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerController
    public boolean messageHasOnlyDynamicTriggers(InAppMessage message) {
        k.e(message, "message");
        if (message.getTriggers() == null || message.getTriggers().isEmpty()) {
            return false;
        }
        Iterator<List<Trigger>> it = message.getTriggers().iterator();
        while (it.hasNext()) {
            for (Trigger trigger : it.next()) {
                if (trigger.getKind() == Trigger.OSTriggerKind.CUSTOM || trigger.getKind() == Trigger.OSTriggerKind.UNKNOWN) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
        Model model = args.getModel();
        k.c(model, "null cannot be cast to non-null type com.onesignal.inAppMessages.internal.triggers.TriggerModel");
        TriggerModel triggerModel = (TriggerModel) model;
        addTriggers(triggerModel.getKey(), triggerModel.getValue());
        this._dynamicTriggerController.getEvents().fire(new C27551(triggerModel));
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(TriggerModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        addTriggers(model.getKey(), model.getValue());
        this._dynamicTriggerController.getEvents().fire(new AnonymousClass1(model));
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(TriggerModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        removeTriggersForKeys(model.getKey());
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ITriggerHandler handler) {
        k.e(handler, "handler");
        this._dynamicTriggerController.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ITriggerHandler handler) {
        k.e(handler, "handler");
        this._dynamicTriggerController.unsubscribe(handler);
    }
}
