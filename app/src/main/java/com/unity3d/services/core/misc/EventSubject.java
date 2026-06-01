package com.unity3d.services.core.misc;

import com.unity3d.services.core.timer.IIntervalTimer;
import com.unity3d.services.core.timer.IIntervalTimerFactory;
import com.unity3d.services.core.timer.IIntervalTimerListener;
import java.util.Queue;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class EventSubject<T> {
    private IEventListener<T> _eventListener;
    Queue<T> _eventQueue;
    IIntervalTimer _intervalTimer;

    public EventSubject(Queue<T> queue, Integer num, IIntervalTimerFactory iIntervalTimerFactory) {
        this._eventQueue = queue;
        this._intervalTimer = iIntervalTimerFactory.createTimer(num, Integer.valueOf(queue.size()), new IIntervalTimerListener() { // from class: com.unity3d.services.core.misc.EventSubject.1
            @Override // com.unity3d.services.core.timer.IIntervalTimerListener
            public void onNextIntervalTriggered() {
                EventSubject.this.sendNextEvent();
            }
        });
    }

    private void killTimer() {
        IIntervalTimer iIntervalTimer = this._intervalTimer;
        if (iIntervalTimer != null) {
            iIntervalTimer.kill();
            this._intervalTimer = null;
        }
    }

    private void startTimer() {
        IIntervalTimer iIntervalTimer = this._intervalTimer;
        if (iIntervalTimer != null) {
            iIntervalTimer.start(Executors.newSingleThreadScheduledExecutor());
        }
    }

    public boolean eventQueueIsEmpty() {
        return this._eventQueue.isEmpty();
    }

    public void sendNextEvent() {
        IEventListener<T> iEventListener = this._eventListener;
        if (iEventListener != null) {
            iEventListener.onNextEvent(this._eventQueue.remove());
        }
        if (this._eventQueue.size() <= 0) {
            unsubscribe();
        }
    }

    public void subscribe(IEventListener<T> iEventListener) {
        Queue<T> queue = this._eventQueue;
        if (queue == null || queue.size() <= 0 || this._intervalTimer == null || iEventListener == null) {
            return;
        }
        this._eventListener = iEventListener;
        startTimer();
    }

    public void unsubscribe() {
        killTimer();
        this._eventListener = null;
    }
}
