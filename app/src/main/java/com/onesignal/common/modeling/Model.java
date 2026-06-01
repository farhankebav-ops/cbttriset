package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import e6.a;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n6.t;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Model implements IEventNotifier<IModelChangedHandler> {
    private Model _parentModel;
    private final String _parentProperty;
    private final EventProducer<IModelChangedHandler> changeNotifier;
    private final Map<String, Object> data;

    /* JADX INFO: renamed from: com.onesignal.common.modeling.Model$notifyChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ ModelChangedArgs $changeArgs;
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelChangedArgs modelChangedArgs, String str) {
            super(1);
            this.$changeArgs = modelChangedArgs;
            this.$tag = str;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IModelChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IModelChangedHandler it) {
            k.e(it, "it");
            it.onChanged(this.$changeArgs, this.$tag);
        }
    }

    public Model() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Object getAnyProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnyProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getAnyProperty(str, aVar);
    }

    public static /* synthetic */ BigDecimal getBigDecimalProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBigDecimalProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getBigDecimalProperty(str, aVar);
    }

    public static /* synthetic */ boolean getBooleanProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBooleanProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getBooleanProperty(str, aVar);
    }

    public static /* synthetic */ double getDoubleProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDoubleProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getDoubleProperty(str, aVar);
    }

    public static /* synthetic */ float getFloatProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getFloatProperty(str, aVar);
    }

    public static /* synthetic */ int getIntProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getIntProperty(str, aVar);
    }

    public static /* synthetic */ List getListProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getListProperty(str, aVar);
    }

    public static /* synthetic */ long getLongProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLongProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getLongProperty(str, aVar);
    }

    public static /* synthetic */ MapModel getMapModelProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMapModelProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getMapModelProperty(str, aVar);
    }

    public static /* synthetic */ Object getOptAnyProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptAnyProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptAnyProperty(str, aVar);
    }

    public static /* synthetic */ BigDecimal getOptBigDecimalProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBigDecimalProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptBigDecimalProperty(str, aVar);
    }

    public static /* synthetic */ Boolean getOptBooleanProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBooleanProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptBooleanProperty(str, aVar);
    }

    public static /* synthetic */ Double getOptDoubleProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptDoubleProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptDoubleProperty(str, aVar);
    }

    public static /* synthetic */ Float getOptFloatProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptFloatProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptFloatProperty(str, aVar);
    }

    public static /* synthetic */ Integer getOptIntProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptIntProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptIntProperty(str, aVar);
    }

    public static /* synthetic */ List getOptListProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptListProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptListProperty(str, aVar);
    }

    public static /* synthetic */ Long getOptLongProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptLongProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptLongProperty(str, aVar);
    }

    public static /* synthetic */ MapModel getOptMapModelProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptMapModelProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptMapModelProperty(str, aVar);
    }

    public static /* synthetic */ String getOptStringProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptStringProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getOptStringProperty(str, aVar);
    }

    public static /* synthetic */ String getStringProperty$default(Model model, String str, a aVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringProperty");
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        return model.getStringProperty(str, aVar);
    }

    private final void notifyChanged(String str, String str2, String str3, Object obj, Object obj2) {
        this.changeNotifier.fire(new AnonymousClass1(new ModelChangedArgs(this, str, str2, obj, obj2), str3));
        if (this._parentModel != null) {
            String str4 = this._parentProperty + '.' + str;
            Model model = this._parentModel;
            k.b(model);
            model.notifyChanged(str4, str2, str3, obj, obj2);
        }
    }

    public static /* synthetic */ void setAnyProperty$default(Model model, String str, Object obj, String str2, boolean z2, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAnyProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setAnyProperty(str, obj, str2, z2);
    }

    public static /* synthetic */ void setBigDecimalProperty$default(Model model, String str, BigDecimal bigDecimal, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBigDecimalProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setBigDecimalProperty(str, bigDecimal, str2, z2);
    }

    public static /* synthetic */ void setBooleanProperty$default(Model model, String str, boolean z2, String str2, boolean z7, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBooleanProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z7 = false;
        }
        model.setBooleanProperty(str, z2, str2, z7);
    }

    public static /* synthetic */ void setDoubleProperty$default(Model model, String str, double d8, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDoubleProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setDoubleProperty(str, d8, str3, z2);
    }

    public static /* synthetic */ void setEnumProperty$default(Model model, String name, Enum value, String tag, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnumProperty");
        }
        if ((i2 & 4) != 0) {
            tag = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        model.setOptAnyProperty(name, value.toString(), tag, z2);
    }

    public static /* synthetic */ void setFloatProperty$default(Model model, String str, float f4, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFloatProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setFloatProperty(str, f4, str2, z2);
    }

    public static /* synthetic */ void setIntProperty$default(Model model, String str, int i2, String str2, boolean z2, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIntProperty");
        }
        if ((i8 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i8 & 8) != 0) {
            z2 = false;
        }
        model.setIntProperty(str, i2, str2, z2);
    }

    public static /* synthetic */ void setListProperty$default(Model model, String str, List list, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setListProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setListProperty(str, list, str2, z2);
    }

    public static /* synthetic */ void setLongProperty$default(Model model, String str, long j, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLongProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setLongProperty(str, j, str3, z2);
    }

    public static /* synthetic */ void setMapModelProperty$default(Model model, String str, MapModel mapModel, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMapModelProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setMapModelProperty(str, mapModel, str2, z2);
    }

    public static /* synthetic */ void setOptAnyProperty$default(Model model, String str, Object obj, String str2, boolean z2, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptAnyProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptAnyProperty(str, obj, str2, z2);
    }

    public static /* synthetic */ void setOptBigDecimalProperty$default(Model model, String str, BigDecimal bigDecimal, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBigDecimalProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptBigDecimalProperty(str, bigDecimal, str2, z2);
    }

    public static /* synthetic */ void setOptBooleanProperty$default(Model model, String str, Boolean bool, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBooleanProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptBooleanProperty(str, bool, str2, z2);
    }

    public static /* synthetic */ void setOptDoubleProperty$default(Model model, String str, Double d8, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptDoubleProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptDoubleProperty(str, d8, str2, z2);
    }

    public static /* synthetic */ void setOptEnumProperty$default(Model model, String name, Enum r22, String tag, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptEnumProperty");
        }
        if ((i2 & 4) != 0) {
            tag = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        k.e(name, "name");
        k.e(tag, "tag");
        model.setOptAnyProperty(name, r22 != null ? r22.toString() : null, tag, z2);
    }

    public static /* synthetic */ void setOptFloatProperty$default(Model model, String str, Float f4, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptFloatProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptFloatProperty(str, f4, str2, z2);
    }

    public static /* synthetic */ void setOptIntProperty$default(Model model, String str, Integer num, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptIntProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptIntProperty(str, num, str2, z2);
    }

    public static /* synthetic */ void setOptListProperty$default(Model model, String str, List list, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptListProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptListProperty(str, list, str2, z2);
    }

    public static /* synthetic */ void setOptLongProperty$default(Model model, String str, Long l, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptLongProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptLongProperty(str, l, str2, z2);
    }

    public static /* synthetic */ void setOptMapModelProperty$default(Model model, String str, MapModel mapModel, String str2, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptMapModelProperty");
        }
        if ((i2 & 4) != 0) {
            str2 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptMapModelProperty(str, mapModel, str2, z2);
    }

    public static /* synthetic */ void setOptStringProperty$default(Model model, String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptStringProperty");
        }
        if ((i2 & 4) != 0) {
            str3 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setOptStringProperty(str, str2, str3, z2);
    }

    public static /* synthetic */ void setStringProperty$default(Model model, String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStringProperty");
        }
        if ((i2 & 4) != 0) {
            str3 = ModelChangeTags.NORMAL;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        model.setStringProperty(str, str2, str3, z2);
    }

    public List<?> createListForProperty(String property, JSONArray jsonArray) {
        k.e(property, "property");
        k.e(jsonArray, "jsonArray");
        return null;
    }

    public Model createModelForProperty(String property, JSONObject jsonObject) {
        k.e(property, "property");
        k.e(jsonObject, "jsonObject");
        return null;
    }

    public final Object getAnyProperty(String name, a aVar) {
        k.e(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, aVar);
        k.c(optAnyProperty, "null cannot be cast to non-null type kotlin.Any");
        return optAnyProperty;
    }

    public final BigDecimal getBigDecimalProperty(String name, a aVar) {
        k.e(name, "name");
        BigDecimal optBigDecimalProperty = getOptBigDecimalProperty(name, aVar);
        k.c(optBigDecimalProperty, "null cannot be cast to non-null type java.math.BigDecimal");
        return optBigDecimalProperty;
    }

    public final boolean getBooleanProperty(String name, a aVar) {
        k.e(name, "name");
        Boolean optBooleanProperty = getOptBooleanProperty(name, aVar);
        k.c(optBooleanProperty, "null cannot be cast to non-null type kotlin.Boolean");
        return optBooleanProperty.booleanValue();
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final double getDoubleProperty(String name, a aVar) {
        k.e(name, "name");
        Double optDoubleProperty = getOptDoubleProperty(name, aVar);
        k.c(optDoubleProperty, "null cannot be cast to non-null type kotlin.Double");
        return optDoubleProperty.doubleValue();
    }

    public final <T extends Enum<T>> T getEnumProperty(String name) {
        k.e(name, "name");
        if (getOptAnyProperty$default(this, name, null, 2, null) == null) {
            k.k();
            throw null;
        }
        k.k();
        throw null;
    }

    public final float getFloatProperty(String name, a aVar) {
        k.e(name, "name");
        Float optFloatProperty = getOptFloatProperty(name, aVar);
        k.c(optFloatProperty, "null cannot be cast to non-null type kotlin.Float");
        return optFloatProperty.floatValue();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeNotifier.getHasSubscribers();
    }

    public final String getId() {
        return getStringProperty$default(this, "id", null, 2, null);
    }

    public final int getIntProperty(String name, a aVar) {
        k.e(name, "name");
        Integer optIntProperty = getOptIntProperty(name, aVar);
        k.c(optIntProperty, "null cannot be cast to non-null type kotlin.Int");
        return optIntProperty.intValue();
    }

    public final <T> List<T> getListProperty(String name, a aVar) {
        k.e(name, "name");
        List<T> optListProperty = getOptListProperty(name, aVar);
        k.c(optListProperty, "null cannot be cast to non-null type kotlin.collections.List<T of com.onesignal.common.modeling.Model.getListProperty>");
        return optListProperty;
    }

    public final long getLongProperty(String name, a aVar) {
        k.e(name, "name");
        Long optLongProperty = getOptLongProperty(name, aVar);
        k.c(optLongProperty, "null cannot be cast to non-null type kotlin.Long");
        return optLongProperty.longValue();
    }

    public final <T> MapModel<T> getMapModelProperty(String name, a aVar) {
        k.e(name, "name");
        MapModel<T> optMapModelProperty = getOptMapModelProperty(name, aVar);
        k.c(optMapModelProperty, "null cannot be cast to non-null type com.onesignal.common.modeling.MapModel<T of com.onesignal.common.modeling.Model.getMapModelProperty>");
        return optMapModelProperty;
    }

    public final Object getOptAnyProperty(String name, a aVar) {
        Object objInvoke;
        k.e(name, "name");
        synchronized (this.data) {
            try {
                if (this.data.containsKey(name) || aVar == null) {
                    objInvoke = this.data.get(name);
                } else {
                    objInvoke = aVar.invoke();
                    this.data.put(name, objInvoke);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objInvoke;
    }

    public final BigDecimal getOptBigDecimalProperty(String name, a aVar) {
        k.e(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, aVar);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Integer ? new BigDecimal(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Long ? new BigDecimal(((Number) optAnyProperty).longValue()) : optAnyProperty instanceof Float ? new BigDecimal(((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Double ? new BigDecimal(((Number) optAnyProperty).doubleValue()) : optAnyProperty instanceof String ? new BigDecimal((String) optAnyProperty) : (BigDecimal) optAnyProperty;
    }

    public final Boolean getOptBooleanProperty(String name, a aVar) {
        k.e(name, "name");
        return (Boolean) getOptAnyProperty(name, aVar);
    }

    public final Double getOptDoubleProperty(String name, a aVar) {
        k.e(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, aVar);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Double ? (Double) optAnyProperty : optAnyProperty instanceof Float ? Double.valueOf(((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Integer ? Double.valueOf(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Long ? Double.valueOf(((Number) optAnyProperty).longValue()) : (Double) optAnyProperty;
    }

    public final <T extends Enum<T>> T getOptEnumProperty(String name) {
        k.e(name, "name");
        if (getOptAnyProperty$default(this, name, null, 2, null) == null) {
            return null;
        }
        k.k();
        throw null;
    }

    public final Float getOptFloatProperty(String name, a aVar) {
        k.e(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, aVar);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Float ? (Float) optAnyProperty : optAnyProperty instanceof Double ? Float.valueOf((float) ((Number) optAnyProperty).doubleValue()) : optAnyProperty instanceof Integer ? Float.valueOf(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Long ? Float.valueOf(((Number) optAnyProperty).longValue()) : (Float) optAnyProperty;
    }

    public final Integer getOptIntProperty(String name, a aVar) {
        k.e(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, aVar);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Integer ? (Integer) optAnyProperty : optAnyProperty instanceof Long ? Integer.valueOf((int) ((Number) optAnyProperty).longValue()) : optAnyProperty instanceof Float ? Integer.valueOf((int) ((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Double ? Integer.valueOf((int) ((Number) optAnyProperty).doubleValue()) : (Integer) optAnyProperty;
    }

    public final <T> List<T> getOptListProperty(String name, a aVar) {
        k.e(name, "name");
        return (List) getOptAnyProperty(name, aVar);
    }

    public final Long getOptLongProperty(String name, a aVar) {
        k.e(name, "name");
        Object optAnyProperty = getOptAnyProperty(name, aVar);
        if (optAnyProperty == null) {
            return null;
        }
        return optAnyProperty instanceof Long ? (Long) optAnyProperty : optAnyProperty instanceof Integer ? Long.valueOf(((Number) optAnyProperty).intValue()) : optAnyProperty instanceof Float ? Long.valueOf((long) ((Number) optAnyProperty).floatValue()) : optAnyProperty instanceof Double ? Long.valueOf((long) ((Number) optAnyProperty).doubleValue()) : (Long) optAnyProperty;
    }

    public final <T> MapModel<T> getOptMapModelProperty(String name, a aVar) {
        k.e(name, "name");
        return (MapModel) getOptAnyProperty(name, aVar);
    }

    public final String getOptStringProperty(String name, a aVar) {
        k.e(name, "name");
        return (String) getOptAnyProperty(name, aVar);
    }

    public final String getStringProperty(String name, a aVar) {
        k.e(name, "name");
        String optStringProperty = getOptStringProperty(name, aVar);
        k.c(optStringProperty, "null cannot be cast to non-null type kotlin.String");
        return optStringProperty;
    }

    public final boolean hasProperty(String name) {
        k.e(name, "name");
        return this.data.containsKey(name);
    }

    public final void initializeFromJson(JSONObject jsonObject) {
        Method method;
        k.e(jsonObject, "jsonObject");
        synchronized (this.data) {
            try {
                this.data.clear();
                Iterator<String> itKeys = jsonObject.keys();
                k.d(itKeys, "jsonObject.keys()");
                while (itKeys.hasNext()) {
                    String property = itKeys.next();
                    Object obj = jsonObject.get(property);
                    if (obj instanceof JSONObject) {
                        k.d(property, "property");
                        Model modelCreateModelForProperty = createModelForProperty(property, (JSONObject) obj);
                        if (modelCreateModelForProperty != null) {
                            this.data.put(property, modelCreateModelForProperty);
                        }
                    } else if (obj instanceof JSONArray) {
                        k.d(property, "property");
                        List<?> listCreateListForProperty = createListForProperty(property, (JSONArray) obj);
                        if (listCreateListForProperty != null) {
                            this.data.put(property, listCreateListForProperty);
                        }
                    } else {
                        Method[] methods = getClass().getMethods();
                        k.d(methods, "this.javaClass.methods");
                        int length = methods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                method = null;
                                break;
                            }
                            method = methods[i2];
                            if (!k.a(method.getReturnType(), Void.class)) {
                                if (t.g0(method.getName(), "get" + property)) {
                                    break;
                                }
                            }
                            i2++;
                        }
                        Class<?> returnType = method != null ? method.getReturnType() : null;
                        boolean zA = true;
                        if (k.a(returnType, Double.TYPE) ? true : k.a(returnType, Double.class)) {
                            Map<String, Object> map = this.data;
                            k.d(property, "property");
                            map.put(property, Double.valueOf(jsonObject.getDouble(property)));
                        } else {
                            if (k.a(returnType, Long.TYPE) ? true : k.a(returnType, Long.class)) {
                                Map<String, Object> map2 = this.data;
                                k.d(property, "property");
                                map2.put(property, Long.valueOf(jsonObject.getLong(property)));
                            } else {
                                if (k.a(returnType, Float.TYPE) ? true : k.a(returnType, Float.class)) {
                                    Map<String, Object> map3 = this.data;
                                    k.d(property, "property");
                                    map3.put(property, Float.valueOf((float) jsonObject.getDouble(property)));
                                } else {
                                    if (k.a(returnType, Integer.TYPE) ? true : k.a(returnType, Integer.class)) {
                                        Map<String, Object> map4 = this.data;
                                        k.d(property, "property");
                                        map4.put(property, Integer.valueOf(jsonObject.getInt(property)));
                                    } else {
                                        if (k.a(returnType, Boolean.TYPE) ? true : k.a(returnType, Boolean.class)) {
                                            Map<String, Object> map5 = this.data;
                                            k.d(property, "property");
                                            map5.put(property, Boolean.valueOf(jsonObject.getBoolean(property)));
                                        } else {
                                            if (!k.a(returnType, String.class)) {
                                                zA = k.a(returnType, String.class);
                                            }
                                            if (zA) {
                                                Map<String, Object> map6 = this.data;
                                                k.d(property, "property");
                                                map6.put(property, jsonObject.getString(property));
                                            } else {
                                                Map<String, Object> map7 = this.data;
                                                k.d(property, "property");
                                                map7.put(property, jsonObject.get(property));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void initializeFromModel(String str, Model model) {
        k.e(model, "model");
        Map<? extends String, ? extends Object> newData = Collections.synchronizedMap(new LinkedHashMap());
        for (Map.Entry<String, Object> entry : model.data.entrySet()) {
            if (entry.getValue() instanceof Model) {
                Object value = entry.getValue();
                k.c(value, "null cannot be cast to non-null type com.onesignal.common.modeling.Model");
                Model model2 = (Model) value;
                model2._parentModel = this;
                k.d(newData, "newData");
                newData.put(entry.getKey(), model2);
            } else {
                k.d(newData, "newData");
                newData.put(entry.getKey(), entry.getValue());
            }
        }
        if (str != null) {
            k.d(newData, "newData");
            newData.put("id", str);
        }
        synchronized (this.data) {
            this.data.clear();
            Map<String, Object> map = this.data;
            k.d(newData, "newData");
            map.putAll(newData);
        }
    }

    public final void setAnyProperty(String name, Object value, String tag, boolean z2) {
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        setOptAnyProperty(name, value, tag, z2);
    }

    public final void setBigDecimalProperty(String name, BigDecimal value, String tag, boolean z2) {
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        setOptBigDecimalProperty(name, value, tag, z2);
    }

    public final void setBooleanProperty(String name, boolean z2, String tag, boolean z7) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptBooleanProperty(name, Boolean.valueOf(z2), tag, z7);
    }

    public final void setDoubleProperty(String name, double d8, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptDoubleProperty(name, Double.valueOf(d8), tag, z2);
    }

    public final /* synthetic */ <T extends Enum<T>> void setEnumProperty(String name, T value, String tag, boolean z2) {
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        setOptAnyProperty(name, value.toString(), tag, z2);
    }

    public final void setFloatProperty(String name, float f4, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptFloatProperty(name, Float.valueOf(f4), tag, z2);
    }

    public final void setId(String value) {
        k.e(value, "value");
        setStringProperty$default(this, "id", value, null, false, 12, null);
    }

    public final void setIntProperty(String name, int i2, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptIntProperty(name, Integer.valueOf(i2), tag, z2);
    }

    public final <T> void setListProperty(String name, List<? extends T> value, String tag, boolean z2) {
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        setOptListProperty(name, value, tag, z2);
    }

    public final void setLongProperty(String name, long j, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptLongProperty(name, Long.valueOf(j), tag, z2);
    }

    public final <T> void setMapModelProperty(String name, MapModel<T> value, String tag, boolean z2) {
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        setOptMapModelProperty(name, value, tag, z2);
    }

    public final void setOptAnyProperty(String name, Object obj, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        Object obj2 = this.data.get(name);
        synchronized (this.data) {
            try {
                if (!k.a(obj2, obj) || z2) {
                    if (obj != null) {
                        this.data.put(name, obj);
                    } else if (this.data.containsKey(name)) {
                        this.data.remove(name);
                    }
                    notifyChanged(name, name, tag, obj2, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setOptBigDecimalProperty(String name, BigDecimal bigDecimal, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, bigDecimal != null ? bigDecimal.toString() : null, tag, z2);
    }

    public final void setOptBooleanProperty(String name, Boolean bool, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, bool, tag, z2);
    }

    public final void setOptDoubleProperty(String name, Double d8, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, d8, tag, z2);
    }

    public final /* synthetic */ <T extends Enum<T>> void setOptEnumProperty(String name, T t3, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, t3 != null ? t3.toString() : null, tag, z2);
    }

    public final void setOptFloatProperty(String name, Float f4, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, f4, tag, z2);
    }

    public final void setOptIntProperty(String name, Integer num, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, num, tag, z2);
    }

    public final <T> void setOptListProperty(String name, List<? extends T> list, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, list, tag, z2);
    }

    public final void setOptLongProperty(String name, Long l, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, l, tag, z2);
    }

    public final <T> void setOptMapModelProperty(String name, MapModel<T> mapModel, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, mapModel, tag, z2);
    }

    public final void setOptStringProperty(String name, String str, String tag, boolean z2) {
        k.e(name, "name");
        k.e(tag, "tag");
        setOptAnyProperty(name, str, tag, z2);
    }

    public final void setStringProperty(String name, String value, String tag, boolean z2) {
        k.e(name, "name");
        k.e(value, "value");
        k.e(tag, "tag");
        setOptStringProperty(name, value, tag, z2);
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        synchronized (this.data) {
            try {
                for (Map.Entry<String, Object> entry : this.data.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Model) {
                        jSONObject.put(entry.getKey(), ((Model) value).toJSON());
                    } else if (value instanceof List) {
                        JSONArray jSONArray = new JSONArray();
                        for (Object obj : (List) value) {
                            if (obj instanceof Model) {
                                jSONArray.put(((Model) obj).toJSON());
                            } else {
                                jSONArray.put(obj);
                            }
                        }
                        jSONObject.put(entry.getKey(), jSONArray);
                    } else {
                        jSONObject.put(entry.getKey(), value);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    public Model(Model model, String str) throws Exception {
        this._parentModel = model;
        this._parentProperty = str;
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        k.d(mapSynchronizedMap, "synchronizedMap(mutableMapOf())");
        this.data = mapSynchronizedMap;
        this.changeNotifier = new EventProducer<>();
        Model model2 = this._parentModel;
        if (model2 != null && str == null) {
            throw new Exception("If parent model is set, parent property must also be set.");
        }
        if (model2 == null && str != null) {
            throw new Exception("If parent property is set, parent model must also be set.");
        }
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(IModelChangedHandler handler) {
        k.e(handler, "handler");
        this.changeNotifier.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(IModelChangedHandler handler) {
        k.e(handler, "handler");
        this.changeNotifier.unsubscribe(handler);
    }

    public /* synthetic */ Model(Model model, String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : model, (i2 & 2) != 0 ? null : str);
    }
}
