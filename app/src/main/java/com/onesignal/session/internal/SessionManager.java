package com.onesignal.session.internal;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import e6.l;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SessionManager implements ISessionManager {
    private final IOutcomeEventsController _outcomeController;

    /* JADX INFO: renamed from: com.onesignal.session.internal.SessionManager$addOutcome$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.SessionManager$addOutcome$1", f = "SessionManager.kt", l = {16}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ String $name;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$name = str;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return SessionManager.this.new AnonymousClass1(this.$name, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOutcomeEventsController iOutcomeEventsController = SessionManager.this._outcomeController;
                String str = this.$name;
                this.label = 1;
                if (iOutcomeEventsController.sendOutcomeEvent(str, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.SessionManager$addOutcomeWithValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.SessionManager$addOutcomeWithValue$1", f = "SessionManager.kt", l = {35}, m = "invokeSuspend")
    public static final class C28191 extends i implements l {
        final /* synthetic */ String $name;
        final /* synthetic */ float $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28191(String str, float f4, c<? super C28191> cVar) {
            super(1, cVar);
            this.$name = str;
            this.$value = f4;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return SessionManager.this.new C28191(this.$name, this.$value, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOutcomeEventsController iOutcomeEventsController = SessionManager.this._outcomeController;
                String str = this.$name;
                float f4 = this.$value;
                this.label = 1;
                if (iOutcomeEventsController.sendOutcomeEventWithValue(str, f4, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((C28191) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.SessionManager$addUniqueOutcome$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.SessionManager$addUniqueOutcome$1", f = "SessionManager.kt", l = {24}, m = "invokeSuspend")
    public static final class C28201 extends i implements l {
        final /* synthetic */ String $name;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28201(String str, c<? super C28201> cVar) {
            super(1, cVar);
            this.$name = str;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return SessionManager.this.new C28201(this.$name, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOutcomeEventsController iOutcomeEventsController = SessionManager.this._outcomeController;
                String str = this.$name;
                this.label = 1;
                if (iOutcomeEventsController.sendUniqueOutcomeEvent(str, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((C28201) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public SessionManager(IOutcomeEventsController _outcomeController) {
        k.e(_outcomeController, "_outcomeController");
        this._outcomeController = _outcomeController;
    }

    @Override // com.onesignal.session.ISessionManager
    public void addOutcome(String name) {
        k.e(name, "name");
        Logging.log(LogLevel.DEBUG, "sendOutcome(name: " + name + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(name, null), 1, null);
    }

    @Override // com.onesignal.session.ISessionManager
    public void addOutcomeWithValue(String name, float f4) {
        k.e(name, "name");
        Logging.log(LogLevel.DEBUG, "sendOutcomeWithValue(name: " + name + ", value: " + f4 + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new C28191(name, f4, null), 1, null);
    }

    @Override // com.onesignal.session.ISessionManager
    public void addUniqueOutcome(String name) {
        k.e(name, "name");
        Logging.log(LogLevel.DEBUG, "sendUniqueOutcome(name: " + name + ')');
        ThreadUtilsKt.suspendifyOnThread$default(0, new C28201(name, null), 1, null);
    }
}
